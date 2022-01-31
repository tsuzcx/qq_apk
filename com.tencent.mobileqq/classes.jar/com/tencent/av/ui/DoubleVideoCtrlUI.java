package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.report.AVReport;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import jry;
import jrz;
import jsa;
import jsb;
import jsc;
import jsd;
import jsf;
import jsg;
import jsh;
import jsi;
import jsj;
import jsk;
import jsl;
import jsm;
import jsn;
import jso;
import jsp;
import jsq;
import jsr;
import jss;
import jst;
import jsu;
import jsv;
import jsx;
import jsy;
import jsz;
import jta;
import jtb;
import mqq.app.MobileQQ;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  int jdField_a_of_type_Int = -1;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new UITools.MyViewAlphaOnTouchListener();
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new jsa(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new jry(this);
  public Timer a;
  public boolean a;
  private int jdField_b_of_type_Int;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new jsk(this);
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = new jss(this);
  boolean jdField_c_of_type_Boolean = false;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  Runnable jdField_d_of_type_JavaLangRunnable = new jso(this);
  boolean jdField_d_of_type_Boolean = false;
  boolean e;
  boolean f;
  public boolean g;
  private boolean p;
  private boolean q = true;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    jsv localjsv = new jsv(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localjsv, 1000L);
  }
  
  private void K()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "setForground");
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_Boolean) && (!SessionMgr.a().a())) {
      this.jdField_a_of_type_ComTencentAvVideoController.g();
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (((this.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) || (!this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown())) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().f();
      if ((localEffectOperateManager != null) && (localEffectOperateManager.a(bool)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "realShowEffectOperate show effect operate animation");
        }
        localEffectOperateManager.a(true);
        String str = localEffectOperateManager.c();
        int i = localEffectOperateManager.b();
        int j = localEffectOperateManager.c();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setEffectOperateDrawable(paramDrawable);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.postDelayed(new jtb(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvUiQavPanel, str, i, j), 1500L);
        ReportController.b(null, "dc00898", "", "", "0X8008AD3", "0X8008AD3", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(Button paramButton)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().r) || (j()))
    {
      AVLog.d(this.jdField_c_of_type_JavaLangString, "click qav_bottombar_camera not invalid .because voiceChoose=" + this.jdField_a_of_type_ComTencentAvVideoController.a().r + ",effectSetting=" + j());
      return;
    }
    paramButton = new ControlUIObserver.CPreEventInfo(paramButton);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), paramButton });
    if (paramButton.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Camera, mBlockName[" + paramButton.a + "]");
    }
    label591:
    for (;;)
    {
      ad();
      return;
      DataReport.i(this.jdField_a_of_type_ComTencentAvVideoController);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().A == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004E98", "0X8004E98", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "open camera");
        }
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        paramButton = str;
        if (str.startsWith("+")) {
          paramButton = str.substring(1);
        }
        localVideoViewInfo.jdField_a_of_type_Long = CharacterUtil.a(paramButton);
        localVideoViewInfo.jdField_a_of_type_Int = 1;
        paramButton = new ArrayList();
        paramButton.add(localVideoViewInfo);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramButton });
        v();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
        ReportController.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().v) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsn(this), 500L);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.c())) {
          break label591;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        break;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
          {
            w();
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f(null);
            this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_c_of_type_JavaLangString, 2, "local close camera");
            }
          }
          else
          {
            v();
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_c_of_type_JavaLangString, 2, "local open camera");
            }
          }
        }
      }
    }
  }
  
  private void b(Button paramButton)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    paramButton = new ControlUIObserver.CPreEventInfo(paramButton);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9000), paramButton });
    if (paramButton.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_AddMember, mBlockName[" + paramButton.a + "]");
    }
    for (;;)
    {
      ad();
      return;
      DataReport.h(this.jdField_a_of_type_ComTencentAvVideoController);
      paramButton = new Intent();
      paramButton.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramButton.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
      paramButton.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramButton);
      ad();
      if ((SmallScreenUtils.b()) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
      {
        paramButton = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramButton != null)
        {
          paramButton = paramButton.a();
          if (paramButton != null) {
            paramButton.c();
          }
        }
      }
    }
  }
  
  private void c(View paramView)
  {
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, this.jdField_u_of_type_Int);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_EffectEntrance, mBlockName[" + paramView.a + "], mEffectType[" + this.jdField_u_of_type_Int + "]");
      ad();
      return;
    }
    AVLog.d(this.jdField_c_of_type_JavaLangString, "qav_bottombar_effect click. mEffectType=" + this.jdField_u_of_type_Int);
    if (this.jdField_u_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(this.jdField_u_of_type_Int) });
      VoiceChangeDataReport.a("0X8007DBE", "");
      label174:
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "[red dot] click qav_bottombar_effect");
      }
      if (this.jdField_u_of_type_Int != 1) {
        break label348;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f("103416");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
      paramView = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if ((paramView == null) || (!paramView.a()) || (!paramView.c())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "goto the effect");
      }
      if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
      {
        int i = paramView.a();
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.setSelectedBtn(i);
      }
      paramView.b();
      aj();
      ReportController.b(null, "dc00898", "", "", "0X8008AD4", "0X8008AD4", 0, 0, "", "", "", "");
      break;
      if (this.jdField_u_of_type_Int != 2) {
        break label174;
      }
      v(paramView.jdField_b_of_type_Int);
      break label174;
      label348:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f(null);
    }
  }
  
  public void A()
  {
    s_();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsp(this), 300L);
    }
  }
  
  public void B()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
        super.Z();
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
              if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
                break;
              }
              if (this.jdField_c_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
            super.Z();
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().f());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
      super.Z();
      return;
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
    super.Z();
  }
  
  public void C()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.b()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.Z();
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.d())
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, true);
      }
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
    }
    DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
  }
  
  public void E()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361)).setVisibility(4);
    super.E();
  }
  
  public void F()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361)).setVisibility(0);
    super.F();
  }
  
  void G()
  {
    if (this.jdField_d_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || ((!this.jdField_a_of_type_ComTencentAvVideoController.a().c()) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().e())) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean)) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80060A7", "0X80060A7", 0, 0, "", "", "", "");
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void H()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) || (!this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown()))
    {
      localObject = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().f();
      if ((localObject != null) && (((EffectOperateManager)localObject).a(bool)))
      {
        localObject = ((EffectOperateManager)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showEffectOperateIfNeed, iconUrl[" + (String)localObject + "]");
        }
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable((String)localObject, null, null);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        a((Drawable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showEffectOperateIfNeed", localException);
      return;
    }
    localException.setURLDrawableListener(new jst(this, localException));
    localException.startDownload();
  }
  
  public void I()
  {
    k(k());
  }
  
  protected int a()
  {
    return 2130969280;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, paramInt);
    }
    return 0;
  }
  
  public void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361);
    if (localView != null) {
      localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131492924));
    }
  }
  
  void a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    switch (paramInt)
    {
    }
    label289:
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
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 26));
                  if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1004) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1000) && (i != 5)) {
                    break;
                  }
                } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                return;
                j(0);
                return;
              } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (this.jdField_a_of_type_ComTencentAvVideoController.d()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 26));
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().J) {
                break label289;
              }
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1006) {
                break;
              }
            } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(23, true);
            return;
            if (j >= 16) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(22, true);
          return;
        } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(23, true);
        return;
        if ((i == 4) || (i == 2)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(22, true);
      return;
    } while (j >= 16);
    j(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onTerSwitchSyncStatus cameraStatus：" + paramInt1 + ", micStatus:" + paramInt2);
    }
    if (paramInt1 == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      label137:
      Object localObject;
      boolean bool;
      if (paramInt1 == 0)
      {
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        if ((paramInt1 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
          break label301;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 2;
          a("onTerSwitchSyncStatus1", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
        }
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (paramInt2 != 0) {
          break label346;
        }
        bool = true;
        label152:
        ((SessionInfo)localObject).jdField_c_of_type_Boolean = bool;
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          break label351;
        }
        super.s(2131365397);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131428883));
        }
      }
      label301:
      label346:
      label351:
      do
      {
        return;
        v();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
        break;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
          break label137;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 1;
        a("onTerSwitchSyncStatus2", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
        break label137;
        bool = false;
        break label152;
        super.t(2131365397);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131428882));
      return;
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131365393) || (paramInt1 == 2131365392)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365393, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365393, paramBoolean);
    }
  }
  
  void a(Bitmap paramBitmap)
  {
    paramBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onClick view.getId = " + paramView.getId());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick mVideoController == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick mQavPanel == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick isChildLock");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {}
    for (Object localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject1 = null)
    {
      int i;
      label712:
      label1234:
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131365367: 
      case 2131365379: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.detail ");
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.detail  not connected ");
          return;
        }
      case 2131365368: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
        MagicDataReport.e(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) + "");
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(134) });
        return;
      case 2131365396: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE_SHELL ");
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365397))
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE_SHELL  MUTE isEnable");
          return;
        }
        if (localObject1 == null) {
          break;
        }
        paramView = DialogUtil.a((Context)localObject1, 230).setMessage(((AVActivity)localObject1).getString(2131429205)).setTitle(((AVActivity)localObject1).getString(2131429207)).setNegativeButton(2131433015, new jsi(this));
        if (UITools.a((Activity)localObject1)) {}
        for (i = 2131429208;; i = 2131429209)
        {
          paramView.setPositiveButton(i, new jsh(this)).show();
          return;
        }
      case 2131365398: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA_SHELL ");
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399))
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA_SHELL  CAMERA is Enable");
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 22)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA_SHELL  is light talk");
          return;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "请求相机权限.1");
          if (localObject1 != null)
          {
            paramView = DialogUtil.a((Context)localObject1, 230).setMessage(((AVActivity)localObject1).getString(2131429204)).setTitle(((AVActivity)localObject1).getString(2131429206)).setNegativeButton(2131433015, new jsl(this));
            if (!UITools.a((Activity)localObject1)) {
              break label712;
            }
            i = 2131429208;
            paramView.setPositiveButton(i, new jsj(this)).show();
          }
        }
        for (;;)
        {
          ad();
          return;
          i = 2131429209;
          break;
          if (((!VcSystemInfo.b()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) || (!this.jdField_a_of_type_ComTencentAvVideoController.c())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1011))
          {
            ReportController.b(null, "CliOper", "", "", "0X8005612", "0X8005612", 0, 0, "", "", "", "");
            if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) {
              ReportController.b(null, "CliOper", "", "", "0X8004E93", "0X8004E93", 0, 0, "", "", "", "");
            }
            a(paramView.getId());
          }
        }
      case 2131365390: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER_SHELL ");
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391))
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER_SHELL ADD_MEMBER is enable");
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 22)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER_SHELL is light talk");
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER_SHELL is anyone");
          return;
        }
        a(paramView.getId());
        ad();
        return;
        if (this.jdField_k_of_type_Int - this.jdField_m_of_type_Int > 4)
        {
          this.jdField_m_of_type_Int = this.jdField_k_of_type_Int;
          this.l = 0;
        }
        this.l += 1;
        if (this.l <= 5) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(112) });
        this.l = 0;
        this.jdField_m_of_type_Int = 0;
        return;
      case 2131365388: 
      case 2131365904: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick Hangup ");
        b(paramView);
        return;
      case 2131365401: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HAND_FREE ");
        boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().N;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController;
        if (!bool2) {
          bool1 = true;
        }
        DataReport.a(paramView, bool1);
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        }
        ad();
        return;
      case 2131365397: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE ");
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean)
        {
          bool1 = true;
          paramView.jdField_c_of_type_Boolean = bool1;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
            break label1234;
          }
          super.s(2131365397);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131428883));
        }
        for (;;)
        {
          ad();
          DataReport.c(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          bool1 = false;
          break;
          super.t(2131365397);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131428882));
        }
      case 2131365395: 
      case 2131366268: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick HIDE ");
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
        com.tencent.av.VideoConstants.ProcessInfo.a = "3";
        a();
        DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
      case 2131365399: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA ");
        a((Button)paramView);
        return;
      case 2131365380: 
      case 2131365405: 
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CALL_PHONE tyep = " + i);
        DataReport.a(paramView.getId(), i);
        paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString));
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
          break;
        }
        localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)))
        {
          localObject2 = VideoActionSheet.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          ((VideoActionSheet)localObject2).a(2131438345);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Int == 1) {
            ((VideoActionSheet)localObject2).a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131438343), ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130840359), 0);
          }
          for (;;)
          {
            ((VideoActionSheet)localObject2).b(2131438344);
            ((VideoActionSheet)localObject2).c(2131433015);
            ((VideoActionSheet)localObject2).a(new jsm(this, (VideoActionSheet)localObject2, str, (Context)localObject1, paramView));
            ((VideoActionSheet)localObject2).show();
            return;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Int == 2) {
              ((VideoActionSheet)localObject2).a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131438343), ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130840358), 0);
            } else {
              ((VideoActionSheet)localObject2).a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131438343), ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130840357), 0);
            }
          }
        }
        if (localObject1 != null)
        {
          ((Context)localObject1).startActivity(paramView);
          paramView = new Intent("tencent.video.v2q.insertSystemCall");
          paramView.putExtra("phoneNumber", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString);
          paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
        this.jdField_a_of_type_ComTencentAvVideoController.b(236);
        this.jdField_a_of_type_ComTencentAvVideoController.c(str, 0);
        return;
      case 2131365391: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER");
        b((Button)paramView);
        return;
      case 2131365369: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_titlebar_switchcamera");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107) });
        ad();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = false;
          ReportController.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
          UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428916));
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = true;
        ReportController.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
        UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428915));
        return;
      case 2131365406: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.LEAVE_MSG");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject1, (String)localObject2, true);
        }
        DataReport.r(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvVideoController.c(str, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
        return;
      case 2131365403: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.Effect");
        c(paramView);
        return;
      case 2131365393: 
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.OPEN_LOCK");
        this.jdField_a_of_type_ComTencentAvVideoController.a(str, 1, 5, 1);
        a(2131429244, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setQCallNickName");
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    super.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    boolean bool2 = true;
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "avSwitch[" + paramString + "], sessionType[" + paramInt + "]");
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361);
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    if (paramInt == 1)
    {
      u();
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, false);
      }
      d(true);
      j(false);
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493532));
      l(true);
      i(0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6007) });
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
        super.t(2131365399);
      }
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label285;
      }
      bool1 = true;
      label197:
      ((SensorHelper)localObject).c(bool1);
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label290;
      }
    }
    label285:
    label290:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SensorHelper)localObject).b(bool1);
      b(paramString + "_avSwitch");
      return;
      if (paramInt != 2) {
        break;
      }
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131492924));
      j(true);
      break;
      bool1 = false;
      break label197;
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().l + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().c()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ak) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011)) {}
    int i;
    label352:
    label504:
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString.contains(paramString1));
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int;
      if ((i >= 0) && (this.jdField_i_of_type_AndroidWidgetTextView != null))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label352;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429104);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429104);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(2131429104);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 0L) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        }
        if ((i <= 0) || (i == 3)) {
          break label504;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(i + 9 - 1, true);
        }
        DataReport.f(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        this.jdField_i_of_type_AndroidWidgetTextView.setText(paramString2);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramString2);
        break;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 2L)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 8, 0L);
          if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_JavaLangString))) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(67, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_JavaLangString, 0L, 0);
          }
          ReportController.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
        }
      }
      if ((i == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(3, true);
        return;
      }
    } while ((i != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(6, true);
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTitleText :" + paramString);
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "mRingAnimator.mfRingAnimation:" + this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null))
    {
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363259);
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
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_p_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
    b("setTipsPaddingTop");
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    int i;
    Object localObject2;
    if (paramBoolean1)
    {
      i = 0;
      ((TextView)localObject1).setVisibility(i);
      localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      i = j;
      if (paramBoolean1) {
        i = 0;
      }
      ((RelativeLayout)localObject1).setVisibility(i);
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramBoolean2))
      {
        localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365363);
        if (localObject1 != null)
        {
          localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject2 != null)
          {
            localObject2 = (TextView)((AVActivity)localObject2).findViewById(2131365386);
            if (!paramBoolean1) {
              break label137;
            }
            ((TextView)localObject2).setVisibility(4);
          }
          label111:
          if (!paramBoolean1) {
            break label146;
          }
          ((View)localObject1).setBackgroundColor(-16777216);
        }
      }
    }
    for (;;)
    {
      b("changeToDoubleScreen");
      return;
      i = 8;
      break;
      label137:
      ((TextView)localObject2).setVisibility(0);
      break label111;
      label146:
      ((View)localObject1).setBackgroundColor(0);
    }
  }
  
  public boolean a()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onBackPressed called");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onBackPressed called return 1");
      return true;
    }
    if (super.a())
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onBackPressed called return 2");
      return true;
    }
    K();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if ((!SmallScreenUtils.b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
      a(2131429114, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().h()))
    {
      r(this.jdField_a_of_type_ComTencentAvVideoController.a().z);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsg(this), 150L);
    }
    if (SmallScreenUtils.b())
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).a();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean) {
        bool = true;
      }
      return bool;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    return false;
  }
  
  public int b()
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365363);
    if ((localView != null) && (localView.getVisibility() == 0) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ImmersiveUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return 0;
  }
  
  void b()
  {
    super.q(a());
    super.b();
    Object localObject1;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
      {
        bool = true;
        ((QavPanel)localObject1).a(4, bool, BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
        this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      }
    }
    else
    {
      G();
      f(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365365));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365367));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362754));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365368));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365937));
      if (Build.VERSION.SDK_INT <= 20)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "need reset quit double screen listener");
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new jsu(this));
      }
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365383));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label654;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365388, this.jdField_a_of_type_AndroidContentResResources.getString(2131428890));
      }
      j(false);
      label277:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)) {
          break label690;
        }
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
        {
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_b_of_type_AndroidWidgetLinearLayout.getResources().getDimensionPixelSize(2131560002) + this.jdField_b_of_type_AndroidWidgetLinearLayout.getResources().getDimensionPixelSize(2131560000));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setEnabled(true);
          DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
        }
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365397, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365397, false);
      }
      b("initUI");
      localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && (((AVActivity)localObject1).c()))
      {
        Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366267);
        RelativeLayout.LayoutParams localLayoutParams;
        if (localObject2 != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
          localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559743);
          ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
        }
        int i = ImmersiveUtils.a((Context)localObject1);
        localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365363);
        if ((localObject2 != null) && (i > 0))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
          localLayoutParams.height = i;
          ((View)localObject2).setLayoutParams(localLayoutParams);
        }
      }
      if ((localObject1 != null) && (!((AVActivity)localObject1).c())) {
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365363).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365374), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365377), this.jdField_b_of_type_AndroidWidgetLinearLayout);
      GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
      return;
      bool = false;
      break;
      label654:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365388, this.jdField_a_of_type_AndroidContentResResources.getString(2131428956));
      }
      j(true);
      break label277;
      label690:
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void b(int paramInt)
  {
    A();
    super.b(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onClose type = " + paramInt);
    }
    int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label478;
      }
      j = 1;
      label82:
      if (((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().h()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26)) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)))
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          DataReport.q(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
          aj();
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)) {
            break label483;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365405, false);
          label255:
          if ((paramInt == 3) && (this.jdField_b_of_type_AndroidWidgetImageButton != null)) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
          }
          if (((paramInt != 3) && (paramInt != 12)) || (!VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().A))) {
            break label497;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365406, 4);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365405, 4);
        }
      }
    }
    for (;;)
    {
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localEffectOperateManager != null) {
        localEffectOperateManager.a(false);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.a();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      }
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
        DataReport.e();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
      if (paramInt == 24)
      {
        this.jdField_k_of_type_Boolean = true;
        this.jdField_g_of_type_AndroidWidgetTextView.setText(2131429076);
      }
      return;
      i = 0;
      break;
      label478:
      j = 0;
      break label82;
      label483:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365405, true);
      break label255;
      label497:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365406, true);
    }
  }
  
  void b(View paramView)
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onClick_Hangup");
    int i = paramView.getId();
    if (i == 2131365388) {
      AVLog.d(this.jdField_c_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      paramView = new ControlUIObserver.CPreEventInfo(paramView);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.jdField_b_of_type_Boolean) {
        break;
      }
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Hangup, mBlockName[" + paramView.a + "]");
      return;
      if (i == 2131365904) {
        AVLog.d(this.jdField_c_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jsr(this, str));
  }
  
  @TargetApi(11)
  protected void b(String paramString)
  {
    super.b(paramString);
    int j;
    int i;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      paramString = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        j = UITools.b(paramString);
        i = UITools.a(paramString);
      }
    }
    for (;;)
    {
      paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365827);
      int m = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      int k = m;
      if (m == 2)
      {
        k = m;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
        {
          k = m;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
            k = 1;
          }
        }
      }
      switch (k)
      {
      default: 
        if (this.jdField_p_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramString);
          return;
        }
        break;
      case 2: 
        label187:
        if (Build.VERSION.SDK_INT < 11) {}
        break;
      }
      for (float f1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f1 = 0.0F)
      {
        Object localObject;
        if (f1 % 180.0F == 0.0F)
        {
          paramString.addRule(12, -1);
          paramString.addRule(13, 0);
          paramString.height = -2;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break label629;
          }
          localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (!(localObject instanceof AVActivity)) {
            break label629;
          }
          localObject = (ZimuView)((AVActivity)localObject).findViewById(2131362537);
          if (localObject == null) {
            break label629;
          }
          if ((((ZimuView)localObject).a().equals("liveshow")) && (((ZimuView)localObject).getVisibility() == 0)) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            paramString.bottomMargin = (j * 2 / 3);
            break;
            i = 0;
            continue;
          }
          paramString.bottomMargin = (j * 1 / 2);
          break;
          paramString.addRule(12, 0);
          paramString.addRule(13, -1);
          paramString.bottomMargin = 0;
          paramString.height = (i * 23 / 25);
          break;
          paramString.addRule(12);
          paramString.addRule(13, 0);
          paramString.height = -2;
          if (i <= 320)
          {
            if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
            {
              paramString.bottomMargin = (d() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559878));
              break;
            }
            paramString.bottomMargin = (d() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559877));
            break;
          }
          if (i <= 480)
          {
            paramString.bottomMargin = (d() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559876));
            break;
          }
          i = d();
          j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559875);
          paramString.bottomMargin = (i + j);
          localObject = Build.MODEL;
          QLog.e(this.jdField_c_of_type_JavaLangString, 1, "adaptScreens Timer ngetBottomToolbarHeight=" + i + ", n720P=" + j + ", params_Tips.bottomMargin =" + paramString.bottomMargin + ", devModal=" + (String)localObject);
          break;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
          break label187;
          label629:
          i = 0;
        }
      }
      i = 0;
      j = 0;
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPeerSwitchTerminal, bStartSwitch : " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(36, true);
      }
    }
    else
    {
      paramString = DoodleLogic.a();
      if (!paramBoolean) {
        break label451;
      }
      paramString.jdField_b_of_type_Boolean = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.jdField_b_of_type_Boolean);
      }
      SmallScreenUtils.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(36, false);
    if (this.jdField_a_of_type_ComTencentAvVideoController.c()) {
      if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1))
      {
        if (!VcSystemInfo.b()) {
          break label271;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
      }
    }
    for (;;)
    {
      D();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, paramString);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.K();
      break;
      label271:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      continue;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        }
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(24, true);
      }
    }
    label451:
    paramString.b();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramBoolean);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    i(paramBoolean);
    Object localObject;
    label199:
    label204:
    label220:
    int i;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.t)) {
          break label204;
        }
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
          break label199;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((QavPanel)localObject).a(paramBoolean, 0, false);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
          paramBoolean = bool2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
            paramBoolean = true;
          }
          ((TipsManager)localObject).a(paramBoolean, true);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131493511));
        }
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131493511));
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
      {
        paramBoolean = true;
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (!paramBoolean) {
          break label248;
        }
      }
      label248:
      for (i = 2;; i = 1)
      {
        ((QavPanel)localObject).a(paramBoolean, i, true);
        break;
        paramBoolean = false;
        break label220;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.t)) {
        break label398;
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
      {
        paramBoolean = true;
        label308:
        ((QavPanel)localObject).a(paramBoolean, 0, false);
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
        break label447;
      }
    }
    label398:
    label414:
    label442:
    label447:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ((TipsManager)localObject).a(paramBoolean, false);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_i_of_type_AndroidWidgetTextView == null) {
        break;
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      return;
      paramBoolean = false;
      break label308;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
      {
        paramBoolean = true;
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (!paramBoolean) {
          break label442;
        }
      }
      for (i = 2;; i = 1)
      {
        ((QavPanel)localObject).a(paramBoolean, i, false);
        break;
        paramBoolean = false;
        break label414;
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], isConnected[" + this.jdField_a_of_type_ComTencentAvVideoController.a().f() + "], mCameraNum[" + this.jdField_n_of_type_Int + "], remoteHasVideo[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean + "]");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, true);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if ((this.jdField_n_of_type_Int > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null)) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDetectNoDevicePermission, set cameraPermission = true");
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
          super.s(2131365399);
        }
        x();
        if ((paramInt == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().N) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        }
        DataReport.c();
        DataReport.n(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
          a("onAfterOpenCamera", 2);
        }
        ad();
        H();
      }
      return;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, true);
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, String.format("onPhoneCalling, isSelf[%s], isCalling[%s], curStatus[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null)) {}
    label228:
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            if (this.jdField_f_of_type_Boolean != paramBoolean2) {}
            for (i = 1;; i = 0)
            {
              this.jdField_f_of_type_Boolean = paramBoolean2;
              if (!paramBoolean1) {
                break label228;
              }
              if (!paramBoolean2) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(40, true);
              return;
            }
          } while (i == 0);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(40, false);
        } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
        DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230).setMessage(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429238)).setPositiveButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429203), new jsc(this)).show();
        ReportController.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
        return;
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        if (!paramBoolean2) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, true);
      Object localObject = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (GAudioSoundUtil.a("qav_peer_phone_calling.mp3")) {
        ((TraeMediaPlayer)localObject).a("DoubleVideoCtrlUI.onPhoneCalling.1", 2, 0, null, GAudioSoundUtil.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
      }
      while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
        return;
        ((TraeMediaPlayer)localObject).a("DoubleVideoCtrlUI.onPhoneCalling.2", 0, 2131230736, null, null, false, 1, false, true, 0);
        GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
      }
      ReportController.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
      return;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, false);
  }
  
  boolean b()
  {
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsx(this), 100L);
  }
  
  @TargetApi(11)
  public void c(int paramInt)
  {
    if ((Build.VERSION.SDK_INT > 11) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean))) {
      a(360 - paramInt);
    }
    if ((Build.VERSION.SDK_INT > 11) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
      a(0.0F);
    }
    if (Build.VERSION.SDK_INT > 11)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131362533);
        }
      }
      if (localObject1 != null) {
        ((ChildLockCircle)localObject1).setRotation(360 - paramInt);
      }
    }
  }
  
  public void c(String paramString) {}
  
  void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      if (((!VcSystemInfo.b()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)) && (paramBoolean))
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
        }
        ReportController.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (this.jdField_n_of_type_Int > 1))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
        }
        label149:
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365401, false);
        }
        label177:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
          break label421;
        }
        super.t(2131365399);
      }
    }
    for (;;)
    {
      e();
      do
      {
        return;
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        break;
        if (!paramBoolean)
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.b()))
          {
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
              break label149;
            }
            this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
            this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
            break label149;
          }
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
            break label149;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
          break label149;
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.c()) || (!VcSystemInfo.b())) {
          break label348;
        }
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
      return;
      label348:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
        break label149;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.postDelayed(new jta(this), 1000L);
      break label149;
      label407:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365401, true);
      break label177;
      label421:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        super.s(2131365399);
        if (this.jdField_n_of_type_Int > 1) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
      }
      else
      {
        super.t(2131365399);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
    }
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt, false);
  }
  
  public void d()
  {
    super.d();
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onCreate ");
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, ">>>onCreate(), ts=" + l1);
    }
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 0) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().F = 3;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
      super.s(2131365399);
    }
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d()))
    {
      j = 1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean) {
        j = 0;
      }
      i = 1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J) {
        i = 4;
      }
      if (1008 != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int) {
        break label3091;
      }
      i = 4;
    }
    label1800:
    label2313:
    label3091:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean) {
        j = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i);
      }
      Object localObject;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "result = " + j);
        }
        if (j == 0) {
          break;
        }
        AVLog.d(this.jdField_c_of_type_JavaLangString, "Video connect fail:" + j);
        if (j == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.b(238);
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 9);
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
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString.equals("Lightalk")) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().B == 0)
          {
            i = 1;
            label468:
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 24) {
              break label724;
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A, 1024, null, null);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(66, true);
            }
            j = i;
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setBindInfo: mBindType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().A + ",mBindId = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.jdField_a_of_type_ComTencentAvVideoController.a().A, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString);
            j = i;
            break;
            i = 4;
            break label468;
            label724:
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 25)
            {
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString.startsWith("+"))) {
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString.substring(3);
              }
              i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A, 1025, null, null);
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 27)
            {
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString.startsWith("+"))) {
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString.substring(3);
              }
              i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A, 1011, null, null);
            }
            else
            {
              i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A);
            }
          }
        }
        j = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, null, 0, 0, null, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Session State = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int + ",SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "deviceName = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
        {
          this.jdField_e_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, false);
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
          break label2313;
        }
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361);
        if ((VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().A)) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(66, false);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
          break label2120;
        }
        ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493532));
        x();
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localObject = localContext;
          if (localContext != null) {
            localObject = localContext.getApplicationContext();
          }
          if ((localObject == null) || (!NetworkUtil.h((Context)localObject)) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)) {}
        }
        label1684:
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label2165;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
        {
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().R) {
            break label2152;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, true);
        }
        label1737:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
          j(true);
        }
        x();
        if (!VcSystemInfo.b()) {
          break label2280;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
          n();
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, true);
        }
        D();
        DataReport.d(this.jdField_a_of_type_ComTencentAvVideoController, true);
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
        }
        label1882:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean) {
          u();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          break label3034;
        }
        super.s(2131365397);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131428883));
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
          c(false);
        }
        this.jdField_a_of_type_AndroidViewViewGroup.post(new jsz(this));
        if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
          this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
        }
        long l2 = System.currentTimeMillis();
        QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 1, "<<<onCreate(), ts=" + l2 + ", cost=%dms" + (l2 - l1));
        return;
        this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break;
        label2120:
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_n_of_type_Int <= 1)) {
          break label1684;
        }
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        break label1684;
        label2152:
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
        break label1737;
        label2165:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) {
          break label1737;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
            break label1737;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
          break label1737;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) == 5)
        {
          if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, true);
          }
          DataReport.g(this.jdField_a_of_type_ComTencentAvVideoController);
          break label1737;
        }
        if ((!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
          break label1737;
        }
        break label1737;
        label2280:
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label1800;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        break label1800;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().e())
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)
          {
            i = 2131428977;
            this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493531));
          }
          for (;;)
          {
            this.jdField_i_of_type_AndroidWidgetTextView.setText(i);
            if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
              this.jdField_d_of_type_AndroidWidgetTextView.setText(i);
            }
            if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(i);
            break;
            i = 2131428834;
          }
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
        {
          i = 2131429028;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak) {
            i = 2131429183;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011) {
            i = 2131429073;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493531));
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(6, true);
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
              this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
            }
            DataReport.d(this.jdField_a_of_type_ComTencentAvVideoController, false);
            this.jdField_i_of_type_AndroidWidgetTextView.setText(i);
            if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
              this.jdField_d_of_type_AndroidWidgetTextView.setText(i);
            }
            if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(i);
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int;
            if ((i == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int == 0)) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(3, true);
            }
            if ((i <= 0) || (i == 3)) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(i + 9 - 1, true);
            }
            DataReport.f(this.jdField_a_of_type_ComTencentAvVideoController);
            break;
            localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Boolean) {
              ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493532));
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d())
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429020);
          if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429020);
          }
          if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
            break label1882;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(2131429020);
          break label1882;
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().g()) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().h())) {
          break label1882;
        }
        r(this.jdField_a_of_type_ComTencentAvVideoController.a().z);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011)
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429078);
          if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429028);
          }
          if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(2131429028);
          }
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsy(this), 150L);
        break label1882;
        label3034:
        super.t(2131365397);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131428882));
        }
      }
    }
  }
  
  void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011) && (paramInt != 2131429073) && (paramInt != 2131428688)) {}
    do
    {
      return;
      if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (paramInt > 0)) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(paramInt);
      }
      if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (paramInt > 0)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramInt);
      }
    } while ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) || (paramInt <= 0));
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramInt);
  }
  
  public void d(String paramString)
  {
    super.d(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.a().v = false;
    A();
  }
  
  void d(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365374);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramBoolean)
    {
      int i = 0;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        i = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      if (i <= 320)
      {
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560033);
        localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560036);
        localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560036);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        return;
        if (i <= 480)
        {
          localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560032);
          localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560035);
          localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560035);
        }
        else
        {
          localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560031);
          localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560034);
          localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560034);
        }
      }
    }
    localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559866);
    localRelativeLayout.setLayoutParams(localLayoutParams1);
    localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559842);
    localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559842);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011))
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, false);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365369).setEnabled(false);
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365369).setClickable(false);
    }
    if (((Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) || (!VcSystemInfo.b())) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onDetectNoDevicePermission issueType = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label214;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onDetectNoDevicePermission remote has video,local close camera");
        }
      }
    }
    for (;;)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean = false;
      x();
      if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365397, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365397, false);
        }
        FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365396);
        if (localFrameLayout != null) {
          localFrameLayout.setClickable(true);
        }
      }
      super.e(paramInt);
      return;
      label214:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onDetectNoDevicePermission remote has no video,local close camera");
        }
      }
    }
  }
  
  void e(String paramString)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_o_of_type_Int = 1;
      if (!paramBoolean) {
        break label73;
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, true);
      }
    }
    label73:
    do
    {
      return;
      this.jdField_o_of_type_Int = 2;
      break;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, false);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, false);
        ThreadManager.post(new jsd(this), 5, null, false);
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
    super.Z();
  }
  
  public void f()
  {
    super.f();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, ">>>onStart(), ts=" + l1);
    }
    label198:
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
      {
        if (!AVReport.a().jdField_a_of_type_Boolean) {
          break label368;
        }
        VideoNodeManager.a(29);
        AVReport.a().j = SystemClock.elapsedRealtime();
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int < 0) || (this.jdField_i_of_type_AndroidWidgetTextView == null)) {
          break label624;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 1011) {
          break label380;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429073);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429073);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(2131429073);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().v)) {
          break label641;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean = false;
        h(false);
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, "<<<onStart(), ts=" + l2);
        QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return;
      label368:
      AVReport.a().y = SystemClock.elapsedRealtime();
      break;
      label380:
      this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429104);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429104);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(2131429104);
      }
      l2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Long;
      String str = ColorRingManager.a(l2, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
          TraeHelper.a().a("DoubleVideoCtrlUI.onStart.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int;
        ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l2 + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator == null) {
          break label622;
        }
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
          TraeHelper.a().a("DoubleVideoCtrlUI.onStart.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, null, -1, null);
        }
      }
      label622:
      break label198;
      label624:
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator == null) {
        break label198;
      }
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
      break label198;
      label641:
      A();
    }
  }
  
  void f(int paramInt)
  {
    this.jdField_g_of_type_AndroidWidgetTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365375));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365376));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365374)).getLayoutParams();
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    boolean bool;
    if (paramInt == 1)
    {
      bool = true;
      d(bool);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
        break label181;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
      }
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
    }
    for (;;)
    {
      if ((i()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365391))) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
      }
      e();
      return;
      bool = false;
      break;
      label181:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        D();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
        }
        DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
      }
    }
  }
  
  void f(String paramString)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      UITools.a(this.jdField_d_of_type_AndroidWidgetTextView, paramString);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.b()))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
        n();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
  }
  
  public void g()
  {
    super.g();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    SensorHelper localSensorHelper;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f()))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
        super.Z();
      }
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label294;
      }
    }
    label294:
    for (boolean bool = true;; bool = false)
    {
      localSensorHelper.b(bool);
      u();
      DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, "<<<onResume(), ts=" + l2);
        QLog.d("IVR_TS_" + this.jdField_c_of_type_JavaLangString, 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      this.jdField_e_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().aA)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jrz(this), 200L);
      return;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "init  double video Control first time");
    c();
  }
  
  public void g(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()))
    {
      if (!this.jdField_i_of_type_Boolean) {
        i(paramInt);
      }
      return;
    }
    i(paramInt);
    ad();
  }
  
  @TargetApi(11)
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onAfterCloseCamera success : " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, true);
    }
    super.t(2131365399);
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
    {
      if (this.jdField_n_of_type_Int > 1)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(true);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (paramBoolean)
    {
      x();
      DataReport.d();
      DataReport.o(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        a("onAfterCloseCamera", 1);
      }
      if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) && (Build.VERSION.SDK_INT > 11)) {
        a(0.0F);
      }
      EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localEffectOperateManager != null) {
        localEffectOperateManager.a(false);
      }
      aj();
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  public void h(int paramInt)
  {
    if (1 == paramInt) {
      if (!this.jdField_e_of_type_Boolean) {
        y();
      }
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        s_();
        return;
      }
    } while ((2 != paramInt) || (!b()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(69, true);
    ReportController.b(null, "CliOper", "", "", "0X80061FB", "0X80061FB", 0, 0, "", "", "", "");
  }
  
  public void h(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = this.jdField_i_of_type_Boolean;
      if (this.jdField_i_of_type_Boolean) {
        i(0);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  public void i()
  {
    super.i();
    this.jdField_e_of_type_Boolean = true;
    K();
    s_();
  }
  
  public void i(int paramInt)
  {
    super.i(paramInt);
    if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, true);
    }
  }
  
  void i(boolean paramBoolean)
  {
    ImageView localImageView;
    TextView localTextView;
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131365381);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131365382);
      if ((localImageView != null) && (localTextView != null)) {}
    }
    else
    {
      return;
    }
    int i;
    Object localObject;
    int j;
    int k;
    Drawable localDrawable;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_u_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)))
    {
      i = 2130840147;
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(i);
      j = ((Drawable)localObject).getMinimumWidth();
      k = ((Drawable)localObject).getMinimumHeight();
      if (!paramBoolean) {
        break label200;
      }
      localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840152);
      localTextView.setTextColor(-1);
    }
    for (;;)
    {
      localImageView.setMinimumWidth(j);
      localImageView.setMinimumHeight(k);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localDrawable);
      return;
      i = 2130840146;
      break;
      label200:
      localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840154);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493572));
      localObject = TintStateDrawable.a(this.jdField_a_of_type_AndroidContentResResources, i, 2131493572);
      ((Drawable)localObject).setBounds(0, 0, j, k);
    }
  }
  
  public void j()
  {
    super.j();
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 4, "onStop()");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
      super.aa();
    }
  }
  
  void j(int paramInt)
  {
    Object localObject;
    String str;
    switch (paramInt)
    {
    default: 
      localObject = null;
      str = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        localObject = PopupDialog.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, (String)localObject, str, 2131429438, 2131429460, new jsq(this, paramInt), null);
        if (localObject != null) {
          ((QQCustomDialog)localObject).show();
        }
      }
      return;
      str = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429458);
      localObject = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429463);
      ReportController.b(null, "CliOper", "", "", "0X8005CFC", "0X8005CFC", 0, 0, "", "", "", "");
      continue;
      str = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429459);
      localObject = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429462);
      ReportController.b(null, "CliOper", "", "", "0X8005CFE", "0X8005CFE", 0, 0, "", "", "", "");
    }
  }
  
  void j(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label94:
    label247:
    label255:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      i(paramBoolean);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramBoolean);
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.t)) {
          break label247;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, 0, false);
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        }
      }
      G();
      AVActivity localAVActivity;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
      {
        localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramBoolean) {
          break label255;
        }
        bool1 = true;
        localAVActivity.b(bool1);
        if (paramBoolean) {
          break label260;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAVActivity.d(bool1);
        localAVActivity.c(paramBoolean);
        if (!paramBoolean) {
          break label265;
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
        }
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
        l(true);
        break label94;
        bool1 = false;
        break label139;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(0);
      }
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      }
    } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
    label139:
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    label260:
    label265:
    return;
  }
  
  public void k()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onDestroy");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoCtrlUI");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      s(true);
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnClickListener(2131365388, null);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_h_of_type_Boolean = false;
    this.jdField_k_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_i_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.k();
  }
  
  public void k(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aA) {}
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
              if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
              {
                AVLog.e(this.jdField_c_of_type_JavaLangString, "Remote not has video, nOff=" + paramInt);
                return;
              }
            } while (this.jdField_a_of_type_Int == paramInt);
            QLog.d(this.jdField_c_of_type_JavaLangString, 1, "setGlassSwitch nOff=" + paramInt + ", prior=" + this.jdField_a_of_type_Int);
            this.jdField_a_of_type_Int = paramInt;
            this.jdField_a_of_type_ComTencentAvVideoController.a().P = paramInt;
            switch (paramInt)
            {
            default: 
              return;
            case 0: 
              ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.h();
            }
          } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(1000, true);
          return;
          ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.g();
        } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(1001, true);
        return;
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.h();
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(1000, true);
      return;
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.g();
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(1002, true);
  }
  
  public void k(boolean paramBoolean)
  {
    View localView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365364);
      if (localView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!l()) {
            break label112;
          }
          if (paramBoolean) {
            break label85;
          }
          localLayoutParams.topMargin = (this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560109) - b() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
        }
      }
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      label85:
      localLayoutParams.topMargin = (-b() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
      continue;
      label112:
      if (!paramBoolean) {
        localLayoutParams.topMargin = (this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560109) - b() + AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentResResources));
      } else {
        localLayoutParams.topMargin = 0;
      }
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
    }
  }
  
  public void l(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Int) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "setGlassWaitTime nTime=" + paramInt + ", mCurrentVideoGlassWaitTime=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_Q_of_type_Int = paramInt;
  }
  
  public void m()
  {
    super.m();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_c_of_type_JavaLangString);
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onConnected ,roomid = " + l);
    if (l > 0L) {
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    Object localObject = l + "";
    VoiceChangeDataReport.a(localSessionInfo.jdField_d_of_type_Int, (String)localObject + "");
    localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365361);
    if (localSessionInfo.jdField_Q_of_type_Boolean) {
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493532));
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429202);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429202);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(2131429202);
    }
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      b("onConnected");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(6);
    }
    int i;
    label369:
    int j;
    label436:
    label485:
    SensorHelper localSensorHelper;
    if (!localSessionInfo.jdField_a_of_type_Boolean)
    {
      i = localSessionInfo.jdField_n_of_type_Int;
      if ((i > 0) && (i != 3) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(i + 9 - 1);
      }
      if (localSessionInfo.N)
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!localSessionInfo.jdField_c_of_type_Boolean) {
          break label933;
        }
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
      }
      if (localSessionInfo.jdField_d_of_type_Int != 2) {
        break label964;
      }
      d(true);
      j(true);
      x();
      c(true);
      localObject = localSessionInfo.jdField_c_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b((String)localObject);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c((String)localObject);
      if (i != 5) {
        break label997;
      }
      if (!localSessionInfo.ao) {
        break label971;
      }
      super.Z();
      D();
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (localSessionInfo.jdField_d_of_type_Int != 1) {
        break label1178;
      }
    }
    label1178:
    for (boolean bool = true;; bool = false)
    {
      localSensorHelper.b(bool);
      i = localSessionInfo.jdField_i_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.a();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      }
      if (localSessionInfo.jdField_i_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.j);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        }
      }
      if ((!localSessionInfo.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
      }
      if (localSessionInfo.jdField_d_of_type_Int == 2)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onConnected, CheckRemoteCameraRunnable");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 5000L);
      }
      if ((this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(25, true);
      }
      if (VideoUtils.a(localSessionInfo.jdField_i_of_type_Int, localSessionInfo.A))
      {
        if (((localSessionInfo.jdField_i_of_type_Int != 0) || (localSessionInfo.jdField_p_of_type_Int == 3024)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365391, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391, false);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(66, false);
        }
      }
      if ((localSessionInfo.jdField_i_of_type_Boolean) && (!localSessionInfo.jdField_g_of_type_Boolean)) {
        a("onConnected", 1);
      }
      H();
      return;
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      label933:
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label369;
      label964:
      x();
      break label436;
      label971:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_c_of_type_Boolean = true;
      break label485;
      label997:
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b())
      {
        if (localSessionInfo.ao)
        {
          super.Z();
          break label485;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_c_of_type_Boolean = true;
        break label485;
      }
      if (!localSessionInfo.f())
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_c_of_type_Boolean = true;
        break label485;
      }
      if (j > 18)
      {
        if ((localSessionInfo.ao) && (localSessionInfo.ap))
        {
          super.Z();
          break label485;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_c_of_type_Boolean = true;
        break label485;
      }
      if (localSessionInfo.ao)
      {
        super.Z();
        break label485;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_c_of_type_Boolean = true;
      break label485;
    }
  }
  
  void n()
  {
    if ((VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().A)) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int == 3024)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
    }
  }
  
  @TargetApi(11)
  public void o()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onPauseVideo");
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      a("onPauseVideo", 1);
      A();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(1000, true);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, true);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (Build.VERSION.SDK_INT > 11))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onResumeVideo setRotation");
          }
          a(0.0F);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, true);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().P = 0;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void p()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onResumeVideo, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "]");
    if ((!VcSystemInfo.b()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(30, true);
      }
      ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 2;
      a("onResumeVideo", 2);
      ThreadManager.post(new jsb(this), 5, null, false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, false);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().v) {
        h(true);
      }
    }
    ad();
  }
  
  public void q() {}
  
  public void r()
  {
    if ((!VcSystemInfo.b()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1))
    {
      this.jdField_g_of_type_Boolean = true;
      return;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean)
    {
      a("onNeedShowPeerVideo1", 2);
      if (!VcSystemInfo.b()) {
        break label205;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 2;
        a("onNeedShowPeerVideo2", 2);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, false);
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, false);
        this.jdField_g_of_type_Boolean = true;
      }
      H();
      return;
      label205:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      }
    }
  }
  
  void s()
  {
    ac();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation);
  }
  
  void s_()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131362533);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).b();
    }
  }
  
  void t()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jsf(this));
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshUI");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    Object localObject1;
    label221:
    do
    {
      Object localObject2;
      do
      {
        return;
        int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
        String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        Object localObject3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject3);
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = ((String)localObject1);
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365375));
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365376));
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView == null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362754));
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
            j(true);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
          {
            if ((!this.jdField_b_of_type_AndroidWidgetImageButton.isShown()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (this.jdField_n_of_type_Int > 1)) {
              this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
            }
            j(true);
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.a == null) {
              break label538;
            }
            a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.a);
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b);
          }
          if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b);
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 25) {
            break label589;
          }
          localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          }
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, (String)localObject1);
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
          this.jdField_a_of_type_ComTencentAvVideoController.a(str);
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
          }
          if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString)) || (localObject1 == null)) {
            break label558;
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          }
          if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          return;
          j(false);
          break label221;
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
      } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
    label538:
    label558:
    label589:
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, false);
    }
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onBeforeCloseCamera");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365403, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365403, false);
    }
    if ((this.jdField_n_of_type_Int > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(false);
    }
  }
  
  void x()
  {
    super.l(true);
  }
  
  void y()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131362533);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365361);
          localObject3 = ((ViewGroup)localObject2).getResources();
          int i = ((Resources)localObject3).getDimensionPixelOffset(2131560106);
          int j = ((Resources)localObject3).getDimensionPixelOffset(2131560107);
          int k = ((Resources)localObject3).getDimensionPixelOffset(2131559998);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, 0, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */