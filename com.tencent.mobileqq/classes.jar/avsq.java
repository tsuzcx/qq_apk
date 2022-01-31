import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;

class avsq
  implements Camera.PictureCallback
{
  avsq(avsm paramavsm) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.a(paramArrayOfByte, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avsq
 * JD-Core Version:    0.7.0.1
 */