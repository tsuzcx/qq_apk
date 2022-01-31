package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jwo;
import jwp;
import jwq;
import jwr;
import jws;
import jwt;
import jwu;
import jwv;
import jww;
import jwx;
import jwy;
import jxc;
import jxd;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4Discussion
  extends MultiVideoCtrlLayerUIBase
{
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jwy(this);
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new jwt(this);
  public Map a;
  public boolean a;
  public long[] a;
  
  public MultiVideoCtrlLayerUI4Discussion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
    }
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void D()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(5);
  }
  
  void a()
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      g("handleExtraData");
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
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidContentResResources != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().y != 4))
    {
      f(paramInt);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      ReportController.b(null, "CliOper", "", "", "0X8006401", "0X8006401", 0, 0, "", "", "", "");
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jwo(this, paramInt2, paramString1, paramInt3, paramInt4), 1000L);
  }
  
  @TargetApi(11)
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "drawUI-->refreshType = " + paramInt1 + " , uin = " + paramLong + " , needRefresh = " + paramBoolean + " , originalType = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject1;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().an)) {
        TraeHelper.a().a("MultiVideoCtrlLayerUI4Discussion.drawUI.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230735, null, 0, null);
      }
      if ((paramLong != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long) && (paramLong != this.jdField_c_of_type_Long))
      {
        TipsManager.c(105);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(105);
        }
      }
      if (paramLong == this.jdField_c_of_type_Long) {
        T();
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label523;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
        break label424;
      }
      if (paramInt1 == 1) {
        b(this.jdField_h_of_type_Int, 2131428963, String.valueOf(paramLong), null, 3000, 0);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          break label412;
        }
        paramInt1 = 1;
        label269:
        if (paramInt1 == 0) {
          break label417;
        }
        paramInt1 = 2131429122;
        label277:
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt1);
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
        if (this.jdField_h_of_type_Boolean) {
          this.j = true;
        }
        UITools.a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidContentResResources.getString(2131429122));
      }
      label332:
      h("drawUI");
    }
    label339:
    Object localObject2;
    for (;;)
    {
      if (paramInt2 == 42)
      {
        a(paramLong, true);
        return;
        if (paramInt1 != 1) {
          break;
        }
        if (paramLong != this.jdField_c_of_type_Long) {
          TraeHelper.a().a("MultiVideoCtrlLayerUI4Discussion.drawUI.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        TipsManager.c(105);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(105);
        break;
        label412:
        paramInt1 = 0;
        break label269;
        label417:
        paramInt1 = 2131429022;
        break label277;
        label424:
        if (paramInt1 == 0)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)
          {
            this.j = false;
            Z();
          }
          if ((paramLong == this.jdField_c_of_type_Long) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().an)) {
            break label332;
          }
          b(this.jdField_h_of_type_Int, 2131428958, String.valueOf(paramLong), null, 3000, 0);
          break label332;
        }
        if (paramInt1 != 1) {
          break label332;
        }
        b(this.jdField_h_of_type_Int, 2131428963, String.valueOf(paramLong), null, 3000, 0);
        break label332;
        label523:
        if (paramInt1 == 68)
        {
          float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559815);
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
          localObject2 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.jdField_i_of_type_AndroidWidgetTextView, f);
          if (this.jdField_f_of_type_Int == 1) {}
          for (localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429010);; localObject1 = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131429009), new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }))
          {
            localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429008) + (String)localObject2 + (String)localObject1;
            b(this.jdField_i_of_type_Int, 0, null, (String)localObject1, 3000, 0);
            break;
          }
        }
        if (paramInt1 == 82)
        {
          b(this.jdField_i_of_type_Int, 0, null, this.jdField_a_of_type_JavaLangString, 3000, 0);
        }
        else if ((paramInt1 == 5) || (paramInt1 == 6))
        {
          paramBoolean = true;
          if (paramLong != this.jdField_c_of_type_Long) {
            break label1739;
          }
        }
      }
    }
    label1315:
    label1739:
    for (int i = 1;; i = 0)
    {
      boolean bool;
      if (paramInt1 == 6)
      {
        bool = d();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
        {
          z();
          if (Build.VERSION.SDK_INT >= 11) {
            a(0.0F);
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
          break label1149;
        }
        if (i != 0) {
          break label991;
        }
        p(paramInt1);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jya);
        this.jdField_a_of_type_Jya.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jya, 1000L);
      }
      for (;;)
      {
        n();
        break;
        label991:
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onSelfVideoIn.-->FirstVideo=" + j + ",index=" + i);
        }
        if ((j == -1) || ((i == j) && (i != 0)))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jya);
          this.jdField_a_of_type_Jya.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jya, 1000L);
          continue;
          label1149:
          if (i == 0)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
            R();
            a(true, true, true);
          }
        }
      }
      if ((paramInt1 == 7) || (paramInt1 == 8))
      {
        if (paramInt1 == 8)
        {
          localObject1 = new VideoViewInfo();
          ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong;
          ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localObject1);
          this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
        }
        if (paramInt1 == 8)
        {
          bool = d();
          paramBoolean = bool;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
          {
            z();
            paramBoolean = bool;
            if (Build.VERSION.SDK_INT >= 11)
            {
              a(0.0F);
              paramBoolean = bool;
            }
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().an) && (paramBoolean))
          {
            if (this.j >= 4) {
              break;
            }
            if ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
              break label1490;
            }
            p(paramInt1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jya);
            this.jdField_a_of_type_Jya.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jya, 1000L);
          }
        }
        for (;;)
        {
          n();
          break;
          ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
          paramBoolean = true;
          break label1315;
          label1490:
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
          R();
          a(true, true, true);
        }
      }
      if ((paramInt1 == 97) || (paramInt1 == 98))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
        R();
        S();
        break label339;
      }
      if (paramInt1 == 11)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1) {
          break label339;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429565);
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
        this.j = true;
        UITools.a(this.jdField_i_of_type_AndroidWidgetTextView, (String)localObject1);
        break label339;
      }
      if ((paramInt1 != 12) || (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)) {
        break label339;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429566);
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      this.j = true;
      UITools.a(this.jdField_i_of_type_AndroidWidgetTextView, (String)localObject1);
      break label339;
      if (paramInt2 != 43) {
        break;
      }
      a(paramLong, false);
      return;
    }
  }
  
  public void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label220:
    label240:
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
                                    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 3)
                                    {
                                      i = 1;
                                      if (this.u != 2) {
                                        break label240;
                                      }
                                      v(-1);
                                      if (i == 0) {
                                        break label272;
                                      }
                                    }
                                    for (paramView = "0X8007E6B";; paramView = "0X8007E6C")
                                    {
                                      VoiceChangeDataReport.a(paramView, "");
                                      return;
                                      i = 0;
                                      break;
                                      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(this.u) });
                                      break label220;
                                    }
                                    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE_SHELL");
                                  } while (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365375));
                                  paramView = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                                  b(paramView.getString(2131429199), paramView.getString(2131429201));
                                  return;
                                  QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_btn_accept_video");
                                  DataReport.b(NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), 1);
                                  e();
                                  this.jdField_a_of_type_ComTencentAvVideoController.a().as = true;
                                  return;
                                  QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA_SHELL");
                                } while (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365377));
                                if ((VcSystemInfo.f()) && (VcSystemInfo.b()) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1)) {
                                  break;
                                }
                              } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                              DataReport.c(2131365376, 1);
                              return;
                              i = this.jdField_a_of_type_ComTencentAvVideoController.b();
                            } while ((this.jdField_c_of_type_Int != 3000) || (i < jdField_a_of_type_Int));
                            paramView = this.jdField_a_of_type_AndroidContentResResources.getString(2131429166);
                          } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(64, paramView, 3000L, 1);
                          ReportController.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
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
                          DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 1);
                          if ((!SmallScreenUtils.b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
                            a(2131429108, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
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
                        i(false);
                        return;
                        V();
                        return;
                        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER_SHELL");
                      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().p()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
                      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(20, true);
                      return;
                      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER");
                      ReportController.b(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
                      paramView = new Intent();
                      paramView.setAction("tencent.video.v2q.AddContactsToDiscuss");
                      paramView.putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
                      if (this.jdField_a_of_type_ComTencentAvVideoController.a().af) {}
                      for (i = 0;; i = 2)
                      {
                        paramView.putExtra("uiFlag", i);
                        paramView.putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.c());
                        paramView.putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.a().b);
                        paramView.putExtra("pstnInRoomPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.d());
                        paramView.putExtra("selectNotAcceptFlag", false);
                        paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
                        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
                        this.jdField_a_of_type_ComTencentAvVideoController.jdField_g_of_type_Int = 1;
                        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
                          ad();
                        }
                        if (!SmallScreenUtils.b()) {
                          break;
                        }
                        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                        if ((paramView == null) || (!(paramView instanceof AVActivity))) {
                          break;
                        }
                        paramView = (AVActivity)paramView;
                        if (paramView == null) {
                          break;
                        }
                        paramView = paramView.a();
                        if (paramView == null) {
                          break;
                        }
                        paramView.c();
                        return;
                      }
                      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HANG_UP");
                    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
                    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
                      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.e();
                    }
                    VoiceChangeDataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a());
                    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
                      MultiVideoRichActionReportCollection.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                    }
                    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().af))
                    {
                      DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230).setTitle(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429567)).setMessage(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429568)).setNegativeButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429570), new jwv(this)).setPositiveButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429569), new jwu(this)).show();
                      return;
                    }
                    paramView = new Bundle();
                    paramView.putString("uin", String.valueOf(this.jdField_b_of_type_Long));
                    paramView = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5, 0, 0, paramView, null);
                    if (paramView == null)
                    {
                      w();
                      return;
                    }
                    long l1 = paramView.getLong("Origin", 0L);
                    long l2 = paramView.getLong("OriginExtra", 0L);
                    int i = paramView.getInt("SelfRight", -1);
                    if (((l1 & 0x2) == 2L) && (QAVHrMeeting.a(l2) == 0))
                    {
                      j(i);
                      return;
                    }
                    w();
                    return;
                    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE");
                  } while (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1);
                  P();
                } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
                ad();
                return;
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HAND_FREE");
              } while (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1);
              this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
            } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
            ad();
            return;
            QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA");
          } while (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1);
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().r) || (j()))
          {
            AVLog.d(this.jdField_c_of_type_JavaLangString, "click qav_bottombar_camera not invalid .because voiceChoose=" + this.jdField_a_of_type_ComTencentAvVideoController.a().r + ", effectSetting=" + j());
            return;
          }
          M();
        } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
        ad();
        return;
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_titlebar_switchcamera");
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107) });
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
          ad();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = false;
          UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428910));
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = true;
        UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428909));
        return;
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_pstn_multi_time_less_banner");
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      PstnUtils.a(null, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2, 15);
      return;
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_pstn_multi_time_less_banner_close");
    } while (this.jdField_b_of_type_AndroidViewView == null);
    label272:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    String str1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfString, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559815);
    if (i == 1)
    {
      paramArrayOfString = this.jdField_a_of_type_AndroidContentResResources.getString(2131429010);
      if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
        break label273;
      }
      String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
      f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559820);
      str1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.jdField_i_of_type_AndroidWidgetTextView, f);
      str2 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str2, this.jdField_i_of_type_AndroidWidgetTextView, f);
      this.jdField_a_of_type_JavaLangString = (str2 + this.jdField_a_of_type_AndroidContentResResources.getString(2131429007) + str1 + paramArrayOfString);
    }
    for (paramArrayOfString = str1;; paramArrayOfString = str1)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onOtherMemberInvited --> inviterName=" + paramArrayOfString);
      c(Long.valueOf(paramString).longValue(), 82, true, -1);
      return;
      paramArrayOfString = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131429009), new Object[] { Integer.valueOf(i) });
      break;
      label273:
      str1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.jdField_i_of_type_AndroidWidgetTextView, f);
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_AndroidContentResResources.getString(2131429008) + str1 + paramArrayOfString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    long l1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long));
    String str1;
    String str2;
    String str3;
    if (l1 > 0L)
    {
      long l2 = this.jdField_a_of_type_ComTencentAvVideoController.d();
      long l3 = this.jdField_a_of_type_ComTencentAvVideoController.e();
      str1 = String.valueOf(l2);
      str2 = String.valueOf(l1);
      str3 = String.valueOf(paramLong) + "_" + str1 + "_" + String.valueOf(l3) + "_" + str2;
      if (!paramBoolean) {
        break label185;
      }
    }
    label185:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800827C", "0X800827C", i, 0, str2, "", str3, "");
      QLog.e(this.jdField_c_of_type_JavaLangString, 1, "onCreateRoomSuc post conf, GroupID = " + paramLong + ", strRoomId=" + str1);
      return;
    }
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
              DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 1);
              if (SmallScreenUtils.b()) {
                break;
              }
            } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
            a(2131429108, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
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
      if (this.jdField_e_of_type_Boolean)
      {
        if (QAVHrMeeting.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long))))
        {
          a(paramInt1, paramInt2, paramString1, paramString2, paramInt3, paramInt4);
          return;
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
      }
      for (;;)
      {
        float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559815);
        paramString1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.jdField_i_of_type_AndroidWidgetTextView, f);
        paramString1 = paramString1 + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
        break;
        long l = Long.valueOf(paramString1).longValue();
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaUtilArrayList);
        if (paramString1 == null)
        {
          paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131428928);
        }
        else
        {
          paramString2 = paramString1.telInfo.mobile;
          if (paramString2 == null)
          {
            paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131428928);
          }
          else
          {
            paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString2);
            if (paramString1 == null) {
              paramString1 = PstnUtils.a(paramString2, 4);
            }
          }
        }
      }
      paramString1 = localObject;
      if (paramInt1 == this.jdField_i_of_type_Int) {
        paramString1 = paramString2;
      }
    }
  }
  
  void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jwq(this, paramLong), 1000L);
  }
  
  void b(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "processExtraData--> Type = " + this.jdField_a_of_type_ComTencentAvVideoController.a().E + " , IntentRelationType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long + " , isInRoom = " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + " , RoomRelationId = " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ArrayOfLong = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong;
    if (paramIntent != null)
    {
      Object localObject2 = (ArrayList)paramIntent.getExtras().getSerializable("phoneNumbers");
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(PstnUtils.a((String)((Iterator)localObject2).next()));
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a((ArrayList)localObject1);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      Object localObject1 = paramIntent.getStringExtra("PstnLevel");
      if ((localObject1 != null) && ("LEVEL2".equals(localObject1))) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().ag = true;
      }
      localObject1 = paramIntent.getStringExtra("PLACE");
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().s = ((String)localObject1);
      }
      paramIntent = paramIntent.getStringExtra("CREATE_PLACE");
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().t = paramIntent;
      }
    }
  }
  
  public void b(String paramString, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jwx(this, paramString, paramArrayOfString), 1000L);
  }
  
  protected boolean b()
  {
    int i = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, Long.toString(this.jdField_b_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "isFull-->Discuss Num = " + i);
    }
    return i >= 100;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "createOrEnterVideo");
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "createOrEnterVideo --> RelationId is Error . RelationId = " + this.jdField_b_of_type_Long);
      }
    }
    do
    {
      return;
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131428971);
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(str);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_ArrayOfLong == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "createOrEnterVideo --> DiscussionUinList is null");
          }
          i(true);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 0, this.jdField_a_of_type_ArrayOfLong, false);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
    } while (this.jdField_b_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    for (;;)
    {
      return;
      if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k()))
      {
        boolean bool;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) {
          bool = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).b;
        }
        for (int i = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int; (bool) && (i != 0); i = 0)
        {
          DataReport.b(i, paramInt);
          return;
          bool = true;
        }
      }
    }
  }
  
  public void c(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super.c(paramLong, paramInt1, paramBoolean, paramInt2);
    if (((paramInt1 == 0) || (5 == paramInt1)) && (QAVHrMeeting.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long))))) {
      b(paramLong, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt);
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnCreate");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().T)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().o;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString, str);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(str);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "switchToGaudio config :" + this.jdField_e_of_type_JavaLangString + "，connectDeviceName : " + str);
      }
      a();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().n()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().af) && (this.jdField_a_of_type_ComTencentAvVideoController.a().L) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4))
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.c().size();
        if (i <= 0) {
          break label361;
        }
        a(i);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().n()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1))
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().M) && (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null)) {
          this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.d();
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setMultiPstnCallback(true);
        }
        a(0L, 11, true, 0);
      }
      if (((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4)) {
        l(true);
      }
      return;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
      break;
      label361:
      A();
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
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(l, 2, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(l, 2, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setBackgroundColor(-256);
      }
      h("initViewList");
      return;
    }
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidContentResResources != null))
    {
      CharSequence localCharSequence = this.jdField_a_of_type_AndroidContentResResources.getText(2131429563);
      SpannableString localSpannableString = new SpannableString(localCharSequence);
      localSpannableString.setSpan(new jwp(this), 10, 18, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResResources.getColor(2131493307)), 10, 18, 33);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(localSpannableString);
      this.jdField_e_of_type_AndroidWidgetTextView.setMovementMethod(QavLinkMovementMethod.a());
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(localCharSequence);
      this.jdField_e_of_type_AndroidWidgetTextView.setHighlightColor(0);
    }
  }
  
  void j(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getResources().getString(2131438786);
    localObject = DialogUtil.a(localAVActivity, 230).setMessage(str).setNegativeButton(2131438788, new jws(this)).setPositiveButton(2131438787, new jwr(this, (VideoAppInterface)localObject, paramInt));
    if (localAVActivity.isResume()) {
      ((QQCustomDialog)localObject).show();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    super.k();
  }
  
  void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshCameraBtnState");
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int j = jdField_a_of_type_Int;
    if ((!VcSystemInfo.f()) || (!VcSystemInfo.b()))
    {
      L();
      return;
    }
    if ((i >= j) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
    {
      L();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      c(true);
      return;
    }
    c(false);
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jww(this));
    }
    do
    {
      return;
      super.aa();
      i(true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 102);
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
        if (((this.jdField_e_of_type_Int != 90) && (this.jdField_e_of_type_Int != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) || (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int != 1)) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 103);
      }
    } while (((this.jdField_e_of_type_Int != 90) && (this.jdField_e_of_type_Int != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) || (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int != 2));
    ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
  }
  
  void x()
  {
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365375)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365375, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        s(2131365375);
      }
    }
    else
    {
      return;
    }
    t(2131365375);
  }
  
  public void y()
  {
    Object localObject = DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, "购买时长包", "你的多人电话时长包已用完，无法拨打包含手机/固话的多人电话", "取消", "购买", new jxc(this), new jxd(this));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().n())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().o())
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.AddContactsToDiscuss");
        ((Intent)localObject).putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
        ((Intent)localObject).putExtra("uiFlag", 1);
        ((Intent)localObject).putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.c());
        ((Intent)localObject).putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.a().b);
        ((Intent)localObject).putExtra("pstnInRoomPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.d());
        ((Intent)localObject).putExtra("selectNotAcceptFlag", true);
        ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
        this.jdField_a_of_type_ComTencentAvVideoController.jdField_g_of_type_Int = 2;
      }
    }
    else {
      return;
    }
    ((QQCustomDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion
 * JD-Core Version:    0.7.0.1
 */