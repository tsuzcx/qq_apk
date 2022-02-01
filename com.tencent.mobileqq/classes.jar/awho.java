import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class awho
  implements DialogInterface.OnClickListener
{
  awho(awhm paramawhm, BaseChatPie paramBaseChatPie, short paramShort) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(1);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Awhm.a(this.jdField_a_of_type_Short, true, true);
        bcst.b(awhm.a(this.jdField_a_of_type_Awhm), "dc00898", "", "", "0X8009978", "0X8009978", this.jdField_a_of_type_Awhm.a(this.jdField_a_of_type_Short), this.jdField_a_of_type_Awhm.a(this.jdField_a_of_type_Short), "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awho
 * JD-Core Version:    0.7.0.1
 */