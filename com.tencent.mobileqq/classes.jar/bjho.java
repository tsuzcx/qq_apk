import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bjho
  implements DialogInterface.OnClickListener
{
  bjho(int paramInt, Activity paramActivity, bjhv parambjhv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bjhk.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bjhk.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bjhk.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bjhv.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bjhk.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bjhk.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bjhk.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bjhk.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bjhk.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bjhk.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjho
 * JD-Core Version:    0.7.0.1
 */