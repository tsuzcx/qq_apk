package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AEMaterialAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, AEMaterialDownloader.MaterialDownloadListener, Observer
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AEGridView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEGridView;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  public AEMaterialMetaData a;
  public String a;
  public ArrayList<AEMaterialMetaData> a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AEMaterialAdapter(Context paramContext, AEGridView paramAEGridView, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
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
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramAEMaterialMetaData == null)
    {
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramAEMaterialMetaData.k;
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this.jdField_a_of_type_JavaLangString);
    AEBaseReportParam.a().b(paramAEMaterialMetaData.D);
    AEBaseReportParam.a().a(paramAEMaterialMetaData.k);
    AEBaseReportParam.a().d(-1);
    AEBaseReportParam.a().n("none");
    AEBaseReportParam.a().m("1");
    AEBaseReportParam.a().e(0);
    Object localObject;
    if (paramAEMaterialMetaData != null)
    {
      AEBaseDataReporter.a().c(paramAEMaterialMetaData.k);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【Select Material】：");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.k);
      AEQLog.b("AEMaterialAdapter", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【Select Material】Usable :");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.e);
      AEQLog.b("AEMaterialAdapter", ((StringBuilder)localObject).toString());
    }
    else
    {
      AEBaseDataReporter.a().c("null");
      AEQLog.b("AEMaterialAdapter", "【Select Material】：null");
    }
    if ((paramAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramAEMaterialMetaData.k)) && (!AEMaterialMetaData.a(paramAEMaterialMetaData)))
    {
      if (paramAEMaterialMetaData.a())
      {
        WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAEMaterialMetaData, 1);
        return;
      }
      if (paramAEMaterialMetaData.e)
      {
        if (!AEResUtil.a())
        {
          QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709780), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialMetaData, this.jdField_a_of_type_Boolean ^ true);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
        if (localObject != null) {
          ((AEMaterialPanel.AEMaterialPanelListener)localObject).a(paramAEMaterialMetaData);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] select material ");
        ((StringBuilder)localObject).append(paramAEMaterialMetaData.k);
        QLog.d("AEMaterialAdapter", 4, ((StringBuilder)localObject).toString());
      }
      else
      {
        c(paramAEMaterialMetaData);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext;
        if (((localObject instanceof Activity)) && (AECameraEntryManager.k(((Activity)localObject).getIntent())))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(paramAEMaterialMetaData);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialMetaData);
      }
      return;
    }
    paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
    if (paramAEMaterialMetaData != null) {
      paramAEMaterialMetaData.a();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData, this.jdField_a_of_type_Boolean ^ true);
    QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
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
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
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
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
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
    d(paramAEMaterialMetaData);
  }
  
  private void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialManager localAEMaterialManager = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    a(paramAEMaterialMetaData, a(paramAEMaterialMetaData));
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
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
    if (paramInt == 113)
    {
      if (AEMaterialManager.a() != null) {
        notifyDataSetChanged();
      }
    }
    else
    {
      if (paramInt == 1024)
      {
        QLog.d("AEMaterialAdapter", 4, "current watermark has change");
        notifyDataSetChanged();
        return;
      }
      if (paramInt == 111)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && (this.jdField_a_of_type_Boolean))
        {
          a(((AEMaterialCategory)paramVarArgs[0]).a);
          notifyDataSetChanged();
        }
      }
      else if (paramInt == 114)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
          a(true, paramVarArgs[0]);
        }
      }
      else if ((paramInt == 115) && (paramVarArgs != null) && (paramVarArgs.length == 1)) {
        a(false, paramVarArgs[0]);
      }
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localAEMaterialMetaData == null) {
      return;
    }
    AEBaseDataReporter.a().g(localAEMaterialMetaData.k);
    if ((paramViewHolder instanceof MaterialNoneViewHolder))
    {
      paramViewHolder = (MaterialNoneViewHolder)paramViewHolder;
      if ((AEMaterialManager.a() != null) && (!localAEMaterialMetaData.equals(AEMaterialManager.a())))
      {
        paramViewHolder.b();
        return;
      }
      paramViewHolder.a();
      return;
    }
    if ((paramViewHolder instanceof MaterialViewHolder))
    {
      paramViewHolder = (MaterialViewHolder)paramViewHolder;
      if ((localAEMaterialMetaData.equals(AEMaterialManager.a())) && (localAEMaterialMetaData.e))
      {
        paramViewHolder.a(2, localAEMaterialMetaData);
        return;
      }
      localAEMaterialMetaData.jdField_a_of_type_Boolean = false;
      paramViewHolder.a(1, localAEMaterialMetaData);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    paramView = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    b(paramView);
    if (paramView.b) {
      paramView.c = true;
    } else {
      paramView.b = true;
    }
    a(paramView, i);
    if (AECameraEntryManager.k(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext2", paramView.k);
      AEReportUtils.b(5, localHashMap);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318506, paramViewGroup, false);
      localObject = new MaterialNoneViewHolder(paramViewGroup);
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318505, paramViewGroup, false);
      localObject = new MaterialViewHolder(paramViewGroup);
      ((MaterialViewHolder)localObject).a(this.jdField_a_of_type_AndroidContentContext);
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
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = a(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */