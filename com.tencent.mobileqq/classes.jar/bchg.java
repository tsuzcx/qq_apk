import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bchg
  implements DialogInterface.OnClickListener
{
  bchg(bchb parambchb, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcds.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bchb.b())
    {
      this.jdField_a_of_type_Bchb.a = new bchm(this.jdField_a_of_type_Bchb);
      this.jdField_a_of_type_Bchb.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bchb.a.b = true;
      this.jdField_a_of_type_Bchb.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bchb.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bchb.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bchb.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bchb.c = true;
      bcfb.a("201", bcfb.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bchl(this.jdField_a_of_type_Bchb, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bchb.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bchb.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchg
 * JD-Core Version:    0.7.0.1
 */