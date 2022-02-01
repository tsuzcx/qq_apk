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
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavUIABTestUtils;
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
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVConfigUtils.ScreenShareSafeTips;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
  boolean a = true;
  ControlUIObserver b = new MultiVideoCtrlLayerUI4NewGroupChat.1(this);
  private QQProgressDialog bx;
  private volatile boolean by = false;
  GAudioUIObserver c = new MultiVideoCtrlLayerUI4NewGroupChat.8(this);
  int d = 0;
  
  public MultiVideoCtrlLayerUI4NewGroupChat(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
    }
  }
  
  public static int a(String paramString1, VideoAppInterface paramVideoAppInterface, String paramString2, boolean paramBoolean)
  {
    if (QAVGroupConfig.c() <= 0) {
      return 2131893346;
    }
    int i = paramVideoAppInterface.b().U().size();
    if (QAVGroupConfig.d() <= i)
    {
      if (AudioHelper.e())
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("isFull, 通话成员超出上限[");
        paramVideoAppInterface.append(i);
        paramVideoAppInterface.append("]");
        QLog.w(paramString1, 1, paramVideoAppInterface.toString());
      }
      return 2131893344;
    }
    if (AudioHelper.e())
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
  
  private void a(int paramInt)
  {
    int j = 0;
    int i;
    if ((paramInt != 5) && (paramInt != 6)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((paramInt == 7) || (paramInt == 8)) {
      j = 1;
    }
    if ((i != 0) || (j != 0)) {
      aA_();
    }
  }
  
  private void au()
  {
    if (this.am != null)
    {
      this.am.aa();
      w();
      this.al.a().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.7(this), 5000L);
    }
  }
  
  private void av()
  {
    if (this.aA == null) {
      return;
    }
    if (QAVHrMeeting.a(this.am.k())) {
      return;
    }
    if (this.d != 0)
    {
      QQToast.makeText(this.aA.getContext(), this.aA.getResources().getString(this.d), 1).show();
      return;
    }
    TipsUtil.a(this.al, 1032);
  }
  
  private void n(long paramLong, View paramView)
  {
    paramView = this.am.k();
    if ((paramView.cj != 2) && (paramView.cj != 1))
    {
      paramView = U();
      if ((paramView != null) && (!paramView.isFinishing()))
      {
        if (paramView.isDestroyed()) {
          return;
        }
        String str1 = paramView.getString(2131916065);
        Object localObject1 = paramView.getString(2131916062);
        Object localObject2 = paramView.getString(2131916063);
        String str4 = paramView.getString(2131916064);
        String str2 = paramView.getString(2131893182);
        String str3 = paramView.getString(2131893168);
        localObject1 = QAVConfigUtils.a((String)localObject1, (String)localObject2, str4);
        localObject1 = ScreenShareDialogUtil.a(paramView, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).a, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).b, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).c);
        localObject2 = PreferenceManager.getDefaultSharedPreferences(this.al.getApp());
        if (!((SharedPreferences)localObject2).contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
        {
          ScreenShareDialogUtil.a(paramView, str1, (CharSequence)localObject1, str3, str2, true, 10, new MultiVideoCtrlLayerUI4NewGroupChat.3(this), new MultiVideoCtrlLayerUI4NewGroupChat.4(this)).show();
          ((SharedPreferences)localObject2).edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
          return;
        }
        DialogUtil.a(paramView, 230, str1, (CharSequence)localObject1, str3, str2, new MultiVideoCtrlLayerUI4NewGroupChat.5(this), new MultiVideoCtrlLayerUI4NewGroupChat.6(this)).setMessageWithoutAutoLink((CharSequence)localObject1).show();
      }
      return;
    }
    f(0L, null);
  }
  
  private void p(long paramLong)
  {
    a(paramLong, 0.0F);
  }
  
  protected boolean B()
  {
    return this.am.k().H;
  }
  
  protected boolean C()
  {
    return QavUIABTestUtils.c(this.al.getCurrentAccountUin());
  }
  
  protected boolean D()
  {
    return QavUIABTestUtils.b(this.al.getCurrentAccountUin());
  }
  
  void a()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleExtraData, mStatusType[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((this.f != 0) && (this.f != 1))
    {
      if (this.f == 2)
      {
        this.aR.b(true);
        this.aR.c(true);
        this.j = this.i;
        return;
      }
      if (QLog.isColorLevel())
      {
        str = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleExterData-->Wrong gaudioStatusType-->type = ");
        localStringBuilder.append(this.f);
        localStringBuilder.append(" , relationId = ");
        localStringBuilder.append(this.i);
        localStringBuilder.append(" , relationType = ");
        localStringBuilder.append(this.h);
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      super.a(-1022L, "handleExtraData");
      d();
    }
  }
  
  @TargetApi(11)
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.c();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
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
    if (this.am == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      if ((this.am != null) && (paramLong != this.k) && (this.am.k().bv)) {
        TraeHelper.a().a(l, this.al, 2131230808, null, 0, null);
      }
      if (paramLong == this.k) {
        super.N();
      }
    }
    else if ((paramInt1 == 1) && (paramLong != this.k))
    {
      TraeHelper.a().a(l, this.al, 2131230809, null, 0, null);
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
              localObject1 = this.X;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Request remote video failed.Uin = ");
              ((StringBuilder)localObject2).append(paramLong);
              ((StringBuilder)localObject2).append(",type=");
              ((StringBuilder)localObject2).append(paramInt1);
              QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            this.am.k().a(l, "drawUI.3", true, true);
            super.a("drawUI.3", l);
            super.L();
          }
        }
        else
        {
          if (paramInt1 == 8)
          {
            localObject1 = new VideoViewInfo();
            ((VideoViewInfo)localObject1).a = paramLong;
            ((VideoViewInfo)localObject1).b = 2;
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.ao.update(null, new Object[] { Integer.valueOf(104), localObject2 });
          }
          if (paramInt1 == 8)
          {
            bool = super.u(l);
            paramBoolean = bool;
            if (this.am.k().q())
            {
              super.ai();
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
          if ((this.am.k().bv) && (paramBoolean))
          {
            if (this.Y >= 4) {
              return;
            }
            if ((!NetworkUtil.isWifiConnected((Context)this.ak.get())) && (this.am.k().B() == -1) && (!this.am.k().bA))
            {
              this.am.k().a(l, "drawUI.2", true, true);
              super.a("drawUI.2", l);
              super.a(true, true, true);
            }
            else
            {
              super.j(paramInt1);
              this.al.a().removeCallbacks(this.U);
              localObject1 = this.U;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("DrawUI:TYPE=");
              ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
              ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
              this.al.a().postDelayed(this.U, 1000L);
            }
          }
        }
      }
      else
      {
        if (paramLong == this.k) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramInt1 == 6)
        {
          bool = super.u(l);
          if (this.am.k().q())
          {
            super.ai();
            p(l);
          }
          paramBoolean = bool;
          if (i != 0)
          {
            paramBoolean = bool;
            if (!this.am.k().by)
            {
              this.am.a(this.k, this.am.k().bi, this.am.k().bk, 1, false);
              paramBoolean = bool;
            }
          }
        }
        else
        {
          paramBoolean = true;
        }
        if ((this.am.k().bv) && (paramBoolean))
        {
          if (this.Y >= 4) {
            return;
          }
          if ((!NetworkUtil.isWifiConnected((Context)this.ak.get())) && (this.am.k().B() == -1) && (!this.am.k().bA))
          {
            if (i == 0)
            {
              this.am.k().a(l, "drawUI.1", true, true);
              super.a("drawUI.1", l);
              super.a(true, true, true);
            }
          }
          else if (i == 0)
          {
            super.j(paramInt1);
            this.al.a().removeCallbacks(this.U);
            localObject1 = this.U;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("DrawUI:TYPE=");
            ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
            ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
            this.al.a().postDelayed(this.U, 1000L);
          }
          else
          {
            i = this.am.k().b(this.k, 1);
            int j = this.am.k().B();
            if (QLog.isColorLevel())
            {
              localObject1 = this.X;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onSelfVideoIn.-->FirstVideo=");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(",index=");
              ((StringBuilder)localObject2).append(i);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            if ((j == -1) || ((i == j) && (i != 0)))
            {
              this.al.a().removeCallbacks(this.U);
              localObject1 = this.U;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("DrawUI:TYPE=");
              ((StringBuilder)localObject2).append(String.valueOf(paramInt1));
              ((MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
              this.al.a().postDelayed(this.U, 1000L);
            }
          }
        }
      }
    }
    else
    {
      i = -1;
      if (this.am.k().i == 9)
      {
        if (paramInt1 == 1)
        {
          b(this.S, 2131893334, String.valueOf(paramLong), null);
          i = 1;
        }
        a_(l, 2131893319);
        if (this.ae) {
          f(l, true);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          f(l, false);
          d(l, null);
          super.G(l);
          if (this.am.k().bv)
          {
            b(this.S, 2131893326, String.valueOf(paramLong), null);
            i = 0;
            break label1389;
          }
        }
        else if (paramInt1 == 1)
        {
          b(this.S, 2131893334, String.valueOf(paramLong), null);
          i = 1;
          break label1389;
        }
        i = -1;
      }
      label1389:
      a(l, "drawUI", i, paramLong);
    }
    if (paramInt2 == 42) {
      super.a(paramLong, true);
    } else if (paramInt2 == 43) {
      super.a(paramLong, false);
    }
    a(paramInt1);
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.ak != null)
    {
      if (!(this.ak.get() instanceof AVActivity)) {
        return;
      }
      switch (paramView.getId())
      {
      default: 
      case 2131893086: 
        l(paramLong, paramView);
        return;
      case 2131893085: 
        A(paramLong);
        return;
      case 2131893082: 
        i(paramLong, paramView);
        return;
      case 2131893080: 
        n(paramLong, paramView);
        return;
      case 2131893078: 
        h(paramLong);
        return;
      case 2131893075: 
        B(paramLong);
        return;
      case 2131893074: 
        b(paramLong, paramView);
        return;
      case 2131893072: 
        y(paramLong);
        return;
      case 2131441323: 
      case 2131893077: 
        k(paramLong, paramView);
        return;
      case 2131441310: 
        paramView = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick, switch_camera, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(paramView, 1, localStringBuilder.toString());
        this.ao.update(null, new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        this.am.k().L ^= true;
        if (this.aA != null)
        {
          int i;
          if (this.am.k().L) {
            i = 2131889950;
          } else {
            i = 2131889949;
          }
          this.aA.a(2131441310, this.aj.getString(i));
          return;
        }
        break;
      case 2131441304: 
        h(paramLong, paramView);
        return;
      case 2131441302: 
        c(paramLong, paramView);
        AVUtil.a("0X800BC0B", AVUtil.c(), 0, "", "", "", "");
        return;
      case 2131441300: 
      case 2131893073: 
        e(paramLong, paramView);
        return;
      case 2131441023: 
        d(paramLong, paramView);
        return;
      case 2131441020: 
        QLog.d(this.X, 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (this.am.k().g == 4)
        {
          DataReport.a(this.am.k().I, this.am.k().H, 10);
          if ((!SmallScreenUtils.g()) && (this.am.k().H)) {
            super.a(2131893252, 1, this.aj.getDimensionPixelSize(2131299920));
          }
        }
        if (SmallScreenUtils.g())
        {
          paramView = ((AVActivity)this.ak.get()).o();
          if (paramView != null) {
            paramView.a();
          }
        }
        super.e(false);
        AVUtil.a("0X800592E", AVUtil.c(), 2, "", "", "", "");
        return;
      case 2131441016: 
      case 2131441017: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.HANG_UP");
        VoiceChangeDataReport.a(this.am.k());
        if (this.am.k().g == 4) {
          MultiVideoRichActionReportCollection.a(this.al);
        }
        i(true);
        if (this.n != null)
        {
          if (this.am.j) {
            this.am.a(this.am.l, this.am.k, 100);
          } else {
            this.am.a(this.h, this.j, 101);
          }
          this.n.a(new MultiVideoCtrlLayerUI4NewGroupChat.2(this, paramLong));
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
        if (((this.l == 90) || (this.l == 270)) && (this.am.k().B() != -1) && (((VideoViewInfo)this.am.k().bi.get(0)).b == 1)) {
          ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
        } else if (((this.l == 90) || (this.l == 270)) && (this.am.k().B() != -1) && (((VideoViewInfo)this.am.k().bi.get(0)).b == 2)) {
          ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
        }
        super.H(paramLong);
        super.e(true);
        if (this.am.j)
        {
          this.am.a(this.am.l, this.am.k, 102);
          return;
        }
        this.am.a(this.h, this.j, 103);
        return;
      case 2131441014: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.HAND_FREE");
        paramView = this.am.k().aF;
        if ((this.am.k().aG) && (paramView != null)) {
          DataReport.c(true, 10);
        } else if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.X, 2, "DeviceList is null");
          }
        }
        else {
          DataReport.c(false, 10);
        }
        if ((this.am.k().q) && (!this.am.k().aG))
        {
          QLog.d(this.X, 1, "in mIsPhoneCalling status, could not open Speaker");
          return;
        }
        this.aQ.a(TraeHelper.l);
        return;
      case 2131440994: 
      case 2131893087: 
        j(paramLong, paramView);
        return;
      case 2131428860: 
      case 2131438060: 
        C(paramLong);
        return;
      case 2131428836: 
      case 2131431769: 
      case 2131441303: 
      case 2131449444: 
        at();
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null) {
      if (paramIntent.hasExtra("enableInvite"))
      {
        this.a = paramIntent.getBooleanExtra("enableInvite", false);
      }
      else
      {
        paramIntent = new Bundle();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.am.k().aN);
        ((StringBuilder)localObject).append("");
        paramIntent.putString("uin", ((StringBuilder)localObject).toString());
        localObject = this.al.a(3, 0, 0, paramIntent, null);
        AudioHelper.a("request", paramIntent);
        AudioHelper.a("response", (Bundle)localObject);
        if (localObject != null) {
          this.a = ((Bundle)localObject).getBoolean("enableInvite", false);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.X;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processExtraData, gaudioStatusType[");
      ((StringBuilder)localObject).append(this.am.k().aP);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(this.am.k().aN);
      ((StringBuilder)localObject).append("], isInRoom[");
      ((StringBuilder)localObject).append(this.am.j);
      ((StringBuilder)localObject).append("], mGAudioGroupId[");
      ((StringBuilder)localObject).append(this.am.k);
      ((StringBuilder)localObject).append("], isVideo[");
      ((StringBuilder)localObject).append(this.H);
      ((StringBuilder)localObject).append("], mCanAutoInviteMemIntoTroop[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramIntent, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    aA_();
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.az;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.aA.b(paramBoolean, paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if ((paramInt != 24) && (paramInt != 25))
      {
        if (QLog.isColorLevel())
        {
          paramKeyEvent = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnKeyDown --> WRONG KeyCode = ");
          localStringBuilder.append(paramInt);
          QLog.d(paramKeyEvent, 2, localStringBuilder.toString());
          return false;
        }
      }
      else
      {
        this.aQ.b();
        return false;
      }
    }
    else if (this.am != null)
    {
      DataReport.b(this.am.k().I, this.am.k().H, 10);
      if (!SmallScreenUtils.g())
      {
        if (this.am.k().H)
        {
          super.a(2131893252, 1, this.aj.getDimensionPixelSize(2131299920));
          return false;
        }
      }
      else if (this.ak != null)
      {
        paramKeyEvent = (Context)this.ak.get();
        if ((paramKeyEvent != null) && ((paramKeyEvent instanceof AVActivity)))
        {
          paramKeyEvent = (AVActivity)paramKeyEvent;
          if (paramKeyEvent != null)
          {
            paramKeyEvent = paramKeyEvent.o();
            if (paramKeyEvent != null) {
              paramKeyEvent.a();
            }
          }
        }
      }
    }
    return false;
  }
  
  public void aA_()
  {
    int i = this.am.k().bi.size();
    int j = 0;
    if (i <= 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.am.k().bM == 4) {
      j = 1;
    }
    boolean bool = ab();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.az.getLayoutParams();
    if ((bool) && ((i != 0) || (j != 0))) {
      i = AIOUtils.b(43.0F, this.az.getResources());
    } else {
      i = AIOUtils.b(20.0F, this.az.getResources());
    }
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.az.setLayoutParams(localLayoutParams);
    }
  }
  
  void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
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
    if (paramInt1 == this.S)
    {
      if (paramString1 == null)
      {
        paramString2 = this.aj.getString(paramInt2);
      }
      else
      {
        paramString1 = this.am.a(paramString1, String.valueOf(this.j), this.h);
        float f = this.aj.getDimensionPixelSize(2131297547);
        paramString1 = UITools.a((Context)this.ak.get(), paramString1, this.as, f);
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(this.aj.getString(paramInt2));
        paramString2 = paramString2.toString();
      }
    }
    else if (paramInt1 != this.T) {
      paramString2 = null;
    }
    TipsUtil.a(this.al, 3009, paramString2);
  }
  
  public void b(long paramLong, View paramView)
  {
    this.aA.a(paramLong, 0, false);
    paramView = U();
    if (paramView.ai != null)
    {
      if (paramView.ai.b()) {
        paramView.ai.c(3);
      } else {
        paramView.ai.a(0);
      }
      H();
    }
    ChatRoomUtil.b("0X800A8D0");
  }
  
  void d()
  {
    long l = AudioHelper.c();
    Object localObject1 = this.X;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("createOrEnterVideo, mRelationId[");
    ((StringBuilder)localObject2).append(this.j);
    ((StringBuilder)localObject2).append("], mIntentRelationId[");
    ((StringBuilder)localObject2).append(this.i);
    ((StringBuilder)localObject2).append("], mStatusType[");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    this.j = this.i;
    if (this.j <= 0L) {
      return;
    }
    a_(l, 2131893262);
    if (this.f == 0)
    {
      localObject2 = null;
      Object localObject3 = P();
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
              localObject2[i] = AudioHelper.c(((ResultRecord)((Iterator)localObject3).next()).uin);
              i += 1;
            }
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.am.k().aO;
      }
      this.am.a(this.h, this.j, 0, (long[])localObject2, this.H);
      this.D = true;
      return;
    }
    if (this.f == 1) {
      this.am.a(l, this.h, this.j, null, this.H);
    }
  }
  
  public void d(long paramLong)
  {
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.al.b(this.c);
    this.al.b(this.b);
    super.d(paramLong);
  }
  
  public void e()
  {
    super.e();
    this.al.a(this.c);
    this.al.a(this.b);
    c();
    g(0L, this.am.k().b());
    a();
  }
  
  @TargetApi(21)
  public void f(long paramLong, View paramView)
  {
    super.f(paramLong, paramView);
    ScreenShareReportHelper.b("0X800AD8D");
  }
  
  void h(long paramLong)
  {
    if (!Q(paramLong))
    {
      QAVGroupConfig.Report.c(false);
      av();
      f(paramLong, 16777215);
    }
    else
    {
      QAVGroupConfig.Report.c(true);
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddMembersToGroup");
      ((Intent)localObject).setPackage(this.al.getApplication().getPackageName());
      this.am.ap();
      SessionInfo localSessionInfo = this.am.k();
      long l = localSessionInfo.D();
      int i = localSessionInfo.E();
      ((Intent)localObject).putExtra("room_id", l);
      ((Intent)localObject).putExtra("room_create_time", i);
      ((Intent)localObject).putExtra("uin", Long.toString(this.am.k));
      SeqUtil.a((Intent)localObject, paramLong);
      ((Intent)localObject).putParcelableArrayListExtra("memberlist", this.am.V());
      AudioHelper.a("ACTION_ADD_MEMBERS_TO_GROUP", ((Intent)localObject).getExtras(), true);
      this.al.getApp().sendBroadcast((Intent)localObject);
      this.am.w = 1;
      if (SmallScreenUtils.g())
      {
        localObject = ((AVActivity)this.ak.get()).o();
        if (localObject != null) {
          ((SmallScreenActivityPlugin)localObject).d();
        }
      }
    }
    i(paramLong, 2131893078);
  }
  
  public void i(int paramInt)
  {
    aA_();
    super.i(paramInt);
  }
  
  public boolean o(long paramLong)
  {
    if (D()) {
      return Y(paramLong);
    }
    return Z(paramLong);
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "refreshMuteBtnState");
    }
    if ((!this.aA.f(2131441023)) && (this.am != null))
    {
      this.aA.setViewEnable(2131441023, true);
      if (this.am.H()) {
        super.m(2131441023);
      } else {
        super.n(2131441023);
      }
      this.aA.b(this.am.H());
    }
  }
  
  protected boolean t()
  {
    if (V()) {
      return true;
    }
    String str = this.X;
    VideoAppInterface localVideoAppInterface = this.al;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append("");
    this.d = a(str, localVideoAppInterface, localStringBuilder.toString(), this.a);
    return this.d != 0;
  }
  
  protected void u()
  {
    this.aA.a(LayoutDef.b(D()));
  }
  
  public void w()
  {
    try
    {
      if (this.bx == null)
      {
        this.bx = new QQProgressDialog(U(), 0, 2131627607, 17);
        this.bx.c(false);
        this.bx.a("");
      }
      this.bx.show();
      this.by = true;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.X, 2, localException.getMessage());
      }
    }
  }
  
  public void z()
  {
    try
    {
      if ((this.bx != null) && (this.bx.isShowing()))
      {
        this.bx.dismiss();
        this.by = false;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.X, 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat
 * JD-Core Version:    0.7.0.1
 */