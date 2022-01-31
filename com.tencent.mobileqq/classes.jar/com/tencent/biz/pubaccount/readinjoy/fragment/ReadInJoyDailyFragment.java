package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;
import ndn;
import ngv;
import nik;
import oab;
import obz;
import ocr;
import odm;
import oel;
import ohb;
import ohp;
import oiy;
import oiz;
import peq;
import pmv;
import rrl;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = 5;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new oiy(this);
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private ngv jdField_a_of_type_Ngv;
  private nik jdField_a_of_type_Nik;
  private ocr jdField_a_of_type_Ocr = new ocr();
  private View b;
  
  private void a(int paramInt)
  {
    ohb.a().a(new oiz(this, paramInt));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        oab.a(paramIntent);
      } while (!a());
      paramIntent = obz.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.c();
    localKandianMergeManager.r();
    obz.f(paramIntent);
    obz.a(false);
  }
  
  private void a(String paramString)
  {
    if (odm.b(odm.b())) {}
    for (String str = "0X80089D1";; str = "0X80098B0")
    {
      ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.3(this, paramString, str));
      return;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  private void b()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.5(this));
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(obz.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131299323)).inflate();
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
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pmv.a().a(pmv.d, 1);
    rrl.a();
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getIntent();
      if (paramBundle != null) {
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
      }
      a(paramBundle);
    }
    ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
    peq.a().a();
    a(0);
    b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    oel.a();
    odm.b();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494320, paramViewGroup, false);
    ohp.b(0, oab.a(), 0);
    odm.b();
    this.jdField_a_of_type_Nik = new nik(getActivity());
    this.jdField_a_of_type_Nik.a(odm.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131309089);
    this.jdField_a_of_type_Nik.a(paramLayoutInflater);
    this.jdField_a_of_type_Nik.a();
    this.jdField_a_of_type_Ngv = new ngv(this.jdField_a_of_type_Nik.a());
    this.jdField_a_of_type_Ngv.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Ngv.a(this.jdField_a_of_type_AndroidViewView);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    rrl.b();
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.d();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    peq.a().b();
    a(5);
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Ngv.a();
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
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.i();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.g();
    }
    ApngImage.pauseByTag(31);
    a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.h();
    }
    RecommendFeedsDiandianEntranceManager.a().a();
    ApngImage.playByTag(31);
    a(2);
    ndn.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.e();
    }
    if (this.jdField_a_of_type_Ocr != null) {
      this.jdField_a_of_type_Ocr.a();
    }
    a(1);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Nik != null) {
      this.jdField_a_of_type_Nik.f();
    }
    if ((!BaseActivity.mAppForground) && (this.jdField_a_of_type_Ocr != null)) {
      this.jdField_a_of_type_Ocr.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_Nik != null) {
        this.jdField_a_of_type_Nik.c();
      }
      pmv.a().c();
      ohp.b(1, oab.a(), oab.b());
      a(oab.a());
      oab.b();
    }
    a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */