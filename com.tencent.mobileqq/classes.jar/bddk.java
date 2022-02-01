import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bddk
  implements DialogInterface.OnClickListener
{
  bddk(bddh parambddh, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bddh localbddh = this.jdField_a_of_type_Bddh;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 8) {}
    for (String str1 = "clk_openframe_cancel";; str1 = "clk_joinbar_cancel")
    {
      bddh.a(localbddh, str2, str1);
      paramDialogInterface.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddk
 * JD-Core Version:    0.7.0.1
 */