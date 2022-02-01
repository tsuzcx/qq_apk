package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavUIABTestUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  boolean a = false;
  boolean b = false;
  boolean c = false;
  TextView d = null;
  ImageView e = null;
  QavInOutAnimation f = null;
  QAVNotification g = null;
  String h = null;
  long i;
  String j = null;
  long k = Long.valueOf(this.j).longValue();
  Runnable l = null;
  DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable m = new DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable(this);
  GAudioUIObserver n = new DoubleVideoMeetingCtrlUI.1(this);
  private boolean o = false;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    paramVideoAppInterface = this.am.k();
    if ((!paramVideoAppInterface.H) && (!paramVideoAppInterface.I)) {
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 3);
    } else {
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 4);
    }
    paramVideoAppInterface.p = 0;
    paramVideoAppInterface.t = this.al.a(0, paramVideoAppInterface.s, null);
  }
  
  private void w()
  {
    SessionInfo localSessionInfo = this.am.k();
    if (localSessionInfo.p == -1) {
      localSessionInfo.p = 0;
    }
    if (TextUtils.isEmpty(localSessionInfo.s)) {
      localSessionInfo.s = String.valueOf(this.i);
    }
    int i1 = localSessionInfo.p;
    String str1 = localSessionInfo.s;
    Bitmap localBitmap = this.al.a(i1, str1, null, true, true);
    String str2 = this.al.a(i1, str1, null);
    if (QLog.isColorLevel())
    {
      String str3 = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHeadBitmap, uinType[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], name[");
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      QLog.i(str3, 2, localStringBuilder.toString());
    }
    if (this.e == null) {
      this.e = ((ImageView)this.an.findViewById(2131441066));
    }
    if (this.d == null) {
      this.d = ((TextView)this.an.findViewById(2131441067));
    }
    this.e.setImageBitmap(localBitmap);
    if (!TextUtils.equals(this.d.getText().toString(), str2))
    {
      this.d.setText(str2);
      this.g.a(localSessionInfo.f, str2, localBitmap, String.valueOf(localSessionInfo.aN), 48, 0, localSessionInfo.g);
    }
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
    return false;
  }
  
  void a()
  {
    SessionInfo localSessionInfo = this.am.k();
    boolean bool = localSessionInfo.I;
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resumeVideo, remoteHasVideo[");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("], displayViewList[");
      ((StringBuilder)localObject2).append(localSessionInfo.bi.size());
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], \nsessionInfo[");
      ((StringBuilder)localObject2).append(localSessionInfo);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((localSessionInfo.g == 4) && (!localSessionInfo.H) && ((localSessionInfo.bi.size() == 0) || (!bool)))
    {
      localSessionInfo.a(l1, "resumeVideo", 3);
      QLog.w(this.X, 1, "resumeVideo, fix SessionType");
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new VideoViewInfo();
    ((VideoViewInfo)localObject2).a = Long.valueOf(localSessionInfo.s).longValue();
    ((VideoViewInfo)localObject2).b = 1;
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new VideoViewInfo();
    ((VideoViewInfo)localObject2).a = Long.valueOf(localSessionInfo.s).longValue();
    ((VideoViewInfo)localObject2).b = 2;
    ((ArrayList)localObject1).add(localObject2);
    this.ao.update(null, new Object[] { Integer.valueOf(104), localObject1 });
    localSessionInfo.b(this.k, 1);
    if (localSessionInfo.H)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "Go On Stage ");
      }
      this.am.ac();
    }
    if ((localSessionInfo.H) && (!localSessionInfo.I)) {
      this.c = true;
    }
    if (localSessionInfo.bi.size() > 0) {
      s();
    }
    ai();
  }
  
  void a(int paramInt)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("avSwitch, sessionType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.an.findViewById(2131432074);
    Object localObject2 = (AVActivity)this.ak.get();
    if (paramInt == 3)
    {
      this.e.setVisibility(0);
      this.d.setVisibility(0);
      this.ax.setVisibility(8);
      this.az.setVisibility(8);
      if (this.aE != null) {
        this.aE.a(0);
      }
      ai();
      this.aA.a(false);
      if (localObject2 != null)
      {
        ((AVActivity)localObject2).b(true);
        ((AVActivity)localObject2).f(true);
        ((AVActivity)localObject2).c(false);
      }
    }
    else if (paramInt == 4)
    {
      ((View)localObject1).setBackgroundColor(this.aj.getColor(2131168376));
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      this.ax.setVisibility(0);
      this.az.setVisibility(0);
      if (this.aE != null) {
        this.aE.a(8);
      }
      this.aA.a(true);
      if (localObject2 != null)
      {
        ((AVActivity)localObject2).b(false);
        ((AVActivity)localObject2).f(false);
        ((AVActivity)localObject2).c(true);
      }
      bool1 = true;
      break label302;
    }
    boolean bool1 = false;
    label302:
    boolean bool2;
    if (this.am.k().g == 3) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.aR.c(bool2);
    this.aR.b(bool2);
    a(Boolean.valueOf(bool1));
    f(l1, 16777215);
    this.al.a(new Object[] { Integer.valueOf(102) });
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
  }
  
  void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, relationId[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], friendUin[");
      ((StringBuilder)localObject2).append(paramLong3);
      ((StringBuilder)localObject2).append("], refreshType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], isAVActivityBackground[");
      ((StringBuilder)localObject2).append(this.am.k().bz);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.am.k().bz) {
      return;
    }
    Object localObject1 = new DoubleVideoMeetingCtrlUI.RefreshUIRunnable(this, paramLong1, paramInt, paramLong3, paramLong2);
    Object localObject2 = (AVActivity)this.ak.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "refreshUI-->Can not get AVActivity");
      }
      return;
    }
    ((AVActivity)localObject2).runOnUiThread((Runnable)localObject1);
  }
  
  public void a(long paramLong, View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick, id[");
      ((StringBuilder)localObject2).append(AudioHelper.a(paramView, paramView.getId()));
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.am.k();
    Object localObject1 = ((SessionInfo)localObject2).s;
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel())
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Error View Id.ID=");
        ((StringBuilder)localObject2).append(paramView.getId());
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return;
      }
      break;
    case 2131893082: 
      i(paramLong, paramView);
      return;
    case 2131893080: 
      this.o = true;
      f(paramLong, paramView);
      return;
    case 2131893078: 
      QLog.d(this.X, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "onClick in meeting");
      }
      DoubleVideoCtrlUI.a(U(), this.al, true);
      super.I(paramLong);
      ReportController.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
      if (SmallScreenUtils.g())
      {
        paramView = (Context)this.ak.get();
        if ((paramView != null) && ((paramView instanceof AVActivity)))
        {
          paramView = (AVActivity)paramView;
          if (paramView != null)
          {
            paramView = paramView.o();
            if (paramView != null)
            {
              paramView.d();
              return;
            }
          }
        }
      }
      break;
    case 2131441310: 
      paramView = this.X;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClick, switch_camera, seq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("]");
      QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
      this.al.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      return;
    case 2131441304: 
      h(paramLong, paramView);
      return;
    case 2131441300: 
    case 2131893073: 
      e(paramLong, paramView);
      return;
    case 2131441023: 
      d(paramLong, paramView);
      return;
    case 2131441022: 
      QLog.d(this.X, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
      int i1 = ((SessionInfo)localObject2).p;
      paramView = ((SessionInfo)localObject2).t;
      this.am.a(i1, (String)localObject1, paramView, null, true);
      return;
    case 2131441020: 
      QLog.d(this.X, 1, "avideo onClick QavPanel.ViewID.HIDE");
      o();
      ReportController.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (((SessionInfo)localObject2).H)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
    case 2131441016: 
    case 2131441017: 
      QLog.d(this.X, 1, "onClick QavPanel.ViewID.HANG_UP");
      i(true);
      a(paramLong, (SessionInfo)localObject2, 1);
      return;
    case 2131441014: 
      QLog.d(this.X, 1, "onClick QavPanel.ViewID.HAND_FREE");
      this.aQ.a(TraeHelper.l);
      if ((((SessionInfo)localObject2).aG) && (((SessionInfo)localObject2).aF != null)) {
        ReportController.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
      super.I(paramLong);
      return;
    case 2131428836: 
    case 2131431769: 
    case 2131441303: 
    case 2131449444: 
      at();
    }
  }
  
  @TargetApi(21)
  public void a(long paramLong, SessionInfo paramSessionInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeChat, from[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], session[");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.am.aF();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(2);
    }
    localObject = U();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((AVActivity)localObject).v();
    }
    if (localObject != null) {
      ((ScreenRecordHelper)localObject).b(1);
    }
    localObject = this.f;
    boolean bool = paramSessionInfo.bz;
    int i2 = 0;
    if ((!bool) && (localObject != null))
    {
      int i1 = i2;
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            i1 = i2;
          }
          else
          {
            paramSessionInfo.a(paramLong, 0L);
            i1 = 12;
            l(43);
          }
        }
        else
        {
          paramSessionInfo.a(paramLong, 0L);
          l(3);
          i1 = 3;
        }
      }
      if (i1 != 0)
      {
        this.al.a().postDelayed(new DoubleVideoMeetingCtrlUI.4(this, paramLong, i1), 1000L);
        return;
      }
      ((QavInOutAnimation)localObject).a(new DoubleVideoMeetingCtrlUI.5(this, paramLong, i1));
      return;
    }
    d(paramLong, 0);
  }
  
  void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "notifyShowVideo-->info list is null");
      }
      return;
    }
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      if ((((VideoViewInfo)paramArrayList.get(i1)).a == this.k) && (!this.am.k().H))
      {
        paramArrayList.remove(i1);
        break;
      }
      i1 += 1;
    }
    this.ao.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
    if (this.e.getVisibility() == 0) {
      a(this.am.k().g);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateWhenCreateOrEnterRoomSuc, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], create[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.am == null) {
      return;
    }
    Object localObject1 = this.am.k();
    ((SessionInfo)localObject1).e("onEnterRoomSuc", true);
    ((SessionInfo)localObject1).bv = true;
    if (TextUtils.isEmpty(((SessionInfo)localObject1).s)) {
      ((SessionInfo)localObject1).s = String.valueOf(((SessionInfo)localObject1).aN);
    }
    this.am.a(3, 0, true, true, ((SessionInfo)localObject1).s);
    u();
    Object localObject2 = (AVActivity)this.ak.get();
    if ((localObject2 != null) && (!((AVActivity)localObject2).isFinishing())) {
      ((AVActivity)localObject2).runOnUiThread(new DoubleVideoMeetingCtrlUI.6(this, (AVActivity)localObject2, paramBoolean, paramLong));
    }
    if (((SessionInfo)localObject1).cn) {
      this.al.a().postDelayed(new DoubleVideoMeetingCtrlUI.7(this, paramLong), 500L);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterOpenCamera, success[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], preSessionType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (V()) {
      return;
    }
    Object localObject = this.am.k();
    if (((SessionInfo)localObject).bz) {
      return;
    }
    f(paramLong, 16777215);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "Go On Stage onAfterOpenCamera");
      }
      this.am.ac();
      if ((!((SessionInfo)localObject).I) && (this.aA != null)) {
        a(((SessionInfo)localObject).g);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.X, 2, "Open Camera Failed");
    }
  }
  
  void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showOrClosePeerVideo, bShow[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], videoSrcType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], friendUin[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    r(paramLong1);
    if (!this.am.k().I) {
      f("showOrClosePeerVideo");
    }
    if (paramBoolean)
    {
      d("showOrClosePeerVideo");
      return;
    }
    Object localObject1 = new VideoViewInfo();
    ((VideoViewInfo)localObject1).a = paramLong2;
    ((VideoViewInfo)localObject1).b = paramInt;
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    this.ao.update(null, new Object[] { Integer.valueOf(104), localObject2 });
    if (paramInt == 2) {
      TipsUtil.b(this.al, 1036);
    }
    if (this.am.k().bi.size() > 0)
    {
      d("showOrClosePeerVideo");
      return;
    }
    this.am.k().a(paramLong1, "showOrClosePeerVideo", false, true);
    a(this.am.k().g);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      g(-1L, 8);
    }
    aA_();
    super.a(paramBoolean);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      ??? = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onVideoViewChange-->BigViewUin = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" ,BigViewVideoSrcType = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" ,SmallViewUin = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" ,SmallViewVideoSrcType = ");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)???, 2, ((StringBuilder)localObject2).toString());
    }
    long l1 = AVUtil.c(paramString1);
    long l2 = AVUtil.c(paramString2);
    if (l1 != 0L)
    {
      if (l2 == 0L) {
        return;
      }
      if (paramInt1 == 2) {
        TipsUtil.b(this.al, 1036);
      }
      paramInt1 = this.am.k().b(l1, paramInt1);
      paramInt2 = this.am.k().b(l2, paramInt2);
      if (QLog.isColorLevel())
      {
        paramString1 = this.X;
        paramString2 = new StringBuilder();
        paramString2.append("onVideoViewChange-->BigViewIndex = ");
        paramString2.append(paramInt1);
        paramString2.append(" ,SmallViewIndex = ");
        paramString2.append(paramInt2);
        QLog.d(paramString1, 2, paramString2.toString());
      }
      if (paramInt1 != -1)
      {
        if (paramInt2 == -1) {
          return;
        }
        paramString1 = (VideoViewInfo)this.am.k().bi.get(paramInt1);
        paramString2 = (VideoViewInfo)this.am.k().bi.get(paramInt2);
        paramString2.c = true;
        paramString1.c = false;
        this.am.k().bi.set(paramInt1, paramString2);
        this.am.k().bi.set(paramInt2, paramString1);
        if (QLog.isColorLevel())
        {
          ??? = this.am.a(this.am.k().bi);
          localObject2 = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onVideoViewChange finish");
          localStringBuilder.append((String)???);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        synchronized (this.am.k().bk)
        {
          this.am.k().bk.set(paramInt1, paramString2);
          this.am.k().bk.set(paramInt2, paramString1);
          this.am.k().C();
          ((AVActivity)this.ak.get()).L.a(paramString1.a, paramString1.b, paramString2.a, paramString2.b);
          s();
          if (l2 == this.k)
          {
            ReportController.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
            return;
          }
          if (l2 == this.i)
          {
            ReportController.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
            if (this.b)
            {
              ReportController.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
          }
          return;
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quitDoubleVideoMeeting, needAnimation[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      m();
      this.am.a(l1, this.i, false, 2);
      this.a = true;
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if ((paramInt != 24) && (paramInt != 25)) {
        return false;
      }
      this.aQ.b();
      return false;
    }
    if (this.am.k().H)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  public void aA_()
  {
    int i1 = this.am.k().bi.size();
    int i2 = 0;
    if (i1 <= 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.am.k().bM == 4) {
      i2 = 1;
    }
    boolean bool = ab();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.az.getLayoutParams();
    if ((bool) && ((i1 != 0) || (i2 != 0))) {
      i1 = AIOUtils.b(43.0F, this.az.getResources());
    } else {
      i1 = AIOUtils.b(20.0F, this.az.getResources());
    }
    if (i1 != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i1;
      this.az.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a_(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], quit[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.a_(paramLong);
    if (this.am != null)
    {
      this.am.k().bz = true;
      this.am.k().by = true;
      if (((!SmallScreenUtils.g()) || ((!NetworkUtil.isWifiConnected((Context)this.ak.get())) && (!this.am.k().bA))) && (this.am.k().H))
      {
        this.am.ad();
        this.ao.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (this.aA != null) {
          this.aA.setViewVisibility(2131441310, 8);
        }
        this.am.k().M = true;
      }
      if (this.am.k().an) {
        super.H(paramLong);
      }
      f("OnPause");
      if ((this.a) || (!SmallScreenUtils.g())) {
        this.am.f("Meeting_onPause");
      }
      this.am.k().b(this.k, true, true);
    }
    this.al.e("DoubleVideoMeetingCtrlUI");
    this.al.a().removeCallbacks(this.bg);
    this.al.a().removeCallbacks(this.m);
  }
  
  protected int b()
  {
    return 2131625719;
  }
  
  public int b(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.al, paramInt);
    return 0;
  }
  
  public void b(long paramLong)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = true;
    Object localObject;
    if (bool1)
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    super.b(paramLong);
    q();
    this.am.k().bz = false;
    this.am.k().by = false;
    if (this.am.k().an)
    {
      if ((this.am.k().k()) || (this.am.k().l())) {
        super.G(paramLong);
      }
      localObject = this.aR;
      if (this.am.k().g == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SensorHelper)localObject).c(bool1);
      localObject = this.aR;
      if (this.am.k().g == 3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((SensorHelper)localObject).b(bool1);
      a();
      d();
    }
    this.al.b(0, this.h);
  }
  
  public void b(long paramLong, int paramInt)
  {
    a(paramLong, 360 - paramInt);
  }
  
  void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.al.a(new Object[] { Integer.valueOf(28), String.valueOf(this.i), Boolean.valueOf(paramBoolean) });
    if (this.a) {
      t();
    }
  }
  
  void c()
  {
    super.c();
    if (this.aA != null)
    {
      this.aA.a(2131625783);
      this.aA.d();
      Activity localActivity = (Activity)this.ak.get();
      if (localActivity != null)
      {
        this.aQ = TraeHelper.a();
        this.aA.a(this.aQ);
        this.aR = SensorHelper.a(this.aR, localActivity, this.am, this.aQ);
        this.aR.a(true);
        this.aQ.b();
      }
    }
    this.aN = ((ImageView)this.an.findViewById(2131441046));
    if ((AVActivity)this.ak.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "initUI-->activity is null");
      }
      b(true);
      return;
    }
    this.f = new QavInOutAnimation((Context)this.ak.get(), this.am, 2, this.aA, this.aB, null, this.an.findViewById(2131441065), this.d, this.an.findViewById(2131441196), null);
  }
  
  void c(int paramInt)
  {
    if (paramInt > 0) {
      a_(-1016L, paramInt);
    }
  }
  
  public void c(long paramLong)
  {
    boolean bool;
    if ((this.Y != 4) && (this.o)) {
      bool = true;
    } else {
      bool = false;
    }
    this.o = false;
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]interceptStopAction:=");
      localStringBuilder.append(bool);
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (!bool) {
      super.c(paramLong);
    }
    if (this.am != null) {
      this.am.k().bz = true;
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (V()) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    if (!localSessionInfo.I)
    {
      a(localSessionInfo.g);
      return;
    }
    f(paramLong, 16777215);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "resumeUI");
    }
    if (!this.am.k().an) {
      return;
    }
    if (this.am.H()) {
      super.m(2131441023);
    } else {
      super.n(2131441023);
    }
    a(this.am.k().g);
    b_(0L);
  }
  
  public void d(int paramInt)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showToolBars, isAllOnstageMembersNotRecvData[");
      localStringBuilder.append(this.am.k().q());
      localStringBuilder.append("], mToolbarDisplay[");
      localStringBuilder.append(this.af);
      localStringBuilder.append("], session[");
      localStringBuilder.append(this.am.k());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (!this.am.k().q())
    {
      super.f(paramInt);
      I(l1);
    }
  }
  
  public void d(long paramLong)
  {
    Object localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.al.b(this.n);
    this.aR.c(false);
    this.aR.b(false);
    if (this.an != null) {
      this.an.removeAllViews();
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.f = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    TraeHelper.a().b(paramLong);
    if (!this.am.k().aK) {
      super.I(paramLong);
    }
    this.a = true;
    this.am.a(paramLong, this.i, true, paramInt);
    super.H(paramLong);
    b(true);
    ReportController.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
  }
  
  void d(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", null))
    {
      boolean bool = this.am.H();
      t(bool);
      int i1;
      if (bool)
      {
        i1 = this.am.D();
        this.am.a("DoubleVideoMeetingCtrlUI.doMute.1", this.i, true);
        this.aA.a("DoubleVideoMeetingCtrlUI.doMute.1", i1, this.am.D(), false);
        super.n(2131441023);
        if (this.al != null) {
          this.al.a(new Object[] { Integer.valueOf(108) });
        }
        ReportController.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
      }
      else
      {
        i1 = this.am.D();
        this.am.a("DoubleVideoMeetingCtrlUI.doMute.2", this.i, false);
        this.aA.a("DoubleVideoMeetingCtrlUI.doMute.2", i1, this.am.D(), false);
        super.m(2131441023);
        if (this.al != null) {
          this.al.a(new Object[] { Integer.valueOf(109) });
        }
        ReportController.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
      }
    }
    super.I(paramLong);
  }
  
  void d(String paramString)
  {
    this.m.a = paramString;
    this.al.a().removeCallbacks(this.m);
    this.al.a().postDelayed(this.m, 1000L);
  }
  
  public void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void e(int paramInt) {}
  
  void e(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", null))
    {
      paramView = this.am.k();
      paramView.cn = false;
      StringBuilder localStringBuilder;
      if (!paramView.H)
      {
        p(paramLong);
        this.al.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
        if (QLog.isColorLevel())
        {
          paramView = this.X;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClick, Open Camera, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w(paramView, 1, localStringBuilder.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramView = this.X;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClick, Close Camera, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w(paramView, 1, localStringBuilder.toString());
        }
        m(paramLong);
        this.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        q(paramLong);
      }
      I(paramLong);
    }
    i(paramLong, 2131893073);
  }
  
  void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addRequestVideoTimeoutRunnable,Function = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.l == null) {
      this.l = new DoubleVideoMeetingCtrlUI.RequestVideoTimeoutRunnale(this);
    } else {
      this.al.a().removeCallbacks(this.l);
    }
    this.al.a().postDelayed(this.l, 30000L);
  }
  
  void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showOrHideAcceptBtn-->isShow = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.ba != null) {
      this.ba.a(paramBoolean, new DoubleVideoMeetingCtrlUI.3(this));
    }
    if (paramBoolean)
    {
      TipsUtil.a(this.al, 1030);
      return;
    }
    TipsUtil.b(this.al, 1030);
  }
  
  public void f(long paramLong, View paramView)
  {
    super.f(paramLong, paramView);
    ScreenShareReportHelper.b("0X800AD8D");
  }
  
  void f(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRequestVideoTimeoutRunnbale-->Function = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.l != null) {
      this.al.a().removeCallbacks(this.l);
    }
  }
  
  void h(long paramLong)
  {
    Object localObject = (AVActivity)this.ak.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "processExtraData-->can not get the activity");
      }
      b(true);
      return;
    }
    localObject = ((AVActivity)localObject).getIntent();
    boolean bool;
    if (localObject != null) {
      bool = ((Intent)localObject).getBooleanExtra("isEnter", false);
    } else {
      bool = false;
    }
    localObject = SessionMgr.a(100, String.valueOf(this.i), new int[0]);
    localObject = SessionMgr.a().d((String)localObject);
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processExtraData uin[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("], info[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((!bool) && ((localObject == null) || (!((SessionInfo)localObject).h())))
    {
      if ((localObject == null) || (((SessionInfo)localObject).i == 0))
      {
        localObject = this.am;
        long l1 = this.i;
        ((VideoController)localObject).a(3, l1, 8, new long[] { l1 }, false);
        a_(paramLong, 2131893616);
      }
    }
    else
    {
      TraeHelper.a().b(paramLong);
      TraeHelper.b(this.al);
      if ((localObject != null) && (((SessionInfo)localObject).i == 0))
      {
        b(true);
        return;
      }
      this.am.a(paramLong, 3, this.i, null, false);
      a_(paramLong, 2131893262);
    }
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
    aA_();
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
    s();
  }
  
  void m()
  {
    super.aa();
    this.aA.a(this.ar);
  }
  
  public void m(long paramLong) {}
  
  void n()
  {
    i(true);
    QavInOutAnimation localQavInOutAnimation = this.f;
    if (localQavInOutAnimation != null) {
      localQavInOutAnimation.a(new DoubleVideoMeetingCtrlUI.2(this));
    }
  }
  
  public boolean o()
  {
    Object localObject = this.am.k().s;
    this.al.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if (!SmallScreenUtils.g())
    {
      if ((this.am.k().g == 4) && (this.am.k().H))
      {
        super.a(2131893252, 1, this.aj.getDimensionPixelSize(2131299920));
        return false;
      }
    }
    else
    {
      localObject = (Context)this.ak.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).o();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).a();
          }
        }
      }
    }
    return false;
  }
  
  public void p(long paramLong)
  {
    f(paramLong, 16777215);
  }
  
  public void q()
  {
    super.q();
    w();
  }
  
  void q(long paramLong)
  {
    this.am.ad();
    f(paramLong, 16777215);
  }
  
  protected boolean r()
  {
    VideoController localVideoController = this.am;
    boolean bool1 = false;
    if (localVideoController == null) {
      return false;
    }
    boolean bool3 = this.am.k().k();
    boolean bool2 = this.am.k().l();
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean r(long paramLong)
  {
    if (this.am.k().bi.size() == 0)
    {
      this.am.k().a(paramLong, "checkRemoteHasVideo.1", false, true);
      return false;
    }
    if ((this.am.k().bi.size() == 1) && (((VideoViewInfo)this.am.k().bi.get(0)).a == this.k))
    {
      this.am.k().a(paramLong, "checkRemoteHasVideo.2", false, true);
      return false;
    }
    this.am.k().a(paramLong, "checkRemoteHasVideo.3", true, true);
    return true;
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "request peer video");
    }
    if (this.am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "requestPeerVideo-->ERROR mVideoControl is NULL");
      }
      return;
    }
    if (this.am.k().bi.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "Peer VideoInfoList Size is null");
      }
      this.am.f("Meeting_requestPeerVideo");
      return;
    }
    this.am.k().bl.clear();
    int i1 = 0;
    while (i1 < this.am.k().bi.size())
    {
      if (((VideoViewInfo)this.am.k().bi.get(i1)).a != this.k) {
        this.am.k().bl.add(this.am.k().bi.get(i1));
      }
      i1 += 1;
    }
    e(false);
    this.am.b(false);
  }
  
  public void t()
  {
    if (this.am == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.X, 2, "cancelNotification");
    }
    QAVNotification localQAVNotification = this.g;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.am.k().f);
    }
    this.am.Z();
  }
  
  public void u()
  {
    if (this.am == null) {
      return;
    }
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.X;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showNotification quit[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("], inMeetingRoom[");
      ((StringBuilder)localObject).append(this.am.k().an);
      ((StringBuilder)localObject).append("]");
      QLog.i(str, 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.a) && (this.am.k().an) && (!SessionMgr.a().d()))
    {
      str = this.am.k().t;
      localObject = this.al.a(0, this.am.k().s, null, true, true);
      this.g.a(this.am.k().f, str, (Bitmap)localObject, String.valueOf(this.am.k().aN), 48, 0, this.am.k().g);
      this.am.Y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */