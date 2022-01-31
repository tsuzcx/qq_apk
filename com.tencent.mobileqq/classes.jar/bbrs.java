import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bbrs
  implements DialogInterface.OnClickListener
{
  bbrs(bbrx parambbrx, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbrx.a(3);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      bbrm.a("0X80094FB");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        bbrm.a("0X80094FA");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    bbrm.a("0X80094FC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbrs
 * JD-Core Version:    0.7.0.1
 */