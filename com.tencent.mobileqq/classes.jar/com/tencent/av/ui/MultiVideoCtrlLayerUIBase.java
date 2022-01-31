package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.ResidentTip;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jxk;
import jxl;
import jxm;
import jxn;
import jxo;
import jxp;
import jxq;
import jxr;
import jxs;
import jxu;
import jxv;
import jxx;
import jxy;
import jxz;
import jya;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  public static int a;
  public long a;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public ImageButton a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  public MultiMembersAudioUI a;
  public MultiMembersVideoUI a;
  public PstnCallbackWaitingUi a;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TraeMediaPlayer jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public jxs a;
  jya jdField_a_of_type_Jya = new jya(this);
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  GAudioUIObserver jdField_b_of_type_ComTencentAvAppGAudioUIObserver = new jxq(this);
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public String b;
  public int c;
  public long c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  public boolean c;
  public int d;
  public TextView d;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  TextView e;
  public Runnable e;
  public boolean e;
  public int f;
  TextView f;
  public Runnable f;
  public boolean f;
  public int g;
  Runnable g;
  int h = 0;
  int i;
  
  static
  {
    jdField_a_of_type_Int = 4;
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangRunnable = new jxk(this);
    this.jdField_i_of_type_Int = 1;
    this.jdField_a_of_type_Jxs = new jxs(this);
  }
  
  protected abstract void D();
  
  void G()
  {
    int j = 0;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        super.s(2131365375);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.u();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1))
      {
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131429566);
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        this.j = true;
        UITools.a(this.jdField_i_of_type_AndroidWidgetTextView, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 9)
    {
      this.j = true;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        j = 1;
      }
      if (j != 0)
      {
        j = 2131429122;
        label176:
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(j);
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
    }
    for (;;)
    {
      Z();
      break;
      j = 2131429022;
      break label176;
      this.j = false;
    }
  }
  
  void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new jxr(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void J()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean))
    {
      n();
      j(false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365375, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365375, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label92;
      }
      s(2131365375);
    }
    for (;;)
    {
      T();
      long l = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_c_of_type_Int, String.valueOf(l));
      t_();
      return;
      label92:
      t(2131365375);
    }
  }
  
  void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshGAList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "refreshGAList --> VideoController is null");
  }
  
  public void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "disableCameraBtn");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365377, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365377, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365377, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365377, this.jdField_a_of_type_AndroidContentResResources.getString(2131428878));
    }
  }
  
  public void M()
  {
    int m = 1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {}
    for (SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();; localSessionInfo = null)
    {
      Object localObject = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("pressCameraBtn, sessionInfo[");
      if (localSessionInfo != null)
      {
        bool = true;
        localStringBuilder = localStringBuilder.append(bool).append("], mVideoController[");
        if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
          break label108;
        }
      }
      label108:
      for (boolean bool = true;; bool = false)
      {
        QLog.w((String)localObject, 1, bool + "]");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
          break label114;
        }
        return;
        bool = false;
        break;
      }
      label114:
      int k;
      if ((localSessionInfo != null) && (!localSessionInfo.jdField_f_of_type_Boolean))
      {
        DataReport.f(true);
        k = m;
        if (!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
          if (VideoController.d(VideoController.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()) <= 0) {
            break label360;
          }
        }
      }
      label360:
      for (int j = 0;; j = 1)
      {
        k = m;
        if (j != 0)
        {
          localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject == null) {
            break;
          }
          DialogUtil.b((Context)localObject, 230, this.jdField_a_of_type_AndroidContentResResources.getString(2131429035), this.jdField_a_of_type_AndroidContentResResources.getString(2131429029), 2131429042, 2131429047, new jxm(this), new jxn(this)).show();
          k = 0;
        }
        if (k == 0) {
          break;
        }
        if ((localSessionInfo.a() == -1) && (!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
        {
          N();
          return;
        }
        if (c())
        {
          L();
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
        return;
        O();
        if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        return;
      }
    }
  }
  
  public void N()
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("goOnStageWithoutWiFiCheck, mContext[");
    if (localContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (localContext != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().l()) {}
    for (int j = 2131429033;; j = 2131429034)
    {
      DialogUtil.b(localContext, 230, null, this.jdField_a_of_type_AndroidContentResResources.getString(j), 2131429042, 2131429047, new jxo(this), new jxp(this)).show();
      return;
    }
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go Off Stage");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_ComTencentAvUiControlUIObserver == null) || (this.jdField_b_of_type_AndroidWidgetImageButton == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "goOffStage --> Error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.z();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false);
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    R();
  }
  
  void P()
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
    long l;
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      l = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "pressMuteBtn --> RelationId = " + l + " ,IsMute = " + bool);
      }
      if (!bool) {
        break label147;
      }
      if (this.jdField_d_of_type_Int != 2) {
        break label138;
      }
      DataReport.a(true, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.pressMuteBtn.1", l, true, true);
      super.t(2131365375);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      return;
      l = this.jdField_a_of_type_Long;
      break;
      label138:
      DataReport.a(true, 10);
    }
    label147:
    if (this.jdField_d_of_type_Int == 2) {
      DataReport.a(false, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.pressMuteBtn.2", l, false, true);
      super.s(2131365375);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      return;
      DataReport.a(false, 10);
    }
  }
  
  public void Q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> VideoController is null");
      }
    }
    label211:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> Not in MultiVideoRoom");
      return;
      int k = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> OnStage Number = " + k);
      }
      int j;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1) != -1)
      {
        j = 1;
        if ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
          break label299;
        }
        if (j != 0)
        {
          if (k >= jdField_a_of_type_Int) {
            break label261;
          }
          if (!c()) {
            break label211;
          }
          L();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
          break label294;
        }
        e();
        return;
        j = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> Go on Stage Failed");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.y();
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.y();
      }
      z();
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
      }
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.y();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label424;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
      R();
      if (NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    label261:
    label294:
    label299:
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, 0);
    return;
    a(true, true, true);
    return;
    label424:
    z();
  }
  
  @TargetApi(11)
  public void R()
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "switchUIMode --> SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    l(true);
    QavPanel localQavPanel;
    if (k == 4)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(0);
      T();
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean;
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (!bool) {
        break label378;
      }
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    }
    for (;;)
    {
      c(true, j);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(true);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(true);
      }
      d(true);
      h(true);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        b(false);
        return;
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        s(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(8);
        T();
        localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        c(false, 1);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(false);
        }
        d(false);
        h(false);
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().L)) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (Build.VERSION.SDK_INT >= 11)) {
          a(0.0F);
        }
      }
      label378:
      j = 1;
    }
  }
  
  public void S()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      TipsManager.c(103);
      TipsManager.c(106);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131428699);
      TipsManager.a(107, str);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107, str, false);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    a(true, false, true);
  }
  
  void T()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo.p())
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(false);
      m(localSessionInfo.jdField_d_of_type_Int);
      return;
    }
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "refreshMemberCtrlButton, SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], multiAVType[" + localSessionInfo.D + "], mUinType[" + this.jdField_c_of_type_Int + "], isManager[" + localSessionInfo.ae + "], isRoomCreator[" + localSessionInfo.af + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "]");
    if ((localSessionInfo.ae) || (localSessionInfo.af))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
      }
    }
    for (;;)
    {
      m(localSessionInfo.jdField_d_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  public void U()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    int j = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".level", 1);
    int k = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".sendDura", 5000);
    int m = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".validDura", 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.a(j, k, m);
  }
  
  void V()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick Member_Speaking_Mgr");
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.MeetingMemberManager");
    localIntent.putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    if (this.jdField_c_of_type_Int == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8005C26", "0X8005C26", 0, 0, "", "", "", "");
    }
    while (this.jdField_c_of_type_Int != 3000) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005C21", "0X8005C21", 0, 0, "", "", "", "");
  }
  
  public void W()
  {
    int j = 0;
    Object localObject;
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidContentResResources != null))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429564));
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429564));
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        localObject = new Rect();
        Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localActivity != null)
        {
          localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
          j = ((Rect)localObject).top;
        }
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if (j == 0) {
          break label148;
        }
      }
    }
    label148:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = j;; ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560023))
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onApnChanged --> NetType = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, paramInt);
    }
    if ((NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      e();
    }
    return 0;
  }
  
  Intent a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null) {
        return localAVActivity.getIntent();
      }
    }
    return null;
  }
  
  public String a(String paramString, int paramInt, TextView paramTextView)
  {
    String str;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "genDiscussTitle, name == null");
      }
      str = "";
    }
    TextPaint localTextPaint;
    float f2;
    float f1;
    do
    {
      do
      {
        return str;
        int j = AIOUtils.a(160.0F, this.jdField_a_of_type_AndroidContentResResources);
        localTextPaint = paramTextView.getPaint();
        f2 = j - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - 4.0F * this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
        str = paramString;
      } while (f2 <= 0.0F);
      f1 = localTextPaint.measureText(paramString);
      str = paramString;
    } while (f1 <= f2);
    float f3 = f2 - localTextPaint.measureText("…");
    paramTextView = paramString;
    for (;;)
    {
      if ((f3 > 0.0F) && (f1 > f3) && (paramTextView.length() > 0))
      {
        paramTextView = paramTextView.substring(0, paramTextView.length() - 1);
        f2 = localTextPaint.measureText(paramTextView);
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (paramTextView.length() > 0) {
            f1 = 1.0F + f3;
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "genDiscussTitle, name widht[" + f1 + "]");
        }
      }
      else
      {
        str = paramString;
        if (f3 <= 0.0F) {
          break;
        }
        str = paramString;
        if (paramTextView.length() <= 0) {
          break;
        }
        return paramTextView + "…";
      }
    }
  }
  
  abstract void a();
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "sendVideoMsgBroadcast--> discussionId = " + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.AddVideoMsg");
        localIntent.putExtra("uinType", this.jdField_c_of_type_Int);
        localIntent.putExtra("msgType", 13);
        localIntent.putExtra("isVideoMsg", false);
        localIntent.putExtra("friendUin", Long.toString(paramLong));
        localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        localIntent.putExtra("isSender", true);
        localIntent.putExtra("isRead", true);
        localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().D);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  public abstract void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramBoolean);
    }
    do
    {
      while (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(paramLong, paramBoolean);
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
  }
  
  void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI == null) || (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidViewView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "adapterScreen-->Container is null");
      }
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559998);
    int k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559992);
    int j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560020);
    int n = UITools.a(paramContext);
    UITools.b(paramContext);
    if (n >= 1080) {}
    for (;;)
    {
      localLayoutParams1.topMargin = m;
      localLayoutParams2.topMargin = k;
      localLayoutParams3.height = j;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setLayoutParams(localLayoutParams2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams3);
      b(true);
      return;
      if (n >= 720)
      {
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560001);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559993);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560020);
      }
      else if (n >= 480)
      {
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560004);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559994);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560021);
      }
      else if (n >= 320)
      {
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560007);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559995);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560022);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    boolean bool = false;
    super.a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnNewIntent");
    }
    c(paramIntent);
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      z();
    }
    b(paramIntent);
    if (bool) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    }
    a();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super.a(paramString1, paramInt1, paramString2, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewChange --> BigViewUin = " + paramString1 + " , BigViewVideoViewType = " + paramInt1 + " , SmallViewUin = " + paramString2 + " , SmallViewVideoViewType = " + paramInt2);
    }
    if ((paramString1 == null) || (paramString2 == null)) {}
    while (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {
      return;
    }
    for (;;)
    {
      try
      {
        Long.valueOf(paramString1).longValue();
        long l = Long.valueOf(paramString2).longValue();
        if (paramInt1 == 2)
        {
          TipsManager.c(106);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
        }
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().a(Long.valueOf(paramString1).longValue(), paramInt1);
        if (j == -1) {
          break;
        }
        paramString1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(j);
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          paramString2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
          if ((l == paramString2.jdField_a_of_type_Long) && (paramInt2 == paramString2.jdField_a_of_type_Int))
          {
            paramString1.jdField_a_of_type_Boolean = false;
            if ((paramString1.jdField_a_of_type_Long != this.jdField_c_of_type_Long) && (paramString2.jdField_a_of_type_Long != this.jdField_c_of_type_Long) && (4 != this.jdField_a_of_type_ComTencentAvVideoController.g())) {
              paramString1.jdField_c_of_type_Boolean = false;
            }
            paramString2.jdField_a_of_type_Boolean = true;
            if ((4 != this.jdField_a_of_type_ComTencentAvVideoController.g()) && (!paramString2.jdField_c_of_type_Boolean))
            {
              paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
              if (paramInt2 != -1) {
                ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2)).jdField_c_of_type_Boolean = false;
              }
            }
            paramString2.jdField_c_of_type_Boolean = true;
            if ((paramString2.jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (this.jdField_d_of_type_Int == 2)) {
              ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
            }
            if ((!paramString2.b) && (this.jdField_a_of_type_ComTencentAvVideoController.g() != 4)) {
              DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().D);
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(j, paramString2);
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, paramString1);
          }
        }
        else
        {
          e();
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewChange --> Parse String 2 Long Failed");
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    int j = 0;
    for (;;)
    {
      if (j < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(j)).jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
          paramArrayList.remove(j);
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
        return;
      }
      j += 1;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + paramBoolean1 + " , needNoticeWiFiTips = " + paramBoolean2 + " , needShowGLView = " + paramBoolean3);
    }
    if (paramBoolean1)
    {
      DataReport.d(NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      z();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        if (!paramBoolean2) {
          break label158;
        }
        String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429234);
        TipsManager.a(102, str);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102, str, false);
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
      }
      return;
      label158:
      TipsManager.c(102);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      TipsManager.c(102);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
      }
      TipsManager.c(107);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107);
      }
    }
  }
  
  void b()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "initUI, SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], switchToGaudio[" + localSessionInfo.T + "], localMute[" + localSessionInfo.jdField_c_of_type_Boolean + "]");
    super.q(2130969284);
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365926));
    m(localSessionInfo.jdField_d_of_type_Int);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      D();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, (Activity)localObject, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
    }
    if ((localSessionInfo.F == 2) && (localSessionInfo.x == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365927);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365928));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365929);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365930));
    this.jdField_g_of_type_AndroidWidgetTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365343));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365345));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362736));
    this.jdField_i_of_type_AndroidWidgetTextView.post(this.jdField_g_of_type_JavaLangRunnable);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365354));
    if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      L();
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(false);
    }
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi = new PstnCallbackWaitingUi((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((AVActivity)localObject).findViewById(2131365810));
    TintStateDrawable.a(this.jdField_a_of_type_AndroidWidgetButton, 2130840156, 2131494045);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject).findViewById(2131364222));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365923));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365924));
    a(((AVActivity)localObject).getApplicationContext());
    e();
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365369, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365369, this.jdField_a_of_type_AndroidContentResResources.getString(2131428892));
    }
    GAudioSoundUtil.a(((AVActivity)localObject).getApplicationContext());
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b())) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.i();
      }
    }
    if ((localSessionInfo.T) && (localSessionInfo.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.initUI", localSessionInfo.jdField_f_of_type_Long, false, true);
      super.s(2131365375);
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new jxl(this));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_b_of_type_AndroidWidgetTextView = this.jdField_j_of_type_AndroidWidgetTextView;
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() != 1))
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366242);
      if (localObject != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559725);
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
    if (this.jdField_f_of_type_JavaLangRunnable == null) {
      this.jdField_f_of_type_JavaLangRunnable = new jxu(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_f_of_type_JavaLangRunnable);
    t_();
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, null, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365355), null);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
    if (localSessionInfo.jdField_d_of_type_Int == 4) {
      R();
    }
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(this.jdField_c_of_type_Long, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.h());
  }
  
  abstract void b(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4);
  
  abstract void b(Intent paramIntent);
  
  protected void b(String paramString)
  {
    super.b(paramString);
    b(false);
  }
  
  @TargetApi(11)
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    int k = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    int m = UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {}
    for (int j = this.jdField_a_of_type_ComTencentAvUiQavPanel.a();; j = 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!paramBoolean)) {
        if (Build.VERSION.SDK_INT < 11) {
          break label292;
        }
      }
      label292:
      for (float f1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f1 = 0.0F)
      {
        if (f1 % 180.0F == 0.0F)
        {
          localLayoutParams.addRule(12, -1);
          localLayoutParams.addRule(13, 0);
          localLayoutParams.bottomMargin = (m * 1 / 2);
          localLayoutParams.height = -2;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams.addRule(12, 0);
          localLayoutParams.addRule(13, -1);
          localLayoutParams.bottomMargin = 0;
          localLayoutParams.height = (k * 23 / 25);
          continue;
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(13, 0);
          localLayoutParams.height = -2;
          if (k <= 320) {
            localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559866));
          } else if (k <= 480) {
            localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559865));
          } else {
            localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559864));
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  protected abstract boolean b();
  
  abstract void c();
  
  @TargetApi(11)
  public void c(int paramInt)
  {
    this.q = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while ((Build.VERSION.SDK_INT < 11) || (this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_e_of_type_Int = 0;
      a(0.0F);
      return;
    case 90: 
      this.jdField_e_of_type_Int = 270;
      a(270.0F);
      return;
    case 180: 
      this.jdField_e_of_type_Int = 180;
      a(180.0F);
      return;
    }
    this.jdField_e_of_type_Int = 90;
    a(90.0F);
  }
  
  public void c(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshUI-->uin = " + paramLong + " , refreshType = " + paramInt1 + " , isRefreshTitle = " + paramBoolean + " , originalType = " + paramInt2);
    }
    if (paramLong == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, " refreshUI-->uin == 0");
      }
    }
    label208:
    label226:
    for (;;)
    {
      return;
      jxy localjxy = new jxy(this, paramLong, paramInt1, paramBoolean, paramInt2);
      Object localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
      {
        localObject = null;
        localObject = (AVActivity)localObject;
        if (localObject == null) {
          break label208;
        }
        ((AVActivity)localObject).runOnUiThread(localjxy);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
          break label226;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(this.jdField_c_of_type_Long, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.h());
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_c_of_type_Long, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.h());
        return;
        localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        break;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "refreshUI-->Can not get AVActivity");
        }
      }
    }
  }
  
  void c(Intent paramIntent)
  {
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      this.jdField_c_of_type_Int = localSessionInfo.jdField_i_of_type_Int;
      if (this.jdField_c_of_type_Int == 3000)
      {
        this.jdField_d_of_type_Int = 2;
        localSessionInfo.F = this.jdField_d_of_type_Int;
        int j = localSessionInfo.E;
        this.jdField_a_of_type_Long = localSessionInfo.jdField_f_of_type_Long;
        if ((localSessionInfo.W) && (j == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.b().size() == 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().size() == 0)) {
          localSessionInfo.E = 0;
        }
        this.jdField_b_of_type_Int = localSessionInfo.E;
        if (paramIntent != null) {
          this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("isVideo", false);
        }
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "processIntentData, mUinType[" + this.jdField_c_of_type_Int + "], mRelationType[" + this.jdField_d_of_type_Int + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "], mStatusType[" + this.jdField_b_of_type_Int + "], isMultiMeeting[" + localSessionInfo.W + "], mStatusType[" + j + "->" + this.jdField_b_of_type_Int + "], getSimpleDataList[" + this.jdField_a_of_type_ComTencentAvVideoController.b() + "], getGAudioList[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Can not get AccountUin WHY!!!???");
        }
        this.jdField_c_of_type_Long = 0L;
        continue;
        if (this.jdField_c_of_type_Int == 1) {
          this.jdField_d_of_type_Int = 1;
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "enableCameraBtn --> IconPress = " + paramBoolean);
    }
    int j = Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if ((!VcSystemInfo.f()) || (!VcSystemInfo.b()) || (j == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "enableCameraBtn --> Disable Camera Button. IsNormalSharp = " + VcSystemInfo.f() + " , isSupportSharpVideo = " + VcSystemInfo.b() + " , GLVersion = " + j);
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365377, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365377, false);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365377, true);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365377, true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365377, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365377, this.jdField_a_of_type_AndroidContentResResources.getString(2131428875));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365377, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365377, this.jdField_a_of_type_AndroidContentResResources.getString(2131428874));
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go on Stage");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Go On Stage, VideoController is null");
    }
    return false;
  }
  
  public void c_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showSharpInfo --> bShow = " + paramBoolean);
    }
    m(paramBoolean);
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnCreate");
    }
    if ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Intent localIntent = a();
    c(localIntent);
    b(localIntent);
  }
  
  void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840334);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null);
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(0);
  }
  
  boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "checkRemoteVideo --> checkRemoteVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "checkRemoteVideo --> VideoController is null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      g("checkRemoteVideo");
      a(false, false, false);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_c_of_type_Long))
    {
      a(false, false, false);
      j("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  abstract void e();
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onDetectNoDevicePermission --> IssueType = " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      O();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
    }
    for (;;)
    {
      super.e(paramInt);
      return;
      if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().k = false;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365375, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365375, false);
        }
        FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365374);
        if (localFrameLayout != null) {
          localFrameLayout.setClickable(true);
        }
      }
    }
  }
  
  void e(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> VideoController is null");
      }
      return false;
    }
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && ((localObject instanceof AVActivity)))
    {
      localObject = (AVActivity)localObject;
      if (localObject == null) {}
    }
    for (boolean bool = ((AVActivity)localObject).isResume();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> isResume = " + bool);
      }
      if (!bool) {
        return false;
      }
      int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
      int j = k;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
        j = k - 1;
      }
      if (j <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> There is no video need request");
        }
        return false;
      }
      bool = VcSystemInfo.b();
      j = Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      if ((!bool) || (j == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl. IsSupportSharpVideo = " + bool + " , GlVersion = " + j);
        }
        return false;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
      j = this.jdField_a_of_type_ComTencentAvVideoController.g();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> Ability = " + j);
      }
      if (j != 4)
      {
        if (this.jdField_d_of_type_Int == 2) {
          ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 1)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(62, true);
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.clear();
      j = 0;
      while (j < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(j);
        if (((VideoViewInfo)localObject).jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.add(localObject);
        }
        j += 1;
      }
      a(false, false, false);
      TipsManager.c(106);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      TipsManager.c(103);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
      return this.jdField_a_of_type_ComTencentAvVideoController.e();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnStart");
    }
    if (TipsManager.a.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.a.jdField_a_of_type_Int, TipsManager.a.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      a(this.jdField_b_of_type_Long);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  void f(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, paramString);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnResume");
    }
    G();
    J();
    if (TipsManager.a.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.a.jdField_a_of_type_Int, TipsManager.a.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
    }
    if ((this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.x();
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
      I();
    }
    if (this.jdField_d_of_type_JavaLangRunnable == null)
    {
      this.jdField_d_of_type_JavaLangRunnable = new jxv(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 2000L);
    }
    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.a();
    }
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())
    {
      i(paramInt);
      ad();
    }
  }
  
  void g(String paramString)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_c_of_type_JavaLangString;
      paramString = new StringBuilder().append("closeRemoteVideo[").append(paramString).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        bool = true;
        QLog.d(str, 2, bool + "]");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break label76;
      }
    }
    label76:
    do
    {
      for (;;)
      {
        return;
        bool = false;
        break;
        this.jdField_a_of_type_ComTencentAvVideoController.f();
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
        R();
        j("closeRemoteVideo");
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
        if (Build.VERSION.SDK_INT >= 19) {
          try
          {
            paramString = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if ((paramString != null) && (paramString.getWindow() != null))
            {
              paramString.getWindow().setFlags(2048, 1024);
              return;
            }
          }
          catch (Exception paramString) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "closeRemoteVideo --> SetFullScreenFailed. Exception = " + paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnPause");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.b();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().aq = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("MultiVideoCtrlLayerUIBase");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (((!SmallScreenUtils.b()) || ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
        O();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) {
        this.jdField_a_of_type_ComTencentAvVideoController.f();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jya);
  }
  
  public void h(int paramInt) {}
  
  public void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "notifyDataChange[" + paramString + "]");
    }
    K();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429122));
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131429122));
      }
    }
    int j;
    int k;
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null)
    {
      j = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      if (j >= 1080)
      {
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559996);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559997);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 4)
      {
        if (!this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a())
        {
          this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setTwoLineState(true);
          o(j);
        }
        label178:
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_JavaUtilArrayList);
        label189:
        if (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI == null) {
          break label350;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      label350:
      while (!QLog.isColorLevel())
      {
        return;
        if (j >= 720)
        {
          k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559999);
          j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560000);
          break;
        }
        if (j >= 480)
        {
          k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560002);
          j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560003);
          break;
        }
        if (j < 320) {
          break label368;
        }
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560005);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560006);
        break;
        if (!this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a()) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setTwoLineState(false);
        o(k);
        break label178;
        if (!QLog.isColorLevel()) {
          break label189;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "notifyDataChange --> MemberUI is null");
        break label189;
      }
      QLog.e(this.jdField_c_of_type_JavaLangString, 2, "notifyDataChange --> MemberUI is null");
      return;
      label368:
      j = 0;
      k = 0;
    }
  }
  
  void h(boolean paramBoolean)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "switchMode --> Can not get activity");
      }
    }
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365922);
        localObject = (AVActivity)localObject;
        if (!paramBoolean) {
          break;
        }
        localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131492923));
      } while (localObject == null);
      ((AVActivity)localObject).b(false);
      ((AVActivity)localObject).d(false);
      ((AVActivity)localObject).c(true);
      return;
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493531));
    } while (localObject == null);
    ((AVActivity)localObject).b(true);
    ((AVActivity)localObject).d(true);
    ((AVActivity)localObject).c(false);
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "addRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_b_of_type_JavaLangRunnable = new jxz(this);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
  }
  
  public void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnStop");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_c_of_type_Int, str1, null);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_Int, str1, null, true, true);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString, str2, localBitmap, str1, 44, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.w();
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void j(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "removeRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365375, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365375, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365375, false);
      }
      return;
    }
    paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.h();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365375, paramBoolean);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365375, true);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365375, true);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jxs);
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_i_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Jxs = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    TipsManager.c(102);
    TipsManager.c(103);
    TipsManager.c(107);
    TipsManager.c(106);
    TipsManager.c(104);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_b_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.c();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("MultiVideoCtrlLayerUIBase.onDestroy");
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.k();
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("MultiVideoCtrlLayerUIBase.playGAudioMicChangedSound.1", 2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("MultiVideoCtrlLayerUIBase.playGAudioMicChangedSound");
      break;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("MultiVideoCtrlLayerUIBase.playGAudioMicChangedSound.2", 2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  void m(int paramInt)
  {
    int k = 2130840208;
    int j = k;
    if (this.jdField_a_of_type_AndroidWidgetImageButton.isEnabled())
    {
      j = k;
      if (this.jdField_a_of_type_AndroidWidgetImageButton.isClickable()) {
        j = 2130840209;
      }
    }
    if (paramInt == 3) {
      AudioHelper.a(this.jdField_a_of_type_AndroidWidgetImageButton, false, j);
    }
    while (paramInt != 4) {
      return;
    }
    AudioHelper.a(this.jdField_a_of_type_AndroidWidgetImageButton, true, j);
  }
  
  public abstract void n();
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showStatusTips --> Type = " + paramInt);
    }
    jxx localjxx = new jxx(this, paramInt, false);
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localObject = null;
      localObject = (AVActivity)localObject;
      if (localObject == null) {
        break label86;
      }
      ((AVActivity)localObject).runOnUiThread(localjxx);
    }
    label86:
    while (!QLog.isColorLevel())
    {
      return;
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
    }
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showStatusTips-->can not get AVActivity");
  }
  
  void o(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams(localLayoutParams);
  }
  
  void p(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 8) || (paramInt == 74)) {}
    do
    {
      do
      {
        return;
      } while ((VcSystemInfo.b()) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1));
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(30, true);
      }
      ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo-->GLVersion not support");
  }
  
  public void t_()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    if (i())
    {
      if (((this instanceof MultiVideoCtrlLayerUI4NewGroupChat)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369))) {
        QAVGroupConfig.Report.f(false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365369, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365369, this.jdField_a_of_type_AndroidContentResResources.getString(2131428892));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null)) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().p();; bool = false)
    {
      if ((b()) || (bool))
      {
        if (((this instanceof MultiVideoCtrlLayerUI4NewGroupChat)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369))) {
          QAVGroupConfig.Report.f(false);
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365369, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365369, this.jdField_a_of_type_AndroidContentResResources.getString(2131428892));
        return;
      }
      if (((this instanceof MultiVideoCtrlLayerUI4NewGroupChat)) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369))) {
        QAVGroupConfig.Report.f(true);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365369, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365369, this.jdField_a_of_type_AndroidContentResResources.getString(2131428913));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365368, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365368, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365368, this.jdField_a_of_type_AndroidContentResResources.getString(2131428913));
      return;
    }
  }
  
  public void u()
  {
    super.u();
  }
  
  public void v() {}
  
  public abstract void x();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */