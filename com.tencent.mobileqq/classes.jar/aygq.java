import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class aygq
  implements Camera.PreviewCallback
{
  aygq(aygn paramaygn) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!aygn.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - aygn.a(this.a) > this.a.c))
      {
        aygn.a(this.a, System.currentTimeMillis());
        aygn.a(this.a, paramArrayOfByte);
      }
    }
    aygn.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygq
 * JD-Core Version:    0.7.0.1
 */