package com.tencent.av.ui;

import actn;
import ajyc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axqw;
import bbcv;
import bbdr;
import bbgg;
import bbon;
import bflh;
import bkur;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import lcl;
import ldc;
import lgf;
import lgg;
import lhz;
import liz;
import ljb;
import lkx;
import lmb;
import lme;
import los;
import lsv;
import ltr;
import lzb;
import lzj;
import mat;
import mck;
import mco;
import mcq;
import mcu;
import mcv;
import mcw;
import mcx;
import mcy;
import mcz;
import mhf;
import mho;
import miq;
import mjr;
import mlr;
import mmn;
import mqk;
import mqq;
import mqx;
import mqz;
import mrh;
import msq;
import mta;
import mtf;
import mtt;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  private long jdField_a_of_type_Long = -1L;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  DoubleVideoCtrlUI.StartTimerRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable = new DoubleVideoCtrlUI.StartTimerRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.1(this);
  Timer jdField_a_of_type_JavaUtilTimer = null;
  mcz jdField_a_of_type_Mcz = new mcz(null);
  mho jdField_a_of_type_Mho = null;
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.2(this);
  public boolean b;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.3(this);
  boolean jdField_c_of_type_Boolean = false;
  Runnable jdField_d_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.16(this);
  boolean jdField_d_of_type_Boolean = false;
  Runnable e;
  public boolean e;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mck parammck)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammck);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.17(this);
  }
  
  private ChildLockSign a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131372228);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockSign((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365325);
          Resources localResources = ((ViewGroup)localObject2).getResources();
          int i = localResources.getDimensionPixelOffset(2131297490);
          int j = localResources.getDimensionPixelOffset(2131297487);
          int k = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
          int m = localResources.getDimensionPixelOffset(2131297488);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, m, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          ((ChildLockSign)localObject1).setVisibility(8);
        }
      }
    }
    return localObject1;
  }
  
  private void a(long paramLong, String paramString)
  {
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      bool = true;
      locallgf.jdField_g_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label130;
      }
      ltr.a().a(32);
      super.k(2131372214);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(true, paramString);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372214, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690265));
    }
    for (;;)
    {
      mqz.c(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool = false;
      break;
      label130:
      ltr.a().b(32);
      super.l(2131372214);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, paramString);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372214, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690256));
    }
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    VideoController localVideoController = paramVideoAppInterface.a();
    lgf locallgf = localVideoController.a();
    String str = locallgf.jdField_d_of_type_JavaLangString;
    int i;
    if (paramBoolean) {
      if (locallgf.a(localVideoController)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "sendAddMemberBroadcast, peerUin[" + str + "], supportUinType[" + i + "], fromDoubleMeeting[" + paramBoolean + "], activity[" + paramActivity + "]");
      }
      if (i == 1) {}
      for (int j = 1;; j = 2)
      {
        axqw.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
        if ((i != 3000) || (paramActivity == null) || (!msq.e())) {
          break label295;
        }
        paramVideoAppInterface = msq.a();
        bbcv.a(paramActivity, 230, null, paramVideoAppInterface, "", ajyc.a(2131703434), new mcw(), null).show();
        if (QLog.isColorLevel()) {
          QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + paramVideoAppInterface + "]");
        }
        axqw.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
        return;
        i = 3000;
        break;
        if (!locallgf.b(localVideoController)) {
          break label351;
        }
        i = 1;
        break;
      }
      label295:
      paramActivity = new Intent();
      paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramActivity.putExtra("peerUin", str);
      paramActivity.putExtra("supportUinType", i);
      paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
      paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
      return;
      label351:
      i = 3000;
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface)
  {
    int i = 2131695729;
    VideoController localVideoController = paramVideoAppInterface.a();
    String str = localVideoController.a().jdField_d_of_type_JavaLangString;
    int j = localVideoController.b(str);
    int k = localVideoController.c(str);
    if (localVideoController.a().jdField_i_of_type_Int == 1011) {
      if (k >= 45) {
        break label130;
      }
    }
    while (i != 0)
    {
      mat.a(paramVideoAppInterface, 1012, i);
      return;
      if (!lmb.f()) {
        i = 2131720797;
      } else if (lsv.a(localVideoController.a()) == 1) {
        i = 2131720733;
      } else if (k < 16) {
        i = 2131695730;
      } else if ((j == 4) || (j == 2) || (j == 3)) {
        label130:
        i = 0;
      }
    }
    mat.a(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    int i = 0;
    int j = paramVideoAppInterface.a().a().jdField_a_of_type_Lgg.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt > 0)
    {
      mat.a(paramVideoAppInterface, 1048, paramInt);
      return;
      if ((j == 3) || (j == 1))
      {
        paramInt = 2131696239;
      }
      else
      {
        paramInt = 2131696238;
        continue;
        if ((j == 3) || (j == 1))
        {
          paramInt = 2131696234;
        }
        else
        {
          paramInt = 2131696233;
          continue;
          if ((j == 3) || (j == 1)) {
            paramInt = 2131696236;
          } else {
            paramInt = 2131696235;
          }
        }
      }
    }
    mat.a(paramVideoAppInterface, 1048);
  }
  
  private boolean c()
  {
    long l = System.currentTimeMillis();
    if (l > this.jdField_a_of_type_Long + 200L)
    {
      this.jdField_a_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "StartGlassCheck, cancel old Timer");
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    DoubleVideoCtrlUI.5 local5 = new DoubleVideoCtrlUI.5(this, paramBoolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "StartGlassCheck, begin Timer, bCheck[" + paramBoolean + "]");
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 10000L)
    {
      localTimer.schedule(local5, l);
      return;
    }
  }
  
  private void i(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    paramView = new mco(paramView);
    paramView.a(paramLong, "onClick_InviteMember");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9000), paramView });
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "onClick_InviteMember block[" + paramView.jdField_b_of_type_Boolean + "]");
    }
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_InviteMember, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695652);
      return;
      mqz.g(this.jdField_a_of_type_ComTencentAvVideoController);
      a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if ((lzj.f()) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
      {
        paramView = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView != null)
        {
          paramView = paramView.a();
          if (paramView != null) {
            paramView.c();
          }
        }
      }
    }
  }
  
  private void v()
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setForground, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "]");
    if (this.jdField_p_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_Boolean) || (ldc.a().a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.c();
  }
  
  protected int a()
  {
    return 2131559506;
  }
  
  public int a(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  ChildLockCircle a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131372225);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365325);
          localObject3 = ((ViewGroup)localObject2).getResources();
          int i = ((Resources)localObject3).getDimensionPixelOffset(2131297486);
          int j = ((Resources)localObject3).getDimensionPixelOffset(2131297485);
          int k = ((Resources)localObject3).getDimensionPixelOffset(2131297687);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, 0, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          ((ChildLockCircle)localObject1).a();
        }
      }
    }
    return localObject1;
  }
  
  public void a() {}
  
  void a(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onTerSwitchSyncStatus, cameraStatus[" + paramInt1 + "], micStatus[" + paramInt2 + "]");
    }
    if (g()) {
      return;
    }
    if (paramInt1 == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      label104:
      lgf locallgf;
      if (paramInt1 == 0)
      {
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramInt1 == 0) && (!locallgf.jdField_k_of_type_Boolean)) {
          break label308;
        }
        if (locallgf.jdField_d_of_type_Int == 1)
        {
          locallgf.a(l, "onTerSwitchSyncStatus.1", 2);
          a("onTerSwitchSyncStatus.1", locallgf.jdField_d_of_type_Int);
        }
        label156:
        if (paramInt2 != 0) {
          break label342;
        }
      }
      String str;
      label308:
      label342:
      for (boolean bool = true;; bool = false)
      {
        locallgf.jdField_g_of_type_Boolean = bool;
        str = locallgf.jdField_d_of_type_JavaLangString;
        if (!locallgf.jdField_g_of_type_Boolean) {
          break label348;
        }
        super.k(2131372214);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372214, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690265));
        return;
        i(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
        break label104;
        if (locallgf.jdField_d_of_type_Int != 2) {
          break label156;
        }
        locallgf.a(l, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", locallgf.jdField_d_of_type_Int);
        break label156;
      }
      label348:
      super.l(2131372214);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372214, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690256));
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    View localView1;
    View localView2;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372511);
      localView2 = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372512);
      if (AudioHelper.a(0) == 1)
      {
        localView1.setBackgroundColor(2147460352);
        localView2.setBackgroundColor(2147460352);
      }
      if (localView1 != null)
      {
        localLayoutParams1 = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams1 != null)
        {
          if (!k()) {
            break label173;
          }
          if (paramBoolean) {
            break label145;
          }
          localLayoutParams1.topMargin = (paramInt - c() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
        }
      }
    }
    for (;;)
    {
      localLayoutParams2.topMargin = localLayoutParams1.topMargin;
      localView1.setLayoutParams(localLayoutParams1);
      localView2.setLayoutParams(localLayoutParams2);
      return;
      label145:
      localLayoutParams1.topMargin = (-c() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
      continue;
      label173:
      if (!paramBoolean)
      {
        localLayoutParams1.topMargin = (paramInt - c() + actn.a(15.0F, this.jdField_a_of_type_AndroidContentResResources));
        if (bkur.b())
        {
          paramInt = localLayoutParams1.topMargin;
          localLayoutParams1.topMargin = (bkur.b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()) + paramInt);
        }
      }
      else
      {
        localLayoutParams1.topMargin = actn.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131372216) || (paramInt1 == 2131372217)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372216, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372216, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        if (!AVReport.a().jdField_a_of_type_Boolean) {
          break label196;
        }
        liz.a(29);
        AVReport.a().j = SystemClock.elapsedRealtime();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int < 0) {
          break label420;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1011) {
          break label208;
        }
        g(-1015L, 2131695740);
        if (this.jdField_a_of_type_Mta != null) {
          this.jdField_a_of_type_Mta.b();
        }
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 20000L);
      }
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().x)) {
          break label437;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().w = false;
        d(false);
      }
      return;
      label196:
      AVReport.a().y = SystemClock.elapsedRealtime();
      break;
      label208:
      g(-1015L, 2131695677);
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().b;
      String str = bbon.a(l, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          mtt.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int;
        axqw.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Mta == null) {
          break label418;
        }
        this.jdField_a_of_type_Mta.c();
        this.jdField_a_of_type_Mta.d();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          mtt.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
        }
      }
      label418:
      continue;
      label420:
      if (this.jdField_a_of_type_Mta != null) {
        this.jdField_a_of_type_Mta.b();
      }
    }
    label437:
    s();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], seq[" + paramLong + "]");
    }
    s();
    super.a(paramLong, paramInt);
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int k = locallgf.jdField_i_of_type_Int;
    int i;
    int j;
    label100:
    Object localObject;
    if (locallgf.jdField_d_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label524;
      }
      j = 1;
      if (((locallgf.m()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((locallgf.n()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26)))) {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          mqz.p(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mcu(this, paramLong));
          N();
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClose phoneNumber is " + (String)localObject);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 3)) {
            break label544;
          }
          if (Build.VERSION.SDK_INT < 17) {
            break label530;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372200, 8);
          localObject = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372213);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((Button)localObject).getLayoutParams();
          localLayoutParams.rightMargin = 0;
          localLayoutParams.removeRule(11);
          localLayoutParams.addRule(14);
          ((Button)localObject).setLayoutParams(localLayoutParams);
        }
      }
    }
    for (;;)
    {
      if (paramInt == 3) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372519, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372213, true);
      localObject = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localObject != null) {
        ((EffectOperateManager)localObject).b(false);
      }
      if (this.jdField_a_of_type_Mta != null)
      {
        this.jdField_a_of_type_Mta.c();
        this.jdField_a_of_type_Mta.e();
        this.jdField_a_of_type_Mta.a();
        this.jdField_a_of_type_Mta = null;
      }
      this.jdField_a_of_type_Boolean = true;
      if ((locallgf.j()) && (locallgf.jdField_d_of_type_Int == 2) && (!locallgf.jdField_j_of_type_Boolean)) {
        mqz.e();
      }
      locallgf.jdField_g_of_type_Boolean = false;
      if (paramInt == 24)
      {
        this.i = true;
        g(paramLong, 2131696122);
      }
      if (paramInt == 42) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      return;
      i = 0;
      break;
      label524:
      j = 0;
      break label100;
      label530:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372200, false);
      continue;
      label544:
      axqw.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372200, true);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick mVideoController == null");
    }
    String str1;
    Object localObject;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick mQavPanel == null");
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().w)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick isChildLock");
          return;
        }
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)));
      str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      localObject = a();
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364067: 
      case 2131365050: 
      case 2131372514: 
        P();
        return;
      case 2131695653: 
        f(paramLong);
        return;
      case 2131372516: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
        lhz.f(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) + "");
        this.jdField_b_of_type_Mck.update(null, new Object[] { Integer.valueOf(134) });
        return;
      case 2131372208: 
      case 2131372209: 
      case 2131372210: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick Hangup ");
        a(paramView);
        return;
      case 2131372206: 
        bool = c();
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + bool);
      }
    } while (!bool);
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().N;
    paramView = this.jdField_a_of_type_ComTencentAvVideoController;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      mqz.a(paramView, bool);
      if (this.jdField_a_of_type_Mtt == null) {
        break;
      }
      this.jdField_a_of_type_Mtt.a(mtt.c);
      return;
    }
    c(paramLong, paramView);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick HIDE ");
    this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
    ldj.a = "3";
    a();
    mqz.b(this.jdField_a_of_type_ComTencentAvVideoController);
    return;
    d(paramLong, paramView);
    return;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    mqz.a(paramView.getId(), i);
    a((AVActivity)localObject, str1);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
    i(paramLong, paramView);
    return;
    e(paramLong, paramView);
    return;
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
    mqq.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Boolean)
    {
      bool = true;
      label738:
      paramView.jdField_l_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Boolean) {
        break label829;
      }
      axqw.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
    }
    for (i = 2131692973; this.jdField_a_of_type_ComTencentAvUiQavPanel != null; i = 2131692972)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372519, this.jdField_a_of_type_AndroidContentResResources.getString(i));
      return;
      bool = false;
      break label738;
      label829:
      axqw.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      mtt.a().b(paramLong);
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject, str2, true);
    }
    mqz.q(this.jdField_a_of_type_ComTencentAvVideoController);
    this.jdField_a_of_type_ComTencentAvVideoController.b(str1, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Int);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Voice");
    g(paramLong, paramView);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Effect");
    h(paramLong, paramView);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
    this.jdField_a_of_type_ComTencentAvVideoController.a(str1, 1, 5, 1);
    a(2131696195, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298865));
    return;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      i = 1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 1) {
        break label1192;
      }
    }
    label1192:
    for (int j = 1;; j = 3)
    {
      axqw.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
      paramView = new Intent((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
      paramView.putExtra("url", "https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process");
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
      j(paramLong, 2131695656);
      return;
      i = 2;
      break;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
    axqw.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.a().v + 1, 0, "", "", "", "");
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g("Sharpness");
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() == 1) {
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(paramLong);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Mhf.b();
    return;
    f(paramLong, paramView);
    return;
    b(paramLong, paramView);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setTitleText, mRingAnimator[" + this.jdField_a_of_type_Mta.jdField_a_of_type_Boolean + "], startRingAnimator[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (!TextUtils.isEmpty(paramString)) {
      d(paramLong, paramString);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Mta != null))
    {
      this.jdField_a_of_type_Mta.c();
      this.jdField_a_of_type_Mta.d();
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    f(paramLong, 65535);
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((i == 2) && (lsv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) && (paramBoolean) && (locallgf.j()))
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      axqw.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
    }
    e();
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (g()) {
      return;
    }
    AVActivity localAVActivity = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    boolean bool;
    if (localAVActivity != null) {
      if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], isConnected[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int + "], mCameraNum[" + this.jdField_o_of_type_Int + "], remoteHasVideo[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean + "], checkCameraResult[" + bool + "], seq[" + paramLong + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372515, 0);
        localAVActivity = a();
        if (localAVActivity != null) {
          localAVActivity.a(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean = true;
        if ((paramInt == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().N) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString))) {
          this.jdField_a_of_type_Mtt.d();
        }
        mqz.c();
        mqz.m(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j())) {
          a("onAfterOpenCamera", 2);
        }
        z(paramLong);
      }
      f(paramLong, 65535);
      return;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  void a(Bitmap paramBitmap)
  {
    paramBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  void a(View paramView)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Hangup, seq[" + l + "]");
    int i = paramView.getId();
    if ((i == 2131372208) || (i == 2131372209)) {
      lcl.d(this.jdField_c_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramView = new mco(paramView);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.jdField_b_of_type_Boolean) {
        break;
      }
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Hangup, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
      return;
      if (i == 2131372210) {
        lcl.d(this.jdField_c_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    g(true);
    this.jdField_a_of_type_Mho.a(new mcx(this, l, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i + "], PhoneNum[" + AudioHelper.a(this.jdField_a_of_type_ComTencentAvVideoController.a().a()) + "]");
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().a())));
    axqw.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(paramString, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setQCallNickName");
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    super.a(paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    boolean bool2 = true;
    long l = AudioHelper.b();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "avSwitch[" + paramString + "], sessionType[" + paramInt + "], seq[" + l + "]");
    if (this.jdField_a_of_type_Mtt != null) {
      this.jdField_a_of_type_Mtt.a();
    }
    mtf localmtf;
    if (paramInt == 1)
    {
      o();
      d(l, false);
      f(l, 65535);
      e(0);
      new mcq(l, "avSwitch", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      localmtf = this.jdField_a_of_type_Mtf;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label227;
      }
      bool1 = true;
      label150:
      localmtf.c(bool1);
      localmtf = this.jdField_a_of_type_Mtf;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label232;
      }
    }
    label227:
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmtf.b(bool1);
      c(l, paramString + "_avSwitch");
      return;
      if (paramInt != 2) {
        break;
      }
      d(l, true);
      break;
      bool1 = false;
      break label150;
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setQCallHead uin = " + paramString);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lgf locallgf;
    int i;
    label289:
    label379:
    do
    {
      do
      {
        long l;
        do
        {
          return;
          locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
          l = AudioHelper.b();
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onInviteReached, peerUin[" + paramString1 + "], showMsg[" + paramString2 + "], remotePhoneState[" + locallgf.jdField_n_of_type_Int + "], remoteTerminal[" + locallgf.jdField_k_of_type_Int + "], phoneOnLine[" + locallgf.jdField_m_of_type_Int + "], pcOnLine[" + locallgf.jdField_l_of_type_Int + "], subState[" + locallgf.jdField_d_of_type_Long + "], isPeerNetworkWell[" + locallgf.jdField_q_of_type_Boolean + "], seq[" + l + "]");
        } while ((!locallgf.f()) || (locallgf.ag) || (locallgf.jdField_i_of_type_Int == 1011) || (!locallgf.jdField_d_of_type_JavaLangString.contains(paramString1)));
        i = locallgf.jdField_n_of_type_Int;
        if (i >= 0)
        {
          if (TextUtils.isEmpty(paramString2)) {
            g(l, 2131695677);
          }
        }
        else {
          if (locallgf.jdField_d_of_type_Long != 0L) {
            break label289;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Mta != null)
          {
            this.jdField_a_of_type_Mta.c();
            this.jdField_a_of_type_Mta.d();
          }
          if ((i <= 0) || (i == 3)) {
            break label379;
          }
          a(i);
          mqz.e(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          d(l, paramString2);
          break;
          if (locallgf.jdField_d_of_type_Long == 2L)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(locallgf.jdField_d_of_type_JavaLangString, 8, 0L);
            if (!TextUtils.isEmpty(locallgf.jdField_o_of_type_JavaLangString)) {
              mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3008, locallgf.jdField_o_of_type_JavaLangString);
            }
            axqw.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
          }
        }
        if (i != 4) {
          break;
        }
      } while ((locallgf.jdField_l_of_type_Int != 1) || (locallgf.jdField_m_of_type_Int != 0));
      a(i);
      return;
    } while ((i != 0) || (!locallgf.jdField_q_of_type_Boolean) || (locallgf.jdField_k_of_type_Int == 2) || (locallgf.jdField_d_of_type_Int != 1));
    mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onPeerSwitchTerminal, peerUin[" + paramString + "], bStartSwitch[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
    }
    for (;;)
    {
      f(l, 65535);
      paramString = lme.a();
      if (!paramBoolean) {
        break;
      }
      paramString.jdField_b_of_type_Boolean = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.jdField_b_of_type_Boolean);
      }
      lzj.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.A();
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363370);
      if (localView != null)
      {
        if ((!paramBoolean) || (localView.getVisibility() == 0)) {
          break label39;
        }
        localView.setVisibility(0);
      }
    }
    label39:
    while ((paramBoolean) || (localView.getVisibility() == 8)) {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt, false);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    boolean bool = false;
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      i = j;
      if (paramBoolean1) {
        i = 0;
      }
      ((RelativeLayout)localObject).setVisibility(i);
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramBoolean2))
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
          paramBoolean2 = bool;
          if (!paramBoolean1) {
            paramBoolean2 = true;
          }
          ((QavPanel)localObject).c(paramBoolean2);
        }
        new mjr(this.jdField_a_of_type_AndroidViewViewGroup).a(paramBoolean1);
      }
      c(-1035L, "changeToDoubleScreen");
      return;
    }
  }
  
  public boolean a()
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onBackPressed, seq[" + l + "], isChildLock[" + ((lgf)localObject).w + "]");
    if (((lgf)localObject).w) {
      return true;
    }
    if (super.a())
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onBackPressed called return 2, seq[" + l + "]");
      return true;
    }
    v();
    String str = ((lgf)localObject).jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((!lzj.f()) && (((lgf)localObject).jdField_d_of_type_Int == 2) && (((lgf)localObject).jdField_j_of_type_Boolean)) {
      a(2131695803, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298865));
    }
    if ((((lgf)localObject).m()) || (((lgf)localObject).n()))
    {
      j(((lgf)localObject).jdField_y_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.13(this, l), 150L);
    }
    if (lzj.f())
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((lzb)localObject).a();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject == null) {
      return false;
    }
    if (!((lgf)localObject).aw) {
      return false;
    }
    if (!((lgf)localObject).jdField_k_of_type_Boolean)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + paramInt + "]");
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((lgf)localObject).jdField_Q_of_type_Int != paramInt)) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setGlassSwitch, GlassSwitch[" + ((lgf)localObject).jdField_Q_of_type_Int + "->" + paramInt + "]");
    }
    if (((lgf)localObject).jdField_Q_of_type_Int == paramInt) {
      return false;
    }
    ((lgf)localObject).jdField_Q_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return false;
    }
    localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject == null) || (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)) {
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1039);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().w) {
        bool = true;
      }
      return bool;
    }
    this.jdField_a_of_type_Mtt.a();
    return false;
  }
  
  void b()
  {
    super.b();
    long l = AudioHelper.b();
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
      {
        bool = true;
        localQavPanel.a(2131559554, bool, BeautyToolbar.checkShowBeauty(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
        this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtt);
      }
    }
    else
    {
      d(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370647));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372516));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372244));
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147483392);
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "need reset quit double screen listener");
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new mcy(this));
      }
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372235));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label454;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372208, this.jdField_a_of_type_AndroidContentResResources.getString(2131690263));
      }
      d(l, false);
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372214, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372214, false);
      }
      c(l, "initUI");
      this.jdField_a_of_type_Mho = new mho((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372254), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372385), null);
      mrh.a(BaseApplicationImpl.getApplication());
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 0))) {
        axqw.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
      }
      return;
      bool = false;
      break;
      label454:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372208, this.jdField_a_of_type_AndroidContentResResources.getString(2131720746));
      }
      d(l, true);
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011) && (paramInt != 2131695740) && (paramInt != 2131720740)) {}
    while (paramInt <= 0) {
      return;
    }
    g(-1016L, paramInt);
  }
  
  public void b(long paramLong)
  {
    boolean bool2 = false;
    super.b(paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((lgf)localObject1).j())
    {
      if (((lgf)localObject1).jdField_d_of_type_Long != 1L) {
        super.x(paramLong);
      }
      localObject2 = this.jdField_a_of_type_Mtf;
      if (((lgf)localObject1).jdField_d_of_type_Int != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((mtf)localObject2).b(bool1);
      o();
      mqz.a(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_d_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!((lgf)localObject1).aw)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.9(this), 200L);
      return;
    }
    localObject1 = this.jdField_c_of_type_JavaLangString;
    Object localObject2 = new StringBuilder().append("onResume, AsyncReadDoubleGlassConfig, mVideoController[");
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      bool1 = true;
    }
    QLog.w((String)localObject1, 1, bool1 + "]");
    c();
  }
  
  @TargetApi(11)
  public void b(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean)) {
      a(paramLong, 360 - paramInt);
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372225);
        }
      }
      if (localObject1 != null) {
        ((ChildLockCircle)localObject1).setRotation(360 - paramInt);
      }
      return;
      a(paramLong, 0.0F);
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    paramView = a();
    if (paramView != null)
    {
      if (!paramView.jdField_a_of_type_Mmn.a()) {
        break label44;
      }
      paramView.jdField_a_of_type_Mmn.c(3);
    }
    for (;;)
    {
      lkx.a("0X800A8D0");
      return;
      label44:
      paramView.jdField_a_of_type_Mmn.a(0);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      f(paramLong, 65535);
    }
  }
  
  public void b(String paramString) {}
  
  void b(boolean paramBoolean)
  {
    int i = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_Mtt != null)
    {
      this.jdField_a_of_type_Mtt.a(paramBoolean);
      this.jdField_a_of_type_Mtt.a();
    }
    QavPanel localQavPanel;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.jdField_q_of_type_Boolean)) {
          break label135;
        }
        localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
        {
          paramBoolean = bool1;
          localQavPanel.a(paramBoolean, 0, false);
        }
      }
      else if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131165925));
      }
    }
    label135:
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
      paramBoolean = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
        paramBoolean = true;
      }
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (paramBoolean) {}
      for (;;)
      {
        localQavPanel.a(paramBoolean, i, true);
        break;
        i = 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_q_of_type_Boolean))
    {
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {}
      for (paramBoolean = bool3;; paramBoolean = false)
      {
        localQavPanel.a(paramBoolean, 0, false);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      paramBoolean = true;
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (!paramBoolean) {
        break label290;
      }
    }
    for (;;)
    {
      localQavPanel.a(paramBoolean, i, false);
      return;
      paramBoolean = false;
      break;
      label290:
      i = 1;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        if (paramBoolean2)
        {
          mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
          return;
        }
        mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1018);
      axqw.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
        localObject = new bflh((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
        if (mrh.a("qav_peer_phone_calling.mp3")) {
          ((bflh)localObject).a(l, 2, 0, null, mrh.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)
        {
          axqw.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
          ((bflh)localObject).a(l, 0, 2131230737, null, null, false, 1, false, true, 0);
          mrh.a(BaseApplicationImpl.getApplication());
        }
        axqw.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a().j();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.6(this), 100L);
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()))
    {
      if (!this.jdField_h_of_type_Boolean) {
        e(paramInt);
      }
      return;
    }
    e(paramInt);
    z(l);
  }
  
  public void c(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_p_of_type_Boolean)) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onStop, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
    }
    super.c(paramLong);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j())) {
      super.y(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
      {
        j(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDetectNoDevicePermission local close camera, remote[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean + "]");
        }
      }
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean = false;
      f(paramLong, 65535);
    }
    super.c(paramLong, paramInt);
  }
  
  void c(long paramLong, View paramView)
  {
    boolean bool = c();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean + "], localMute[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean + "], seq[" + paramLong + "], canClick[" + bool + "]");
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool))
    {
      q(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean);
      a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString);
    }
    super.z(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onAfterCloseCamera, success[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    f(paramLong, 65535);
    if (paramBoolean)
    {
      h(true);
      mqz.d();
      mqz.n(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) {
        a("onAfterCloseCamera", 1);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) {
        a(paramLong, 0.0F);
      }
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
    s();
  }
  
  public void c(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onNotRecvAudioData, bNotRecv[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      this.jdField_p_of_type_Int = 1;
    }
    while (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) == 5)
      {
        return;
        this.jdField_p_of_type_Int = 2;
      }
      else
      {
        mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) == 5) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L) {
        break;
      }
      super.x(l);
      return;
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
    }
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "avideo onCreate, state[" + ((lgf)localObject).jdField_g_of_type_Int + "], seq[" + l + "]");
    b();
    this.jdField_a_of_type_Mtt.c();
    if (((lgf)localObject).E == 0) {
      ((lgf)localObject).E = 3;
    }
    int j;
    int i;
    if ((((lgf)localObject).d()) || (((lgf)localObject).h()))
    {
      j = 1;
      if (((lgf)localObject).jdField_Q_of_type_Boolean) {
        j = 0;
      }
      i = 1;
      if (!((lgf)localObject).L) {
        i = 4;
      }
      if (1008 != ((lgf)localObject).jdField_i_of_type_Int) {
        break label1172;
      }
      i = 4;
    }
    label1172:
    for (;;)
    {
      if (((lgf)localObject).jdField_e_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lgf)localObject).jdField_d_of_type_JavaLangString, j, i);; i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lgf)localObject).jdField_d_of_type_JavaLangString, j, i, ((lgf)localObject).jdField_i_of_type_JavaLangString, ((lgf)localObject).jdField_j_of_type_JavaLangString, ((lgf)localObject).a(), ((lgf)localObject).jdField_i_of_type_Int, ((lgf)localObject).jdField_f_of_type_JavaLangString, ((lgf)localObject).jdField_g_of_type_JavaLangString, ((lgf)localObject).jdField_a_of_type_ArrayOfByte, null, null, 0, 0, null, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "result = " + i);
        }
        if (i == 0) {
          break;
        }
        lcl.d(this.jdField_c_of_type_JavaLangString, "Video connect fail:" + i);
        if (i == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(((lgf)localObject).jdField_d_of_type_JavaLangString, 238);
          this.jdField_a_of_type_ComTencentAvVideoController.b(238);
          this.jdField_a_of_type_ComTencentAvVideoController.b(((lgf)localObject).jdField_d_of_type_JavaLangString, 9);
        }
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ((Activity)localObject).finish();
          }
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onCreate, ofter Request, state[" + ((lgf)localObject).jdField_g_of_type_Int + "], SessionType[" + ((lgf)localObject).jdField_d_of_type_Int + "], deviceName[" + ((lgf)localObject).jdField_q_of_type_JavaLangString + "], seq[" + l + "]");
      }
      label481:
      label511:
      String str;
      if (((lgf)localObject).f())
      {
        if (((lgf)localObject).jdField_d_of_type_Int == 1)
        {
          this.jdField_d_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          this.jdField_a_of_type_Mtt.a(this.jdField_d_of_type_JavaLangString);
        }
      }
      else
      {
        if (!((lgf)localObject).j()) {
          break label739;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label691;
        }
        if (((lgf)localObject).jdField_d_of_type_Int == 2) {
          d(l, true);
        }
        i = ((lgf)localObject).jdField_i_of_type_Int;
        str = ((lgf)localObject).jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
        label549:
        if (((lgf)localObject).jdField_m_of_type_Boolean) {
          o();
        }
        if (((lgf)localObject).jdField_Q_of_type_Boolean)
        {
          this.jdField_a_of_type_Mtf.c(true);
          this.jdField_a_of_type_Mtf.c(true);
        }
        if (!((lgf)localObject).jdField_g_of_type_Boolean) {
          break label1118;
        }
        super.k(2131372214);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372214, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690265));
        }
      }
      for (;;)
      {
        a(l, false);
        this.jdField_a_of_type_AndroidViewViewGroup.post(new DoubleVideoCtrlUI.8(this));
        if (this.jdField_a_of_type_Mho == null) {
          break;
        }
        this.jdField_a_of_type_Mho.a();
        return;
        this.jdField_d_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label481;
        label691:
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) || (((lgf)localObject).jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.b(((lgf)localObject).jdField_d_of_type_JavaLangString) != 5)) {
          break label511;
        }
        mqz.f(this.jdField_a_of_type_ComTencentAvVideoController);
        break label511;
        label739:
        if (((lgf)localObject).i())
        {
          if (((lgf)localObject).jdField_Q_of_type_Boolean) {}
          for (i = 2131695812;; i = 2131720810)
          {
            b(i);
            break;
          }
        }
        if (((lgf)localObject).f())
        {
          i = 2131696149;
          if (((lgf)localObject).ag) {
            i = 2131696150;
          }
          if (((lgf)localObject).jdField_i_of_type_Int == 1011) {
            i = 2131695740;
          }
          if (((lgf)localObject).jdField_Q_of_type_Boolean)
          {
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "Inviting, remotePhoneState[" + ((lgf)localObject).jdField_n_of_type_Int + "], isPeerNetworkWell[" + ((lgf)localObject).jdField_q_of_type_Boolean + "], remoteOnline[" + ((lgf)localObject).r + "], remoteTerminal[" + ((lgf)localObject).jdField_k_of_type_Int + "]");
            if ((((lgf)localObject).jdField_n_of_type_Int == 0) && (((lgf)localObject).jdField_q_of_type_Boolean) && (((lgf)localObject).jdField_k_of_type_Int != 2) && (((lgf)localObject).jdField_d_of_type_Int == 1)) {
              mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
            }
          }
          b(i);
          i = ((lgf)localObject).jdField_i_of_type_Int;
          str = ((lgf)localObject).jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
          i = ((lgf)localObject).jdField_n_of_type_Int;
          if ((i == 4) && (((lgf)localObject).jdField_l_of_type_Int == 1) && (((lgf)localObject).jdField_m_of_type_Int == 0)) {
            a(i);
          }
          if ((i <= 0) || (i == 3)) {
            break label549;
          }
          a(i);
          mqz.e(this.jdField_a_of_type_ComTencentAvVideoController);
          break label549;
        }
        if (((lgf)localObject).h())
        {
          b(2131696000);
          break label549;
        }
        if ((!((lgf)localObject).m()) && (!((lgf)localObject).n())) {
          break label549;
        }
        j(((lgf)localObject).jdField_y_of_type_Int);
        if (((lgf)localObject).jdField_i_of_type_Int == 1011) {
          b(2131696129);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.7(this, l), 150L);
        break label549;
        label1118:
        super.l(2131372214);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372214, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690256));
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (1 == paramInt) {
      if (!this.jdField_d_of_type_Boolean)
      {
        p();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt == 0)
            {
              q();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
              return;
            }
          } while (2 == paramInt);
          if (3 != paramInt) {
            break;
          }
          localObject1 = a();
        } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().s != 2) || (localObject1 == null) || (!((ChildLockSign)localObject1).isEnabled()));
        if (((ChildLockSign)localObject1).getVisibility() != 0)
        {
          ((ChildLockSign)localObject1).setLocked(true);
          ((ChildLockSign)localObject1).setVisibility(0);
          r();
          return;
        }
        ((ChildLockSign)localObject1).setVisibility(8);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        return;
      } while (4 != paramInt);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372225);
        }
      }
    } while (localObject1 == null);
  }
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoCtrlUI");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(paramLong);
      o(true);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365325);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_b_of_type_Mck = null;
    this.jdField_a_of_type_Msy = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    if (this.jdField_a_of_type_Mho != null)
    {
      this.jdField_a_of_type_Mho.b();
      this.jdField_a_of_type_Mho = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372255));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372256));
    f(paramLong, 65535);
    e();
  }
  
  void d(long paramLong, View paramView)
  {
    Object localObject = new mco(paramView);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), localObject });
    }
    if (((mco)localObject).jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, mBlockName[" + ((mco)localObject).jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695648);
      return;
      if (a(paramLong, "android.permission.CAMERA", paramView))
      {
        lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
        mqz.h(this.jdField_a_of_type_ComTencentAvVideoController);
        if (locallgf.jdField_d_of_type_Int == 1)
        {
          los locallos = new los();
          localObject = locallgf.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject;
          if (((String)localObject).startsWith("+")) {
            paramView = ((String)localObject).substring(1);
          }
          locallos.jdField_a_of_type_Long = mqx.a(paramView);
          locallos.jdField_a_of_type_Int = 1;
          paramView = new ArrayList();
          paramView.add(locallos);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
          i(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, open1, seq[" + paramLong + "]");
          }
          axqw.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
          if (locallgf.x) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.14(this), 500L);
          }
        }
        else if (locallgf.jdField_d_of_type_Int == 2)
        {
          if (locallgf.jdField_j_of_type_Boolean)
          {
            j(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, close, seq[" + paramLong + "]");
            }
          }
          else
          {
            i(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, open2, seq[" + paramLong + "]");
            }
          }
        }
      }
    }
  }
  
  void d(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (g()) {
      return;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_q_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, 0, false);
      if (this.jdField_a_of_type_Mtt != null) {
        this.jdField_a_of_type_Mtt.a();
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))
      {
        AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramBoolean) {
          break label217;
        }
        bool1 = true;
        label93:
        localAVActivity.b(bool1);
        if (paramBoolean) {
          break label223;
        }
        bool1 = bool2;
        label108:
        localAVActivity.f(bool1);
        localAVActivity.c(paramBoolean);
      }
      if (!paramBoolean) {
        break label229;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(8);
      }
      h(paramLong, 8);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      a(Boolean.valueOf(paramBoolean));
      return;
      f(-1014L, 65535);
      break;
      label217:
      bool1 = false;
      break label93;
      label223:
      bool1 = false;
      break label108;
      label229:
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(0);
      }
      h(paramLong, 0);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().w)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().w = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean = this.jdField_h_of_type_Boolean;
      if (this.jdField_h_of_type_Boolean) {
        e(0);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372515, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372519, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372513, 8);
      AVActivity localAVActivity = a();
      if (localAVActivity != null) {
        localAVActivity.a(false);
      }
    }
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
  }
  
  public void e(long paramLong)
  {
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(locallgf.jdField_d_of_type_JavaLangString);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onConnected, roomid[" + l + "], mNeedRemoveAudioCallback[" + this.jdField_c_of_type_Boolean + "], seq[" + paramLong + "]");
    super.e(paramLong);
    if (l > 0L) {
      ((ljb)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    String str = l + "";
    mlr.a(locallgf.jdField_d_of_type_Int, str + "");
    g(paramLong, 2131695802);
    mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
    mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
    label293:
    label315:
    int i;
    int j;
    label367:
    mtf localmtf;
    if (!locallgf.jdField_e_of_type_Boolean)
    {
      if (locallgf.N)
      {
        axqw.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!locallgf.jdField_g_of_type_Boolean) {
          break label595;
        }
        axqw.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        mqz.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (locallgf.jdField_d_of_type_Int != 2) {
        break label631;
      }
      d(paramLong, true);
      a(paramLong, true);
      str = locallgf.jdField_d_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
      if (i != 5) {
        break label650;
      }
      if (!locallgf.ak) {
        break label639;
      }
      super.x(paramLong);
      localmtf = this.jdField_a_of_type_Mtf;
      if (locallgf.jdField_d_of_type_Int != 1) {
        break label775;
      }
    }
    label775:
    for (boolean bool = true;; bool = false)
    {
      localmtf.b(bool);
      i = locallgf.jdField_i_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_Mta != null)
      {
        this.jdField_a_of_type_Mta.c();
        this.jdField_a_of_type_Mta.e();
        this.jdField_a_of_type_Mta.a();
        this.jdField_a_of_type_Mta = null;
      }
      if (locallgf.jdField_m_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      }
      if (locallgf.jdField_d_of_type_Int == 2)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onConnected, CheckRemoteCameraRunnable");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      }
      if ((locallgf.jdField_m_of_type_Boolean) && (!locallgf.jdField_k_of_type_Boolean)) {
        a("onConnected", 1);
      }
      return;
      axqw.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      label595:
      axqw.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label293;
      label631:
      h(true);
      break label315;
      label639:
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label367;
      label650:
      if (!this.jdField_a_of_type_ComTencentAvVideoController.d())
      {
        if (locallgf.ak)
        {
          super.x(paramLong);
          break label367;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label367;
      }
      if (!locallgf.j())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label367;
      }
      if (j > 18)
      {
        if ((locallgf.ak) && (locallgf.al))
        {
          super.x(paramLong);
          break label367;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label367;
      }
      if (locallgf.ak)
      {
        super.x(paramLong);
        break label367;
      }
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label367;
    }
  }
  
  public void e_(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void f()
  {
    super.f();
    this.jdField_d_of_type_Boolean = true;
    v();
    q();
  }
  
  public void f(int paramInt)
  {
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramInt != locallgf.R) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setGlassWaitTime, WaitTime[" + locallgf.R + "->" + paramInt + "]");
    }
    locallgf.R = paramInt;
  }
  
  protected void f(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_Mcz.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
      f(paramLong, 65535);
      j(paramLong, 2131695653);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
    }
  }
  
  public void g(long paramLong)
  {
    int k = 0;
    if (g()) {
      return;
    }
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372513);
    if ((!msq.d()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean)) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = " + msq.d());
    }
    for (int j = 0;; j = 1)
    {
      lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localImageButton == null) {
        break;
      }
      int i;
      if (locallgf.v == 0) {
        i = 2130841781;
      }
      for (;;)
      {
        label130:
        QavPanel.setBtnTopDrawable(localImageButton, i);
        if (j != 0) {}
        for (i = k;; i = 8)
        {
          localImageButton.setVisibility(i);
          if (j != 0) {
            break;
          }
          ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372305)).setVisibility(4);
          return;
          if (locallgf.v == 1)
          {
            i = 2130841782;
            break label130;
          }
          if (locallgf.v == 2)
          {
            i = 2130841784;
            break label130;
          }
          if (locallgf.v != 3) {
            break label227;
          }
          i = 2130841783;
          break label130;
        }
        label227:
        i = 2130841781;
      }
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onPauseVideo, seq[" + l + "]");
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
    {
      a("onPauseVideo", 1);
      s();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onResumeVideo setRotation");
        }
        a(l, 0.0F);
      }
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Int = 0;
    }
  }
  
  public void h(long paramLong)
  {
    boolean bool2 = false;
    if (g()) {}
    mqk localmqk;
    do
    {
      return;
      localmqk = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695653);
      if (localmqk != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, null, seq[" + paramLong + "]");
    return;
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1;
    if ((locallgf.jdField_d_of_type_Int == 3) || (locallgf.jdField_d_of_type_Int == 4) || (locallgf.jdField_d_of_type_Int == 1))
    {
      bool1 = bool2;
      if (jdField_o_of_type_Boolean)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, 场景不支持, seq[" + paramLong + "]");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localmqk.a(mcz.d(this.jdField_a_of_type_Mcz));
      localmqk.c(bool1);
      return;
      AVActivity localAVActivity = a();
      if (localAVActivity.jdField_a_of_type_Miq == null)
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, !mRecordUiCtrl, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if (!localAVActivity.jdField_a_of_type_Miq.h())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, !isEnableRecord, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if ((!locallgf.jdField_j_of_type_Boolean) || (!locallgf.jdField_k_of_type_Boolean))
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + locallgf.jdField_j_of_type_Boolean + "][sessionInfo.remoteHasVideo=" + locallgf.jdField_k_of_type_Boolean + "]");
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public void i()
  {
    long l = AudioHelper.b();
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onResumeVideo, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "], seq[" + l + "]");
    if (lsv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131720777));
      axqw.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      axqw.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    axqw.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onResumeVideo", 2);
      a("onResumeVideo", 2);
      ThreadManager.excute(new DoubleVideoCtrlUI.11(this, l), 16, null, false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x) {
        d(true);
      }
    }
    for (;;)
    {
      z(l);
      return;
      f(l, 65535);
    }
  }
  
  public void i(long paramLong)
  {
    f(paramLong, 65535);
  }
  
  public void j() {}
  
  public void j(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onBeforeCloseCamera, seq[" + paramLong + "]");
    }
    f(paramLong, 65535);
  }
  
  public void k()
  {
    if (lsv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    long l = AudioHelper.b();
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean + ", seq[" + l + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean)
    {
      a("onNeedShowPeerVideo.1", 2);
      f(l, 65535);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onNeedShowPeerVideo.2", 2);
      a("onNeedShowPeerVideo.2", 2);
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  void l()
  {
    G();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Msy);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Mho != null) {
      this.jdField_a_of_type_Mho.a(new mcv(this));
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_Mcz.a();
    f(-1027L, 65535);
  }
  
  public void o()
  {
    if (g()) {
      return;
    }
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "refreshUI, SessionType[" + locallgf.jdField_d_of_type_Int + "], seq[" + l + "]");
    }
    int i = locallgf.jdField_i_of_type_Int;
    String str = locallgf.jdField_d_of_type_JavaLangString;
    Object localObject3 = locallgf.jdField_f_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
    Object localObject1 = locallgf.jdField_e_of_type_JavaLangString;
    if (locallgf.jdField_e_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject3);
      locallgf.jdField_e_of_type_JavaLangString = ((String)localObject1);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372255));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372256));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370647));
      if (locallgf.jdField_d_of_type_Int == 2) {
        d(l, true);
      }
    }
    else
    {
      if (locallgf.jdField_d_of_type_Int != 2) {
        break label484;
      }
      d(l, true);
      label249:
      if (locallgf.jdField_i_of_type_Int == 1011)
      {
        if (locallgf.jdField_a_of_type_Lgg.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label501;
        }
        a(locallgf.jdField_a_of_type_Lgg.jdField_a_of_type_AndroidGraphicsBitmap);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(locallgf.jdField_a_of_type_Lgg.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(locallgf.jdField_a_of_type_Lgg.jdField_b_of_type_JavaLangString);
        }
      }
      label283:
      if (locallgf.jdField_i_of_type_Int != 25) {
        break label556;
      }
      localObject2 = locallgf.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = locallgf.jdField_f_of_type_JavaLangString;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(str);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
      }
      if ((!((String)localObject2).equals(locallgf.jdField_d_of_type_JavaLangString)) || (localObject1 == null)) {
        break label521;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    for (;;)
    {
      f(l, 65535);
      return;
      d(l, false);
      break;
      label484:
      if (locallgf.jdField_d_of_type_Int != 1) {
        break label249;
      }
      b(false);
      break label249;
      label501:
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label283;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bbdr.a());
      break label283;
      label521:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        continue;
        label556:
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
      }
    }
  }
  
  void p()
  {
    ChildLockCircle localChildLockCircle = a();
    if (localChildLockCircle != null) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().w)) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localChildLockCircle.a(bool);
      return;
    }
  }
  
  void q()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372225);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).b();
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 3000L);
  }
  
  public void s()
  {
    long l = AudioHelper.b();
    q();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().w)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().w = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.18(this, l), 300L);
    }
  }
  
  public void t()
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onSelfAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L) {
        super.x(l);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.d()) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
            super.x(l);
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().j());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().al);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
      super.x(l);
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    super.x(l);
  }
  
  public void u()
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onOppositeAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.d()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ak)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    super.x(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */