import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bixw
  implements DialogInterface.OnClickListener
{
  bixw(biyc parambiyc, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Biyc.a(2);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      bixr.a("0X80094F8");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        bixr.a("0X80094F7");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    bixr.a("0X80094F9");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixw
 * JD-Core Version:    0.7.0.1
 */