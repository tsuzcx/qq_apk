import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class avwy
  implements Camera.PreviewCallback
{
  avwy(avwv paramavwv) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!avwv.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - avwv.a(this.a) > this.a.c))
      {
        avwv.a(this.a, System.currentTimeMillis());
        avwv.a(this.a, paramArrayOfByte);
      }
    }
    avwv.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwy
 * JD-Core Version:    0.7.0.1
 */