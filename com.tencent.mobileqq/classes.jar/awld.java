import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreateContextException;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreatePbufferSurfaceException;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLMakeCurrentException;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVOpenglFlipFilter;
import com.tencent.mobileqq.shortvideo.util.SVOpenglFlipFilter.EGLCreateProgramException;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class awld
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public awlf a;
  private SVOpenglFlipFilter jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public awld()
  {
    this.jdField_a_of_type_Awlf = new awlf();
  }
  
  @TargetApi(17)
  private awmb a(awle paramawle, int paramInt)
  {
    awmb localawmb = paramawle.jdField_a_of_type_Awma.a();
    if (localawmb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localawmb.a(paramawle.jdField_a_of_type_Int, paramawle.jdField_b_of_type_Int, paramawle.e))
    {
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (PtvFilterUtils.a(paramInt, paramawle.jdField_a_of_type_Int, paramawle.jdField_b_of_type_Int, paramawle.e, localawmb.jdField_a_of_type_JavaNioByteBuffer, paramawle.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct) != 0)
      {
        localawmb.a();
        return null;
      }
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory= old time " + paramawle.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime + ", new time = " + l2 + ", diff=" + (l2 - paramawle.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime));
      }
      paramawle.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime = l2;
      l1 = (SystemClock.elapsedRealtimeNanos() - l1) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory=" + l1 + "us]");
      }
      return localawmb;
    }
    localawmb.a();
    return null;
  }
  
  public static CameraFilterGLView.SharedMemWriteFile a(awmb paramawmb)
  {
    if (paramawmb.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile == null) {
      paramawmb.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile = new CameraFilterGLView.SharedMemWriteFile();
    }
    return paramawmb.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile;
  }
  
  private void a(awle paramawle, awmb paramawmb, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, awjf paramawjf)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = a(paramawmb);
    localSharedMemWriteFile.jdField_a_of_type_Int = paramawle.jdField_a_of_type_Int;
    localSharedMemWriteFile.jdField_b_of_type_Int = paramawle.jdField_b_of_type_Int;
    localSharedMemWriteFile.c = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_Awmb = paramawmb;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = paramawle.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_Awma = paramawle.jdField_a_of_type_Awma;
    localSharedMemWriteFile.jdField_a_of_type_Ahnu = null;
    localSharedMemWriteFile.d = paramInt2;
    localSharedMemWriteFile.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = paramawle.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
    localSharedMemWriteFile.jdField_a_of_type_Awjf = paramawjf;
    paramawle.jdField_a_of_type_Awma.a(localSharedMemWriteFile);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("glAsyncPostThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    }
  }
  
  public void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    }
    do
    {
      awmb localawmb;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                synchronized (this.jdField_a_of_type_Awlf.jdField_a_of_type_JavaLangObject)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(this.jdField_a_of_type_Awlf.jdField_a_of_type_Int, this.jdField_a_of_type_Awlf.jdField_b_of_type_Int, this.jdField_a_of_type_Awlf.jdField_a_of_type_AndroidOpenglEGLContext)))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("face", 2, "checkIsCanReusedPbuffer = false [release]");
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null)
                  {
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = new SVOpenglFlipFilter(this.jdField_a_of_type_Awlf.jdField_a_of_type_Int, this.jdField_a_of_type_Awlf.jdField_b_of_type_Int, this.jdField_a_of_type_Awlf.jdField_a_of_type_AndroidOpenglEGLContext);
                  }
                }
                try
                {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a();
                  this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                  return true;
                  localObject = finally;
                  throw localObject;
                }
                catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLMakeCurrentException);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                  }
                }
                catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLCreateContextException);
                    }
                  }
                }
                catch (OffScreenInputSurface.EGLCreatePbufferSurfaceException localEGLCreatePbufferSurfaceException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLCreatePbufferSurfaceException);
                    }
                  }
                }
                catch (SVOpenglFlipFilter.EGLCreateProgramException localEGLCreateProgramException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[EGLCreateProgramException]" + localEGLCreateProgramException);
                    }
                  }
                }
                ??? = (awle)???.obj;
                if (awjh.jdField_a_of_type_Boolean) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[FILTER_FLIP_GL_DRAW] ignore because stop capture, frame index = " + ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
            if (???.d != 180) {
              break;
            }
            localawmb = a(???, ???.c);
          } while (localawmb == null);
          a(???, localawmb, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, 0, ???.jdField_a_of_type_Awjf);
          return true;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!awlu.jdField_a_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(???.c, ???.jdField_a_of_type_Int, ???.jdField_b_of_type_Int);
          localawmb = a(???, 0);
        } while (localawmb == null);
        a(???, localawmb, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_Awjf);
        return true;
        localawmb = a(???, ???.c);
      } while (localawmb == null);
      a(???, localawmb, 180, true, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_Awjf);
      return true;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awld
 * JD-Core Version:    0.7.0.1
 */