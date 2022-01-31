import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bhsx
  implements DialogInterface.OnClickListener
{
  bhsx(bhsr parambhsr, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bhsr.a(this.jdField_a_of_type_Bhsr, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhsx
 * JD-Core Version:    0.7.0.1
 */