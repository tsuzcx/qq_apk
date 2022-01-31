import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class az
  implements Runnable
{
  public az(LiteActivity paramLiteActivity, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin()))) && (!this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setId(2131361888);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130838373));
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838373);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getColorStateList(2131494260));
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setPadding((int)(LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) * 10.0F), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), (int)(LiteActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) * 10.0F), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDimension(2131558669));
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
      }
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -2016) {
        break label510;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg.split("\\|");
      if ((localObject == null) || (localObject.length <= 0)) {
        break label504;
      }
      localObject = localObject[0].trim();
      localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
        break label568;
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      label388:
      localStringBuilder.append(":");
      if (!(localObject instanceof QQText)) {
        break label905;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(((QQText)localObject).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_AndroidContentIntent);
        localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.getHandler();
        if (localObject != null)
        {
          ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_JavaLangRunnable);
          ((Handler)localObject).postDelayed(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_JavaLangRunnable, 10000L);
        }
        return;
        label504:
        localObject = "";
        break;
        label510:
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2011)
        {
          localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
          if (localObject != null)
          {
            localObject = ((AbsStructMsg)localObject).mMsgBrief;
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
        break;
        label568:
        String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str3 == null) || (str3.length() == 0))
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          break label388;
        }
        String str2;
        String str1;
        if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("subAccountLatestNick");
          if (str2 != null)
          {
            str1 = str2;
            if (str2.length() != 0) {}
          }
          else
          {
            str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
          }
          localStringBuilder.append(str3);
          localStringBuilder.append("-");
          localStringBuilder.append(str1);
          break label388;
        }
        if ((1010 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) || (1001 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) || (10002 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop))
        {
          if (String.valueOf(AppConstants.G).equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin))
          {
            str2 = ContactUtils.q(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin);
            str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
            }
            localStringBuilder.append(str3);
            localStringBuilder.append("-");
            localStringBuilder.append(str1);
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -1024) {
              break label388;
            }
            localObject = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getString(2131437666), new Object[] { str1 });
            break label388;
          }
          str2 = ContactUtils.q(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          str1 = str2;
          if (!TextUtils.isEmpty(str2)) {
            continue;
          }
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin;
          continue;
        }
        localStringBuilder.append(str3);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(LiteActivity.jdField_a_of_type_JavaLangString, 2, localException.toString());
        continue;
      }
      label905:
      localStringBuilder.append(localException);
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     az
 * JD-Core Version:    0.7.0.1
 */