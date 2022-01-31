package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentItemQCallData
  extends RecentUserBaseData
{
  public RecentItemQCallData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
    a(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary);
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.b)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.b).append(",");
      if (this.jdField_c_of_type_Int != 0) {
        break label142;
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      label142:
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemQCallData
 * JD-Core Version:    0.7.0.1
 */