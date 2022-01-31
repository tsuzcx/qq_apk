import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bdlh
  implements DialogInterface.OnClickListener
{
  bdlh(bdlc parambdlc, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdht.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bdlc.b())
    {
      this.jdField_a_of_type_Bdlc.a = new bdln(this.jdField_a_of_type_Bdlc);
      this.jdField_a_of_type_Bdlc.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bdlc.a.b = true;
      this.jdField_a_of_type_Bdlc.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bdlc.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bdlc.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bdlc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdlc.c = true;
      bdjc.a("201", bdjc.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bdlm(this.jdField_a_of_type_Bdlc, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdlc.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bdlc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlh
 * JD-Core Version:    0.7.0.1
 */