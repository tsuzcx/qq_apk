import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;

class avdb
  implements DialogInterface.OnClickListener
{
  avdb(avcy paramavcy, String paramString, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new avdd(avcy.a(this.jdField_a_of_type_Avcy).jdField_a_of_type_AndroidContentContext, avcy.a(this.jdField_a_of_type_Avcy).a()).a(this.jdField_a_of_type_JavaLangString).a(avcy.a(this.jdField_a_of_type_Avcy).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo).a(avcy.a(this.jdField_a_of_type_Avcy)).a();
    if (this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.isFriendBanned())
    {
      axqy.b(avcy.a(this.jdField_a_of_type_Avcy).a(), "dc00898", "", "", "0X800A4BE", "0X800A4BE", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(avcy.a(this.jdField_a_of_type_Avcy).a(), "dc00898", "", "", "0X800A4BC", "0X800A4BC", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdb
 * JD-Core Version:    0.7.0.1
 */