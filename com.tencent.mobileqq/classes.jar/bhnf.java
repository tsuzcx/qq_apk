import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bhnf
  implements DialogInterface.OnClickListener
{
  bhnf(int paramInt, Activity paramActivity, bhnm parambhnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bhnb.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bhnb.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bhnb.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bhnm.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bhnb.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bhnb.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bhnb.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bhnb.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bhnb.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bhnb.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnf
 * JD-Core Version:    0.7.0.1
 */