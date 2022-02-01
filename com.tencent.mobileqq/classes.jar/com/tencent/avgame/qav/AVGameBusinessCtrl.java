package com.tencent.avgame.qav;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.qav.audio.AvGameMusicPlayer;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSessionManager;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.CostTraceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qav.QavDef.MultiParams;
import com.tencent.qav.QavSDK;
import com.tencent.qav.channel.VideoChannelImpl;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.multi.QavMultiObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.log.AVLogImpl;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;
import mqq.util.WeakReference;

public class AVGameBusinessCtrl
  extends IAVGameBusinessCtrl
{
  private static volatile AVGameBusinessCtrl a;
  private final WeakReference<AVGameAppInterface> b;
  private final ArrayList<WeakReference<AVGameUIEventCallback>> c = new ArrayList();
  private AVGameSessionManager d;
  private boolean e = true;
  private final BroadcastReceiver f = new AVGameBusinessCtrl.1(this);
  private MultiOperatorImplForGame g;
  private IAVGameBusinessCtrl.IOnEnterRoom h;
  private boolean i;
  private boolean j = false;
  private boolean k;
  private AVGameCameraAssistant l;
  private IAVGameMediaPlayerCtrl m;
  private QavMultiObserver n = new AVGameBusinessCtrl.2(this);
  
  private AVGameBusinessCtrl()
  {
    AVGamePerfReporter.a().a("param_QAVInit");
    CostTraceUtil.a().b("AVGameBusinessCtrlInit");
    AVLog.d("AVGameBusinessCtrl", "AVGameBusinessCtrl create and init.");
    Object localObject2 = BaseApplicationImpl.getApplication().getQQProcessName();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init, [");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("]");
    QLog.i("AVGameBusinessCtrl", 1, ((StringBuilder)localObject1).toString());
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject3 instanceof AVGameAppInterface)) {
      localObject1 = (AVGameAppInterface)localObject3;
    } else {
      localObject1 = null;
    }
    this.b = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject3).getManager(5)).registProxyMessagePush(AppSetting.d(), (String)localObject2, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    AVLog.a(new AVLogImpl());
    localObject1 = VideoChannelImpl.c();
    ((VideoChannelImpl)localObject1).a((AppRuntime)localObject3);
    ((VideoChannelImpl)localObject1).a(new AVGameBusinessCtrl.3(this));
    long l1 = ((AppRuntime)localObject3).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new QavCtrlForGame((Context)localObject2, new MultiOperatorImplForGame((Context)localObject2, l1, (VideoChannelInterface)localObject1, AvGameConfigUtil.a().c(l1)));
    QavSDK localQavSDK = QavSDK.a();
    localQavSDK.a((QavCtrl)localObject3);
    localQavSDK.a((Context)localObject2, l1, (VideoChannelInterface)localObject1);
    this.g = ((MultiOperatorImplForGame)QavSDK.a().c());
    this.d = new AVGameSessionManager();
    localQavSDK.a(this.n);
    CostTraceUtil.a().c("AVGameBusinessCtrlInit");
    AVGamePerfReporter.a().a("param_QAVInit", 0);
    AVGamePerfReporter.a().a("param_AVGameInit", 0);
  }
  
  public static AVGameBusinessCtrl a()
  {
    return b();
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    AVGameHandler.a().b().post(new AVGameBusinessCtrl.4(this, paramIntent, paramContext));
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onMemberShareInOrOut, shareIn[");
    ((StringBuilder)???).append(paramBoolean);
    ((StringBuilder)???).append("], userUin[");
    ((StringBuilder)???).append(paramLong1);
    ((StringBuilder)???).append("]");
    AVLog.c("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    ??? = AVGameSession.a(paramInt1, paramLong2);
    ??? = this.d.a((String)???);
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onMemberShareInOrOut failed, session is null.");
      return;
    }
    if (paramBoolean) {
      paramInt1 = 2;
    } else {
      paramInt1 = 0;
    }
    boolean bool = ((AVGameSession)???).b(paramLong1, paramBoolean, paramInt1);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onMemberShareInOrOut, updateUserSubVideoStatus result[");
    ((StringBuilder)???).append(bool);
    ((StringBuilder)???).append("]");
    AVLog.c("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramBoolean, paramLong1, 2);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static AVGameBusinessCtrl b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVGameBusinessCtrl();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(k()), Boolean.valueOf(t()), Integer.valueOf(paramInt2) }));
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null) {
      localIMultiOperator.b(paramInt1);
    }
    AVGameSession localAVGameSession = this.d.a();
    if (localAVGameSession != null)
    {
      if (paramInt1 == 1) {
        bool = true;
      }
      localAVGameSession.h = bool;
    }
    if (localIMultiOperator != null) {
      c(localIMultiOperator.i(), paramInt2);
    }
  }
  
  public static void c()
  {
    if (a != null) {
      try
      {
        if (a != null) {
          a.f();
        }
        a = null;
        return;
      }
      finally {}
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = 3;
    boolean bool2 = k();
    boolean bool1 = false;
    boolean bool3 = t();
    int i1 = 2;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(paramInt) }));
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null)
    {
      if ((paramInt != 0) && (k()))
      {
        localIMultiOperator.b(0);
        i1 = 0;
        paramInt = i2;
      }
      else if ((paramInt != 2) && (t()))
      {
        localIMultiOperator.b(2);
        paramInt = 0;
      }
      else
      {
        localIMultiOperator.b(1);
        paramInt = 0;
        i1 = 1;
      }
      AVGameSession localAVGameSession = this.d.a();
      if (localAVGameSession != null)
      {
        if (i1 == 1) {
          bool1 = true;
        }
        localAVGameSession.h = bool1;
      }
      c(localIMultiOperator.i(), paramInt);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AVGameHandler.a().c().post(new AVGameBusinessCtrl.6(this, paramInt1, paramInt2));
  }
  
  public static boolean e()
  {
    if (a == null) {
      AVLog.b("AVGameBusinessCtrl", "ERROR!!! Instance == null. ", new Throwable("打印调用栈"));
    }
    return a != null;
  }
  
  private void r()
  {
    if (!d()) {
      return;
    }
    this.g.a();
  }
  
  private void s()
  {
    if (!d()) {
      return;
    }
    this.g.b();
  }
  
  private boolean t()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    boolean bool2 = ((BluetoothAdapter)localObject).isEnabled();
    boolean bool1 = true;
    if (bool2)
    {
      i1 = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      int i2 = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      int i3 = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i1 == 2) {
        break label71;
      }
      if (i2 == 2)
      {
        i1 = i2;
        break label71;
      }
      if (i3 == 2)
      {
        i1 = i3;
        break label71;
      }
    }
    int i1 = -1;
    label71:
    localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    if (i1 == -1)
    {
      if (((AudioManager)localObject).isBluetoothA2dpOn()) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void u()
  {
    int i1 = 2;
    boolean bool2 = k();
    boolean bool1 = false;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(t()) }));
    IMultiOperator localIMultiOperator = QavSDK.a().c();
    if (localIMultiOperator != null)
    {
      if (k())
      {
        localIMultiOperator.b(0);
        i1 = 0;
      }
      else if (t())
      {
        localIMultiOperator.b(2);
      }
      else
      {
        localIMultiOperator.b(1);
        i1 = 1;
      }
      AVGameSession localAVGameSession = this.d.a();
      if (localAVGameSession != null)
      {
        if (i1 == 1) {
          bool1 = true;
        }
        localAVGameSession.h = bool1;
      }
      c(localIMultiOperator.i(), -1);
    }
  }
  
  private void v()
  {
    if (this.m == null)
    {
      this.m = new AVGameMediaPlayerCtrl();
      this.m.h();
    }
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IAVGameBusinessCtrl.IOnEnterRoom paramIOnEnterRoom)
  {
    if (!e()) {
      return -1;
    }
    AVGamePerfReporter.a().a("param_QAVEnterRoom");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterRoom. businessRoomId[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], onEnterRoom[");
    ((StringBuilder)localObject).append(paramIOnEnterRoom);
    ((StringBuilder)localObject).append("], sourceType[");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("], svrRecordFlag[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("] tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)localObject).toString());
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AVGameAppInterface)) {
      localObject = ((AVGameAppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "";
    }
    if (AVGameUtil.b((String)localObject) == 0L)
    {
      paramString = new StringBuilder();
      paramString.append("enterRoom failed. selfUin[");
      paramString.append((String)localObject);
      paramString.append("] is illegal.");
      AVLog.a("AVGameBusinessCtrl", paramString.toString());
      return -1;
    }
    int i1 = AVGameUtil.a(paramString);
    if (i1 == 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterRoom failed. invalid args. [");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append("]");
      AVLog.a("AVGameBusinessCtrl", paramArrayOfByte.toString());
      return -1;
    }
    paramString = this.d.a();
    if (paramString != null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterRoom failed. a call already exist. relation id(or peer uin) = ");
      paramArrayOfByte.append(paramString.e);
      paramArrayOfByte.append(", sessionId = ");
      paramArrayOfByte.append(paramString.b);
      AVLog.a("AVGameBusinessCtrl", paramArrayOfByte.toString());
      return -1;
    }
    long l1 = i1;
    String str = AVGameSession.a(11, l1);
    paramString = this.d.a(str);
    if (paramString != null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterRoom failed. a call already exist. relation id = ");
      paramArrayOfByte.append(paramString.e);
      paramArrayOfByte.append(", sessionId = ");
      paramArrayOfByte.append(paramString.b);
      AVLog.a("AVGameBusinessCtrl", paramArrayOfByte.toString());
      return -1;
    }
    paramString = this.d.a(1, str, true);
    if (paramString == null)
    {
      AVLog.a("AVGameBusinessCtrl", "enterRoom failed. create session fail");
      return -1;
    }
    paramString.d = 11;
    paramString.e = l1;
    paramString.f = false;
    paramString.g = true;
    paramString.a(1);
    paramString.l = AVGameUtil.b((String)localObject);
    localObject = new QavDef.MultiParams();
    ((QavDef.MultiParams)localObject).a = 11;
    ((QavDef.MultiParams)localObject).b = 14;
    ((QavDef.MultiParams)localObject).c = 1;
    ((QavDef.MultiParams)localObject).d = i1;
    ((QavDef.MultiParams)localObject).f = "";
    ((QavDef.MultiParams)localObject).e = paramString.l;
    ((QavDef.MultiParams)localObject).g = paramInt2;
    ((QavDef.MultiParams)localObject).h = paramArrayOfByte;
    ((QavDef.MultiParams)localObject).i = paramInt1;
    paramInt1 = this.g.a((QavDef.MultiParams)localObject);
    if (paramInt1 == 0)
    {
      this.h = paramIOnEnterRoom;
      return paramInt1;
    }
    paramString = new StringBuilder();
    paramString.append("enterRoom failed. retCode = ");
    paramString.append(paramInt1);
    AVLog.a("AVGameBusinessCtrl", paramString.toString());
    paramString = this.d;
    paramString.b(paramString.a().b);
    return paramInt1;
  }
  
  public void a(int paramInt)
  {
    if (e())
    {
      if (!d()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAudioRoute route = ");
      ((StringBuilder)localObject).append(paramInt);
      AVLog.c("AVGameBusinessCtrl", ((StringBuilder)localObject).toString());
      this.g.b(paramInt);
      localObject = this.d.a();
      if (localObject != null)
      {
        boolean bool = true;
        if (paramInt != 1) {
          bool = false;
        }
        ((AVGameSession)localObject).h = bool;
      }
      c(paramInt, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AVGameHandler.a().c().post(new AVGameBusinessCtrl.5(this, paramInt1, paramInt2));
  }
  
  public void a(AVGameUIEventCallback paramAVGameUIEventCallback)
  {
    if (paramAVGameUIEventCallback == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramAVGameUIEventCallback)) {
          return;
        }
      }
      this.c.add(new WeakReference(paramAVGameUIEventCallback));
      return;
    }
    for (;;)
    {
      throw paramAVGameUIEventCallback;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramBoolean, -1L, 2);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    AVGameSession localAVGameSession = j();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("goOnStage, from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], session[");
      ((StringBuilder)localObject).append(localAVGameSession);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameBusinessCtrl", 2, ((StringBuilder)localObject).toString());
    }
    if (localAVGameSession == null) {
      return;
    }
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localAVGameSession.o = bool;
    if (SecurityPolicyChecker.a().c()) {
      localAVGameSession.o = true;
    }
    Object localObject = m();
    if (localObject != null) {
      ((AVGameCameraAssistant)localObject).a("goOnStage");
    }
    localObject = QavSDK.a().c();
    if ((localObject instanceof MultiOperatorImplForGame))
    {
      localAVGameSession.b(1);
      if (!((MultiOperatorImplForGame)localObject).c()) {
        this.n.a(false, localAVGameSession.e, localAVGameSession.d);
      }
    }
  }
  
  public void b(AVGameUIEventCallback paramAVGameUIEventCallback)
  {
    if (paramAVGameUIEventCallback == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramAVGameUIEventCallback))
        {
          this.c.remove(localWeakReference);
          return;
        }
      }
      return;
    }
    for (;;)
    {
      throw paramAVGameUIEventCallback;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      long l1 = Long.valueOf(((AVGameAppInterface)this.b.get()).getCurrentAccountUin()).longValue();
      localObject = this.d.a();
      if (localObject != null) {
        a(paramBoolean, l1, ((AVGameSession)localObject).e, ((AVGameSession)localObject).d, 0L, 0);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (e())
    {
      if (!d()) {
        return;
      }
      this.g.a(paramBoolean);
      AVGameSession localAVGameSession = this.d.a();
      if (localAVGameSession != null) {
        localAVGameSession.i = (paramBoolean ^ true);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (e())
    {
      if (!d()) {
        return;
      }
      this.g.b(paramBoolean);
      AVGameSession localAVGameSession = this.d.a();
      if (localAVGameSession != null) {
        localAVGameSession.k = (paramBoolean ^ true);
      }
    }
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public void f()
  {
    AVLog.d("AVGameBusinessCtrl", "AVGameBusinessCtrl destroy.");
    QavSDK.a().b(this.n);
    this.n = null;
    this.d = null;
    this.g = null;
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.d(), BaseApplicationImpl.getApplication().getQQProcessName());
    QavSDK.a().b();
    if (this.i)
    {
      this.i = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.f);
    }
    synchronized (this.c)
    {
      this.c.clear();
      try
      {
        if (this.l != null)
        {
          this.l.d();
          this.l = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean g()
  {
    if (!e()) {
      return true;
    }
    Object localObject1 = (AVGameAppInterface)this.b.get();
    if (localObject1 != null) {
      AVGameUtilService.b(((AVGameAppInterface)localObject1).getApp());
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((AVGameSessionManager)localObject1).a();
    } else {
      localObject1 = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitRoom, session[");
    if (localObject1 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((AVGameSession)localObject1).b;
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("] tid=");
    localStringBuilder.append(Thread.currentThread().getId());
    AVLog.a("AVGameBusinessCtrl", localStringBuilder.toString());
    Object localObject2 = this.m;
    if (localObject2 != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject2).k();
      this.m = null;
    }
    CallingStateMonitor.a().e();
    if (QavSDK.a().c() != null) {
      QavSDK.a().c().a(-1L, true, false);
    }
    AvGameMusicPlayer.c();
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.c();
    }
    localObject2 = m();
    if (localObject2 != null) {
      ((AVGameCameraAssistant)localObject2).b((AVGameSession)localObject1);
    }
    if (localObject1 == null)
    {
      AVLog.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return false;
    }
    ((AVGameSession)localObject1).a(3);
    localObject2 = this.d;
    if (localObject2 != null) {
      ((AVGameSessionManager)localObject2).b(((AVGameSessionManager)localObject2).a().b);
    }
    AVLog.d("AVGameBusinessCtrl", "exitRoom mSessionManager has clear");
    this.g.g();
    ((AVGameSession)localObject1).a(4);
    this.k = true;
    this.j = false;
    return true;
  }
  
  public String h()
  {
    if ((e()) && (d())) {
      return this.g.l();
    }
    return null;
  }
  
  public int i()
  {
    if ((e()) && (d())) {
      return this.g.i();
    }
    return 0;
  }
  
  public AVGameSession j()
  {
    if (e())
    {
      AVGameSessionManager localAVGameSessionManager = this.d;
      if (localAVGameSessionManager != null) {
        return localAVGameSessionManager.a();
      }
    }
    return null;
  }
  
  public boolean k()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public void l()
  {
    AVGameSession localAVGameSession = j();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("goOffStage, session[");
      ((StringBuilder)localObject).append(localAVGameSession);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameBusinessCtrl", 2, ((StringBuilder)localObject).toString());
    }
    if (localAVGameSession == null) {
      return;
    }
    localAVGameSession.o = false;
    Object localObject = QavSDK.a().c();
    if ((localObject instanceof MultiOperatorImplForGame))
    {
      localAVGameSession.b(4);
      if (!((MultiOperatorImplForGame)localObject).d()) {
        this.n.b(false, localAVGameSession.e, localAVGameSession.d);
      }
    }
  }
  
  public AVGameCameraAssistant m()
  {
    if (this.l == null) {
      try
      {
        if (this.l == null) {
          this.l = new AVGameCameraAssistant(this, (AVGameAppInterface)this.b.get());
        }
      }
      finally {}
    }
    if (this.l == null) {
      QLog.i("AVGameBusinessCtrl", 1, "getCameraAssistant, assistant is null.");
    }
    return this.l;
  }
  
  public IAVGameMediaPlayerCtrl n()
  {
    return this.m;
  }
  
  public boolean o()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl
 * JD-Core Version:    0.7.0.1
 */