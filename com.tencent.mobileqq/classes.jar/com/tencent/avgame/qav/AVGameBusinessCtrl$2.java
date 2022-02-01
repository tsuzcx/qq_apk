package com.tencent.avgame.qav;

import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSessionManager;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.controller.multi.QavMultiObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

class AVGameBusinessCtrl$2
  extends QavMultiObserver
{
  AVGameBusinessCtrl$2(AVGameBusinessCtrl paramAVGameBusinessCtrl) {}
  
  public void a()
  {
    if (!AVGameBusinessCtrl.b()) {}
    do
    {
      return;
      AVLog.d("AVGameBusinessCtrl", "onEnterRoom success.");
      ??? = AVGameBusinessCtrl.a(this.a).a();
    } while (??? == null);
    AVGameBusinessCtrl.a(this.a, true);
    AVGameBusinessCtrl.b(this.a, true);
    AVGameBusinessCtrl.c(this.a, false);
    AVGameBusinessCtrl.d(this.a, true);
    ((AVGameSession)???).a(2);
    this.a.c(true);
    this.a.d(true);
    AVGameHandler.a().a().post(new AVGameBusinessCtrl.2.1(this));
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a(AVGameBusinessCtrl.a(this.a).a(), AVGameBusinessCtrl.a(this.a));
    }
    ??? = new IntentFilter();
    ((IntentFilter)???).addAction("android.intent.action.HEADSET_PLUG");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(AVGameBusinessCtrl.a(this.a), (IntentFilter)???);
    if (AVGameBusinessCtrl.a(this.a) != null) {
      AVGameBusinessCtrl.a(this.a).a(0);
    }
    AVGameBusinessCtrl.a(this.a, null);
    AVGameBusinessCtrl.b(this.a);
    AVGamePerfReporter.a().a("param_QAVEnterRoom", 0);
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    AVLog.d("AVGameBusinessCtrl", "onError, errorType[" + paramInt + "]");
    if ((paramInt == 2) || (paramInt == 1))
    {
      AVLog.d("AVGameBusinessCtrl", "onEnterRoom failed. errorType = " + paramInt);
      if (AVGameBusinessCtrl.a(this.a).a() == null)
      {
        AVLog.a("AVGameBusinessCtrl", "onEnterRoom failed. session == null.");
        return;
      }
      AVGameBusinessCtrl.a(this.a).b(AVGameBusinessCtrl.a(this.a).a().a);
      ReportController.b(null, "dc00898", "", "", "0X800B041", "0X800B041", 0, 0, "", "", "", "");
      if (AVGameBusinessCtrl.a(this.a) != null) {
        AVGameBusinessCtrl.a(this.a).a(paramInt);
      }
      AVGameBusinessCtrl.a(this.a, null);
    }
    for (;;)
    {
      AVGamePerfReporter.a().a("param_QAVEnterRoom", paramInt);
      synchronized (AVGameBusinessCtrl.a(this.a))
      {
        Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((AVGameUIEventCallback)localWeakReference.get()).a(paramInt);
      }
      if ((paramInt == 4) || (paramInt != 3)) {}
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    AVLog.c("AVGameBusinessCtrl", "onUserFirstVideoFrameIn. userUin = " + paramLong + ", videoSrcType = " + paramInt);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    AVLog.d("AVGameBusinessCtrl", "onUserEnter. uin = " + paramMultiUserInfo.mUin + ", isMicOn = " + paramMultiUserInfo.mMicOn);
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserEnter failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a(paramMultiUserInfo);
    if (??? != null)
    {
      ((AVGameUserInfo)???).mEnterTime = System.currentTimeMillis();
      AVLog.d("AVGameBusinessCtrl", "onUserEnter time is " + ((AVGameUserInfo)???).mEnterTime);
    }
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    AVLog.d("AVGameBusinessCtrl", "onUserAudioAvailable. uin = " + paramMultiUserInfo.mUin + ", available = " + paramBoolean);
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserAudioAvailable failed. session == null.");
      return;
    }
    ((AVGameSession)???).a(paramMultiUserInfo);
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean);
        }
      }
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt)
  {
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserSpeaking failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a(paramMultiUserInfo);
    if (((AVGameUserInfo)???).mIsSpeaking != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((AVGameUserInfo)???).mIsSpeaking = paramBoolean;
      ((AVGameUserInfo)???).mAudioEnergy = paramInt;
      if ((QLog.isDevelopLevel()) || (i != 0)) {
        AVLog.d("AVGameBusinessCtrl", "onUserSpeaking. uin[ " + paramMultiUserInfo.mUin + "], isSpeaking[" + paramBoolean + "], audioEnergy[" + paramInt + "]");
      }
      if ((paramBoolean) && (paramInt < 10)) {
        break;
      }
      synchronized (AVGameBusinessCtrl.a(this.a))
      {
        Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((AVGameUIEventCallback)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean, paramInt);
      }
    }
  }
  
  public void a(List<QavDef.MultiUserInfo> paramList)
  {
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserUpdate failed. session == null.");
      return;
    }
    Object localObject2 = new ArrayList(paramList.size());
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)((Iterator)localObject3).next();
      AVLog.d("AVGameBusinessCtrl", "onUserUpdate. uin = " + localMultiUserInfo.mUin + ", isMicOn = " + localMultiUserInfo.mMicOn);
      ((AVGameSession)???).a(localMultiUserInfo);
      ((List)localObject2).add(Long.valueOf(localMultiUserInfo.mUin));
    }
    ((AVGameSession)???).a((List)localObject2);
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      localObject2 = AVGameBusinessCtrl.a(this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((WeakReference)localObject3).get() != null)) {
          ((AVGameUIEventCallback)((WeakReference)localObject3).get()).a(paramList);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "onSystemCallStateChanged, isCalling[" + paramBoolean + "], enter[" + AVGameBusinessCtrl.a(this.a) + "]");
    }
    if (paramBoolean) {
      AVGameBusinessCtrl.c(this.a);
    }
    for (;;)
    {
      synchronized (AVGameBusinessCtrl.a(this.a))
      {
        Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() == null)) {
          continue;
        }
        ((AVGameUIEventCallback)localWeakReference.get()).a(paramBoolean);
      }
      AVGameBusinessCtrl.d(this.a);
    }
    if ((paramBoolean) && (AVGameBusinessCtrl.a(this.a))) {
      CallingStateMonitor.a().c();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = AVGameSession.a(paramInt, paramLong);
    localObject = AVGameBusinessCtrl.a(this.a).a((String)localObject);
    if (localObject == null) {
      AVLog.a("AVGameBusinessCtrl", "onGoOnStageRet failed. session == null.");
    }
    do
    {
      AVGameCameraAssistant localAVGameCameraAssistant;
      do
      {
        do
        {
          do
          {
            return;
            AVLog.d("AVGameBusinessCtrl", "onGoOnStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
            if (!paramBoolean) {
              break;
            }
          } while (((AVGameSession)localObject).d != 1);
          localAVGameCameraAssistant = this.a.a();
        } while (localAVGameCameraAssistant == null);
        localAVGameCameraAssistant.a((AVGameSession)localObject);
        return;
        if (!((AVGameSession)localObject).a(1)) {
          break;
        }
        localAVGameCameraAssistant = this.a.a();
      } while (localAVGameCameraAssistant == null);
      localAVGameCameraAssistant.b((AVGameSession)localObject);
      return;
    } while (((AVGameSession)localObject).d != 1);
    ((AVGameSession)localObject).b(0);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 1;
    AVLog.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. videoIn = " + paramBoolean + ", userUin = " + paramLong1);
    ??? = AVGameSession.a(paramInt1, paramLong2);
    ??? = AVGameBusinessCtrl.a(this.a).a((String)???);
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onMemberVideoInOrOut failed. session == null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((AVGameSession)???).a(paramLong1, paramBoolean, paramInt1);
      AVLog.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. updateUserCameraVideoStatus result = " + bool);
      synchronized (AVGameBusinessCtrl.a(this.a))
      {
        Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((AVGameUIEventCallback)localWeakReference.get()).a(paramBoolean, paramLong1, 1);
      }
    }
  }
  
  public void b(int paramInt)
  {
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onSelfVolumeUpdate failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a();
    if (??? != null) {
      ((AVGameUserInfo)???).mVolumeValue = paramInt;
    }
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramInt);
        }
      }
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    AVLog.d("AVGameBusinessCtrl", "onUserExit. uin = " + paramMultiUserInfo.mUin);
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserExit failed. session == null.");
      return;
    }
    ((AVGameSession)???).a(paramMultiUserInfo.mUin);
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "onVideoChatCallStateChanged, isCalling[" + paramBoolean + "], enter[" + AVGameBusinessCtrl.a(this.a) + "]");
    }
    synchronized (AVGameBusinessCtrl.a(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramBoolean);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = AVGameSession.a(paramInt, paramLong);
    localObject = AVGameBusinessCtrl.a(this.a).a((String)localObject);
    if (localObject == null) {
      AVLog.a("AVGameBusinessCtrl", "onGoOffStageRet failed. session == null.");
    }
    AVGameCameraAssistant localAVGameCameraAssistant;
    do
    {
      return;
      AVLog.d("AVGameBusinessCtrl", "onGoOffStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
      if (!((AVGameSession)localObject).a(1)) {
        break;
      }
      localAVGameCameraAssistant = this.a.a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.b((AVGameSession)localObject);
    return;
    ((AVGameSession)localObject).b(0);
  }
  
  public void c(int paramInt)
  {
    ??? = new StringBuilder().append("onStartRemoteVideoRequestResult. success = ");
    if (paramInt == 96) {}
    for (boolean bool = true;; bool = false)
    {
      AVLog.c("AVGameBusinessCtrl", bool);
      synchronized (AVGameBusinessCtrl.a(this.a))
      {
        Iterator localIterator = AVGameBusinessCtrl.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((AVGameUIEventCallback)localWeakReference.get()).c(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl.2
 * JD-Core Version:    0.7.0.1
 */