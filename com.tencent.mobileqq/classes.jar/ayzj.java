import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class ayzj
  implements Camera.PreviewCallback
{
  ayzj(ayzg paramayzg) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!ayzg.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - ayzg.a(this.a) > this.a.c))
      {
        ayzg.a(this.a, System.currentTimeMillis());
        ayzg.a(this.a, paramArrayOfByte);
      }
    }
    ayzg.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzj
 * JD-Core Version:    0.7.0.1
 */