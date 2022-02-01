import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class bdbh
  implements Camera.AutoFocusCallback
{
  bdbh(bdbf parambdbf, bdbk parambdbk) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_Bdbk.onAutoFocusCallback(paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbh
 * JD-Core Version:    0.7.0.1
 */