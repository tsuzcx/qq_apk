package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemPublicAccountADFolderData
  extends RecentItemChatMsgData
{
  public String g = "";
  
  public RecentItemPublicAccountADFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 1;
    this.g = AdvertisementRecentUserManager.a().a(paramRecentUser.uin);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_uin");
        paramQQAppInterface = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_name");
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
        }
      }
    }
    if (this.jdField_c_of_type_Int > 0) {
      this.jdField_c_of_type_Int = 1;
    }
    if (PublicAccountConfigUtil.a) {}
    for (this.f |= 0x1;; this.f &= 0xFFFFFFFE)
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
      QLog.d("RecentItemPublicAccountADFolderData", 2, "mTitleName:" + this.jdField_b_of_type_JavaLangString + ", mDisplayTime:" + this.jdField_a_of_type_Long + ", mUnreadNum:" + this.jdField_c_of_type_Int + ", mUnreadFlag:" + this.jdField_b_of_type_Int + ", mShowTime:" + this.jdField_c_of_type_JavaLangString + ", mStatus:" + this.jdField_a_of_type_Int + ", mMsgExtroInfo:" + this.jdField_d_of_type_JavaLangCharSequence + ", mExtraInfoColor:" + this.e + ", mLastMsg:" + this.jdField_c_of_type_JavaLangCharSequence);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData
 * JD-Core Version:    0.7.0.1
 */