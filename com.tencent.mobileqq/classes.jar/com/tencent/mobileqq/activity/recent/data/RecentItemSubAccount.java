package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public RecentItemSubAccount(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label172:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      MsgSummary localMsgSummary = a();
      if (!AppConstants.w.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131436380);
      this.jdField_c_of_type_Int = 0;
      SubAccountControll.a(paramQQAppInterface, paramContext, this, localMsgSummary);
      if (!TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) {
        localMsgSummary.jdField_b_of_type_Int = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentItemSubAccount.update mUser.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + " mUser.type=" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + " mUnreadNum=" + this.jdField_c_of_type_Int + " mUnreadFlag=" + this.jdField_b_of_type_Int);
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) {
        break label377;
      }
      this.e = paramContext.getResources().getColor(2131494281);
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Long = a();
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, localMsgSummary);
    } while (!AppSetting.b);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
    if (this.jdField_c_of_type_Int == 0) {}
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      this.jdField_b_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
      }
      this.jdField_b_of_type_JavaLangString = (paramContext.getString(2131436291) + "（" + this.jdField_b_of_type_JavaLangString + "）");
      break;
      label377:
      this.jdField_d_of_type_JavaLangCharSequence = "";
      this.e = 0;
      break label172;
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount
 * JD-Core Version:    0.7.0.1
 */