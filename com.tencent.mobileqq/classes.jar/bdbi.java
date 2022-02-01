import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class bdbi
  implements Camera.AutoFocusCallback
{
  bdbi(bdbg parambdbg, bdbl parambdbl) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_Bdbl.a(paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbi
 * JD-Core Version:    0.7.0.1
 */