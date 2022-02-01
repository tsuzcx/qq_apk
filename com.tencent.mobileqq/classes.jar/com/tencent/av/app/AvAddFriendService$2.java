package com.tencent.av.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.qphone.base.util.QLog;

class AvAddFriendService$2
  extends FriendObserver
{
  AvAddFriendService$2(AvAddFriendService paramAvAddFriendService) {}
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAutoInfo  isSuccess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",remark=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",groupId");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryUinSafetyFlag isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",status=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      AvAddFriendService.a(this.a, String.valueOf(paramLong), 3, paramInt);
      return;
    }
    AvAddFriendService.a(this.a, String.valueOf(paramLong));
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    super.onUpdateAddFriend(paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramBundle);
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel())
    {
      paramBundle = AvAddFriendService.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAddFriend 请求加好友回调  isSuccess= ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",addSuccess=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(",reqestUin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",friendSetting");
      localStringBuilder.append(i);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(paramString)) && (i == 0)) {
      this.a.jdField_a_of_type_Boolean = true;
    }
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uin");
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel())
    {
      String str2 = AvAddFriendService.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAddFriendSetting  isSuccess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",uin");
      localStringBuilder.append(str1);
      localStringBuilder.append(",friendSetting=");
      localStringBuilder.append(i);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(str1)) && (i == 0))
    {
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    ((IFriendHandlerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(str1, null, i, (byte)0, "", this.a.jdField_a_of_type_Int, 0, true, null, true, "", "");
    if (paramBoolean)
    {
      if (this.a.a(str1) == 2)
      {
        this.a.c(str1);
      }
      else
      {
        AvAddFriendService.a(this.a, str1, 1);
        this.a.a(str1);
      }
      paramBundle.getStringArrayList("user_question");
      paramBundle.getBoolean("contact_bothway");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService.2
 * JD-Core Version:    0.7.0.1
 */