import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aqyr
  implements DialogInterface.OnClickListener
{
  aqyr(aqyo paramaqyo, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (this.jdField_a_of_type_Boolean)
    {
      str = this.jdField_a_of_type_Aqyo.h.a(this.jdField_a_of_type_JavaLangString);
      bgzo.a((Context)localObject, str);
      paramDialogInterface.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label136;
      }
      paramDialogInterface = "0X800AE6A";
      label50:
      localObject = this.jdField_a_of_type_JavaLangString;
      if (!this.b) {
        break label142;
      }
      str = "size";
      label66:
      aqyo.a(paramDialogInterface, (String)localObject, str);
      localObject = blyl.a();
      if (!this.jdField_a_of_type_Boolean) {
        break label148;
      }
      paramDialogInterface = "2";
      label88:
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
    }
    label136:
    label142:
    label148:
    label154:
    for (String str = "2";; str = "1")
    {
      ((blyl)localObject).a("Open", "4", "platform898", paramDialogInterface, str, 102, 1, System.currentTimeMillis());
      return;
      str = this.jdField_a_of_type_Aqyo.i.a(this.jdField_a_of_type_JavaLangString);
      break;
      paramDialogInterface = "0X800AE64";
      break label50;
      str = "full";
      break label66;
      paramDialogInterface = "3";
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyr
 * JD-Core Version:    0.7.0.1
 */