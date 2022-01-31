package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemServiceAccountFolderData
  extends RecentUserBaseData
{
  public RecentItemServiceAccountFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    label31:
    ServiceAccountFolderManager localServiceAccountFolderManager;
    if (PublicAccountConfigUtil.a)
    {
      this.f |= 0x1;
      localServiceAccountFolderManager = ServiceAccountFolderManager.a();
      this.jdField_b_of_type_JavaLangString = ServiceAccountFolderManager.a(paramQQAppInterface);
      this.jdField_a_of_type_Long = localServiceAccountFolderManager.a(paramQQAppInterface);
      this.jdField_c_of_type_Int = localServiceAccountFolderManager.b();
      if (this.jdField_c_of_type_Int > 0) {
        break label424;
      }
      if ((!localServiceAccountFolderManager.a()) || (this.jdField_a_of_type_Long <= localServiceAccountFolderManager.b())) {
        break label416;
      }
      this.jdField_b_of_type_Int = 2;
      this.jdField_c_of_type_Int = 1;
      label96:
      if (this.jdField_a_of_type_Long == 0L) {
        break label432;
      }
      this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      label123:
      this.jdField_c_of_type_JavaLangCharSequence = localServiceAccountFolderManager.a(paramQQAppInterface);
      if (!localServiceAccountFolderManager.b()) {
        break label444;
      }
      this.jdField_a_of_type_Int = 4;
      label144:
      if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_b_of_type_Int != 1)) {
        break label452;
      }
      this.jdField_d_of_type_JavaLangCharSequence = localServiceAccountFolderManager.a();
      this.e = paramContext.getResources().getColor(2131494281);
    }
    for (;;)
    {
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
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemServiceAccountFolderData", 2, "mTitleName:" + this.jdField_b_of_type_JavaLangString + ", mDisplayTime:" + this.jdField_a_of_type_Long + ", mUnreadNum:" + this.jdField_c_of_type_Int + ", mUnreadFlag:" + this.jdField_b_of_type_Int + ", mShowTime:" + this.jdField_c_of_type_JavaLangString + ", mStatus:" + this.jdField_a_of_type_Int + ", mMsgExtroInfo:" + this.jdField_d_of_type_JavaLangCharSequence + ", mExtraInfoColor:" + this.e + ", mLastMsg:" + this.jdField_c_of_type_JavaLangCharSequence);
      return;
      this.f &= 0xFFFFFFFE;
      break label31;
      label416:
      this.jdField_b_of_type_Int = 0;
      break label96;
      label424:
      this.jdField_b_of_type_Int = 1;
      break label96;
      label432:
      this.jdField_c_of_type_JavaLangString = localServiceAccountFolderManager.b(paramQQAppInterface);
      break label123;
      label444:
      this.jdField_a_of_type_Int = 0;
      break label144;
      label452:
      this.jdField_d_of_type_JavaLangCharSequence = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData
 * JD-Core Version:    0.7.0.1
 */