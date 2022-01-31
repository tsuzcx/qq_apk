package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import bhvo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import noo;
import nsf;
import ntu;
import olm;
import onk;
import ooc;
import oox;
import opw;
import osm;
import ota;
import ouj;
import ouk;
import oul;
import pqk;
import pyq;
import sed;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a;
  private static ooc jdField_a_of_type_Ooc = new ooc();
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ouk(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ouj(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private nsf jdField_a_of_type_Nsf;
  private ntu jdField_a_of_type_Ntu;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(int paramInt)
  {
    osm.a().a(new oul(this, paramInt));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        olm.a(paramIntent);
      } while (!b());
      paramIntent = onk.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.c();
    localKandianMergeManager.s();
    onk.f(paramIntent);
    onk.a(false);
  }
  
  private void a(String paramString)
  {
    if (oox.b(oox.b())) {}
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
    if (jdField_a_of_type_Ooc != null)
    {
      jdField_a_of_type_Ooc.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Ooc != null)
    {
      jdField_a_of_type_Ooc.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    if (getActivity() != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("float_layer_finsh_action");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void e()
  {
    if (getActivity() != null) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  private void f()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.6(this));
  }
  
  private void g()
  {
    jdField_a_of_type_Ooc.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(onk.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364887)).inflate();
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
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    pyq.a().a(pyq.d, 1);
    sed.a();
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
    pqk.a().a();
    a(0);
    f();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      onk.c = true;
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
          bhvo.a(paramBundle, ((Bundle)localObject).getInt("floating_window_scene"), i, (Bundle)localObject);
        }
      }
      d();
      onk.g();
      g();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    opw.a();
    oox.b();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559891, paramViewGroup, false);
    ota.b(0, olm.a(), 0);
    oox.b();
    this.jdField_a_of_type_Ntu = new ntu(getActivity());
    this.jdField_a_of_type_Ntu.a(oox.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131374831);
    this.jdField_a_of_type_Ntu.a(paramLayoutInflater);
    this.jdField_a_of_type_Ntu.a();
    this.jdField_a_of_type_Nsf = new nsf(this.jdField_a_of_type_Ntu.a());
    this.jdField_a_of_type_Nsf.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Nsf.a(this.jdField_a_of_type_AndroidViewView);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    sed.b();
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.d();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    pqk.a().b();
    a(5);
    e();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Nsf.a();
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
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.g();
    }
    ApngImage.pauseByTag(31);
    a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.h();
    }
    RecommendFeedsDiandianEntranceManager.a().a();
    ApngImage.playByTag(31);
    a(2);
    noo.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.e();
    }
    if (jdField_a_of_type_Ooc != null) {
      jdField_a_of_type_Ooc.a();
    }
    a(1);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Ntu != null) {
      this.jdField_a_of_type_Ntu.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_Ooc != null)) {
      jdField_a_of_type_Ooc.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Ntu != null) {
        this.jdField_a_of_type_Ntu.c();
      }
      pyq.a().c();
      ota.b(1, olm.a(), olm.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(olm.a());
      }
      olm.b();
      onk.c = false;
      oox.c();
    }
    a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */