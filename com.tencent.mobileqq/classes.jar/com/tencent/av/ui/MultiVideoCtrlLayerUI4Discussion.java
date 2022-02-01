package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
  Map<String, String> a = new HashMap();
  boolean b = false;
  GAudioUIObserver c = new MultiVideoCtrlLayerUI4Discussion.6(this);
  
  public MultiVideoCtrlLayerUI4Discussion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
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
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
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
      a(-1022L, "handleExtraData");
      d();
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = this.al;
    AVActivity localAVActivity = (AVActivity)this.ak.get();
    String str = this.al.getApplication().getResources().getString(2131890773);
    localObject = DialogUtil.a(localAVActivity, 230).setMessage(str).setNegativeButton(2131890774, new MultiVideoCtrlLayerUI4Discussion.9(this)).setPositiveButton(2131890775, new MultiVideoCtrlLayerUI4Discussion.8(this, (VideoAppInterface)localObject, paramInt));
    if (localAVActivity.isResume()) {
      ((QQCustomDialog)localObject).show();
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.al.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.1(this, paramInt2, paramString1), 1000L);
  }
  
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
      if ((paramLong != this.k) && (this.am.k().bv)) {
        TraeHelper.a().a(l, this.al, 2131230808, null, 0, null);
      }
      if ((paramLong != this.am.k().aX) && (paramLong != this.k)) {
        TipsUtil.b(this.al, 1047);
      }
      if (paramLong == this.k) {
        N();
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramLong != this.k) {
        TraeHelper.a().a(l, this.al, 2131230809, null, 0, null);
      }
      TipsUtil.b(this.al, 1047);
    }
    int i = -1;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if (paramInt1 == 68)
      {
        float f = this.aj.getDimensionPixelSize(2131297547);
        localObject1 = this.am.a(String.valueOf(paramLong), String.valueOf(this.j), this.h);
        localObject2 = UITools.a((Context)this.ak.get(), (String)localObject1, this.as, f);
        if (this.m == 1) {
          localObject1 = this.aj.getString(2131893273);
        } else {
          localObject1 = String.format(this.aj.getString(2131893272), new Object[] { Integer.valueOf(this.m) });
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.aj.getString(2131893271));
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        b(this.T, 0, null, (String)localObject1);
      }
      else if (paramInt1 == 82)
      {
        b(this.T, 0, null, this.E);
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
                localObject1 = this.X;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Request remote video failed.Uin = ");
                ((StringBuilder)localObject2).append(paramLong);
                ((StringBuilder)localObject2).append(",type=");
                ((StringBuilder)localObject2).append(paramInt1);
                QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              this.am.k().a(l, "drawUI.3", true, true);
              a("drawUI.3", l);
              L();
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
              bool = u(l);
              paramBoolean = bool;
              if (this.am.k().q())
              {
                ai();
                a(l, 0.0F);
                paramBoolean = bool;
              }
            }
            else
            {
              ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
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
                a("drawUI.2", l);
                a(true, true, true);
              }
              else
              {
                j(paramInt1);
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
            bool = u(l);
            if (this.am.k().q())
            {
              ai();
              a(l, 0.0F);
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
                a("drawUI.1", l);
                a(true, true, true);
              }
            }
            else if (i == 0)
            {
              j(paramInt1);
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
    }
    else
    {
      if (this.am.k().i == 9)
      {
        if (paramInt1 == 1)
        {
          b(this.S, 2131893301, String.valueOf(paramLong), null);
          i = 1;
        }
        a_(l, 2131893319);
        if (this.ae) {
          f(l, true);
        }
        paramInt1 = i;
      }
      else
      {
        if (paramInt1 == 0)
        {
          f(l, false);
          d(l, null);
          G(l);
          if ((paramLong != this.k) && (this.am.k().bv))
          {
            b(this.S, 2131893250, String.valueOf(paramLong), null);
            paramInt1 = 0;
            break label1661;
          }
        }
        else if (paramInt1 == 1)
        {
          b(this.S, 2131893301, String.valueOf(paramLong), null);
          paramInt1 = 1;
          break label1661;
        }
        paramInt1 = -1;
      }
      label1661:
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
    if (((paramInt1 == 0) || (5 == paramInt1)) && (QAVHrMeeting.b(this.al.f(String.valueOf(this.j))))) {
      b(paramLong, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.ak != null)
    {
      if (!(this.ak.get() instanceof AVActivity)) {
        return;
      }
      int i;
      switch (paramView.getId())
      {
      default: 
      case 2131893087: 
        j(paramLong, paramView);
        return;
      case 2131893085: 
        A(paramLong);
        return;
      case 2131893082: 
        i(paramLong, paramView);
        return;
      case 2131893078: 
        p(paramLong);
        return;
      case 2131893077: 
        k(paramLong, paramView);
        return;
      case 2131893075: 
        B(paramLong);
        return;
      case 2131893073: 
        e(paramLong, paramView);
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
        return;
      case 2131441023: 
        d(paramLong, paramView);
        return;
      case 2131441020: 
        QLog.d(this.X, 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (this.am.k().g == 4)
        {
          DataReport.a(this.am.k().I, this.am.k().H, 1);
          if ((!SmallScreenUtils.g()) && (this.am.k().H)) {
            a(2131893252, 1, this.aj.getDimensionPixelSize(2131299920));
          }
        }
        if (SmallScreenUtils.g())
        {
          paramView = (Context)this.ak.get();
          if ((paramView instanceof AVActivity))
          {
            paramView = ((AVActivity)paramView).o();
            if (paramView != null) {
              paramView.a();
            }
          }
        }
        e(false);
        return;
      case 2131441016: 
      case 2131441017: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.HANG_UP");
        VoiceChangeDataReport.a(this.am.k());
        if (this.am.k().g == 4) {
          MultiVideoRichActionReportCollection.a(this.al);
        }
        if ((this.am.k().bm.size() > 0) && (this.am.k().bh))
        {
          DialogUtil.a((Context)this.ak.get(), 230).setTitle(((Context)this.ak.get()).getString(2131893388)).setMessage(((Context)this.ak.get()).getString(2131893386)).setNegativeButton(((Context)this.ak.get()).getString(2131893385), new MultiVideoCtrlLayerUI4Discussion.3(this)).setPositiveButton(((Context)this.ak.get()).getString(2131893387), new MultiVideoCtrlLayerUI4Discussion.2(this, paramLong)).show();
          return;
        }
        paramView = new Bundle();
        paramView.putString("uin", String.valueOf(this.j));
        paramView = this.al.a(5, 0, 0, paramView, null);
        if (paramView == null)
        {
          h(paramLong);
          return;
        }
        long l1 = paramView.getLong("Origin", 0L);
        long l2 = paramView.getLong("OriginExtra", 0L);
        i = paramView.getInt("SelfRight", -1);
        if (((l1 & 0x2) == 2L) && (QAVHrMeeting.c(l2) == 0))
        {
          a(i);
          return;
        }
        h(paramLong);
        return;
      case 2131441014: 
        if ((this.am.k().q) && (!this.am.k().aG))
        {
          QLog.d(this.X, 1, "in mIsPhoneCalling status, could not open Speaker");
          return;
        }
        this.aQ.a(TraeHelper.l);
        return;
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
    if (QLog.isColorLevel())
    {
      paramIntent = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processExtraData--> Type = ");
      localStringBuilder.append(this.am.k().aP);
      localStringBuilder.append(" , relationId = ");
      localStringBuilder.append(this.am.k().aN);
      localStringBuilder.append(" , isInRoom = ");
      localStringBuilder.append(this.am.j);
      localStringBuilder.append(" , RoomRelationId = ");
      localStringBuilder.append(this.am.k);
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
    String str = this.am.a(paramArrayOfString, String.valueOf(this.j), this.h);
    float f = this.aj.getDimensionPixelSize(2131297547);
    if (i == 1) {
      paramArrayOfString = this.aj.getString(2131893273);
    } else {
      paramArrayOfString = String.format(this.aj.getString(2131893272), new Object[] { Integer.valueOf(i) });
    }
    if (!paramString.equals(this.al.getCurrentAccountUin()))
    {
      localObject = this.am.a(paramString, String.valueOf(this.j), this.h);
      f = this.aj.getDimensionPixelSize(2131297549);
      str = UITools.a((Context)this.ak.get(), str, this.as, f);
      localObject = UITools.a((Context)this.ak.get(), (String)localObject, this.as, f);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.aj.getString(2131893270));
      localStringBuilder.append(str);
      localStringBuilder.append(paramArrayOfString);
      this.E = localStringBuilder.toString();
      paramArrayOfString = str;
    }
    else
    {
      str = UITools.a((Context)this.ak.get(), str, this.as, f);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.aj.getString(2131893271));
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramArrayOfString);
      this.E = ((StringBuilder)localObject).toString();
      paramArrayOfString = str;
    }
    str = this.X;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onOtherMemberInvited, inviterUin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], invitedName[");
    ((StringBuilder)localObject).append(paramArrayOfString);
    ((StringBuilder)localObject).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
    a(Long.valueOf(paramString).longValue(), 82, true, -1, 0);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.az.setVisibility(8);
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.aA.a(paramBoolean, paramInt);
  }
  
  void a(boolean paramBoolean, long paramLong)
  {
    long l1 = this.al.f(String.valueOf(this.j));
    if (l1 > 0L)
    {
      long l2 = this.am.ap();
      long l3 = this.am.aq();
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
      str2 = this.X;
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
      DataReport.b(this.am.k().I, this.am.k().H, 1);
      if (!SmallScreenUtils.g())
      {
        if (this.am.k().H)
        {
          a(2131893252, 1, this.aj.getDimensionPixelSize(2131299920));
          return false;
        }
      }
      else if (this.ak != null)
      {
        paramKeyEvent = (Context)this.ak.get();
        if ((paramKeyEvent != null) && ((paramKeyEvent instanceof AVActivity)))
        {
          paramKeyEvent = ((AVActivity)paramKeyEvent).o();
          if (paramKeyEvent != null) {
            paramKeyEvent.a();
          }
        }
      }
    }
    return false;
  }
  
  public void aB_()
  {
    TextView localTextView1 = (TextView)this.aA.e(2131428836);
    TextView localTextView2 = (TextView)this.aA.e(2131449444);
    localTextView1.setVisibility(0);
    localTextView2.setVisibility(8);
  }
  
  void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
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
    if (paramInt1 == this.S)
    {
      if (paramString1 == null)
      {
        paramString2 = this.aj.getString(paramInt2);
      }
      else
      {
        if (this.G)
        {
          if (QAVHrMeeting.b(this.al.f(String.valueOf(this.j))))
          {
            a(paramInt1, paramInt2, paramString1, paramString2);
            return;
          }
          paramString1 = this.am.a(paramString1, String.valueOf(this.j), this.h);
        }
        else
        {
          long l = Long.valueOf(paramString1).longValue();
          paramString1 = this.am.k().a(l);
          if (paramString1 == null)
          {
            paramString1 = this.aj.getString(2131890648);
          }
          else
          {
            paramString2 = paramString1.telInfo.mobile;
            if (paramString2 == null)
            {
              paramString1 = this.aj.getString(2131890648);
            }
            else
            {
              paramString1 = this.am.d(paramString2);
              if (paramString1 == null)
              {
                paramString2 = PstnUtils.a(paramString2, 4);
                paramString1 = paramString2;
                if (paramString2 == null) {
                  paramString1 = this.aj.getString(2131890648);
                }
              }
            }
          }
        }
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
  
  public void b(long paramLong, int paramInt)
  {
    super.b(paramLong, paramInt);
    if (this.am != null)
    {
      if (this.am.k().q()) {
        return;
      }
      boolean bool = true;
      int j = this.am.k().bi.size();
      int i = 0;
      if (j > 0)
      {
        bool = ((VideoViewInfo)this.am.k().bi.get(0)).d;
        i = ((VideoViewInfo)this.am.k().bi.get(0)).b;
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
    this.al.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.7(this, paramLong), 1000L);
  }
  
  void b(String paramString, String[] paramArrayOfString)
  {
    this.al.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.5(this, paramString, paramArrayOfString), 1000L);
  }
  
  protected boolean b_(long paramLong)
  {
    boolean bool = X(paramLong);
    c(paramLong, bool, 0);
    return bool;
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
    this.b = true;
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.al.b(this.c);
    super.d(paramLong);
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "OnCreate");
    }
    this.b = false;
    this.al.a(this.c);
    c();
    g(0L, this.am.k().b());
    a();
  }
  
  public void f(long paramLong, View paramView)
  {
    i(paramLong, 2131893080);
  }
  
  void h(long paramLong)
  {
    i(true);
    if (this.n != null)
    {
      if (this.am.j) {
        this.am.a(this.am.l, this.am.k, 100);
      } else {
        this.am.a(this.h, this.j, 101);
      }
      this.n.a(new MultiVideoCtrlLayerUI4Discussion.4(this, paramLong));
      return;
    }
    super.H(paramLong);
    e(true);
    if (this.am.j) {
      this.am.a(this.am.l, this.am.k, 102);
    } else {
      this.am.a(this.h, this.j, 103);
    }
    ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
    if (((this.l == 90) || (this.l == 270)) && (this.am.k().B() != -1) && (((VideoViewInfo)this.am.k().bi.get(0)).b == 1))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
      return;
    }
    if (((this.l == 90) || (this.l == 270)) && (this.am.k().B() != -1) && (((VideoViewInfo)this.am.k().bi.get(0)).b == 2)) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
    }
  }
  
  void p(long paramLong)
  {
    if (t())
    {
      TipsUtil.a(this.al, 1032, 2131893344);
    }
    else
    {
      ReportController.b(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddContactsToDiscuss");
      ((Intent)localObject).putExtra("discussUin", Long.toString(this.am.k));
      ((Intent)localObject).putExtra("notAcceptUserList", this.am.al());
      ((Intent)localObject).putExtra("notAcceptPhoneList", this.am.k().av);
      ((Intent)localObject).putExtra("selectNotAcceptFlag", false);
      ((Intent)localObject).setPackage(this.al.getApplication().getPackageName());
      this.al.getApp().sendBroadcast((Intent)localObject);
      this.am.w = 1;
      if (SmallScreenUtils.g())
      {
        localObject = (Context)this.ak.get();
        if ((localObject instanceof AVActivity))
        {
          localObject = ((AVActivity)localObject).o();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).d();
          }
        }
      }
    }
    i(paramLong, 2131893078);
  }
  
  void s()
  {
    if ((!this.aA.f(2131441023)) && (this.am != null))
    {
      this.aA.setViewEnable(2131441023, true);
      if (this.am.H()) {
        m(2131441023);
      } else {
        n(2131441023);
      }
      this.aA.b(this.am.H());
    }
  }
  
  protected boolean t()
  {
    int i = this.al.d(this.h, Long.toString(this.j));
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFull-->Discuss Num = ");
      localStringBuilder.append(i);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return i >= 100;
  }
  
  protected void u()
  {
    this.aA.a(2131625787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion
 * JD-Core Version:    0.7.0.1
 */