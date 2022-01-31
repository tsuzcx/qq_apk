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

public class azka
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public azkc a;
  private SVOpenglFlipFilter jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public azka()
  {
    this.jdField_a_of_type_Azkc = new azkc();
  }
  
  @TargetApi(17)
  private azky a(azkb paramazkb, int paramInt)
  {
    azky localazky = paramazkb.jdField_a_of_type_Azkx.a();
    if (localazky == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localazky.a(paramazkb.jdField_a_of_type_Int, paramazkb.jdField_b_of_type_Int, paramazkb.e))
    {
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (PtvFilterUtils.a(paramInt, paramazkb.jdField_a_of_type_Int, paramazkb.jdField_b_of_type_Int, paramazkb.e, localazky.jdField_a_of_type_JavaNioByteBuffer, paramazkb.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct) != 0)
      {
        localazky.a();
        return null;
      }
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory= old time " + paramazkb.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime + ", new time = " + l2 + ", diff=" + (l2 - paramazkb.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime));
      }
      paramazkb.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime = l2;
      l1 = (SystemClock.elapsedRealtimeNanos() - l1) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory=" + l1 + "us]");
      }
      return localazky;
    }
    localazky.a();
    return null;
  }
  
  public static CameraFilterGLView.SharedMemWriteFile a(azky paramazky)
  {
    if (paramazky.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile == null) {
      paramazky.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile = new CameraFilterGLView.SharedMemWriteFile();
    }
    return paramazky.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile;
  }
  
  private void a(azkb paramazkb, azky paramazky, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, azic paramazic)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = a(paramazky);
    localSharedMemWriteFile.jdField_a_of_type_Int = paramazkb.jdField_a_of_type_Int;
    localSharedMemWriteFile.jdField_b_of_type_Int = paramazkb.jdField_b_of_type_Int;
    localSharedMemWriteFile.c = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_Azky = paramazky;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = paramazkb.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_Azkx = paramazkb.jdField_a_of_type_Azkx;
    localSharedMemWriteFile.jdField_a_of_type_Ajwj = null;
    localSharedMemWriteFile.d = paramInt2;
    localSharedMemWriteFile.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = paramazkb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
    localSharedMemWriteFile.jdField_a_of_type_Azic = paramazic;
    paramazkb.jdField_a_of_type_Azkx.a(localSharedMemWriteFile);
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
      azky localazky;
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
                synchronized (this.jdField_a_of_type_Azkc.jdField_a_of_type_JavaLangObject)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(this.jdField_a_of_type_Azkc.jdField_a_of_type_Int, this.jdField_a_of_type_Azkc.jdField_b_of_type_Int, this.jdField_a_of_type_Azkc.jdField_a_of_type_AndroidOpenglEGLContext)))
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
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = new SVOpenglFlipFilter(this.jdField_a_of_type_Azkc.jdField_a_of_type_Int, this.jdField_a_of_type_Azkc.jdField_b_of_type_Int, this.jdField_a_of_type_Azkc.jdField_a_of_type_AndroidOpenglEGLContext);
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
                ??? = (azkb)???.obj;
                if (azie.jdField_a_of_type_Boolean) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[FILTER_FLIP_GL_DRAW] ignore because stop capture, frame index = " + ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
            if (???.d != 180) {
              break;
            }
            localazky = a(???, ???.c);
          } while (localazky == null);
          a(???, localazky, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, 0, ???.jdField_a_of_type_Azic);
          return true;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!azkr.jdField_a_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(???.c, ???.jdField_a_of_type_Int, ???.jdField_b_of_type_Int);
          localazky = a(???, 0);
        } while (localazky == null);
        a(???, localazky, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_Azic);
        return true;
        localazky = a(???, ???.c);
      } while (localazky == null);
      a(???, localazky, 180, true, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_Azic);
      return true;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azka
 * JD-Core Version:    0.7.0.1
 */