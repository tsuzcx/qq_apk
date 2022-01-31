import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bfkt
  implements DialogInterface.OnClickListener
{
  bfkt(bfko parambfko, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bfhg.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bfko.b())
    {
      this.jdField_a_of_type_Bfko.a = new bfkz(this.jdField_a_of_type_Bfko);
      this.jdField_a_of_type_Bfko.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bfko.a.b = true;
      this.jdField_a_of_type_Bfko.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bfko.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bfko.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bfko.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfko.c = true;
      bfip.a("201", bfip.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bfky(this.jdField_a_of_type_Bfko, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bfko.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bfko.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkt
 * JD-Core Version:    0.7.0.1
 */