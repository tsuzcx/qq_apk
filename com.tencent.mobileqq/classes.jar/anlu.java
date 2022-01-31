import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class anlu
  implements DialogInterface.OnDismissListener
{
  anlu(anlt paramanlt, bhpy parambhpy) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ClearData actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlu
 * JD-Core Version:    0.7.0.1
 */