package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AvCustomDialog;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class MultiIncomingCallsActivity
  extends BaseGaInvite
{
  public static boolean G = false;
  int A = -1;
  boolean B;
  long[] C = null;
  String D = "";
  int E = 0;
  boolean F = false;
  QAVNotification H;
  String I;
  GAudioUIObserver J = new MultiIncomingCallsActivity.12(this);
  VideoObserver K = new MultiIncomingCallsActivity.13(this);
  private long L = 0L;
  private boolean M = false;
  private ArrayList<Memberinfo> N = new ArrayList();
  private Runnable O = null;
  private InviteMemberObserverWithoutCache P = new MultiIncomingCallsActivity.1(this);
  private MqqHandler Q;
  private Runnable R = new MultiIncomingCallsActivity.2(this);
  private GAudioUIObserver S = new MultiIncomingCallsActivity.3(this);
  private BroadcastReceiver T = null;
  private boolean U = false;
  private BroadcastReceiver V = new MultiIncomingCallsActivity.4(this);
  private boolean W = false;
  private Runnable X = null;
  private Runnable Y = null;
  AvCustomDialog q = null;
  TextView r = null;
  MutiMemberThumbList s;
  Bitmap t = null;
  String u = null;
  String v = null;
  SessionInfo w = null;
  boolean x = false;
  boolean y = false;
  int z = 0;
  
  private void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.b) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.W = true;
      k();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void d(int paramInt)
  {
    boolean bool = this.f.b(this.d, this.b, paramInt);
    if (QLog.isColorLevel())
    {
      String str = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGAudioRoomMemList ");
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      QQToast.makeText(this, HardCodeUtil.a(2131904883), 1).show(getResources().getDimensionPixelSize(2131299920));
      finish();
    }
  }
  
  private void j()
  {
    MqqHandler localMqqHandler = this.Q;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacks(this.R);
      this.Q.postDelayed(this.R, 10000L);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.l;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyDataChange mHasCallFromMemberList:=");
      ((StringBuilder)localObject2).append(this.W);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    j();
    Object localObject3 = this.f.W();
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashSet();
    localObject3 = ((ArrayList)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (VideoController.GAudioFriends)((Iterator)localObject3).next();
      if (((VideoController.GAudioFriends)localObject4).a != this.c) {
        ((ArrayList)localObject1).add(localObject4);
      }
      ((Set)localObject2).add(Long.valueOf(((VideoController.GAudioFriends)localObject4).a));
    }
    int i = ((ArrayList)localObject1).size();
    localObject3 = this.N.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Memberinfo)((Iterator)localObject3).next();
      if (!((Set)localObject2).contains(Long.valueOf(((Memberinfo)localObject4).a)))
      {
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.a = ((Memberinfo)localObject4).a;
        localGAudioFriends.x = ((Memberinfo)localObject4).b;
        if (((Memberinfo)localObject4).a == this.e.getLongAccountUin())
        {
          ((ArrayList)localObject1).add(0, localGAudioFriends);
          i += 1;
        }
        else
        {
          ((ArrayList)localObject1).add(localGAudioFriends);
        }
      }
    }
    if (this.X != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.X);
      this.X = null;
    }
    this.X = new MultiIncomingCallsActivity.10(this, i, (ArrayList)localObject1);
    ThreadManager.getSubThreadHandler().post(this.X);
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.f == null) {
      return;
    }
    Object localObject = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeSession, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = Long.valueOf(CharacterUtil.b(this.u));
    if (this.x)
    {
      if (paramInt == 1)
      {
        this.f.a(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
      if (paramInt == 2) {
        this.f.a(paramLong, ((Long)localObject).longValue(), 2);
      }
    }
    else
    {
      localObject = this.w;
      if (localObject == null) {
        localObject = this.u;
      } else {
        localObject = ((SessionInfo)localObject).s;
      }
      this.f.a((String)localObject, 241);
      this.f.b(241);
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignoreMultiCall, refuse3rd[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], mVideoController[");
    boolean bool;
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.f == null) {
      return;
    }
    if (!paramBoolean2) {
      this.f.a(paramLong1, paramInt1, paramLong2, 10, false);
    } else {
      this.f.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
    if ((paramBoolean1) && (this.e != null)) {
      this.e.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
    }
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    h();
    boolean bool1 = ThemeUtil.isInNightMode(this.e);
    this.q = new AvCustomDialog(this, bool1);
    View localView = LayoutInflater.from(this).inflate(2131625718, null);
    if (b()) {
      localObject1 = (ViewStub)localView.findViewById(2131441201);
    } else {
      localObject1 = (ViewStub)localView.findViewById(2131441051);
    }
    if (localObject1 != null) {
      ((ViewStub)localObject1).inflate();
    }
    this.j = ((ImageView)localView.findViewById(2131441207));
    this.k = ((TextView)localView.findViewById(2131441206));
    this.k.setSingleLine();
    this.h = ((TextView)localView.findViewById(2131441211));
    this.r = ((TextView)localView.findViewById(2131441205));
    if (VideoUtils.a())
    {
      this.r.setText(2131893378);
      this.r.setTextColor(getResources().getColor(2131166775));
    }
    else if (this.e.t())
    {
      this.r.setText(2131887400);
      this.r.setTextColor(getResources().getColor(2131166775));
    }
    f();
    a(this.t, 4);
    if (b()) {
      this.k.setText(this.g);
    } else {
      a(this.k);
    }
    this.q.a(localView, false);
    if (b())
    {
      this.s = ((MutiMemberThumbList)localView.findViewById(2131441212));
      this.s.setBitMapFetcher(this.f);
      this.s.setRelationShipInfo(this.b, this.d);
      localObject2 = this.s;
      if (bool1) {
        localObject1 = "#757575";
      } else {
        localObject1 = "#878B99";
      }
      ((MutiMemberThumbList)localObject2).setTextColor((String)localObject1);
      this.s.setHeadImgMask(bool1);
      this.s.setMoreInfoDrawableColor("#F246505F");
      this.s.setDisPlayList(null);
      this.L = this.f.a(this.d, this.E, this.b);
      this.f.n.a(this.b, this.L, true);
      d(this.E);
    }
    Object localObject2 = (Button)localView.findViewById(2131441210);
    ((Button)localObject2).setOnClickListener(new MultiIncomingCallsActivity.6(this, paramLong));
    this.q.setOnCancelListener(new MultiIncomingCallsActivity.7(this, paramLong));
    this.q.setOnDismissListener(new MultiIncomingCallsActivity.8(this));
    SessionInfo localSessionInfo = SessionMgr.a().b();
    Object localObject1 = (Button)localView.findViewById(2131441204);
    ((Button)localObject1).setOnClickListener(new MultiIncomingCallsActivity.9(this, paramLong, paramIntent, localSessionInfo));
    if (b())
    {
      ((Button)localObject1).setText(2131893425);
      ((Button)localObject2).setText(2131893431);
    }
    else
    {
      ((Button)localObject1).setText(2131893425);
      ((Button)localObject2).setText(2131893432);
    }
    if ((!this.y) && (!this.x)) {
      ((Button)localObject1).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130843197), null, null, null);
    }
    boolean bool2 = b();
    if (bool1)
    {
      int j = Color.parseColor("#A8A8A8");
      int i;
      if (bool2) {
        i = 2131441203;
      } else {
        i = 2131441052;
      }
      localView.findViewById(i).setBackgroundDrawable(getResources().getDrawable(2130853291));
      paramIntent = localView.findViewById(2131441208);
      paramIntent.setBackgroundDrawable(UITools.a(67.199997F, this));
      paramIntent.setVisibility(0);
      this.k.setTextColor(j);
      this.h.setTextColor(j);
      this.r.setTextColor(j);
      localView.findViewById(2131431855).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130843123);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject2).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject2).setCompoundDrawablePadding(0);
      ((Button)localObject2).setTextColor(j);
      localView.findViewById(2131441214).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130843121);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject1).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject1).setCompoundDrawablePadding(0);
      ((Button)localObject1).setTextColor(j);
    }
    this.q.show();
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", new Object[] { this.u, this.v, Boolean.valueOf(this.x), Integer.valueOf(this.a), Integer.valueOf(this.d), Integer.valueOf(this.A), Boolean.valueOf(this.B), Boolean.valueOf(this.y), Integer.valueOf(this.z) }));
    }
    TraeHelper.a().a(paramLong, this.e, 2131230808, null, 0, null);
  }
  
  public void a(long paramLong, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    QAVGroupConfig.Report.a(true);
    sendBroadcast(new Intent("com.tencent.werewoves.plugin"));
    sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    c(1);
    if (VideoUtils.a())
    {
      sendBroadcast(new Intent("tencent.av.EXIT_QZONE_LIVE_REQ_ACTION"));
      return;
    }
    a(paramLong, "onClickAccept", paramIntent, paramSessionInfo);
    this.e.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.b), Integer.valueOf(3) });
    b("onClickAccept");
  }
  
  void a(long paramLong, String paramString, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    SessionInfo localSessionInfo = SessionMgr.a().b();
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptRequest, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], HandleSessionInfo[");
    localStringBuilder.append(paramSessionInfo);
    localStringBuilder.append("], CurMainSession[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("], mSessionInfo[");
    localStringBuilder.append(this.w);
    localStringBuilder.append("], SameSession[");
    boolean bool;
    if (paramSessionInfo == localSessionInfo) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], getAliveSessionCount[");
    localStringBuilder.append(SessionMgr.a().c());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.F = true;
    if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo) && (SessionMgr.a().c() >= 2))
    {
      this.f.o(true);
      if (paramSessionInfo.h())
      {
        a(paramLong, paramString, false, paramSessionInfo, -1);
      }
      else
      {
        this.f.a(true, 205, new int[] { localSessionInfo.o });
        this.f.b(205);
      }
      a(paramSessionInfo);
    }
    paramString = this.w;
    if ((paramString != null) && (!paramString.h()))
    {
      if (QLog.isColorLevel())
      {
        paramString = this.l;
        paramIntent = new StringBuilder();
        paramIntent.append("Session already destroyed, id:");
        paramIntent.append(this.w.f);
        paramIntent.append(", status = ");
        paramIntent.append(this.w.i);
        QLog.d(paramString, 2, paramIntent.toString());
      }
    }
    else
    {
      if (b())
      {
        g();
        return;
      }
      c(paramIntent);
    }
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignoreRequest[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], refuse3rd[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mainSessionInfo[");
    localStringBuilder.append(paramSessionInfo);
    localStringBuilder.append("], iFlag[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.F = false;
    }
    TraeHelper.b(this.e);
    paramString = this.u;
    boolean bool1 = this.x;
    int i = this.d;
    long l = this.b;
    if (!paramBoolean) {
      if (paramSessionInfo != null)
      {
        str = paramSessionInfo.s;
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = paramSessionInfo.aW;
        }
        bool1 = paramSessionInfo.am;
        i = paramSessionInfo.aQ;
        l = paramSessionInfo.aN;
      }
      else
      {
        return;
      }
    }
    int j = UITools.c(i);
    boolean bool2;
    if ((!paramBoolean) && ((bool1) || (a(j)))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (a(j))
    {
      a(paramLong, i, l, bool2, paramInt, paramBoolean);
      return;
    }
    a(paramLong, bool1, paramString, bool2, paramBoolean);
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.f == null)
    {
      QLog.d(this.l, 1, "refuseDoubleCall mVideoController is null");
      return;
    }
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refuseDoubleCall, isDoubleVideoMeeting[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], notifyDestroyUI[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], refuse3rd[");
    localStringBuilder.append(paramBoolean3);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean1)
    {
      this.f.a(paramLong, paramString, 1, true);
      long l2 = -1L;
      long l1;
      try
      {
        l1 = CharacterUtil.b(paramString);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d(this.l, 2, "", localNumberFormatException);
          l1 = l2;
        }
      }
      if (!paramBoolean3)
      {
        this.f.a(paramLong, 3, l1, 10, false);
        this.f.a(paramLong, l1, 23);
      }
      else
      {
        this.f.a(paramLong, 3, l1);
        this.f.a(paramLong, l1, 1);
      }
    }
    else
    {
      VideoController localVideoController = this.f;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallsActivity.11(this, localVideoController, paramString, paramBoolean3));
    }
    if ((paramBoolean2) && (this.e != null)) {
      this.e.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
    }
  }
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f = super.getResources().getDimensionPixelSize(2131298546);
    String str1;
    if (b())
    {
      String str2 = String.valueOf(this.b);
      str1 = super.getApplicationContext().getString(2131893269);
      int j = this.e.d(this.d, str2);
      int i = j;
      if (j == 0)
      {
        localObject = this.C;
        if (localObject != null) {
          i = localObject.length + 1;
        } else {
          i = 1;
        }
      }
      if (i > 999) {}
      for (j = super.getResources().getDimensionPixelSize(2131298548);; j = super.getResources().getDimensionPixelSize(2131298547))
      {
        f = j;
        break;
        if (i <= 99) {
          break;
        }
      }
      str2 = this.e.a(this.a, str2, null);
      str2 = UITools.a(super.getApplicationContext(), str2, paramTextView, f);
      str1 = String.format(str1, new Object[] { Integer.valueOf(i) });
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(str1);
      str1 = ((StringBuilder)localObject).toString();
    }
    else
    {
      str1 = this.g;
    }
    paramTextView.setText(str1);
  }
  
  void a(SessionInfo paramSessionInfo)
  {
    if ((this.f != null) && (paramSessionInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.e.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramSessionInfo.aN);
      localIntent.putExtra("peerUin", paramSessionInfo.s);
      this.e.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void b(Intent paramIntent)
  {
    long l = QQAudioHelper.d();
    this.d = 3;
    super.b(paramIntent);
    if (paramIntent == null) {
      return;
    }
    this.u = paramIntent.getStringExtra("peerUin");
    this.v = paramIntent.getStringExtra("extraUin");
    this.x = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.A = paramIntent.getIntExtra("memberType", -1);
    this.B = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.y = paramIntent.getBooleanExtra("isAudioMode", false);
    this.z = paramIntent.getIntExtra("bindType", 0);
    String str = SessionMgr.a(3, this.u, new int[0]);
    if (this.x)
    {
      str = SessionMgr.a(100, this.u, new int[0]);
      this.y = false;
    }
    if (b())
    {
      this.E = paramIntent.getIntExtra("MultiAVType", -1);
      if (this.E == 2) {
        this.y = false;
      } else {
        this.y = true;
      }
      this.D = paramIntent.getStringExtra("inviteId");
      str = SessionMgr.a(this.d, String.valueOf(this.b), new int[0]);
      this.C = paramIntent.getLongArrayExtra("memberList");
      int i = AVUtil.d(this.d);
      this.g = this.e.a(i, String.valueOf(this.c), String.valueOf(this.b));
      this.t = this.e.a(i, String.valueOf(this.c), this.v, true, true);
    }
    else
    {
      this.g = this.e.a(this.a, this.u, this.v);
      this.t = this.e.a(this.a, this.u, this.v, true, true);
    }
    this.w = SessionMgr.a().d(str);
    if (this.w == null)
    {
      b("processIntent_fail");
      return;
    }
    if (!d(paramIntent)) {
      a(l, paramIntent);
    }
  }
  
  void b(String paramString)
  {
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyUI[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    h();
    super.finish();
  }
  
  void c(int paramInt)
  {
    try
    {
      SessionInfo localSessionInfo = SessionMgr.a().b();
      if ((localSessionInfo != null) && (SessionMgr.a().c() >= 2))
      {
        int i = localSessionInfo.i;
        int j = localSessionInfo.e;
        Object localObject3 = null;
        StringBuilder localStringBuilder = null;
        Object localObject4 = null;
        Object localObject5 = null;
        Object localObject6 = null;
        Object localObject7 = null;
        Object localObject8 = null;
        Object localObject1 = null;
        if (localSessionInfo.am)
        {
          if (paramInt == 0)
          {
            localObject3 = "0X8005BAA";
          }
          else if (paramInt == 1)
          {
            localObject3 = "0X8005BAB";
          }
          else
          {
            localObject3 = localObject1;
            if (paramInt == 2) {
              localObject3 = "0X8005BAC";
            }
          }
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = this.l;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("double share, action:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", reportType:");
            localStringBuilder.append((String)localObject3);
            QLog.d((String)localObject1, 2, localStringBuilder.toString());
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          break;
          if ((localSessionInfo.aQ == 1) && (localSessionInfo.g == 3))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BB3";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BB4";
            }
            else
            {
              localObject3 = localStringBuilder;
              if (paramInt == 2) {
                localObject3 = "0X8005BB5";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.l;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("group audio, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.aQ == 1) && (localSessionInfo.g == 4))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BB6";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BB7";
            }
            else
            {
              localObject3 = localObject4;
              if (paramInt == 2) {
                localObject3 = "0X8005BB8";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.l;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("group video, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.aQ == 2) && (localSessionInfo.g == 3))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BAD";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BAE";
            }
            else
            {
              localObject3 = localObject5;
              if (paramInt == 2) {
                localObject3 = "0X8005BAF";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.l;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("discuss audio, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.aQ == 2) && (localSessionInfo.g == 4))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BB0";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BB1";
            }
            else
            {
              localObject3 = localObject6;
              if (paramInt == 2) {
                localObject3 = "0X8005BB2";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.l;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("discuss video, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.g != 2) && ((localSessionInfo.h != 2) || ((i != 1) && (i != 2))))
          {
            if ((localSessionInfo.g != 1) && ((localSessionInfo.h != 1) || ((i != 1) && (i != 2))))
            {
              localObject1 = localObject3;
              if (QLog.isColorLevel())
              {
                localObject1 = this.l;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("nothing, action:");
                localStringBuilder.append(paramInt);
                localStringBuilder.append(", reportType:");
                localStringBuilder.append(null);
                localStringBuilder.append("SessionType:");
                localStringBuilder.append(localSessionInfo.g);
                localStringBuilder.append(", BeginSessionType:");
                localStringBuilder.append(localSessionInfo.h);
                localStringBuilder.append(", sessionStatus:");
                localStringBuilder.append(j);
                localStringBuilder.append(", state:");
                localStringBuilder.append(i);
                QLog.d((String)localObject1, 2, localStringBuilder.toString());
                localObject1 = localObject3;
              }
            }
            else
            {
              if (paramInt == 0)
              {
                localObject3 = "0X8005BA4";
              }
              else if (paramInt == 1)
              {
                localObject3 = "0X8005BA5";
              }
              else
              {
                localObject3 = localObject7;
                if (paramInt == 2) {
                  localObject3 = "0X8005BA6";
                }
              }
              localObject1 = localObject3;
              if (QLog.isColorLevel())
              {
                localObject1 = this.l;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("double audio, action:");
                localStringBuilder.append(paramInt);
                localStringBuilder.append(", reportType:");
                localStringBuilder.append((String)localObject3);
                QLog.d((String)localObject1, 2, localStringBuilder.toString());
                localObject1 = localObject3;
              }
            }
          }
          else
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BA7";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BA8";
            }
            else
            {
              localObject3 = localObject8;
              if (paramInt == 2) {
                localObject3 = "0X8005BA9";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.l;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("double video, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
        }
        if (localObject1 != null) {
          ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        }
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void c(Intent paramIntent)
  {
    QLog.d(this.l, 1, "startVideoChatActivity");
    TraeHelper.a().c();
    if ((this.f != null) && (this.f.X)) {
      this.e.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject = this.w;
    String str = null;
    int i;
    if (localObject != null)
    {
      str = ((SessionInfo)localObject).aB;
      i = this.w.az;
      localObject = this.w.aH;
    }
    else
    {
      localObject = null;
      i = -1;
    }
    int j = paramIntent.getIntExtra("uinType", -1);
    boolean bool = paramIntent.getBooleanExtra("isAudioMode", false);
    if (this.x)
    {
      paramIntent = super.getIntent().getStringExtra("peerUin");
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", paramIntent);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.g);
    }
    else
    {
      localIntent.putExtra("uinType", j);
      localIntent.putExtra("bindType", i);
      localIntent.putExtra("bindId", str);
      localIntent.putExtra("uin", this.u);
      localIntent.putExtra("name", this.g);
      localIntent.putExtra("extraUin", this.v);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", bool);
      localIntent.putExtra("sig", (byte[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = this.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startVideoChatActivity: bindType = ");
        localStringBuilder.append(i);
        localStringBuilder.append(",bindId = ");
        localStringBuilder.append(str);
        localStringBuilder.append(",BindType = ");
        paramIntent = this.w;
        if (paramIntent == null) {
          paramIntent = "session info null";
        } else {
          paramIntent = Integer.valueOf(paramIntent.az);
        }
        localStringBuilder.append(paramIntent);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (j == 0) {
        localIntent.putExtra("isFriend", this.e.c(this.u));
      }
      if (bool) {
        localIntent.putExtra("sessionType", 1);
      } else {
        localIntent.putExtra("sessionType", 2);
      }
      localIntent.putExtra("isSender", false);
    }
    super.startActivity(localIntent);
    super.overridePendingTransition(2130772286, 2130772285);
  }
  
  public void d()
  {
    QAVNotification localQAVNotification = this.H;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.w.f);
    }
    c(2);
    a(QQAudioHelper.d(), "onInviteTimeOut", true, SessionMgr.a().b(), 8);
    b("onInviteTimeOut");
  }
  
  public boolean d(Intent paramIntent)
  {
    boolean bool2 = false;
    if (paramIntent == null) {
      return false;
    }
    long l = QQAudioHelper.d();
    String str1 = paramIntent.getAction();
    boolean bool1 = bool2;
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      String str2 = paramIntent.getStringExtra("session_id");
      localObject = this.w;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((SessionInfo)localObject).f;
      }
      if (TextUtils.equals(str2, (CharSequence)localObject))
      {
        a(l, paramIntent, SessionMgr.a().b());
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          paramIntent = this.l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkParamAndDoAction coming[");
          localStringBuilder.append(str2);
          localStringBuilder.append("], cur[");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("]");
          QLog.i(paramIntent, 2, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParamAndDoAction action[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void f()
  {
    if (this.h == null) {
      return;
    }
    this.h.setSingleLine();
    if (b())
    {
      localObject = a(this.d, this.b, null, this.y, true);
      this.h.setText((CharSequence)localObject);
      return;
    }
    if (this.x)
    {
      this.h.setText(2131893410);
      return;
    }
    Object localObject = this.h;
    int i;
    if (this.y) {
      i = 2131893423;
    } else {
      i = 2131893424;
    }
    ((TextView)localObject).setText(i);
  }
  
  void g()
  {
    QLog.d(this.l, 1, "startGActivity");
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.b));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.C);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.w.o);
    localIntent.putExtra("uin", String.valueOf(this.b));
    localIntent.putExtra("uinType", this.a);
    localIntent.putExtra("isFromInviteDialog", true);
    super.startActivity(localIntent);
  }
  
  void h()
  {
    AvCustomDialog localAvCustomDialog = this.q;
    if (localAvCustomDialog != null)
    {
      try
      {
        localAvCustomDialog.dismiss();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.q = null;
    }
  }
  
  void i()
  {
    if (this.H == null) {
      this.H = QAVNotification.a(this.e);
    }
    Object localObject;
    if (b())
    {
      if (this.w != null)
      {
        localObject = String.valueOf(this.b);
        Bitmap localBitmap = this.e.a(this.a, (String)localObject, null, true, true);
        String str = this.e.a(AVUtil.d(this.d), Long.toString(this.c), (String)localObject);
        this.H.a(this.w.f, str, localBitmap, (String)localObject, 57, this.a, 3);
      }
    }
    else
    {
      localObject = this.e.a(this.a, this.u, this.v, true, true);
      if ((!this.y) && (!this.x))
      {
        this.H.a(this.w.f, this.g, (Bitmap)localObject, null, 56, this.a, 2);
        return;
      }
      this.H.a(this.w.f, this.g, (Bitmap)localObject, null, 55, this.a, 1);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = QQAudioHelper.d();
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130853313);
    super.getWindow().addFlags(128);
    paramBundle = this.f.az();
    if ((paramBundle != null) && (paramBundle.a(this)))
    {
      this.M = true;
      return;
    }
    TraeHelper.a().b(l);
    b(super.getIntent());
    paramBundle = this.f.az();
    if (paramBundle != null) {
      paramBundle.a(getClass().getName(), getIntent());
    }
    if (this.e != null)
    {
      if (!b()) {
        this.e.a(this.K);
      }
      this.e.a(this.J);
      if (b())
      {
        this.Q = ThreadManager.getUIHandler();
        this.e.a(this.P);
        this.e.a(this.S);
        this.T = new MultiIncomingCallsActivity.5(this);
        registerReceiver(this.T, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    try
    {
      registerReceiver(this.V, paramBundle);
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    this.U = true;
    int i;
    if (b()) {
      i = 30000;
    } else {
      i = 60000;
    }
    b(i);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    G = false;
    QLog.d(this.l, 1, "onDestroy");
    h();
    this.t = null;
    if (this.e != null)
    {
      this.e.b(this.K);
      this.e.b(this.J);
      this.e.b(this.P);
      this.e.b(this.S);
    }
    BroadcastReceiver localBroadcastReceiver = this.T;
    if (localBroadcastReceiver != null)
    {
      try
      {
        unregisterReceiver(localBroadcastReceiver);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      this.T = null;
    }
    Object localObject1 = this.s;
    if (localObject1 != null) {
      ((MutiMemberThumbList)localObject1).a();
    }
    localObject1 = this.Q;
    if (localObject1 != null)
    {
      ((MqqHandler)localObject1).removeCallbacks(this.R);
      this.Q = null;
    }
    if (this.H != null)
    {
      localObject1 = SessionMgr.a().b();
      Object localObject2 = this.w;
      if (localObject2 != localObject1) {
        this.H.a(((SessionInfo)localObject2).f);
      }
      if (localObject1 != null) {
        this.H.c(((SessionInfo)localObject1).f);
      }
      if ((localObject1 != null) && (((SessionInfo)localObject1).f != null) && (!((SessionInfo)localObject1).f.equals(this.I))) {
        this.H.a(this.I);
      }
      this.H = null;
      if (QLog.isColorLevel())
      {
        localObject2 = this.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy main[");
        localStringBuilder.append(localObject1);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(this.w);
        localStringBuilder.append("], id[");
        localStringBuilder.append(this.I);
        localStringBuilder.append("]");
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
    }
    if ((this.e != null) && (!this.M)) {
      this.e.a(new Object[] { Integer.valueOf(707) });
    }
    try
    {
      if (this.U)
      {
        unregisterReceiver(this.V);
        this.U = false;
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
    }
    if (this.Y != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.Y);
      this.Y = null;
    }
    if (this.X != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.X);
      this.X = null;
    }
    if (this.O != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.O);
      this.O = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.F) && (paramInt == 4))
    {
      c(2);
      a(QQAudioHelper.d(), "onKeyDown", true, null, -1);
      b("onKeyDown");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "onNewIntent");
    }
    d(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    QLog.d(this.l, 1, "onPause");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    G = true;
    QLog.d(this.l, 1, "onResume");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    a(true);
    c(0);
    if (this.f != null)
    {
      this.f.t(this.u);
      this.f.a(MultiIncomingCallsActivity.class);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    QLog.d(this.l, 1, "onStart");
    if (this.w == null) {
      return;
    }
    if (this.H == null) {
      this.H = QAVNotification.a(this.e);
    }
    this.H.a(this.w.f);
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if ((localSessionInfo != null) && (!this.w.f.equals(localSessionInfo.f)))
    {
      this.e.a(false, null);
      this.H.b(localSessionInfo.f);
      this.I = localSessionInfo.f;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    QLog.d(this.l, 1, "onStop");
    if (!super.isFinishing())
    {
      i();
      this.e.a(true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity
 * JD-Core Version:    0.7.0.1
 */