import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer;
import java.nio.ByteBuffer;

public class bczb
  implements ImageReader.OnImageAvailableListener
{
  public bczb(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      bczm.a(1, "[Camera2]Image Capture cost:" + (float)(System.currentTimeMillis() - Camera2Control.a(this.a)) / 1000.0F);
      bczl.a(2, Camera2Control.a(this.a).a * Camera2Control.a(this.a).b, System.currentTimeMillis() - Camera2Control.a(this.a));
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        ByteBuffer localByteBuffer = paramImageReader.getPlanes()[0].getBuffer();
        byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
        localByteBuffer.get(arrayOfByte);
        if ((Camera2Control.a(this.a) != null) && (Camera2Control.a(this.a) != null))
        {
          Camera2Control.a(this.a).a = Camera2Control.a(this.a).a;
          Camera2Control.a(this.a).post(new Camera2Control.ImageSaveServer(arrayOfByte, Camera2Control.a(this.a)));
        }
        paramImageReader.close();
      }
      return;
    }
    catch (Exception paramImageReader)
    {
      bczm.a(1, "[Camera2] onImageAvailable mImageReader exception:" + paramImageReader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczb
 * JD-Core Version:    0.7.0.1
 */