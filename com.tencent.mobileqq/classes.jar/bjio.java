import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bjio
  implements DialogInterface.OnClickListener
{
  bjio(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(null, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_JavaLangString, "Alert_Dialog", "Cancel", this.jdField_a_of_type_Int, this.b, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjio
 * JD-Core Version:    0.7.0.1
 */