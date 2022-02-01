import android.hardware.Camera.PreviewCallback;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import java.nio.ByteBuffer;

public class bczc
  implements ImageReader.OnImageAvailableListener
{
  public bczc(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        Camera.PreviewCallback localPreviewCallback = Camera2Control.a(this.a);
        if (localPreviewCallback != null)
        {
          ByteBuffer localByteBuffer = paramImageReader.getPlanes()[0].getBuffer();
          byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
          localByteBuffer.get(arrayOfByte);
          localPreviewCallback.onPreviewFrame(arrayOfByte, null);
        }
        paramImageReader.close();
      }
      return;
    }
    catch (Exception paramImageReader)
    {
      bczm.a(1, "[Camera2] onImageAvailable mPreviewReader exception:" + paramImageReader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczc
 * JD-Core Version:    0.7.0.1
 */