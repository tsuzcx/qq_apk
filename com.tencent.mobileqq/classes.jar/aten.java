import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class aten
  implements Camera.PreviewCallback
{
  aten(atek paramatek) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!atek.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - atek.a(this.a) > this.a.c))
      {
        atek.a(this.a, System.currentTimeMillis());
        atek.a(this.a, paramArrayOfByte);
      }
    }
    atek.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aten
 * JD-Core Version:    0.7.0.1
 */