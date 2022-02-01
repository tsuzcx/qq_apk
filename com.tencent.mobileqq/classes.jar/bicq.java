import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bicq
  implements DialogInterface.OnClickListener
{
  bicq(bicl parambicl, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bhzm.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bicl.b())
    {
      this.jdField_a_of_type_Bicl.a = new bicw(this.jdField_a_of_type_Bicl);
      this.jdField_a_of_type_Bicl.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bicl.a.b = true;
      this.jdField_a_of_type_Bicl.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_Bicl.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bicl.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bicl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bicl.c = true;
      bias.a("201", bias.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new bicv(this.jdField_a_of_type_Bicl, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bicl.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_Bicl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicq
 * JD-Core Version:    0.7.0.1
 */