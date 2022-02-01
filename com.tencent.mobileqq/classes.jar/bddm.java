import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bddm
  implements DialogInterface.OnClickListener
{
  bddm(bddh parambddh, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bddh.a(this.jdField_a_of_type_Bddh, this.jdField_a_of_type_JavaLangString, "clk_unableframe_open");
    paramDialogInterface.dismiss();
    bddh.a(this.jdField_a_of_type_Bddh, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddm
 * JD-Core Version:    0.7.0.1
 */