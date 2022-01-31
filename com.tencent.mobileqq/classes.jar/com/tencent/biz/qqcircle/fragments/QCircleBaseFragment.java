package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import bdij;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import tqb;
import tql;
import tqt;
import tra;
import tvt;
import tvy;
import xxl;
import yuh;

public abstract class QCircleBaseFragment
  extends ComponentBaseFragment
{
  public static final String b = QCircleBaseFragment.class.getSimpleName();
  
  private void b()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      long l = getActivity().getIntent().getLongExtra("key_bundle_open_page_time", 0L);
      if (l != 0L) {
        QLog.i(b, 1, "openPageTime = " + (System.currentTimeMillis() - l));
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
    File localFile = new File(tqb.g);
    if ((localFile.exists()) || (bdij.a() == null))
    {
      QLog.i(b, 1, "DownLoadZipFile Save file is exist");
      return;
    }
    xxl.a(localFile, (String)yuh.a().a("KEY_QCIRCLE_BASE_VIEW_DOWNLOAD_URL", "https://down.qq.com/video_story/qcircle/base/qcircle_download_pics.zip"), tqb.d);
  }
  
  private void e()
  {
    tvt localtvt = tvt.a();
    tvy localtvy = new tvy(this);
    localtvt.a(new String[] { "https://down.qq.com/video_story/qcircle/animation/rockey1.zip", "https://down.qq.com/video_story/qcircle/animation/rockey2.zip", "https://down.qq.com/video_story/qcircle/animation/rockey3.zip", "https://down.qq.com/video_story/qcircle/animation/icon_start_recommend.zip", "https://down.qq.com/video_story/qcircle/animation/icon_end_recommend.zip", "https://down.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip", "https://down.qq.com/video_story/qcircle/animation/rockey_single_click.zip" }, localtvy);
  }
  
  public void a() {}
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
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
      if (((getActivity() instanceof PublicFragmentActivity)) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        ImmersiveUtils.a(true, getActivity().getWindow());
        tra.a(getActivity());
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((xxl.a()) && (b())) {
      c();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    tqt.a().a();
    tql.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
 * JD-Core Version:    0.7.0.1
 */