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

public class azfr
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public azft a;
  private SVOpenglFlipFilter jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public azfr()
  {
    this.jdField_a_of_type_Azft = new azft();
  }
  
  @TargetApi(17)
  private azgp a(azfs paramazfs, int paramInt)
  {
    azgp localazgp = paramazfs.jdField_a_of_type_Azgo.a();
    if (localazgp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localazgp.a(paramazfs.jdField_a_of_type_Int, paramazfs.jdField_b_of_type_Int, paramazfs.e))
    {
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (PtvFilterUtils.a(paramInt, paramazfs.jdField_a_of_type_Int, paramazfs.jdField_b_of_type_Int, paramazfs.e, localazgp.jdField_a_of_type_JavaNioByteBuffer, paramazfs.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct) != 0)
      {
        localazgp.a();
        return null;
      }
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory= old time " + paramazfs.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime + ", new time = " + l2 + ", diff=" + (l2 - paramazfs.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime));
      }
      paramazfs.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime = l2;
      l1 = (SystemClock.elapsedRealtimeNanos() - l1) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory=" + l1 + "us]");
      }
      return localazgp;
    }
    localazgp.a();
    return null;
  }
  
  public static CameraFilterGLView.SharedMemWriteFile a(azgp paramazgp)
  {
    if (paramazgp.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile == null) {
      paramazgp.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile = new CameraFilterGLView.SharedMemWriteFile();
    }
    return paramazgp.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile;
  }
  
  private void a(azfs paramazfs, azgp paramazgp, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, azdt paramazdt)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = a(paramazgp);
    localSharedMemWriteFile.jdField_a_of_type_Int = paramazfs.jdField_a_of_type_Int;
    localSharedMemWriteFile.jdField_b_of_type_Int = paramazfs.jdField_b_of_type_Int;
    localSharedMemWriteFile.c = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_Azgp = paramazgp;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = paramazfs.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_Azgo = paramazfs.jdField_a_of_type_Azgo;
    localSharedMemWriteFile.jdField_a_of_type_Ajru = null;
    localSharedMemWriteFile.d = paramInt2;
    localSharedMemWriteFile.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = paramazfs.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
    localSharedMemWriteFile.jdField_a_of_type_Azdt = paramazdt;
    paramazfs.jdField_a_of_type_Azgo.a(localSharedMemWriteFile);
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
      azgp localazgp;
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
                synchronized (this.jdField_a_of_type_Azft.jdField_a_of_type_JavaLangObject)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(this.jdField_a_of_type_Azft.jdField_a_of_type_Int, this.jdField_a_of_type_Azft.jdField_b_of_type_Int, this.jdField_a_of_type_Azft.jdField_a_of_type_AndroidOpenglEGLContext)))
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
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = new SVOpenglFlipFilter(this.jdField_a_of_type_Azft.jdField_a_of_type_Int, this.jdField_a_of_type_Azft.jdField_b_of_type_Int, this.jdField_a_of_type_Azft.jdField_a_of_type_AndroidOpenglEGLContext);
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
                ??? = (azfs)???.obj;
                if (azdv.jdField_a_of_type_Boolean) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[FILTER_FLIP_GL_DRAW] ignore because stop capture, frame index = " + ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
            if (???.d != 180) {
              break;
            }
            localazgp = a(???, ???.c);
          } while (localazgp == null);
          a(???, localazgp, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, 0, ???.jdField_a_of_type_Azdt);
          return true;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!azgi.jdField_a_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(???.c, ???.jdField_a_of_type_Int, ???.jdField_b_of_type_Int);
          localazgp = a(???, 0);
        } while (localazgp == null);
        a(???, localazgp, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_Azdt);
        return true;
        localazgp = a(???, ???.c);
      } while (localazgp == null);
      a(???, localazgp, 180, true, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_Azdt);
      return true;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfr
 * JD-Core Version:    0.7.0.1
 */