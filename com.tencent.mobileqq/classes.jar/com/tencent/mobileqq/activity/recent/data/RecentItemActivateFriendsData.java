package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemActivateFriendsData
  extends RecentUserBaseData
{
  public RecentItemActivateFriendsData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label111:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      QQMessageFacade.Message localMessage = null;
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
      if (localQQMessageFacade != null) {
        localMessage = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      }
      if (localMessage == null) {
        break label242;
      }
      this.jdField_a_of_type_Long = localMessage.time;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface == null) {
        break;
      }
      this.jdField_c_of_type_Int = paramQQAppInterface.a(localMessage.frienduin, localMessage.istroop);
      this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      this.jdField_c_of_type_JavaLangCharSequence = localMessage.getMessageText();
      e();
      if (TextUtils.isEmpty(this.b)) {
        this.b = paramContext.getString(2131437234);
      }
    } while (!AppSetting.b);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.b).append(",");
    if (this.jdField_c_of_type_Int == 0) {}
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      this.jdField_c_of_type_Int = 0;
      break;
      label242:
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Long = 0L;
      if (QLog.isColorLevel()) {
        QLog.e("ActivateFriends.Recent", 2, "RecentActivateFriends update, last msg is null");
      }
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaLangCharSequence = "";
      break label111;
      if (this.jdField_c_of_type_Int == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.jdField_c_of_type_Int == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.jdField_c_of_type_Int > 0) {
        paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData
 * JD-Core Version:    0.7.0.1
 */