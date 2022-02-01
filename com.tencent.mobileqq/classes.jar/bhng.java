import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bhng
  implements DialogInterface.OnClickListener
{
  bhng(bhnm parambhnm, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bhnm.a(2);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      bhnb.a("0X80094F8");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        bhnb.a("0X80094F7");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    bhnb.a("0X80094F9");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhng
 * JD-Core Version:    0.7.0.1
 */