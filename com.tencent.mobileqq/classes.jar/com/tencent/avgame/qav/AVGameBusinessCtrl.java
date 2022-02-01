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
import com.tencent.avgame.gamelogic.gameres.AvGameMusicPlayer;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSessionManager;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.avgame.util.CostTraceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.QConfigManager;
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
{
  private static volatile AVGameBusinessCtrl jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl = null;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AVGameBusinessCtrl.1(this);
  private AVGameBusinessCtrl.IOnEnterRoom jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl$IOnEnterRoom;
  private AVGameCameraAssistant jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  private AVGameMediaPlayerCtrl jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl;
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
    Object localObject3 = BaseApplicationImpl.getApplication().getQQProcessName();
    QLog.i("AVGameBusinessCtrl", 1, "init, [" + (String)localObject3 + "]");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = null;
    if ((localObject2 instanceof AVGameAppInterface)) {
      localObject1 = (AVGameAppInterface)localObject2;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject2).getManager(5)).registProxyMessagePush(AppSetting.a(), (String)localObject3, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    AVLog.a(new AVLogImpl());
    localObject1 = VideoChannelImpl.a();
    ((VideoChannelImpl)localObject1).a((AppRuntime)localObject2);
    ((VideoChannelImpl)localObject1).a(new AVGameBusinessCtrl.3(this));
    long l = ((AppRuntime)localObject2).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new QavCtrlForGame((Context)localObject2, new MultiOperatorImplForGame((Context)localObject2, l, (VideoChannelInterface)localObject1, ((AvGameConfBean)QConfigManager.a().a(642)).b(l)));
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
    paramInt2 = 2;
    AVLog.c("AVGameBusinessCtrl", "onMemberShareInOrOut, shareIn[" + paramBoolean + "], userUin[" + paramLong1 + "]");
    ??? = AVGameSession.a(paramInt1, paramLong2);
    ??? = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a((String)???);
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onMemberShareInOrOut failed, session is null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((AVGameSession)???).b(paramLong1, paramBoolean, paramInt1);
      AVLog.c("AVGameBusinessCtrl", "onMemberShareInOrOut, updateUserSubVideoStatus result[" + bool + "]");
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((AVGameUIEventCallback)localWeakReference.get()).b(paramBoolean, paramLong1, 2);
      }
    }
  }
  
  public static AVGameBusinessCtrl b()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl == null) {
        jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl = new AVGameBusinessCtrl();
      }
      return jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(d()), Boolean.valueOf(f()), Integer.valueOf(paramInt2) }));
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    if (localIMultiOperator != null) {
      localIMultiOperator.b(paramInt1);
    }
    AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
    if (localAVGameSession != null) {
      if (paramInt1 != 1) {
        break label116;
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      if (localIMultiOperator != null) {
        c(localIMultiOperator.a(), paramInt2);
      }
      return;
      label116:
      bool = false;
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
    int i = 2;
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(d()), Boolean.valueOf(f()), Integer.valueOf(paramInt) }));
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    AVGameSession localAVGameSession;
    if (localIMultiOperator != null)
    {
      if ((paramInt == 0) || (!d())) {
        break label125;
      }
      localIMultiOperator.b(0);
      i = 0;
      paramInt = j;
      localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null) {
        if (i != 1) {
          break label165;
        }
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      c(localIMultiOperator.a(), paramInt);
      return;
      label125:
      if ((paramInt != 2) && (f()))
      {
        localIMultiOperator.b(2);
        paramInt = 0;
        break;
      }
      localIMultiOperator.b(1);
      paramInt = 0;
      i = 1;
      break;
      label165:
      bool = false;
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
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(d()), Boolean.valueOf(f()) }));
    IMultiOperator localIMultiOperator = QavSDK.a().a();
    AVGameSession localAVGameSession;
    if (localIMultiOperator != null)
    {
      if (!d()) {
        break label104;
      }
      localIMultiOperator.b(0);
      i = 0;
      localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null) {
        if (i != 1) {
          break label133;
        }
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      c(localIMultiOperator.a(), -1);
      return;
      label104:
      if (f())
      {
        localIMultiOperator.b(2);
        break;
      }
      localIMultiOperator.b(1);
      i = 1;
      break;
      label133:
      bool = false;
    }
  }
  
  private boolean f()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    int i;
    int j;
    int k;
    if (((BluetoothAdapter)localObject).isEnabled())
    {
      i = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      j = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      k = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i != 2) {}
    }
    for (;;)
    {
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if ((i != -1) || (((AudioManager)localObject).isBluetoothA2dpOn()))
      {
        return true;
        i = j;
        if (j == 2) {
          continue;
        }
        if (k == 2) {
          i = k;
        }
      }
      else
      {
        return false;
      }
      i = -1;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl == null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl = new AVGameMediaPlayerCtrl();
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl.e();
    }
  }
  
  public int a()
  {
    if ((!b()) || (!a())) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a();
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, AVGameBusinessCtrl.IOnEnterRoom paramIOnEnterRoom)
  {
    if (!b()) {
      return -1;
    }
    AVGamePerfReporter.a().a("param_QAVEnterRoom");
    AVLog.d("AVGameBusinessCtrl", "enterRoom. businessRoomId[" + paramString + "], onEnterRoom[" + paramIOnEnterRoom + "], sourceType[" + paramInt2 + "], svrRecordFlag[" + paramInt1 + "] tid=" + Thread.currentThread().getId());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AVGameAppInterface)) {}
    for (localObject = ((AVGameAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      if (AVGameUtils.a((String)localObject) == 0L)
      {
        AVLog.a("AVGameBusinessCtrl", "enterRoom failed. selfUin[" + (String)localObject + "] is illegal.");
        return -1;
      }
      int i = AVGameUtils.a(paramString);
      if (i == 0)
      {
        AVLog.a("AVGameBusinessCtrl", "enterRoom failed. invalid args. [" + paramString + "]");
        return -1;
      }
      paramString = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (paramString != null)
      {
        AVLog.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id(or peer uin) = " + paramString.jdField_a_of_type_Long + ", sessionId = " + paramString.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = AVGameSession.a(11, i);
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a(paramString);
      if (localAVGameSession != null)
      {
        AVLog.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id = " + localAVGameSession.jdField_a_of_type_Long + ", sessionId = " + localAVGameSession.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a(1, paramString, true);
      if (paramString == null)
      {
        AVLog.a("AVGameBusinessCtrl", "enterRoom failed. create session fail");
        return -1;
      }
      paramString.jdField_b_of_type_Int = 11;
      paramString.jdField_a_of_type_Long = i;
      paramString.jdField_b_of_type_Boolean = false;
      paramString.c = true;
      paramString.a(1);
      paramString.jdField_b_of_type_Long = AVGameUtils.a((String)localObject);
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
        this.jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl$IOnEnterRoom = paramIOnEnterRoom;
        return paramInt1;
      }
      AVLog.a("AVGameBusinessCtrl", "enterRoom failed. retCode = " + paramInt1);
      this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.b(this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a().jdField_a_of_type_JavaLangString);
      return paramInt1;
    }
  }
  
  public AVGameCameraAssistant a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
        this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant = new AVGameCameraAssistant(this, (AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
      }
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
        QLog.i("AVGameBusinessCtrl", 1, "getCameraAssistant, assistant is null.");
      }
      return this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
    }
    finally {}
  }
  
  public AVGameMediaPlayerCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl;
  }
  
  public AVGameSession a()
  {
    if ((!b()) || (this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager == null)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
  }
  
  public String a()
  {
    if ((!b()) || (!a())) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a();
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if ((!b()) || (!a())) {
      return;
    }
    AVLog.c("AVGameBusinessCtrl", "setAudioRoute route = " + paramInt);
    this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.b(paramInt);
    AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
    if (localAVGameSession != null) {
      if (paramInt != 1) {
        break label78;
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      c(paramInt, 0);
      return;
      label78:
      bool = false;
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
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramAVGameUIEventCallback));
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
    }
  }
  
  public void b(int paramInt)
  {
    AVGameSession localAVGameSession = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOnStage, from[" + paramInt + "], session[" + localAVGameSession + "]");
    }
    if (localAVGameSession == null) {
      return;
    }
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localAVGameSession.g = bool;
      if (SecurityPolicyChecker.a().b()) {
        localAVGameSession.g = true;
      }
      Object localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).a("goOnStage");
      }
      localObject = QavSDK.a().a();
      if (!(localObject instanceof MultiOperatorImplForGame)) {
        break;
      }
      localAVGameSession.b(1);
      if (((MultiOperatorImplForGame)localObject).a()) {
        break;
      }
      this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver.a(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
      return;
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
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      long l = Long.valueOf(((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin()).longValue();
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      if (localAVGameSession != null) {
        a(paramBoolean, l, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int, 0L, 0);
      }
    }
  }
  
  public void c()
  {
    AVGameSession localAVGameSession = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOffStage, session[" + localAVGameSession + "]");
    }
    if (localAVGameSession == null) {}
    IMultiOperator localIMultiOperator;
    do
    {
      do
      {
        return;
        localAVGameSession.g = false;
        localIMultiOperator = QavSDK.a().a();
      } while (!(localIMultiOperator instanceof MultiOperatorImplForGame));
      localAVGameSession.b(4);
    } while (((MultiOperatorImplForGame)localIMultiOperator).b());
    this.jdField_a_of_type_ComTencentQavControllerMultiQavMultiObserver.b(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((!b()) || (!a())) {}
    AVGameSession localAVGameSession;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.a(paramBoolean);
      localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
    } while (localAVGameSession == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAVGameSession.e = paramBoolean;
      return;
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
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
      localStringBuilder = new StringBuilder().append("exitRoom, session[");
      if (localObject1 != null) {
        break label190;
      }
    }
    label190:
    for (Object localObject2 = null;; localObject2 = ((AVGameSession)localObject1).jdField_a_of_type_JavaLangString)
    {
      AVLog.a("AVGameBusinessCtrl", (String)localObject2 + "] tid=" + Thread.currentThread().getId());
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl.h();
        this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl = null;
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
      if (localObject1 != null) {
        break label198;
      }
      AVLog.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return false;
      localObject1 = null;
      break;
    }
    label198:
    ((AVGameSession)localObject1).a(3);
    if (this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager != null) {
      this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.b(this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a().jdField_a_of_type_JavaLangString);
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
    if ((!b()) || (!a())) {}
    AVGameSession localAVGameSession;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameQavMultiOperatorImplForGame.b(paramBoolean);
      localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSessionManager.a();
    } while (localAVGameSession == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAVGameSession.f = paramBoolean;
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl
 * JD-Core Version:    0.7.0.1
 */