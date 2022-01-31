import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class aubl
  implements Camera.PreviewCallback
{
  aubl(aubi paramaubi) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!aubi.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - aubi.a(this.a) > this.a.c))
      {
        aubi.a(this.a, System.currentTimeMillis());
        aubi.a(this.a, paramArrayOfByte);
      }
    }
    aubi.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubl
 * JD-Core Version:    0.7.0.1
 */