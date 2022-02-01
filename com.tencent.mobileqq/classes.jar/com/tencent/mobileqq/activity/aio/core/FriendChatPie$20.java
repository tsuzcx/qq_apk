package com.tencent.mobileqq.activity.aio.core;

import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;

class FriendChatPie$20
  implements Runnable
{
  FriendChatPie$20(FriendChatPie paramFriendChatPie, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (AioFriendTitleHelper)this.this$0.a(45);
    if (((AioFriendTitleHelper)localObject).c()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((AioFriendTitleHelper)localObject).b()) || (!this.this$0.C)) {
      bool = false;
    }
    localObject = ((FriendsManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).setSubtitleOnlineDrawable(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.20
 * JD-Core Version:    0.7.0.1
 */