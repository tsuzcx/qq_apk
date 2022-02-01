import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bhnh
  implements DialogInterface.OnClickListener
{
  bhnh(bhnm parambhnm, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bhnm.a(3);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      bhnb.a("0X80094FB");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        bhnb.a("0X80094FA");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    bhnb.a("0X80094FC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnh
 * JD-Core Version:    0.7.0.1
 */