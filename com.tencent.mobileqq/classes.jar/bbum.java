import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class bbum
  implements Camera.AutoFocusCallback
{
  bbum(bbuk parambbuk, bbup parambbup) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_Bbup.onAutoFocusCallback(paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbum
 * JD-Core Version:    0.7.0.1
 */