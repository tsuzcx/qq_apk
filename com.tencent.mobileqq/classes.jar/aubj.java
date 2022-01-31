import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class aubj
  implements Camera.PreviewCallback
{
  aubj(aubg paramaubg) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!aubg.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - aubg.a(this.a) > this.a.c))
      {
        aubg.a(this.a, System.currentTimeMillis());
        aubg.a(this.a, paramArrayOfByte);
      }
    }
    aubg.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubj
 * JD-Core Version:    0.7.0.1
 */