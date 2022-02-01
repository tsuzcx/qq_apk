import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bekm
  implements DialogInterface.OnClickListener
{
  bekm(bekj parambekj, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bekj localbekj = this.jdField_a_of_type_Bekj;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 8) {}
    for (String str1 = "clk_openframe_cancel";; str1 = "clk_joinbar_cancel")
    {
      bekj.a(localbekj, str2, str1);
      paramDialogInterface.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekm
 * JD-Core Version:    0.7.0.1
 */