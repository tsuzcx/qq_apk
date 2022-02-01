import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aqys
  implements DialogInterface.OnClickListener
{
  aqys(aqyo paramaqyo, Runnable paramRunnable, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_JavaLangRunnable.run();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = "0X800AE6B";
      localObject = this.jdField_a_of_type_JavaLangString;
      if (!this.b) {
        break label99;
      }
      str = "size";
      label41:
      aqyo.a(paramDialogInterface, (String)localObject, str);
      localObject = blyl.a();
      if (!this.jdField_a_of_type_Boolean) {
        break label105;
      }
      paramDialogInterface = "2";
      label63:
      if (!this.jdField_a_of_type_Boolean) {
        break label111;
      }
    }
    label99:
    label105:
    label111:
    for (String str = "2";; str = "1")
    {
      ((blyl)localObject).a("Later", "4", "platform898", paramDialogInterface, str, 102, 1, System.currentTimeMillis());
      return;
      paramDialogInterface = "0X800AE65";
      break;
      str = "full";
      break label41;
      paramDialogInterface = "3";
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqys
 * JD-Core Version:    0.7.0.1
 */