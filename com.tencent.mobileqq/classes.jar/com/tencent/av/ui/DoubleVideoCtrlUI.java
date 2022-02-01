package com.tencent.av.ui;

import agej;
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
import anzj;
import bdll;
import bhlq;
import bhmq;
import bhpc;
import bhxi;
import blfn;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import lbj;
import lcb;
import lff;
import lfg;
import lha;
import lic;
import lie;
import lkd;
import llk;
import lln;
import lob;
import lsv;
import ltr;
import lzf;
import lzq;
import mbb;
import mct;
import mcx;
import mcz;
import mde;
import mdf;
import mdg;
import mdh;
import mdi;
import mdj;
import mhr;
import mia;
import mjd;
import mkh;
import mmi;
import mng;
import mrd;
import mrk;
import mrs;
import mru;
import msc;
import mtl;
import mty;
import mud;
import mur;
import mvd;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  DoubleVideoCtrlUI.StartTimerRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable = new DoubleVideoCtrlUI.StartTimerRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.1(this);
  Timer jdField_a_of_type_JavaUtilTimer = null;
  mdj jdField_a_of_type_Mdj = new mdj(null);
  mia jdField_a_of_type_Mia = null;
  public boolean a;
  private long jdField_b_of_type_Long = -1L;
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
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mct parammct)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammct);
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
        localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131373351);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockSign((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365689);
          Resources localResources = ((ViewGroup)localObject2).getResources();
          int i = localResources.getDimensionPixelOffset(2131297600);
          int j = localResources.getDimensionPixelOffset(2131297597);
          int k = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
          int m = localResources.getDimensionPixelOffset(2131297598);
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
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.a()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b())) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool;
    int j;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      bool = true;
      paramString.a("doMute", bool);
      j = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label134;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().b("doMute", 1);
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoCtrl.doMute", j, i, false);
      s(true);
      mru.c(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool = false;
      break;
      label134:
      this.jdField_a_of_type_ComTencentAvVideoController.a().b("doMute", 0);
    }
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    VideoController localVideoController = paramVideoAppInterface.a();
    lff locallff = localVideoController.a();
    String str = locallff.jdField_d_of_type_JavaLangString;
    int i;
    if (paramBoolean) {
      if (locallff.a(localVideoController)) {
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
        bdll.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
        if ((i != 3000) || (paramActivity == null) || (!mtl.f())) {
          break label291;
        }
        paramVideoAppInterface = mtl.a();
        bhlq.a(paramActivity, 230, null, paramVideoAppInterface, "", anzj.a(2131702333), new mdg(), null).show();
        if (QLog.isColorLevel()) {
          QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + paramVideoAppInterface + "]");
        }
        bdll.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
        return;
        i = 3000;
        break;
        if (!locallff.b(localVideoController)) {
          break label347;
        }
        i = 1;
        break;
      }
      label291:
      paramActivity = new Intent();
      paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramActivity.putExtra("peerUin", str);
      paramActivity.putExtra("supportUinType", i);
      paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
      paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
      return;
      label347:
      i = 3000;
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface)
  {
    int i = 2131694812;
    VideoController localVideoController = paramVideoAppInterface.a();
    String str = localVideoController.a().jdField_d_of_type_JavaLangString;
    int j = localVideoController.b(str);
    int k = localVideoController.c(str);
    if (localVideoController.a().jdField_j_of_type_Int == 1011) {
      if (k >= 45) {
        break label130;
      }
    }
    while (i != 0)
    {
      mbb.a(paramVideoAppInterface, 1012, i);
      return;
      if (!llk.e()) {
        i = 2131719249;
      } else if (lsv.a(localVideoController.a()) == 1) {
        i = 2131719183;
      } else if (k < 16) {
        i = 2131694813;
      } else if ((j == 4) || (j == 2) || (j == 3)) {
        label130:
        i = 0;
      }
    }
    mbb.a(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    int i = 0;
    int j = paramVideoAppInterface.a().a().jdField_a_of_type_Lfg.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt > 0)
    {
      mbb.a(paramVideoAppInterface, 1048, paramInt);
      return;
      if ((j == 3) || (j == 1))
      {
        paramInt = 2131695339;
      }
      else
      {
        paramInt = 2131695338;
        continue;
        if ((j == 3) || (j == 1))
        {
          paramInt = 2131695334;
        }
        else
        {
          paramInt = 2131695333;
          continue;
          if ((j == 3) || (j == 1)) {
            paramInt = 2131695336;
          } else {
            paramInt = 2131695335;
          }
        }
      }
    }
    mbb.a(paramVideoAppInterface, 1048);
  }
  
  private boolean c()
  {
    long l = System.currentTimeMillis();
    if (l > this.jdField_b_of_type_Long + 200L)
    {
      this.jdField_b_of_type_Long = l;
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
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "StartGlassCheck, cancel old Timer");
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    DoubleVideoCtrlUI.5 local5 = new DoubleVideoCtrlUI.5(this, paramBoolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "StartGlassCheck, begin Timer, bCheck[" + paramBoolean + "]");
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 10000L)
    {
      localTimer.schedule(local5, l);
      return;
    }
  }
  
  private void k(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    paramView = new mcx(paramView);
    paramView.a(paramLong, "onClick_InviteMember");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9000), paramView });
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "onClick_InviteMember block[" + paramView.jdField_b_of_type_Boolean + "]");
    }
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_InviteMember, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
    }
    for (;;)
    {
      l(paramLong, 2131694732);
      return;
      mru.g(this.jdField_a_of_type_ComTencentAvVideoController);
      a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if ((lzq.f()) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
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
  
  private void s(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      ltr.a().a(32);
      super.k(2131373336);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373336, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690158));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label193;
      }
    }
    label193:
    for (paramBoolean = true;; paramBoolean = false)
    {
      q(paramBoolean);
      return;
      ltr.a().b(32);
      super.l(2131373336);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373336, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690147));
      break;
    }
  }
  
  private void v()
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setForground, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "]");
    if (this.jdField_p_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_Boolean) || (lcb.a().a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.c();
  }
  
  protected int a()
  {
    return 2131559699;
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
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131373348);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365689);
          localObject3 = ((ViewGroup)localObject2).getResources();
          int i = ((Resources)localObject3).getDimensionPixelOffset(2131297596);
          int j = ((Resources)localObject3).getDimensionPixelOffset(2131297595);
          int k = ((Resources)localObject3).getDimensionPixelOffset(2131297799);
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
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onTerSwitchSyncStatus, cameraStatus[" + paramInt1 + "], micStatus[" + paramInt2 + "]");
    }
    if (h()) {
      return;
    }
    if (paramInt1 == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      label103:
      lff locallff;
      label155:
      boolean bool;
      if (paramInt1 == 0)
      {
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramInt1 == 0) && (!locallff.k)) {
          break label328;
        }
        if (locallff.jdField_d_of_type_Int == 1)
        {
          locallff.a(l, "onTerSwitchSyncStatus.1", 2);
          a("onTerSwitchSyncStatus.1", locallff.jdField_d_of_type_Int);
        }
        if (paramInt2 != 0) {
          break label362;
        }
        bool = true;
        label162:
        locallff.a("onTerSwitchSyncStatus", bool);
        if (paramInt2 != 0) {
          break label368;
        }
      }
      String str;
      label328:
      label362:
      label368:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        locallff.b("onTerSwitchSyncStatus", paramInt1);
        str = locallff.jdField_d_of_type_JavaLangString;
        if (!locallff.jdField_g_of_type_Boolean) {
          break label373;
        }
        super.k(2131373336);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373336, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690158));
        return;
        i(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
        break label103;
        if (locallff.jdField_d_of_type_Int != 2) {
          break label155;
        }
        locallff.a(l, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", locallff.jdField_d_of_type_Int);
        break label155;
        bool = false;
        break label162;
      }
      label373:
      super.l(2131373336);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373336, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690147));
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
      localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373634);
      localView2 = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373635);
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
          if (!l()) {
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
        localLayoutParams1.topMargin = (paramInt - c() + agej.a(15.0F, this.jdField_a_of_type_AndroidContentResResources));
        if (LiuHaiUtils.b())
        {
          paramInt = localLayoutParams1.topMargin;
          localLayoutParams1.topMargin = (LiuHaiUtils.b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()) + paramInt);
        }
      }
      else
      {
        localLayoutParams1.topMargin = agej.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131373338) || (paramInt1 == 2131373339)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373338, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373338, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().h())
      {
        if (!AVReport.a().jdField_a_of_type_Boolean) {
          break label196;
        }
        lic.a(29);
        AVReport.a().j = SystemClock.elapsedRealtime();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int < 0) {
          break label420;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 1011) {
          break label208;
        }
        a_(-1015L, 2131694823);
        if (this.jdField_a_of_type_Mty != null) {
          this.jdField_a_of_type_Mty.b();
        }
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 20000L);
      }
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().y)) {
          break label437;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
        d(false);
      }
      return;
      label196:
      AVReport.a().y = SystemClock.elapsedRealtime();
      break;
      label208:
      a_(-1015L, 2131694760);
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long;
      String str = bhxi.a(l, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int;
        bdll.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Mty == null) {
          break label418;
        }
        this.jdField_a_of_type_Mty.c();
        this.jdField_a_of_type_Mty.d();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
        }
      }
      label418:
      continue;
      label420:
      if (this.jdField_a_of_type_Mty != null) {
        this.jdField_a_of_type_Mty.b();
      }
    }
    label437:
    s();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], seq[" + paramLong + "]");
    }
    s();
    super.a(paramLong, paramInt);
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int k = locallff.jdField_j_of_type_Int;
    int i;
    int j;
    label99:
    Object localObject;
    if (locallff.jdField_d_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label543;
      }
      j = 1;
      if (((locallff.o()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((locallff.p()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26) || (k == 1044)))) {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          mru.p(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mde(this, paramLong));
          O();
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose phoneNumber is " + (String)localObject);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 3)) {
            break label563;
          }
          if (Build.VERSION.SDK_INT < 17) {
            break label549;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373322, 8);
          localObject = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373335);
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373642, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373335, true);
      localObject = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localObject != null) {
        ((EffectOperateManager)localObject).b(false);
      }
      if (this.jdField_a_of_type_Mty != null)
      {
        this.jdField_a_of_type_Mty.c();
        this.jdField_a_of_type_Mty.e();
        this.jdField_a_of_type_Mty.a();
        this.jdField_a_of_type_Mty = null;
      }
      this.jdField_a_of_type_Boolean = true;
      if ((locallff.l()) && (locallff.jdField_d_of_type_Int == 2) && (!locallff.jdField_j_of_type_Boolean)) {
        mru.e();
      }
      locallff.a("onClose", false);
      locallff.b("onClose", 0);
      if (paramInt == 24)
      {
        this.i = true;
        a_(paramLong, 2131695210);
      }
      if (paramInt == 42) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      return;
      i = 0;
      break;
      label543:
      j = 0;
      break label99;
      label549:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373322, false);
      continue;
      label563:
      bdll.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373322, true);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mVideoController == null");
    }
    label808:
    label1204:
    label1372:
    do
    {
      String str1;
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
            {
              QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mQavPanel == null");
              return;
            }
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().x)
            {
              QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick isChildLock");
              return;
            }
          } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)));
          str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          localObject = a();
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131364381: 
          case 2131365419: 
          case 2131373637: 
            Q();
            return;
          case 2131694733: 
            f(paramLong);
            return;
          case 2131373639: 
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
            lha.f(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) + "");
            this.jdField_b_of_type_Mct.update(null, new Object[] { Integer.valueOf(134) });
            return;
          case 2131373330: 
          case 2131373331: 
          case 2131373332: 
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick Hangup ");
            a(paramView);
            return;
          case 2131373328: 
            bool = c();
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + bool);
          }
        } while (!bool);
        boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().P;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          mru.a(paramView, bool);
          if (this.jdField_a_of_type_Mur == null) {
            break;
          }
          this.jdField_a_of_type_Mur.a(mur.c);
          return;
        }
        c(paramLong, paramView);
        return;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_j_of_type_Int == 1044)) {
          bdll.b(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick HIDE ");
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
        lcj.a = "3";
        a();
        mru.b(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        d(paramLong, paramView);
        return;
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        mru.a(paramView.getId(), i);
        a((AVActivity)localObject, str1);
        return;
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
        k(paramLong, paramView);
        return;
        f(paramLong, paramView);
        return;
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        mrk.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean)
        {
          bool = true;
          paramView.jdField_m_of_type_Boolean = bool;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) {
            break label899;
          }
          bdll.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
        }
        for (i = 2131692594; this.jdField_a_of_type_ComTencentAvUiQavPanel != null; i = 2131692593)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373642, this.jdField_a_of_type_AndroidContentResResources.getString(i));
          return;
          bool = false;
          break label808;
          bdll.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          mur.a().b(paramLong);
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int;
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject, str2, true);
        }
        mru.q(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvVideoController.b(str1, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_z_of_type_Int);
        return;
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Voice");
        h(paramLong, paramView);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      } while ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044));
      bdll.b(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
      return;
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Effect");
      i(paramLong, paramView);
      return;
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
      this.jdField_a_of_type_ComTencentAvVideoController.a(str1, 1, 5, 1);
      a(2131695294, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299011));
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 1) {
          break label1372;
        }
      }
      for (int j = 1;; j = 3)
      {
        bdll.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
        paramView = new Intent((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process&_wwv=4");
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
        l(paramLong, 2131694738);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044)) {
          break;
        }
        bdll.b(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
        return;
        i = 2;
        break label1204;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
      bdll.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.a().w + 1, 0, "", "", "", "");
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g("Sharpness");
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() == 1) {
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramLong);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Mhr.b();
      return;
      g(paramLong, paramView);
      return;
      b(paramLong, paramView);
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044));
    label899:
    bdll.b(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
    return;
    e(paramLong, paramView);
    return;
    j(paramLong, paramView);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setTitleText, mRingAnimator[" + this.jdField_a_of_type_Mty.jdField_a_of_type_Boolean + "], startRingAnimator[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (!TextUtils.isEmpty(paramString)) {
      d(paramLong, paramString);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Mty != null))
    {
      this.jdField_a_of_type_Mty.c();
      this.jdField_a_of_type_Mty.d();
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    i(paramLong, 65535);
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((i == 2) && (lsv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) && (paramBoolean) && (locallff.l()))
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      bdll.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
    }
    e();
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (h()) {
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
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], isConnected[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int + "], mCameraNum[" + this.q + "], remoteHasVideo[" + this.jdField_a_of_type_ComTencentAvVideoController.a().k + "], checkCameraResult[" + bool + "], seq[" + paramLong + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373638, 0);
        localAVActivity = a();
        if (localAVActivity != null) {
          localAVActivity.a(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = true;
        mru.c();
        mru.m(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().k) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
          a("onAfterOpenCamera", 2);
        }
        C(paramLong);
      }
      i(paramLong, 65535);
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
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Hangup, seq[" + l + "]");
    int i = paramView.getId();
    if ((i == 2131373330) || (i == 2131373331)) {
      lbj.d(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramView = new mcx(paramView);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.jdField_b_of_type_Boolean) {
        break;
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Hangup, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
      return;
      if (i == 2131373332) {
        lbj.d(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    g(true);
    this.jdField_a_of_type_Mia.a(new mdh(this, l, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i + "], PhoneNum[" + AudioHelper.a(this.jdField_a_of_type_ComTencentAvVideoController.a().a()) + "]");
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().a())));
    bdll.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(paramString, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setQCallNickName");
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
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avSwitch[" + paramString + "], sessionType[" + paramInt + "], seq[" + l + "]");
    if (this.jdField_a_of_type_Mur != null) {
      this.jdField_a_of_type_Mur.a();
    }
    mud localmud;
    if (paramInt == 1)
    {
      o();
      d(l, false);
      i(l, 65535);
      e(0);
      new mcz(l, "avSwitch", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      localmud = this.jdField_a_of_type_Mud;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label226;
      }
      bool1 = true;
      label149:
      localmud.c(bool1);
      localmud = this.jdField_a_of_type_Mud;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label231;
      }
    }
    label226:
    label231:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmud.b(bool1);
      c(l, paramString + "_avSwitch");
      return;
      if (paramInt != 2) {
        break;
      }
      d(l, true);
      break;
      bool1 = false;
      break label149;
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setQCallHead uin = " + paramString);
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
    lff locallff;
    int i;
    label288:
    label378:
    do
    {
      do
      {
        long l;
        do
        {
          return;
          locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
          l = AudioHelper.b();
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onInviteReached, peerUin[" + paramString1 + "], showMsg[" + paramString2 + "], remotePhoneState[" + locallff.jdField_o_of_type_Int + "], remoteTerminal[" + locallff.l + "], phoneOnLine[" + locallff.jdField_n_of_type_Int + "], pcOnLine[" + locallff.jdField_m_of_type_Int + "], subState[" + locallff.jdField_d_of_type_Long + "], isPeerNetworkWell[" + locallff.r + "], seq[" + l + "]");
        } while ((!locallff.h()) || (locallff.ai) || (locallff.jdField_j_of_type_Int == 1011) || (!locallff.jdField_d_of_type_JavaLangString.contains(paramString1)));
        i = locallff.jdField_o_of_type_Int;
        if (i >= 0)
        {
          if (TextUtils.isEmpty(paramString2)) {
            a_(l, 2131694760);
          }
        }
        else {
          if (locallff.jdField_d_of_type_Long != 0L) {
            break label288;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Mty != null)
          {
            this.jdField_a_of_type_Mty.c();
            this.jdField_a_of_type_Mty.d();
          }
          if ((i <= 0) || (i == 3)) {
            break label378;
          }
          a(i);
          mru.e(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          d(l, paramString2);
          break;
          if (locallff.jdField_d_of_type_Long == 2L)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(locallff.jdField_d_of_type_JavaLangString, 8, 0L);
            if (!TextUtils.isEmpty(locallff.jdField_o_of_type_JavaLangString)) {
              mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3008, locallff.jdField_o_of_type_JavaLangString);
            }
            bdll.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
          }
        }
        if (i != 4) {
          break;
        }
      } while ((locallff.jdField_m_of_type_Int != 1) || (locallff.jdField_n_of_type_Int != 0));
      a(i);
      return;
    } while ((i != 0) || (!locallff.r) || (locallff.l == 2) || (locallff.jdField_d_of_type_Int != 1));
    mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPeerSwitchTerminal, peerUin[" + paramString + "], bStartSwitch[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
    }
    for (;;)
    {
      i(l, 65535);
      paramString = lln.a();
      if (!paramBoolean) {
        break;
      }
      paramString.jdField_b_of_type_Boolean = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.jdField_b_of_type_Boolean);
      }
      lzq.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
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
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363626);
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
          ((QavPanel)localObject).d(paramBoolean2);
        }
        new mkh(this.jdField_a_of_type_AndroidViewViewGroup).a(paramBoolean1);
      }
      c(-1035L, "changeToDoubleScreen");
      return;
    }
  }
  
  public boolean a()
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBackPressed, seq[" + l + "], isChildLock[" + ((lff)localObject).x + "]");
    if (((lff)localObject).x) {
      return true;
    }
    if (super.a())
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBackPressed called return 2, seq[" + l + "]");
      return true;
    }
    v();
    String str = ((lff)localObject).jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((!lzq.f()) && (((lff)localObject).jdField_d_of_type_Int == 2) && (((lff)localObject).jdField_j_of_type_Boolean)) {
      a(2131694888, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299011));
    }
    if ((((lff)localObject).o()) || (((lff)localObject).p()))
    {
      j(((lff)localObject).jdField_z_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.13(this, l), 150L);
    }
    if (lzq.f())
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((lzf)localObject).a();
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
    if (!((lff)localObject).ay) {
      return false;
    }
    if (!((lff)localObject).k)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + paramInt + "]");
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((lff)localObject).R != paramInt)) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassSwitch, GlassSwitch[" + ((lff)localObject).R + "->" + paramInt + "]");
    }
    if (((lff)localObject).R == paramInt) {
      return false;
    }
    ((lff)localObject).R = paramInt;
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
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1039);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x) {
        bool = true;
      }
      return bool;
    }
    this.jdField_a_of_type_Mur.a();
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
        break label474;
      }
      bool = true;
      localQavPanel.a(2131559749, bool, BeautyToolbar.checkShowBeauty(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mur);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1044) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setNoVideoAndShareBtnMode();
      }
    }
    d(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373639));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373366));
    if (AudioHelper.a(0) == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147483392);
    }
    if (Build.VERSION.SDK_INT <= 20)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "need reset quit double screen listener");
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new mdi(this));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373358));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373330, this.jdField_a_of_type_AndroidContentResResources.getString(2131690156));
      }
      d(l, false);
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373336, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373336, false);
      }
      c(l, "initUI");
      this.jdField_a_of_type_Mia = new mia((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373376), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373508), null);
      msc.a(BaseApplicationImpl.getApplication());
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 0))) {
        bdll.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
      }
      return;
      label474:
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373330, this.jdField_a_of_type_AndroidContentResResources.getString(2131719196));
      }
      d(l, true);
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011) && (paramInt != 2131694823) && (paramInt != 2131719190)) {}
    while (paramInt <= 0) {
      return;
    }
    a_(-1016L, paramInt);
  }
  
  public void b(long paramLong)
  {
    boolean bool2 = false;
    super.b(paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((lff)localObject1).l())
    {
      if (((lff)localObject1).jdField_d_of_type_Long != 1L) {
        super.A(paramLong);
      }
      localObject2 = this.jdField_a_of_type_Mud;
      if (((lff)localObject1).jdField_d_of_type_Int != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((mud)localObject2).b(bool1);
      o();
      mru.a(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_d_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!((lff)localObject1).ay)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.9(this), 200L);
      return;
    }
    localObject1 = this.jdField_d_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {
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
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373348);
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
      if (!paramView.jdField_a_of_type_Mng.a()) {
        break label44;
      }
      paramView.jdField_a_of_type_Mng.c(3);
    }
    for (;;)
    {
      lkd.a("0X800A8D0");
      return;
      label44:
      paramView.jdField_a_of_type_Mng.a(0);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      i(paramLong, 65535);
    }
  }
  
  public void b(String paramString) {}
  
  void b(boolean paramBoolean)
  {
    int i = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_Mur != null)
    {
      this.jdField_a_of_type_Mur.a(paramBoolean);
      this.jdField_a_of_type_Mur.a();
    }
    QavPanel localQavPanel;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) {
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131166020));
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean))
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
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l + "]");
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
          mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
          return;
        }
        mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1018);
      bdll.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
        localObject = new blfn((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
        if (msc.a("qav_peer_phone_calling.mp3")) {
          ((blfn)localObject).a(l, 2, 0, null, msc.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_S_of_type_Boolean)
        {
          bdll.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
          ((blfn)localObject).a(l, 0, 2131230737, null, null, false, 1, false, true, 0);
          msc.a(BaseApplicationImpl.getApplication());
        }
        bdll.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
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
    return this.jdField_a_of_type_ComTencentAvVideoController.a().l();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.6(this), 100L);
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()))
    {
      if (!this.jdField_h_of_type_Boolean) {
        e(paramInt);
      }
      return;
    }
    e(paramInt);
    C(l);
  }
  
  public void c(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_p_of_type_Boolean)) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStop, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
    }
    super.c(paramLong);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
      super.B(paramLong);
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
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission local close camera, remote[" + this.jdField_a_of_type_ComTencentAvVideoController.a().k + "]");
        }
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = false;
      i(paramLong, 65535);
    }
    super.c(paramLong, paramInt);
  }
  
  void c(long paramLong, View paramView)
  {
    boolean bool = c();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean + "], localMute[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean + "], seq[" + paramLong + "], canClick[" + bool + "]");
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool)) {
      a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString);
    }
    super.C(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterCloseCamera, success[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    i(paramLong, 65535);
    if (paramBoolean)
    {
      h(true);
      mru.d();
      mru.n(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k) {
        a("onAfterCloseCamera", 1);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k) {
        a(paramLong, 0.0F);
      }
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.a().y = false;
    s();
  }
  
  public void c(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onNotRecvAudioData, bNotRecv[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      this.r = 1;
    }
    while (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) == 5)
      {
        return;
        this.r = 2;
      }
      else
      {
        mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
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
      super.A(l);
      return;
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    s(paramBoolean2);
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avideo onCreate, state[" + ((lff)localObject).jdField_g_of_type_Int + "], seq[" + l + "]");
    b();
    this.jdField_a_of_type_Mur.c();
    if (((lff)localObject).F == 0) {
      ((lff)localObject).F = 3;
    }
    int j;
    int i;
    if ((((lff)localObject).f()) || (((lff)localObject).j()))
    {
      j = 1;
      if (((lff)localObject).jdField_S_of_type_Boolean) {
        j = 0;
      }
      i = 1;
      if (!((lff)localObject).N) {
        i = 4;
      }
      if (1008 == ((lff)localObject).jdField_j_of_type_Int) {
        i = 4;
      }
    }
    label390:
    label525:
    label1191:
    for (;;)
    {
      if (((lff)localObject).jdField_e_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lff)localObject).jdField_d_of_type_JavaLangString, j, i);; i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lff)localObject).jdField_d_of_type_JavaLangString, j, i, ((lff)localObject).i, ((lff)localObject).jdField_j_of_type_JavaLangString, ((lff)localObject).a(), ((lff)localObject).jdField_j_of_type_Int, ((lff)localObject).jdField_f_of_type_JavaLangString, ((lff)localObject).jdField_g_of_type_JavaLangString, ((lff)localObject).jdField_a_of_type_ArrayOfByte, null, null, 0, 0, null, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "result = " + i);
        }
        if (i == 0) {
          break label390;
        }
        lbj.d(this.jdField_d_of_type_JavaLangString, "Video connect fail:" + i);
        if (i == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(((lff)localObject).jdField_d_of_type_JavaLangString, 238);
          this.jdField_a_of_type_ComTencentAvVideoController.b(238);
          this.jdField_a_of_type_ComTencentAvVideoController.b(((lff)localObject).jdField_d_of_type_JavaLangString, 9);
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
        if (1044 != ((lff)localObject).jdField_j_of_type_Int) {
          break label1191;
        }
        i = 4;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, ofter Request, state[" + ((lff)localObject).jdField_g_of_type_Int + "], SessionType[" + ((lff)localObject).jdField_d_of_type_Int + "], deviceName[" + ((lff)localObject).q + "], seq[" + l + "]");
      }
      label495:
      String str;
      if (((lff)localObject).h())
      {
        if (((lff)localObject).jdField_d_of_type_Int == 1)
        {
          this.jdField_e_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          this.jdField_a_of_type_Mur.a(this.jdField_e_of_type_JavaLangString);
        }
      }
      else
      {
        if (!((lff)localObject).l()) {
          break label756;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label708;
        }
        if (((lff)localObject).jdField_d_of_type_Int == 2) {
          d(l, true);
        }
        i = ((lff)localObject).jdField_j_of_type_Int;
        str = ((lff)localObject).jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
        label563:
        if (((lff)localObject).jdField_n_of_type_Boolean) {
          o();
        }
        if (((lff)localObject).jdField_S_of_type_Boolean)
        {
          this.jdField_a_of_type_Mud.c(true);
          this.jdField_a_of_type_Mud.c(true);
        }
        if (!((lff)localObject).jdField_g_of_type_Boolean) {
          break label1134;
        }
        super.k(2131373336);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373336, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690158));
        }
      }
      for (;;)
      {
        a(l, false);
        this.jdField_a_of_type_AndroidViewViewGroup.post(new DoubleVideoCtrlUI.8(this));
        if (this.jdField_a_of_type_Mia == null) {
          break;
        }
        this.jdField_a_of_type_Mia.a();
        return;
        this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label495;
        label708:
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) || (((lff)localObject).jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.b(((lff)localObject).jdField_d_of_type_JavaLangString) != 5)) {
          break label525;
        }
        mru.f(this.jdField_a_of_type_ComTencentAvVideoController);
        break label525;
        label756:
        if (((lff)localObject).k())
        {
          if (((lff)localObject).jdField_S_of_type_Boolean) {}
          for (i = 2131694898;; i = 2131719258)
          {
            b(i);
            break;
          }
        }
        if (((lff)localObject).h())
        {
          i = 2131695244;
          if (((lff)localObject).ai) {
            i = 2131695245;
          }
          if (((lff)localObject).jdField_j_of_type_Int == 1011) {
            i = 2131694823;
          }
          if (((lff)localObject).jdField_S_of_type_Boolean)
          {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "Inviting, remotePhoneState[" + ((lff)localObject).jdField_o_of_type_Int + "], isPeerNetworkWell[" + ((lff)localObject).r + "], remoteOnline[" + ((lff)localObject).s + "], remoteTerminal[" + ((lff)localObject).l + "]");
            if ((((lff)localObject).jdField_o_of_type_Int == 0) && (((lff)localObject).r) && (((lff)localObject).l != 2) && (((lff)localObject).jdField_d_of_type_Int == 1)) {
              mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
            }
          }
          b(i);
          i = ((lff)localObject).jdField_j_of_type_Int;
          str = ((lff)localObject).jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
          i = ((lff)localObject).jdField_o_of_type_Int;
          if ((i == 4) && (((lff)localObject).jdField_m_of_type_Int == 1) && (((lff)localObject).jdField_n_of_type_Int == 0)) {
            a(i);
          }
          if ((i <= 0) || (i == 3)) {
            break label563;
          }
          a(i);
          mru.e(this.jdField_a_of_type_ComTencentAvVideoController);
          break label563;
        }
        if (((lff)localObject).j())
        {
          b(2131695087);
          break label563;
        }
        if ((!((lff)localObject).o()) && (!((lff)localObject).p())) {
          break label563;
        }
        j(((lff)localObject).jdField_z_of_type_Int);
        if (((lff)localObject).jdField_j_of_type_Int == 1011) {
          b(2131695217);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.7(this, l), 150L);
        break label563;
        label1134:
        super.l(2131373336);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373336, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690147));
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
        } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().t != 2) || (localObject1 == null) || (!((ChildLockSign)localObject1).isEnabled()));
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
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373348);
        }
      }
    } while (localObject1 == null);
  }
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
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
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365689);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_b_of_type_Mct = null;
    this.jdField_a_of_type_Mtt = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    if (this.jdField_a_of_type_Mia != null)
    {
      this.jdField_a_of_type_Mia.b();
      this.jdField_a_of_type_Mia = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373377));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373378));
    i(paramLong, 65535);
    e();
  }
  
  void d(long paramLong, View paramView)
  {
    Object localObject = new mcx(paramView);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), localObject });
    }
    if (((mcx)localObject).jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, mBlockName[" + ((mcx)localObject).jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131694728);
      return;
      if (a(paramLong, "android.permission.CAMERA", paramView))
      {
        lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
        mru.h(this.jdField_a_of_type_ComTencentAvVideoController);
        if (locallff.jdField_d_of_type_Int == 1)
        {
          lob locallob = new lob();
          localObject = locallff.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject;
          if (((String)localObject).startsWith("+")) {
            paramView = ((String)localObject).substring(1);
          }
          locallob.jdField_a_of_type_Long = mrs.a(paramView);
          locallob.jdField_a_of_type_Int = 1;
          paramView = new ArrayList();
          paramView.add(locallob);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
          i(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, open1, seq[" + paramLong + "]");
          }
          bdll.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
          if (locallff.y) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.14(this), 500L);
          }
        }
        else if (locallff.jdField_d_of_type_Int == 2)
        {
          if (locallff.jdField_j_of_type_Boolean)
          {
            j(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, close, seq[" + paramLong + "]");
            }
          }
          else
          {
            i(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, open2, seq[" + paramLong + "]");
            }
          }
        }
      }
    }
  }
  
  void d(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (h()) {
      return;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, 0, false);
      if (this.jdField_a_of_type_Mur != null) {
        this.jdField_a_of_type_Mur.a();
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
      j(paramLong, 8);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      a(Boolean.valueOf(paramBoolean));
      return;
      i(-1014L, 65535);
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
      j(paramLong, 0);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().x)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_z_of_type_Boolean = this.jdField_h_of_type_Boolean;
      if (this.jdField_h_of_type_Boolean) {
        e(0);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373638, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373642, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373636, 8);
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
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(locallff.jdField_d_of_type_JavaLangString);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onConnected, roomid[" + l + "], mNeedRemoveAudioCallback[" + this.jdField_c_of_type_Boolean + "], seq[" + paramLong + "]");
    super.e(paramLong);
    k(paramLong);
    if (l > 0L) {
      ((lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    String str = l + "";
    mmi.a(locallff.jdField_d_of_type_Int, str + "");
    if (locallff.jdField_h_of_type_Int != 4) {
      a_(paramLong, 2131694887);
    }
    mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
    mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
    label306:
    label328:
    int i;
    int j;
    label380:
    mud localmud;
    if (!locallff.jdField_e_of_type_Boolean)
    {
      if (locallff.P)
      {
        bdll.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!locallff.jdField_g_of_type_Boolean) {
          break label608;
        }
        bdll.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        mru.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (locallff.jdField_d_of_type_Int != 2) {
        break label644;
      }
      d(paramLong, true);
      a(paramLong, true);
      str = locallff.jdField_d_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
      if (i != 5) {
        break label663;
      }
      if (!locallff.am) {
        break label652;
      }
      super.A(paramLong);
      localmud = this.jdField_a_of_type_Mud;
      if (locallff.jdField_d_of_type_Int != 1) {
        break label788;
      }
    }
    label644:
    label652:
    label788:
    for (boolean bool = true;; bool = false)
    {
      localmud.b(bool);
      i = locallff.jdField_j_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_Mty != null)
      {
        this.jdField_a_of_type_Mty.c();
        this.jdField_a_of_type_Mty.e();
        this.jdField_a_of_type_Mty.a();
        this.jdField_a_of_type_Mty = null;
      }
      if (locallff.jdField_n_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      }
      if (locallff.jdField_d_of_type_Int == 2)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onConnected, CheckRemoteCameraRunnable");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      }
      if ((locallff.jdField_n_of_type_Boolean) && (!locallff.k)) {
        a("onConnected", 1);
      }
      return;
      bdll.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      label608:
      bdll.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label306;
      h(true);
      break label328;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label380;
      label663:
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
      {
        if (locallff.am)
        {
          super.A(paramLong);
          break label380;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label380;
      }
      if (!locallff.l())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label380;
      }
      if (j > 18)
      {
        if ((locallff.am) && (locallff.an))
        {
          super.A(paramLong);
          break label380;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label380;
      }
      if (locallff.am)
      {
        super.A(paramLong);
        break label380;
      }
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label380;
    }
  }
  
  public void e(long paramLong, View paramView)
  {
    if (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) < 1000L) {}
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (paramView == null);
    mvd.a("0X800AD8D");
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    l(paramLong, 2131694734);
    paramView.a(paramLong);
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
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramInt != locallff.jdField_S_of_type_Int) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassWaitTime, WaitTime[" + locallff.jdField_S_of_type_Int + "->" + paramInt + "]");
    }
    locallff.jdField_S_of_type_Int = paramInt;
  }
  
  protected void f(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_Mdj.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
      i(paramLong, 65535);
      l(paramLong, 2131694733);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
    }
  }
  
  public void g(long paramLong)
  {
    int k = 0;
    if (h()) {
      return;
    }
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373636);
    if ((!mtl.e()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = " + mtl.e());
    }
    for (int j = 0;; j = 1)
    {
      lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localImageButton == null) {
        break;
      }
      int i;
      if (locallff.w == 0) {
        i = 2130842267;
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
          ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373427)).setVisibility(4);
          return;
          if (locallff.w == 1)
          {
            i = 2130842268;
            break label130;
          }
          if (locallff.w == 2)
          {
            i = 2130842270;
            break label130;
          }
          if (locallff.w != 3) {
            break label227;
          }
          i = 2130842269;
          break label130;
        }
        label227:
        i = 2130842267;
      }
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPauseVideo, seq[" + l + "]");
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
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onResumeVideo setRotation");
        }
        a(l, 0.0F);
      }
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a().R = 0;
    }
  }
  
  public void h(long paramLong)
  {
    boolean bool2 = false;
    if (h()) {}
    mrd localmrd;
    do
    {
      return;
      localmrd = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131694733);
      if (localmrd != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, null, seq[" + paramLong + "]");
    return;
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1;
    if ((locallff.jdField_d_of_type_Int == 3) || (locallff.jdField_d_of_type_Int == 4) || (locallff.jdField_d_of_type_Int == 1))
    {
      bool1 = bool2;
      if (jdField_o_of_type_Boolean)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, 场景不支持, seq[" + paramLong + "]");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localmrd.a(mdj.d(this.jdField_a_of_type_Mdj));
      localmrd.c(bool1);
      return;
      AVActivity localAVActivity = a();
      if (localAVActivity.jdField_a_of_type_Mjd == null)
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, !mRecordUiCtrl, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if (!localAVActivity.jdField_a_of_type_Mjd.h())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, !isEnableRecord, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if ((!locallff.jdField_j_of_type_Boolean) || (!locallff.k))
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + locallff.jdField_j_of_type_Boolean + "][sessionInfo.remoteHasVideo=" + locallff.k + "]");
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
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onResumeVideo, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "], seq[" + l + "]");
    if (lsv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131719229));
      bdll.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      bdll.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onResumeVideo", 2);
      a("onResumeVideo", 2);
      ThreadManager.excute(new DoubleVideoCtrlUI.11(this, l), 16, null, false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().y) {
        d(true);
      }
    }
    for (;;)
    {
      C(l);
      return;
      i(l, 65535);
    }
  }
  
  public void i(long paramLong)
  {
    i(paramLong, 65535);
  }
  
  public void j() {}
  
  public void j(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBeforeCloseCamera, seq[" + paramLong + "]");
    }
    i(paramLong, 65535);
  }
  
  public void k()
  {
    if (lsv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    long l = AudioHelper.b();
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean + ", seq[" + l + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean)
    {
      a("onNeedShowPeerVideo.1", 2);
      i(l, 65535);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onNeedShowPeerVideo.2", 2);
      a("onNeedShowPeerVideo.2", 2);
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void k(long paramLong)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l())
    {
      mrd localmrd = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131694734);
      if (localmrd != null) {
        localmrd.c(false);
      }
      return;
    }
    super.k(paramLong);
  }
  
  void l()
  {
    H();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtt);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Mia != null) {
      this.jdField_a_of_type_Mia.a(new mdf(this));
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_Mdj.a();
    i(-1027L, 65535);
  }
  
  public void o()
  {
    if (h()) {
      return;
    }
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshUI, SessionType[" + locallff.jdField_d_of_type_Int + "], seq[" + l + "]");
    }
    int i = locallff.jdField_j_of_type_Int;
    String str = locallff.jdField_d_of_type_JavaLangString;
    Object localObject3 = locallff.jdField_f_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
    Object localObject1 = locallff.jdField_e_of_type_JavaLangString;
    if (locallff.jdField_e_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject3);
      locallff.jdField_e_of_type_JavaLangString = ((String)localObject1);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373377));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373378));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371647));
      if (locallff.jdField_d_of_type_Int == 2) {
        d(l, true);
      }
    }
    else
    {
      if (locallff.jdField_d_of_type_Int != 2) {
        break label483;
      }
      d(l, true);
      label248:
      if (locallff.jdField_j_of_type_Int == 1011)
      {
        if (locallff.jdField_a_of_type_Lfg.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label500;
        }
        a(locallff.jdField_a_of_type_Lfg.jdField_a_of_type_AndroidGraphicsBitmap);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(locallff.jdField_a_of_type_Lfg.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(locallff.jdField_a_of_type_Lfg.jdField_b_of_type_JavaLangString);
        }
      }
      label282:
      if (locallff.jdField_j_of_type_Int != 25) {
        break label555;
      }
      localObject2 = locallff.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = locallff.jdField_f_of_type_JavaLangString;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(str);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
      }
      if ((!((String)localObject2).equals(locallff.jdField_d_of_type_JavaLangString)) || (localObject1 == null)) {
        break label520;
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
      i(l, 65535);
      return;
      d(l, false);
      break;
      label483:
      if (locallff.jdField_d_of_type_Int != 1) {
        break label248;
      }
      b(false);
      break label248;
      label500:
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label282;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bhmq.a());
      break label282;
      label520:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        continue;
        label555:
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
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x)) {
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
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373348);
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
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().x)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.18(this, l), 300L);
    }
  }
  
  public void t()
  {
    long l = AudioHelper.b();
    if (AudioHelper.f()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onSelfAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L) {
        super.A(l);
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
              if (this.jdField_a_of_type_ComTencentAvVideoController.e()) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
            super.A(l);
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().l());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().an);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
      super.A(l);
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    super.A(l);
  }
  
  public void u()
  {
    long l = AudioHelper.b();
    if (AudioHelper.f()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onOppositeAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().am)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    super.A(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */