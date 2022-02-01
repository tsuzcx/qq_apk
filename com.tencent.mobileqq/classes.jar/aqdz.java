import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class aqdz
  implements DialogInterface.OnDismissListener
{
  aqdz(aqdy paramaqdy, blir paramblir) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Blir.dismiss();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ClearData actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdz
 * JD-Core Version:    0.7.0.1
 */