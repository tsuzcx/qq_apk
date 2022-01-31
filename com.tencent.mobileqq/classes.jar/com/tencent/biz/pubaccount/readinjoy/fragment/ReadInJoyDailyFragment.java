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
import bjxq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nrt;
import nvp;
import nww;
import opt;
import ors;
import osk;
import otf;
import ouk;
import oxb;
import oxp;
import ozk;
import ozl;
import ozm;
import pxc;
import qhl;
import svt;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  public static List<String> a;
  private static osk jdField_a_of_type_Osk = new osk();
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ozl(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ozk(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private nvp jdField_a_of_type_Nvp;
  private nww jdField_a_of_type_Nww;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(int paramInt)
  {
    oxb.a().a(new ozm(this, paramInt));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        opt.a(paramIntent);
      } while (!b());
      paramIntent = ors.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.c();
    localKandianMergeManager.s();
    ors.f(paramIntent);
    ors.a(false);
  }
  
  private void a(String paramString)
  {
    if (otf.b(otf.b())) {}
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
    if (jdField_a_of_type_Osk != null)
    {
      jdField_a_of_type_Osk.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Osk != null)
    {
      jdField_a_of_type_Osk.a();
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
    jdField_a_of_type_Osk.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(ors.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364973)).inflate();
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
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.a(paramInt1, paramInt2, paramIntent);
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
        localIntent.putExtra("open_kandian_tab_fragment", true);
        localIntent.putExtra("arg_channel_cover_id", 0);
        localIntent.setFlags(335544320);
        getActivity().startActivity(localIntent);
      }
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    opt.a(getActivity().app);
    opt.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    qhl.a().a(qhl.d, 1);
    svt.a();
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
    pxc.a().a();
    a(0);
    f();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      ors.c = true;
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
          bjxq.a(paramBundle, j, i, (Bundle)localObject, otf.b());
          if ((j == 1) && ((i != 1) || (bjxq.a((Bundle)localObject)))) {
            opt.a(32);
          }
        }
      }
      d();
      ors.i();
      g();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ouk.a();
    otf.b();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559987, paramViewGroup, false);
    oxp.b(0, opt.a(), 0);
    otf.b();
    this.jdField_a_of_type_Nww = new nww(getActivity());
    this.jdField_a_of_type_Nww.a(otf.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375298);
    this.jdField_a_of_type_Nww.a(paramLayoutInflater);
    this.jdField_a_of_type_Nww.a();
    this.jdField_a_of_type_Nvp = new nvp(this.jdField_a_of_type_Nww.a());
    this.jdField_a_of_type_Nvp.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Nvp.a(this.jdField_a_of_type_AndroidViewView);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    svt.b();
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.d();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    pxc.a().b();
    a(5);
    e();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Nvp.a();
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
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.g();
    }
    ApngImage.pauseByTag(31);
    a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.h();
    }
    RecommendFeedsDiandianEntranceManager.a().a();
    ApngImage.playByTag(31);
    a(2);
    nrt.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.e();
    }
    if (jdField_a_of_type_Osk != null) {
      jdField_a_of_type_Osk.a();
    }
    a(1);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Nww != null) {
      this.jdField_a_of_type_Nww.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_Osk != null)) {
      jdField_a_of_type_Osk.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Nww != null) {
        this.jdField_a_of_type_Nww.c();
      }
      qhl.a().c();
      oxp.b(1, opt.a(), opt.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(opt.a());
      }
      opt.b();
      ors.c = false;
      otf.c();
    }
    a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */