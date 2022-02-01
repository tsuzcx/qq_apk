package com.tencent.avgame.qav;

import android.content.Context;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavDef.MultiParams;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.controller.multi.QavMultiObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.ObserverDispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class MultiOperatorImplForGame
  extends MultiOperatorImpl
  implements ISetAudioFrameCallback
{
  private AsyncExitTask jdField_a_of_type_ComTencentAvgameQavAsyncExitTask = null;
  private SdkAudioFrameCallback[] jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback = null;
  
  public MultiOperatorImplForGame(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface, boolean paramBoolean)
  {
    super(paramContext, paramLong, paramVideoChannelInterface, paramBoolean);
  }
  
  public int a(QavDef.MultiParams paramMultiParams)
  {
    try
    {
      int i = super.a(paramMultiParams);
      if (i == 0) {
        AsyncExitTask.a();
      }
      return i;
    }
    finally {}
  }
  
  public void a()
  {
    AVLog.c("MultiOperatorImplForGame", "startAudioRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAECMode(paramInt);
    }
  }
  
  public void a(int paramInt, SdkAudioFrameCallback paramSdkAudioFrameCallback)
  {
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback == null) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback = new SdkAudioFrameCallback[2];
    }
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[paramInt] = paramSdkAudioFrameCallback;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AVLog.c("MultiOperatorImplForGame", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(paramBoolean) }));
    if (paramInt == 2) {
      ObserverDispatcher.a().a(QavMultiObserver.class, 16, new Object[] { Boolean.valueOf(paramBoolean) });
    }
    while (paramInt != 1) {
      return;
    }
    ObserverDispatcher.a().a(QavMultiObserver.class, 17, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 100) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0] != null)) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
    if ((paramInt4 == 3) || (paramInt4 == 0) || (paramInt4 == 1) || (paramInt4 == 2) || (paramInt4 == 8)) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1] != null)) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1].a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    AVLog.c("MultiOperatorImplForGame", "goOnStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();; i = 0)
    {
      AVLog.d("MultiOperatorImplForGame", "goOnStage, ret[" + i + "]");
      if (i == 0) {
        break;
      }
      return true;
    }
  }
  
  public void b()
  {
    AVLog.c("MultiOperatorImplForGame", "stopAudioRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public boolean b()
  {
    AVLog.c("MultiOperatorImplForGame", "goOffStage mHasCallExitRoom：=" + this.b);
    if (this.b) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();; i = -1)
    {
      AVLog.d("MultiOperatorImplForGame", "goOffStage, ret[" + i + "]");
      if (i != -1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void c()
  {
    AVLog.c("MultiOperatorImplForGame", "startAVGameVideoRecv mHasCallExitRoom：=" + this.b);
    if (this.b) {}
    AVGameSession localAVGameSession;
    do
    {
      do
      {
        return;
        localAVGameSession = AVGameBusinessCtrl.b().a();
      } while (localAVGameSession == null);
      boolean bool = SecurityPolicyChecker.a().b();
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localAVGameSession.a.clear();
      Object localObject = new ArrayList(8);
      localAVGameSession.c((List)localObject);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AVGameUserInfo localAVGameUserInfo = (AVGameUserInfo)((Iterator)localObject).next();
        if (localAVGameUserInfo.mUin != l)
        {
          VideoViewInfo localVideoViewInfo;
          if (bool)
          {
            if ((localAVGameUserInfo.mVideoOn) && (localAVGameUserInfo.mBigVideo))
            {
              localVideoViewInfo = new VideoViewInfo();
              localVideoViewInfo.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              localVideoViewInfo.jdField_a_of_type_Int = localAVGameUserInfo.mVideoSrc;
              localVideoViewInfo.jdField_a_of_type_Boolean = localAVGameUserInfo.mBigVideo;
              localAVGameSession.a.add(localVideoViewInfo);
            }
          }
          else
          {
            if (localAVGameUserInfo.mVideoOn)
            {
              localVideoViewInfo = new VideoViewInfo();
              localVideoViewInfo.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              localVideoViewInfo.jdField_a_of_type_Int = localAVGameUserInfo.mVideoSrc;
              localVideoViewInfo.jdField_a_of_type_Boolean = localAVGameUserInfo.mBigVideo;
              localAVGameSession.a.add(localVideoViewInfo);
            }
            if (localAVGameUserInfo.mSubVideoOn)
            {
              localVideoViewInfo = new VideoViewInfo();
              localVideoViewInfo.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
              localVideoViewInfo.jdField_a_of_type_Int = localAVGameUserInfo.mSubVideoSrc;
              localVideoViewInfo.jdField_a_of_type_Boolean = false;
              localAVGameSession.a.add(localVideoViewInfo);
            }
          }
        }
      }
      if (localAVGameSession.a.isEmpty())
      {
        AVLog.a("MultiOperatorImplForGame", "startAVGameVideoRecv fail with empty uinList");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAVGameVideoRecv(localAVGameSession.a);
  }
  
  public void d()
  {
    AVLog.c("MultiOperatorImplForGame", "stopAVGameVideoRecv mHasCallExitRoom：=" + this.b);
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && (!this.b)) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv();
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 28
    //   4: ldc 253
    //   6: invokestatic 55	com/tencent/qav/log/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 256	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_ComTencentQavQavDef$MultiParams	Lcom/tencent/qav/QavDef$MultiParams;
    //   14: aload_0
    //   15: getfield 259	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   18: ifnull +12 -> 30
    //   21: aload_0
    //   22: getfield 259	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   25: invokeinterface 262 1 0
    //   30: iconst_m1
    //   31: istore_1
    //   32: invokestatic 266	com/tencent/avgame/gamelogic/gameres/AvGameMusicPlayer:b	()V
    //   35: getstatic 271	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 16
    //   40: if_icmplt +6 -> 46
    //   43: invokestatic 274	com/tencent/av/audioprocess/AudioProcess:a	()V
    //   46: aload_0
    //   47: getfield 58	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   50: ifnull +75 -> 125
    //   53: invokestatic 276	com/tencent/avgame/qav/AsyncExitTask:a	()Z
    //   56: ifeq +79 -> 135
    //   59: aload_0
    //   60: getfield 17	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_ComTencentAvgameQavAsyncExitTask	Lcom/tencent/avgame/qav/AsyncExitTask;
    //   63: ifnonnull +14 -> 77
    //   66: aload_0
    //   67: new 23	com/tencent/avgame/qav/AsyncExitTask
    //   70: dup
    //   71: invokespecial 277	com/tencent/avgame/qav/AsyncExitTask:<init>	()V
    //   74: putfield 17	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_ComTencentAvgameQavAsyncExitTask	Lcom/tencent/avgame/qav/AsyncExitTask;
    //   77: aload_0
    //   78: getfield 17	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_ComTencentAvgameQavAsyncExitTask	Lcom/tencent/avgame/qav/AsyncExitTask;
    //   81: aload_0
    //   82: invokevirtual 280	com/tencent/avgame/qav/MultiOperatorImplForGame:a	()Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   85: invokevirtual 283	com/tencent/avgame/qav/AsyncExitTask:a	(Lcom/tencent/av/gaudio/QQGAudioCtrl;)I
    //   88: istore_1
    //   89: aload_0
    //   90: invokevirtual 286	com/tencent/avgame/qav/MultiOperatorImplForGame:i	()V
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 84	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_Boolean	Z
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 42	com/tencent/avgame/qav/MultiOperatorImplForGame:b	Z
    //   103: iload_1
    //   104: sipush 261
    //   107: if_icmpne +18 -> 125
    //   110: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   113: invokevirtual 164	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   116: checkcast 288	com/tencent/avgame/app/AVGameAppInterface
    //   119: sipush 1006
    //   122: invokevirtual 290	com/tencent/avgame/app/AVGameAppInterface:b	(I)V
    //   125: invokestatic 295	com/tencent/avgame/util/AVGamePerfReporter:a	()Lcom/tencent/avgame/util/AVGamePerfReporter;
    //   128: iconst_1
    //   129: invokevirtual 297	com/tencent/avgame/util/AVGamePerfReporter:a	(I)V
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: aload_0
    //   136: getfield 58	com/tencent/avgame/qav/MultiOperatorImplForGame:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   139: iconst_0
    //   140: invokevirtual 301	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   143: pop
    //   144: goto -55 -> 89
    //   147: astore_2
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_2
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	MultiOperatorImplForGame
    //   31	77	1	i	int
    //   147	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	147	finally
    //   32	46	147	finally
    //   46	77	147	finally
    //   77	89	147	finally
    //   89	103	147	finally
    //   110	125	147	finally
    //   125	132	147	finally
    //   135	144	147	finally
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    QavDef.MultiUserInfo localMultiUserInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      AVLog.c("MultiOperatorImplForGame", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localMultiUserInfo = a(paramLong);
      if (localMultiUserInfo != null) {
        if (paramBoolean) {
          break label84;
        }
      }
    }
    label84:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localMultiUserInfo.mMicOn = paramBoolean;
      a(localMultiUserInfo, bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 93) {}
    for (boolean bool = true;; bool = false)
    {
      ObserverDispatcher.a().a(QavMultiObserver.class, 12, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    boolean bool;
    if (paramInt1 == 90) {
      if (paramLong1 == 3L) {
        bool = true;
      }
    }
    for (;;)
    {
      ObserverDispatcher.a().a(QavMultiObserver.class, 11, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 15, new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentQavQavDef$MultiParams == null) {}
    label164:
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          AVLog.c("MultiOperatorImplForGame", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
          if (paramAVUserInfo.account == this.jdField_a_of_type_Long)
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              i();
              ObserverDispatcher.a().a(QavMultiObserver.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramAVUserInfo.account);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break label164;
            }
            paramAVUserInfo = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramAVUserInfo = new QavDef.MultiUserInfo();
              paramAVUserInfo.mUin = this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_Long;
              paramAVUserInfo.mOpenId = this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_JavaLangString;
              paramAVUserInfo.mMicOn = true;
              a(paramAVUserInfo);
            }
          }
          for (;;)
          {
            b(paramAVUserInfo);
            return;
            paramInt1 = 0;
            break;
            paramVarArgs = new QavDef.MultiUserInfo();
            paramVarArgs.mUin = paramAVUserInfo.account;
            paramVarArgs.mMicOn = true;
            a(paramVarArgs);
            paramAVUserInfo = paramVarArgs;
          }
        }
      } while (paramInt1 != 71);
      AVLog.c("MultiOperatorImplForGame", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      paramAVUserInfo = b(paramAVUserInfo.account);
    } while (paramAVUserInfo == null);
    c(paramAVUserInfo);
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return;
    }
    long l = paramArrayOfLong[0];
    switch (paramInt1)
    {
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    default: 
      AVLog.d("MultiOperatorImplForGame", "onMultiVideoChatMembersInfoChange, error. type[" + paramInt1 + "], id[" + paramLong1 + "], type[" + paramInt2 + "], user[" + l + "]");
      return;
    case 42: 
    case 43: 
      if (paramInt1 == 42) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfLong = a(l);
        if (paramArrayOfLong == null) {
          break;
        }
        ObserverDispatcher.a().a(QavMultiObserver.class, 6, new Object[] { paramArrayOfLong, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
        return;
      }
    case 72: 
      ObserverDispatcher.a().a(QavMultiObserver.class, 9, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
      return;
    }
    ObserverDispatcher.a().a(QavMultiObserver.class, 10, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
  }
  
  public void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 13, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void onSelfAudioVolumeChange(long paramLong)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 8, new Object[] { Integer.valueOf((int)paramLong) });
  }
  
  public void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 13, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.MultiOperatorImplForGame
 * JD-Core Version:    0.7.0.1
 */