import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class ayta
  implements Camera.PreviewCallback
{
  ayta(aysx paramaysx) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!aysx.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - aysx.a(this.a) > this.a.c))
      {
        aysx.a(this.a, System.currentTimeMillis());
        aysx.a(this.a, paramArrayOfByte);
      }
    }
    aysx.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayta
 * JD-Core Version:    0.7.0.1
 */