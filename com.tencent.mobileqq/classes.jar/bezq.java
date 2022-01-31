import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bezq
  implements DialogInterface.OnClickListener
{
  bezq(int paramInt, Activity paramActivity, bezx parambezx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bezm.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bezm.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bezm.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bezx.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bezm.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bezm.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bezm.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bezm.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bezm.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bezm.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezq
 * JD-Core Version:    0.7.0.1
 */