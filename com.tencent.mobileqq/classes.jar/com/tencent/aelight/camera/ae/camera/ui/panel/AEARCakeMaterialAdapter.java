package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEARCakeMaterialAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements AEMaterialDownloader.MaterialDownloadListener, Observer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AEARCakeMaterialManager jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager;
  AEARCakePanel.AEARCakePanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  public ArrayList<AEGiftMaterial> a;
  
  AEARCakeMaterialAdapter(Context paramContext, AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = paramAEARCakePanelListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager = AEARCakeMaterialManager.a();
  }
  
  private int a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      String str = ((AEGiftMaterial)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a().C;
      if ((str != null) && (str.equals(paramAEMaterialMetaData.C))) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : onClick postion");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject).toString());
    if (paramInt == -1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener == null)
    {
      AEQLog.d("AEARCakeMaterialAdapter", "MaterialPanelListener is null");
      return;
    }
    localObject = (AEGiftMaterial)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localObject == null)
    {
      AEQLog.d("AEARCakeMaterialAdapter", "giftMaterial is null");
      return;
    }
    AEARCakeMaterial localAEARCakeMaterial = ((AEGiftMaterial)localObject).a();
    if (localAEARCakeMaterial == null) {
      return;
    }
    if (!a(localAEARCakeMaterial.k))
    {
      AEQLog.a("AEARCakeMaterialAdapter", "arcake downing can not click");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake :onclick :");
    localStringBuilder.append(localAEARCakeMaterial.toString());
    localStringBuilder.append("downloading : ");
    localStringBuilder.append(localAEARCakeMaterial.f);
    localStringBuilder.append(" usable ");
    localStringBuilder.append(localAEARCakeMaterial.e);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    if ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) && (!localAEARCakeMaterial.e))
    {
      AEQLog.d("AEARCakeMaterialAdapter", "net work not available");
      ToastUtil.a().a(HardCodeUtil.a(2131716132));
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager.a((AEGiftMaterial)localObject, paramInt);
    if (localAEARCakeMaterial.e)
    {
      if (!AEResUtil.a())
      {
        QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709780), 0).a();
        ThreadManager.excute(new AEARCakeMaterialAdapter.2(this), 64, null, true);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener.a(localAEARCakeMaterial);
    }
    else
    {
      a(localAEARCakeMaterial);
    }
    notifyDataSetChanged();
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
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
    b(paramAEMaterialMetaData);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (AEGiftMaterial)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((AEGiftMaterial)localObject2).a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("arcake same downloading :");
        localStringBuilder.append(((AEARCakeMaterial)localObject2).C);
        localStringBuilder.append(" downloading ");
        localStringBuilder.append(((AEARCakeMaterial)localObject2).f);
        AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
        if ((paramString.equals(((AEARCakeMaterial)localObject2).k)) && (((AEARCakeMaterial)localObject2).f))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("arcake same downloading :");
          ((StringBuilder)localObject1).append(paramString);
          AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject1).toString());
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    notifyDataSetChanged();
    a(paramInt);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : doRealDownload");
    ((StringBuilder)localObject).append(paramAEMaterialMetaData.C);
    AEQLog.b("AEARCakeMaterialAdapter", ((StringBuilder)localObject).toString());
    if (AEMaterialManager.a(paramAEMaterialMetaData))
    {
      paramAEMaterialMetaData.e = AEMaterialManager.a(paramAEMaterialMetaData);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arcake : already download ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.C);
      AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject).toString());
      onDownloadFinish(paramAEMaterialMetaData, true, 200);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
    ((AEMaterialManager)localObject).a(((AEMaterialManager)localObject).getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a(List<AEGiftMaterial> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : updateMaterialList");
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEARCakeMaterialAdapter.5(this, paramInt), 200L);
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEGiftMaterial localAEGiftMaterial = (AEGiftMaterial)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localAEGiftMaterial != null)
    {
      if (paramViewHolder == null) {
        return;
      }
      AEARCakeMaterial localAEARCakeMaterial = localAEGiftMaterial.a();
      if (localAEARCakeMaterial == null) {
        return;
      }
      paramViewHolder = (AEARCakeMaterialHolder)paramViewHolder;
      paramViewHolder.a(localAEARCakeMaterial);
      int i;
      if (localAEARCakeMaterial.e) {
        i = 8;
      } else {
        i = 0;
      }
      paramViewHolder.d(i);
      paramViewHolder.a(localAEGiftMaterial.a());
      paramViewHolder.b(localAEGiftMaterial.b());
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager.a() == paramInt) {
        paramViewHolder.c(0);
      } else {
        paramViewHolder.c(8);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        paramViewHolder.d(8);
      }
      paramViewHolder.itemView.setOnClickListener(new AEARCakeMaterialAdapter.1(this, paramViewHolder));
      paramViewHolder.a(localAEARCakeMaterial);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318464, paramViewGroup, false);
    return new AEARCakeMaterialHolder(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
  }
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : onDownloadFinish ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("cake id ");
    localStringBuilder.append(paramAEMaterialMetaData.C);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramInt = a(paramAEMaterialMetaData);
    if (paramInt <= 0) {
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : onDownloadFinish position");
    localStringBuilder.append(paramInt);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEARCakeMaterialAdapter.3(this, paramInt, paramAEMaterialMetaData, paramBoolean));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = a(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEARCakeMaterialAdapter.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */