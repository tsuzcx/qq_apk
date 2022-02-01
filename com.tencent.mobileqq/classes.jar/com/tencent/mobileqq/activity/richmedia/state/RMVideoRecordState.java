package com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class RMVideoRecordState
  extends RMVideoState
{
  private boolean a = false;
  private long b = 0L;
  
  private void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[@] [startRecordVideo]Lock.CAPTURE_LOCK=");
      ((StringBuilder)???).append(Lock.b);
      QLog.d("RMRecordState", 2, ((StringBuilder)???).toString());
    }
    if (!Lock.b) {
      synchronized (Lock.a)
      {
        Lock.b = true;
        Lock.a.notifyAll();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[@] [startRecordVideo]Lock.CAPTURE_LOCK=");
          ((StringBuilder)???).append(Lock.b);
          QLog.d("RMRecordState", 2, ((StringBuilder)???).toString());
        }
        AVCodec.get().startCapture();
        localRMVideoStateMgr.o.startCapture();
        if (localRMVideoStateMgr.x()) {
          localRMVideoStateMgr.j();
        }
        if ((localRMVideoStateMgr.p != null) && (localRMVideoStateMgr.w())) {
          localRMVideoStateMgr.p.j();
        }
        this.b = System.currentTimeMillis();
        return;
      }
    }
  }
  
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.v.cb_();
    localRMVideoStateMgr.r();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
    }
    this.a = false;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] initState end");
    }
  }
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramTCTimerCallback = RMVideoStateMgr.a();
    if (paramTCTimerCallback.b) {
      paramTCTimerCallback.n = (System.currentTimeMillis() - paramTCTimerCallback.c);
    } else {
      paramTCTimerCallback.n = paramInt1;
    }
    if (!this.a)
    {
      this.a = paramBoolean;
      if ((paramTCTimerCallback.v()) && (!paramTCTimerCallback.p.s) && (!paramTCTimerCallback.z)) {
        paramTCTimerCallback.I.post(new RMVideoRecordState.2(this));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[@] timeExpire: mIsRecordOver=");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" mStateMgr.mTotalTime=");
        ((StringBuilder)localObject).append(paramTCTimerCallback.n);
        QLog.d("RMRecordState", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramTCTimerCallback.v;
      double d1 = paramTCTimerCallback.n;
      double d2 = RecordManager.a().d().a();
      Double.isNaN(d2);
      ((RMViewSTInterface)localObject).a((int)(d1 + d2), this.a);
      if (this.a) {
        paramTCTimerCallback.I.post(new RMVideoRecordState.3(this));
      }
    }
  }
  
  public void b()
  {
    c();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a(2);
    localRMVideoStateMgr.q();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
    }
  }
  
  public void c()
  {
    Object localObject = RMVideoStateMgr.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] [stopRecordVideo]Lock.CAPTURE_LOCK = ");
      localStringBuilder.append(Lock.b);
      QLog.d("RMRecordState", 2, localStringBuilder.toString());
    }
    if (Lock.b)
    {
      Lock.b = false;
      long l1 = System.currentTimeMillis();
      this.b = (l1 - this.b);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] [stopRecordVideo] current=");
        localStringBuilder.append(l1);
        localStringBuilder.append(" timestamp=");
        localStringBuilder.append(this.b);
        QLog.d("RMRecordState", 2, localStringBuilder.toString());
      }
      if (this.a) {
        ((RMVideoStateMgr)localObject).n = CodecParam.RECORD_MAX_TIME;
      }
      ((RMVideoStateMgr)localObject).v.f();
      ((RMVideoStateMgr)localObject).o.stopCapture();
      if (((RMVideoStateMgr)localObject).p != null) {
        ((RMVideoStateMgr)localObject).p.k();
      }
      if (((RMVideoStateMgr)localObject).x())
      {
        if (((RMVideoStateMgr)localObject).B != null) {
          ((RMVideoStateMgr)localObject).C = ((RMVideoStateMgr)localObject).B.b((RMVideoStateMgr)localObject);
        }
        ((RMVideoStateMgr)localObject).k();
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new RMVideoRecordState.1(this, (RMVideoStateMgr)localObject));
      AVCodec.get().stopCapture();
      long l2 = ((RMVideoStateMgr)localObject).v.l();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] [stopRecordVideo] timeLimit=");
        localStringBuilder.append(l2);
        localStringBuilder.append(" timestamp=");
        localStringBuilder.append(this.b);
        QLog.d("RMRecordState", 2, localStringBuilder.toString());
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = this.b;
      }
      if ((l1 < 500L) && (!this.a))
      {
        ((RMVideoStateMgr)localObject).v.a(true);
        ((RMVideoStateMgr)localObject).a(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[@] stopRecordVideo end Lock.CAPTURE_LOCK = ");
        ((StringBuilder)localObject).append(Lock.b);
        QLog.d("RMRecordState", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void g()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState
 * JD-Core Version:    0.7.0.1
 */