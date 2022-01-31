package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;

public class SendBlessRecentItemData
  extends RecentUserBaseData
{
  public SendBlessRecentItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    BlessManager localBlessManager = (BlessManager)paramQQAppInterface.getManager(137);
    BlessTask localBlessTask = localBlessManager.a();
    int i;
    if (!localBlessManager.h())
    {
      this.jdField_b_of_type_JavaLangString = paramContext.getResources().getString(2131438270);
      this.jdField_c_of_type_JavaLangCharSequence = localBlessManager.b();
      this.jdField_d_of_type_JavaLangCharSequence = "";
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800618A", "0X800618A", 0, 0, "", "", "", "");
      if (localBlessManager.a() < 0) {
        break label378;
      }
      if (localBlessManager.a() != 0) {
        break label373;
      }
      i = 2;
      label103:
      this.jdField_b_of_type_Int = i;
    }
    label373:
    label378:
    for (this.jdField_c_of_type_Int = 1;; this.jdField_c_of_type_Int = 0)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
      if (this.jdField_a_of_type_Long > 0L) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
      localBlessManager.e();
      if (AppSetting.b)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_c_of_type_Int == 1) {
          paramQQAppInterface.append("有一条未读");
        }
        if (this.jdField_d_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      }
      return;
      if (localBlessTask == null) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = localBlessTask.starWord;
      this.jdField_c_of_type_JavaLangCharSequence = localBlessTask.starBless;
      this.jdField_d_of_type_JavaLangCharSequence = localBlessTask.ex2;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence))
      {
        this.jdField_d_of_type_JavaLangCharSequence = ("[" + this.jdField_d_of_type_JavaLangCharSequence + "] ");
        this.e = paramContext.getResources().getColor(2131494294);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800632B", "0X800632B", 0, 0, "", "", "", "");
      break;
      i = 1;
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData
 * JD-Core Version:    0.7.0.1
 */