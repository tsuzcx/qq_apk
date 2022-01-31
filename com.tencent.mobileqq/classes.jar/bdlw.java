import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bdlw
  implements DialogInterface.OnClickListener
{
  bdlw(bdlr parambdlr, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdii.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bdlr.b())
    {
      this.jdField_a_of_type_Bdlr.a = new bdmc(this.jdField_a_of_type_Bdlr);
      this.jdField_a_of_type_Bdlr.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bdlr.a.b = true;
      this.jdField_a_of_type_Bdlr.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bdlr.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bdlr.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bdlr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdlr.c = true;
      bdjr.a("201", bdjr.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bdmb(this.jdField_a_of_type_Bdlr, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdlr.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bdlr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlw
 * JD-Core Version:    0.7.0.1
 */