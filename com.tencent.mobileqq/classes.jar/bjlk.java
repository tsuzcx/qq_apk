import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreateContextException;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLMakeCurrentException;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class bjlk
  implements Handler.Callback
{
  private static boolean jdField_a_of_type_Boolean = awii.c(awii.z);
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public bjll a;
  private bjlm jdField_a_of_type_Bjlm;
  bjln jdField_a_of_type_Bjln;
  GLVideoClipUtil jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil;
  private PreviewContext jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext;
  OffScreenInputSurface jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int jdField_b_of_type_Int;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  private bjlt a()
  {
    bjlt localbjlt = this.jdField_a_of_type_Bjll.a.b();
    if (localbjlt != null) {
      return localbjlt;
    }
    localbjlt = this.jdField_a_of_type_Bjll.a.a();
    if (localbjlt != null)
    {
      this.jdField_a_of_type_Bjln.a(localbjlt.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return localbjlt;
    }
    return null;
  }
  
  private void a(AVIOStruct paramAVIOStruct)
  {
    this.jdField_a_of_type_Bjlm.jdField_a_of_type_Int = paramAVIOStruct.pFrameIndex;
    paramAVIOStruct.pFrameIndex = 0;
    this.jdField_a_of_type_Bjlm.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bjlm.jdField_b_of_type_Int = 0;
    bjbu.a("handleMessage:writeVideoFrame[false]  mThumbPicControl.mSendThumbOKIndex=" + this.jdField_a_of_type_Bjlm.jdField_a_of_type_Int);
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    bool1 = false;
    synchronized (bjll.a(this.jdField_a_of_type_Bjll))
    {
      Object localObject2 = bjll.a(this.jdField_a_of_type_Bjll);
      if (localObject2 == null) {
        return false;
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) && ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.b()) || (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.a((EGLContext)localObject2))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]1 glContextH=" + OffScreenInputSurface.a((EGLContext)localObject2));
        }
        if ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.b()) && (QLog.isColorLevel())) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]2 mSharedDataContextH=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.a());
        }
        f();
      }
      OffScreenInputSurface localOffScreenInputSurface = this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localOffScreenInputSurface == null) {}
      try
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (EGLContext)localObject2);
        bool1 = bool2;
      }
      catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLCreateContextException]exp=", localEGLCreateContextException);
          }
          bjkx.a(1);
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
          bool1 = false;
          continue;
        }
      }
      localObject2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localObject2 != null)
      {
        try
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.c();
          if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.a()) {
            break label299;
          }
          throw new RuntimeException("checkEGL failed");
        }
        catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLMakeCurrentException]exp=", localEGLMakeCurrentException);
          }
          bjkx.a(2);
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.b();
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
        }
        return bool1;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a();
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.h = false;
    this.i = false;
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a(this.jdField_d_of_type_Boolean);
    int j = GLES20.glGetError();
    if (j != 0) {
      bjbu.a("glDrawFrame:glError=" + j);
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bjln != null) {
      this.jdField_a_of_type_Bjln.c();
    }
    this.jdField_a_of_type_Bjln = null;
    a();
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.b();
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public void a()
  {
    b(false);
    biyr.a("destroy OffScreenGLSurface");
  }
  
  public void a(int paramInt1, int paramInt2, bjam parambjam)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = parambjam.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = parambjam.jdField_d_of_type_Int;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_OUTPUT_WIDTH = this.jdField_a_of_type_Int;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_OUTPUT_HEIGHT = this.jdField_b_of_type_Int;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_IMAGE_WIDTH = this.jdField_a_of_type_Int;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_IMAGE_HEIGHT = this.jdField_b_of_type_Int;
    this.jdField_e_of_type_Int = awij.a().b();
    if (this.jdField_e_of_type_Int == 270) {}
    for (this.f = false;; this.f = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "setPreviewSize: backCamera=" + this.f + " mVideoClipDegree=" + this.jdField_e_of_type_Int);
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.f);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Bjln = new bjln();
        this.jdField_a_of_type_Bjln.a(false, false);
        b();
      }
      bjkz.b();
      return;
    }
    this.jdField_a_of_type_Bjln = null;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a()) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c()
  {
    GLES20.glClear(16384);
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      e();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    if (paramMessage.what == -16716524)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "handleMessage SETPREVIEW=" + paramMessage.arg1 + "*" + paramMessage.arg2 + " " + this.h);
      }
      a(paramMessage.arg1, paramMessage.arg2, (bjam)paramMessage.obj);
      this.h = true;
      if (this.i)
      {
        a(a());
        biyr.a("SETPREVIEW OffScreenGLSurface");
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (paramMessage.what != -16716523) {
            break;
          }
          this.i = true;
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT] before " + this.h);
          }
          if (this.h) {
            a(a());
          }
        } while (!QLog.isColorLevel());
        QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT]");
        biyr.a("RANDER_DATA_INIT OffScreenGLSurface");
        return true;
        if (paramMessage.what != -16716522) {
          break;
        }
        d();
        this.jdField_a_of_type_Bjll.a();
        this.jdField_a_of_type_Bjll.a = null;
        this.jdField_a_of_type_Bjlm.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Bjlm.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bjlm.jdField_a_of_type_Int = -1;
        f();
      } while (!QLog.isColorLevel());
      QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_FINISH]");
      return true;
    } while (paramMessage.what != -16716526);
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("CAMERA_OPENGL_RANDER_DATA");; localStringBuilder = null)
    {
      int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (j != 0)
      {
        bjbu.a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + j);
        return true;
      }
      if (this.jdField_a_of_type_Bjln != null) {
        bjkz.a(PtvFilterUtils.a() / 1000L);
      }
      Object localObject;
      if (paramMessage.obj != null) {
        if (paramMessage.arg1 == 0) {
          localObject = (byte[])paramMessage.obj;
        }
      }
      for (;;)
      {
        long l = PtvFilterUtils.a();
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a((byte[])localObject);
        bjkz.d((PtvFilterUtils.a() - l) / 1000L);
        if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle((byte[])localObject);
        }
        if (this.jdField_a_of_type_Bjln != null)
        {
          if (this.jdField_a_of_type_Bjll.a == null)
          {
            bjbu.a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + j);
            return true;
            if (paramMessage.arg1 != 1) {
              break label1133;
            }
            localObject = ((bjkj)paramMessage.obj).jdField_a_of_type_ArrayOfByte;
            continue;
          }
          l = PtvFilterUtils.a();
          bjlt localbjlt = a();
          if (localbjlt != null)
          {
            this.jdField_a_of_type_Bjln.a(localbjlt.jdField_a_of_type_Int);
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append("bind t=").append(localbjlt.jdField_a_of_type_Int).append("|");
              localStringBuilder.append("begin w=").append(this.jdField_a_of_type_Int).append("|");
              localStringBuilder.append("h=").append(this.jdField_b_of_type_Int).append("|");
            }
            c();
            if (!jdField_a_of_type_Boolean) {}
            AVIOStruct localAVIOStruct;
            for (boolean bool1 = true;; bool1 = false)
            {
              PtvFilterUtils.a(bool1);
              if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
                localStringBuilder.append("end draw s=").append(jdField_a_of_type_Boolean).append("|");
              }
              if (paramMessage.arg1 != 1) {
                break label1103;
              }
              localAVIOStruct = ((bjkj)paramMessage.obj).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct;
              if (localAVIOStruct != null) {
                break;
              }
              throw new RuntimeException("OffScreenGLSurface:msg.arg1=" + paramMessage.arg1 + " frame=null");
            }
            localObject = localAVIOStruct;
            if (localAVIOStruct.pFrameIndex == 0)
            {
              this.jdField_a_of_type_Bjlm.jdField_a_of_type_Boolean = true;
              localObject = localAVIOStruct;
            }
            label752:
            ((AVIOStruct)localObject).vFrameTime = SystemClock.elapsedRealtime();
            j = paramMessage.arg1;
            bool1 = bool2;
            if (!this.f) {
              bool1 = true;
            }
            localbjlt.a(j, localObject, bool1);
            localbjlt.d();
            bool1 = this.jdField_a_of_type_Bjll.a.a();
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append("write ns=").append(this.jdField_a_of_type_Bjlm.jdField_a_of_type_Boolean).append("|");
              localStringBuilder.append("fi=").append(((AVIOStruct)localObject).pFrameIndex).append("|");
              localStringBuilder.append("hrf=").append(bool1).append("|");
            }
            if (!bool1)
            {
              if (this.jdField_a_of_type_Bjlm.jdField_a_of_type_Boolean) {
                a((AVIOStruct)localObject);
              }
              localbjlt.a();
            }
            label905:
            bjkz.c((PtvFilterUtils.a() - l) / 1000L);
          }
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (QLog.isColorLevel()))
          {
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append("context=").append(this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext).append("|");
              localStringBuilder.append("notify=").append(this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame).append("|");
            }
            if ((this.g) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
              QLog.d("OffScreenGLSurface", 2, "this log is for qzonetest : the camera create successful!");
            }
            this.g = this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame;
          }
          if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
            this.jdField_a_of_type_AndroidOsHandler.post(new OffScreenGLSurface.1(this));
          }
          if (this.jdField_a_of_type_Bjln != null)
          {
            bjkz.b(PtvFilterUtils.a() / 1000L);
            bjkz.a();
          }
          if ((!QLog.isColorLevel()) || (localStringBuilder == null)) {
            break;
          }
          QLog.d("OffScreenGLSurface", 2, localStringBuilder.toString());
          return true;
          label1103:
          localObject = new AVIOStruct();
          break label752;
          bjbu.a("handleMessage:byteBufferProcessFrame: no texture");
          break label905;
          bjbu.a("handleMessage:byteBufferProcessFrame  framebuffer=null");
        }
        label1133:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjlk
 * JD-Core Version:    0.7.0.1
 */