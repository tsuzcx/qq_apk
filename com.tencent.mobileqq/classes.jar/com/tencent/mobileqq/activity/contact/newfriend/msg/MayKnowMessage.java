package com.tencent.mobileqq.activity.contact.newfriend.msg;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;

public class MayKnowMessage
  extends NewFriendMessage
{
  public MayKnowRecommend a;
  
  public MayKnowMessage(MayKnowRecommend paramMayKnowRecommend)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = paramMayKnowRecommend;
    this.jdField_a_of_type_Long = paramMayKnowRecommend.timestamp;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramQQAppInterface = (MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (paramQQAppInterface == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = paramQQAppInterface.a();; bool = false)
    {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getDisplayName(bool);
      this.jdField_a_of_type_JavaLangString = String.format(BaseApplicationImpl.sApplication.getString(2131689660), new Object[] { paramQQAppInterface });
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.msg.MayKnowMessage
 * JD-Core Version:    0.7.0.1
 */