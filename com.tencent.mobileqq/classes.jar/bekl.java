import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bekl
  implements DialogInterface.OnClickListener
{
  bekl(bekj parambekj, String paramString, int paramInt1, Bundle paramBundle, int paramInt2, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bekj localbekj = this.jdField_a_of_type_Bekj;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 8) {}
    for (String str1 = "clk_openframe_open";; str1 = "clk_joinbar_open")
    {
      bekj.a(localbekj, str2, str1);
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_Int != 8) {
        break;
      }
      bekj.a(this.jdField_a_of_type_Bekj, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      return;
    }
    bekj.a(this.jdField_a_of_type_Bekj, this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekl
 * JD-Core Version:    0.7.0.1
 */