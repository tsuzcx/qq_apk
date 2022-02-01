import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

final class auzo
  implements DialogInterface.OnClickListener
{
  auzo(int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 1)
    {
      ((auyv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(156)).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
      paramDialogInterface.dismiss();
      if (this.jdField_b_of_type_Int == 1)
      {
        paramDialogInterface = "clk_openframe_open";
        if (this.jdField_a_of_type_Int != 1) {
          break label88;
        }
        auzn.a(bool1, paramDialogInterface, this.jdField_a_of_type_JavaLangString);
      }
    }
    label88:
    while (paramInt != 0) {
      for (;;)
      {
        return;
        paramDialogInterface = "clk_joinbar_open";
        continue;
        bool1 = false;
      }
    }
    paramDialogInterface.dismiss();
    if (this.jdField_b_of_type_Int == 1)
    {
      paramDialogInterface = "clk_openframe_cancel";
      if (this.jdField_a_of_type_Int != 1) {
        break label141;
      }
    }
    label141:
    for (bool1 = bool2;; bool1 = false)
    {
      auzn.a(bool1, paramDialogInterface, this.jdField_a_of_type_JavaLangString);
      return;
      paramDialogInterface = "clk_joinbar_cancel";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzo
 * JD-Core Version:    0.7.0.1
 */