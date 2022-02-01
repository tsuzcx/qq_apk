import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

final class awfs
  implements DialogInterface.OnClickListener
{
  awfs(BaseChatPie paramBaseChatPie, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (paramInt == 1)
    {
      if (awfq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString)) {
        awfq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 3, false, null);
      }
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
      awfq.a(bool1, "clk_joinframe_join", this.jdField_a_of_type_JavaLangString);
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      awfq.a(bool1, "clk_joinframe_cancel", this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfs
 * JD-Core Version:    0.7.0.1
 */