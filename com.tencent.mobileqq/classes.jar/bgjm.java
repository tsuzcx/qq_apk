import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bgjm
  implements DialogInterface.OnClickListener
{
  bgjm(bgjg parambgjg, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bgjg.a(this.jdField_a_of_type_Bgjg, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjm
 * JD-Core Version:    0.7.0.1
 */