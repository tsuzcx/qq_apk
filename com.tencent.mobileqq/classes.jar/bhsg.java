import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bhsg
  implements DialogInterface.OnClickListener
{
  bhsg(bhsa parambhsa, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bhsa.a(this.jdField_a_of_type_Bhsa, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhsg
 * JD-Core Version:    0.7.0.1
 */