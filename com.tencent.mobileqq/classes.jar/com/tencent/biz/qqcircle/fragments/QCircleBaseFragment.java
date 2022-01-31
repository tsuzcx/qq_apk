package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import bdms;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import tqb;
import tql;
import tqt;
import tra;
import twe;
import twn;
import ybu;
import yyw;

public abstract class QCircleBaseFragment
  extends ComponentBaseFragment
{
  protected TopGestureLayout a;
  
  private void b()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      long l = getActivity().getIntent().getLongExtra("key_bundle_open_page_time", 0L);
      if (l != 0L) {
        QLog.i("QCircleBaseFragment", 1, "openPageTime = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  private void c()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void d()
  {
    File localFile = new File(tqb.i);
    if ((localFile.exists()) || (bdms.a() == null))
    {
      QLog.i("QCircleBaseFragment", 1, "DownLoadZipFile Save file is exist");
      return;
    }
    ybu.a(localFile, (String)yyw.a().a("KEY_QCIRCLE_BASE_VIEW_DOWNLOAD_URL", "https://down.qq.com/video_story/qcircle/base/qcircle_download_pics.zip"), tqb.f);
  }
  
  private void e()
  {
    twe localtwe = twe.a();
    twn localtwn = new twn(this);
    localtwe.a(new String[] { "https://down.qq.com/video_story/qcircle/animation/rockey1.zip", "https://down.qq.com/video_story/qcircle/animation/rockey2.zip", "https://down.qq.com/video_story/qcircle/animation/rockey3.zip", "https://down.qq.com/video_story/qcircle/animation/icon_start_recommend.zip", "https://down.qq.com/video_story/qcircle/animation/icon_end_recommend.zip", "https://down.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip", "https://down.qq.com/video_story/qcircle/animation/rockey_single_click.zip" }, localtwn);
  }
  
  protected TopGestureLayout a()
  {
    if (this.a == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.a = ((TopGestureLayout)localObject);
      }
    }
    return this.a;
  }
  
  public abstract String a();
  
  public void a()
  {
    QLog.d(a(), 1, a() + "->onBackPressed");
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d(a(), 1, a() + "->doOnCreateView");
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    d();
    e();
    paramLayoutInflater = getActivity().mSystemBarComp;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.init();
      paramLayoutInflater.setStatusBarVisible(2, 0);
    }
    if (a()) {
      getActivity().getWindow().setFlags(1024, 1024);
    }
    for (;;)
    {
      b();
      return;
      if (((getActivity() instanceof QCircleFragmentActivity)) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        tra.a(getActivity(), b());
        ImmersiveUtils.a(true, getActivity().getWindow());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleBaseFragment", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected int b()
  {
    return tra.a();
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((ybu.a()) && (b())) {
      c();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    QLog.d(a(), 1, a() + "->onAttach");
    super.onAttach(paramActivity);
  }
  
  public void onDestroy()
  {
    QLog.d(a(), 1, a() + "->onDestroy");
    super.onDestroy();
    tqt.a().a();
    tql.a();
  }
  
  public void onDetach()
  {
    QLog.d(a(), 1, a() + "->onDetach");
    super.onDetach();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(a(), 1, a() + "->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
 * JD-Core Version:    0.7.0.1
 */