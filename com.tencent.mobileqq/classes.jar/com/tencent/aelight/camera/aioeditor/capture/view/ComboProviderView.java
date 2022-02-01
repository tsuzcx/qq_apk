package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderPagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboObeserver;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener
{
  public int a;
  public Handler a;
  public VideoFilterTools.DataSet a;
  ComboProviderPagerAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter;
  CaptureComboObeserver jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboObeserver = new ComboProviderView.1(this);
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  ArrayList<FilterCategory> jdField_a_of_type_JavaUtilArrayList;
  
  public ComboProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(ComboProviderView.class.getSimpleName());
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      paramBundle = (QIMFilterCategoryItem)paramBundle.getParcelable("select_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restore ");
          ((StringBuilder)localObject).append(paramBundle.jdField_a_of_type_JavaLangString);
          QLog.d("ComboProviderView", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (CaptureComboManager)QIMManager.a(5);
        if (((this.g == 2) || (this.g == 1)) && (VideoFilterTools.a().a[this.g] == null)) {
          VideoFilterTools.a().a[this.g] = ((CaptureComboManager)localObject).a(paramBundle);
        }
        paramBundle = ((CaptureComboManager)localObject).a;
        if (paramBundle != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet = paramBundle.a(this.g);
        }
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
    int j = VideoFilterTools.a().b();
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
        this.jdField_a_of_type_Int = i;
        VideoFilterTools.a().a(7, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboObeserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a(5)).b(this);
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("category= ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" categoryName= ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",itemId=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("ComboProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("selectCategoryAndItem when mTagInfos null ");
        paramString1.append(paramInt);
        paramString1.append(" ");
        paramString1.append(paramString2);
        QLog.e("ComboProviderView", 2, paramString1.toString());
      }
      return;
    }
    int k = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((paramInt != -1) && (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt)) || ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))) {
        break label215;
      }
      i += 1;
    }
    i = 0;
    label215:
    a().onTabChecked(i);
    Object localObject2 = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(b());
    Object localObject1 = null;
    paramInt = 0;
    int j;
    for (;;)
    {
      j = k;
      paramString1 = (String)localObject1;
      if (paramInt >= ((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList.get(paramInt);
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
      QLog.d("ComboProviderView", 2, paramString2.toString());
    }
    if (paramString1 == null) {
      return;
    }
    if (paramString1.f())
    {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString1, 2);
      return;
    }
    postDelayed(new ComboProviderView.2(this, j), 500L);
    paramString2 = (CaptureComboManager)QIMManager.a(5);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("apply_source", 1);
    ((Bundle)localObject1).putInt("capture_scene", this.g);
    localObject2 = paramString2.a(paramString1);
    if ((((ComboSet)localObject2).jdField_a_of_type_Int == 1) || (((ComboSet)localObject2).jdField_a_of_type_Int == 2)) {
      QIMCommonLoadingProgress.a(localObject2).a();
    }
    paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject1);
    g();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("selectFilterItem state = ");
      paramString2.append(paramString1);
      QLog.i("ComboProviderView", 2, paramString2.toString());
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboObeserver);
    paramBundle = (CaptureComboManager)QIMManager.a(5);
    paramBundle.a(this);
    paramBundle.a().a(this.g);
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "ComboProviderView onCreate");
    }
    paramBundle = paramBundle.a;
    if (paramBundle != null) {
      setup(paramBundle.a(this.g));
    }
    paramBundle = (PasterDataManager)QIMManager.a().c(4);
    paramBundle.c();
    paramBundle.a(true, (Activity)getContext());
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    setup(paramComboFilterData.a(this.g));
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    g();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int k = paramQIMFilterCategoryItem.jdField_a_of_type_Int;
    int j = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == k) {
        break label52;
      }
      i += 1;
    }
    i = 0;
    label52:
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() != i) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(i);
    }
    Iterator localIterator = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.iterator();
    i = j;
    while ((localIterator.hasNext()) && (!((QIMFilterCategoryItem)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString))) {
      i += 1;
    }
    paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    if (paramQIMFilterCategoryItem != null)
    {
      paramQIMFilterCategoryItem.setSelection(i);
      ((ComboProviderGridAdapter)paramQIMFilterCategoryItem.getAdapter()).a();
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
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet != null)
    {
      CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      Activity localActivity = (Activity)getContext();
      VideoFilterTools.DataSet localDataSet = localCaptureComboManager.a.a(this.g);
      if (localDataSet.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem != null) {
        localCaptureComboManager.a(localDataSet.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem).a(localActivity, this.g);
      }
      VideoFilterTools.a().a(localDataSet.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, localActivity, this.g);
      g();
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
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a().jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null) {
      a(localQIMFilterCategoryItem);
    }
  }
  
  public void e()
  {
    super.e();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    g();
  }
  
  public void f()
  {
    VideoFilterTools.a();
    VideoFilterTools.a(true);
    super.f();
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a(5)).a(this.g, (Activity)getContext());
    }
  }
  
  public void g()
  {
    if (!this.d) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "ComboProviderView updateComboState");
    }
    int i = 0;
    int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a.size();
    while (i < j)
    {
      int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a.keyAt(i);
      ListAdapter localListAdapter = ((GridView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a.get(k)).getAdapter();
      if ((localListAdapter instanceof ComboProviderGridAdapter)) {
        ((ComboProviderGridAdapter)localListAdapter).notifyDataSetChanged();
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = b();
    paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView.f())
    {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView, 2);
      return;
    }
    if ((paramLong > 0L) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a(-1, paramAdapterView);
    }
    paramView = (CaptureComboManager)QIMManager.a(5);
    Object localObject = paramAdapterView.jdField_a_of_type_JavaLangString;
    if (paramView.a().a((String)localObject, getContext())) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.g);
    localObject = paramView.a(paramAdapterView);
    if ((((ComboSet)localObject).jdField_a_of_type_Int == 1) || (((ComboSet)localObject).jdField_a_of_type_Int == 2)) {
      QIMCommonLoadingProgress.a(localObject).a();
    }
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    if ((SlideShowPhotoListManager.a().b() == 22) && (paramAdapterView.f != null) && (paramAdapterView.f.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 1);
    }
    if ((SlideShowPhotoListManager.a().b() == 22) && (paramAdapterView.f != null) && (!paramAdapterView.f.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 2);
    }
    g();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onItemClick combo ");
      paramView.append(i);
      paramView.append(",");
      paramView.append(paramInt);
      paramView.append(", combo ");
      paramView.append(localObject);
      QLog.i("QCombo", 2, paramView.toString());
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onItemClick state = ");
      paramView.append(paramAdapterView);
      QLog.i("QCombo", 2, paramView.toString());
    }
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter = new ComboProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterComboProviderPagerAdapter.notifyDataSetChanged();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.jdField_a_of_type_Int;
    if (i > j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(j);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_Int);
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */