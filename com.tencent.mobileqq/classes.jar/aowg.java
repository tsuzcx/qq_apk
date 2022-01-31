import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleSurfaceStickerTracker;

public class aowg
  implements ImageReader.OnImageAvailableListener
{
  public aowg(SimpleSurfaceStickerTracker paramSimpleSurfaceStickerTracker) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleSurfaceStickerTracker", 2, "onImageAvailable , thread id=" + Thread.currentThread().getId());
    }
    if (SimpleSurfaceStickerTracker.a(this.a) >= SimpleSurfaceStickerTracker.b(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleSurfaceStickerTracker", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + SimpleSurfaceStickerTracker.a(this.a) + " , mLastDecodeTimestamp " + SimpleSurfaceStickerTracker.b(this.a));
      }
      try
      {
        synchronized (SimpleSurfaceStickerTracker.b(this.a))
        {
          SimpleSurfaceStickerTracker.b(this.a).wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    synchronized (SimpleSurfaceStickerTracker.a(this.a))
    {
      if (SimpleSurfaceStickerTracker.b(this.a))
      {
        SimpleSurfaceStickerTracker.a(this.a, true);
        SimpleSurfaceStickerTracker.a(this.a).notifyAll();
        QLog.w("SimpleSurfaceStickerTracker", 2, "onFrameAvailable error= ; isStoped=" + SimpleSurfaceStickerTracker.b(this.a));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SimpleSurfaceStickerTracker", 2, "onFrameAvailable start");
      }
      if (SimpleSurfaceStickerTracker.a(this.a)) {
        new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
      SimpleSurfaceStickerTracker.a(this.a, SimpleSurfaceStickerTracker.b(this.a));
    }
    try
    {
      paramImageReader = paramImageReader.acquireNextImage();
      SimpleSurfaceStickerTracker.a(this.a, paramImageReader);
      paramImageReader.close();
      SimpleSurfaceStickerTracker.a(this.a, true);
      SimpleSurfaceStickerTracker.a(this.a).notifyAll();
      return;
    }
    catch (Exception paramImageReader)
    {
      paramImageReader.printStackTrace();
      SimpleSurfaceStickerTracker.a(this.a, true);
      SimpleSurfaceStickerTracker.a(this.a).notifyAll();
      QLog.w("SimpleSurfaceStickerTracker", 2, "onFrameAvailable error= ; isStoped=" + SimpleSurfaceStickerTracker.b(this.a));
    }
    paramImageReader = finally;
    throw paramImageReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowg
 * JD-Core Version:    0.7.0.1
 */