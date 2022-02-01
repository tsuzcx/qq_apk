package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;

class LimitChatPie$14
  implements Runnable
{
  LimitChatPie$14(LimitChatPie paramLimitChatPie, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.this$0.f.setText(LimitChatPie.a(this.this$0));
    }
    for (;;)
    {
      localObject = (AioFriendTitleHelper)this.this$0.a(45);
      if (!((AioFriendTitleHelper)localObject).c()) {
        break;
      }
      return;
      this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((AioFriendTitleHelper)localObject).b()) || (!this.this$0.L)) {
      bool = false;
    }
    Object localObject = ((FriendsManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    OnLineStatusHelper.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.14
 * JD-Core Version:    0.7.0.1
 */