package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderPagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoTransfer;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager.Music;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;

public class TransitionProviderView
  extends ProviderView
  implements Handler.Callback, QIMSlidingTabView.IOnTabCheckListener, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener
{
  public int a;
  private TransitionProviderPagerAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter;
  MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = new TransitionProviderView.1(this);
  public MusicItemInfo a;
  private BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public ArrayList<FilterCategory> a;
  public int b = -1;
  public int c = 0;
  
  public TransitionProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null)
    {
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if ((localQimMusicPlayer != null) && (localQimMusicPlayer.b(paramMusicItemInfo)))
      {
        localQimMusicPlayer.a(paramMusicItemInfo);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.c(true);
        }
      }
      else if (localQimMusicPlayer != null)
      {
        localQimMusicPlayer.a(paramMusicItemInfo, this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
      }
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public ArrayList<QIMSlidingTabView.TabIcon> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.jdField_a_of_type_JavaLangString = ((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      localTabIcon.jdField_a_of_type_Boolean = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131714851));
      localStringBuilder.append(localTabIcon.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(HardCodeUtil.a(2131714852));
      localTabIcon.b = localStringBuilder.toString();
      localArrayList.add(localTabIcon);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter;
    if (localObject != null) {
      ((TransitionProviderPagerAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "TransitionProviderView onCreate");
    }
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560878, this, false));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
    paramBundle = ((CaptureComboManager)QIMManager.a(5)).a;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "comboFilterData null");
      }
    }
    else {
      setup(paramBundle.a());
    }
  }
  
  public void b(int paramInt) {}
  
  public void e()
  {
    ApngImage.playByTag(16);
    super.e();
  }
  
  public void f()
  {
    ApngImage.pauseByTag(16);
    super.f();
  }
  
  public void g()
  {
    if (!this.d) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderView", 2, "TransitionProviderView updateSelectedState");
    }
    TransitionProviderPagerAdapter localTransitionProviderPagerAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter;
    if (localTransitionProviderPagerAdapter != null) {
      localTransitionProviderPagerAdapter.b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    paramAdapterView = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    if (paramInt >= paramAdapterView.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    paramView = (TransitionCategoryItem)paramAdapterView.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((paramView != null) && (!paramView.equals(VideoFilterTools.a().a())))
    {
      VideoFilterTools.a().a(paramView);
      g();
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null)
      {
        paramInt = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.b(paramInt);
      }
      StoryReportor.a("video_edit_transition", "clk_effects", EditVideoTransfer.a(this.b), 0, new String[] { paramView.k, paramView.n, paramView.l, paramView.m });
    }
    if (SlideShowPhotoListManager.a().b() == 22) {
      if ((paramView != null) && (Integer.valueOf(paramView.jdField_a_of_type_JavaLangString).intValue() < 0)) {
        LpReportInfo_pf00064.allReport(680, 7, 2);
      } else if ((paramView != null) && (Integer.valueOf(paramView.jdField_a_of_type_JavaLangString).intValue() == 4)) {
        LpReportInfo_pf00064.allReport(680, 7, 1);
      } else if ((paramView != null) && (Integer.valueOf(paramView.jdField_a_of_type_JavaLangString).intValue() > 0)) {
        LpReportInfo_pf00064.allReport(680, 7, 3);
      }
    }
    if (paramView != null)
    {
      paramAdapterView = new MusicItemInfo();
      paramAdapterView.mType = 2;
      paramView = SlideShowConfigManager.a(getContext()).a(paramView.k);
      if ((paramView != null) && (paramView.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)QIMManager.a(2)).a(((SlideShowConfigManager.Music)paramView.get(0)).jdField_a_of_type_Int, ((SlideShowConfigManager.Music)paramView.get(0)).b);
        paramView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        if (paramView != null)
        {
          a(paramView);
          return;
        }
        a(paramAdapterView);
        return;
      }
      a(paramAdapterView);
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
    }
  }
  
  public void setup(ArrayList<FilterCategory> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter = new TransitionProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderPagerAdapter.notifyDataSetChanged();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.c;
    if (i > j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(j);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView
 * JD-Core Version:    0.7.0.1
 */