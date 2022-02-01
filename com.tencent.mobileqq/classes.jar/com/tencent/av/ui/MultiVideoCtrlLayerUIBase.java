package com.tencent.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoConstants;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.av.ui.MultiVideoCtrlLayerUIBase.SpeakingInfo;>;
import java.util.Iterator;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  private static boolean a = false;
  static int e = 16;
  Runnable A = null;
  int B = 0;
  public boolean C = false;
  boolean D = false;
  String E = null;
  QAVNotification F = null;
  boolean G = true;
  boolean H = false;
  ITraeMediaPlayerApi I = null;
  String J;
  int K = -1;
  int L = -1;
  ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo> M = new ArrayList();
  String N = "";
  ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo> O = new ArrayList();
  boolean P = false;
  Runnable Q = new MultiVideoCtrlLayerUIBase.3(this);
  MultiVideoMembersClickListener R = new MultiVideoCtrlLayerUIBase.6(this);
  int S = 0;
  int T = 1;
  MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable U = new MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable(this);
  MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable V = new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable(this);
  GAudioUIObserver W = new MultiVideoCtrlLayerUIBase.11(this);
  private boolean b = false;
  private boolean bx = false;
  private InviteMemberObserver c = new MultiVideoCtrlLayerUIBase.1(this);
  private BroadcastReceiver d = new MultiVideoCtrlLayerUIBase.2(this);
  public int f = -1;
  int g = -1;
  public int h = 0;
  long i = 0L;
  public long j = 0L;
  long k = 0L;
  int l = 0;
  int m = 0;
  QavInOutAnimation n = null;
  TextView o = null;
  TextView p = null;
  TextView q = null;
  TextView r = null;
  RelativeLayout s = null;
  MultiMembersAudioUI t = null;
  MultiMembersVideoUI u = null;
  Runnable v = null;
  Runnable w = null;
  Runnable x = null;
  Runnable y = null;
  Runnable z = null;
  
  static
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 21) {
      i1 = 16;
    } else {
      i1 = 9;
    }
    e = i1;
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("SM-G7106")) && (!Build.MODEL.equalsIgnoreCase("MI 2")) && (!Build.MODEL.equalsIgnoreCase("GT-B9388")) && (!Build.MODEL.equalsIgnoreCase("L39u")) && (!Build.MODEL.equalsIgnoreCase("R7007")) && (!Build.MODEL.equalsIgnoreCase("VIVO X5S L"))) {
      bool = false;
    } else {
      bool = true;
    }
    a = bool;
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
  }
  
  private String a(ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo> paramArrayList)
  {
    SessionInfo localSessionInfo = this.am.k();
    int i5 = AVUtil.c(localSessionInfo.p);
    if (paramArrayList.size() > 0)
    {
      localObject1 = new int[3];
      Object tmp33_31 = localObject1;
      tmp33_31[0] = -1;
      Object tmp37_33 = tmp33_31;
      tmp37_33[1] = -1;
      Object tmp41_37 = tmp37_33;
      tmp41_37[2] = -1;
      tmp41_37;
      int i1 = 0;
      Object localObject2;
      while (i1 < paramArrayList.size())
      {
        if (QLog.isColorLevel())
        {
          localObject2 = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("speakingInfoList. idx = ");
          localStringBuilder.append(i1);
          localStringBuilder.append(", uin = ");
          localStringBuilder.append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(i1)).a);
          localStringBuilder.append(", audioEnergy = ");
          localStringBuilder.append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(i1)).b);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        if ((localObject1[0] != -1) && (((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[0])).b >= ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(i1)).b))
        {
          if ((localObject1[1] != -1) && (((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[1])).b >= ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(i1)).b))
          {
            if ((localObject1[2] == -1) || (((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[2])).b < ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(i1)).b)) {
              localObject1[2] = i1;
            }
          }
          else
          {
            localObject1[2] = localObject1[1];
            localObject1[1] = i1;
          }
        }
        else
        {
          localObject1[2] = localObject1[1];
          localObject1[1] = localObject1[0];
          localObject1[0] = i1;
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.O.size())
      {
        i2 = 0;
        while ((i2 < localObject1.length) && (localObject1[i2] >= 0))
        {
          if (((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i1)).a.equalsIgnoreCase(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).a))
          {
            i3 = 1;
            break label404;
          }
          i2 += 1;
        }
        i3 = 0;
        label404:
        if (i3 != 0)
        {
          ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).a = "";
          ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i1)).b = ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).b;
        }
        else
        {
          ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i1)).a = "";
        }
        i1 += 1;
      }
      int i2 = 0;
      for (i1 = 0; i2 < this.O.size(); i1 = i3)
      {
        int i4 = i2;
        i3 = i1;
        if (((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i2)).a.equalsIgnoreCase(""))
        {
          i3 = i1;
          for (;;)
          {
            i1 = i3;
            if (i3 >= localObject1.length) {
              break;
            }
            if (localObject1[i3] < 0)
            {
              i1 = i3;
              break;
            }
            if (!((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i3])).a.equalsIgnoreCase(""))
            {
              ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i2)).a = ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i3])).a;
              ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i2)).b = ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i3])).b;
              ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i3])).a = "";
              i1 = i3 + 1;
              break;
            }
            i3 += 1;
          }
          i4 = i2;
          i3 = i1;
          if (i1 < localObject1.length)
          {
            i4 = i2;
            i3 = i1;
            if (localObject1[i1] < 0)
            {
              this.O.remove(i2);
              i4 = i2 - 1;
              i3 = i1;
            }
          }
        }
        i2 = i4 + 1;
      }
      int i3 = this.O.size();
      while (i3 < 1)
      {
        i2 = i1;
        for (;;)
        {
          i1 = i2;
          if (i2 >= localObject1.length) {
            break;
          }
          if (localObject1[i2] < 0)
          {
            i1 = i2;
            break;
          }
          if (!((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).a.equalsIgnoreCase(""))
          {
            this.O.add(new MultiVideoCtrlLayerUIBase.SpeakingInfo(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).a, ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).b));
            ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject1[i2])).a = "";
            i1 = i2 + 1;
            break;
          }
          i2 += 1;
        }
        i3 += 1;
      }
      paramArrayList = "";
      i1 = 0;
      for (;;)
      {
        localObject1 = paramArrayList;
        if (i1 >= this.O.size()) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = this.X;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("speakingInfoList. uin = ");
          ((StringBuilder)localObject2).append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i1)).a);
          ((StringBuilder)localObject2).append(", audioEnergy = ");
          ((StringBuilder)localObject2).append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i1)).b);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = this.al.a(i5, ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.O.get(i1)).a, String.valueOf(localSessionInfo.aN));
        localObject1 = localObject2;
        if (CharacterUtil.a((String)localObject2) > 6)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(CharacterUtil.a((String)localObject2, 0, 6));
          ((StringBuilder)localObject1).append("...");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if (i1 < this.O.size() - 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(((Context)this.ak.get()).getString(2131893645));
          paramArrayList = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList);
          ((StringBuilder)localObject2).append((String)localObject1);
          paramArrayList = ((StringBuilder)localObject2).toString();
        }
        i1 += 1;
      }
    }
    Object localObject1 = "";
    if (this.am.U().size() != 0)
    {
      paramArrayList = (ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo>)localObject1;
      if (this.am.U().size() == 1)
      {
        paramArrayList = (ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo>)localObject1;
        if (((VideoController.GAudioFriends)this.am.U().get(0)).a != Long.parseLong(this.al.getCurrentAccountUin())) {}
      }
    }
    else
    {
      paramArrayList = "";
    }
    return paramArrayList;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    boolean bool = this.am.H();
    if (this.aA != null) {
      this.aA.a("doRefreshGaudioMuteUIStatus", paramInt1, paramInt2, false);
    }
    if (bool)
    {
      super.n(2131441023);
      if (this.al != null) {
        this.al.a(new Object[] { Integer.valueOf(108) });
      }
    }
    else
    {
      super.m(2131441023);
      if (this.al != null) {
        this.al.a(new Object[] { Integer.valueOf(109) });
      }
    }
  }
  
  private void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((Activity)this.ak.get() != null)
    {
      if (this.am == null) {
        return;
      }
      boolean bool = this.am.k().H;
      int i3 = 0;
      int i4 = 1;
      if ((!bool) && (this.am.k().bi.size() <= 0)) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        i1 = 2131441326;
      } else {
        i1 = 2131440995;
      }
      Object localObject1 = (TextView)this.an.findViewById(i1);
      Object localObject2 = Long.toString(paramLong);
      int i1 = 0;
      while (i1 < this.M.size())
      {
        if (((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.M.get(i1)).a.equalsIgnoreCase((String)localObject2))
        {
          if (paramBoolean)
          {
            ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.M.get(i1)).b = paramInt;
            i2 = i4;
            if (paramInt >= 10) {
              break label226;
            }
            this.M.remove(i1);
            i2 = i4;
            break label226;
          }
          this.M.remove(i1);
          i2 = i4;
          break label226;
        }
        i1 += 1;
      }
      int i2 = 0;
      label226:
      if ((paramBoolean) && (i2 == 0) && (paramInt > 10)) {
        this.M.add(new MultiVideoCtrlLayerUIBase.SpeakingInfo((String)localObject2, paramInt));
      }
      ((AVActivity)this.ak.get()).L.a(paramLong, paramBoolean);
      if ((!bool) && (this.am.U().size() <= 8))
      {
        this.N = "";
      }
      else
      {
        localObject2 = new ArrayList();
        paramInt = i3;
        while (paramInt < this.M.size())
        {
          ((ArrayList)localObject2).add(new MultiVideoCtrlLayerUIBase.SpeakingInfo(((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.M.get(paramInt)).a, ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.M.get(paramInt)).b));
          paramInt += 1;
        }
        this.N = a((ArrayList)localObject2);
      }
      ((TextView)localObject1).setText(this.N);
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshSpokesmanInfoContent. uin = ");
      ((StringBuilder)localObject2).append(LogUtil.getSafePrintUin(String.valueOf(paramLong)));
      ((StringBuilder)localObject2).append(", isSpeaking = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", hasVideo = ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", member cnt = ");
      ((StringBuilder)localObject2).append(this.am.U().size());
      ((StringBuilder)localObject2).append(", mSpokesmanNicknameListStr = ");
      ((StringBuilder)localObject2).append(this.N);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void v(boolean paramBoolean)
  {
    int i2 = ImmersiveUtils.getScreenHeight();
    int i1 = i2;
    if (ImmersiveUtils.isSupporImmersive() != 1)
    {
      i1 = i2 - ImmersiveUtils.getStatusBarHeight((Context)this.ak.get());
      ImmersiveUtils.getStatusBarHeight((Context)this.ak.get());
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.t.getLayoutParams();
    if (paramBoolean) {
      i1 = AIOUtils.b(VideoConstants.x, this.t.getResources());
    } else {
      i1 = (int)(i1 * 58 / 1000.0F);
    }
    if (localMarginLayoutParams.topMargin == i1) {
      return;
    }
    localMarginLayoutParams.topMargin = i1;
    this.t.setLayoutParams(localMarginLayoutParams);
    this.u.setVisibility(8);
  }
  
  protected long A()
  {
    if (this.am.j) {
      return this.j;
    }
    return this.i;
  }
  
  void A(long paramLong)
  {
    QLog.d(this.X, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
    int i1 = this.am.k().g;
    int i3 = 4;
    if ((i1 == 4) && (this.am.k().bi.size() > 0))
    {
      AVActivity localAVActivity = (AVActivity)this.ak.get();
      int i2 = localAVActivity.u();
      if (3 == i2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (4 == i2) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i2 != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
      }
      if ((i2 == 0) && (i1 == 0))
      {
        QLog.d(this.X, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
      }
      else
      {
        if (i1 != 0) {
          i1 = i3;
        } else {
          i1 = 3;
        }
        localAVActivity.a(i1, false);
      }
    }
    i(paramLong, 2131893085);
  }
  
  void B(long paramLong)
  {
    C(paramLong);
    i(paramLong, 2131893075);
    ReportController.b(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
  }
  
  void C(long paramLong)
  {
    QLog.d(this.X, 1, "OnClick_MemberInfo");
    AVActivity localAVActivity = (AVActivity)this.ak.get();
    boolean bool;
    if ((!this.am.k().bg) && (!this.am.k().bh)) {
      bool = false;
    } else {
      bool = true;
    }
    VideoMsgTools.a(localAVActivity, String.valueOf(this.am.k().aN), bool, true);
  }
  
  protected void D(long paramLong)
  {
    if (!VideoController.d()) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    localSessionInfo.a(paramLong, true);
    long l1 = Long.valueOf(this.al.getCurrentAccountUin()).longValue();
    int i1 = 0;
    while (i1 < localSessionInfo.bi.size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)localSessionInfo.bi.get(i1);
      if ((localVideoViewInfo.a == l1) && (localVideoViewInfo.b == 2))
      {
        localVideoViewInfo.d = true;
        localVideoViewInfo.f = true;
      }
      else
      {
        localVideoViewInfo.d = false;
        localVideoViewInfo.f = false;
      }
      i1 += 1;
    }
    localSessionInfo.a(-1L, "onUserScreenShareOpen", 4);
    a("onUserScreenShareOpen", paramLong);
    b(paramLong, this.am.k().bi);
  }
  
  void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "resumeVideo");
    }
    if (this.v == null) {
      this.v = new MultiVideoCtrlLayerUIBase.AutoCheckRunnable(this);
    } else {
      this.al.a().removeCallbacks(this.v);
    }
    this.al.a().postDelayed(this.v, 500L);
  }
  
  protected void E(long paramLong)
  {
    if (!VideoController.d()) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    localSessionInfo.a(paramLong, false);
    if (localSessionInfo.bi.size() == 0) {
      localSessionInfo.a(-1L, "onUserScreenShareOpen", 3);
    }
    u(paramLong);
    a("onUserScreenShareClose", paramLong);
  }
  
  protected void F(long paramLong)
  {
    if (V()) {
      return;
    }
    int i2 = 0;
    Object localObject = this.am.k();
    int i1 = i2;
    if (((SessionInfo)localObject).g == 1)
    {
      i1 = i2;
      if (!((SessionInfo)localObject).j())
      {
        i2 = 8;
        i1 = i2;
        if (bv)
        {
          localObject = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBtn_More, !isConnected, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w((String)localObject, 1, localStringBuilder.toString());
          i1 = i2;
        }
      }
    }
    this.aA.setViewVisibility(2131441302, i1);
  }
  
  boolean F()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "Go on Stage");
    }
    if (this.am != null) {
      return this.am.ac();
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.X, 2, "Go On Stage, VideoController is null");
    }
    return false;
  }
  
  void G()
  {
    long l2 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViewList, seq[");
      localStringBuilder.append(l2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    int i1 = this.f;
    long l1;
    if ((i1 != 0) && (i1 != 1)) {
      l1 = this.am.k;
    } else {
      l1 = this.i;
    }
    this.t.a(l1, this.h, false);
    this.t.setOnItemClickListener(this.R);
    b(l2, "initViewList");
  }
  
  public void H()
  {
    if (this.am == null) {
      return;
    }
    int i1;
    if ((!this.am.k().H) && (this.am.k().bi.size() <= 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject1 = (TextView)this.an.findViewById(2131440995);
    Object localObject3 = (TextView)this.an.findViewById(2131441326);
    Object localObject4 = (ImageView)this.an.findViewById(2131441031);
    Object localObject2 = (ImageView)this.an.findViewById(2131441029);
    if (i1 != 0)
    {
      ((TextView)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(8);
      if ((!a) && (!this.P))
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("refreshSpokesmanInfoUI video. txt = ");
        ((StringBuilder)localObject2).append(this.N);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        int i2 = AIOUtils.b(VideoConstants.u + VideoConstants.w, ((TextView)localObject3).getResources());
        i1 = i2;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i1 = i2 + ImmersiveUtils.getStatusBarHeight((Context)this.ak.get());
        }
        i2 = i1;
        if (VideoConstants.y) {
          if (this.af) {
            i2 = i1 + 5;
          } else {
            i2 = i1 + 25;
          }
        }
        localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject3).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = i2;
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((TextView)localObject3).setText(this.N);
        ((TextView)localObject3).setVisibility(0);
        ((ImageView)localObject4).setVisibility(0);
      }
    }
    else
    {
      ((TextView)localObject3).setVisibility(8);
      ((ImageView)localObject4).setVisibility(8);
      if ((!a) && (!this.P))
      {
        ((TextView)localObject1).setText(this.N);
        localObject3 = U();
        if (((localObject3 != null) && (((AVActivity)localObject3).ai != null) && (((AVActivity)localObject3).ai.c())) || (this.am.U().size() <= 8))
        {
          localObject4 = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshSpokesmanInfoUI audio. txt = ");
          localStringBuilder.append(this.N);
          localStringBuilder.append(", isSoftKeyboardShown = ");
          localStringBuilder.append(((AVActivity)localObject3).ai.c());
          localStringBuilder.append(", member cnt = ");
          localStringBuilder.append(this.am.U().size());
          QLog.d((String)localObject4, 2, localStringBuilder.toString());
          ((TextView)localObject1).setVisibility(8);
          ((ImageView)localObject2).setVisibility(8);
          return;
        }
        localObject3 = this.X;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("refreshSpokesmanInfoUI audio. txt = ");
        ((StringBuilder)localObject4).append(this.N);
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
        ((TextView)localObject1).setVisibility(0);
        ((ImageView)localObject2).setVisibility(0);
      }
    }
  }
  
  ArrayList<VideoController.GAudioFriends> I()
  {
    if (this.am != null) {
      return this.am.U();
    }
    return null;
  }
  
  void J()
  {
    long l1 = AudioHelper.c();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOrResumeRemoteOrLocalVideo, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], mVideoController[");
      boolean bool;
      if (this.am != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.am == null) {
      return;
    }
    if (!this.am.j)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "startOrResumeRemoteOrLocalVideo, Not in MultiVideoRoom");
      }
      return;
    }
    int i2 = this.am.q();
    int i3 = this.am.k().b(this.k, 1);
    int i1;
    if (i3 != -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOrResumeRemoteOrLocalVideo, onStageNum[");
      localStringBuilder.append(i2);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i3);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((!NetworkUtil.isWifiConnected((Context)this.ak.get())) && (!this.am.k().bA))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
      }
      if (i1 != 0)
      {
        this.am.a(this.k, this.am.k().bi, this.am.k().bk, 1, false);
        this.am.ab();
      }
      if (this.am.k().bi.size() > 0)
      {
        this.am.k().a(l1, "startOrResumeRemoteOrLocalVideo", true, true);
        a("startOrResumeRemoteOrLocalVideo", l1);
        if (!NetworkUtil.isNetworkAvailable((Context)this.ak.get()))
        {
          DoubleVideoCtrlUI.a(this.al, 0);
          return;
        }
        a(true, true, true);
        return;
      }
      ai();
      return;
    }
    if (i1 != 0) {
      if (i2 < e)
      {
        if (F())
        {
          f(l1, 16777215);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.X, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
          }
          this.am.a(this.k, this.am.k().bi, this.am.k().bk, 1, false);
          this.am.ab();
        }
      }
      else
      {
        this.am.a(this.k, this.am.k().bi, this.am.k().bk, 1, false);
        this.am.ab();
      }
    }
    if (this.am.k().bi.size() > 0)
    {
      K();
      return;
    }
    ai();
  }
  
  boolean K()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "startRecvAllVideo");
    }
    Object localObject = this.am;
    boolean bool2 = false;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "startRecvAllVideo --> VideoController is null");
      }
      return false;
    }
    localObject = (Context)this.ak.get();
    if ((localObject != null) && ((localObject instanceof AVActivity)))
    {
      localObject = (AVActivity)localObject;
      if (localObject != null)
      {
        bool1 = ((AVActivity)localObject).isResume();
        break label98;
      }
    }
    boolean bool1 = true;
    label98:
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecvAllVideo --> isResume = ");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!bool1) {
      return false;
    }
    int i2 = this.am.k().bi.size();
    int i1 = i2;
    if (this.am.k().H) {
      i1 = i2 - 1;
    }
    if (i1 <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "startRecvAllVideo --> There is no video need request");
      }
      return false;
    }
    i1 = Utils.a(this.al.getApp());
    if (i1 == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = ");
        localStringBuilder.append(i1);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    i1 = this.am.X();
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecvAllVideo --> Ability = ");
      localStringBuilder.append(i1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (i1 != 4)
    {
      if (this.h == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
      }
      if (this.am.k().bi.size() > 1) {
        TipsUtil.a(this.al, 3007);
      }
    }
    this.am.k().bl.clear();
    long l1 = Long.parseLong(this.al.getCurrentAccountUin());
    i1 = 0;
    while (i1 < this.am.k().bi.size())
    {
      localObject = (VideoViewInfo)this.am.k().bi.get(i1);
      if ((((VideoViewInfo)localObject).e) && (l1 != ((VideoViewInfo)localObject).a)) {
        this.am.k().bl.add(localObject);
      }
      i1 += 1;
    }
    a(false, false, false);
    Y();
    TipsUtil.b(this.al, 1036);
    TipsUtil.b(this.al, 1037);
    bool1 = bool2;
    if (this.am.k().bM == 3) {
      bool1 = true;
    }
    return this.am.b(bool1);
  }
  
  void L()
  {
    Y();
    TipsUtil.b(this.al, 1036);
    TipsUtil.b(this.al, 1037);
    TipsUtil.a(this.al, 1030);
    this.am.k().b(this.k, true, true);
    a(true, false, true);
  }
  
  protected void M()
  {
    if (this.am.k().bM == 1)
    {
      int i1;
      if (this.am.X() == 4) {
        i1 = 3;
      } else {
        i1 = 4;
      }
      int i2 = i1;
      if (i1 == 3)
      {
        i2 = i1;
        if (!QAVConfigUtils.c()) {
          i2 = 4;
        }
      }
      AVActivity localAVActivity = (AVActivity)this.ak.get();
      if (localAVActivity != null)
      {
        if (QLog.isDevelopLevel())
        {
          String str = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initScreenLayout Style=");
          localStringBuilder.append(i2);
          localStringBuilder.append("|");
          localStringBuilder.append(this.am.k().bM);
          localStringBuilder.append("|");
          localStringBuilder.append(this.am.X());
          QLog.d(str, 4, localStringBuilder.toString());
        }
        localAVActivity.a(i2, false);
      }
    }
  }
  
  void N()
  {
    long l1 = AudioHelper.c();
    SessionInfo localSessionInfo = this.am.k();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshMemberCtrlButton, SessionType[");
    localStringBuilder.append(localSessionInfo.g);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(localSessionInfo.o);
    localStringBuilder.append("], mUinType[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], isManager[");
    localStringBuilder.append(localSessionInfo.bg);
    localStringBuilder.append("], isRoomCreator[");
    localStringBuilder.append(localSessionInfo.bh);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.am.j);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    f(l1, 16777215);
  }
  
  void O()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_push_cfg_txt.");
    localStringBuilder.append(this.al.getCurrentAccountUin());
    localStringBuilder.append(".level");
    int i1 = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_push_cfg_txt.");
    localStringBuilder.append(this.al.getCurrentAccountUin());
    localStringBuilder.append(".sendDura");
    int i2 = localSharedPreferences.getInt(localStringBuilder.toString(), 5000);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_push_cfg_txt.");
    localStringBuilder.append(this.al.getCurrentAccountUin());
    localStringBuilder.append(".validDura");
    int i3 = localSharedPreferences.getInt(localStringBuilder.toString(), 6000);
    this.am.a(i1, i2, i3);
  }
  
  Intent P()
  {
    if (this.ak != null)
    {
      AVActivity localAVActivity = (AVActivity)this.ak.get();
      if (localAVActivity != null) {
        return localAVActivity.getIntent();
      }
    }
    return null;
  }
  
  boolean Q()
  {
    if ((VcSystemInfo.isNormalSharp()) && (Utils.a(this.al.getApp()) != 1))
    {
      if (this.am.q() >= e)
      {
        TipsUtil.a(this.al, 1031);
        return false;
      }
      return true;
    }
    DoubleVideoCtrlUI.a(this.al);
    return false;
  }
  
  public void R()
  {
    if (this.am == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.X, 2, "cancelNotification");
    }
    QAVNotification localQAVNotification = this.F;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.am.k().f);
    }
    this.am.Z();
  }
  
  public void S()
  {
    if (this.am == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showNotification quit[");
      ((StringBuilder)localObject2).append(this.C);
      ((StringBuilder)localObject2).append("], inRoom[");
      ((StringBuilder)localObject2).append(this.am.j);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((!this.C) && (this.am.j))
    {
      if (this.F != null)
      {
        localObject1 = this.am.k();
        localObject2 = String.valueOf(((SessionInfo)localObject1).aN);
        String str = this.al.a(this.g, (String)localObject2, null);
        Bitmap localBitmap = this.al.a(this.g, (String)localObject2, null, true, true);
        int i1;
        if (((SessionInfo)localObject1).k())
        {
          if (((SessionInfo)localObject1).g == 3) {
            i1 = 62;
          } else {
            i1 = 63;
          }
        }
        else {
          i1 = 44;
        }
        this.F.a(this.am.k().f, str, localBitmap, (String)localObject2, i1, this.g, this.am.k().g);
      }
      this.am.Y();
    }
  }
  
  protected boolean T()
  {
    if (this.am == null) {
      return false;
    }
    SessionInfo localSessionInfo = this.am.k();
    boolean bool2 = QAVConfigUtils.q();
    boolean bool1;
    if ((!localSessionInfo.bg) && (!localSessionInfo.bh)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canStopMuteStatus, isAllowedControlMicAfterBeMuted[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], isNormalUser[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], isRoomMicOff[");
      localStringBuilder.append(localSessionInfo.aU);
      localStringBuilder.append("], micAuthByAdmin[");
      localStringBuilder.append(localSessionInfo.aV);
      localStringBuilder.append("], mIsPhoneCalling[");
      localStringBuilder.append(this.am.k().q);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((bool1) && (localSessionInfo.aU) && (localSessionInfo.aV != 0)) {
      return false;
    }
    if ((!bool2) && (bool1) && (localSessionInfo.aV == 1)) {
      return false;
    }
    return !this.am.k().q;
  }
  
  public String a(String paramString, int paramInt, TextView paramTextView)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "genDiscussTitle, name == null");
      }
      return "";
    }
    int i1 = AIOUtils.b(160.0F, this.aj);
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1 = i1 - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - this.aj.getDisplayMetrics().density * 4.0F;
    String str = paramString;
    if (f1 > 0.0F)
    {
      float f2 = localTextPaint.measureText(paramString);
      str = paramString;
      if (f2 > f1)
      {
        float f3 = f1 - localTextPaint.measureText("…");
        paramTextView = paramString;
        while ((f3 > 0.0F) && (f2 > f3) && (paramTextView.length() > 0))
        {
          str = paramTextView.substring(0, paramTextView.length() - 1);
          f2 = localTextPaint.measureText(str);
          f1 = f2;
          if (f2 == 0.0F)
          {
            f1 = f2;
            if (str.length() > 0) {
              f1 = 1.0F + f3;
            }
          }
          f2 = f1;
          paramTextView = str;
          if (QLog.isDevelopLevel())
          {
            paramTextView = this.X;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("genDiscussTitle, name widht[");
            localStringBuilder.append(f1);
            localStringBuilder.append("]");
            QLog.d(paramTextView, 2, localStringBuilder.toString());
            f2 = f1;
            paramTextView = str;
          }
        }
        str = paramString;
        if (f3 > 0.0F)
        {
          str = paramString;
          if (paramTextView.length() > 0)
          {
            paramString = new StringBuilder();
            paramString.append(paramTextView);
            paramString.append("…");
            str = paramString.toString();
          }
        }
      }
    }
    return str;
  }
  
  abstract void a();
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoViewModeChange --> lastMode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , currentMode = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",bigUin=");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt1 != paramInt2)
    {
      if (this.bx) {
        return;
      }
      boolean bool;
      if (paramInt2 == 3) {
        bool = true;
      } else {
        bool = false;
      }
      if (4 != this.am.X()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      int i1 = 1;
      while (i1 < this.am.k().bi.size())
      {
        paramString = (VideoViewInfo)this.am.k().bi.get(i1);
        paramString.c = bool;
        if ((paramInt1 != 0) && (!paramString.e))
        {
          int i2 = this.am.k().b(this.k);
          if (i2 != -1) {
            ((VideoViewInfo)this.am.k().bi.get(i2)).e = false;
          }
        }
        if ((paramInt2 == 3) && (paramInt1 != 0)) {
          paramString.e = false;
        } else {
          paramString.e = true;
        }
        i1 += 1;
      }
      if (K()) {
        this.am.k().bj = true;
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.a(paramLong);
    if (this.D)
    {
      s(this.j);
      this.D = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  abstract void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (V()) {
      return;
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, uin[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], refreshType[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], needRefresh[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], originalType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], audioEnergy[");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramLong == 0L) {
      return;
    }
    Object localObject1 = new MultiVideoCtrlLayerUIBase.RefreshUIRunnable(this, paramLong, paramInt1, paramBoolean, paramInt2);
    Object localObject2 = U();
    ((AVActivity)localObject2).runOnUiThread((Runnable)localObject1);
    if (this.u != null)
    {
      this.t.a(this.k, 0, 0, this.am.H());
      ((AVActivity)localObject2).L.b(this.k, this.am.H());
    }
    if (paramInt2 == 42) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    }
    d(paramLong, paramBoolean, paramInt3);
    H();
  }
  
  void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeRemoteVideo[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], mVideoController[");
      boolean bool;
      if (this.am != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.am == null) {
      return;
    }
    this.am.f("Multi_closeRemoteVideo");
    this.am.k().a(paramLong, "closeRemoteVideo", false, true);
    a("closeRemoteVideo", paramLong);
    e("closeRemoteVideo");
    this.ao.update(null, new Object[] { Integer.valueOf(104), this.am.k().bi });
  }
  
  void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyDataChangeByQuitUin, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if ((paramInt == 1) && (this.ak.get() != null))
    {
      localObject = (Activity)this.ak.get();
      localObject = this.am;
      if (this.Y == 3) {
        bool1 = false;
      }
      ((VideoController)localObject).b(paramLong2, bool1);
    }
    b(paramLong1, paramString);
  }
  
  void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (V()) {
      return;
    }
    int i1;
    if (paramArrayList == null) {
      i1 = 0;
    } else {
      i1 = paramArrayList.size();
    }
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doInternalUIFreash, gaFList[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.aj == null) {
      return;
    }
    if (i1 <= 1) {
      a_(paramLong, 2131893319);
    } else {
      d(paramLong, null);
    }
    this.K = i1;
    Object localObject = this.t;
    if (localObject != null)
    {
      ((MultiMembersAudioUI)localObject).a(paramArrayList);
      H();
    }
    ((AVActivity)this.ak.get()).L.a(paramArrayList);
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      ((MultiMembersAudioUI)localObject).a(paramLong, paramBoolean);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyMemberSpeak, MemberUI is null --> Uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , Speak = ");
      localStringBuilder.append(paramBoolean);
      QLog.e((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    H();
  }
  
  abstract void a(Intent paramIntent);
  
  public void a(String arg1, int paramInt1, String paramString2, int paramInt2)
  {
    super.a(???, paramInt1, paramString2, paramInt2);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoViewChange --> BigViewUin = ");
      localStringBuilder.append(???);
      localStringBuilder.append(" , BigViewVideoViewType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , SmallViewUin = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" , SmallViewVideoViewType = ");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (??? != null)
    {
      if (paramString2 == null) {
        return;
      }
      if (this.bx) {
        return;
      }
    }
    try
    {
      long l1 = Long.valueOf(paramString2).longValue();
      if (paramInt1 == 2)
      {
        k(1036);
        TipsUtil.b(this.al, 1036);
      }
      int i1 = this.am.k().b(Long.valueOf(???).longValue(), paramInt1);
      if (i1 == -1) {
        return;
      }
      paramString2 = (VideoViewInfo)this.am.k().bi.get(i1);
      paramInt1 = 0;
      while (paramInt1 < this.am.k().bi.size())
      {
        localObject = (VideoViewInfo)this.am.k().bi.get(paramInt1);
        if ((l1 == ((VideoViewInfo)localObject).a) && (paramInt2 == ((VideoViewInfo)localObject).b))
        {
          paramString2.c = false;
          if ((paramString2.a != this.k) && (((VideoViewInfo)localObject).a != this.k) && (4 != this.am.X())) {
            paramString2.e = false;
          }
          ((VideoViewInfo)localObject).c = true;
          if ((4 != this.am.X()) && (!((VideoViewInfo)localObject).e))
          {
            paramInt2 = this.am.k().b(this.k);
            if (paramInt2 != -1) {
              ((VideoViewInfo)this.am.k().bi.get(paramInt2)).e = false;
            }
          }
          ((VideoViewInfo)localObject).e = true;
          if ((((VideoViewInfo)localObject).a == this.k) && (this.h == 2)) {
            ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
          }
          if ((!((VideoViewInfo)localObject).d) && (this.am.X() != 4)) {
            DataReport.b(this.am.k().o);
          }
          this.am.k().bi.set(i1, localObject);
          this.am.k().bi.set(paramInt1, paramString2);
          synchronized (this.am.k().bk)
          {
            this.am.k().bk.set(i1, localObject);
            this.am.k().bk.set(paramInt1, paramString2);
            this.am.k().C();
            ((AVActivity)this.ak.get()).L.a(((VideoViewInfo)localObject).a, ((VideoViewInfo)localObject).b, paramString2.a, paramString2.b);
          }
        }
        paramInt1 += 1;
      }
      K();
      return;
    }
    catch (Exception ???)
    {
      label608:
      break label608;
    }
    QLog.e(this.X, 2, "onVideoViewChange --> Parse String 2 Long Failed");
  }
  
  void a(String paramString, long paramLong)
  {
    if (this.am == null) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    if (localSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchUIMode[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], SessionType[");
      localStringBuilder.append(localSessionInfo.g);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    boolean bool;
    if (localSessionInfo.g == 4)
    {
      this.aR.c(false);
      this.aR.b(false);
      this.t.setVisibility(8);
      ((AVActivity)this.ak.get()).L.k(this.am.k().bM);
      ((AVActivity)this.ak.get()).L.a(this.am.k());
      N();
      int i1;
      if ((!localSessionInfo.H) && (!localSessionInfo.I)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      a(true, i1);
      if (this.aQ != null) {
        this.aQ.a(true);
      }
      a(true);
      b(true);
      g(paramLong, 8);
      bool = true;
    }
    else
    {
      this.an.setVisibility(0);
      s(true);
      this.aR.c(true);
      this.aR.b(true);
      this.t.setVisibility(0);
      paramString = (AVActivity)this.ak.get();
      if (!paramString.isFinishing()) {
        paramString.L.k(-1);
      }
      N();
      a(false, 1);
      if (this.aQ != null) {
        this.aQ.a(false);
      }
      a(false);
      b(false);
      g(paramLong, 0);
      a(paramLong, 0.0F);
      bool = false;
    }
    a(Boolean.valueOf(bool));
    f(paramLong, 16777215);
    this.al.a(new Object[] { Integer.valueOf(102) });
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ax.setVisibility(0);
      this.ay.setVisibility(8);
      this.p.setVisibility(0);
      this.o.setVisibility(8);
      if (this.aE != null) {
        this.aE.a(8);
      }
    }
    else
    {
      this.ax.setVisibility(8);
      this.ay.setVisibility(0);
      this.o.setVisibility(0);
      this.p.setVisibility(8);
      if (this.aE != null) {
        this.aE.a(0);
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showOrHideRecvVideoBtnAndTips --> bShow = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" , needNoticeWiFiTips = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" , needShowGLView = ");
      localStringBuilder.append(paramBoolean3);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.bx = paramBoolean1;
    this.am.k().b(paramBoolean1);
    if (this.ba != null) {
      this.ba.a(paramBoolean1, new MultiVideoCtrlLayerUIBase.10(this));
    }
    if (paramBoolean1)
    {
      DataReport.d(NetworkUtil.isWifiConnected((Context)this.ak.get()), this.am.k().o);
      ai();
      if (paramBoolean2) {
        TipsUtil.a(this.al, 3013);
      } else {
        TipsUtil.b(this.al, 3013);
      }
    }
    else
    {
      TipsUtil.b(this.al, 3013);
      TipsUtil.b(this.al, 1030);
    }
    if (paramBoolean3) {
      b(AudioHelper.c(), this.am.k().bi);
    }
  }
  
  public void a_(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnPause, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.a_(paramLong);
    if (this.am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    this.am.k().by = true;
    this.al.e("MultiVideoCtrlLayerUIBase");
    if (this.am != null)
    {
      if (((!SmallScreenUtils.g()) || ((!NetworkUtil.isWifiConnected((Context)this.ak.get())) && (!this.am.k().bA))) && (this.am.k().H)) {
        w(paramLong);
      }
      if (this.am.k().B() != -1) {
        this.am.f("Multi_onPause");
      }
      this.am.k().b(this.k, true, true);
    }
    this.al.a().removeCallbacks(this.bg);
    this.al.a().removeCallbacks(this.U);
  }
  
  void a_(long paramLong, int paramInt)
  {
    this.L = paramInt;
    int i1 = this.L;
    super.d(paramLong, this.aj.getString(paramInt));
  }
  
  protected int b()
  {
    return 2131625735;
  }
  
  public int b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onApnChanged --> NetType = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    DoubleVideoCtrlUI.a(this.al, paramInt);
    if ((NetworkUtil.isWifiConnected((Context)this.ak.get())) && (this.am != null) && (this.am.j) && (this.bx)) {
      K();
    }
    return 0;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.aA == null) {
      return;
    }
    this.aA.setViewVisibility(paramInt1, paramInt2);
  }
  
  abstract void b(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.b(paramLong);
    r(paramLong);
    t(paramLong);
    if (this.am != null) {
      this.am.k().by = false;
    }
    if ((this.am != null) && (this.am.j)) {
      E();
    }
    if (this.y == null)
    {
      this.y = new MultiVideoCtrlLayerUIBase.RefreshFaceRunnable(this);
      this.al.a().postDelayed(this.y, 2000L);
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    this.aJ = paramInt;
    if (this.am != null)
    {
      if (this.am.k().q()) {
        return;
      }
      this.l = (360 - paramInt);
      a(paramLong, this.l);
    }
  }
  
  void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGroupVideoChatClosed, relationId[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], mIntentRelationId[");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.i != paramLong) {
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject1).putExtra("type", 32);
    ((Intent)localObject1).putExtra("relationId", paramLong);
    ((Intent)localObject1).putExtra("uinType", this.g);
    ((Intent)localObject1).putExtra("closeType", paramInt1);
    ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
    ((Intent)localObject1).putExtra("from", this.X);
    Object localObject2 = (AVActivity)this.ak.get();
    if (localObject2 != null)
    {
      ((Intent)localObject1).setPackage(this.al.getApplication().getPackageName());
      ((AVActivity)localObject2).sendBroadcast((Intent)localObject1);
      e(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.X, 2, "onGroupVideoChatClosed-->can not get the activity");
    }
  }
  
  void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyDataChange, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    paramString = this.am.Q();
    ThreadManager.getSubThreadHandler().post(new MultiVideoCtrlLayerUIBase.7(this, paramString, paramLong));
  }
  
  void b(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)paramArrayList.get(i1);
      if ((localVideoViewInfo.a == this.k) && (localVideoViewInfo.b == 1) && (!this.am.k().H))
      {
        paramArrayList.remove(i1);
        break;
      }
      i1 += 1;
    }
    this.ao.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
  }
  
  void b(Intent paramIntent)
  {
    try
    {
      this.k = Long.valueOf(this.al.getCurrentAccountUin()).longValue();
    }
    catch (Exception localException)
    {
      label20:
      Object localObject;
      int i1;
      break label20;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "Can not get AccountUin WHY!!!???");
    }
    this.k = 0L;
    localObject = this.am.k();
    this.g = ((SessionInfo)localObject).p;
    i1 = this.g;
    if (i1 == 3000) {
      this.h = 2;
    } else if (i1 == 1) {
      this.h = 1;
    }
    ((SessionInfo)localObject).aQ = this.h;
    i1 = ((SessionInfo)localObject).aP;
    this.i = ((SessionInfo)localObject).aN;
    this.f = ((SessionInfo)localObject).aP;
    this.b = false;
    if (paramIntent != null) {
      this.H = paramIntent.getBooleanExtra("isVideo", false);
    }
    paramIntent = this.X;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processIntentData, mUinType[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("], mRelationType[");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("], mIntentRelationId[");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("], mStatusType[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("], mStatusType[");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("], getSimpleDataList[");
    ((StringBuilder)localObject).append(this.am.W());
    ((StringBuilder)localObject).append("], getGAudioList[");
    ((StringBuilder)localObject).append(this.am.U());
    ((StringBuilder)localObject).append("]");
    QLog.w(paramIntent, 1, ((StringBuilder)localObject).toString());
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = (BaseActivity)this.ak.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "switchMode --> Can not get activity");
      }
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)this.an.findViewById(2131441074);
    localObject = (AVActivity)localObject;
    if (paramBoolean)
    {
      localRelativeLayout.setBackgroundColor(this.aj.getColor(2131168376));
      if (localObject != null)
      {
        ((AVActivity)localObject).b(false);
        ((AVActivity)localObject).f(false);
        ((AVActivity)localObject).c(true);
      }
    }
    else
    {
      localRelativeLayout.setBackgroundColor(this.aj.getColor(2131166788));
      if (localObject != null)
      {
        ((AVActivity)localObject).b(true);
        ((AVActivity)localObject).f(true);
        ((AVActivity)localObject).c(false);
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhoneCalling, isSelf[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.am == null) {
      return;
    }
    if (paramBoolean1)
    {
      if ((this.am.k().q) && (this.am.k().aG)) {
        this.aQ.a(TraeHelper.k);
      }
      s();
    }
  }
  
  void c()
  {
    long l1 = AudioHelper.c();
    Object localObject1 = this.am.k();
    Object localObject2 = this.X;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("initUI, SessionType[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).g);
    ((StringBuilder)localObject3).append("], switchToGAudioMode[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).aR);
    ((StringBuilder)localObject3).append("], localMute[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).E);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l1);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    super.c();
    if (this.aA != null)
    {
      u();
      this.aA.d();
      localObject2 = (Activity)this.ak.get();
      if (localObject2 != null)
      {
        this.aQ = TraeHelper.a();
        this.aA.a(this.aQ);
        this.aR = SensorHelper.a(this.aR, (Activity)localObject2, this.am, this.aQ);
        this.aR.a(true);
        this.aQ.b();
      }
    }
    this.as.post(this.Q);
    h(l1, 8);
    this.o = ((TextView)this.an.findViewById(2131441067));
    this.q = ((TextView)this.an.findViewById(2131438060));
    this.r = ((TextView)this.an.findViewById(2131428860));
    this.p = ((TextView)this.an.findViewById(2131441068));
    f(l1, 16777215);
    localObject2 = (AVActivity)this.ak.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.s = ((RelativeLayout)this.an.findViewById(2131441297));
    this.t = ((MultiMembersAudioUI)this.an.findViewById(2131441216));
    this.u = ((MultiMembersVideoUI)this.an.findViewById(2131441217));
    v(true);
    G();
    GAudioSoundUtil.a(((AVActivity)localObject2).getApplicationContext());
    if (this.am.j)
    {
      this.aR.b(true);
      this.aR.c(true);
      if ((this.aE != null) && (!this.aE.o())) {
        this.aE.i();
      }
    }
    if ((((SessionInfo)localObject1).b()) && (((SessionInfo)localObject1).E))
    {
      int i1 = this.am.D();
      this.am.a("MultiVideoCtrlLayerUIBase.initUI", ((SessionInfo)localObject1).aN, false, true, -1);
      if (this.aA != null) {
        this.aA.a("MultiVideoCtrlLayerUIBase.initUI", i1, this.am.D(), false);
      }
      super.m(2131441023);
    }
    this.aQ.b();
    if (this.A == null) {
      this.A = new MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable(this);
    }
    this.al.a().post(this.A);
    this.n = new QavInOutAnimation((Context)this.ak.get(), this.am, 3, this.aA, this.aB, null, null, this.o, this.an.findViewById(2131441196), null);
    this.n.a();
    if (((SessionInfo)localObject1).g == 4) {
      a("initUI", l1);
    }
    ((AVActivity)this.ak.get()).L.b(this.k, this.am.H());
    if (AudioHelper.a(0) == 1) {
      this.t.setBackgroundColor(531496751);
    }
    localObject3 = (TextView)this.an.findViewById(2131441326);
    TextView localTextView = (TextView)this.an.findViewById(2131440995);
    ((TextView)localObject3).setAlpha(0.3F);
    localTextView.setAlpha(0.3F);
    localObject1 = (ImageView)this.an.findViewById(2131441031);
    localObject2 = (ImageView)this.an.findViewById(2131441029);
    ((ImageView)localObject1).setAlpha(0.3F);
    ((ImageView)localObject2).setAlpha(0.3F);
    localObject3 = new MultiVideoCtrlLayerUIBase.4(this, (TextView)localObject3, (ImageView)localObject1, localTextView, (ImageView)localObject2);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject3);
    ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject3);
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    super.c(paramLong);
    S();
    this.D = false;
  }
  
  public void c(long paramLong, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1))
    {
      w(paramLong);
      this.am.a(this.k, this.am.k().bi, this.am.k().bk, 1, false);
    }
    super.c(paramLong, paramInt);
  }
  
  public void c(long paramLong, View paramView)
  {
    if (V()) {
      return;
    }
    C(paramLong);
    I(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      K();
    }
    H();
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "OnNewIntent");
    }
    b(paramIntent);
    boolean bool = false;
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      ai();
    }
    a(paramIntent);
    if (bool) {
      this.aQ.f();
    }
    a();
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      super.n(2131441023);
      if ((this.al != null) && (paramBoolean2))
      {
        if (this.aA.getCurrentSpeakerMode() != 3) {
          t(true);
        } else {
          TipsUtil.a(this.am.e, 1071, 3000L);
        }
        this.al.a(new Object[] { Integer.valueOf(108) });
      }
    }
    else
    {
      super.m(2131441023);
      TipsUtil.a(this.am.e, false);
      if (this.aA != null) {
        this.aA.a(2131441023, ((Context)this.ak.get()).getString(2131889940));
      }
      if ((this.al != null) && (paramBoolean2))
      {
        t(false);
        this.al.a(new Object[] { Integer.valueOf(109) });
      }
    }
  }
  
  abstract void d();
  
  public void d(int paramInt)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "showToolBars");
    }
    if (!this.am.k().q())
    {
      f(paramInt);
      I(l1);
    }
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDestroy, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    this.am.T();
    this.al.b(this.W);
    this.al.b(this.c);
    if (this.ak.get() != null) {
      ((Context)this.ak.get()).unregisterReceiver(this.d);
    }
    this.al.a().removeCallbacks(this.v);
    this.al.a().removeCallbacks(this.w);
    this.al.a().removeCallbacks(this.x);
    this.al.a().removeCallbacks(this.y);
    this.al.a().removeCallbacks(this.aI);
    this.al.a().removeCallbacks(this.V);
    if (this.z != null) {
      this.al.a().removeCallbacks(this.z);
    }
    this.al.a().removeCallbacks(this.A);
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.aI = null;
    this.V = null;
    this.z = null;
    this.A = null;
    Y();
    TipsUtil.b(this.al, 1030);
    TipsUtil.b(this.al, 1036);
    TipsUtil.b(this.al, 1037);
    TipsUtil.b(this.al, 3013);
    TipsUtil.b(this.al, 1034);
    TipsUtil.b(this.al, 1035);
    this.aR.a(false);
    this.aR.b(false);
    this.aR.c(false);
    this.aR = null;
    this.t = null;
    this.u = null;
    this.J = null;
    this.K = -1;
    this.L = -1;
    if (this.an != null) {
      this.an.removeAllViews();
    }
    Object localObject = this.I;
    if (localObject != null)
    {
      ((ITraeMediaPlayerApi)localObject).stopRing(paramLong);
      this.I = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.n = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, View paramView)
  {
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Mute, micPermission[");
    localStringBuilder.append(this.am.k().O);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView)) {
      x(paramLong);
    }
    super.I(paramLong);
  }
  
  void d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addRequestVideoTimeoutRunnable[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.w != null) {
      this.al.a().removeCallbacks(this.w);
    } else {
      this.w = new MultiVideoCtrlLayerUIBase.RequestVideoTimeOutRunnable(this);
    }
    this.al.a().postDelayed(this.w, 30000L);
  }
  
  public void d(boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyAIDenoiseTips, isFromlocal[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (U() != null)
    {
      if (paramBoolean)
      {
        TipsUtil.a(this.al, 3016);
        str = "0X800BC07";
      }
      else
      {
        TipsUtil.a(this.al, 3015);
        str = "0X800BC08";
      }
      ReportController.b(null, "CliOper", "", "", str, str, 1, 0, "", "", "", "");
    }
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.X, 1, "showPermissionDialog deniedForAudioRecord(2) 10");
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "OnCreate");
    }
    Object localObject = (BaseActivity)this.ak.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "Can not get activity");
      }
      return;
    }
    this.al.a(this.W);
    this.al.a(this.c);
    ((BaseActivity)localObject).registerReceiver(this.d, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    this.F = QAVNotification.a(this.al);
    localObject = P();
    b((Intent)localObject);
    a((Intent)localObject);
    this.am.S();
  }
  
  public void e(int paramInt) {}
  
  void e(long paramLong, View paramView)
  {
    SessionInfo localSessionInfo = this.am.k();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_CAMERA, sessionInfo[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("], mHasLauncnRequestFromCameraButton[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (a(paramLong, "android.permission.CAMERA", paramView)) {
      if (!localSessionInfo.H)
      {
        if (!Q()) {
          return;
        }
        int i2 = 0;
        if (g(false)) {
          return;
        }
        DataReport.f(true);
        if (!NetworkUtil.isWifiConnected((Context)this.ak.get()))
        {
          paramView = new StringBuilder();
          paramView.append(VideoController.aj);
          paramView.append(this.al.getCurrentAccountUin());
          if (VideoController.n(paramView.toString()) > 0) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          if (i1 != 0)
          {
            paramView = (Context)this.ak.get();
            if (paramView == null) {
              return;
            }
            DialogUtil.a(paramView, 230, this.aj.getString(2131893450), this.aj.getString(2131893446), 2131893167, 2131893180, new MultiVideoCtrlLayerUIBase.12(this, paramLong), new MultiVideoCtrlLayerUIBase.13(this)).show();
            i1 = i2;
            break label287;
          }
        }
        int i1 = 1;
        label287:
        if (i1 != 0) {
          if ((localSessionInfo.B() == -1) && (!NetworkUtil.isWifiConnected((Context)this.ak.get())))
          {
            v(paramLong);
          }
          else if (F())
          {
            this.b = true;
            f(paramLong, 16777215);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(this.X, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
          }
        }
      }
      else
      {
        w(paramLong);
        this.am.a(this.k, localSessionInfo.bi, localSessionInfo.bk, 1, false);
      }
    }
    i(paramLong, 2131893073);
  }
  
  void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRequestVideoTimeoutRunnable[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.w != null) {
      this.al.a().removeCallbacks(this.w);
    }
  }
  
  void e(boolean paramBoolean)
  {
    this.C = paramBoolean;
    this.al.a(new Object[] { Integer.valueOf(28), String.valueOf(this.i), Boolean.valueOf(paramBoolean) });
    if (this.C) {
      R();
    }
  }
  
  void f(boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    ITraeMediaPlayerApi localITraeMediaPlayerApi = this.I;
    if (localITraeMediaPlayerApi == null)
    {
      this.I = ((ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class));
      this.I.init((Context)this.ak.get(), null);
    }
    else
    {
      localITraeMediaPlayerApi.stopRing(l1);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3"))
      {
        localITraeMediaPlayerApi = this.I;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(GAudioSoundUtil.a());
        localStringBuilder.append("qav_gaudio_muted.mp3");
        localITraeMediaPlayerApi.playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
      }
    }
    else if (GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      localITraeMediaPlayerApi = this.I;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(GAudioSoundUtil.a());
      localStringBuilder.append("qav_gaudio_cancel_muted.mp3");
      localITraeMediaPlayerApi.playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
    }
  }
  
  public boolean g(boolean paramBoolean)
  {
    SessionInfo localSessionInfo = this.am.k();
    boolean bool2 = QAVConfigUtils.q();
    boolean bool1;
    if ((!localSessionInfo.bg) && (!localSessionInfo.bh)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], isNormalUser[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], isRoomMicOff[");
      localStringBuilder.append(localSessionInfo.aU);
      localStringBuilder.append("], micAuthByAdmin[");
      localStringBuilder.append(localSessionInfo.aV);
      localStringBuilder.append("], openMic[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    int i1;
    if ((bool1) && (localSessionInfo.aU) && (localSessionInfo.aV != 0))
    {
      if (paramBoolean) {
        i1 = 2131893304;
      } else {
        i1 = 2131893474;
      }
      TipsUtil.a(this.al, 1033, this.aj.getString(i1));
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", i1, 0, "1", "", "", "");
      return true;
    }
    if ((!bool2) && (bool1) && (localSessionInfo.aV == 1))
    {
      if (paramBoolean) {
        i1 = 2131893307;
      } else {
        i1 = 2131893475;
      }
      TipsUtil.a(this.al, 1033, this.aj.getString(i1));
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", i1, 0, "2", "", "", "");
      return true;
    }
    return false;
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.X, 1, "showPermissionDialog grantForAudioRecord(2) 09");
  }
  
  public void i(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLayoutModeChange --> ScreenType = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" , hasSetBigVideoView = ");
      ((StringBuilder)localObject2).append(this.am.k().w());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 3)
    {
      if (4 == this.am.X())
      {
        localObject1 = this.am.k().bi.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoViewInfo)((Iterator)localObject1).next();
          if (!((VideoViewInfo)localObject2).c) {
            ((VideoViewInfo)localObject2).e = true;
          }
        }
      }
      if (this.am.k().bi.size() > 0) {
        ((VideoViewInfo)this.am.k().bi.get(0)).e = true;
      }
    }
    else if (paramInt == 4)
    {
      if ((!this.am.k().w()) && (this.am.k().bi.size() > 0))
      {
        ((VideoViewInfo)this.am.k().bi.get(0)).c = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.X, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
        }
      }
      if (4 == this.am.X())
      {
        localObject1 = this.am.k().bi.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoViewInfo)((Iterator)localObject1).next();
          if (!((VideoViewInfo)localObject2).c) {
            ((VideoViewInfo)localObject2).e = true;
          }
        }
      }
      if (this.am.k().bi.size() > 0) {
        ((VideoViewInfo)this.am.k().bi.get(0)).e = true;
      }
    }
    K();
  }
  
  void j(int paramInt)
  {
    if ((paramInt != 6) && (paramInt != 8))
    {
      if (paramInt == 74) {
        return;
      }
      if (Utils.a(this.al.getApp()) == 1)
      {
        TipsUtil.a(this.al, 1012, this.al.getApp().getString(2131917890));
        ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
        ReportController.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e(this.X, 2, "startRecvAllVideo-->GLVersion not support");
        }
      }
    }
  }
  
  public void m(long paramLong) {}
  
  public void q()
  {
    super.q();
  }
  
  void r(long paramLong)
  {
    if ((this.am != null) && (this.am.j))
    {
      if (this.am.H())
      {
        super.m(2131441023);
        if (this.aA != null) {
          this.aA.b(this.am.H());
        }
      }
      this.am.K();
      if (this.am.k().i == 9)
      {
        f(paramLong, true);
        a_(paramLong, 2131893319);
      }
      else
      {
        f(paramLong, false);
        d(paramLong, null);
      }
      G(paramLong);
      this.aR.c(true);
      this.aR.b(true);
    }
  }
  
  protected boolean r()
  {
    if (this.am == null) {
      return false;
    }
    return this.am.k().k();
  }
  
  abstract void s();
  
  void s(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendVideoMsgBroadcast--> discussionId = ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.al != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddVideoMsg");
      ((Intent)localObject).putExtra("uinType", this.g);
      ((Intent)localObject).putExtra("msgType", 13);
      ((Intent)localObject).putExtra("isVideoMsg", false);
      ((Intent)localObject).putExtra("friendUin", Long.toString(paramLong));
      ((Intent)localObject).putExtra("senderUin", this.al.getCurrentAccountUin());
      ((Intent)localObject).putExtra("isSender", true);
      ((Intent)localObject).putExtra("isRead", true);
      ((Intent)localObject).putExtra("MultiAVType", this.am.k().o);
      ((Intent)localObject).setPackage(this.al.getApplication().getPackageName());
      this.al.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  protected void t(long paramLong)
  {
    if (V()) {
      return;
    }
    if (this.am.j)
    {
      this.aA.setViewEnable(2131441023, true);
      this.aA.b(2131441023, true);
      if (this.am.H()) {
        m(2131441023);
      } else {
        n(2131441023);
      }
      this.aA.b(this.am.H());
      N();
    }
    long l1 = this.j;
    this.al.b(this.g, String.valueOf(l1));
    f(paramLong, 16777215);
    G(paramLong);
  }
  
  protected abstract boolean t();
  
  protected abstract void u();
  
  boolean u(long paramLong)
  {
    if (this.am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "checkRemoteVideo --> VideoController is null");
      }
      return false;
    }
    SessionInfo localSessionInfo = this.am.k();
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRemoteVideo, displayViewList[");
      localStringBuilder.append(localSessionInfo.bi.size());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (localSessionInfo.bi.size() == 0)
    {
      a(paramLong, "checkRemoteVideo");
      a(false, false, false);
      return false;
    }
    if ((localSessionInfo.bi.size() == 1) && (((VideoViewInfo)localSessionInfo.bi.get(0)).a == this.k))
    {
      a(false, false, false);
      e("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  void v(long paramLong)
  {
    Context localContext = (Context)this.ak.get();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("goOnStageWithoutWiFiCheck, mContext[");
    boolean bool;
    if (localContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (localContext == null) {
      return;
    }
    int i1;
    if (this.am.k().t()) {
      i1 = 2131893462;
    } else {
      i1 = 2131893463;
    }
    DialogUtil.a(localContext, 230, null, this.aj.getString(i1), 2131893167, 2131893180, new MultiVideoCtrlLayerUIBase.8(this, paramLong), new MultiVideoCtrlLayerUIBase.9(this)).show();
  }
  
  void w(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("goOffStage, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if ((this.am != null) && (this.ao != null) && (this.aA != null))
    {
      this.am.ad();
      this.am.k().a(paramLong, "goOffStage", false, false);
      this.ao.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      b(2131441304, 8);
      localObject = U();
      if (localObject != null) {
        ((AVActivity)localObject).a(false);
      }
      a("goOffStage", paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "goOffStage --> Error");
    }
  }
  
  void x(long paramLong)
  {
    if ((this.aA.i()) && (!this.aA.j()))
    {
      QLog.d(this.X, 1, "intercept doMute operation");
      return;
    }
    boolean bool = this.am.H();
    long l1;
    if (this.am.j) {
      l1 = this.j;
    } else {
      l1 = this.i;
    }
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doMute, relationId[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], mute[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    int i1;
    if (bool)
    {
      if (g(true)) {
        return;
      }
      if (this.am.k().q)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.X, 1, "PhoneCalling-status not support open MIC");
        }
        return;
      }
      if (this.h == 2) {
        DataReport.a(true, 1);
      } else {
        DataReport.a(true, 10);
      }
      t(true);
      i1 = this.am.D();
      this.am.a("MultiVideoCtrlLayerUIBase.doMute.1", l1, true, true, -1);
      this.aA.a("MultiVideoCtrlLayerUIBase.doMute.1", i1, this.am.D(), false);
      super.n(2131441023);
      if (this.al != null) {
        this.al.a(new Object[] { Integer.valueOf(108) });
      }
    }
    else
    {
      if (this.h == 2) {
        DataReport.a(false, 1);
      } else {
        DataReport.a(false, 10);
      }
      t(false);
      i1 = this.am.D();
      this.am.a("MultiVideoCtrlLayerUIBase.doMute.2", l1, false, true, -1);
      this.aA.a("MultiVideoCtrlLayerUIBase.doMute.2", i1, this.am.D(), false);
      super.m(2131441023);
      if (this.al != null) {
        this.al.a(new Object[] { Integer.valueOf(109) });
      }
    }
  }
  
  protected void y(long paramLong)
  {
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_AIDenoise, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    boolean bool = SharedPreUtils.d() ^ true;
    k(bool);
    SharedPreUtils.c(bool);
    this.am.l(bool);
    f(paramLong, 16777215);
    DataReport.b(this.am, bool);
  }
  
  public void z(long paramLong)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("go on stage failed, info[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    b(2131441304, 8);
    Object localObject = U();
    if (localObject != null) {
      ((AVActivity)localObject).a(false);
    }
    f(l1, 16777215);
    if (paramLong == 7L) {
      TipsUtil.a(this.al, 1029);
    } else if (paramLong == 8L) {
      TipsUtil.a(this.al, 1033, this.aj.getString(2131893474));
    } else {
      TipsUtil.a(this.al, 1028);
    }
    if (this.h == 2) {
      ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */