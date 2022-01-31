package com.tencent.biz.pubaccount.readinjoy.view;

import aanv;
import aekt;
import alpo;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import bdiv;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.SkinPullRefreshHeader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.List;
import nrt;
import org.json.JSONException;
import orz;
import qiu;
import qjs;
import rxo;
import rxp;
import rxq;
import rxr;
import rxs;
import rxt;
import rxu;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class SlideActiveAnimController
  implements Animator.AnimatorListener, Runnable
{
  private static int j = 1;
  private static int k = 2;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  ReadInJoySkinSlideDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView;
  public ReadInJoyXListView a;
  public ReadInjoySlideAnimLayout a;
  SkinPullRefreshHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader;
  Runnable jdField_a_of_type_JavaLangRunnable = new SlideActiveAnimController.8(this);
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  public boolean c;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  public boolean d;
  int e;
  public boolean e;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  private int i;
  private int l = j;
  
  public SlideActiveAnimController(int paramInt, Activity paramActivity, ReadInjoySlideAnimLayout paramReadInjoySlideAnimLayout, ReadInJoyXListView paramReadInJoyXListView, View paramView1, View paramView2, Runnable paramRunnable)
  {
    this.jdField_g_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(new rxo(this));
    this.jdField_d_of_type_AndroidViewView = paramActivity.findViewById(2131379430);
    this.jdField_a_of_type_AndroidViewView = paramActivity.findViewById(2131376969);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_c_of_type_AndroidViewView = paramActivity.findViewById(2131372976);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout = paramReadInjoySlideAnimLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(4);
    this.jdField_a_of_type_Int = paramActivity.getResources().getDimensionPixelSize(2131298665);
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int * 3);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new rxp(this, paramRunnable);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    String str;
    if ((localObject instanceof BaseActivity))
    {
      bdiv.v((Context)localObject, ((BaseActivity)localObject).getCurrentAccountUin());
      str = ((qiu)((BaseActivity)localObject).app.getManager(270)).a();
      localObject = new orz();
    }
    for (;;)
    {
      try
      {
        ((orz)localObject).b().c().a(paramInt).e().f().g().h().a(str).d(0).e(2).a();
        if (!TextUtils.isEmpty(paramString)) {
          continue;
        }
        paramInt = 0;
        ((orz)localObject).a("image_jump", String.valueOf(paramInt));
        if (!paramBoolean) {
          continue;
        }
        paramInt = 1;
        ((orz)localObject).a("ad_page", paramInt);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      nrt.a(null, "CliOper", "", "", "0X800969B", "0X800969B", 0, 0, bjxj.a("default_feeds_proteus_offline_bid"), "", "", ((orz)localObject).a(), false);
      return;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  public static void a(View paramView)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout;
    if (paramBoolean) {}
    for (int m = 0;; m = 4)
    {
      localReadInjoySlideAnimLayout.setVisibility(m);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a.setTranslationY(-this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getHeight());
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isDirectory()));
    return true;
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (!a(paramString2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView = null;
    }
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView = new ReadInJoySkinSlideDownView(this.jdField_g_of_type_Int, this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface, paramString1, paramString2, paramInt, new rxq(this), null, new rxr(this));
    QLog.i("SlideActiveAnimController", 1, "makeAndAddPosterView current state id = " + paramString1 + ",rootPath = " + paramString2 + ",manager = " + paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setContentView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
  }
  
  private boolean d()
  {
    long l1 = System.currentTimeMillis();
    return (this.jdField_a_of_type_Long != -1L) && (l1 - this.jdField_a_of_type_Long >= 300L);
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView != null;
  }
  
  private boolean f()
  {
    return qjs.b() == 1;
  }
  
  private boolean g()
  {
    return true;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getVisibility() != 0)
    {
      int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a.setTranslationY(-m);
    }
  }
  
  private void k()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.smoothScrollBy(0, 0);
    l();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setMessage(false, "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(0);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    a(true);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setDisableContentTouch(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setDisableContentTouch(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
  }
  
  private void n()
  {
    float f1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a.getTranslationY();
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, f1 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rxs(this, f1));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void o()
  {
    if ((!this.jdField_c_of_type_Boolean) || (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity))) {}
    do
    {
      return;
      Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      this.jdField_e_of_type_Int = localWindow.getAttributes().flags;
      localWindow.setFlags(1024, 1024);
    } while ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp == null));
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarVisible(2, 0);
  }
  
  private void p()
  {
    if ((!this.jdField_c_of_type_Boolean) || (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity))) {}
    do
    {
      return;
      Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      localWindow.clearFlags(1024);
      localWindow.addFlags(this.jdField_e_of_type_Int);
    } while ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp == null));
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarVisible(0, 0);
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) && (this.jdField_f_of_type_Boolean)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.l == k);
        if (QLog.isColorLevel()) {
          QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim enter");
        }
        if (this.i != 0) {
          break;
        }
        this.i = this.jdField_a_of_type_AndroidViewView.getHeight();
        if (this.i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim return3 : mOriginHeadHeight=" + this.i);
      return;
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rxt(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new rxu(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    } while (!QLog.isColorLevel());
    QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim mHeadAnimator start");
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } while (this.l == j);
    this.jdField_f_of_type_Boolean = false;
    this.l = j;
    this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    p();
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void u()
  {
    this.h = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.springBackOverScrollHeaderView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setTranslationY(0.0F);
    if (e()) {
      m();
    }
  }
  
  private void v()
  {
    x();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    r();
    w();
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void w()
  {
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getHeight();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a.setTranslationY(-m);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(4);
  }
  
  private void x()
  {
    long l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    if (l1 > 0L) {}
    try
    {
      nrt.a(null, "CliOper", "", "", "0X800A1A6", "0X800A1A6", 0, 0, bjxj.a("default_feeds_proteus_offline_bid"), "", "", new orz().a("duration", (int)l1).a(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a()
  {
    j();
    this.i = this.jdField_a_of_type_AndroidViewView.getHeight();
    this.jdField_b_of_type_Int = (aekt.a(210.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - this.i);
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader)
  {
    this.jdField_g_of_type_Boolean = true;
    this.h = 0;
    r();
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader, int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader = paramSkinPullRefreshHeader;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_g_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
      } while ((f()) && (!e()));
      if (paramInt1 >= this.jdField_b_of_type_Int)
      {
        if (f())
        {
          paramSkinPullRefreshHeader.a(true, alpo.a(2131714573));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setMessage(true, alpo.a(2131714570));
          s();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.c();
        }
        q();
        return;
      }
      if (paramInt1 < this.jdField_a_of_type_Int) {
        break;
      }
      if (paramInt1 >= this.i - this.jdField_a_of_type_Int) {
        q();
      }
    } while (!f());
    paramSkinPullRefreshHeader.a(true, alpo.a(2131714572));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setMessage(true, alpo.a(2131714571));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.b();
    return;
    if (f())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setMessage(false, "");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(4);
      paramSkinPullRefreshHeader.a(false, "");
    }
    r();
    t();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (!f()) {
      return;
    }
    QLog.i("SlideActiveAnimController", 1, "setGuideAttrs id = " + paramString1 + ",rootPath = " + paramString2 + ",manager = " + paramInt + ",guideView = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
    QLog.i("SlideActiveAnimController", 1, "setGuideAttrs current state id = " + this.jdField_a_of_type_JavaLangString + ",rootPath = " + this.jdField_b_of_type_JavaLangString + ",manager = " + this.jdField_d_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView == null) {
      b(paramString1, paramString2, paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_d_of_type_Int = paramInt;
      return;
      if ((!paramString1.equals(this.jdField_a_of_type_JavaLangString)) || (!paramString2.equals(this.jdField_b_of_type_JavaLangString)) || (paramInt != this.jdField_d_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView = null;
        b(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      if (!f()) {
        break;
      }
      bool1 = bool2;
    } while (!e());
    if ((f()) && (this.h >= this.jdField_b_of_type_Int) && (d()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.isTouchHolding = false;
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader.a(false, "");
      return true;
    }
    if (this.l == k) {
      r();
    }
    for (;;)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader.a(false, "");
      return false;
      if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()))
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
        r();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((f()) && (!e())) {}
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        return false;
      case 0: 
        if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
          return true;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a() != 6) {
          break;
        }
      }
      for (this.jdField_e_of_type_Boolean = true; (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean); this.jdField_e_of_type_Boolean = false) {
        return true;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    k();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.post(this);
  }
  
  public boolean b()
  {
    return (f()) || (g());
  }
  
  public void c()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.h = 0;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      v();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable.run();
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    u();
    if (!this.jdField_b_of_type_Boolean) {
      v();
    }
    do
    {
      return;
      m();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.c();
  }
  
  public void e()
  {
    if (!this.jdField_d_of_type_Boolean) {
      x();
    }
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a();
    }
    i();
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = -1;
    h();
    u();
    v();
  }
  
  public void h()
  {
    if (e())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      QLog.d("SlideActiveAnimController", 1, "removeOnGlobalLayoutListener");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Boolean = false;
    u();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    boolean bool = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    u();
    int m;
    Object localObject;
    if (e())
    {
      paramAnimator = qiu.b(this.jdField_a_of_type_AndroidAppActivity, 0);
      m = this.jdField_g_of_type_Int;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a();
      if ((paramAnimator == null) || (!paramAnimator.isAD)) {
        break label161;
      }
    }
    for (;;)
    {
      a(m, (String)localObject, bool);
      if ((paramAnimator != null) && (paramAnimator.isAD) && (paramAnimator.adExposureReports != null) && (paramAnimator.adExposureReports.size() > 0)) {}
      try
      {
        localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
        long l1 = paramAnimator.adId.longValue();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.trace_info.aid.set(l1);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(paramAnimator.getUrls(paramAnimator.adExposureReports));
        aanv.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject);
        return;
      }
      catch (NumberFormatException paramAnimator)
      {
        label161:
        paramAnimator.printStackTrace();
      }
      bool = false;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void run()
  {
    this.jdField_b_of_type_Boolean = true;
    n();
    q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController
 * JD-Core Version:    0.7.0.1
 */