package com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

class RMVideoInitState
  extends RMVideoState
{
  boolean a = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = true;
  public boolean f = true;
  final Runnable g = new RMVideoInitState.2(this);
  
  public void a()
  {
    this.d = false;
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr != null)
    {
      if (localRMVideoStateMgr.B != null) {
        localRMVideoStateMgr.B.a(localRMVideoStateMgr);
      }
      if (localRMVideoStateMgr.v != null) {
        localRMVideoStateMgr.v.a();
      }
      if (!localRMVideoStateMgr.q) {
        this.c = false;
      }
      if (!this.c)
      {
        d();
        return;
      }
      localRMVideoStateMgr.t();
      c();
    }
  }
  
  public void a(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct)
  {
    paramAVCodecCallback = RMVideoStateMgr.a();
    if (paramMessageStruct.mId != 33554435) {
      return;
    }
    paramAVCodecCallback.s = ((String)paramMessageStruct.mObj0);
    this.a = true;
    paramAVCodecCallback.g = null;
    if (QLog.isColorLevel())
    {
      paramMessageStruct = new StringBuilder();
      paramMessageStruct.append("[@] onAVCodecEvent[RMFileEventNotify] path=");
      paramMessageStruct.append(paramAVCodecCallback.s);
      paramMessageStruct.append(",files : ");
      paramMessageStruct.append(Arrays.toString(new File(paramAVCodecCallback.s).list()));
      QLog.d("RMVideoInitState", 2, paramMessageStruct.toString());
    }
    paramAVCodecCallback.I.post(new RMVideoInitState.4(this));
    f();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if ((paramObject instanceof CameraProxy.CameraPreviewObservable))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 12)
          {
            if (!this.d)
            {
              this.d = true;
              RMVideoStateMgr.a().a(2002, HardCodeUtil.a(2131910936), false);
            }
            if (QLog.isColorLevel()) {
              QLog.d("RMVideoInitState", 2, "[@] EVENT_CAMERA_DISABLED error");
            }
          }
        }
        else if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof String)))
        {
          if (!this.d)
          {
            this.d = true;
            RMVideoStateMgr.a().a(2003, HardCodeUtil.a(2131910938), false);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[@] EVENT_SET_CAMERA_PARAM error, error = ");
            ((StringBuilder)localObject).append(paramVarArgs[0]);
            QLog.d("RMVideoInitState", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      else if (paramVarArgs != null) {
        if ((paramVarArgs[0] instanceof Boolean))
        {
          this.b = true;
          f();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[@] EVENT_CREATE_CAMERA[success] obj= ");
            ((StringBuilder)localObject).append(paramVarArgs[0]);
            QLog.d("RMVideoInitState", 2, ((StringBuilder)localObject).toString());
          }
          localObject = BaseApplicationImpl.sApplication.getQQProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story"))) {
            StoryReportor.b("take_video", "camera_initial", 0, 0, new String[0]);
          }
          ThreadManager.post(new RMVideoInitState.5(this), 8, null, true);
        }
        else if ((paramVarArgs[0] instanceof String))
        {
          if (!this.d)
          {
            this.d = true;
            RMVideoStateMgr.a().a(2002, HardCodeUtil.a(2131910943), false);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[@] EVENT_CREATE_CAMERA, error = ");
            ((StringBuilder)localObject).append(paramVarArgs[0]);
            QLog.d("RMVideoInitState", 2, ((StringBuilder)localObject).toString());
          }
          localObject = BaseApplicationImpl.sApplication.getQQProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story"))) {
            StoryReportor.b("take_video", "camera_initial", 0, -1, new String[0]);
          }
        }
      }
    }
    else if ((paramObject instanceof AudioCapture))
    {
      localObject = RMVideoStateMgr.a();
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt == 6) {
            if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof Boolean)) && (((Boolean)paramVarArgs[0]).booleanValue()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [OK]");
              }
              ((RMVideoStateMgr)localObject).c(true);
              f();
              ((RMVideoStateMgr)localObject).r = true;
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [error]麦克风启动录制失败...");
              }
              ((RMVideoStateMgr)localObject).p = null;
              ((RMVideoStateMgr)localObject).r = false;
              if (RMVideoStateMgr.l)
              {
                ((RMVideoStateMgr)localObject).c(true);
                f();
              }
              else
              {
                ((RMVideoStateMgr)localObject).c(false);
              }
              if (!((RMVideoStateMgr)localObject).z)
              {
                RMVideoStateMgr.a().b(0, HardCodeUtil.a(2131910934), false);
                ((RMVideoStateMgr)localObject).z = true;
              }
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_OPEN_MIC [error]麦克风打开失败...");
          }
          ((RMVideoStateMgr)localObject).p = null;
          ((RMVideoStateMgr)localObject).r = false;
          if (RMVideoStateMgr.l)
          {
            ((RMVideoStateMgr)localObject).c(true);
            f();
          }
          else
          {
            ((RMVideoStateMgr)localObject).c(false);
          }
          if (!((RMVideoStateMgr)localObject).z)
          {
            RMVideoStateMgr.a().b(0, HardCodeUtil.a(2131910939), false);
            ((RMVideoStateMgr)localObject).z = true;
          }
        }
      }
      else if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof Boolean)) && (((Boolean)paramVarArgs[0]).booleanValue()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [OK]");
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]麦克风初始化参数失败...");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] EVENT_INIT [error]mAudioSampleRate=");
          localStringBuilder.append(CodecParam.mAudioSampleRate);
          localStringBuilder.append(" mAudioChannel=");
          localStringBuilder.append(CodecParam.mAudioChannel);
          localStringBuilder.append(" mAudioFormat=");
          localStringBuilder.append(CodecParam.mAudioFormat);
          QLog.d("RMVideoInitState", 2, localStringBuilder.toString());
        }
        ((RMVideoStateMgr)localObject).p = null;
        ((RMVideoStateMgr)localObject).r = false;
        ((RMVideoStateMgr)localObject).c(false);
        if (((RMVideoStateMgr)localObject).I != null) {
          ((RMVideoStateMgr)localObject).I.post(new RMVideoInitState.6(this));
        } else if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [Error]麦克风参数初始化失败 ,rmStateMgr.mHandler = null");
        }
      }
    }
    super.a(paramObject, paramInt, paramVarArgs);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    if (e()) {
      RMVideoStateMgr.a().a(3);
    }
  }
  
  void c()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] retake called");
    }
    if (localRMVideoStateMgr.p != null) {
      localRMVideoStateMgr.p.a();
    }
    try
    {
      localRMVideoStateMgr.r();
      if (this.e)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().retake()");
        }
        AVCodec.get().retake();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().init()");
        }
        AVCodec.get().init();
        this.e = true;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    if (localRMVideoStateMgr.o != null) {
      localRMVideoStateMgr.o.reset();
    }
    RecordManager.a().d().a(0);
  }
  
  void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit called");
    }
    localRMVideoStateMgr.I.postDelayed(new RMVideoInitState.1(this), 50L);
  }
  
  boolean e()
  {
    return (RMVideoStateMgr.a().q) && (this.a) && (this.b);
  }
  
  void f()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (e())
    {
      localRMVideoStateMgr.I.removeCallbacks(this.g);
      localRMVideoStateMgr.I.post(new RMVideoInitState.3(this));
    }
  }
  
  public void g()
  {
    RMVideoStateMgr.a().u();
    this.c = false;
  }
  
  public void h()
  {
    RMVideoStateMgr.a().u();
    this.c = false;
    this.a = false;
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState
 * JD-Core Version:    0.7.0.1
 */