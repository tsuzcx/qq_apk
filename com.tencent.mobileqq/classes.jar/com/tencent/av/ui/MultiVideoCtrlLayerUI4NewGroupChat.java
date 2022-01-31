package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GroupInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jwq;
import jwr;
import jws;
import jwt;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4NewGroupChat
  extends MultiVideoCtrlLayerUIBase
{
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jwt(this);
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver = new jwq(this);
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new jwr(this);
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public MultiVideoCtrlLayerUI4NewGroupChat(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
    }
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365391)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().p()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(21, true);
  }
  
  private boolean m()
  {
    boolean bool = true;
    SessionInfo localSessionInfo = null;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    if (localSessionInfo == null) {
      return false;
    }
    if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GroupInfo.jdField_a_of_type_Int == 0)
    {
      if (b())
      {
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GroupInfo.jdField_a_of_type_Int = 1;
        QAVGroupConfig.Report.d(false);
      }
    }
    else {
      if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GroupInfo.jdField_a_of_type_Int != 1) {
        break label82;
      }
    }
    for (;;)
    {
      return bool;
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GroupInfo.jdField_a_of_type_Int = 2;
      QAVGroupConfig.Report.d(true);
      break;
      label82:
      bool = false;
    }
  }
  
  @TargetApi(11)
  private void y()
  {
    a(0.0F);
  }
  
  protected void D()
  {
    if (m())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(6);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(5);
  }
  
  void a()
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      super.g("handleExtraData");
      c();
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "handleExterData-->Wrong gaudioStatusType-->type = " + this.jdField_b_of_type_Int + " , relationId = " + this.jdField_a_of_type_Long + " , relationType = " + this.jdField_d_of_type_Int);
  }
  
  @TargetApi(11)
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "drawUI-->refreshType = " + paramInt1 + " , uin = " + paramLong + " , needRefresh = " + paramBoolean + " , originalType = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().an)) {
        TraeHelper.a().a("MultiVideoCtrlLayerUI4NewGroupChat.drawUI.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230735, null, 0, null);
      }
      if (paramLong == this.jdField_c_of_type_Long) {
        super.T();
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label380;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
        break label295;
      }
      if (paramInt1 == 1) {
        b(this.jdField_h_of_type_Int, 2131428970, String.valueOf(paramLong), null, 3000, 0);
      }
      localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131429128);
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (this.jdField_h_of_type_Boolean) {
        this.j = true;
      }
      UITools.a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidContentResResources.getString(2131429128));
    }
    for (;;)
    {
      super.h("drawUI");
      label244:
      if (paramInt2 != 42) {
        break label1223;
      }
      super.a(paramLong, true);
      return;
      if ((paramInt1 != 1) || (paramLong == this.jdField_c_of_type_Long)) {
        break;
      }
      TraeHelper.a().a("MultiVideoCtrlLayerUI4NewGroupChat.drawUI.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      break;
      label295:
      if (paramInt1 == 0)
      {
        this.j = false;
        super.Z();
        if ((paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().an)) {
          b(this.jdField_h_of_type_Int, 2131428965, String.valueOf(paramLong), null, 3000, 0);
        }
      }
      else if (paramInt1 == 1)
      {
        b(this.jdField_h_of_type_Int, 2131428970, String.valueOf(paramLong), null, 3000, 0);
      }
    }
    label380:
    if ((paramInt1 == 5) || (paramInt1 == 6))
    {
      paramBoolean = true;
      if (paramLong != this.jdField_c_of_type_Long) {
        break label1237;
      }
    }
    label648:
    label806:
    label1223:
    label1237:
    for (int i = 1;; i = 0)
    {
      boolean bool;
      if (paramInt1 == 6)
      {
        bool = super.d();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
        {
          super.z();
          if (Build.VERSION.SDK_INT >= 11) {
            y();
          }
        }
        paramBoolean = bool;
        if (i != 0)
        {
          paramBoolean = bool;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
            paramBoolean = bool;
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().an) && (paramBoolean))
      {
        if (this.j >= 4) {
          break;
        }
        if ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
          break label806;
        }
        if (i != 0) {
          break label648;
        }
        super.p(paramInt1);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jxl);
        this.jdField_a_of_type_Jxl.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jxl, 1000L);
      }
      for (;;)
      {
        n();
        break;
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onSelfVideoIn.-->FirstVideo=" + j + ",index=" + i);
        }
        if ((j == -1) || ((i == j) && (i != 0)))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jxl);
          this.jdField_a_of_type_Jxl.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jxl, 1000L);
          continue;
          if (i == 0)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
            super.R();
            super.a(true, true, true);
          }
        }
      }
      if ((paramInt1 == 7) || (paramInt1 == 8))
      {
        paramBoolean = true;
        if (paramInt1 == 8)
        {
          localObject = new VideoViewInfo();
          ((VideoViewInfo)localObject).jdField_a_of_type_Long = paramLong;
          ((VideoViewInfo)localObject).jdField_a_of_type_Int = 2;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject);
          this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
        }
        if (paramInt1 == 8)
        {
          bool = super.d();
          paramBoolean = bool;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
          {
            super.z();
            paramBoolean = bool;
            if (Build.VERSION.SDK_INT >= 11)
            {
              a(0.0F);
              paramBoolean = bool;
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().an) && (paramBoolean))
        {
          if (this.j >= 4) {
            break;
          }
          if ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
            break label1118;
          }
          super.p(paramInt1);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jxl);
          this.jdField_a_of_type_Jxl.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jxl, 1000L);
        }
        for (;;)
        {
          n();
          break;
          label1118:
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
          super.R();
          super.a(true, true, true);
        }
      }
      if ((paramInt1 != 97) && (paramInt1 != 98)) {
        break label244;
      }
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
      super.R();
      super.S();
      break label244;
      if (paramInt2 != 43) {
        break;
      }
      super.a(paramLong, false);
      return;
    }
  }
  
  public void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label188:
    label209:
    label241:
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
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          AVLog.d(this.jdField_c_of_type_JavaLangString, "qav_bottombar_effect click. mEffectType=" + this.u);
                          int i;
                          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 3)
                          {
                            i = 1;
                            if (this.u != 2) {
                              break label209;
                            }
                            v(-1);
                            if (i == 0) {
                              break label241;
                            }
                          }
                          for (paramView = "0X8007E6D";; paramView = "0X8007E6E")
                          {
                            VoiceChangeDataReport.a(paramView, "");
                            return;
                            i = 0;
                            break;
                            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(this.u) });
                            break label188;
                          }
                          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_btn_accept_video");
                          DataReport.b(NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), 10);
                          super.e();
                          this.jdField_a_of_type_ComTencentAvVideoController.a().as = true;
                          return;
                          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA_SHELL");
                        } while (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399));
                        if ((VcSystemInfo.f()) && (VcSystemInfo.b()) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1)) {
                          break;
                        }
                      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                      return;
                    } while (this.jdField_a_of_type_ComTencentAvVideoController.b() < jdField_a_of_type_Int);
                    paramView = this.jdField_a_of_type_AndroidContentResResources.getString(2131429172);
                  } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                  this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(64, paramView, 3000L, 1);
                  return;
                  QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_titlebar_mid_txt");
                  if (this.k - this.m > 2)
                  {
                    this.m = this.k;
                    this.l = 0;
                  }
                  this.l += 1;
                } while (this.l <= 5);
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(112) });
                this.l = 0;
                this.m = 0;
                return;
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onClick QavPanel.VIEW_ENUM.HIDE");
                if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
                {
                  DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 10);
                  if ((!SmallScreenUtils.b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
                    super.a(2131429114, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
                  }
                }
                if (SmallScreenUtils.b())
                {
                  paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  if ((paramView != null) && ((paramView instanceof AVActivity)))
                  {
                    paramView = (AVActivity)paramView;
                    if (paramView != null)
                    {
                      paramView = paramView.a();
                      if (paramView != null) {
                        paramView.a();
                      }
                    }
                  }
                }
                super.i(false);
                return;
                V();
                return;
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HANG_UP");
                VoiceChangeDataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a());
                if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
                  MultiVideoRichActionReportCollection.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                }
                if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
                {
                  this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jws(this));
                  return;
                }
                ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
                if (((this.jdField_e_of_type_Int == 90) || (this.jdField_e_of_type_Int == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 1)) {
                  ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  super.aa();
                  super.i(true);
                  if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.c, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 102);
                  return;
                  if (((this.jdField_e_of_type_Int == 90) || (this.jdField_e_of_type_Int == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 2)) {
                    ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
                  }
                }
                this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 103);
                return;
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE");
                super.P();
              } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
              super.ad();
              return;
              QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HAND_FREE");
              paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfJavaLangString;
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().N) && (paramView != null)) {
                DataReport.c(true, 10);
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
                if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
                  break;
                }
                super.ad();
                return;
                if (paramView == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "DeviceList is null");
                  }
                }
                else {
                  DataReport.c(false, 10);
                }
              }
              QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA");
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().r) || (j()))
              {
                AVLog.d(this.jdField_c_of_type_JavaLangString, "click qav_bottombar_camera not invalid .because voiceChoose=" + this.jdField_a_of_type_ComTencentAvVideoController.a().r + ", effectSetting=" + j());
                return;
              }
              super.M();
            } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
            super.ad();
            return;
            QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_titlebar_switchcamera");
            this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107) });
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
              super.ad();
            }
            paramView = (ImageButton)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365369);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = false;
              UITools.a(paramView, this.jdField_a_of_type_AndroidContentResResources.getString(2131428916));
              return;
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = true;
            UITools.a(paramView, this.jdField_a_of_type_AndroidContentResResources.getString(2131428915));
            return;
            QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER_SHELL");
            QAVGroupConfig.Report.e(false);
            A();
            return;
            QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER");
            if (b())
            {
              QAVGroupConfig.Report.e(false);
              A();
              t_();
              return;
            }
            QAVGroupConfig.Report.e(true);
            paramView = new Intent();
            paramView.setAction("tencent.video.v2q.AddMembersToGroup");
            paramView.putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
            paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
            this.jdField_a_of_type_ComTencentAvVideoController.jdField_g_of_type_Int = 1;
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
              ad();
            }
          } while (!SmallScreenUtils.b());
          paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((paramView == null) || (!(paramView instanceof AVActivity)));
        paramView = (AVActivity)paramView;
      } while (paramView == null);
      paramView = paramView.a();
    } while (paramView == null);
    paramView.c();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnKeyDown --> WRONG KeyCode = " + paramInt);
      }
      break;
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
              do
              {
                return false;
                this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
                return false;
              } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
              DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 10);
              if (SmallScreenUtils.b()) {
                break;
              }
            } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
            super.a(2131429114, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
            return false;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          paramKeyEvent = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((paramKeyEvent == null) || (!(paramKeyEvent instanceof AVActivity)));
        paramKeyEvent = (AVActivity)paramKeyEvent;
      } while (paramKeyEvent == null);
      paramKeyEvent = paramKeyEvent.a();
    } while (paramKeyEvent == null);
    paramKeyEvent.a();
    return false;
  }
  
  void b(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setMembersInOrOutWording --> Type = " + paramInt1 + " , Id = " + paramInt2 + " , Uin = " + paramString1 + " , value = " + paramString2 + " , time = " + paramInt3 + " , flag = " + paramInt4);
    }
    Object localObject = null;
    if (paramInt1 == this.jdField_h_of_type_Int) {
      if (paramString1 == null) {
        paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(63, paramString1, paramInt3, paramInt4);
      }
      return;
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
      float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      paramString1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.jdField_i_of_type_AndroidWidgetTextView, f);
      paramString1 = paramString1 + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      continue;
      paramString1 = localObject;
      if (paramInt1 == this.jdField_i_of_type_Int) {
        paramString1 = paramString2;
      }
    }
  }
  
  void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("forceShowInviteBox", false);
      if (!paramIntent.hasExtra("enableInvite")) {
        break label178;
      }
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("enableInvite", false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "processExtraData, gaudioStatusType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().E + "], relationId[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long + "], isInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.e + "], mGAudioGroupId[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long + "], isVideo[" + this.jdField_f_of_type_Boolean + "], mForceShowInviteBox[" + this.jdField_a_of_type_Boolean + "], mEnableInvite[" + this.jdField_b_of_type_Boolean + "]");
      }
      return;
      label178:
      paramIntent = new Bundle();
      paramIntent.putString("uin", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long + "");
      Bundle localBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3, 0, 0, paramIntent, null);
      AudioHelper.a("request", paramIntent);
      AudioHelper.a("response", localBundle);
      if (localBundle != null) {
        this.jdField_b_of_type_Boolean = localBundle.getBoolean("enableInvite", false);
      }
    }
  }
  
  protected boolean b()
  {
    if (AudioHelper.e()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "isFull, mEnableInvite[" + this.jdField_b_of_type_Boolean + "]");
    }
    return !this.jdField_b_of_type_Boolean;
  }
  
  void c()
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "createOrEnterVideo, mRelationId[" + this.jdField_b_of_type_Long + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "]");
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long <= 0L) {}
    do
    {
      return;
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131428977);
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(str);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 0, null, this.jdField_f_of_type_Boolean);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
    } while (this.jdField_b_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, null, this.jdField_f_of_type_Boolean);
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if (m())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(paramBoolean, paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
    a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
      l(true);
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "initViewList");
    }
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1)) {}
    for (long l = this.jdField_a_of_type_Long;; l = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(l, 1, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(l, 1, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      super.h("initViewList");
      return;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    super.k();
  }
  
  void n()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshCameraBtnState");
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int j = jdField_a_of_type_Int;
    if ((!VcSystemInfo.f()) || (!VcSystemInfo.b())) {
      super.L();
    }
    for (;;)
    {
      l(bool);
      return;
      if ((i >= j) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
      {
        super.L();
      }
      else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        super.c(true);
        bool = true;
      }
      else
      {
        super.c(false);
        bool = true;
      }
    }
  }
  
  public void t_()
  {
    if (m())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365391, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131365390, 8);
      return;
    }
    super.t_();
  }
  
  void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshMuteBtnState");
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365397)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365397, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        super.s(2131365397);
      }
    }
    else
    {
      return;
    }
    super.t(2131365397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat
 * JD-Core Version:    0.7.0.1
 */