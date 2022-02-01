import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bddl
  implements DialogInterface.OnClickListener
{
  bddl(bddh parambddh, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bddh.a(this.jdField_a_of_type_Bddh, this.jdField_a_of_type_JavaLangString, "clk_unableframe_cancel");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddl
 * JD-Core Version:    0.7.0.1
 */