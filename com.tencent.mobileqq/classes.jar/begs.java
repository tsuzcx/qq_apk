import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class begs
  implements bliz
{
  begs(begp parambegp, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, int paramInt2, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", this.jdField_a_of_type_Int, 0, "", "", "", "");
      begp.a("2", "1");
      continue;
      ahtp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaLangString);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", this.jdField_a_of_type_Int, 0, "", "", "", "");
      continue;
      if (this.b == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.jdField_a_of_type_JavaLangString)), this.jdField_a_of_type_AndroidContentContext.getString(2131693466));
        paramView.putExtra("big_brother_source_key", begp.a(this.jdField_a_of_type_Begp));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92D", "0X800A92D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", begp.a(this.jdField_a_of_type_Begp));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", this.jdField_a_of_type_Int, 0, "", "", "", "");
        begp.a("1", "2");
        continue;
        begp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", this.jdField_a_of_type_Int, 0, "", "", "", "");
        begp.b("0X800A00A", "0X800A00A");
        continue;
        bhhz.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_JavaLangString);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", this.jdField_a_of_type_Int, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begs
 * JD-Core Version:    0.7.0.1
 */