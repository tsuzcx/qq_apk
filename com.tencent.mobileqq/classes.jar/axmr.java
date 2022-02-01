import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class axmr
  implements Camera.PreviewCallback
{
  axmr(axmo paramaxmo) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!axmo.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - axmo.a(this.a) > this.a.c))
      {
        axmo.a(this.a, System.currentTimeMillis());
        axmo.a(this.a, paramArrayOfByte);
      }
    }
    axmo.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmr
 * JD-Core Version:    0.7.0.1
 */