import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class bciq
  implements Camera.AutoFocusCallback
{
  bciq(bcio parambcio, bcit parambcit) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_Bcit.a(paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciq
 * JD-Core Version:    0.7.0.1
 */