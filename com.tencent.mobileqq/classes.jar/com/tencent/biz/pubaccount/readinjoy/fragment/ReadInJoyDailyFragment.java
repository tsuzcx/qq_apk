package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import bmic;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import odz;
import olh;
import oqb;
import orj;
import pin;
import pkh;
import pkn;
import plm;
import pmu;
import pnn;
import prp;
import prs;
import pti;
import pwb;
import pwy;
import pwz;
import pxa;
import pxc;
import pxd;
import pxe;
import pxf;
import pxg;
import pxl;
import pyg;
import pyh;
import rbg;
import rjm;
import uic;
import ujj;
import ukq;
import urp;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a;
  private static pkn jdField_a_of_type_Pkn = new pkn();
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new pyh(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pyg(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private oqb jdField_a_of_type_Oqb;
  private orj jdField_a_of_type_Orj;
  private pwz jdField_a_of_type_Pwz = new pwz();
  private pxc jdField_a_of_type_Pxc;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        pin.a(paramIntent);
      } while (!b());
      paramIntent = pnn.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    localKandianMergeManager.d();
    localKandianMergeManager.r();
    prp.a(paramIntent);
  }
  
  private void a(String paramString)
  {
    if (plm.b(plm.b())) {}
    for (String str = "0X80089D1";; str = "0X80098B0")
    {
      ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.4(this, paramString, str));
      return;
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Pkn != null)
    {
      jdField_a_of_type_Pkn.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Pkn != null)
    {
      jdField_a_of_type_Pkn.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = pnn.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Pxc == null) {
      this.jdField_a_of_type_Pxc = new pxc(this.jdField_a_of_type_Pwz, getActivity());
    }
    this.jdField_a_of_type_Pwz.a(new pwy[] { new pxe(this.jdField_a_of_type_Pwz, getActivity()), new pxd(this.jdField_a_of_type_Pwz, getActivity()), new pxf(this.jdField_a_of_type_Pwz, localQQAppInterface, getActivity()), this.jdField_a_of_type_Pxc, new pxa(this.jdField_a_of_type_Pwz, localQQAppInterface, getActivity()), new pxl(this.jdField_a_of_type_Pwz, getActivity()), new pxg(this.jdField_a_of_type_Pwz, localQQAppInterface, getActivity()) });
  }
  
  private void e()
  {
    if (getActivity() != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("float_layer_finsh_action");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void f()
  {
    if (getActivity() != null) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.5(this));
  }
  
  private void h()
  {
    jdField_a_of_type_Pkn.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(pkh.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365375)).inflate();
      }
      if (this.b != null) {
        this.b.setVisibility(0);
      }
    }
    while (this.b == null) {
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("launch_from")))
    {
      int i = getActivity().getIntent().getIntExtra("launch_from", 0);
      if ((i == 9) || (i == 6))
      {
        Intent localIntent = new Intent(getActivity(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", MainFragment.b);
        localIntent.putExtra("open_kandian_tab_fragment", true);
        localIntent.putExtra("arg_channel_cover_id", 0);
        localIntent.setFlags(335544320);
        getActivity().startActivity(localIntent);
      }
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    QLog.d("ReadInJoyDailyFragment", 1, "onConfigurationChanged densityNoScale : " + f1 + ", screenWidth : " + paramConfiguration.widthPixels);
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    plm.b();
    pin.a(getActivity().app);
    pin.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    rjm.a().a(rjm.d, 1);
    urp.a();
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      localObject = paramBundle.getIntent();
      if (localObject != null) {
        this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("launch_from", 5);
      }
      a((Intent)localObject);
    }
    ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
    rbg.a().a();
    g();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      pqf.jdField_a_of_type_Boolean = true;
      QLog.d("ReadInJoyDailyFragment", 1, "from aio share");
    }
    for (int i = 1;; i = 0)
    {
      if ((localObject != null) && (paramBundle != null))
      {
        if (((Bundle)localObject).getBoolean("open_floating_window", false)) {
          i = 1;
        }
        if (i != 0)
        {
          QLog.d("ReadInJoyDailyFragment", 1, "openFloatingWindow is true");
          i = ((Bundle)localObject).getInt("floating_window_business");
          int j = ((Bundle)localObject).getInt("floating_window_scene");
          bmic.a(paramBundle, j, i, (Bundle)localObject, plm.b());
          if ((j == 1) && ((i != 1) || (bmic.a((Bundle)localObject)))) {
            pin.a(32);
          }
        }
      }
      e();
      prs.a();
      h();
      d();
      this.jdField_a_of_type_Pwz.a();
      this.jdField_a_of_type_Pxc.i();
      paramBundle = pnn.a();
      if (paramBundle != null)
      {
        uic.a(paramBundle).e();
        uic.a(paramBundle);
      }
      ujj.a.b(41697);
      ukq.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId 41697 notifyShowSelf ");
      ujj.a.a(0);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    pmu.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560199, paramViewGroup, false);
    pwb.b(0, pin.a(), 0);
    this.jdField_a_of_type_Orj = new orj(getActivity());
    this.jdField_a_of_type_Orj.a(plm.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376226);
    this.jdField_a_of_type_Orj.a(paramLayoutInflater);
    this.jdField_a_of_type_Orj.a();
    this.jdField_a_of_type_Oqb = new oqb(this.jdField_a_of_type_Orj.a());
    this.jdField_a_of_type_Oqb.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Oqb.a(this.jdField_a_of_type_AndroidViewView);
    a();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pti().a(Integer.valueOf(plm.b())).a());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    urp.b();
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.d();
    }
    if (this.jdField_a_of_type_Pwz != null) {
      this.jdField_a_of_type_Pwz.b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    rbg.a().b();
    f();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Oqb.a();
    odz.a().a("RIJAdRefreshSceneDaily");
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getActivity().setIntent(paramIntent);
    if (paramIntent != null) {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    }
    a(paramIntent);
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.g();
    }
    if (this.jdField_a_of_type_Pwz != null) {
      this.jdField_a_of_type_Pwz.d();
    }
    ApngImage.pauseByTag(31);
    ujj.a.b(-1);
    ukq.a("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
    ujj.a.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.h();
    }
    if (this.jdField_a_of_type_Pwz != null) {
      this.jdField_a_of_type_Pwz.c();
    }
    RecommendFeedsDiandianEntranceManager.a().b();
    ApngImage.playByTag(31);
    olh.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
    ujj.a.b(plm.b());
    ukq.a("ReadInJoySuperMaskAd", "onResume: setSuperMaskChannelId = " + plm.b());
    ujj.a.b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.e();
    }
    if (jdField_a_of_type_Pkn != null) {
      jdField_a_of_type_Pkn.a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_Pkn != null)) {
      jdField_a_of_type_Pkn.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Orj != null) {
        this.jdField_a_of_type_Orj.c();
      }
      rjm.a().c();
      pwb.b(1, pin.a(), pin.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(pin.a());
      }
      pin.b();
      pqf.jdField_a_of_type_Boolean = false;
      plm.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Pwz != null)) {
      this.jdField_a_of_type_Pwz.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */