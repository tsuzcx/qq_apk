package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.List;

public class QIMFilterProviderView
  extends ProviderView
  implements CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener
{
  public int a;
  public VideoFilterTools.DataSet a;
  FilterProviderPagerAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  public ArrayList<FilterCategory> a;
  public int b = 0;
  
  public QIMFilterProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(QIMFilterProviderView.class.getSimpleName());
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
          localStringBuilder.append(paramBundle.jdField_a_of_type_JavaLangString);
          QLog.d("FilterProviderView", 2, localStringBuilder.toString());
        }
        paramBundle.c = 1;
      }
    }
  }
  
  protected int a()
  {
    return 2131560878;
  }
  
  public ArrayList<QIMSlidingTabView.TabIcon> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = VideoFilterTools.a().a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      VideoFilterTools.a();
      localTabIcon.jdField_a_of_type_Boolean = VideoFilterTools.a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int, "");
      localArrayList.add(localTabIcon);
      if ((j != -1) && (j == ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int))
      {
        this.b = i;
        VideoFilterTools.a().a(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    VideoFilterTools.a();
    VideoFilterTools.a(true);
    if (QIMManager.a().a(5))
    {
      localObject = (CaptureComboManager)QIMManager.a(5);
      localObject.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[this.g].a();
      ((CaptureComboManager)localObject).b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("category= ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" categoryName= ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",itemId=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("FilterProviderView", 2, ((StringBuilder)localObject).toString());
    }
    int k = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) || ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))) {
        break label157;
      }
      i += 1;
    }
    i = 0;
    label157:
    a().onTabChecked(i);
    FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
    Object localObject = null;
    paramInt = 0;
    int j;
    for (;;)
    {
      j = k;
      paramString1 = (String)localObject;
      if (paramInt >= localFilterCategory.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramString1.jdField_a_of_type_JavaLangString.equals(paramString2))
      {
        j = paramInt;
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
      paramString2.append(i);
      paramString2.append(",pos=");
      paramString2.append(j);
      QLog.d("FilterProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new QIMFilterProviderView.1(this, j), 200L);
      paramString2 = (CaptureComboManager)QIMManager.a(5);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("apply_source", 1);
      ((Bundle)localObject).putInt("capture_scene", this.g);
      paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
      g();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560878, this, false));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
    paramBundle = (CaptureComboManager)QIMManager.a(5);
    paramBundle.a(this);
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = paramBundle.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
      }
    }
    else {
      setup(paramBundle.a(this.g));
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
      QLog.d("FilterProviderView", 2, localStringBuilder.toString());
    }
    if (paramComboFilterData != null) {
      setup(paramComboFilterData.a(this.g));
    }
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
    g();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.b(true);
    }
    g();
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
  
  public int b()
  {
    BounceViewPager localBounceViewPager = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
    if (localBounceViewPager == null) {
      return 0;
    }
    return localBounceViewPager.getCurrentItem();
  }
  
  public void b()
  {
    super.b();
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet;
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      VideoFilterTools.ComboFilterData localComboFilterData = localCaptureComboManager.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
      localObject1 = localObject2;
      if (localComboFilterData != null) {
        localObject1 = localComboFilterData.a(this.g);
      }
    }
    if ((localObject1 != null) && (((VideoFilterTools.DataSet)localObject1).jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem != null))
    {
      localObject2 = (Activity)getContext();
      localCaptureComboManager.a(((VideoFilterTools.DataSet)localObject1).jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem).a((Activity)localObject2, this.g);
      VideoFilterTools.a().b(((VideoFilterTools.DataSet)localObject1).jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
      VideoFilterTools.a().a(((VideoFilterTools.DataSet)localObject1).jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, this.g);
      g();
      onItemClick(null, null, 0, 0L);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.b(true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.b();
    }
    g();
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
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  public void f()
  {
    super.f();
    ((CaptureComboManager)QIMManager.a(5)).b(this);
  }
  
  public void g()
  {
    if (!this.d) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "FilterProviderView updateSelectedState");
    }
    int i = 0;
    int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a.size();
    while (i < j)
    {
      int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a.keyAt(i);
      ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a.get(k)).getAdapter();
      if ((localListAdapter instanceof FilterProviderGridAdapter)) {
        ((FilterProviderGridAdapter)localListAdapter).notifyDataSetChanged();
      }
      i += 1;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView != null) {
      paramAdapterView = paramView.getTag();
    } else {
      paramAdapterView = null;
    }
    if ((paramAdapterView != null) && ((paramAdapterView instanceof QIMFilterCategoryItem)))
    {
      paramAdapterView = (QIMFilterCategoryItem)paramAdapterView;
    }
    else
    {
      paramAdapterView = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramAdapterView == null) {
        return;
      }
      paramView = (QIMFilterCategoryItem)((FilterCategory)paramAdapterView.get(b())).jdField_a_of_type_JavaUtilList.get(paramInt);
      paramAdapterView = paramView;
      if (paramView == null) {
        return;
      }
    }
    if (paramAdapterView.f())
    {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView, 2);
      return;
    }
    if ((paramLong > 0L) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a(-1, paramAdapterView);
    }
    paramView = (CaptureComboManager)QIMManager.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.g);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((CaptureComboManager)QIMManager.a(5)).a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onTabChecked(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
      VideoFilterTools.a().a(2, ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int, "");
    }
  }
  
  public void setup(VideoFilterTools.DataSet paramDataSet)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter = new FilterProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.b;
    if (i > j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(j);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(this.b);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterFilterProviderPagerAdapter.notifyDataSetChanged();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */