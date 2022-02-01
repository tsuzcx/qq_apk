import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bjxi
  implements DialogInterface.OnClickListener
{
  bjxi(bjxd parambjxd, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjtx.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bjxd.b())
    {
      this.jdField_a_of_type_Bjxd.a = new bjxo(this.jdField_a_of_type_Bjxd);
      this.jdField_a_of_type_Bjxd.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bjxd.a.b = true;
      this.jdField_a_of_type_Bjxd.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bjxd.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bjxd.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjxd.c = true;
      bjvg.a("201", bjvg.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bjxn(this.jdField_a_of_type_Bjxd, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bjxd.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxi
 * JD-Core Version:    0.7.0.1
 */