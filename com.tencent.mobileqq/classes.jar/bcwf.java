import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bcwf
  implements DialogInterface.OnClickListener
{
  bcwf(int paramInt, Activity paramActivity, bcwm parambcwm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bcwb.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bcwb.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bcwb.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bcwm.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bcwb.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bcwb.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bcwb.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bcwb.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bcwb.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bcwb.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwf
 * JD-Core Version:    0.7.0.1
 */