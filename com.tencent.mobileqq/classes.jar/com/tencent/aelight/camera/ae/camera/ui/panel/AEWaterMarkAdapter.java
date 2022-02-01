package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AEWaterMarkAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, AEMaterialDownloader.MaterialDownloadListener, Observer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AEWaterMarkPanel.AEWaterMarkPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  private AEMaterialMetaData jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList<AEMaterialMetaData> a;
  
  AEWaterMarkAdapter(Context paramContext, AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = paramAEWaterMarkPanelListener;
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 114);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 115);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 1025);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 113);
  }
  
  private int a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).k.equals(paramAEMaterialMetaData.k)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialMetaData localAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if ((localAEMaterialMetaData != null) && (!localAEMaterialMetaData.equals(paramAEMaterialMetaData)))
    {
      localAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
      localAEMaterialMetaData.b = false;
      localAEMaterialMetaData.c = false;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((paramObject.getId() != null) && (paramObject.getId().equals(((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).k)))
      {
        ((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
        notifyItemChanged(i, Integer.valueOf(1));
        return;
      }
      i += 1;
    }
  }
  
  private static void b(RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {
      return;
    }
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if (localLinearLayoutManager == null) {
      return;
    }
    paramRecyclerView = new AEWaterMarkAdapter.7(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.f) {
      return;
    }
    if (TextUtils.isEmpty(paramAEMaterialMetaData.k)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager == null) {
      return;
    }
    c(paramAEMaterialMetaData);
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialManager localAEMaterialManager = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      AEQLog.d("AEWaterMarkAdapter", "mTemplateList is null");
      notifyDataSetChanged();
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData1 = AEMaterialManager.b();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      AEMaterialMetaData localAEMaterialMetaData2 = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localAEMaterialMetaData1 != null)
      {
        k = j;
        if (localAEMaterialMetaData1.k.equals(localAEMaterialMetaData2.k)) {
          k = i;
        }
      }
      i += 1;
    }
    a(j);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectedIndex:");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEWaterMarkAdapter", ((StringBuilder)localObject).toString());
    notifyDataSetChanged();
    localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localObject != null) {
      ((RecyclerView)localObject).post(new AEWaterMarkAdapter.3(this, paramInt));
    }
  }
  
  public void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCircleCaptureStyle:");
    localStringBuilder.append(paramRatio);
    AEQLog.a("AEWaterMarkAdapter", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEWaterMarkAdapter.2(this), 200L);
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.8(this, paramInt, paramVarArgs));
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localObject == null) {
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.b();
    if ((paramViewHolder instanceof AEMaterialWaterMarkNoneViewHolder))
    {
      if (localAEMaterialMetaData == null)
      {
        localObject = (AEMaterialWaterMarkNoneViewHolder)paramViewHolder;
        ((AEMaterialWaterMarkNoneViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        ((AEMaterialWaterMarkNoneViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        localObject = (AEMaterialWaterMarkNoneViewHolder)paramViewHolder;
        ((AEMaterialWaterMarkNoneViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((AEMaterialWaterMarkNoneViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio != AEVideoStoryTopBarViewModel.Ratio.FULL)
      {
        ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056363));
        return;
      }
      paramViewHolder = (AEMaterialWaterMarkNoneViewHolder)paramViewHolder;
      paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167401));
      return;
    }
    if ((paramViewHolder instanceof AEMaterialWaterMarkViewHolder))
    {
      paramViewHolder = (AEMaterialWaterMarkViewHolder)paramViewHolder;
      paramViewHolder.a((AEMaterialMetaData)localObject);
      boolean bool;
      if (localAEMaterialMetaData == null)
      {
        if (paramInt == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = localAEMaterialMetaData.k.equals(((AEMaterialMetaData)localObject).k);
      }
      if (bool)
      {
        if (localAEMaterialMetaData != null) {
          ((AEMaterialMetaData)localObject).jdField_a_of_type_Boolean = localAEMaterialMetaData.jdField_a_of_type_Boolean;
        }
        if (((AEMaterialMetaData)localObject).jdField_a_of_type_Boolean)
        {
          paramViewHolder.e.setVisibility(8);
          paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramViewHolder.e.setVisibility(0);
        }
        paramViewHolder.a(8);
        paramViewHolder.b(8);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewHolder.e.setVisibility(8);
        paramViewHolder.b((AEMaterialMetaData)localObject);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio != AEVideoStoryTopBarViewModel.Ratio.FULL) {
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056363));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener == null)
    {
      AEQLog.d("AEWaterMarkAdapter", "water mark mlistener is null");
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((i != 0) && (localAEMaterialMetaData != null))
    {
      if ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) && (!localAEMaterialMetaData.e))
      {
        AEQLog.d("AEWaterMarkAdapter", "net work not available");
        ToastUtil.a().a(HardCodeUtil.a(2131716132));
        return;
      }
      a(localAEMaterialMetaData);
      AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
      if (localAEMaterialMetaData.k == null) {
        paramView = "none";
      } else {
        paramView = localAEMaterialMetaData.k;
      }
      localAEBaseDataReporter.n(paramView);
      if (localAEMaterialMetaData.b) {
        localAEMaterialMetaData.c = true;
      } else {
        localAEMaterialMetaData.b = true;
      }
      this.jdField_a_of_type_JavaLangString = localAEMaterialMetaData.k;
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this.jdField_a_of_type_JavaLangString);
      if (localAEMaterialMetaData.e)
      {
        if (!AEResUtil.a())
        {
          QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709780), 0).a();
          ThreadManager.excute(new AEWaterMarkAdapter.1(this), 64, null, true);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(localAEMaterialMetaData, true);
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener.a(localAEMaterialMetaData);
        a(i);
      }
      else
      {
        b(localAEMaterialMetaData);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener.a();
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(null, true);
      a(0);
      AEBaseDataReporter.a().ay();
    }
    if (AECameraEntryManager.k(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))
    {
      paramView = new HashMap();
      paramView.put("ext2", localAEMaterialMetaData.k);
      AEReportUtils.b(9, paramView);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318484, paramViewGroup, false);
      localObject = new AEMaterialWaterMarkNoneViewHolder(paramViewGroup);
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318483, paramViewGroup, false);
      localObject = new AEMaterialWaterMarkViewHolder(paramViewGroup, this.jdField_a_of_type_AndroidContentContext);
    }
    paramViewGroup.setOnClickListener(this);
    return localObject;
  }
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramInt = a(paramAEMaterialMetaData);
    if (paramInt <= 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.4(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.5(this));
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = a(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.6(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkAdapter
 * JD-Core Version:    0.7.0.1
 */