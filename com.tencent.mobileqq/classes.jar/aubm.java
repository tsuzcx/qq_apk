import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;

class aubm
  implements Camera.PictureCallback
{
  aubm(aubi paramaubi) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.a(paramArrayOfByte, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubm
 * JD-Core Version:    0.7.0.1
 */