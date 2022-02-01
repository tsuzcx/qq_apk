import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bjns
  implements DialogInterface.OnClickListener
{
  bjns(bjnn parambjnn, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjko.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bjnn.b())
    {
      this.jdField_a_of_type_Bjnn.a = new bjny(this.jdField_a_of_type_Bjnn);
      this.jdField_a_of_type_Bjnn.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bjnn.a.b = true;
      this.jdField_a_of_type_Bjnn.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bjnn.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bjnn.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bjnn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnn.c = true;
      bjlu.a("201", bjlu.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bjnx(this.jdField_a_of_type_Bjnn, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bjnn.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bjnn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjns
 * JD-Core Version:    0.7.0.1
 */