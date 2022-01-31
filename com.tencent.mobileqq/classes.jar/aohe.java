import android.os.Handler;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoState;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import java.io.File;
import java.util.Arrays;

public class aohe
  extends RMVideoState
{
  final Runnable jdField_a_of_type_JavaLangRunnable = new aohh(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = true;
  public boolean f = true;
  public volatile boolean g;
  
  public void a()
  {
    this.d = false;
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr != null)
    {
      ThreadManager.post(new aohf(this, localRMVideoStateMgr), 8, null, false);
      if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.n();
      }
      if (!localRMVideoStateMgr.d) {
        this.c = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] initState " + this.c);
      }
      try
      {
        if ((!this.c) && (!this.g))
        {
          this.g = true;
          d();
        }
        for (;;)
        {
          return;
          localRMVideoStateMgr.l();
          c();
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct)
  {
    paramAVCodecCallback = RMVideoStateMgr.a();
    switch (paramMessageStruct.mId)
    {
    default: 
      return;
    }
    paramAVCodecCallback.jdField_a_of_type_JavaLangString = ((String)paramMessageStruct.mObj0);
    this.jdField_a_of_type_Boolean = true;
    paramAVCodecCallback.jdField_a_of_type_Aohb = null;
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] onAVCodecEvent[RMFileEventNotify] path=" + paramAVCodecCallback.jdField_a_of_type_JavaLangString + ",files : " + Arrays.toString(new File(paramAVCodecCallback.jdField_a_of_type_JavaLangString).list()));
    }
    paramAVCodecCallback.jdField_a_of_type_AndroidOsHandler.post(new aohj(this));
    e();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramObject instanceof CameraProxy.CameraPreviewObservable)) {
      switch (paramInt)
      {
      }
    }
    Object localObject;
    for (;;)
    {
      super.a(paramObject, paramInt, paramVarArgs);
      return;
      if (paramVarArgs != null) {
        if ((paramVarArgs[0] instanceof Boolean))
        {
          this.b = true;
          e();
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA[success] obj= " + paramVarArgs[0]);
          }
          localObject = BaseApplicationImpl.sApplication.getProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story"))) {
            StoryReportor.b("take_video", "camera_initial", 0, 0, new String[0]);
          }
          ThreadManager.post(new aohk(this), 8, null, true);
        }
        else if ((paramVarArgs[0] instanceof String))
        {
          if (!this.d)
          {
            this.d = true;
            RMVideoStateMgr.a().a(2002, "抱歉，初始化摄像头失败", false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA, error = " + paramVarArgs[0]);
          }
          if (1 == FlowCameraMqqAction.a) {
            QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "2", null);
          }
          localObject = BaseApplicationImpl.sApplication.getProcessName();
          if ((localObject != null) && (((String)localObject).endsWith(":story")))
          {
            StoryReportor.b("take_video", "camera_initial", 0, -1, new String[0]);
            continue;
            if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof String)))
            {
              if (!this.d)
              {
                this.d = true;
                RMVideoStateMgr.a().a(2003, "抱歉，初始化摄像头参数失败，请重试", false);
              }
              if (QLog.isColorLevel())
              {
                QLog.d("RMVideoInitState", 2, "[@] EVENT_SET_CAMERA_PARAM error, error = " + paramVarArgs[0]);
                continue;
                if (!this.d)
                {
                  this.d = true;
                  RMVideoStateMgr.a().a(2002, "抱歉，摄像头被禁止了", false);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RMVideoInitState", 2, "[@] EVENT_CAMERA_DISABLED error");
                }
                if (1 == FlowCameraMqqAction.a)
                {
                  QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "4", null);
                  continue;
                  if ((paramObject instanceof AudioCapture))
                  {
                    localObject = RMVideoStateMgr.a();
                    switch (paramInt)
                    {
                    case 4: 
                    default: 
                      break;
                    case 3: 
                      if ((paramVarArgs != null) && ((paramVarArgs[0] instanceof Boolean)) && (((Boolean)paramVarArgs[0]).booleanValue()))
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
                          QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]mAudioSampleRate=" + CodecParam.q + " mAudioChannel=" + CodecParam.o + " mAudioFormat=" + CodecParam.p);
                        }
                        ((RMVideoStateMgr)localObject).jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
                        ((RMVideoStateMgr)localObject).e = false;
                        ((RMVideoStateMgr)localObject).c(false);
                        if (((RMVideoStateMgr)localObject).jdField_a_of_type_AndroidOsHandler != null) {
                          ((RMVideoStateMgr)localObject).jdField_a_of_type_AndroidOsHandler.post(new aohl(this));
                        }
                        while (1 == FlowCameraMqqAction.a)
                        {
                          QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "5", null);
                          break;
                          if (QLog.isColorLevel()) {
                            QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [Error]麦克风参数初始化失败 ,rmStateMgr.mHandler = null");
                          }
                        }
                      }
                      break;
                    case 5: 
                      if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_OPEN_MIC [error]麦克风打开失败...");
                      }
                      ((RMVideoStateMgr)localObject).jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
                      ((RMVideoStateMgr)localObject).e = false;
                      if (RMVideoStateMgr.c)
                      {
                        ((RMVideoStateMgr)localObject).c(true);
                        e();
                      }
                      for (;;)
                      {
                        if (!((RMVideoStateMgr)localObject).h)
                        {
                          RMVideoStateMgr.a().b(0, "麦克风被禁用", false);
                          ((RMVideoStateMgr)localObject).h = true;
                        }
                        if (1 != FlowCameraMqqAction.a) {
                          break;
                        }
                        QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "6", null);
                        break;
                        ((RMVideoStateMgr)localObject).c(false);
                      }
                    case 6: 
                      if ((paramVarArgs == null) || (!(paramVarArgs[0] instanceof Boolean)) || (!((Boolean)paramVarArgs[0]).booleanValue())) {
                        break label881;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [OK]");
                      }
                      ((RMVideoStateMgr)localObject).c(true);
                      e();
                      ((RMVideoStateMgr)localObject).e = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label881:
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [error]麦克风启动录制失败...");
    }
    ((RMVideoStateMgr)localObject).jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    ((RMVideoStateMgr)localObject).e = false;
    if (RMVideoStateMgr.c)
    {
      ((RMVideoStateMgr)localObject).c(true);
      e();
    }
    for (;;)
    {
      if (!((RMVideoStateMgr)localObject).h)
      {
        RMVideoStateMgr.a().b(0, "麦克风被禁用", false);
        ((RMVideoStateMgr)localObject).h = true;
      }
      if (1 != FlowCameraMqqAction.a) {
        break;
      }
      QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "7", null);
      break;
      ((RMVideoStateMgr)localObject).c(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    RMVideoStateMgr.a().a("RMVideoInitState");
    return false;
  }
  
  public void b()
  {
    if (b()) {
      RMVideoStateMgr.a().a(3);
    }
  }
  
  boolean b()
  {
    return (RMVideoStateMgr.a().d) && (this.jdField_a_of_type_Boolean) && (this.b);
  }
  
  void c()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] retake called");
    }
    if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    for (;;)
    {
      try
      {
        localRMVideoStateMgr.j();
        if (!this.e) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().retake()");
        }
        AVCodec.get().retake();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        continue;
      }
      if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.reset();
      }
      RecordManager.a().a().a(0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().init()");
      }
      AVCodec.get().init();
      this.e = true;
    }
  }
  
  void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit called");
    }
    localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.postDelayed(new aohg(this), 50L);
  }
  
  void e()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (b())
    {
      localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.post(new aohi(this));
    }
  }
  
  public void f()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.m();
    localRMVideoStateMgr.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.c = false;
  }
  
  public void g()
  {
    RMVideoStateMgr.a().m();
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohe
 * JD-Core Version:    0.7.0.1
 */