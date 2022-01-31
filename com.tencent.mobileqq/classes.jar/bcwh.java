import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bcwh
  implements DialogInterface.OnClickListener
{
  bcwh(bcwm parambcwm, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bcwm.a(3);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      bcwb.a("0X80094FB");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        bcwb.a("0X80094FA");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    bcwb.a("0X80094FC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwh
 * JD-Core Version:    0.7.0.1
 */