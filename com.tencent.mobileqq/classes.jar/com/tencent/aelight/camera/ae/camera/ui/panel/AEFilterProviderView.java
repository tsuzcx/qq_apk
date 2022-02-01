package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AEFilterProviderView
  extends ProviderView
  implements AEFilterProviderAdapter.OnItemClickListener, CaptureComboManager.CaptureComboListener
{
  public int a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEFilterProviderAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter;
  private AEProviderContainerView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView;
  public VideoFilterTools.DataSet a;
  private CaptureComboManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
  public ArrayList<FilterCategory> a;
  public int b = 0;
  
  public AEFilterProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static void a(String paramString)
  {
    AECameraPrefsUtil.a().a("ae_filter_id", paramString, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFilterPref(ae_filter_id, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(AEFilterProviderView.class.getSimpleName());
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      if (VideoFilterTools.a().a[this.g] != null) {
        VideoFilterTools.a().a[this.g].c = 1;
      }
      paramBundle = (QIMFilterCategoryItem)paramBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("restore ");
          localStringBuilder.append(paramBundle.a);
          QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
        }
        paramBundle.c = 1;
      }
    }
  }
  
  protected int a()
  {
    return 2131560878;
  }
  
  public void a()
  {
    super.a();
    CaptureComboManager localCaptureComboManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
    if (localCaptureComboManager != null)
    {
      localCaptureComboManager.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[this.g].a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("category= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" categoryName= ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",itemId=");
      localStringBuilder.append(paramString2);
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
    FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.b);
    StringBuilder localStringBuilder = null;
    int j = 0;
    paramInt = 0;
    int i;
    for (;;)
    {
      i = j;
      paramString1 = localStringBuilder;
      if (paramInt >= localFilterCategory.a.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.a.get(paramInt);
      if (paramString1.a.equals(paramString2))
      {
        i = paramInt;
        break;
      }
      paramInt += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("itemInfo= ");
      paramString2.append(paramString1);
      paramString2.append(",index=");
      paramString2.append(this.b);
      paramString2.append(",pos=");
      paramString2.append(i);
      QLog.d("AEFilterProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new AEFilterProviderView.1(this, i), 200L);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager != null)
      {
        paramString2 = new Bundle();
        paramString2.putInt("apply_source", 1);
        paramString2.putInt("capture_scene", this.g);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager.a(paramString1, (Activity)getContext(), paramString2);
      }
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView.b()) {
        a(paramString1.a);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView = ((AEProviderContainerView)((Activity)getContext()).findViewById(2064121976));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2064318490, this, true);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122192));
    paramBundle = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter = new AEFilterProviderAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.a(this);
    if (QIMManager.a().a(5))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager = ((CaptureComboManager)QIMManager.a(5));
      paramBundle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
      if (paramBundle != null) {
        paramBundle.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
      }
    }
    else {
      a(paramBundle.a(this.g));
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramView != null) {
      localObject1 = paramView.getTag();
    } else {
      localObject1 = null;
    }
    paramView = (View)localObject2;
    if (localObject1 != null) {
      paramView = (QIMFilterCategoryItem)localObject1;
    }
    if (paramView == null) {
      return;
    }
    if (paramView != null)
    {
      localObject2 = new HashMap();
      localObject1 = "none";
      if (paramInt == 0)
      {
        AEBaseReportParam.a().o("none");
        ((HashMap)localObject2).put("ext15", "none");
      }
      else
      {
        AEBaseReportParam.a().o(paramView.a);
        ((HashMap)localObject2).put("ext15", paramView.a);
      }
      AEReportUtils.b(11, (HashMap)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report filter click(");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", ");
        if (paramInt != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(paramView.a);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(")");
        QLog.d("AEFilterProviderView", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a(-1, paramView);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager != null)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("apply_source", 1);
      ((Bundle)localObject1).putInt("capture_scene", this.g);
      if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
        ((Bundle)localObject1).putBoolean("capture_force_enable", true);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager.a(paramView, (Activity)getContext(), (Bundle)localObject1);
    }
    if (!this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView.b()) {
      a(paramView.a);
    }
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
    if (paramView != null) {
      paramView.a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComboFilterDataUpdated data:");
      boolean bool;
      if (paramComboFilterData == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
    if (paramComboFilterData != null) {
      a(paramComboFilterData.a(this.g));
    }
  }
  
  public void a(VideoFilterTools.DataSet paramDataSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_b_of_type_JavaUtilArrayList;
    paramDataSet = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramDataSet != null)
    {
      int i = paramDataSet.size();
      int j = this.b;
      if (i > j) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("fp onComboApply combo ");
      paramBundle.append(paramComboSet.a);
      paramBundle.append(" filter ");
      QLog.i("QCombo", 2, paramBundle.toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
    if (paramBoolean)
    {
      paramFilterSet = (QimMusicPlayer)QIMManager.a().c(8);
      if (this.g == 0) {
        paramInt = QQFilterRenderManagerHolder.b;
      } else {
        paramInt = QQFilterRenderManagerHolder.c;
      }
      paramFilterSet.c(paramInt);
      paramFilterSet.f();
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet == null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
      if (localObject != null)
      {
        localObject = ((CaptureComboManager)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet = ((VideoFilterTools.ComboFilterData)localObject).a(this.g);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet;
    if ((localObject != null) && (((VideoFilterTools.DataSet)localObject).jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem != null))
    {
      localObject = (Activity)getContext();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
      VideoFilterTools.a().b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
      VideoFilterTools.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, this.g);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
      a(null, 0);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.b();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    CaptureComboManager localCaptureComboManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  public void f()
  {
    super.f();
    CaptureComboManager localCaptureComboManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboManager;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */