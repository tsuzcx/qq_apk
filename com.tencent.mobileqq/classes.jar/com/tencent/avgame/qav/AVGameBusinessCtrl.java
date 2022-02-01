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
  private static volatile AVGameBusinessCtrl jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AVGameBusinessCtrl.1(this);
  private AVGameCameraAssistant jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  private IAVGameBusinessCtrl.IOnEnterRoom jdField_a_of_type_ComTencentAvgameQavIAVGameBusinessCtrl$IOnEnterRoom;
  private IAVGameMediaPlayerCtrl jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl;
  private MultiOperatorImplForGame jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame;
  private AVGameSessionManager jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager;
  private QavMultiObserver jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver = new AVGameBusinessCtrl.2(this);
  private final ArrayList<WeakReference<AVGameUIEventCallback>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = false;
  private boolean d;
  
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
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject3).getManager(5)).registProxyMessagePush(AppSetting.a(), (String)localObject2, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    AVLog.a(new AVLogImpl());
    localObject1 = VideoChannelImpl.a();
    ((VideoChannelImpl)localObject1).a((AppRuntime)localObject3);
    ((VideoChannelImpl)localObject1).a(new AVGameBusinessCtrl.3(this));
    long l = ((AppRuntime)localObject3).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new QavCtrlForGame((Context)localObject2, new MultiOperatorImplForGame((Context)localObject2, l, (VideoChannelInterface)localObject1, AvGameConfigUtil.a().b(l)));
    QavSDK localQavSDK = QavSDK.a();
    localQavSDK.a((QavCtrl)localObject3);
    localQavSDK.a((Context)localObject2, l, (VideoChannelInterface)localObject1);
    this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame = ((MultiOperatorImplForGame)QavSDK.a().a());
    this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager = new AVGameSessionManager();
    localQavSDK.a(this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver);
    CostTraceUtil.a().c("AVGameBusinessCtrlInit");
    AVGamePerfReporter.a().a("param_QAVInit", 0);
    AVGamePerfReporter.a().a("param_AVGameInit", 0);
  }
  
  public static AVGameBusinessCtrl a()
  {
    return b();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl != null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl != null) {
          jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl.b();
        }
        jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl = null;
        return;
      }
      finally {}
    }
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    AVGameHandler.a().a().post(new AVGameBusinessCtrl.4(this, paramIntent, paramContext));
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
    ??? = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a((String)???);
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
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl == null) {
          jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl = new AVGameBusinessCtrl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(d()), Boolean.valueOf(g()), Integer.valueOf(paramInt2) }));
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null) {
      localIMultiOperator.b(paramInt1);
    }
    AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
    if (localAVGameSession != null)
    {
      if (paramInt1 == 1) {
        bool = true;
      }
      localAVGameSession.d = bool;
    }
    if (localIMultiOperator != null) {
      c(localIMultiOperator.a(), paramInt2);
    }
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl == null) {
      AVLog.b("AVGameBusinessCtrl", "ERROR!!! Instance == null. ", new Throwable("打印调用栈"));
    }
    return jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl != null;
  }
  
  private void c(int paramInt)
  {
    int j = 3;
    boolean bool2 = d();
    boolean bool1 = false;
    boolean bool3 = g();
    int i = 2;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(paramInt) }));
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null)
    {
      if ((paramInt != 0) && (d()))
      {
        localIMultiOperator.b(0);
        i = 0;
        paramInt = j;
      }
      else if ((paramInt != 2) && (g()))
      {
        localIMultiOperator.b(2);
        paramInt = 0;
      }
      else
      {
        localIMultiOperator.b(1);
        paramInt = 0;
        i = 1;
      }
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null)
      {
        if (i == 1) {
          bool1 = true;
        }
        localAVGameSession.d = bool1;
      }
      c(localIMultiOperator.a(), paramInt);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AVGameHandler.a().b().post(new AVGameBusinessCtrl.6(this, paramInt1, paramInt2));
  }
  
  private void d()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a();
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.b();
  }
  
  private void f()
  {
    int i = 2;
    boolean bool2 = d();
    boolean bool1 = false;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(g()) }));
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null)
    {
      if (d())
      {
        localIMultiOperator.b(0);
        i = 0;
      }
      else if (g())
      {
        localIMultiOperator.b(2);
      }
      else
      {
        localIMultiOperator.b(1);
        i = 1;
      }
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null)
      {
        if (i == 1) {
          bool1 = true;
        }
        localAVGameSession.d = bool1;
      }
      c(localIMultiOperator.a(), -1);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl == null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl = new AVGameMediaPlayerCtrl();
      this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl.e();
    }
  }
  
  private boolean g()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    boolean bool2 = ((BluetoothAdapter)localObject).isEnabled();
    boolean bool1 = true;
    if (bool2)
    {
      i = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      int j = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      int k = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i == 2) {
        break label71;
      }
      if (j == 2)
      {
        i = j;
        break label71;
      }
      if (k == 2)
      {
        i = k;
        break label71;
      }
    }
    int i = -1;
    label71:
    localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    if (i == -1)
    {
      if (((AudioManager)localObject).isBluetoothA2dpOn()) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public int a()
  {
    if ((b()) && (a())) {
      return this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a();
    }
    return 0;
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IAVGameBusinessCtrl.IOnEnterRoom paramIOnEnterRoom)
  {
    if (!b()) {
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
    if (AVGameUtil.a((String)localObject) == 0L)
    {
      paramString = new StringBuilder();
      paramString.append("enterRoom failed. selfUin[");
      paramString.append((String)localObject);
      paramString.append("] is illegal.");
      AVLog.a("AVGameBusinessCtrl", paramString.toString());
      return -1;
    }
    int i = AVGameUtil.a(paramString);
    if (i == 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterRoom failed. invalid args. [");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append("]");
      AVLog.a("AVGameBusinessCtrl", paramArrayOfByte.toString());
      return -1;
    }
    paramString = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
    if (paramString != null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterRoom failed. a call already exist. relation id(or peer uin) = ");
      paramArrayOfByte.append(paramString.jdField_a_of_type_Long);
      paramArrayOfByte.append(", sessionId = ");
      paramArrayOfByte.append(paramString.jdField_a_of_type_JavaLangString);
      AVLog.a("AVGameBusinessCtrl", paramArrayOfByte.toString());
      return -1;
    }
    long l = i;
    String str = AVGameSession.a(11, l);
    paramString = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a(str);
    if (paramString != null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterRoom failed. a call already exist. relation id = ");
      paramArrayOfByte.append(paramString.jdField_a_of_type_Long);
      paramArrayOfByte.append(", sessionId = ");
      paramArrayOfByte.append(paramString.jdField_a_of_type_JavaLangString);
      AVLog.a("AVGameBusinessCtrl", paramArrayOfByte.toString());
      return -1;
    }
    paramString = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a(1, str, true);
    if (paramString == null)
    {
      AVLog.a("AVGameBusinessCtrl", "enterRoom failed. create session fail");
      return -1;
    }
    paramString.jdField_b_of_type_Int = 11;
    paramString.jdField_a_of_type_Long = l;
    paramString.jdField_b_of_type_Boolean = false;
    paramString.c = true;
    paramString.a(1);
    paramString.jdField_b_of_type_Long = AVGameUtil.a((String)localObject);
    localObject = new QavDef.MultiParams();
    ((QavDef.MultiParams)localObject).jdField_a_of_type_Int = 11;
    ((QavDef.MultiParams)localObject).jdField_b_of_type_Int = 14;
    ((QavDef.MultiParams)localObject).c = 1;
    ((QavDef.MultiParams)localObject).d = i;
    ((QavDef.MultiParams)localObject).jdField_a_of_type_JavaLangString = "";
    ((QavDef.MultiParams)localObject).jdField_a_of_type_Long = paramString.jdField_b_of_type_Long;
    ((QavDef.MultiParams)localObject).e = paramInt2;
    ((QavDef.MultiParams)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    ((QavDef.MultiParams)localObject).f = paramInt1;
    paramInt1 = this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a((QavDef.MultiParams)localObject);
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ComTencentAvgameQavIAVGameBusinessCtrl$IOnEnterRoom = paramIOnEnterRoom;
      return paramInt1;
    }
    paramString = new StringBuilder();
    paramString.append("enterRoom failed. retCode = ");
    paramString.append(paramInt1);
    AVLog.a("AVGameBusinessCtrl", paramString.toString());
    paramString = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager;
    paramString.b(paramString.a().jdField_a_of_type_JavaLangString);
    return paramInt1;
  }
  
  public AVGameCameraAssistant a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
          this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant = new AVGameCameraAssistant(this, (AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
        }
      }
      finally {}
    }
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
      QLog.i("AVGameBusinessCtrl", 1, "getCameraAssistant, assistant is null.");
    }
    return this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  }
  
  public IAVGameMediaPlayerCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl;
  }
  
  public AVGameSession a()
  {
    if (b())
    {
      AVGameSessionManager localAVGameSessionManager = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager;
      if (localAVGameSessionManager != null) {
        return localAVGameSessionManager.a();
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((b()) && (a())) {
      return this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (b())
    {
      if (!a()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAudioRoute route = ");
      ((StringBuilder)localObject).append(paramInt);
      AVLog.c("AVGameBusinessCtrl", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.b(paramInt);
      localObject = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localObject != null)
      {
        boolean bool = true;
        if (paramInt != 1) {
          bool = false;
        }
        ((AVGameSession)localObject).d = bool;
      }
      c(paramInt, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AVGameHandler.a().b().post(new AVGameBusinessCtrl.5(this, paramInt1, paramInt2));
  }
  
  public void a(AVGameUIEventCallback paramAVGameUIEventCallback)
  {
    if (paramAVGameUIEventCallback == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramAVGameUIEventCallback)) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramAVGameUIEventCallback));
      return;
    }
    for (;;)
    {
      throw paramAVGameUIEventCallback;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    AVLog.d("AVGameBusinessCtrl", "AVGameBusinessCtrl destroy.");
    QavSDK.a().b(this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver);
    this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver = null;
    this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager = null;
    this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame = null;
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    QavSDK.a().a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      try
      {
        if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant != null)
        {
          this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant.c();
          this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public void b(int paramInt)
  {
    AVGameSession localAVGameSession = a();
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
    localAVGameSession.g = bool;
    if (SecurityPolicyChecker.a().b()) {
      localAVGameSession.g = true;
    }
    Object localObject = a();
    if (localObject != null) {
      ((AVGameCameraAssistant)localObject).a("goOnStage");
    }
    localObject = QavSDK.a().a();
    if ((localObject instanceof MultiOperatorImplForGame))
    {
      localAVGameSession.b(1);
      if (!((MultiOperatorImplForGame)localObject).a()) {
        this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver.a(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(AVGameUIEventCallback paramAVGameUIEventCallback)
  {
    if (paramAVGameUIEventCallback == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramAVGameUIEventCallback))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localWeakReference);
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
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      long l = Long.valueOf(((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin()).longValue();
      localObject = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localObject != null) {
        a(paramBoolean, l, ((AVGameSession)localObject).jdField_a_of_type_Long, ((AVGameSession)localObject).jdField_b_of_type_Int, 0L, 0);
      }
    }
  }
  
  public void c()
  {
    AVGameSession localAVGameSession = a();
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
    localAVGameSession.g = false;
    Object localObject = QavSDK.a().a();
    if ((localObject instanceof MultiOperatorImplForGame))
    {
      localAVGameSession.b(4);
      if (!((MultiOperatorImplForGame)localObject).b()) {
        this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver.b(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (b())
    {
      if (!a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a(paramBoolean);
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null) {
        localAVGameSession.e = (paramBoolean ^ true);
      }
    }
  }
  
  public boolean c()
  {
    if (!b()) {
      return true;
    }
    Object localObject1 = (AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject1 != null) {
      AVGameUtilService.b(((AVGameAppInterface)localObject1).getApp());
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager;
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
      localObject2 = ((AVGameSession)localObject1).jdField_a_of_type_JavaLangString;
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("] tid=");
    localStringBuilder.append(Thread.currentThread().getId());
    AVLog.a("AVGameBusinessCtrl", localStringBuilder.toString());
    Object localObject2 = this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl;
    if (localObject2 != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject2).h();
      this.jdField_a_of_type_ComTencentAvgameQavIAVGameMediaPlayerCtrl = null;
    }
    CallingStateMonitor.a().b();
    if (QavSDK.a().a() != null) {
      QavSDK.a().a().a(-1L, true, false);
    }
    AvGameMusicPlayer.b();
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a();
    }
    localObject2 = a();
    if (localObject2 != null) {
      ((AVGameCameraAssistant)localObject2).b((AVGameSession)localObject1);
    }
    if (localObject1 == null)
    {
      AVLog.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return false;
    }
    ((AVGameSession)localObject1).a(3);
    localObject2 = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager;
    if (localObject2 != null) {
      ((AVGameSessionManager)localObject2).b(((AVGameSessionManager)localObject2).a().jdField_a_of_type_JavaLangString);
    }
    AVLog.d("AVGameBusinessCtrl", "exitRoom mSessionManager has clear");
    this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.e();
    ((AVGameSession)localObject1).a(4);
    this.d = true;
    this.c = false;
    return true;
  }
  
  public void d(boolean paramBoolean)
  {
    if (b())
    {
      if (!a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.b(paramBoolean);
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null) {
        localAVGameSession.f = (paramBoolean ^ true);
      }
    }
  }
  
  public boolean d()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public boolean e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl
 * JD-Core Version:    0.7.0.1
 */