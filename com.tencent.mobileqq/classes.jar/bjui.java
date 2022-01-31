import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bjui
  implements DialogInterface.OnClickListener
{
  bjui(bjuc parambjuc, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bjuc.a(this.jdField_a_of_type_Bjuc, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjui
 * JD-Core Version:    0.7.0.1
 */