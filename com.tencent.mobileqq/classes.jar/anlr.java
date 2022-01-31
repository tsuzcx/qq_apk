import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class anlr
  implements DialogInterface.OnDismissListener
{
  anlr(anlq paramanlq, bhpy parambhpy) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ClearApp actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlr
 * JD-Core Version:    0.7.0.1
 */