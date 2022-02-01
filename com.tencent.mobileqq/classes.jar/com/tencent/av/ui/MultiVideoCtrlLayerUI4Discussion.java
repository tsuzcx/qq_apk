package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
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
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4Discussion
  extends MultiVideoCtrlLayerUIBase
{
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new MultiVideoCtrlLayerUI4Discussion.6(this);
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public MultiVideoCtrlLayerUI4Discussion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
    }
  }
  
  private static void b(String paramString1, VideoAppInterface paramVideoAppInterface, String paramString2, int paramInt, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString2);
    localBundle.putInt("uinType", paramInt);
    localBundle.putString("wording", paramString3);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyWriteGrayMsg, peerUin[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], wording[");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("]");
      QLog.w(paramString1, 1, localStringBuilder.toString());
      paramVideoAppInterface.a(1, 0, 0, localBundle, null);
      return;
    }
    catch (Exception paramVideoAppInterface)
    {
      paramString2 = new StringBuilder();
      paramString2.append("notifyWriteGrayMsg, Exception[");
      paramString2.append(paramVideoAppInterface.getMessage());
      paramString2.append("]");
      QLog.w(paramString1, 1, paramString2.toString());
    }
  }
  
  void a()
  {
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
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
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
      a(-1022L, "handleExtraData");
      c();
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getResources().getString(2131693233);
    localObject = DialogUtil.a(localAVActivity, 230).setMessage(str).setNegativeButton(2131693234, new MultiVideoCtrlLayerUI4Discussion.9(this)).setPositiveButton(2131693235, new MultiVideoCtrlLayerUI4Discussion.8(this, (VideoAppInterface)localObject, paramInt));
    if (localAVActivity.isResume()) {
      ((QQCustomDialog)localObject).show();
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.1(this, paramInt2, paramString1), 1000L);
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.b();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
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
      if ((paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ab)) {
        TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230740, null, 0, null);
      }
      if ((paramLong != this.jdField_a_of_type_ComTencentAvVideoController.a().g) && (paramLong != this.jdField_c_of_type_Long)) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
      }
      if (paramLong == this.jdField_c_of_type_Long) {
        A();
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramLong != this.jdField_c_of_type_Long) {
        TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230741, null, 0, null);
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
    }
    int i = -1;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if (paramInt1 == 68)
      {
        float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297162);
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
        localObject2 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.jdField_e_of_type_AndroidWidgetTextView, f);
        if (this.jdField_g_of_type_Int == 1) {
          localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695514);
        } else {
          localObject1 = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131695513), new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) });
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131695512));
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        b(this.l, 0, null, (String)localObject1);
      }
      else if (paramInt1 == 82)
      {
        b(this.l, 0, null, this.jdField_a_of_type_JavaLangString);
      }
      else
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
                localObject1 = this.jdField_d_of_type_JavaLangString;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Request remote video failed.Uin = ");
                ((StringBuilder)localObject2).append(paramLong);
                ((StringBuilder)localObject2).append(",type=");
                ((StringBuilder)localObject2).append(paramInt1);
                QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.3", true, true);
              a("drawUI.3", l);
              y();
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
              bool = a(l);
              paramBoolean = bool;
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
              {
                N();
                a(l, 0.0F);
                paramBoolean = bool;
              }
            }
            else
            {
              ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
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
                a("drawUI.2", l);
                a(true, true, true);
              }
              else
              {
                h(paramInt1);
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
                localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("DrawUI:TYPE=");
                ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
                ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
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
            bool = a(l);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
            {
              N();
              a(l, 0.0F);
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
                a("drawUI.1", l);
                a(true, true, true);
              }
            }
            else if (i == 0)
            {
              h(paramInt1);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              localObject1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("DrawUI:TYPE=");
              ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
              ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            }
            else
            {
              i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
              int j = this.jdField_a_of_type_ComTencentAvVideoController.a().c();
              if (QLog.isColorLevel())
              {
                localObject1 = this.jdField_d_of_type_JavaLangString;
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
                ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
              }
            }
          }
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
      {
        if (paramInt1 == 1)
        {
          b(this.k, 2131695542, String.valueOf(paramLong), null);
          i = 1;
        }
        a_(l, 2131695560);
        if (this.jdField_g_of_type_Boolean) {
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
          A(l);
          if ((paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ab))
          {
            b(this.k, 2131695491, String.valueOf(paramLong), null);
            paramInt1 = 0;
            break label1659;
          }
        }
        else if (paramInt1 == 1)
        {
          b(this.k, 2131695542, String.valueOf(paramLong), null);
          paramInt1 = 1;
          break label1659;
        }
        paramInt1 = -1;
      }
      label1659:
      a(l, "drawUI", paramInt1, paramLong);
    }
    if (paramInt2 == 42)
    {
      a(paramLong, true);
      return;
    }
    if (paramInt2 == 43) {
      a(paramLong, false);
    }
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    super.a(paramLong, paramInt1, paramBoolean, paramInt2, paramInt3);
    if (((paramInt1 == 0) || (5 == paramInt1)) && (QAVHrMeeting.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long))))) {
      b(paramLong, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)) {
        return;
      }
      int i;
      switch (paramView.getId())
      {
      default: 
      case 2131695346: 
        i(paramLong, paramView);
        return;
      case 2131695344: 
        v(paramLong);
        return;
      case 2131695341: 
        h(paramLong, paramView);
        return;
      case 2131695337: 
        n(paramLong);
        return;
      case 2131695336: 
        j(paramLong, paramView);
        return;
      case 2131695335: 
        w(paramLong);
        return;
      case 2131695333: 
        e(paramLong, paramView);
        return;
      case 2131373640: 
        paramView = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick, switch_camera, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(paramView, 1, localStringBuilder.toString());
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvVideoController.a().m ^= true;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
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
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
        {
          DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 1);
          if ((!SmallScreenUtils.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
            a(2131695493, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
          }
        }
        if (SmallScreenUtils.f())
        {
          paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((paramView instanceof AVActivity))
          {
            paramView = ((AVActivity)paramView).a();
            if (paramView != null) {
              paramView.a();
            }
          }
        }
        e(false);
        return;
      case 2131373345: 
      case 2131373346: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
        VoiceChangeDataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
          MultiVideoRichActionReportCollection.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().T))
        {
          DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230).setTitle(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695629)).setMessage(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695627)).setNegativeButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695626), new MultiVideoCtrlLayerUI4Discussion.3(this)).setPositiveButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695628), new MultiVideoCtrlLayerUI4Discussion.2(this, paramLong)).show();
          return;
        }
        paramView = new Bundle();
        paramView.putString("uin", String.valueOf(this.jdField_b_of_type_Long));
        paramView = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5, 0, 0, paramView, null);
        if (paramView == null)
        {
          j(paramLong);
          return;
        }
        long l1 = paramView.getLong("Origin", 0L);
        long l2 = paramView.getLong("OriginExtra", 0L);
        i = paramView.getInt("SelfRight", -1);
        if (((l1 & 0x2) == 2L) && (QAVHrMeeting.a(l2) == 0))
        {
          a(i);
          return;
        }
        j(paramLong);
        return;
      case 2131373343: 
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().E))
        {
          QLog.d(this.jdField_d_of_type_JavaLangString, 1, "in mIsPhoneCalling status, could not open Speaker");
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(TraeHelper.jdField_c_of_type_Int);
        return;
      case 2131370754: 
      case 2131376548: 
        x(paramLong);
        return;
      case 2131364477: 
      case 2131365542: 
      case 2131373635: 
        S();
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processExtraData--> Type = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      localStringBuilder.append(" , relationId = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long);
      localStringBuilder.append(" , isInRoom = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean);
      localStringBuilder.append(" , RoomRelationId = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
  }
  
  void a(String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfString, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297162);
    if (i == 1) {
      paramArrayOfString = this.jdField_a_of_type_AndroidContentResResources.getString(2131695514);
    } else {
      paramArrayOfString = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131695513), new Object[] { Integer.valueOf(i) });
    }
    if (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
      f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297164);
      str = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str, this.jdField_e_of_type_AndroidWidgetTextView, f);
      localObject = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject, this.jdField_e_of_type_AndroidWidgetTextView, f);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131695511));
      localStringBuilder.append(str);
      localStringBuilder.append(paramArrayOfString);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      paramArrayOfString = str;
    }
    else
    {
      str = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str, this.jdField_e_of_type_AndroidWidgetTextView, f);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentResResources.getString(2131695512));
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramArrayOfString);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      paramArrayOfString = str;
    }
    str = this.jdField_d_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onOtherMemberInvited, inviterUin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], invitedName[");
    ((StringBuilder)localObject).append(paramArrayOfString);
    ((StringBuilder)localObject).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
    a(Long.valueOf(paramString).longValue(), 82, true, -1, 0);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt);
  }
  
  void a(boolean paramBoolean, long paramLong)
  {
    long l1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long));
    if (l1 > 0L)
    {
      long l2 = this.jdField_a_of_type_ComTencentAvVideoController.d();
      long l3 = this.jdField_a_of_type_ComTencentAvVideoController.e();
      String str1 = String.valueOf(l2);
      String str2 = String.valueOf(l1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(String.valueOf(l3));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).toString();
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800827C", "0X800827C", i, 0, str2, "", (String)localObject, "");
      str2 = this.jdField_d_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreateRoomSuc post conf, GroupID = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", strRoomId=");
      ((StringBuilder)localObject).append(str1);
      QLog.e(str2, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if ((paramInt != 24) && (paramInt != 25))
      {
        if (QLog.isColorLevel())
        {
          paramKeyEvent = this.jdField_d_of_type_JavaLangString;
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
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 1);
      if (!SmallScreenUtils.f())
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().j)
        {
          a(2131695493, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
          return false;
        }
      }
      else if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramKeyEvent = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramKeyEvent != null) && ((paramKeyEvent instanceof AVActivity)))
        {
          paramKeyEvent = ((AVActivity)paramKeyEvent).a();
          if (paramKeyEvent != null) {
            paramKeyEvent.a();
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
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMembersInOrOutWording --> Type = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , Id = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" , Uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" , value = ");
      localStringBuilder.append(paramString2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt1 == this.k)
    {
      if (paramString1 == null)
      {
        paramString2 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      }
      else
      {
        if (this.jdField_d_of_type_Boolean)
        {
          if (QAVHrMeeting.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long))))
          {
            a(paramInt1, paramInt2, paramString1, paramString2);
            return;
          }
          paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
        }
        else
        {
          long l = Long.valueOf(paramString1).longValue();
          paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l);
          if (paramString1 == null)
          {
            paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131693109);
          }
          else
          {
            paramString2 = paramString1.telInfo.mobile;
            if (paramString2 == null)
            {
              paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131693109);
            }
            else
            {
              paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString2);
              if (paramString1 == null)
              {
                paramString2 = PstnUtils.a(paramString2, 4);
                paramString1 = paramString2;
                if (paramString2 == null) {
                  paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131693109);
                }
              }
            }
          }
        }
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
  
  public void b(long paramLong, int paramInt)
  {
    super.b(paramLong, paramInt);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().q()) {
        return;
      }
      boolean bool = true;
      int j = this.jdField_a_of_type_ComTencentAvVideoController.a().c.size();
      int i = 0;
      if (j > 0)
      {
        bool = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).b;
        i = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int;
      }
      if (bool)
      {
        if (i == 0) {
          return;
        }
        DataReport.b(i, paramInt);
      }
    }
  }
  
  void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.7(this, paramLong), 1000L);
  }
  
  void b(String paramString, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.5(this, paramString, paramArrayOfString), 1000L);
  }
  
  void c()
  {
    long l = AudioHelper.b();
    Object localObject1 = this.jdField_d_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("createOrEnterVideo, mRelationId[");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject2).append("], mIntentRelationId[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
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
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a;
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
    int i = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, Long.toString(this.jdField_b_of_type_Long));
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFull-->Discuss Num = ");
      localStringBuilder.append(i);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return i >= 100;
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnCreate");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    b();
    f(0L, this.jdField_a_of_type_ComTencentAvVideoController.a().b());
    a();
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    super.d(paramLong);
  }
  
  void e()
  {
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373351, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.i()) {
        k(2131373351);
      } else {
        l(2131373351);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.i());
    }
  }
  
  public void f(long paramLong, View paramView)
  {
    l(paramLong, 2131695339);
  }
  
  void j(long paramLong)
  {
    h(true);
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.b, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 100);
      } else {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 101);
      }
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new MultiVideoCtrlLayerUI4Discussion.4(this, paramLong));
      return;
    }
    super.B(paramLong);
    e(true);
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.b, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 102);
    } else {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 103);
    }
    ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
    if (((this.jdField_f_of_type_Int == 90) || (this.jdField_f_of_type_Int == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 1))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
      return;
    }
    if (((this.jdField_f_of_type_Int == 90) || (this.jdField_f_of_type_Int == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 2)) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
    }
  }
  
  void n(long paramLong)
  {
    if (c())
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1032, 2131695585);
    }
    else
    {
      ReportController.b(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddContactsToDiscuss");
      ((Intent)localObject).putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
      ((Intent)localObject).putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.f());
      ((Intent)localObject).putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.a().b);
      ((Intent)localObject).putExtra("selectNotAcceptFlag", false);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Int = 1;
      if (SmallScreenUtils.f())
      {
        localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject instanceof AVActivity))
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).c();
          }
        }
      }
    }
    l(paramLong, 2131695337);
  }
  
  protected void p()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion
 * JD-Core Version:    0.7.0.1
 */