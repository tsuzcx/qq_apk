import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bbrq
  implements DialogInterface.OnClickListener
{
  bbrq(int paramInt, Activity paramActivity, bbrx parambbrx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      bbrm.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      bbrm.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_Bbrx.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        bbrm.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        bbrm.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          bbrm.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbrq
 * JD-Core Version:    0.7.0.1
 */