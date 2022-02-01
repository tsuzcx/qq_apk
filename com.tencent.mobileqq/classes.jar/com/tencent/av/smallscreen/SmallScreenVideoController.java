package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.av.AVLog;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;

public class SmallScreenVideoController
  implements SmallScreenVideoLayerUI.SmallScreenListener
{
  CameraObserver A = new SmallScreenVideoController.2(this);
  GAudioUIObserver B = new SmallScreenVideoController.3(this);
  boolean C = false;
  SmallScreenVideoController.MyVideoObserver D = new SmallScreenVideoController.MyVideoObserver(this);
  Display a = null;
  SmallScreenService b;
  Context c = null;
  int d = -1;
  Timer e = null;
  int f = 1;
  int g = 0;
  int h = 0;
  int i = -1;
  int j = 0;
  String k = null;
  String l = null;
  String m = null;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  boolean q = false;
  VideoAppInterface r = null;
  VideoController s = null;
  SmallScreenVideoControlUI t;
  SmallScreenVideoLayerUI u;
  ICameraManagerApi v;
  Bitmap w = null;
  AbstractOrientationEventListener x = null;
  int y = 0;
  ControlUIObserver z = new SmallScreenVideoController.MyControlUIObserver(this);
  
  SmallScreenVideoController(SmallScreenService paramSmallScreenService)
  {
    this.b = paramSmallScreenService;
    this.c = paramSmallScreenService.getApplicationContext();
    this.a = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
  }
  
  public static void a(Context paramContext, VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo start");
    }
    if ((paramContext != null) && (paramVideoController != null))
    {
      if (MultiIncomingCallsActivity.G)
      {
        paramVideoController = new Intent(paramContext, MultiIncomingCallsActivity.class);
        paramVideoController.addFlags(262144);
        paramVideoController.addFlags(268435456);
        paramVideoController.addFlags(4194304);
        try
        {
          paramContext.startActivity(paramVideoController);
        }
        catch (Exception paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label134;
          }
        }
        paramVideoController = new StringBuilder();
        paramVideoController.append("enterVideo e = ");
        paramVideoController.append(paramContext);
        QLog.e("SmallScreenVideoController", 2, paramVideoController.toString());
      }
      else
      {
        b(paramContext, paramVideoController);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo context or controller is null.");
    }
    label134:
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo end");
    }
  }
  
  private void a(SessionInfo paramSessionInfo)
  {
    int i1 = this.g;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if ((i1 != 3) && (i1 != 4)) {
            return;
          }
          if (this.t == null) {
            if (this.q)
            {
              this.t = new SmallScreenMultiVideoControlUI(this.r, this.b, this.z);
              if (paramSessionInfo != null)
              {
                this.g = paramSessionInfo.g;
                this.h = paramSessionInfo.h;
              }
            }
            else
            {
              if (this.s.k().o == 2)
              {
                this.t = new SmallScreenMultiVideoControlUI(this.r, this.b, this.z);
                return;
              }
              this.t = new SmallScreenMultiVideoControlUI(this.r, this.b, this.z);
            }
          }
        }
        else if (this.q)
        {
          this.t = new SmallScreenMultiVideoControlUI(this.r, this.b, this.z);
          if (paramSessionInfo != null)
          {
            this.g = paramSessionInfo.g;
            this.h = paramSessionInfo.h;
          }
        }
        else
        {
          this.t = new SmallScreenDoubleVideoControlUI(this.r, this.b, this.z);
        }
      }
      else if (this.t == null) {
        if (this.q)
        {
          this.t = new SmallScreenMultiVideoControlUI(this.r, this.b, this.z);
          if (paramSessionInfo != null)
          {
            this.g = paramSessionInfo.g;
            this.h = paramSessionInfo.h;
          }
        }
        else
        {
          this.t = new SmallScreenDoubleVideoControlUI(this.r, this.b, this.z);
        }
      }
    }
    else if ((paramSessionInfo != null) && (paramSessionInfo.B) && ((paramSessionInfo.i == 1) || (paramSessionInfo.i == 2))) {
      this.t = new SmallScreenDoubleVideoControlUI(this.r, this.b, this.z);
    }
  }
  
  private static void b(Context paramContext, VideoController paramVideoController)
  {
    Object localObject = paramVideoController.k();
    int i1 = ((SessionInfo)localObject).g;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterVideo sessionType =");
      localStringBuilder.append(i1);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    if ((i1 != 1) && (i1 != 2))
    {
      long l2 = ((SessionInfo)localObject).aN;
      int i2 = ((SessionInfo)localObject).aQ;
      long l1 = 0L;
      if (l2 != 0L)
      {
        if (((SessionInfo)localObject).h())
        {
          try
          {
            l2 = Long.parseLong(((SessionInfo)localObject).aW);
            l1 = l2;
          }
          catch (Throwable paramVideoController)
          {
            paramVideoController.printStackTrace();
          }
          paramVideoController = new Intent(paramContext, GaInviteLockActivity.class);
          BaseGaInvite.a(paramVideoController, "SmallScreenInvite");
          paramVideoController.addFlags(268435456);
          paramVideoController.putExtra("uinType", ((SessionInfo)localObject).p);
          paramVideoController.putExtra("peerUin", ((SessionInfo)localObject).aW);
          paramVideoController.putExtra("friendUin", l1);
          paramVideoController.putExtra("relationType", ((SessionInfo)localObject).aQ);
          paramVideoController.putExtra("MultiAVType", ((SessionInfo)localObject).o);
          paramVideoController.putExtra("discussId", ((SessionInfo)localObject).aN);
          paramVideoController.putExtra("memberList", ((SessionInfo)localObject).aO);
          paramVideoController.putExtra("session_id", ((SessionInfo)localObject).f);
        }
        else
        {
          paramVideoController = new Intent(paramContext, AVActivity.class);
          paramVideoController.addFlags(262144);
          paramVideoController.addFlags(268435456);
          paramVideoController.addFlags(4194304);
          paramVideoController.putExtra("GroupId", String.valueOf(l2));
          paramVideoController.putExtra("Type", 2);
          paramVideoController.putExtra("sessionType", i1);
          paramVideoController.putExtra("uinType", UITools.c(i2));
          paramVideoController.putExtra("isDoubleVideoMeeting", ((SessionInfo)localObject).am);
          paramVideoController.putExtra("MultiAVType", ((SessionInfo)localObject).o);
          paramVideoController.putExtra("Fromwhere", "SmallScreen");
        }
        try
        {
          paramContext.startActivity(paramVideoController);
          return;
        }
        catch (Exception paramContext)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        paramVideoController = new StringBuilder();
        paramVideoController.append("enterVideo e = ");
        paramVideoController.append(paramContext);
        QLog.e("SmallScreenVideoController", 2, paramVideoController.toString());
      }
      else
      {
        if ((paramVideoController.l()) && (((SessionInfo)localObject).g()))
        {
          paramVideoController = new Intent(paramContext, VideoInviteActivity.class);
          paramVideoController.addFlags(268435456);
          paramVideoController.putExtra("uinType", ((SessionInfo)localObject).p);
          paramVideoController.putExtra("peerUin", ((SessionInfo)localObject).s);
          paramVideoController.putExtra("extraUin", ((SessionInfo)localObject).u);
          boolean bool;
          if (((SessionInfo)localObject).h == 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramVideoController.putExtra("isAudioMode", bool);
          paramContext.startActivity(paramVideoController);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
        }
      }
    }
    else
    {
      paramVideoController = new Intent(paramContext, AVActivity.class);
      if (((SessionInfo)localObject).p == 1011) {
        return;
      }
      paramVideoController.addFlags(262144);
      paramVideoController.addFlags(268435456);
      paramVideoController.addFlags(4194304);
      if (((SessionInfo)localObject).am)
      {
        ((SessionInfo)localObject).p = 0;
        paramVideoController.putExtra("sessionType", ((SessionInfo)localObject).g);
        paramVideoController.putExtra("GroupId", ((SessionInfo)localObject).s);
        paramVideoController.putExtra("uin", ((SessionInfo)localObject).s);
        paramVideoController.putExtra("isDoubleVideoMeeting", true);
        paramVideoController.putExtra("uinType", ((SessionInfo)localObject).p);
        try
        {
          paramContext.startActivity(paramVideoController);
        }
        catch (Exception paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label776;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enterVideo e = ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.e("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        paramVideoController.putExtra("sessionType", i1);
        paramVideoController.putExtra("uin", ((SessionInfo)localObject).s);
        try
        {
          paramContext.startActivity(paramVideoController);
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("enterVideo e = ");
            ((StringBuilder)localObject).append(paramContext);
            QLog.e("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      label776:
      paramVideoController.putExtra("Fromwhere", "SmallScreen");
    }
  }
  
  private void c(int paramInt)
  {
    long l1 = AudioHelper.c();
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeVideoLayoutMode, mode[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mVideoLayerUI[");
      boolean bool;
      if (this.u != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.u;
    if (localObject != null)
    {
      if (paramInt == ((SmallScreenVideoLayerUI)localObject).z()) {
        return;
      }
      if (paramInt == 1) {
        a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
      this.u.i(paramInt);
      this.b.a(l1);
    }
  }
  
  private void m()
  {
    this.r.a().postDelayed(new SmallScreenVideoController.4(this), 50L);
  }
  
  void a()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.e = null;
    }
    this.e = new Timer();
    localObject = new SmallScreenVideoController.1(this);
    this.e.schedule((TimerTask)localObject, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.b.c(paramInt);
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy, mActivityState[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    this.f = 0;
    Object localObject = this.b;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SmallScreenService)localObject).b(1);
    }
    if (localObject != null)
    {
      localObject = ((SmallScreenRelativeLayout)localObject).findViewById(2013331470);
      if (localObject != null) {
        ((View)localObject).findViewById(2013331471).clearAnimation();
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.e = null;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((ICameraManagerApi)localObject).deleteObserver(this.A);
      this.v = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((SmallScreenVideoLayerUI)localObject).E();
      this.u = null;
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((SmallScreenVideoControlUI)localObject).a(paramLong);
      this.t = null;
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).b(this.D);
      this.r.b(this.z);
      this.r.b(this.B);
      this.r.b().k().e("SmallScreen.onDestroy", 0);
    }
    this.s = null;
    this.r = null;
    this.x = null;
    this.z = null;
    this.D = null;
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog("SmallScreenVideoController", localStringBuilder.toString());
    this.r.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof VideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCreate");
      }
      this.r = ((VideoAppInterface)paramAppRuntime);
      this.s = this.r.b();
      this.r.a(this.z);
      this.r.a(this.B);
      this.r.a(this.D);
      this.s.n.sendGetGatewayMsg();
      j();
      if (!this.s.k().a()) {
        i();
      }
      GraphicRenderMgr.getInstance();
      a(false);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = this.s.k();
    if ((localObject1 != null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreateUI SessionType = ");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject1).g);
      QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject2).toString());
    }
    this.w = UITools.a(this.c, 2130842939);
    if (this.v == null)
    {
      this.v = CameraUtils.a(this.c);
      this.v.addObserver(this.A);
      this.v.setCameraListener(this.s.t);
    }
    Object localObject2 = this.b.b(1);
    if (localObject2 == null)
    {
      QLog.w("SmallScreenVideoController", 2, "onCreateUI videoToastView == null");
      return;
    }
    localObject2 = ((SmallScreenRelativeLayout)localObject2).findViewById(2013331458);
    SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.u;
    if (localSmallScreenVideoLayerUI == null) {
      this.u = new SmallScreenVideoLayerUI(this.r, this.b, (View)localObject2, this);
    } else {
      localSmallScreenVideoLayerUI.n();
    }
    a((SessionInfo)localObject1);
    localObject2 = this.t;
    if (localObject2 != null) {
      ((SmallScreenVideoControlUI)localObject2).a(paramBoolean);
    }
    if ((localObject1 != null) && (((SessionInfo)localObject1).i != 4) && (this.g == 1) && (!this.n))
    {
      localObject1 = this.r;
      int i1 = VipFunCallUtil.a((AppRuntime)localObject1, ((VideoAppInterface)localObject1).getAccount(), 6, true, null);
      if (i1 > 0)
      {
        int i2 = VipFunCallUtil.c();
        localObject1 = VipFunCallUtil.a(this.r, i1, i2, null);
        if ((localObject1 != null) && (new File((String)localObject1).exists()))
        {
          localObject1 = this.u;
          if (localObject1 != null) {
            ((SmallScreenVideoLayerUI)localObject1).T();
          }
        }
      }
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    a(this.c, this.s);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick end");
    }
  }
  
  public boolean b(int paramInt)
  {
    if (!this.s.k().bR) {
      return false;
    }
    if (this.d == paramInt) {
      return false;
    }
    Object localObject = this.t;
    if ((localObject != null) && ((localObject instanceof SmallScreenDoubleVideoControlUI)))
    {
      if (!this.s.k().I)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Remote not has video, nOff=");
        ((StringBuilder)localObject).append(paramInt);
        AVLog.printErrorLog("SmallScreenVideoController", ((StringBuilder)localObject).toString());
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGlassSwitch nOff=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", prior=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
      this.d = paramInt;
      this.s.k().bS = paramInt;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return true;
            }
            this.u.aa();
            this.s.f(1);
            return true;
          }
          this.u.ab();
          this.s.f(1);
          return true;
        }
        this.u.aa();
        this.s.f(0);
        return true;
      }
      this.u.ab();
      this.s.f(0);
      return true;
    }
    return false;
  }
  
  void c()
  {
    if (this.o) {
      this.b.stopSelf();
    }
  }
  
  void d()
  {
    Object localObject = this.b;
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SmallScreenService)localObject).a(1);
    }
    SmallScreenService localSmallScreenService = this.b;
    if (localSmallScreenService != null) {
      localSmallScreenRelativeLayout = localSmallScreenService.b(1);
    }
    if ((this.o) && (localObject != null) && (((SmallScreenToast)localObject).e()) && (localSmallScreenRelativeLayout != null) && (localSmallScreenRelativeLayout.getVisibility() != 8))
    {
      localSmallScreenRelativeLayout.e();
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((SmallScreenService)localObject).stopSelf();
    }
  }
  
  public void e()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>onStart(), ts=");
      ((StringBuilder)localObject).append(l1);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ((StringBuilder)localObject).toString());
    }
    this.f = 3;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStart");
    }
    Object localObject = this.t;
    if (localObject != null) {
      ((SmallScreenVideoControlUI)localObject).b();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<<onStart(), ts=");
      ((StringBuilder)localObject).append(l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ((StringBuilder)localObject).toString());
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void f()
  {
    long l1 = System.currentTimeMillis();
    this.C = false;
    this.f = 5;
    long l2 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume, seq[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("] sessionType=");
      ((StringBuilder)localObject).append(this.s.k().g);
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    this.r.a().postDelayed(new SmallScreenVideoController.OnResumeRunnable(this, l2), 200L);
    boolean bool1;
    if (this.s.k().g == 2)
    {
      if (this.s.k().j())
      {
        localObject = this.s.k().s;
        if ((!this.s.k().I) && (!this.s.k().cw)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if (this.s.k().cw) {
          this.u.a(this.s.k().s, 1, true);
        }
        this.u.a((String)localObject, 1, bool1, false, this.s.h(this.k));
        if ((this.s.k().H) && (!this.r.m()))
        {
          this.v.openCamera(l2);
          this.u.a(true, false);
          this.u.c(l2, this.v.isFrontCamera());
        }
      }
      else if ((!this.s.k().br) && (!this.p))
      {
        this.s.k().b(l2, true);
        this.v.openCamera(l2);
        this.u.a(true, false);
        this.u.c(l2, this.v.isFrontCamera());
      }
    }
    else if (this.s.k().g == 4)
    {
      localObject = this.s.k().bi;
      int i1 = 0;
      while (i1 < ((ArrayList)localObject).size())
      {
        VideoViewInfo localVideoViewInfo = (VideoViewInfo)((ArrayList)localObject).get(i1);
        String str = String.valueOf(localVideoViewInfo.a);
        int i2 = localVideoViewInfo.b;
        boolean bool2 = localVideoViewInfo.c;
        boolean bool3 = localVideoViewInfo.d;
        if ((localVideoViewInfo.g != 5L) && (localVideoViewInfo.g != 14L)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if ((!str.equals(this.r.getCurrentAccountUin())) && (bool3)) {
          this.u.a(str, i2, bool3, bool2, bool1);
        }
        i1 += 1;
      }
    }
    Object localObject = this.u;
    if (localObject != null) {
      ((SmallScreenVideoLayerUI)localObject).G();
    }
    localObject = this.t;
    if (localObject != null) {
      ((SmallScreenVideoControlUI)localObject).e();
    }
    this.s.a(false);
    k();
    l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<<onResume(), ts=");
      ((StringBuilder)localObject).append(l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ((StringBuilder)localObject).toString());
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    l();
    this.f = 4;
    Object localObject = this.u;
    if (localObject != null) {
      ((SmallScreenVideoLayerUI)localObject).W();
    }
    localObject = this.t;
    if (localObject != null) {
      ((SmallScreenVideoControlUI)localObject).g();
    }
    this.s.a(true);
  }
  
  void h()
  {
    this.f = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    SmallScreenVideoControlUI localSmallScreenVideoControlUI = this.t;
    if (localSmallScreenVideoControlUI != null) {
      localSmallScreenVideoControlUI.s();
    }
  }
  
  void i()
  {
    this.g = this.s.k().g;
    this.h = this.s.k().h;
    this.q = this.s.k().am;
    this.i = this.s.k().p;
    this.k = this.s.k().s;
    this.j = this.s.k().az;
    this.m = this.s.k().aB;
    this.l = this.s.k().u;
    this.n = this.s.k().B;
  }
  
  void j()
  {
    if (this.x == null) {
      this.x = new SmallScreenVideoController.VideoOrientationEventListener(this, this.c, 2);
    }
  }
  
  void k()
  {
    AbstractOrientationEventListener localAbstractOrientationEventListener = this.x;
    if (localAbstractOrientationEventListener != null) {
      localAbstractOrientationEventListener.enable();
    }
  }
  
  void l()
  {
    AbstractOrientationEventListener localAbstractOrientationEventListener = this.x;
    if (localAbstractOrientationEventListener != null) {
      localAbstractOrientationEventListener.disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController
 * JD-Core Version:    0.7.0.1
 */