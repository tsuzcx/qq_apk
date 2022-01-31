package com.tencent.mobileqq.activity.aio.rebuild;

import aedo;
import ajjj;
import android.widget.TextView;
import atlb;
import avbz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class FriendChatPie$26
  implements Runnable
{
  public FriendChatPie$26(aedo paramaedo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (avbz)this.this$0.a(45);
    if (((avbz)localObject).b()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((avbz)localObject).a()) || (!this.this$0.Q)) {
      bool = false;
    }
    localObject = ((ajjj)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    atlb.a().a((Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.26
 * JD-Core Version:    0.7.0.1
 */