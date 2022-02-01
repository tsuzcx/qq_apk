package com.tencent.mobileqq.activity.aio.rebuild;

import aijm;
import android.widget.TextView;
import anyw;
import azhq;
import bbsi;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class FriendChatPie$25
  implements Runnable
{
  public FriendChatPie$25(aijm paramaijm, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (bbsi)this.this$0.a(45);
    if (((bbsi)localObject).c()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((bbsi)localObject).b()) || (!this.this$0.P)) {
      bool = false;
    }
    localObject = ((anyw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    azhq.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.25
 * JD-Core Version:    0.7.0.1
 */