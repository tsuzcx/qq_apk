package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.screenshare.ScreenShareDialogUtil;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4NewGroupChat
  extends MultiVideoCtrlLayerUIBase
{
  int jdField_a_of_type_Int = 0;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new MultiVideoCtrlLayerUI4NewGroupChat.6(this);
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver = new MultiVideoCtrlLayerUI4NewGroupChat.1(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  boolean jdField_a_of_type_Boolean = true;
  private volatile boolean q = false;
  
  public MultiVideoCtrlLayerUI4NewGroupChat(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
    }
  }
  
  private void T()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.v();
      q();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.5(this), 5000L);
    }
  }
  
  private void U()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    if (QAVHrMeeting.a(this.jdField_a_of_type_ComTencentAvVideoController.a())) {
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentAvUiQavPanel.getContext(), this.jdField_a_of_type_ComTencentAvUiQavPanel.getResources().getString(this.jdField_a_of_type_Int), 1).a();
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1032);
  }
  
  public static int a(String paramString1, VideoAppInterface paramVideoAppInterface, String paramString2, boolean paramBoolean)
  {
    if (QAVGroupConfig.b() <= 0) {
      return 2131695587;
    }
    int i = paramVideoAppInterface.a().c().size();
    if (QAVGroupConfig.c() <= i)
    {
      if (AudioHelper.b())
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("isFull, 通话成员超出上限[");
        paramVideoAppInterface.append(i);
        paramVideoAppInterface.append("]");
        QLog.w(paramString1, 1, paramVideoAppInterface.toString());
      }
      return 2131695585;
    }
    if (AudioHelper.b())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("isGAudioFull, gAudioMemCount[");
      paramVideoAppInterface.append(i);
      paramVideoAppInterface.append("], canAutoInviteMemIntoTroop[");
      paramVideoAppInterface.append(paramBoolean);
      paramVideoAppInterface.append("], wording[");
      paramVideoAppInterface.append(0);
      paramVideoAppInterface.append("]");
      QLog.w(paramString1, 1, paramVideoAppInterface.toString());
    }
    return 0;
  }
  
  private void c(long paramLong, View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramView.X != 2) && (paramView.X != 1))
    {
      paramView = a();
      if ((paramView != null) && (!paramView.isFinishing()))
      {
        if (paramView.isDestroyed()) {
          return;
        }
        String str1 = paramView.getString(2131718564);
        String str2 = paramView.getString(2131718563);
        String str3 = paramView.getString(2131695618);
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
        if (!localSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
        {
          ScreenShareDialogUtil.a(paramView, str1, str2, str3, null, true, 10, new MultiVideoCtrlLayerUI4NewGroupChat.3(this), null).show();
          localSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
          return;
        }
        DialogUtil.a(paramView, 230, str1, str2, null, str3, new MultiVideoCtrlLayerUI4NewGroupChat.4(this), null).show();
      }
      return;
    }
    T();
  }
  
  private void n(long paramLong)
  {
    a(paramLong, 0.0F);
  }
  
  void a()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleExtraData, mStatusType[");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1))
    {
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        return;
      }
      if (QLog.isColorLevel())
      {
        str = this.d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleExterData-->Wrong gaudioStatusType-->type = ");
        localStringBuilder.append(this.jdField_c_of_type_Int);
        localStringBuilder.append(" , relationId = ");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append(" , relationType = ");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      super.a(-1022L, "handleExtraData");
      c();
    }
  }
  
  @TargetApi(11)
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.b();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("drawUI, uin[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], refreshType[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], needRefresh[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], originalType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ab)) {
        TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230740, null, 0, null);
      }
      if (paramLong == this.jdField_c_of_type_Long) {
        super.A();
      }
    }
    else if ((paramInt1 == 1) && (paramLong != this.jdField_c_of_type_Long))
    {
      TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230741, null, 0, null);
    }
    int i;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      boolean bool;
      if ((paramInt1 != 5) && (paramInt1 != 6))
      {
        if ((paramInt1 != 7) && (paramInt1 != 8))
        {
          if ((paramInt1 == 97) || (paramInt1 == 98))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = this.d;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Request remote video failed.Uin = ");
              ((StringBuilder)localObject2).append(paramLong);
              ((StringBuilder)localObject2).append(",type=");
              ((StringBuilder)localObject2).append(paramInt1);
              QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.3", true, true);
            super.a("drawUI.3", l);
            super.y();
          }
        }
        else
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
            bool = super.a(l);
            paramBoolean = bool;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
            {
              super.N();
              paramBoolean = bool;
              if (Build.VERSION.SDK_INT >= 11)
              {
                a(l, 0.0F);
                paramBoolean = bool;
              }
            }
          }
          else
          {
            paramBoolean = true;
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ab) && (paramBoolean))
          {
            if (this.m >= 4) {
              return;
            }
            if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.2", true, true);
              super.a("drawUI.2", l);
              super.a(true, true, true);
            }
            else
            {
              super.h(paramInt1);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("DrawUI:TYPE=");
              ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
              ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            }
          }
        }
      }
      else
      {
        if (paramLong == this.jdField_c_of_type_Long) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramInt1 == 6)
        {
          bool = super.a(l);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
          {
            super.N();
            n(l);
          }
          paramBoolean = bool;
          if (i != 0)
          {
            paramBoolean = bool;
            if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ae)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
              paramBoolean = bool;
            }
          }
        }
        else
        {
          paramBoolean = true;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ab) && (paramBoolean))
        {
          if (this.m >= 4) {
            return;
          }
          if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
          {
            if (i == 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.1", true, true);
              super.a("drawUI.1", l);
              super.a(true, true, true);
            }
          }
          else if (i == 0)
          {
            super.h(paramInt1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
            localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("DrawUI:TYPE=");
            ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
            ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
          }
          else
          {
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
            int j = this.jdField_a_of_type_ComTencentAvVideoController.a().c();
            if (QLog.isColorLevel())
            {
              localObject1 = this.d;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onSelfVideoIn.-->FirstVideo=");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(",index=");
              ((StringBuilder)localObject2).append(i);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            if ((j == -1) || ((i == j) && (i != 0)))
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("DrawUI:TYPE=");
              ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
              ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            }
          }
        }
      }
    }
    else
    {
      i = -1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
      {
        if (paramInt1 == 1)
        {
          b(this.k, 2131695575, String.valueOf(paramLong), null);
          i = 1;
        }
        a_(l, 2131695560);
        if (this.g) {
          e(l, true);
        }
        paramInt1 = i;
      }
      else
      {
        if (paramInt1 == 0)
        {
          e(l, false);
          d(l, null);
          super.A(l);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().ab)
          {
            b(this.k, 2131695567, String.valueOf(paramLong), null);
            paramInt1 = 0;
            break label1389;
          }
        }
        else if (paramInt1 == 1)
        {
          b(this.k, 2131695575, String.valueOf(paramLong), null);
          paramInt1 = 1;
          break label1389;
        }
        paramInt1 = -1;
      }
      label1389:
      a(l, "drawUI", paramInt1, paramLong);
    }
    if (paramInt2 == 42)
    {
      super.a(paramLong, true);
      return;
    }
    if (paramInt2 == 43) {
      super.a(paramLong, false);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)) {
        return;
      }
      switch (paramView.getId())
      {
      default: 
      case 2131695346: 
        i(paramLong, paramView);
        return;
      case 2131695345: 
        k(paramLong, paramView);
        return;
      case 2131695344: 
        v(paramLong);
        return;
      case 2131695341: 
        h(paramLong, paramView);
        return;
      case 2131695339: 
        c(paramLong, paramView);
        return;
      case 2131695337: 
        j(paramLong);
        return;
      case 2131695336: 
        j(paramLong, paramView);
        return;
      case 2131695335: 
        w(paramLong);
        return;
      case 2131695334: 
        b(paramLong, paramView);
        return;
      case 2131695333: 
        e(paramLong, paramView);
        return;
      case 2131373640: 
        paramView = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick, switch_camera, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(paramView, 1, localStringBuilder.toString());
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvVideoController.a().m ^= true;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          int i;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().m) {
            i = 2131692842;
          } else {
            i = 2131692841;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373640, this.jdField_a_of_type_AndroidContentResResources.getString(i));
          return;
        }
        break;
      case 2131373636: 
        g(paramLong, paramView);
        return;
      case 2131373351: 
        d(paramLong, paramView);
        return;
      case 2131373348: 
        QLog.d(this.d, 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
        {
          DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 10);
          if ((!SmallScreenUtils.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
            super.a(2131695493, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
          }
        }
        if (SmallScreenUtils.f())
        {
          paramView = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
          if (paramView != null) {
            paramView.a();
          }
        }
        super.e(false);
        return;
      case 2131373345: 
      case 2131373346: 
        QLog.d(this.d, 1, "onClick QavPanel.ViewID.HANG_UP");
        VoiceChangeDataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
          MultiVideoRichActionReportCollection.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        h(true);
        if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.b, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 100);
          } else {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 101);
          }
          this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new MultiVideoCtrlLayerUI4NewGroupChat.2(this, paramLong));
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
        if (((this.jdField_f_of_type_Int == 90) || (this.jdField_f_of_type_Int == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 1)) {
          ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
        } else if (((this.jdField_f_of_type_Int == 90) || (this.jdField_f_of_type_Int == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 2)) {
          ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
        }
        super.B(paramLong);
        super.e(true);
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.b, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 102);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 103);
        return;
      case 2131373343: 
        QLog.d(this.d, 1, "onClick QavPanel.ViewID.HAND_FREE");
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfJavaLangString;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().E) && (paramView != null)) {
          DataReport.c(true, 10);
        } else if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.d, 2, "DeviceList is null");
          }
        }
        else {
          DataReport.c(false, 10);
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().E))
        {
          QLog.d(this.d, 1, "in mIsPhoneCalling status, could not open Speaker");
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(TraeHelper.jdField_c_of_type_Int);
        return;
      case 2131364477: 
      case 2131365542: 
      case 2131373635: 
        S();
        return;
      case 2131363038: 
      case 2131363044: 
      case 2131370754: 
      case 2131376548: 
        x(paramLong);
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null) {
      if (paramIntent.hasExtra("enableInvite"))
      {
        this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("enableInvite", false);
      }
      else
      {
        paramIntent = new Bundle();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long);
        ((StringBuilder)localObject).append("");
        paramIntent.putString("uin", ((StringBuilder)localObject).toString());
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3, 0, 0, paramIntent, null);
        AudioHelper.a("request", paramIntent);
        AudioHelper.a("response", (Bundle)localObject);
        if (localObject != null) {
          this.jdField_a_of_type_Boolean = ((Bundle)localObject).getBoolean("enableInvite", false);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processExtraData, gaudioStatusType[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long);
      ((StringBuilder)localObject).append("], isInRoom[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append("], mGAudioGroupId[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("], isVideo[");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      ((StringBuilder)localObject).append("], mCanAutoInviteMemIntoTroop[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramIntent, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(paramBoolean, paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if ((paramInt != 24) && (paramInt != 25))
      {
        if (QLog.isColorLevel())
        {
          paramKeyEvent = this.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnKeyDown --> WRONG KeyCode = ");
          localStringBuilder.append(paramInt);
          QLog.d(paramKeyEvent, 2, localStringBuilder.toString());
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        return false;
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 10);
      if (!SmallScreenUtils.f())
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().j)
        {
          super.a(2131695493, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
          return false;
        }
      }
      else if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramKeyEvent = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramKeyEvent != null) && ((paramKeyEvent instanceof AVActivity)))
        {
          paramKeyEvent = (AVActivity)paramKeyEvent;
          if (paramKeyEvent != null)
          {
            paramKeyEvent = paramKeyEvent.a();
            if (paramKeyEvent != null) {
              paramKeyEvent.a();
            }
          }
        }
      }
    }
    return false;
  }
  
  void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMembersInOrOutWording, type[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], id[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], value[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramInt1 == this.k)
    {
      if (paramString1 == null)
      {
        paramString2 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      }
      else
      {
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
        float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297162);
        paramString1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.jdField_e_of_type_AndroidWidgetTextView, f);
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2));
        paramString2 = paramString2.toString();
      }
    }
    else if (paramInt1 != this.l) {
      paramString2 = null;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3009, paramString2);
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    paramView = a();
    if (paramView.a != null)
    {
      if (paramView.a.a()) {
        paramView.a.c(3);
      } else {
        paramView.a.a(0);
      }
      w();
    }
    ChatRoomUtil.a("0X800A8D0");
  }
  
  void c()
  {
    long l = AudioHelper.b();
    Object localObject1 = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("createOrEnterVideo, mRelationId[");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject2).append("], mIntentRelationId[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append("], mStatusType[");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long <= 0L) {
      return;
    }
    a_(l, 2131695503);
    if (this.jdField_c_of_type_Int == 0)
    {
      localObject2 = null;
      Object localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Intent)localObject3).getParcelableArrayListExtra("invitelist");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((ArrayList)localObject3).size() > 0)
          {
            localObject2 = new long[((ArrayList)localObject3).size()];
            int i = 0;
            localObject3 = ((ArrayList)localObject3).iterator();
            for (;;)
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject2[i] = AudioHelper.a(((ResultRecord)((Iterator)localObject3).next()).uin);
              i += 1;
            }
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 0, (long[])localObject2, this.jdField_e_of_type_Boolean);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    if (this.jdField_c_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, null, this.jdField_e_of_type_Boolean);
    }
  }
  
  protected boolean c()
  {
    if (h()) {
      return true;
    }
    String str = this.d;
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("");
    this.jdField_a_of_type_Int = a(str, localVideoAppInterface, localStringBuilder.toString(), this.jdField_a_of_type_Boolean);
    return this.jdField_a_of_type_Int != 0;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    b();
    f(0L, this.jdField_a_of_type_ComTencentAvVideoController.a().b());
    a();
  }
  
  public void d(long paramLong)
  {
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    super.d(paramLong);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "refreshMuteBtnState");
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373351, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.i()) {
        super.k(2131373351);
      } else {
        super.l(2131373351);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.i());
    }
  }
  
  @TargetApi(21)
  public void f(long paramLong, View paramView)
  {
    super.f(paramLong, paramView);
    ScreenShareReportHelper.a("0X800AD8D");
  }
  
  void j(long paramLong)
  {
    if (!b(paramLong))
    {
      QAVGroupConfig.Report.c(false);
      U();
      i(paramLong, 16777215);
    }
    else
    {
      QAVGroupConfig.Report.c(true);
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddMembersToGroup");
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvVideoController.d();
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      long l = localSessionInfo.b();
      int i = localSessionInfo.d();
      ((Intent)localObject).putExtra("room_id", l);
      ((Intent)localObject).putExtra("room_create_time", i);
      ((Intent)localObject).putExtra("uin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
      SeqUtil.a((Intent)localObject, paramLong);
      ((Intent)localObject).putParcelableArrayListExtra("memberlist", this.jdField_a_of_type_ComTencentAvVideoController.d());
      AudioHelper.a("ACTION_ADD_MEMBERS_TO_GROUP", ((Intent)localObject).getExtras(), true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Int = 1;
      if (SmallScreenUtils.f())
      {
        localObject = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        if (localObject != null) {
          ((SmallScreenActivityPlugin)localObject).c();
        }
      }
    }
    l(paramLong, 2131695337);
  }
  
  protected void p()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559744);
  }
  
  public void q()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), 0, 2131561251, 17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.q = true;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.d, 2, localException.getMessage());
      }
    }
  }
  
  public void r()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.q = false;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.d, 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat
 * JD-Core Version:    0.7.0.1
 */