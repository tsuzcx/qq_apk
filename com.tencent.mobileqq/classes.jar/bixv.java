import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bixv
  implements DialogInterface.OnClickListener
{
  bixv(int paramInt, Activity paramActivity, biyc parambiyc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bixr.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bixr.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bixr.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Biyc.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bixr.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bixr.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bixr.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bixr.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bixr.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bixr.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixv
 * JD-Core Version:    0.7.0.1
 */