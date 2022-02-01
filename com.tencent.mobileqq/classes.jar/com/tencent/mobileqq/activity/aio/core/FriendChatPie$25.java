package com.tencent.mobileqq.activity.aio.core;

import agab;
import android.widget.TextView;
import anvk;
import azbj;
import bbss;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;

public class FriendChatPie$25
  implements Runnable
{
  public FriendChatPie$25(agab paramagab, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.mSubTilteText.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (bbss)this.this$0.getHelper(45);
    if (((bbss)localObject).c()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((bbss)localObject).b()) || (!this.this$0.setSubTitleVisiable)) {
      bool = false;
    }
    localObject = ((anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.this$0.sessionInfo.curFriendUin);
    azbj.a().a(this.this$0.app, (Friends)localObject, this.this$0.mSubTilteText, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.25
 * JD-Core Version:    0.7.0.1
 */