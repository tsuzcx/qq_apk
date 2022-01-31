import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bezs
  implements DialogInterface.OnClickListener
{
  bezs(bezx parambezx, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bezx.a(3);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      bezm.a("0X80094FB");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        bezm.a("0X80094FA");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    bezm.a("0X80094FC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezs
 * JD-Core Version:    0.7.0.1
 */