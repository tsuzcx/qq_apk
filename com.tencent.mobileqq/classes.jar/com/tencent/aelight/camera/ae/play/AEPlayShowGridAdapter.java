package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AEPlayShowGridAdapter
  extends RecyclerView.Adapter<AEPlayShowGridViewHolder>
  implements AEPlayShowGridViewHolder.ItemClickCallback
{
  private static final String TAG = "AEPlayShowGridAdapter";
  public static AEMaterialMetaData selectedMaterial;
  public static AEMaterialMetaData selectedMidMaterial;
  private String curTabId = "";
  private AECaptureController mAECaptureController;
  private Map<String, AEPlayShowGridViewHolder> mCachedViewHolder;
  private AEVideoStoryCaptureModeViewModel mCaptureModeViewModel;
  private Context mContext;
  private int mLayoutType;
  private List<AEMaterialMetaData> mMaterialList;
  private AEMaterialManager mMidMaterialManager;
  private VideoStoryCapturePartManager mPartManager;
  private AEPlayShowGridAdapter.SizeInfo mSizeInfo;
  private AEPituCameraUnit mUnit;
  
  public AEPlayShowGridAdapter(@NonNull Context paramContext, @NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, @NonNull AEPlayShowGridAdapter.SizeInfo paramSizeInfo, int paramInt)
  {
    this.mContext = paramContext;
    this.mPartManager = paramVideoStoryCapturePartManager;
    this.mUnit = ((AEPituCameraUnit)this.mPartManager.a(65537, new Object[0]));
    this.mAECaptureController = this.mUnit.am();
    this.mSizeInfo = paramSizeInfo;
    this.mLayoutType = paramInt;
    this.mMidMaterialManager = ((AEMaterialManager)AEQIMManager.a().b(1));
    this.mCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.mUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.mCachedViewHolder = new HashMap();
  }
  
  private void addProgressObserver(String paramString, IProgressObserver paramIProgressObserver)
  {
    try
    {
      Iterator localIterator = PlayDownloadManagerWrap.getInstance().getDownloadingMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          PlayDownloadManagerWrap.getInstance().addProgressObserver(paramString, paramIProgressObserver);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void applyTemplate(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.P == 0)
    {
      selectedMidMaterial = paramAEMaterialMetaData;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(QIMPtvTemplateManager.b);
      localStringBuilder.append(paramAEMaterialMetaData.t);
      localStringBuilder.toString();
      this.mAECaptureController.a(paramAEMaterialMetaData);
      this.mPartManager.b(393218, new Object[] { paramAEMaterialMetaData });
      return;
    }
    if ((paramAEMaterialMetaData.P == 4) || (paramAEMaterialMetaData.P == 5) || (paramAEMaterialMetaData.P == 6) || (paramAEMaterialMetaData.P == 7))
    {
      selectedMidMaterial = null;
      this.mPartManager.b(655361, new Object[] { paramAEMaterialMetaData });
    }
  }
  
  private void downloadTemplate(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!paramAEMaterialMetaData.B)
    {
      if (TextUtils.isEmpty(paramAEMaterialMetaData.m)) {
        return;
      }
      downloadTemplateDirectly(paramAEMaterialMetaData);
    }
  }
  
  private void downloadTemplateDirectly(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEPlayShowGridViewHolder localAEPlayShowGridViewHolder = (AEPlayShowGridViewHolder)this.mCachedViewHolder.get(paramAEMaterialMetaData.m);
    if (localAEPlayShowGridViewHolder != null) {
      localAEPlayShowGridViewHolder.onDownloadStart();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【Play Item】onDownloadStart :");
    localStringBuilder.append(paramAEMaterialMetaData.m);
    AEQLog.b("AEPlayShowGridAdapter", localStringBuilder.toString());
    PlayDownloadManagerWrap.getInstance().addProgressObserver(paramAEMaterialMetaData.m, localAEPlayShowGridViewHolder);
    PlayDownloadManagerWrap.getInstance().startDownload(this.mPartManager, this.mMidMaterialManager, paramAEMaterialMetaData);
  }
  
  public static void onSelectedMidMaterialConsumed()
  {
    selectedMidMaterial = null;
  }
  
  private void removeProgressObserver(String paramString, AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    try
    {
      Iterator localIterator = PlayDownloadManagerWrap.getInstance().getDownloadingMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          PlayDownloadManagerWrap.getInstance().removeProgressObserver(paramString, paramAEPlayShowGridViewHolder);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void scanExistHolderToObserve(String paramString)
  {
    Map localMap = this.mCachedViewHolder;
    if (localMap == null) {
      return;
    }
    if (localMap.get(paramString) == null) {
      return;
    }
    paramString = (AEPlayShowGridViewHolder)this.mCachedViewHolder.get(paramString);
    if (paramString != null)
    {
      if (paramString.mPlayMaterial == null) {
        return;
      }
      if (paramString.mPlayMaterial.B) {
        addProgressObserver(paramString.mPlayMaterial.m, paramString);
      }
    }
  }
  
  public static boolean selectedMidMaterialNotConsumed()
  {
    return selectedMidMaterial != null;
  }
  
  private void toMiniApp(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.mPartManager.b(655363, new Object[] { paramAEMaterialMetaData });
  }
  
  private void toWebView(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.mPartManager.b(655362, new Object[] { paramAEMaterialMetaData });
  }
  
  public int getItemCount()
  {
    return this.mMaterialList.size();
  }
  
  public void initObservers()
  {
    Object localObject1 = this.mCachedViewHolder;
    if (localObject1 != null)
    {
      if (((Map)localObject1).size() < 1) {
        return;
      }
      localObject1 = this.mCachedViewHolder.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          if (localObject2 != null) {
            scanExistHolderToObserve((String)localObject2);
          }
        }
      }
    }
  }
  
  public void onBindViewHolder(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.mMaterialList.get(paramInt);
    paramAEPlayShowGridViewHolder.bind(localAEMaterialMetaData, paramInt);
    String str = this.curTabId;
    if ((str != null) && (str.equals(localAEMaterialMetaData.Q)))
    {
      AEBaseReportParam.a().g(paramAEPlayShowGridViewHolder.mPlayMaterial.P);
      AEBaseReportParam.a().f(paramInt + 1);
      AEBaseDataReporter.a().f(paramAEPlayShowGridViewHolder.mPlayMaterial.m);
    }
  }
  
  public AEPlayShowGridViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mLayoutType == 1) {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2064056385, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2064056386, paramViewGroup, false);
    }
    return new AEPlayShowGridViewHolder(paramViewGroup, this.mSizeInfo, this, this.mLayoutType);
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mCachedViewHolder.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      PlayDownloadManagerWrap.getInstance().removeProgressObserver((String)localEntry.getKey(), (IProgressObserver)localEntry.getValue());
    }
  }
  
  public void onItemClicked(View paramView, @NonNull AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    if (paramInt >= 0) {
      paramInt += 1;
    }
    Integer.toString(paramInt);
    AEBaseReportParam.a().f(paramInt);
    AEBaseReportParam.a().q("3");
    AEBaseReportParam.a().g(paramAEMaterialMetaData.P);
    selectedMaterial = paramAEMaterialMetaData;
    paramView = new StringBuilder();
    paramView.append("【Play Material OnClick】playShowType:");
    paramView.append(paramAEMaterialMetaData.P);
    AEQLog.b("AEPlayShowGridAdapter", paramView.toString());
    paramView = new StringBuilder();
    paramView.append("【Play Material OnClick】id:");
    paramView.append(paramAEMaterialMetaData.m);
    AEQLog.b("AEPlayShowGridAdapter", paramView.toString());
    if (AEMaterialMetaData.c(paramAEMaterialMetaData))
    {
      if (paramAEMaterialMetaData.A)
      {
        applyTemplate(paramAEMaterialMetaData);
      }
      else if (!NetworkUtil.isNetworkAvailable())
      {
        selectedMaterial = null;
        selectedMidMaterial = null;
        paramView = this.mContext;
        QQToast.makeText(paramView, paramView.getString(2131915328), 0).show();
      }
      else
      {
        downloadTemplate(paramAEMaterialMetaData);
      }
      AEBaseDataReporter.a().c(paramAEMaterialMetaData.m);
      return;
    }
    if (paramAEMaterialMetaData.P == 2)
    {
      toWebView(paramAEMaterialMetaData);
      AEBaseDataReporter.a().c(paramAEMaterialMetaData.m);
      return;
    }
    if (paramAEMaterialMetaData.P == 3)
    {
      toMiniApp(paramAEMaterialMetaData);
      AEBaseDataReporter.a().c(paramAEMaterialMetaData.m);
    }
  }
  
  public void onViewAttachedToWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewAttachedToWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.m)) && (AEMaterialMetaData.c(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.put(paramAEPlayShowGridViewHolder.mPlayMaterial.m, paramAEPlayShowGridViewHolder);
      paramAEPlayShowGridViewHolder.resetProgress();
      addProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.m, paramAEPlayShowGridViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewDetachedFromWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.m)) && (AEMaterialMetaData.c(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.remove(paramAEPlayShowGridViewHolder.mPlayMaterial.m);
      paramAEPlayShowGridViewHolder.resetProgress();
      removeProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.m, paramAEPlayShowGridViewHolder);
      scanExistHolderToObserve(paramAEPlayShowGridViewHolder.mPlayMaterial.m);
    }
  }
  
  public void putData(@NonNull List<AEMaterialMetaData> paramList)
  {
    this.mMaterialList = paramList;
    if (this.mMaterialList.size() == 0) {
      this.mCachedViewHolder.clear();
    }
    notifyDataSetChanged();
  }
  
  public void setCurTabId(String paramString)
  {
    this.curTabId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowGridAdapter
 * JD-Core Version:    0.7.0.1
 */