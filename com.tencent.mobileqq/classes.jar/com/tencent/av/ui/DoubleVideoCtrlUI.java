package com.tencent.av.ui;

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
import anvx;
import bdla;
import bhdj;
import bheg;
import bhml;
import bkxc;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import lbd;
import lbz;
import lfe;
import lff;
import lhg;
import lii;
import lik;
import lkj;
import lll;
import llq;
import lls;
import lob;
import lsq;
import ltm;
import lvy;
import lzh;
import lzr;
import mbf;
import mcx;
import mdb;
import mdd;
import mdi;
import mdj;
import mdk;
import mdl;
import mdm;
import mdn;
import mdo;
import mhw;
import mif;
import mji;
import mkn;
import mmo;
import mnm;
import mrj;
import mrq;
import mrr;
import mry;
import msa;
import msi;
import mtr;
import muf;
import muk;
import muy;
import mvk;
import mwz;
import mxd;
import mxk;
import mym;
import myw;
import myx;
import nab;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  private int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  DoubleVideoCtrlUI.StartTimerRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable = new DoubleVideoCtrlUI.StartTimerRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.1(this);
  Timer jdField_a_of_type_JavaUtilTimer = null;
  mdo jdField_a_of_type_Mdo = new mdo(null);
  mif jdField_a_of_type_Mif = null;
  mwz jdField_a_of_type_Mwz = null;
  public boolean a;
  private long jdField_b_of_type_Long = -1L;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.2(this);
  public boolean b;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.3(this);
  public boolean c;
  Runnable jdField_d_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.4(this);
  boolean jdField_d_of_type_Boolean = false;
  Runnable jdField_e_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.5(this);
  boolean jdField_e_of_type_Boolean = false;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcx parammcx)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammcx);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
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
        localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131373480);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockSign((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365816);
          Resources localResources = ((ViewGroup)localObject2).getResources();
          int i = localResources.getDimensionPixelOffset(2131297656);
          int j = localResources.getDimensionPixelOffset(2131297653);
          int k = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
          int m = localResources.getDimensionPixelOffset(2131297654);
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
      msa.c(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool = false;
      break;
      label134:
      this.jdField_a_of_type_ComTencentAvVideoController.a().b("doMute", 0);
    }
  }
  
  private void a(long paramLong, lfe paramlfe)
  {
    boolean bool = true;
    if (h()) {
      return;
    }
    if (paramlfe.A())
    {
      mxd localmxd = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if (localmxd != null) {
        localmxd.d(paramlfe);
      }
      mrr.a("0X800B632", 0, 0, "", "", "", "");
      bool = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(this.jdField_d_of_type_JavaLangString, 4, "onClick_WatchTogether, open[" + bool + "]");
      return;
      nab.a(a(), 2, paramlfe.jdField_j_of_type_Int, paramlfe.jdField_d_of_type_JavaLangString);
      mrr.a("0X800B61C", 0, 1, "", "", "", "");
    }
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    VideoController localVideoController = paramVideoAppInterface.a();
    lfe locallfe = localVideoController.a();
    String str = locallfe.jdField_d_of_type_JavaLangString;
    int i;
    if (paramBoolean) {
      if (locallfe.a(localVideoController)) {
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
        bdla.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
        if ((i != 3000) || (paramActivity == null) || (!mtr.f())) {
          break label286;
        }
        paramVideoAppInterface = mtr.a();
        bhdj.a(paramActivity, 230, null, paramVideoAppInterface, "", anvx.a(2131702919), new mdm(), null).show();
        if (QLog.isColorLevel()) {
          QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + paramVideoAppInterface + "]");
        }
        bdla.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
        return;
        i = 3000;
        break;
        if (!locallfe.b(localVideoController)) {
          break label342;
        }
        i = 1;
        break;
      }
      label286:
      paramActivity = new Intent();
      paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramActivity.putExtra("peerUin", str);
      paramActivity.putExtra("supportUinType", i);
      paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
      paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
      return;
      label342:
      i = 3000;
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface)
  {
    int i = 2131695166;
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
      mbf.a(paramVideoAppInterface, 1012, i);
      return;
      if (!llq.e()) {
        i = 2131719987;
      } else if (lsq.a(localVideoController.a()) == 1) {
        i = 2131719921;
      } else if (k < 16) {
        i = 2131695167;
      } else if ((j == 4) || (j == 2) || (j == 3)) {
        label130:
        i = 0;
      }
    }
    mbf.a(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    int i = 0;
    int j = paramVideoAppInterface.a().a().jdField_a_of_type_Lff.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt > 0)
    {
      mbf.a(paramVideoAppInterface, 1048, paramInt);
      return;
      if ((j == 3) || (j == 1))
      {
        paramInt = 2131695695;
      }
      else
      {
        paramInt = 2131695694;
        continue;
        if ((j == 3) || (j == 1))
        {
          paramInt = 2131695690;
        }
        else
        {
          paramInt = 2131695689;
          continue;
          if ((j == 3) || (j == 1)) {
            paramInt = 2131695692;
          } else {
            paramInt = 2131695691;
          }
        }
      }
    }
    mbf.a(paramVideoAppInterface, 1048);
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
  
  private boolean d()
  {
    Object localObject = lbz.a().a();
    if ((localObject == null) || (!((lfe)localObject).A())) {}
    do
    {
      do
      {
        return true;
        localObject = a();
      } while (localObject == null);
      localObject = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    } while ((localObject == null) || (((VideoLayerUI)localObject).g() == 1));
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
    DoubleVideoCtrlUI.8 local8 = new DoubleVideoCtrlUI.8(this, paramBoolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "StartGlassCheck, begin Timer, bCheck[" + paramBoolean + "]");
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 10000L)
    {
      localTimer.schedule(local8, l);
      return;
    }
  }
  
  private void l(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    paramView = new mdb(paramView);
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
      l(paramLong, 2131695084);
      return;
      msa.g(this.jdField_a_of_type_ComTencentAvVideoController);
      a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if ((lzr.f()) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
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
      ltm.a().a(32);
      super.k(2131373465);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690221));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label193;
      }
    }
    label193:
    for (paramBoolean = true;; paramBoolean = false)
    {
      q(paramBoolean);
      return;
      ltm.a().b(32);
      super.l(2131373465);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690208));
      break;
    }
  }
  
  private void v()
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setForground, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "]");
    if (this.jdField_p_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_Boolean) || (lbz.a().a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b();
  }
  
  private void w()
  {
    boolean bool2 = true;
    Object localObject = a();
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localWatchTogetherMediaPlayCtrl != null) && (localObject != null) && (locallfe != null) && (locallfe.A()))
    {
      localObject = ((AVActivity)localObject).a(localWatchTogetherMediaPlayCtrl.i());
      if (this.jdField_h_of_type_Boolean) {
        break label90;
      }
      bool1 = true;
      locallfe.c(bool1);
      if (this.jdField_h_of_type_Boolean) {
        break label95;
      }
    }
    label90:
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((mym)localObject).setImmersiveStatus(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected int a()
  {
    return 2131559737;
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
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131373477);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365816);
          localObject3 = ((ViewGroup)localObject2).getResources();
          int i = ((Resources)localObject3).getDimensionPixelOffset(2131297652);
          int j = ((Resources)localObject3).getDimensionPixelOffset(2131297651);
          int k = ((Resources)localObject3).getDimensionPixelOffset(2131297855);
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
      label104:
      lfe locallfe;
      label156:
      boolean bool;
      if (paramInt1 == 0)
      {
        k(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramInt1 == 0) && (!locallfe.k)) {
          break label329;
        }
        if (locallfe.jdField_d_of_type_Int == 1)
        {
          locallfe.a(l, "onTerSwitchSyncStatus.1", 2);
          a("onTerSwitchSyncStatus.1", locallfe.jdField_d_of_type_Int);
        }
        if (paramInt2 != 0) {
          break label363;
        }
        bool = true;
        label163:
        locallfe.a("onTerSwitchSyncStatus", bool);
        if (paramInt2 != 0) {
          break label369;
        }
      }
      String str;
      label329:
      label363:
      label369:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        locallfe.b("onTerSwitchSyncStatus", paramInt1);
        str = locallfe.jdField_d_of_type_JavaLangString;
        if (!locallfe.jdField_g_of_type_Boolean) {
          break label374;
        }
        super.k(2131373465);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690221));
        return;
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
        break label104;
        if (locallfe.jdField_d_of_type_Int != 2) {
          break label156;
        }
        locallfe.a(l, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", locallfe.jdField_d_of_type_Int);
        break label156;
        bool = false;
        break label163;
      }
      label374:
      super.l(2131373465);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690208));
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
      localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373763);
      localView2 = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373764);
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
          localLayoutParams1.topMargin = (paramInt - d() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
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
      localLayoutParams1.topMargin = (-d() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
      continue;
      label173:
      if (!paramBoolean)
      {
        localLayoutParams1.topMargin = (paramInt - d() + AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentResResources));
        if (LiuHaiUtils.b())
        {
          paramInt = localLayoutParams1.topMargin;
          localLayoutParams1.topMargin = (LiuHaiUtils.b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()) + paramInt);
        }
      }
      else
      {
        localLayoutParams1.topMargin = AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131373467) || (paramInt1 == 2131373468)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373467, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373467, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().h())
      {
        if (!lvy.a().jdField_a_of_type_Boolean) {
          break label196;
        }
        lii.a(29);
        lvy.a().j = SystemClock.elapsedRealtime();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int < 0) {
          break label414;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 1011) {
          break label208;
        }
        a_(-1015L, 2131695177);
        if (this.jdField_a_of_type_Muf != null) {
          this.jdField_a_of_type_Muf.b();
        }
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
      }
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().y)) {
          break label431;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
        d(false);
      }
      return;
      label196:
      lvy.a().y = SystemClock.elapsedRealtime();
      break;
      label208:
      a_(-1015L, 2131695114);
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long;
      String str = bhml.a(l, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          muy.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int;
        bdla.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Muf == null) {
          break label412;
        }
        this.jdField_a_of_type_Muf.c();
        this.jdField_a_of_type_Muf.d();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          muy.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
        }
      }
      label412:
      continue;
      label414:
      if (this.jdField_a_of_type_Muf != null) {
        this.jdField_a_of_type_Muf.b();
      }
    }
    label431:
    s();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], seq[" + paramLong + "]");
    }
    s();
    super.a(paramLong, paramInt);
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int k = locallfe.jdField_j_of_type_Int;
    int i;
    int j;
    label100:
    Object localObject;
    if (locallfe.jdField_d_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label544;
      }
      j = 1;
      if (((locallfe.o()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((locallfe.p()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26) || (k == 1044)))) {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          msa.p(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mdi(this, paramLong));
          O();
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose phoneNumber is " + (String)localObject);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 3)) {
            break label564;
          }
          if (Build.VERSION.SDK_INT < 17) {
            break label550;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373451, 8);
          localObject = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373464);
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373464, true);
      localObject = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localObject != null) {
        ((EffectOperateManager)localObject).b(false);
      }
      if (this.jdField_a_of_type_Muf != null)
      {
        this.jdField_a_of_type_Muf.c();
        this.jdField_a_of_type_Muf.e();
        this.jdField_a_of_type_Muf.a();
        this.jdField_a_of_type_Muf = null;
      }
      this.jdField_b_of_type_Boolean = true;
      if ((locallfe.l()) && (locallfe.jdField_d_of_type_Int == 2) && (!locallfe.jdField_j_of_type_Boolean)) {
        msa.e();
      }
      locallfe.a("onClose", false);
      locallfe.b("onClose", 0);
      if (paramInt == 24)
      {
        this.i = true;
        a_(paramLong, 2131695566);
      }
      if (paramInt == 42) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      return;
      i = 0;
      break;
      label544:
      j = 0;
      break label100;
      label550:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373451, false);
      continue;
      label564:
      bdla.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373451, true);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mVideoController == null");
    }
    label810:
    label895:
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
          case 2131364480: 
          case 2131365544: 
          case 2131373766: 
            Q();
            return;
          case 2131695085: 
            g(paramLong);
            return;
          case 2131373768: 
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
            lhg.f(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) + "");
            this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(134) });
            return;
          case 2131373459: 
          case 2131373460: 
          case 2131373461: 
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick Hangup ");
            a(paramView);
            return;
          case 2131373457: 
            bool = c();
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + bool);
          }
        } while (!bool);
        boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().P;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          msa.a(paramView, bool);
          if (this.jdField_a_of_type_Muy == null) {
            break;
          }
          this.jdField_a_of_type_Muy.a(muy.c);
          return;
        }
        d(paramLong, paramView);
        return;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_j_of_type_Int == 1044)) {
          bdla.b(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick HIDE ");
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
        lci.a = "3";
        a();
        msa.b(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        e(paramLong, paramView);
        return;
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        msa.a(paramView.getId(), i);
        a((AVActivity)localObject, str1);
        return;
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
        l(paramLong, paramView);
        return;
        g(paramLong, paramView);
        return;
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        mrq.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean)
        {
          bool = true;
          paramView.jdField_m_of_type_Boolean = bool;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) {
            break label895;
          }
          bdla.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
        }
        for (i = 2131692744; this.jdField_a_of_type_ComTencentAvUiQavPanel != null; i = 2131692743)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373771, this.jdField_a_of_type_AndroidContentResResources.getString(i));
          return;
          bool = false;
          break label810;
          bdla.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          muy.a().b(paramLong);
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int;
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject, str2, true);
        }
        msa.q(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvVideoController.b(str1, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_z_of_type_Int);
        return;
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Voice");
        i(paramLong, paramView);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      } while ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044));
      bdla.b(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
      return;
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Effect");
      j(paramLong, paramView);
      return;
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
      this.jdField_a_of_type_ComTencentAvVideoController.a(str1, 1, 5, 1);
      a(2131695650, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299080));
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 1) {
          break label1344;
        }
      }
      for (int j = 1;; j = 3)
      {
        bdla.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
        paramView = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process&_wwv=4");
        ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
        l(paramLong, 2131695090);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044)) {
          break;
        }
        bdla.b(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
        return;
        i = 2;
        break label1188;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
      bdla.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.a().w + 1, 0, "", "", "", "");
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g("Sharpness");
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() == 1) {
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramLong);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Mhw.b();
      return;
      h(paramLong, paramView);
      return;
      b(paramLong, paramView);
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044));
    label1188:
    label1344:
    bdla.b(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
    return;
    f(paramLong, paramView);
    return;
    k(paramLong, paramView);
    return;
    c(paramLong, paramView);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setTitleText, mRingAnimator[" + this.jdField_a_of_type_Muf.jdField_a_of_type_Boolean + "], startRingAnimator[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (!TextUtils.isEmpty(paramString)) {
      d(paramLong, paramString);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Muf != null))
    {
      this.jdField_a_of_type_Muf.c();
      this.jdField_a_of_type_Muf.d();
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    i(paramLong, 16777215);
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((i == 2) && (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) && (paramBoolean) && (locallfe.l()))
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      bdla.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373767, 0);
        localAVActivity = a();
        if (localAVActivity != null) {
          localAVActivity.a(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = true;
        msa.c();
        msa.m(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().k) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
          a("onAfterOpenCamera", 2);
        }
        D(paramLong);
      }
      i(paramLong, 16777215);
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
    if ((i == 2131373459) || (i == 2131373460)) {
      lbd.g(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramView = new mdb(paramView);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.jdField_b_of_type_Boolean) {
        break;
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Hangup, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
      return;
      if (i == 2131373461) {
        lbd.g(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    g(true);
    this.jdField_a_of_type_Mif.a(new mdl(this, l, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i + "], PhoneNum[" + AudioHelper.a(this.jdField_a_of_type_ComTencentAvVideoController.a().a()) + "]");
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().a())));
    bdla.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.jdField_b_of_type_Boolean = true;
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
    if (this.jdField_a_of_type_Muy != null) {
      this.jdField_a_of_type_Muy.a();
    }
    muk localmuk;
    if (paramInt == 1)
    {
      o();
      d(l, false);
      i(l, 16777215);
      e(0);
      new mdd(l, "avSwitch", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      localmuk = this.jdField_a_of_type_Muk;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label227;
      }
      bool1 = true;
      label150:
      localmuk.c(bool1);
      localmuk = this.jdField_a_of_type_Muk;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label232;
      }
    }
    label227:
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmuk.b(bool1);
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
    lfe locallfe;
    int i;
    label289:
    label373:
    do
    {
      do
      {
        long l;
        do
        {
          return;
          locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
          l = AudioHelper.b();
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onInviteReached, peerUin[" + paramString1 + "], showMsg[" + paramString2 + "], remotePhoneState[" + locallfe.jdField_o_of_type_Int + "], remoteTerminal[" + locallfe.l + "], phoneOnLine[" + locallfe.jdField_n_of_type_Int + "], pcOnLine[" + locallfe.jdField_m_of_type_Int + "], subState[" + locallfe.jdField_d_of_type_Long + "], isPeerNetworkWell[" + locallfe.r + "], seq[" + l + "]");
        } while ((!locallfe.h()) || (locallfe.ai) || (locallfe.jdField_j_of_type_Int == 1011) || (!locallfe.jdField_d_of_type_JavaLangString.contains(paramString1)));
        i = locallfe.jdField_o_of_type_Int;
        if (i >= 0)
        {
          if (TextUtils.isEmpty(paramString2)) {
            a_(l, 2131695114);
          }
        }
        else {
          if (locallfe.jdField_d_of_type_Long != 0L) {
            break label289;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Muf != null)
          {
            this.jdField_a_of_type_Muf.c();
            this.jdField_a_of_type_Muf.d();
          }
          if ((i <= 0) || (i == 3)) {
            break label373;
          }
          a(i);
          msa.e(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          d(l, paramString2);
          break;
          if (locallfe.jdField_d_of_type_Long == 2L)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(locallfe.jdField_d_of_type_JavaLangString, 8, 0L);
            if (!TextUtils.isEmpty(locallfe.jdField_o_of_type_JavaLangString)) {
              mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3008, locallfe.jdField_o_of_type_JavaLangString);
            }
            bdla.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
          }
        }
        if (i != 4) {
          break;
        }
      } while ((locallfe.jdField_m_of_type_Int != 1) || (locallfe.jdField_n_of_type_Int != 0));
      a(i);
      return;
    } while ((i != 0) || (!locallfe.r) || (locallfe.l == 2) || (locallfe.jdField_d_of_type_Int != 1));
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPeerSwitchTerminal, peerUin[" + paramString + "], bStartSwitch[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
    }
    for (;;)
    {
      i(l, 16777215);
      paramString = lls.a();
      if (!paramBoolean) {
        break;
      }
      paramString.jdField_b_of_type_Boolean = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.jdField_b_of_type_Boolean);
      }
      lzr.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        k(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.z();
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363727);
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
        new mkn(this.jdField_a_of_type_AndroidViewViewGroup).a(paramBoolean1);
      }
      c(-1035L, "changeToDoubleScreen");
      return;
    }
  }
  
  public boolean a()
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBackPressed, seq[" + l + "], isChildLock[" + ((lfe)localObject).x + "]");
    if (((lfe)localObject).x) {
      return true;
    }
    if (super.a())
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBackPressed called return 2, seq[" + l + "]");
      return true;
    }
    v();
    String str = ((lfe)localObject).jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((!lzr.f()) && (((lfe)localObject).jdField_d_of_type_Int == 2) && (((lfe)localObject).jdField_j_of_type_Boolean)) {
      a(2131695242, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299080));
    }
    if ((((lfe)localObject).o()) || (((lfe)localObject).p()))
    {
      j(((lfe)localObject).jdField_z_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.16(this, l), 150L);
    }
    if (lzr.f())
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((lzh)localObject).a();
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
    if (!((lfe)localObject).ay) {
      return false;
    }
    if (!((lfe)localObject).k)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + paramInt + "]");
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((lfe)localObject).R != paramInt)) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassSwitch, GlassSwitch[" + ((lfe)localObject).R + "->" + paramInt + "]");
    }
    if (((lfe)localObject).R == paramInt) {
      return false;
    }
    ((lfe)localObject).R = paramInt;
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
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1039);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentAvVideoController.a().x;
    }
    this.jdField_a_of_type_Muy.a();
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
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
        break label468;
      }
      bool = true;
      localQavPanel.a(2131559787, bool, BeautyToolbar.checkShowBeauty(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Muy);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1044) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setNoVideoAndShareBtnMode();
      }
    }
    d(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371803));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373768));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373495));
    if (AudioHelper.a(0) == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147483392);
    }
    if (Build.VERSION.SDK_INT <= 20)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "need reset quit double screen listener");
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new mdn(this));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373487));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373459, this.jdField_a_of_type_AndroidContentResResources.getString(2131690219));
      }
      d(l, false);
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373465, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373465, false);
      }
      c(l, "initUI");
      this.jdField_a_of_type_Mif = new mif((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373505), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373637), null);
      msi.a(BaseApplicationImpl.getApplication());
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 0))) {
        bdla.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
      }
      return;
      label468:
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373459, this.jdField_a_of_type_AndroidContentResResources.getString(2131719934));
      }
      d(l, true);
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011) && (paramInt != 2131695177) && (paramInt != 2131719928)) {}
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
    if (((lfe)localObject1).l())
    {
      if (((lfe)localObject1).jdField_d_of_type_Long != 1L) {
        super.B(paramLong);
      }
      localObject2 = this.jdField_a_of_type_Muk;
      if (((lfe)localObject1).jdField_d_of_type_Int != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((muk)localObject2).b(bool1);
      o();
      msa.a(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_e_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!((lfe)localObject1).ay)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.12(this), 200L);
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
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373477);
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
      if (!paramView.jdField_a_of_type_Mnm.a()) {
        break label44;
      }
      paramView.jdField_a_of_type_Mnm.c(3);
    }
    for (;;)
    {
      lkj.a("0X800A8D0");
      return;
      label44:
      paramView.jdField_a_of_type_Mnm.a(0);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      i(paramLong, 16777215);
    }
  }
  
  public void b(String paramString) {}
  
  void b(boolean paramBoolean)
  {
    int i = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_Muy != null)
    {
      this.jdField_a_of_type_Muy.a(paramBoolean);
      this.jdField_a_of_type_Muy.a();
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131166047));
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
          mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
          return;
        }
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1018);
      bdla.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
        localObject = new bkxc((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
        if (msi.a("qav_peer_phone_calling.mp3")) {
          ((bkxc)localObject).a(l, 2, 0, null, msi.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_S_of_type_Boolean)
        {
          bdla.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
          ((bkxc)localObject).a(l, 0, 2131230737, null, null, false, 1, false, true, 0);
          msi.a(BaseApplicationImpl.getApplication());
        }
        bdla.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.9(this), 100L);
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
    D(l);
  }
  
  public void c(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_p_of_type_Boolean)) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStop, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
    }
    super.c(paramLong);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
      super.C(paramLong);
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
        k(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission local close camera, remote[" + this.jdField_a_of_type_ComTencentAvVideoController.a().k + "]");
        }
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = false;
      i(paramLong, 16777215);
    }
    super.c(paramLong, paramInt);
  }
  
  protected void c(long paramLong, View paramView)
  {
    paramView = lbz.a().a();
    if (!mxd.b(paramView.jdField_d_of_type_JavaLangString))
    {
      a(2131695744, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299080));
      mrr.a("0X800B61C", 0, 0, "", "", "", "");
      return;
    }
    mxk localmxk = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localmxk.b(new mdk(this, paramLong, paramView, localmxk));
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterCloseCamera, success[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    i(paramLong, 16777215);
    if (paramBoolean)
    {
      h(true);
      msa.d();
      msa.n(this.jdField_a_of_type_ComTencentAvVideoController);
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
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
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
      super.B(l);
      return;
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avideo onCreate, state[" + ((lfe)localObject1).jdField_g_of_type_Int + "], seq[" + l + "]");
    b();
    this.jdField_a_of_type_Muy.c();
    if (((lfe)localObject1).F == 0) {
      ((lfe)localObject1).F = 3;
    }
    int j;
    int i;
    if ((((lfe)localObject1).f()) || (((lfe)localObject1).j()))
    {
      j = 1;
      if (((lfe)localObject1).jdField_S_of_type_Boolean) {
        j = 0;
      }
      i = 1;
      if (!((lfe)localObject1).N) {
        i = 4;
      }
      if (1008 == ((lfe)localObject1).jdField_j_of_type_Int) {
        i = 4;
      }
    }
    label646:
    label1307:
    for (;;)
    {
      Object localObject2;
      if (((lfe)localObject1).jdField_e_of_type_Boolean)
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lfe)localObject1).jdField_d_of_type_JavaLangString, j, i);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "result = " + i);
        }
        if (i != 0)
        {
          lbd.g(this.jdField_d_of_type_JavaLangString, "Video connect fail:" + i);
          if (i == -2)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(((lfe)localObject1).jdField_d_of_type_JavaLangString, 238);
            this.jdField_a_of_type_ComTencentAvVideoController.b(238);
            this.jdField_a_of_type_ComTencentAvVideoController.b(((lfe)localObject1).jdField_d_of_type_JavaLangString, 9);
          }
          this.jdField_b_of_type_Boolean = true;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
          {
            localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject1 != null) {
              ((Activity)localObject1).finish();
            }
          }
          return;
          if (1044 != ((lfe)localObject1).jdField_j_of_type_Int) {
            break label1307;
          }
          i = 4;
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
        int k;
        label355:
        String str;
        if (localObject2 != null)
        {
          if (i != 1) {
            break label453;
          }
          k = 3;
          str = ((lfe)localObject1).jdField_d_of_type_JavaLangString;
          if (!((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(k, str)) {
            break label458;
          }
          ((lll)localObject2).a(str, 1, false);
        }
        for (;;)
        {
          i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((lfe)localObject1).jdField_d_of_type_JavaLangString, j, i, ((lfe)localObject1).i, ((lfe)localObject1).jdField_j_of_type_JavaLangString, ((lfe)localObject1).a(), ((lfe)localObject1).jdField_j_of_type_Int, ((lfe)localObject1).jdField_f_of_type_JavaLangString, ((lfe)localObject1).jdField_g_of_type_JavaLangString, ((lfe)localObject1).jdField_a_of_type_ArrayOfByte, null, null, 0, 0, null, null);
          break;
          label453:
          k = 0;
          break label355;
          label458:
          ((lll)localObject2).a(str, 0, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, ofter Request, state[" + ((lfe)localObject1).jdField_g_of_type_Int + "], SessionType[" + ((lfe)localObject1).jdField_d_of_type_Int + "], deviceName[" + ((lfe)localObject1).q + "], seq[" + l + "]");
      }
      if (((lfe)localObject1).h())
      {
        if (((lfe)localObject1).jdField_d_of_type_Int == 1)
        {
          this.jdField_e_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          label577:
          this.jdField_a_of_type_Muy.a(this.jdField_e_of_type_JavaLangString);
        }
      }
      else
      {
        if (!((lfe)localObject1).l()) {
          break label870;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label822;
        }
        label607:
        if (((lfe)localObject1).jdField_d_of_type_Int == 2) {
          d(l, true);
        }
        i = ((lfe)localObject1).jdField_j_of_type_Int;
        localObject2 = ((lfe)localObject1).jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject2);
        if (this.jdField_a_of_type_Mwz == null)
        {
          this.jdField_a_of_type_Mwz = new mwz(this);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.addObserver(this.jdField_a_of_type_Mwz);
        }
        if (((lfe)localObject1).jdField_n_of_type_Boolean) {
          o();
        }
        if (((lfe)localObject1).jdField_S_of_type_Boolean)
        {
          this.jdField_a_of_type_Muk.c(true);
          this.jdField_a_of_type_Muk.c(true);
        }
        if (!((lfe)localObject1).jdField_g_of_type_Boolean) {
          break label1250;
        }
        super.k(2131373465);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690221));
        }
      }
      for (;;)
      {
        a(l, false);
        this.jdField_a_of_type_AndroidViewViewGroup.post(new DoubleVideoCtrlUI.11(this));
        if (this.jdField_a_of_type_Mif == null) {
          break;
        }
        this.jdField_a_of_type_Mif.a();
        return;
        this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label577;
        label822:
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) || (((lfe)localObject1).jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.b(((lfe)localObject1).jdField_d_of_type_JavaLangString) != 5)) {
          break label607;
        }
        msa.f(this.jdField_a_of_type_ComTencentAvVideoController);
        break label607;
        label870:
        if (((lfe)localObject1).k())
        {
          if (((lfe)localObject1).jdField_S_of_type_Boolean) {}
          for (i = 2131695252;; i = 2131719996)
          {
            b(i);
            break;
          }
        }
        if (((lfe)localObject1).h())
        {
          i = 2131695600;
          if (((lfe)localObject1).ai) {
            i = 2131695601;
          }
          if (((lfe)localObject1).jdField_j_of_type_Int == 1011) {
            i = 2131695177;
          }
          if (((lfe)localObject1).jdField_S_of_type_Boolean)
          {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "Inviting, remotePhoneState[" + ((lfe)localObject1).jdField_o_of_type_Int + "], isPeerNetworkWell[" + ((lfe)localObject1).r + "], remoteOnline[" + ((lfe)localObject1).s + "], remoteTerminal[" + ((lfe)localObject1).l + "]");
            if ((((lfe)localObject1).jdField_o_of_type_Int == 0) && (((lfe)localObject1).r) && (((lfe)localObject1).l != 2) && (((lfe)localObject1).jdField_d_of_type_Int == 1)) {
              mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
            }
          }
          b(i);
          i = ((lfe)localObject1).jdField_j_of_type_Int;
          localObject2 = ((lfe)localObject1).jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject2);
          i = ((lfe)localObject1).jdField_o_of_type_Int;
          if ((i == 4) && (((lfe)localObject1).jdField_m_of_type_Int == 1) && (((lfe)localObject1).jdField_n_of_type_Int == 0)) {
            a(i);
          }
          if ((i <= 0) || (i == 3)) {
            break label646;
          }
          a(i);
          msa.e(this.jdField_a_of_type_ComTencentAvVideoController);
          break label646;
        }
        if (((lfe)localObject1).j())
        {
          b(2131695442);
          break label646;
        }
        if ((!((lfe)localObject1).o()) && (!((lfe)localObject1).p())) {
          break label646;
        }
        j(((lfe)localObject1).jdField_z_of_type_Int);
        if (((lfe)localObject1).jdField_j_of_type_Int == 1011) {
          b(2131695573);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.10(this, l), 150L);
        break label646;
        label1250:
        super.l(2131373465);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690208));
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (1 == paramInt) {
      if (!this.jdField_e_of_type_Boolean)
      {
        p();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
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
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
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
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        return;
      } while (4 != paramInt);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373477);
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
      if (this.jdField_a_of_type_Mwz != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.removeObserver(this.jdField_a_of_type_Mwz);
        this.jdField_a_of_type_Mwz = null;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("DoubleVideoCtrlUI");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(paramLong);
      o(true);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365816);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_b_of_type_Mcx = null;
    this.jdField_a_of_type_Mtz = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    if (this.jdField_a_of_type_Mif != null)
    {
      this.jdField_a_of_type_Mif.b();
      this.jdField_a_of_type_Mif = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373506));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373507));
    i(paramLong, 16777215);
    e();
  }
  
  void d(long paramLong, View paramView)
  {
    boolean bool = c();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean + "], localMute[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean + "], seq[" + paramLong + "], canClick[" + bool + "]");
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool)) {
      a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString);
    }
    super.D(paramLong);
  }
  
  void d(long paramLong, boolean paramBoolean)
  {
    boolean bool = lbz.a().a().A();
    int i;
    if (paramBoolean) {
      if (bool) {
        i = 4;
      }
    }
    for (;;)
    {
      e(paramLong, i);
      return;
      i = 2;
      continue;
      if (bool) {
        i = 3;
      } else {
        i = 1;
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().x)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_z_of_type_Boolean = this.jdField_h_of_type_Boolean;
      if (this.jdField_h_of_type_Boolean)
      {
        e(0);
        w();
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373767, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373771, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373765, 8);
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(locallfe.jdField_d_of_type_JavaLangString);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onConnected, roomid[" + l + "], mNeedRemoveAudioCallback[" + this.jdField_d_of_type_Boolean + "], seq[" + paramLong + "]");
    super.e(paramLong);
    l(paramLong);
    if (l > 0L) {
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    String str = l + "";
    mmo.a(locallfe.jdField_d_of_type_Int, str + "");
    if (locallfe.jdField_h_of_type_Int != 4) {
      a_(paramLong, 2131695241);
    }
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
    label295:
    label317:
    int i;
    int j;
    label369:
    muk localmuk;
    if (!locallfe.jdField_e_of_type_Boolean)
    {
      if (locallfe.P)
      {
        bdla.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!locallfe.jdField_g_of_type_Boolean) {
          break label592;
        }
        bdla.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        msa.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (locallfe.jdField_d_of_type_Int != 2) {
        break label623;
      }
      d(paramLong, true);
      a(paramLong, true);
      str = locallfe.jdField_d_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
      if (i != 5) {
        break label642;
      }
      if (!locallfe.am) {
        break label631;
      }
      super.B(paramLong);
      localmuk = this.jdField_a_of_type_Muk;
      if (locallfe.jdField_d_of_type_Int != 1) {
        break label767;
      }
    }
    label592:
    label623:
    label631:
    label767:
    for (boolean bool = true;; bool = false)
    {
      localmuk.b(bool);
      i = locallfe.jdField_j_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_Muf != null)
      {
        this.jdField_a_of_type_Muf.c();
        this.jdField_a_of_type_Muf.e();
        this.jdField_a_of_type_Muf.a();
        this.jdField_a_of_type_Muf = null;
      }
      if (locallfe.jdField_n_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      }
      if (locallfe.jdField_d_of_type_Int == 2)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onConnected, CheckRemoteCameraRunnable");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
      }
      if ((locallfe.jdField_n_of_type_Boolean) && (!locallfe.k)) {
        a("onConnected", 1);
      }
      return;
      bdla.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      bdla.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label295;
      h(true);
      break label317;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label369;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
      {
        if (locallfe.am)
        {
          super.B(paramLong);
          break label369;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label369;
      }
      if (!locallfe.l())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label369;
      }
      if (j > 18)
      {
        if ((locallfe.am) && (locallfe.an))
        {
          super.B(paramLong);
          break label369;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label369;
      }
      if (locallfe.am)
      {
        super.B(paramLong);
        break label369;
      }
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label369;
    }
  }
  
  public void e(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    boolean bool2 = mrr.c(paramInt);
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether", 4, "changeUIMode, [" + this.jdField_a_of_type_Int + "-->" + paramInt + "], isVideo[" + bool2 + "]");
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(bool2, 0, false);
      if (this.jdField_a_of_type_Muy != null) {
        this.jdField_a_of_type_Muy.a();
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))
      {
        AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (bool2) {
          break label316;
        }
        bool1 = true;
        label174:
        localAVActivity.b(bool1);
        if (bool2) {
          break label322;
        }
        bool1 = true;
        label189:
        localAVActivity.f(bool1);
        localAVActivity.c(bool2);
      }
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
        break label328;
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
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramInt == 2)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      a(Boolean.valueOf(bool2));
      return;
      i(-1014L, 16777215);
      break;
      label316:
      bool1 = false;
      break label174;
      label322:
      bool1 = false;
      break label189;
      label328:
      if (paramInt == 1)
      {
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
  }
  
  void e(long paramLong, View paramView)
  {
    Object localObject = new mdb(paramView);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), localObject });
    }
    if (((mdb)localObject).jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, mBlockName[" + ((mdb)localObject).jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695080);
      return;
      if (a(paramLong, "android.permission.CAMERA", paramView))
      {
        lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
        msa.h(this.jdField_a_of_type_ComTencentAvVideoController);
        if (locallfe.jdField_d_of_type_Int == 1)
        {
          lob locallob = new lob();
          localObject = locallfe.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject;
          if (((String)localObject).startsWith("+")) {
            paramView = ((String)localObject).substring(1);
          }
          locallob.jdField_a_of_type_Long = mry.a(paramView);
          locallob.jdField_a_of_type_Int = 1;
          paramView = new ArrayList();
          paramView.add(locallob);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
          j(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, open1, seq[" + paramLong + "]");
          }
          bdla.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
          if (locallfe.y) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.18(this), 500L);
          }
          if (locallfe.A()) {
            mrr.a("0X800B637", 0, 0, "", "", "", "");
          }
        }
        else if (locallfe.jdField_d_of_type_Int == 2)
        {
          if (locallfe.jdField_j_of_type_Boolean)
          {
            k(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, close, seq[" + paramLong + "]");
            }
            if (locallfe.A()) {
              mrr.a("0X800B638", 0, 0, "", "", "", "");
            }
          }
          else
          {
            j(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, open2, seq[" + paramLong + "]");
            }
            if (locallfe.A()) {
              mrr.a("0X800B637", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
  
  public void e_(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void f()
  {
    super.f();
    this.jdField_e_of_type_Boolean = true;
    v();
    q();
  }
  
  public void f(int paramInt)
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramInt != locallfe.jdField_S_of_type_Int) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassWaitTime, WaitTime[" + locallfe.jdField_S_of_type_Int + "->" + paramInt + "]");
    }
    locallfe.jdField_S_of_type_Int = paramInt;
  }
  
  public void f(long paramLong)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    mrj localmrj = a(2131695094, paramLong);
    if ((localmrj == null) || (localContext == null)) {}
    label97:
    label112:
    label127:
    do
    {
      return;
      Object localObject = lbz.a().a();
      if (!((lfe)localObject).l())
      {
        localmrj.c(false);
        return;
      }
      boolean bool1 = mtr.j();
      localmrj.c(bool1);
      if (bool1)
      {
        localObject = ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).b((lfe)localObject);
        boolean bool2;
        if (localObject == null)
        {
          localObject = null;
          if ((localObject == null) || (((myw)localObject).a() == 0)) {
            break label231;
          }
          bool1 = true;
          if ((bool1) && (!((myw)localObject).e())) {
            break label236;
          }
          bool2 = true;
          if (!bool1) {
            break label242;
          }
          localmrj.a(localContext.getResources().getString(2131695095));
          localmrj.a(bool2);
          if (bool2) {
            break label261;
          }
        }
        for (boolean bool3 = true;; bool3 = false)
        {
          localmrj.b(bool3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_WatchTogether, watching[" + bool1 + "], enable[" + bool2 + "]");
          return;
          localObject = ((myx)localObject).a;
          break label97;
          bool1 = false;
          break label112;
          bool2 = false;
          break label127;
          localmrj.a(localContext.getResources().getString(2131695094));
          break label147;
        }
      }
    } while (!QLog.isColorLevel());
    label147:
    label231:
    label236:
    label242:
    QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_WatchTogether, entry close.");
    label261:
  }
  
  public void f(long paramLong, View paramView)
  {
    if (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) < 1000L) {}
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (paramView == null);
    mvk.a("0X800AD8D");
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    l(paramLong, 2131695086);
    paramView.a(paramLong);
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
  
  protected void g(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_Mdo.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
      i(paramLong, 16777215);
      l(paramLong, 2131695085);
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
    int i = 2130842323;
    if (h()) {}
    label47:
    label60:
    label231:
    label237:
    label241:
    for (;;)
    {
      return;
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373765);
      int j;
      if (locallfe.A()) {
        j = 0;
      }
      for (;;)
      {
        if (localImageButton == null) {
          break label241;
        }
        if (locallfe.w == 0)
        {
          QavPanel.setBtnTopDrawable(localImageButton, i);
          if (j == 0) {
            break label231;
          }
        }
        for (i = 0;; i = 8)
        {
          localImageButton.setVisibility(i);
          if (j != 0) {
            break;
          }
          ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373556)).setVisibility(4);
          return;
          if ((mtr.e()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {
            break label237;
          }
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = " + mtr.e());
          j = 0;
          break label47;
          if (locallfe.w == 1)
          {
            i = 2130842324;
            break label60;
          }
          if (locallfe.w == 2)
          {
            i = 2130842326;
            break label60;
          }
          if (locallfe.w != 3) {
            break label60;
          }
          i = 2130842325;
          break label60;
        }
        j = 1;
      }
    }
  }
  
  public void i()
  {
    long l = AudioHelper.b();
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onResumeVideo, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "], seq[" + l + "]");
    if (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131719967));
      bdla.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      bdla.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onResumeVideo", 2);
      a("onResumeVideo", 2);
      ThreadManager.excute(new DoubleVideoCtrlUI.14(this, l), 16, null, false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().y) {
        d(true);
      }
    }
    for (;;)
    {
      D(l);
      return;
      i(l, 16777215);
    }
  }
  
  public void i(long paramLong)
  {
    boolean bool2 = false;
    if (h()) {}
    mrj localmrj;
    do
    {
      return;
      localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695085);
      if (localmrj != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, null, seq[" + paramLong + "]");
    return;
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1;
    if ((locallfe.jdField_d_of_type_Int == 3) || (locallfe.jdField_d_of_type_Int == 4) || (locallfe.jdField_d_of_type_Int == 1))
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
      localmrj.a(mdo.a(this.jdField_a_of_type_Mdo));
      localmrj.c(bool1);
      return;
      AVActivity localAVActivity = a();
      if (localAVActivity.jdField_a_of_type_Mji == null)
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, !mRecordUiCtrl, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if (!localAVActivity.jdField_a_of_type_Mji.h())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, !isEnableRecord, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if ((!locallfe.jdField_j_of_type_Boolean) || (!locallfe.k))
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + locallfe.jdField_j_of_type_Boolean + "][sessionInfo.remoteHasVideo=" + locallfe.k + "]");
          bool1 = bool2;
        }
      }
      else if (locallfe.A())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_Record, in watch together mode.");
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public void j() {}
  
  public void j(long paramLong)
  {
    i(paramLong, 16777215);
  }
  
  public void k()
  {
    if (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    long l = AudioHelper.b();
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean + ", seq[" + l + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean)
    {
      a("onNeedShowPeerVideo.1", 2);
      i(l, 16777215);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onNeedShowPeerVideo.2", 2);
      a("onNeedShowPeerVideo.2", 2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void k(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBeforeCloseCamera, seq[" + paramLong + "]");
    }
    i(paramLong, 16777215);
  }
  
  void l()
  {
    H();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtz);
  }
  
  public void l(long paramLong)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l())
    {
      mrj localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695086);
      if (localmrj != null) {
        localmrj.c(false);
      }
      return;
    }
    super.l(paramLong);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Mif != null) {
      this.jdField_a_of_type_Mif.a(new mdj(this));
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_Mdo.a();
    i(-1027L, 16777215);
  }
  
  public void o()
  {
    if (h()) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshUI, SessionType[" + locallfe.jdField_d_of_type_Int + "], seq[" + l + "]");
    }
    int i = locallfe.jdField_j_of_type_Int;
    String str = locallfe.jdField_d_of_type_JavaLangString;
    Object localObject3 = locallfe.jdField_f_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
    Object localObject1 = locallfe.jdField_e_of_type_JavaLangString;
    if (locallfe.jdField_e_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject3);
      locallfe.jdField_e_of_type_JavaLangString = ((String)localObject1);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373506));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373507));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371803));
      if (locallfe.jdField_d_of_type_Int == 2) {
        d(l, true);
      }
    }
    else
    {
      if (locallfe.jdField_d_of_type_Int != 2) {
        break label484;
      }
      d(l, true);
      label249:
      if (locallfe.jdField_j_of_type_Int == 1011)
      {
        if (locallfe.jdField_a_of_type_Lff.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label501;
        }
        a(locallfe.jdField_a_of_type_Lff.jdField_a_of_type_AndroidGraphicsBitmap);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(locallfe.jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(locallfe.jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString);
        }
      }
      label283:
      if (locallfe.jdField_j_of_type_Int != 25) {
        break label556;
      }
      localObject2 = locallfe.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = locallfe.jdField_f_of_type_JavaLangString;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(str);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
      }
      if ((!((String)localObject2).equals(locallfe.jdField_d_of_type_JavaLangString)) || (localObject1 == null)) {
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
      i(l, 16777215);
      return;
      d(l, false);
      break;
      label484:
      if (locallfe.jdField_d_of_type_Int != 1) {
        break label249;
      }
      b(false);
      break label249;
      label501:
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label283;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bheg.a());
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
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373477);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).b();
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
  }
  
  public void s()
  {
    long l = AudioHelper.b();
    q();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().x)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.19(this, l), 300L);
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
        super.B(l);
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
            super.B(l);
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().l());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().an);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
      super.B(l);
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    super.B(l);
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
    super.B(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */