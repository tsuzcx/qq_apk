package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class StrangerAddFriendHelper$1
  extends ShieldListObserver
{
  StrangerAddFriendHelper$1(StrangerAddFriendHelper paramStrangerAddFriendHelper) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int k = 0;
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), str)) {
        k = 1;
      }
      j += 1;
    }
    if (k != 0)
    {
      ChatActivityUtils.a(this.a.jdField_a_of_type_AndroidAppActivity, paramBoolean, false);
      if (paramBoolean) {
        this.a.e();
      }
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    int k = 0;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), str)) {
        k = 1;
      }
      j += 1;
    }
    if (k != 0)
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerAddFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */