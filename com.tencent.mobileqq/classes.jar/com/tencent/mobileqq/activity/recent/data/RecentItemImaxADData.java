package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemImaxADData
  extends RecentItemChatMsgData
{
  public String g;
  
  public RecentItemImaxADData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
        if (paramQQAppInterface != null)
        {
          paramContext = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_name");
          if (!TextUtils.isEmpty(paramContext)) {
            this.jdField_b_of_type_JavaLangString = paramContext;
          }
          paramQQAppInterface = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_uin_head_url");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            this.g = paramQQAppInterface;
          }
        }
      }
      if (this.jdField_c_of_type_Int > 0) {
        this.jdField_c_of_type_Int = 1;
      }
      if (AppSetting.b)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
        if (this.jdField_d_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      }
    } while (!QLog.isColorLevel());
    QLog.d("RecentItemImaxADData", 2, "mTitleName:" + this.jdField_b_of_type_JavaLangString + ", mDisplayTime:" + this.jdField_a_of_type_Long + ", mUnreadNum:" + this.jdField_c_of_type_Int + ", mUnreadFlag:" + this.jdField_b_of_type_Int + ", mShowTime:" + this.jdField_c_of_type_JavaLangString + ", mStatus:" + this.jdField_a_of_type_Int + ", mMsgExtroInfo:" + this.jdField_d_of_type_JavaLangCharSequence + ", mExtraInfoColor:" + this.e + ", mLastMsg:" + this.jdField_c_of_type_JavaLangCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData
 * JD-Core Version:    0.7.0.1
 */