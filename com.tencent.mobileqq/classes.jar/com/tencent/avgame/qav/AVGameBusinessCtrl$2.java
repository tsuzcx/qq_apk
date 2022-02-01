package com.tencent.avgame.qav;

import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSessionManager;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
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
    if (!AVGameBusinessCtrl.e()) {
      return;
    }
    AVLog.d("AVGameBusinessCtrl", "onEnterRoom success.");
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null) {
      return;
    }
    AVGameBusinessCtrl.a(this.a, true);
    AVGameBusinessCtrl.b(this.a, true);
    AVGameBusinessCtrl.c(this.a, false);
    AVGameBusinessCtrl.d(this.a, true);
    ((AVGameSession)???).a(2);
    this.a.c(true);
    this.a.d(true);
    AVGameHandler.a().b().post(new AVGameBusinessCtrl.2.1(this));
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a(AVGameBusinessCtrl.c(this.a).k(), AVGameBusinessCtrl.c(this.a));
    }
    ??? = new IntentFilter();
    ((IntentFilter)???).addAction("android.intent.action.HEADSET_PLUG");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(AVGameBusinessCtrl.d(this.a), (IntentFilter)???);
    if (AVGameBusinessCtrl.e(this.a) != null) {
      AVGameBusinessCtrl.e(this.a).onEnterRoom(0);
    }
    AVGameBusinessCtrl.a(this.a, null);
    AVGameBusinessCtrl.f(this.a);
    AVGamePerfReporter.a().a("param_QAVEnterRoom", 0);
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onError, errorType[");
    ((StringBuilder)???).append(paramInt);
    ((StringBuilder)???).append("]");
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    if ((paramInt != 2) && (paramInt != 1)) {
      break label184;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onEnterRoom failed. errorType = ");
    ((StringBuilder)???).append(paramInt);
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    if (AVGameBusinessCtrl.a(this.a).a() == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onEnterRoom failed. session == null.");
      return;
    }
    AVGameBusinessCtrl.a(this.a).b(AVGameBusinessCtrl.a(this.a).a().b);
    ReportController.b(null, "dc00898", "", "", "0X800B041", "0X800B041", 0, 0, "", "", "", "");
    if (AVGameBusinessCtrl.e(this.a) != null) {
      AVGameBusinessCtrl.e(this.a).onEnterRoom(paramInt);
    }
    AVGameBusinessCtrl.a(this.a, null);
    label184:
    AVGamePerfReporter.a().a("param_QAVEnterRoom", paramInt);
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramInt);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserFirstVideoFrameIn. userUin = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", videoSrcType = ");
    localStringBuilder.append(paramInt);
    AVLog.c("AVGameBusinessCtrl", localStringBuilder.toString());
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onUserEnter. uin = ");
    ((StringBuilder)???).append(paramMultiUserInfo.mUin);
    ((StringBuilder)???).append(", isMicOn = ");
    ((StringBuilder)???).append(paramMultiUserInfo.mMicOn);
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserEnter failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a(paramMultiUserInfo);
    Object localObject2;
    if (??? != null)
    {
      ((AVGameUserInfo)???).mEnterTime = System.currentTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUserEnter time is ");
      ((StringBuilder)localObject2).append(((AVGameUserInfo)???).mEnterTime);
      AVLog.d("AVGameBusinessCtrl", ((StringBuilder)localObject2).toString());
    }
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      localObject2 = AVGameBusinessCtrl.g(this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramMultiUserInfo);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramMultiUserInfo;
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onUserAudioAvailable. uin = ");
    ((StringBuilder)???).append(paramMultiUserInfo.mUin);
    ((StringBuilder)???).append(", available = ");
    ((StringBuilder)???).append(paramBoolean);
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserAudioAvailable failed. session == null.");
      return;
    }
    ((AVGameSession)???).a(paramMultiUserInfo);
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramMultiUserInfo;
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
    int i;
    if (((AVGameUserInfo)???).mIsSpeaking != paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    ((AVGameUserInfo)???).mIsSpeaking = paramBoolean;
    ((AVGameUserInfo)???).mAudioEnergy = paramInt;
    if ((QLog.isDevelopLevel()) || (i != 0))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onUserSpeaking. uin[ ");
      ((StringBuilder)???).append(paramMultiUserInfo.mUin);
      ((StringBuilder)???).append("], isSpeaking[");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append("], audioEnergy[");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append("]");
      AVLog.d("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    }
    if ((paramBoolean) && (paramInt < 10)) {
      return;
    }
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean, paramInt);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramMultiUserInfo;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUserUpdate. uin = ");
      localStringBuilder.append(localMultiUserInfo.mUin);
      localStringBuilder.append(", isMicOn = ");
      localStringBuilder.append(localMultiUserInfo.mMicOn);
      AVLog.d("AVGameBusinessCtrl", localStringBuilder.toString());
      ((AVGameSession)???).a(localMultiUserInfo);
      ((List)localObject2).add(Long.valueOf(localMultiUserInfo.mUin));
    }
    ((AVGameSession)???).a((List)localObject2);
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      localObject2 = AVGameBusinessCtrl.g(this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((WeakReference)localObject3).get() != null)) {
          ((AVGameUIEventCallback)((WeakReference)localObject3).get()).a(paramList);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onSystemCallStateChanged, isCalling[");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append("], enter[");
      ((StringBuilder)???).append(AVGameBusinessCtrl.h(this.a));
      ((StringBuilder)???).append("]");
      QLog.i("AVGameBusinessCtrl", 2, ((StringBuilder)???).toString());
    }
    if (paramBoolean) {
      AVGameBusinessCtrl.i(this.a);
    } else {
      AVGameBusinessCtrl.j(this.a);
    }
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(paramBoolean);
        }
      }
      if ((paramBoolean) && (AVGameBusinessCtrl.h(this.a))) {
        CallingStateMonitor.a().f();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject1 = AVGameSession.a(paramInt, paramLong);
    localObject1 = AVGameBusinessCtrl.a(this.a).a((String)localObject1);
    if (localObject1 == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onGoOnStageRet failed. session == null.");
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGoOnStageRet, ret[");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], relationId[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], relationType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("]");
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)localObject2).toString());
    if (paramBoolean)
    {
      if (((AVGameSession)localObject1).m == 1)
      {
        localObject2 = this.a.m();
        if (localObject2 != null) {
          ((AVGameCameraAssistant)localObject2).a((AVGameSession)localObject1);
        }
      }
    }
    else if (((AVGameSession)localObject1).c(1))
    {
      localObject2 = this.a.m();
      if (localObject2 != null) {
        ((AVGameCameraAssistant)localObject2).b((AVGameSession)localObject1);
      }
    }
    else if (((AVGameSession)localObject1).m == 1)
    {
      ((AVGameSession)localObject1).b(0);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramInt);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onUserExit. uin = ");
    ((StringBuilder)???).append(paramMultiUserInfo.mUin);
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    ??? = AVGameBusinessCtrl.a(this.a).a();
    if (??? == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onUserExit failed. session == null.");
      return;
    }
    ((AVGameSession)???).b(paramMultiUserInfo.mUin);
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramMultiUserInfo);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramMultiUserInfo;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onVideoChatCallStateChanged, isCalling[");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append("], enter[");
      ((StringBuilder)???).append(AVGameBusinessCtrl.h(this.a));
      ((StringBuilder)???).append("]");
      QLog.i("AVGameBusinessCtrl", 2, ((StringBuilder)???).toString());
    }
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).b(paramBoolean);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject1 = AVGameSession.a(paramInt, paramLong);
    localObject1 = AVGameBusinessCtrl.a(this.a).a((String)localObject1);
    if (localObject1 == null)
    {
      AVLog.a("AVGameBusinessCtrl", "onGoOffStageRet failed. session == null.");
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGoOffStageRet, ret[");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], relationId[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], relationType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("]");
    AVLog.d("AVGameBusinessCtrl", ((StringBuilder)localObject2).toString());
    if (((AVGameSession)localObject1).c(1))
    {
      localObject2 = this.a.m();
      if (localObject2 != null) {
        ((AVGameCameraAssistant)localObject2).b((AVGameSession)localObject1);
      }
    }
    else
    {
      ((AVGameSession)localObject1).b(0);
    }
  }
  
  public void c(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onStartRemoteVideoRequestResult. success = ");
    boolean bool;
    if (paramInt == 96) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)???).append(bool);
    AVLog.c("AVGameBusinessCtrl", ((StringBuilder)???).toString());
    synchronized (AVGameBusinessCtrl.g(this.a))
    {
      Iterator localIterator = AVGameBusinessCtrl.g(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).c(paramInt);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl.2
 * JD-Core Version:    0.7.0.1
 */