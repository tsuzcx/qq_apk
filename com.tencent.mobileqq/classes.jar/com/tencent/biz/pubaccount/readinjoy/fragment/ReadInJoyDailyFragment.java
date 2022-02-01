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
import anxh;
import bnrm;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
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
import ocd;
import ogs;
import ohz;
import oyc;
import ozs;
import pag;
import pbd;
import pcj;
import pda;
import pfd;
import pfs;
import pgp;
import pgq;
import pgr;
import pgs;
import pgt;
import pgu;
import pgv;
import pgw;
import phb;
import phv;
import phw;
import phx;
import qiy;
import qrn;
import tny;
import tqi;
import txc;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a;
  private static pag jdField_a_of_type_Pag = new pag();
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new phw(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new phv(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private ogs jdField_a_of_type_Ogs;
  private ohz jdField_a_of_type_Ohz;
  private pgq jdField_a_of_type_Pgq = new pgq();
  private pgs jdField_a_of_type_Pgs;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(int paramInt)
  {
    pfd.a().a(new phx(this, paramInt));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        oyc.a(paramIntent);
      } while (!b());
      paramIntent = ozs.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.d();
    localKandianMergeManager.s();
    ozs.f(paramIntent);
    ozs.a(false);
  }
  
  private void a(String paramString)
  {
    if (pbd.b(pbd.b())) {}
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
    if (jdField_a_of_type_Pag != null)
    {
      jdField_a_of_type_Pag.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Pag != null)
    {
      jdField_a_of_type_Pag.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = ozs.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Pgs == null) {
      this.jdField_a_of_type_Pgs = new pgs(this.jdField_a_of_type_Pgq, getActivity());
    }
    this.jdField_a_of_type_Pgq.a(new pgp[] { new pgu(this.jdField_a_of_type_Pgq, getActivity()), new pgt(this.jdField_a_of_type_Pgq, getActivity()), new pgv(this.jdField_a_of_type_Pgq, localQQAppInterface, getActivity()), this.jdField_a_of_type_Pgs, new pgr(this.jdField_a_of_type_Pgq, localQQAppInterface, getActivity()), new phb(this.jdField_a_of_type_Pgq, getActivity()), new pgw(this.jdField_a_of_type_Pgq, localQQAppInterface, getActivity()) });
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
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.6(this));
  }
  
  private void h()
  {
    jdField_a_of_type_Pag.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(ozs.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365256)).inflate();
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
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.a(paramInt1, paramInt2, paramIntent);
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
    float f2 = anxh.a() / 16.0F;
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
    pbd.b();
    oyc.a(getActivity().app);
    oyc.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    qrn.a().a(qrn.d, 1);
    txc.a();
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
    qiy.a().a();
    a(0);
    g();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      ozs.c = true;
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
          bnrm.a(paramBundle, j, i, (Bundle)localObject, pbd.b());
          if ((j == 1) && ((i != 1) || (bnrm.a((Bundle)localObject)))) {
            oyc.a(32);
          }
        }
      }
      e();
      ozs.g();
      h();
      d();
      this.jdField_a_of_type_Pgq.a();
      this.jdField_a_of_type_Pgs.i();
      paramBundle = ozs.a();
      if (paramBundle != null)
      {
        tny.a(paramBundle).b();
        tny.a(paramBundle);
      }
      tqi.a().a(41697);
      tqi.a().b(0);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    pcj.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560145, paramViewGroup, false);
    pfs.b(0, oyc.a(), 0);
    this.jdField_a_of_type_Ohz = new ohz(getActivity());
    this.jdField_a_of_type_Ohz.a(pbd.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376213);
    this.jdField_a_of_type_Ohz.a(paramLayoutInflater);
    this.jdField_a_of_type_Ohz.a();
    this.jdField_a_of_type_Ogs = new ogs(this.jdField_a_of_type_Ohz.a());
    this.jdField_a_of_type_Ogs.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Ogs.a(this.jdField_a_of_type_AndroidViewView);
    a();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "8014");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pda().a(pbd.b()).a());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    txc.b();
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.d();
    }
    if (this.jdField_a_of_type_Pgq != null) {
      this.jdField_a_of_type_Pgq.b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    qiy.a().b();
    a(5);
    f();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Ogs.a();
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
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.g();
    }
    if (this.jdField_a_of_type_Pgq != null) {
      this.jdField_a_of_type_Pgq.d();
    }
    ApngImage.pauseByTag(31);
    a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.h();
    }
    if (this.jdField_a_of_type_Pgq != null) {
      this.jdField_a_of_type_Pgq.c();
    }
    RecommendFeedsDiandianEntranceManager.a().a();
    ApngImage.playByTag(31);
    a(2);
    ocd.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.e();
    }
    if (jdField_a_of_type_Pag != null) {
      jdField_a_of_type_Pag.a();
    }
    a(1);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ohz != null) {
      this.jdField_a_of_type_Ohz.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_Pag != null)) {
      jdField_a_of_type_Pag.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Ohz != null) {
        this.jdField_a_of_type_Ohz.c();
      }
      qrn.a().c();
      pfs.b(1, oyc.a(), oyc.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(oyc.a());
      }
      oyc.b();
      ozs.c = false;
      pbd.c();
    }
    a(4);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Pgq != null)) {
      this.jdField_a_of_type_Pgq.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */