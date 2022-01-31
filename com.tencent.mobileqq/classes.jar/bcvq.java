import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bcvq
  implements DialogInterface.OnClickListener
{
  bcvq(int paramInt, Activity paramActivity, bcvx parambcvx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bcvm.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bcvm.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bcvm.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bcvx.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bcvm.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bcvm.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bcvm.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bcvm.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bcvm.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bcvm.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcvq
 * JD-Core Version:    0.7.0.1
 */