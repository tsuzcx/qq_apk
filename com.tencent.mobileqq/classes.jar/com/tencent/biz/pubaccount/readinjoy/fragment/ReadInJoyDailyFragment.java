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
import bkwt;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nwz;
import odq;
import oif;
import ojm;
import ozh;
import pay;
import pbm;
import pcl;
import pdt;
import pil;
import ple;
import pmb;
import pmc;
import pmd;
import pmf;
import pmg;
import pmh;
import pmi;
import pmj;
import pmo;
import pni;
import pnj;
import qpb;
import qxg;
import ttv;
import tuz;
import tva;
import tvi;
import twp;
import uds;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a;
  private static pbm jdField_a_of_type_Pbm = new pbm();
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new pnj(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pni(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private oif jdField_a_of_type_Oif;
  private ojm jdField_a_of_type_Ojm;
  private pmc jdField_a_of_type_Pmc = new pmc();
  private pmf jdField_a_of_type_Pmf;
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
        ozh.a(paramIntent);
      } while (!b());
      paramIntent = pay.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.d();
    localKandianMergeManager.r();
    pay.f(paramIntent);
    pay.a(false);
  }
  
  private void a(String paramString)
  {
    if (pcl.b(pcl.b())) {}
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
    if (jdField_a_of_type_Pbm != null)
    {
      jdField_a_of_type_Pbm.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Pbm != null)
    {
      jdField_a_of_type_Pbm.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = pay.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Pmf == null) {
      this.jdField_a_of_type_Pmf = new pmf(this.jdField_a_of_type_Pmc, getActivity());
    }
    this.jdField_a_of_type_Pmc.a(new pmb[] { new pmh(this.jdField_a_of_type_Pmc, getActivity()), new pmg(this.jdField_a_of_type_Pmc, getActivity()), new pmi(this.jdField_a_of_type_Pmc, localQQAppInterface, getActivity()), this.jdField_a_of_type_Pmf, new pmd(this.jdField_a_of_type_Pmc, localQQAppInterface, getActivity()), new pmo(this.jdField_a_of_type_Pmc, getActivity()), new pmj(this.jdField_a_of_type_Pmc, localQQAppInterface, getActivity()) });
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
    jdField_a_of_type_Pbm.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(pay.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365281)).inflate();
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
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.a(paramInt1, paramInt2, paramIntent);
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
    pcl.b();
    ozh.a(getActivity().app);
    ozh.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    qxg.a().a(qxg.d, 1);
    uds.a();
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
    qpb.a().a();
    g();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      pay.c = true;
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
          bkwt.a(paramBundle, j, i, (Bundle)localObject, pcl.b());
          if ((j == 1) && ((i != 1) || (bkwt.a((Bundle)localObject)))) {
            ozh.a(32);
          }
        }
      }
      e();
      pay.g();
      h();
      d();
      this.jdField_a_of_type_Pmc.a();
      this.jdField_a_of_type_Pmf.i();
      paramBundle = pay.a();
      if (paramBundle != null)
      {
        ttv.a(paramBundle).e();
        ttv.a(paramBundle);
      }
      tvi.a.b(41697);
      twp.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId 41697 notifyShowSelf ");
      tvi.a.a(tuz.a.a());
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    pdt.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560152, paramViewGroup, false);
    ple.b(0, ozh.a(), 0);
    this.jdField_a_of_type_Ojm = new ojm(getActivity());
    this.jdField_a_of_type_Ojm.a(pcl.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375979);
    this.jdField_a_of_type_Ojm.a(paramLayoutInflater);
    this.jdField_a_of_type_Ojm.a();
    this.jdField_a_of_type_Oif = new oif(this.jdField_a_of_type_Ojm.a());
    this.jdField_a_of_type_Oif.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Oif.a(this.jdField_a_of_type_AndroidViewView);
    a();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pil().a(Integer.valueOf(pcl.b())).a());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    uds.b();
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.d();
    }
    if (this.jdField_a_of_type_Pmc != null) {
      this.jdField_a_of_type_Pmc.b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    qpb.a().b();
    f();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Oif.a();
    nwz.a().a("RIJAdRefreshSceneDaily");
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
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.g();
    }
    if (this.jdField_a_of_type_Pmc != null) {
      this.jdField_a_of_type_Pmc.d();
    }
    ApngImage.pauseByTag(31);
    tvi.a.b(-1);
    twp.a("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
    tvi.a.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.h();
    }
    if (this.jdField_a_of_type_Pmc != null) {
      this.jdField_a_of_type_Pmc.c();
    }
    RecommendFeedsDiandianEntranceManager.a().a();
    ApngImage.playByTag(31);
    odq.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
    tvi.a.b(pcl.b());
    twp.a("ReadInJoySuperMaskAd", "onResume: setSuperMaskChannelId = " + pcl.b());
    tvi.a.b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.e();
    }
    if (jdField_a_of_type_Pbm != null) {
      jdField_a_of_type_Pbm.a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ojm != null) {
      this.jdField_a_of_type_Ojm.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_Pbm != null)) {
      jdField_a_of_type_Pbm.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Ojm != null) {
        this.jdField_a_of_type_Ojm.c();
      }
      qxg.a().c();
      ple.b(1, ozh.a(), ozh.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(ozh.a());
      }
      ozh.b();
      pay.c = false;
      pcl.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Pmc != null)) {
      this.jdField_a_of_type_Pmc.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */