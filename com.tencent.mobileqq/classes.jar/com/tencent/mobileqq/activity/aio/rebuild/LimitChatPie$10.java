package com.tencent.mobileqq.activity.aio.rebuild;

import ahhp;
import amsw;
import android.text.TextUtils;
import android.widget.TextView;
import axuy;
import bamd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class LimitChatPie$10
  implements Runnable
{
  public LimitChatPie$10(ahhp paramahhp, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.this$0.mSubTilteText.setText(ahhp.a(this.this$0));
    }
    for (;;)
    {
      localObject = (bamd)this.this$0.getHelper(45);
      if (!((bamd)localObject).c()) {
        break;
      }
      return;
      this.this$0.mSubTilteText.setText(this.jdField_a_of_type_JavaLangString);
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((bamd)localObject).b()) || (!this.this$0.setSubTitleVisiable)) {
      bool = false;
    }
    Object localObject = ((amsw)this.this$0.app.getManager(51)).e(this.this$0.sessionInfo.curFriendUin);
    axuy.a().a(this.this$0.app, (Friends)localObject, this.this$0.mSubTilteText, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.10
 * JD-Core Version:    0.7.0.1
 */