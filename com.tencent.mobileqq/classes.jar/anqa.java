import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class anqa
  implements DialogInterface.OnDismissListener
{
  anqa(anpz paramanpz, bhuf parambhuf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bhuf.dismiss();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ClearApp actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqa
 * JD-Core Version:    0.7.0.1
 */