package com.tencent.mobileqq.activity.aio.rebuild;

import agld;
import aloz;
import android.widget.TextView;
import awaf;
import axwx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class FriendChatPie$25
  implements Runnable
{
  public FriendChatPie$25(agld paramagld, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (axwx)this.this$0.a(45);
    if (((axwx)localObject).c()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((axwx)localObject).b()) || (!this.this$0.Q)) {
      bool = false;
    }
    localObject = ((aloz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    awaf.a().a((Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.25
 * JD-Core Version:    0.7.0.1
 */