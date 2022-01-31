import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;

class ateo
  implements Camera.PictureCallback
{
  ateo(atek paramatek) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.a(paramArrayOfByte, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ateo
 * JD-Core Version:    0.7.0.1
 */