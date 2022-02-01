import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bigp
  implements DialogInterface.OnClickListener
{
  bigp(int paramInt, Activity paramActivity, bigw parambigw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bigl.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bigl.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bigl.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bigw.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bigl.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bigl.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bigl.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bigl.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bigl.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bigl.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigp
 * JD-Core Version:    0.7.0.1
 */