import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bfpc
  implements DialogInterface.OnClickListener
{
  bfpc(bfox parambfox, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bflp.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bfox.b())
    {
      this.jdField_a_of_type_Bfox.a = new bfpi(this.jdField_a_of_type_Bfox);
      this.jdField_a_of_type_Bfox.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bfox.a.b = true;
      this.jdField_a_of_type_Bfox.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bfox.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bfox.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bfox.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfox.c = true;
      bfmy.a("201", bfmy.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bfph(this.jdField_a_of_type_Bfox, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bfox.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bfox.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpc
 * JD-Core Version:    0.7.0.1
 */