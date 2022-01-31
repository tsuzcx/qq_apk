package com.tencent.mobileqq.activity.aio.rebuild;

import aeom;
import ajxl;
import android.widget.TextView;
import aujc;
import awbu;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class FriendChatPie$25
  implements Runnable
{
  public FriendChatPie$25(aeom paramaeom, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (awbu)this.this$0.a(45);
    if (((awbu)localObject).b()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((awbu)localObject).a()) || (!this.this$0.Q)) {
      bool = false;
    }
    localObject = ((ajxl)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    aujc.a().a((Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.25
 * JD-Core Version:    0.7.0.1
 */