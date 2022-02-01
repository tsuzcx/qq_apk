package com.tencent.mobileqq.activity.aio.core;

import afiw;
import amsw;
import android.widget.TextView;
import axuy;
import bamd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class FriendChatPie$25
  implements Runnable
{
  public FriendChatPie$25(afiw paramafiw, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.mSubTilteText.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject = (bamd)this.this$0.getHelper(45);
    if (((bamd)localObject).c()) {
      return;
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((bamd)localObject).b()) || (!this.this$0.setSubTitleVisiable)) {
      bool = false;
    }
    localObject = ((amsw)this.this$0.app.getManager(51)).e(this.this$0.sessionInfo.curFriendUin);
    axuy.a().a(this.this$0.app, (Friends)localObject, this.this$0.mSubTilteText, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.25
 * JD-Core Version:    0.7.0.1
 */