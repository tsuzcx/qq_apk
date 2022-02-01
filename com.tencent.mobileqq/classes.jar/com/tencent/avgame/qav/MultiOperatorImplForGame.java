package com.tencent.avgame.qav;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avgame.ipc.AccountReceiver.AccountListener;
import com.tencent.avgame.qav.audio.AvGameMusicPlayer;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
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
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startAudioRecv mHasCallExitRoom：=");
    localStringBuilder.append(this.b);
    AVLog.c("MultiOperatorImplForGame", localStringBuilder.toString());
    if (this.b) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
    }
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
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    AVLog.c("MultiOperatorImplForGame", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(paramBoolean) }));
    if (paramInt == 2)
    {
      ObserverDispatcher.a().a(QavMultiObserver.class, 16, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    if (paramInt == 1) {
      ObserverDispatcher.a().a(QavMultiObserver.class, 17, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 100) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0] != null)) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0].onReceiveAudioFrame(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
    if ((paramInt4 == 3) || (paramInt4 == 0) || (paramInt4 == 1) || (paramInt4 == 2) || (paramInt4 == 8)) {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1] != null)) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1].onReceiveAudioFrame(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("goOnStage mHasCallExitRoom：=");
    localStringBuilder.append(this.b);
    AVLog.c("MultiOperatorImplForGame", localStringBuilder.toString());
    boolean bool2 = this.b;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();
    } else {
      i = 0;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("goOnStage, ret[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    AVLog.d("MultiOperatorImplForGame", localStringBuilder.toString());
    if (i != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopAudioRecv mHasCallExitRoom：=");
    localStringBuilder.append(this.b);
    AVLog.c("MultiOperatorImplForGame", localStringBuilder.toString());
    if (this.b) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
    }
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("goOffStage mHasCallExitRoom：=");
    localStringBuilder.append(this.b);
    AVLog.c("MultiOperatorImplForGame", localStringBuilder.toString());
    boolean bool2 = this.b;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();
    } else {
      i = -1;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("goOffStage, ret[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    AVLog.d("MultiOperatorImplForGame", localStringBuilder.toString());
    if (i != -1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startAVGameVideoRecv mHasCallExitRoom：=");
    ((StringBuilder)localObject1).append(this.b);
    AVLog.c("MultiOperatorImplForGame", ((StringBuilder)localObject1).toString());
    if (this.b) {
      return;
    }
    localObject1 = IAVGameBusinessCtrl.a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((IAVGameBusinessCtrl)localObject1).a();
    if (localObject1 == null) {
      return;
    }
    boolean bool = SecurityPolicyChecker.a().b();
    long l = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    ((AVGameSession)localObject1).a.clear();
    Object localObject2 = new ArrayList(8);
    ((AVGameSession)localObject1).c((List)localObject2);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AVGameUserInfo localAVGameUserInfo = (AVGameUserInfo)((Iterator)localObject2).next();
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
            ((AVGameSession)localObject1).a.add(localVideoViewInfo);
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
            ((AVGameSession)localObject1).a.add(localVideoViewInfo);
          }
          if (localAVGameUserInfo.mSubVideoOn)
          {
            localVideoViewInfo = new VideoViewInfo();
            localVideoViewInfo.jdField_a_of_type_Long = localAVGameUserInfo.mUin;
            localVideoViewInfo.jdField_a_of_type_Int = localAVGameUserInfo.mSubVideoSrc;
            localVideoViewInfo.jdField_a_of_type_Boolean = false;
            ((AVGameSession)localObject1).a.add(localVideoViewInfo);
          }
        }
      }
    }
    if (((AVGameSession)localObject1).a.isEmpty())
    {
      AVLog.a("MultiOperatorImplForGame", "startAVGameVideoRecv fail with empty uinList");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAVGameVideoRecv(((AVGameSession)localObject1).a);
    }
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopAVGameVideoRecv mHasCallExitRoom：=");
    localStringBuilder.append(this.b);
    AVLog.c("MultiOperatorImplForGame", localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && (!this.b)) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv();
    }
  }
  
  public void e()
  {
    try
    {
      AVLog.c("MultiOperatorImplForGame", "exitRoom");
      this.jdField_a_of_type_ComTencentQavQavDef$MultiParams = null;
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      int i = -1;
      AvGameMusicPlayer.b();
      if (Build.VERSION.SDK_INT >= 16) {
        AudioProcess.a();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (AsyncExitTask.a())
        {
          if (this.jdField_a_of_type_ComTencentAvgameQavAsyncExitTask == null) {
            this.jdField_a_of_type_ComTencentAvgameQavAsyncExitTask = new AsyncExitTask();
          }
          i = this.jdField_a_of_type_ComTencentAvgameQavAsyncExitTask.a(a());
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quitRoom(0);
        }
        i();
        this.jdField_a_of_type_Boolean = false;
        this.b = true;
        if (i == 261)
        {
          AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if ((localAppRuntime instanceof AccountReceiver.AccountListener)) {
            ((AccountReceiver.AccountListener)localAppRuntime).b(1006);
          }
        }
      }
      AVGamePerfReporter.a().a(1);
      return;
    }
    finally {}
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    AVLog.c("MultiOperatorImplForGame", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
    QavDef.MultiUserInfo localMultiUserInfo = a(paramLong);
    if (localMultiUserInfo != null)
    {
      localMultiUserInfo.mMicOn = (paramBoolean ^ true);
      a(localMultiUserInfo, bool);
    }
  }
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    boolean bool;
    if (paramInt1 == 93) {
      bool = true;
    } else {
      bool = false;
    }
    ObserverDispatcher.a().a(QavMultiObserver.class, 12, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
  }
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 == 90) && (paramLong1 == 3L)) {
      bool = true;
    } else {
      bool = false;
    }
    ObserverDispatcher.a().a(QavMultiObserver.class, 11, new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
  }
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 15, new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentQavQavDef$MultiParams == null) {
      return;
    }
    if (paramInt1 == 70)
    {
      AVLog.c("MultiOperatorImplForGame", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      if (paramAVUserInfo.account == this.jdField_a_of_type_Long) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        i();
        ObserverDispatcher.a().a(QavMultiObserver.class, 1, new Object[0]);
      }
      paramVarArgs = a(paramAVUserInfo.account);
      if ((paramVarArgs == null) && (paramInt1 == 0))
      {
        paramVarArgs = new QavDef.MultiUserInfo();
        paramVarArgs.mUin = paramAVUserInfo.account;
        paramVarArgs.mMicOn = true;
        a(paramVarArgs);
        paramAVUserInfo = paramVarArgs;
      }
      else
      {
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
      b(paramAVUserInfo);
      return;
    }
    if (paramInt1 == 71)
    {
      AVLog.c("MultiOperatorImplForGame", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      paramAVUserInfo = b(paramAVUserInfo.account);
      if (paramAVUserInfo != null) {
        c(paramAVUserInfo);
      }
    }
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0))
    {
      long l = paramArrayOfLong[0];
      if ((paramInt1 != 42) && (paramInt1 != 43))
      {
        switch (paramInt1)
        {
        default: 
          paramArrayOfLong = new StringBuilder();
          paramArrayOfLong.append("onMultiVideoChatMembersInfoChange, error. type[");
          paramArrayOfLong.append(paramInt1);
          paramArrayOfLong.append("], id[");
          paramArrayOfLong.append(paramLong1);
          paramArrayOfLong.append("], type[");
          paramArrayOfLong.append(paramInt2);
          paramArrayOfLong.append("], user[");
          paramArrayOfLong.append(l);
          paramArrayOfLong.append("]");
          AVLog.d("MultiOperatorImplForGame", paramArrayOfLong.toString());
        }
        for (;;)
        {
          return;
          ObserverDispatcher.a().a(QavMultiObserver.class, 10, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
          continue;
          ObserverDispatcher.a().a(QavMultiObserver.class, 9, new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(paramInt3) });
        }
      }
      boolean bool;
      if (paramInt1 == 42) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayOfLong = a(l);
      if (paramArrayOfLong != null) {
        ObserverDispatcher.a().a(QavMultiObserver.class, 6, new Object[] { paramArrayOfLong, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
      }
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.MultiOperatorImplForGame
 * JD-Core Version:    0.7.0.1
 */