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
  public ArrayList<FilterCategory> a;
  public int b = 0;
  public int c = -1;
  public MusicItemInfo d;
  WeakReferenceHandler e = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public int f = 0;
  MusicDownloadListener g = new TransitionProviderView.1(this);
  private BounceViewPager h;
  private TransitionProviderPagerAdapter i;
  
  public TransitionProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null)
    {
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().d(8);
      if ((localQimMusicPlayer != null) && (localQimMusicPlayer.b(paramMusicItemInfo)))
      {
        localQimMusicPlayer.a(paramMusicItemInfo);
        if (this.F != null) {
          this.F.c(true);
        }
      }
      else if (localQimMusicPlayer != null)
      {
        localQimMusicPlayer.a(paramMusicItemInfo, this.g);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((TransitionProviderPagerAdapter)localObject).a();
    }
    localObject = this.h;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.v.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "TransitionProviderView onCreate");
    }
    super.a(paramBundle);
    this.v.setTabCheckListener(this);
    if (this.w == null) {
      this.h = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131627201, this, false));
    } else {
      this.h = ((BounceViewPager)this.w);
    }
    this.h.a(this);
    a(this.h);
    paramBundle = ((CaptureComboManager)QIMManager.a(5)).l;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "comboFilterData null");
      }
    }
    else {
      setup(paramBundle.c());
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
    if (!this.B) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderView", 2, "TransitionProviderView updateSelectedState");
    }
    TransitionProviderPagerAdapter localTransitionProviderPagerAdapter = this.i;
    if (localTransitionProviderPagerAdapter != null) {
      localTransitionProviderPagerAdapter.b();
    }
  }
  
  protected int getInflateLayout()
  {
    return 0;
  }
  
  public ArrayList<QIMSlidingTabView.TabIcon> getTabTextList()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.a.size())
    {
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.a = ((FilterCategory)this.a.get(j)).b;
      localTabIcon.b = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131912351));
      localStringBuilder.append(localTabIcon.a);
      localStringBuilder.append(HardCodeUtil.a(2131912352));
      localTabIcon.c = localStringBuilder.toString();
      localArrayList.add(localTabIcon);
      j += 1;
    }
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a(this.d);
    }
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (this.h.getCurrentItem() >= this.a.size()) {
      return;
    }
    paramAdapterView = (FilterCategory)this.a.get(this.h.getCurrentItem());
    if (paramInt >= paramAdapterView.c.size()) {
      return;
    }
    paramView = (TransitionCategoryItem)paramAdapterView.c.get(paramInt);
    if ((paramView != null) && (!paramView.equals(VideoFilterTools.a().c())))
    {
      VideoFilterTools.a().a(paramView);
      g();
      if (this.F != null)
      {
        paramInt = Integer.parseInt(paramView.a);
        this.F.b(paramInt);
      }
      StoryReportor.a("video_edit_transition", "clk_effects", EditVideoTransfer.b(this.c), 0, new String[] { paramView.t, paramView.w, paramView.u, paramView.v });
    }
    if (SlideShowPhotoListManager.a().e() == 22) {
      if ((paramView != null) && (Integer.valueOf(paramView.a).intValue() < 0)) {
        LpReportInfo_pf00064.allReport(680, 7, 2);
      } else if ((paramView != null) && (Integer.valueOf(paramView.a).intValue() == 4)) {
        LpReportInfo_pf00064.allReport(680, 7, 1);
      } else if ((paramView != null) && (Integer.valueOf(paramView.a).intValue() > 0)) {
        LpReportInfo_pf00064.allReport(680, 7, 3);
      }
    }
    if (paramView != null)
    {
      paramAdapterView = new MusicItemInfo();
      paramAdapterView.mType = 2;
      paramView = SlideShowConfigManager.a(getContext()).a(paramView.t);
      if ((paramView != null) && (paramView.size() > 0))
      {
        this.d = ((QIMMusicConfigManager)QIMManager.a(2)).a(((SlideShowConfigManager.Music)paramView.get(0)).a, ((SlideShowConfigManager.Music)paramView.get(0)).b);
        paramView = this.d;
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
      if (paramInt > this.a.size()) {
        return;
      }
      this.h.setCurrentItem(paramInt);
    }
  }
  
  public void setup(ArrayList<FilterCategory> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.a = new ArrayList(5);
    this.a.addAll(paramArrayList);
    this.v.initTabItemsWithRedDot(getTabTextList());
    this.i = new TransitionProviderPagerAdapter(this.r, this.D);
    this.i.a(this.a);
    this.i.a(this);
    this.h.setAdapter(this.i);
    this.i.notifyDataSetChanged();
    int j = this.a.size();
    int k = this.f;
    if (j > k)
    {
      this.h.setCurrentItem(k);
      this.v.onTabChecked(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView
 * JD-Core Version:    0.7.0.1
 */