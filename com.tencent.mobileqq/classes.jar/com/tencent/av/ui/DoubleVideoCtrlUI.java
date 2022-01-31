package com.tencent.av.ui;

import actj;
import ajya;
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
import axqy;
import bbdj;
import bbef;
import bbgu;
import bbpb;
import bfly;
import bkvi;
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
import lcg;
import lcx;
import lga;
import lgb;
import lhu;
import liu;
import liw;
import lks;
import llw;
import llz;
import lon;
import lsq;
import ltm;
import lyw;
import lze;
import mao;
import mcf;
import mcj;
import mcl;
import mcp;
import mcq;
import mcr;
import mcs;
import mct;
import mcu;
import mha;
import mhj;
import min;
import mjo;
import mlo;
import mmk;
import mqh;
import mqn;
import mqu;
import mqw;
import mre;
import msn;
import msx;
import mtc;
import mtq;

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
  mcu jdField_a_of_type_Mcu = new mcu(null);
  mhj jdField_a_of_type_Mhj = null;
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
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcf parammcf)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammcf);
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
        localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131372230);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockSign((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365324);
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
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      bool = true;
      locallga.jdField_g_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label130;
      }
      ltm.a().a(32);
      super.k(2131372216);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(true, paramString);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690265));
    }
    for (;;)
    {
      mqw.c(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool = false;
      break;
      label130:
      ltm.a().b(32);
      super.l(2131372216);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, paramString);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690256));
    }
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    VideoController localVideoController = paramVideoAppInterface.a();
    lga locallga = localVideoController.a();
    String str = locallga.jdField_d_of_type_JavaLangString;
    int i;
    if (paramBoolean) {
      if (locallga.a(localVideoController)) {
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
        axqy.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
        if ((i != 3000) || (paramActivity == null) || (!msn.e())) {
          break label295;
        }
        paramVideoAppInterface = msn.a();
        bbdj.a(paramActivity, 230, null, paramVideoAppInterface, "", ajya.a(2131703445), new mcr(), null).show();
        if (QLog.isColorLevel()) {
          QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + paramVideoAppInterface + "]");
        }
        axqy.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
        return;
        i = 3000;
        break;
        if (!locallga.b(localVideoController)) {
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
    int i = 2131695730;
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
      mao.a(paramVideoAppInterface, 1012, i);
      return;
      if (!llw.f()) {
        i = 2131720808;
      } else if (lsq.a(localVideoController.a()) == 1) {
        i = 2131720744;
      } else if (k < 16) {
        i = 2131695731;
      } else if ((j == 4) || (j == 2) || (j == 3)) {
        label130:
        i = 0;
      }
    }
    mao.a(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    int i = 0;
    int j = paramVideoAppInterface.a().a().jdField_a_of_type_Lgb.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt > 0)
    {
      mao.a(paramVideoAppInterface, 1048, paramInt);
      return;
      if ((j == 3) || (j == 1))
      {
        paramInt = 2131696240;
      }
      else
      {
        paramInt = 2131696239;
        continue;
        if ((j == 3) || (j == 1))
        {
          paramInt = 2131696235;
        }
        else
        {
          paramInt = 2131696234;
          continue;
          if ((j == 3) || (j == 1)) {
            paramInt = 2131696237;
          } else {
            paramInt = 2131696236;
          }
        }
      }
    }
    mao.a(paramVideoAppInterface, 1048);
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
    paramView = new mcj(paramView);
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
      j(paramLong, 2131695653);
      return;
      mqw.g(this.jdField_a_of_type_ComTencentAvVideoController);
      a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if ((lze.f()) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
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
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_Boolean) || (lcx.a().a())) {
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
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131372227);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365324);
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
      lga locallga;
      if (paramInt1 == 0)
      {
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramInt1 == 0) && (!locallga.jdField_k_of_type_Boolean)) {
          break label308;
        }
        if (locallga.jdField_d_of_type_Int == 1)
        {
          locallga.a(l, "onTerSwitchSyncStatus.1", 2);
          a("onTerSwitchSyncStatus.1", locallga.jdField_d_of_type_Int);
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
        locallga.jdField_g_of_type_Boolean = bool;
        str = locallga.jdField_d_of_type_JavaLangString;
        if (!locallga.jdField_g_of_type_Boolean) {
          break label348;
        }
        super.k(2131372216);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690265));
        return;
        i(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
        break label104;
        if (locallga.jdField_d_of_type_Int != 2) {
          break label156;
        }
        locallga.a(l, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", locallga.jdField_d_of_type_Int);
        break label156;
      }
      label348:
      super.l(2131372216);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690256));
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
      localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372513);
      localView2 = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372514);
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
        localLayoutParams1.topMargin = (paramInt - c() + actj.a(15.0F, this.jdField_a_of_type_AndroidContentResResources));
        if (bkvi.b())
        {
          paramInt = localLayoutParams1.topMargin;
          localLayoutParams1.topMargin = (bkvi.b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()) + paramInt);
        }
      }
      else
      {
        localLayoutParams1.topMargin = actj.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131372218) || (paramInt1 == 2131372219)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372218, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372218, paramBoolean);
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
        liu.a(29);
        AVReport.a().j = SystemClock.elapsedRealtime();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int < 0) {
          break label420;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1011) {
          break label208;
        }
        g(-1015L, 2131695741);
        if (this.jdField_a_of_type_Msx != null) {
          this.jdField_a_of_type_Msx.b();
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
      g(-1015L, 2131695678);
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().b;
      String str = bbpb.a(l, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          mtq.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int;
        axqy.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Msx == null) {
          break label418;
        }
        this.jdField_a_of_type_Msx.c();
        this.jdField_a_of_type_Msx.d();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          mtq.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
        }
      }
      label418:
      continue;
      label420:
      if (this.jdField_a_of_type_Msx != null) {
        this.jdField_a_of_type_Msx.b();
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
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int k = locallga.jdField_i_of_type_Int;
    int i;
    int j;
    label100:
    Object localObject;
    if (locallga.jdField_d_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label524;
      }
      j = 1;
      if (((locallga.m()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((locallga.n()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26)))) {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          mqw.p(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mcp(this, paramLong));
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
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372202, 8);
          localObject = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372215);
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372521, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372215, true);
      localObject = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localObject != null) {
        ((EffectOperateManager)localObject).b(false);
      }
      if (this.jdField_a_of_type_Msx != null)
      {
        this.jdField_a_of_type_Msx.c();
        this.jdField_a_of_type_Msx.e();
        this.jdField_a_of_type_Msx.a();
        this.jdField_a_of_type_Msx = null;
      }
      this.jdField_a_of_type_Boolean = true;
      if ((locallga.j()) && (locallga.jdField_d_of_type_Int == 2) && (!locallga.jdField_j_of_type_Boolean)) {
        mqw.e();
      }
      locallga.jdField_g_of_type_Boolean = false;
      if (paramInt == 24)
      {
        this.i = true;
        g(paramLong, 2131696123);
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
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372202, false);
      continue;
      label544:
      axqy.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372202, true);
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
      case 2131364066: 
      case 2131365049: 
      case 2131372516: 
        P();
        return;
      case 2131695654: 
        f(paramLong);
        return;
      case 2131372518: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
        lhu.f(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) + "");
        this.jdField_b_of_type_Mcf.update(null, new Object[] { Integer.valueOf(134) });
        return;
      case 2131372210: 
      case 2131372211: 
      case 2131372212: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick Hangup ");
        a(paramView);
        return;
      case 2131372208: 
        bool = c();
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + bool);
      }
    } while (!bool);
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().N;
    paramView = this.jdField_a_of_type_ComTencentAvVideoController;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      mqw.a(paramView, bool);
      if (this.jdField_a_of_type_Mtq == null) {
        break;
      }
      this.jdField_a_of_type_Mtq.a(mtq.c);
      return;
    }
    c(paramLong, paramView);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick HIDE ");
    this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
    lde.a = "3";
    a();
    mqw.b(this.jdField_a_of_type_ComTencentAvVideoController);
    return;
    d(paramLong, paramView);
    return;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    mqw.a(paramView.getId(), i);
    a((AVActivity)localObject, str1);
    return;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
    i(paramLong, paramView);
    return;
    e(paramLong, paramView);
    return;
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
    mqn.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
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
      axqy.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
    }
    for (i = 2131692974; this.jdField_a_of_type_ComTencentAvUiQavPanel != null; i = 2131692973)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372521, this.jdField_a_of_type_AndroidContentResResources.getString(i));
      return;
      bool = false;
      break label738;
      label829:
      axqy.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      mtq.a().b(paramLong);
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject, str2, true);
    }
    mqw.q(this.jdField_a_of_type_ComTencentAvVideoController);
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
    a(2131696196, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298865));
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
      axqy.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
      paramView = new Intent((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
      paramView.putExtra("url", "https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process");
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
      j(paramLong, 2131695657);
      return;
      i = 2;
      break;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
    axqy.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.a().v + 1, 0, "", "", "", "");
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g("Sharpness");
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() == 1) {
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(paramLong);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Mha.b();
    return;
    f(paramLong, paramView);
    return;
    b(paramLong, paramView);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setTitleText, mRingAnimator[" + this.jdField_a_of_type_Msx.jdField_a_of_type_Boolean + "], startRingAnimator[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (!TextUtils.isEmpty(paramString)) {
      d(paramLong, paramString);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Msx != null))
    {
      this.jdField_a_of_type_Msx.c();
      this.jdField_a_of_type_Msx.d();
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    f(paramLong, 65535);
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((i == 2) && (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) && (paramBoolean) && (locallga.j()))
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      axqy.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372517, 0);
        localAVActivity = a();
        if (localAVActivity != null) {
          localAVActivity.a(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean = true;
        if ((paramInt == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().N) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString))) {
          this.jdField_a_of_type_Mtq.d();
        }
        mqw.c();
        mqw.m(this.jdField_a_of_type_ComTencentAvVideoController);
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
    if ((i == 2131372210) || (i == 2131372211)) {
      lcg.d(this.jdField_c_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramView = new mcj(paramView);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.jdField_b_of_type_Boolean) {
        break;
      }
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Hangup, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
      return;
      if (i == 2131372212) {
        lcg.d(this.jdField_c_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    g(true);
    this.jdField_a_of_type_Mhj.a(new mcs(this, l, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i + "], PhoneNum[" + AudioHelper.a(this.jdField_a_of_type_ComTencentAvVideoController.a().a()) + "]");
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().a())));
    axqy.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Mtq != null) {
      this.jdField_a_of_type_Mtq.a();
    }
    mtc localmtc;
    if (paramInt == 1)
    {
      o();
      d(l, false);
      f(l, 65535);
      e(0);
      new mcl(l, "avSwitch", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      localmtc = this.jdField_a_of_type_Mtc;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label227;
      }
      bool1 = true;
      label150:
      localmtc.c(bool1);
      localmtc = this.jdField_a_of_type_Mtc;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label232;
      }
    }
    label227:
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmtc.b(bool1);
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
    lga locallga;
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
          locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
          l = AudioHelper.b();
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onInviteReached, peerUin[" + paramString1 + "], showMsg[" + paramString2 + "], remotePhoneState[" + locallga.jdField_n_of_type_Int + "], remoteTerminal[" + locallga.jdField_k_of_type_Int + "], phoneOnLine[" + locallga.jdField_m_of_type_Int + "], pcOnLine[" + locallga.jdField_l_of_type_Int + "], subState[" + locallga.jdField_d_of_type_Long + "], isPeerNetworkWell[" + locallga.jdField_q_of_type_Boolean + "], seq[" + l + "]");
        } while ((!locallga.f()) || (locallga.ag) || (locallga.jdField_i_of_type_Int == 1011) || (!locallga.jdField_d_of_type_JavaLangString.contains(paramString1)));
        i = locallga.jdField_n_of_type_Int;
        if (i >= 0)
        {
          if (TextUtils.isEmpty(paramString2)) {
            g(l, 2131695678);
          }
        }
        else {
          if (locallga.jdField_d_of_type_Long != 0L) {
            break label289;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Msx != null)
          {
            this.jdField_a_of_type_Msx.c();
            this.jdField_a_of_type_Msx.d();
          }
          if ((i <= 0) || (i == 3)) {
            break label379;
          }
          a(i);
          mqw.e(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          d(l, paramString2);
          break;
          if (locallga.jdField_d_of_type_Long == 2L)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(locallga.jdField_d_of_type_JavaLangString, 8, 0L);
            if (!TextUtils.isEmpty(locallga.jdField_o_of_type_JavaLangString)) {
              mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3008, locallga.jdField_o_of_type_JavaLangString);
            }
            axqy.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
          }
        }
        if (i != 4) {
          break;
        }
      } while ((locallga.jdField_l_of_type_Int != 1) || (locallga.jdField_m_of_type_Int != 0));
      a(i);
      return;
    } while ((i != 0) || (!locallga.jdField_q_of_type_Boolean) || (locallga.jdField_k_of_type_Int == 2) || (locallga.jdField_d_of_type_Int != 1));
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onPeerSwitchTerminal, peerUin[" + paramString + "], bStartSwitch[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
    }
    for (;;)
    {
      f(l, 65535);
      paramString = llz.a();
      if (!paramBoolean) {
        break;
      }
      paramString.jdField_b_of_type_Boolean = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.jdField_b_of_type_Boolean);
      }
      lze.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
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
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363369);
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
        new mjo(this.jdField_a_of_type_AndroidViewViewGroup).a(paramBoolean1);
      }
      c(-1035L, "changeToDoubleScreen");
      return;
    }
  }
  
  public boolean a()
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onBackPressed, seq[" + l + "], isChildLock[" + ((lga)localObject).w + "]");
    if (((lga)localObject).w) {
      return true;
    }
    if (super.a())
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onBackPressed called return 2, seq[" + l + "]");
      return true;
    }
    v();
    String str = ((lga)localObject).jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((!lze.f()) && (((lga)localObject).jdField_d_of_type_Int == 2) && (((lga)localObject).jdField_j_of_type_Boolean)) {
      a(2131695804, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298865));
    }
    if ((((lga)localObject).m()) || (((lga)localObject).n()))
    {
      j(((lga)localObject).jdField_y_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.13(this, l), 150L);
    }
    if (lze.f())
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((lyw)localObject).a();
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
    if (!((lga)localObject).aw) {
      return false;
    }
    if (!((lga)localObject).jdField_k_of_type_Boolean)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + paramInt + "]");
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((lga)localObject).jdField_Q_of_type_Int != paramInt)) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setGlassSwitch, GlassSwitch[" + ((lga)localObject).jdField_Q_of_type_Int + "->" + paramInt + "]");
    }
    if (((lga)localObject).jdField_Q_of_type_Int == paramInt) {
      return false;
    }
    ((lga)localObject).jdField_Q_of_type_Int = paramInt;
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
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1039);
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
    this.jdField_a_of_type_Mtq.a();
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtq);
      }
    }
    else
    {
      d(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370647));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372518));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372246));
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147483392);
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "need reset quit double screen listener");
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new mct(this));
      }
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372237));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label454;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372210, this.jdField_a_of_type_AndroidContentResResources.getString(2131690263));
      }
      d(l, false);
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372216, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372216, false);
      }
      c(l, "initUI");
      this.jdField_a_of_type_Mhj = new mhj((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372256), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372387), null);
      mre.a(BaseApplicationImpl.getApplication());
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 0))) {
        axqy.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
      }
      return;
      bool = false;
      break;
      label454:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372210, this.jdField_a_of_type_AndroidContentResResources.getString(2131720757));
      }
      d(l, true);
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011) && (paramInt != 2131695741) && (paramInt != 2131720751)) {}
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
    if (((lga)localObject1).j())
    {
      if (((lga)localObject1).jdField_d_of_type_Long != 1L) {
        super.x(paramLong);
      }
      localObject2 = this.jdField_a_of_type_Mtc;
      if (((lga)localObject1).jdField_d_of_type_Int != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((mtc)localObject2).b(bool1);
      o();
      mqw.a(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_d_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!((lga)localObject1).aw)) {
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
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372227);
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
      if (!paramView.jdField_a_of_type_Mmk.a()) {
        break label44;
      }
      paramView.jdField_a_of_type_Mmk.c(3);
    }
    for (;;)
    {
      lks.a("0X800A8D0");
      return;
      label44:
      paramView.jdField_a_of_type_Mmk.a(0);
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
    if (this.jdField_a_of_type_Mtq != null)
    {
      this.jdField_a_of_type_Mtq.a(paramBoolean);
      this.jdField_a_of_type_Mtq.a();
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
          mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
          return;
        }
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1018);
      axqy.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
        localObject = new bfly((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
        if (mre.a("qav_peer_phone_calling.mp3")) {
          ((bfly)localObject).a(l, 2, 0, null, mre.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)
        {
          axqy.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
          ((bfly)localObject).a(l, 0, 2131230737, null, null, false, 1, false, true, 0);
          mre.a(BaseApplicationImpl.getApplication());
        }
        axqy.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
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
      mqw.d();
      mqw.n(this.jdField_a_of_type_ComTencentAvVideoController);
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
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
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
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
    }
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "avideo onCreate, state[" + ((lga)localObject).jdField_g_of_type_Int + "], seq[" + l + "]");
    b();
    this.jdField_a_of_type_Mtq.c();
    if (((lga)localObject).E == 0) {
      ((lga)localObject).E = 3;
    }
    int j;
    int i;
    if ((((lga)localObject).d()) || (((lga)localObject).h()))
    {
      j = 1;
      if (((lga)localObject).jdField_Q_of_type_Boolean) {
        j = 0;
      }
      i = 1;
      if (!((lga)localObject).L) {
        i = 4;
      }
      if (1008 != ((lga)localObject).jdField_i_of_type_Int) {
        break label1172;
      }
      i = 4;
    }
    label1172:
    for (;;)
    {
      if (((lga)localObject).jdField_e_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lga)localObject).jdField_d_of_type_JavaLangString, j, i);; i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lga)localObject).jdField_d_of_type_JavaLangString, j, i, ((lga)localObject).jdField_i_of_type_JavaLangString, ((lga)localObject).jdField_j_of_type_JavaLangString, ((lga)localObject).a(), ((lga)localObject).jdField_i_of_type_Int, ((lga)localObject).jdField_f_of_type_JavaLangString, ((lga)localObject).jdField_g_of_type_JavaLangString, ((lga)localObject).jdField_a_of_type_ArrayOfByte, null, null, 0, 0, null, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "result = " + i);
        }
        if (i == 0) {
          break;
        }
        lcg.d(this.jdField_c_of_type_JavaLangString, "Video connect fail:" + i);
        if (i == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(((lga)localObject).jdField_d_of_type_JavaLangString, 238);
          this.jdField_a_of_type_ComTencentAvVideoController.b(238);
          this.jdField_a_of_type_ComTencentAvVideoController.b(((lga)localObject).jdField_d_of_type_JavaLangString, 9);
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
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onCreate, ofter Request, state[" + ((lga)localObject).jdField_g_of_type_Int + "], SessionType[" + ((lga)localObject).jdField_d_of_type_Int + "], deviceName[" + ((lga)localObject).jdField_q_of_type_JavaLangString + "], seq[" + l + "]");
      }
      label481:
      label511:
      String str;
      if (((lga)localObject).f())
      {
        if (((lga)localObject).jdField_d_of_type_Int == 1)
        {
          this.jdField_d_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          this.jdField_a_of_type_Mtq.a(this.jdField_d_of_type_JavaLangString);
        }
      }
      else
      {
        if (!((lga)localObject).j()) {
          break label739;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label691;
        }
        if (((lga)localObject).jdField_d_of_type_Int == 2) {
          d(l, true);
        }
        i = ((lga)localObject).jdField_i_of_type_Int;
        str = ((lga)localObject).jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
        label549:
        if (((lga)localObject).jdField_m_of_type_Boolean) {
          o();
        }
        if (((lga)localObject).jdField_Q_of_type_Boolean)
        {
          this.jdField_a_of_type_Mtc.c(true);
          this.jdField_a_of_type_Mtc.c(true);
        }
        if (!((lga)localObject).jdField_g_of_type_Boolean) {
          break label1118;
        }
        super.k(2131372216);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690265));
        }
      }
      for (;;)
      {
        a(l, false);
        this.jdField_a_of_type_AndroidViewViewGroup.post(new DoubleVideoCtrlUI.8(this));
        if (this.jdField_a_of_type_Mhj == null) {
          break;
        }
        this.jdField_a_of_type_Mhj.a();
        return;
        this.jdField_d_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label481;
        label691:
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) || (((lga)localObject).jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.b(((lga)localObject).jdField_d_of_type_JavaLangString) != 5)) {
          break label511;
        }
        mqw.f(this.jdField_a_of_type_ComTencentAvVideoController);
        break label511;
        label739:
        if (((lga)localObject).i())
        {
          if (((lga)localObject).jdField_Q_of_type_Boolean) {}
          for (i = 2131695813;; i = 2131720821)
          {
            b(i);
            break;
          }
        }
        if (((lga)localObject).f())
        {
          i = 2131696150;
          if (((lga)localObject).ag) {
            i = 2131696151;
          }
          if (((lga)localObject).jdField_i_of_type_Int == 1011) {
            i = 2131695741;
          }
          if (((lga)localObject).jdField_Q_of_type_Boolean)
          {
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "Inviting, remotePhoneState[" + ((lga)localObject).jdField_n_of_type_Int + "], isPeerNetworkWell[" + ((lga)localObject).jdField_q_of_type_Boolean + "], remoteOnline[" + ((lga)localObject).r + "], remoteTerminal[" + ((lga)localObject).jdField_k_of_type_Int + "]");
            if ((((lga)localObject).jdField_n_of_type_Int == 0) && (((lga)localObject).jdField_q_of_type_Boolean) && (((lga)localObject).jdField_k_of_type_Int != 2) && (((lga)localObject).jdField_d_of_type_Int == 1)) {
              mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
            }
          }
          b(i);
          i = ((lga)localObject).jdField_i_of_type_Int;
          str = ((lga)localObject).jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
          i = ((lga)localObject).jdField_n_of_type_Int;
          if ((i == 4) && (((lga)localObject).jdField_l_of_type_Int == 1) && (((lga)localObject).jdField_m_of_type_Int == 0)) {
            a(i);
          }
          if ((i <= 0) || (i == 3)) {
            break label549;
          }
          a(i);
          mqw.e(this.jdField_a_of_type_ComTencentAvVideoController);
          break label549;
        }
        if (((lga)localObject).h())
        {
          b(2131696001);
          break label549;
        }
        if ((!((lga)localObject).m()) && (!((lga)localObject).n())) {
          break label549;
        }
        j(((lga)localObject).jdField_y_of_type_Int);
        if (((lga)localObject).jdField_i_of_type_Int == 1011) {
          b(2131696130);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.7(this, l), 150L);
        break label549;
        label1118:
        super.l(2131372216);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690256));
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
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372227);
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
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365324);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_b_of_type_Mcf = null;
    this.jdField_a_of_type_Msv = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    if (this.jdField_a_of_type_Mhj != null)
    {
      this.jdField_a_of_type_Mhj.b();
      this.jdField_a_of_type_Mhj = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372257));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372258));
    f(paramLong, 65535);
    e();
  }
  
  void d(long paramLong, View paramView)
  {
    Object localObject = new mcj(paramView);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), localObject });
    }
    if (((mcj)localObject).jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, mBlockName[" + ((mcj)localObject).jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695649);
      return;
      if (a(paramLong, "android.permission.CAMERA", paramView))
      {
        lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
        mqw.h(this.jdField_a_of_type_ComTencentAvVideoController);
        if (locallga.jdField_d_of_type_Int == 1)
        {
          lon locallon = new lon();
          localObject = locallga.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject;
          if (((String)localObject).startsWith("+")) {
            paramView = ((String)localObject).substring(1);
          }
          locallon.jdField_a_of_type_Long = mqu.a(paramView);
          locallon.jdField_a_of_type_Int = 1;
          paramView = new ArrayList();
          paramView.add(locallon);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
          i(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, open1, seq[" + paramLong + "]");
          }
          axqy.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
          if (locallga.x) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.14(this), 500L);
          }
        }
        else if (locallga.jdField_d_of_type_Int == 2)
        {
          if (locallga.jdField_j_of_type_Boolean)
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
      if (this.jdField_a_of_type_Mtq != null) {
        this.jdField_a_of_type_Mtq.a();
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
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372517, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372521, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372515, 8);
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
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(locallga.jdField_d_of_type_JavaLangString);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onConnected, roomid[" + l + "], mNeedRemoveAudioCallback[" + this.jdField_c_of_type_Boolean + "], seq[" + paramLong + "]");
    super.e(paramLong);
    if (l > 0L) {
      ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    String str = l + "";
    mlo.a(locallga.jdField_d_of_type_Int, str + "");
    g(paramLong, 2131695803);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
    label293:
    label315:
    int i;
    int j;
    label367:
    mtc localmtc;
    if (!locallga.jdField_e_of_type_Boolean)
    {
      if (locallga.N)
      {
        axqy.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!locallga.jdField_g_of_type_Boolean) {
          break label595;
        }
        axqy.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        mqw.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (locallga.jdField_d_of_type_Int != 2) {
        break label631;
      }
      d(paramLong, true);
      a(paramLong, true);
      str = locallga.jdField_d_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
      if (i != 5) {
        break label650;
      }
      if (!locallga.ak) {
        break label639;
      }
      super.x(paramLong);
      localmtc = this.jdField_a_of_type_Mtc;
      if (locallga.jdField_d_of_type_Int != 1) {
        break label775;
      }
    }
    label775:
    for (boolean bool = true;; bool = false)
    {
      localmtc.b(bool);
      i = locallga.jdField_i_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_Msx != null)
      {
        this.jdField_a_of_type_Msx.c();
        this.jdField_a_of_type_Msx.e();
        this.jdField_a_of_type_Msx.a();
        this.jdField_a_of_type_Msx = null;
      }
      if (locallga.jdField_m_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      }
      if (locallga.jdField_d_of_type_Int == 2)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onConnected, CheckRemoteCameraRunnable");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      }
      if ((locallga.jdField_m_of_type_Boolean) && (!locallga.jdField_k_of_type_Boolean)) {
        a("onConnected", 1);
      }
      return;
      axqy.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      label595:
      axqy.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
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
        if (locallga.ak)
        {
          super.x(paramLong);
          break label367;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label367;
      }
      if (!locallga.j())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label367;
      }
      if (j > 18)
      {
        if ((locallga.ak) && (locallga.al))
        {
          super.x(paramLong);
          break label367;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label367;
      }
      if (locallga.ak)
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
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramInt != locallga.R) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setGlassWaitTime, WaitTime[" + locallga.R + "->" + paramInt + "]");
    }
    locallga.R = paramInt;
  }
  
  protected void f(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_Mcu.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
      f(paramLong, 65535);
      j(paramLong, 2131695654);
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
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372515);
    if ((!msn.d()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean)) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = " + msn.d());
    }
    for (int j = 0;; j = 1)
    {
      lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localImageButton == null) {
        break;
      }
      int i;
      if (locallga.v == 0) {
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
          ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372307)).setVisibility(4);
          return;
          if (locallga.v == 1)
          {
            i = 2130841782;
            break label130;
          }
          if (locallga.v == 2)
          {
            i = 2130841784;
            break label130;
          }
          if (locallga.v != 3) {
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
    mqh localmqh;
    do
    {
      return;
      localmqh = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695654);
      if (localmqh != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, null, seq[" + paramLong + "]");
    return;
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1;
    if ((locallga.jdField_d_of_type_Int == 3) || (locallga.jdField_d_of_type_Int == 4) || (locallga.jdField_d_of_type_Int == 1))
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
      localmqh.a(mcu.d(this.jdField_a_of_type_Mcu));
      localmqh.c(bool1);
      return;
      AVActivity localAVActivity = a();
      if (localAVActivity.jdField_a_of_type_Min == null)
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, !mRecordUiCtrl, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if (!localAVActivity.jdField_a_of_type_Min.h())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, !isEnableRecord, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if ((!locallga.jdField_j_of_type_Boolean) || (!locallga.jdField_k_of_type_Boolean))
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + locallga.jdField_j_of_type_Boolean + "][sessionInfo.remoteHasVideo=" + locallga.jdField_k_of_type_Boolean + "]");
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
    if (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131720788));
      axqy.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      axqy.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
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
    if (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Msv);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Mhj != null) {
      this.jdField_a_of_type_Mhj.a(new mcq(this));
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_Mcu.a();
    f(-1027L, 65535);
  }
  
  public void o()
  {
    if (g()) {
      return;
    }
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "refreshUI, SessionType[" + locallga.jdField_d_of_type_Int + "], seq[" + l + "]");
    }
    int i = locallga.jdField_i_of_type_Int;
    String str = locallga.jdField_d_of_type_JavaLangString;
    Object localObject3 = locallga.jdField_f_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
    Object localObject1 = locallga.jdField_e_of_type_JavaLangString;
    if (locallga.jdField_e_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject3);
      locallga.jdField_e_of_type_JavaLangString = ((String)localObject1);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372257));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372258));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370647));
      if (locallga.jdField_d_of_type_Int == 2) {
        d(l, true);
      }
    }
    else
    {
      if (locallga.jdField_d_of_type_Int != 2) {
        break label484;
      }
      d(l, true);
      label249:
      if (locallga.jdField_i_of_type_Int == 1011)
      {
        if (locallga.jdField_a_of_type_Lgb.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label501;
        }
        a(locallga.jdField_a_of_type_Lgb.jdField_a_of_type_AndroidGraphicsBitmap);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(locallga.jdField_a_of_type_Lgb.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(locallga.jdField_a_of_type_Lgb.jdField_b_of_type_JavaLangString);
        }
      }
      label283:
      if (locallga.jdField_i_of_type_Int != 25) {
        break label556;
      }
      localObject2 = locallga.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = locallga.jdField_f_of_type_JavaLangString;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(str);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
      }
      if ((!((String)localObject2).equals(locallga.jdField_d_of_type_JavaLangString)) || (localObject1 == null)) {
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
      if (locallga.jdField_d_of_type_Int != 1) {
        break label249;
      }
      b(false);
      break label249;
      label501:
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label283;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bbef.a());
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
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372227);
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