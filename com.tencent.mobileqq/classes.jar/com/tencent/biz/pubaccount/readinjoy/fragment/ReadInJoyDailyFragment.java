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
import anll;
import bgnt;
import bmqh;
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
import oat;
import ofk;
import ogr;
import oon;
import oqr;
import pfk;
import pha;
import pho;
import pil;
import pjr;
import pkh;
import pmk;
import pmy;
import pnq;
import pnr;
import pns;
import pnt;
import pnu;
import pnv;
import pnw;
import pny;
import pod;
import pox;
import poy;
import poz;
import qqk;
import rat;
import txa;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a;
  private static pho jdField_a_of_type_Pho = new pho();
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new poy(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pox(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private ofk jdField_a_of_type_Ofk;
  private ogr jdField_a_of_type_Ogr;
  private pnr jdField_a_of_type_Pnr = new pnr();
  private pnt jdField_a_of_type_Pnt;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(int paramInt)
  {
    pmk.a().a(new poz(this, paramInt));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        pfk.a(paramIntent);
      } while (!b());
      paramIntent = pha.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.d();
    localKandianMergeManager.s();
    pha.f(paramIntent);
    pha.a(false);
  }
  
  private void a(String paramString)
  {
    if (pil.b(pil.b())) {}
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
    if (jdField_a_of_type_Pho != null)
    {
      jdField_a_of_type_Pho.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Pho != null)
    {
      jdField_a_of_type_Pho.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = pha.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Pnt == null) {
      this.jdField_a_of_type_Pnt = new pnt(this.jdField_a_of_type_Pnr, getActivity());
    }
    this.jdField_a_of_type_Pnr.a(new pnq[] { new pnv(this.jdField_a_of_type_Pnr, getActivity()), new pnu(this.jdField_a_of_type_Pnr, getActivity()), new pnw(this.jdField_a_of_type_Pnr, localQQAppInterface, getActivity()), this.jdField_a_of_type_Pnt, new pns(this.jdField_a_of_type_Pnr, localQQAppInterface, getActivity()), new pod(this.jdField_a_of_type_Pnr, getActivity()), new pny(this.jdField_a_of_type_Pnr, localQQAppInterface, getActivity()) });
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
    jdField_a_of_type_Pho.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(pha.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365212)).inflate();
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
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.a(paramInt1, paramInt2, paramIntent);
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
    float f2 = anll.a() / 16.0F;
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
    pil.b();
    pfk.a(getActivity().app);
    pfk.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    rat.a().a(rat.d, 1);
    txa.a();
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
    qqk.a().a();
    a(0);
    g();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      pha.c = true;
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
          bmqh.a(paramBundle, j, i, (Bundle)localObject, pil.b());
          if ((j == 1) && ((i != 1) || (bmqh.a((Bundle)localObject)))) {
            pfk.a(32);
          }
        }
      }
      e();
      pha.g();
      h();
      d();
      this.jdField_a_of_type_Pnr.a();
      this.jdField_a_of_type_Pnt.i();
      paramBundle = pha.a();
      if ((bgnt.h(getActivity())) && (paramBundle != null))
      {
        oon.a(paramBundle).a();
        oon.a(paramBundle);
      }
      oqr.a().a(41697);
      oqr.a().b(0);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    pjr.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560133, paramViewGroup, false);
    pmy.b(0, pfk.a(), 0);
    this.jdField_a_of_type_Ogr = new ogr(getActivity());
    this.jdField_a_of_type_Ogr.a(pil.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376073);
    this.jdField_a_of_type_Ogr.a(paramLayoutInflater);
    this.jdField_a_of_type_Ogr.a();
    this.jdField_a_of_type_Ofk = new ofk(this.jdField_a_of_type_Ogr.a());
    this.jdField_a_of_type_Ofk.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Ofk.a(this.jdField_a_of_type_AndroidViewView);
    a();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "8014");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pkh().a(pil.b()).a());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    txa.b();
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.d();
    }
    if (this.jdField_a_of_type_Pnr != null) {
      this.jdField_a_of_type_Pnr.b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    qqk.a().b();
    a(5);
    f();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Ofk.a();
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
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.g();
    }
    if (this.jdField_a_of_type_Pnr != null) {
      this.jdField_a_of_type_Pnr.d();
    }
    ApngImage.pauseByTag(31);
    a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.h();
    }
    if (this.jdField_a_of_type_Pnr != null) {
      this.jdField_a_of_type_Pnr.c();
    }
    RecommendFeedsDiandianEntranceManager.a().a();
    ApngImage.playByTag(31);
    a(2);
    oat.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.e();
    }
    if (jdField_a_of_type_Pho != null) {
      jdField_a_of_type_Pho.a();
    }
    a(1);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ogr != null) {
      this.jdField_a_of_type_Ogr.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_Pho != null)) {
      jdField_a_of_type_Pho.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Ogr != null) {
        this.jdField_a_of_type_Ogr.c();
      }
      rat.a().c();
      pmy.b(1, pfk.a(), pfk.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(pfk.a());
      }
      pfk.b();
      pha.c = false;
      pil.c();
    }
    a(4);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Pnr != null)) {
      this.jdField_a_of_type_Pnr.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */