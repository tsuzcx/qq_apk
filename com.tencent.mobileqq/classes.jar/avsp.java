import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class avsp
  implements Camera.PreviewCallback
{
  avsp(avsm paramavsm) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!avsm.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - avsm.a(this.a) > this.a.c))
      {
        avsm.a(this.a, System.currentTimeMillis());
        avsm.a(this.a, paramArrayOfByte);
      }
    }
    avsm.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avsp
 * JD-Core Version:    0.7.0.1
 */