package com.tencent.mobileqq.activity.aio.rebuild;

import aici;
import android.text.TextUtils;
import android.widget.TextView;
import anvk;
import azbj;
import bbss;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;

public class LimitChatPie$10
  implements Runnable
{
  public LimitChatPie$10(aici paramaici, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.this$0.mSubTilteText.setText(aici.a(this.this$0));
    }
    for (;;)
    {
      localObject = (bbss)this.this$0.getHelper(45);
      if (!((bbss)localObject).c()) {
        break;
      }
      return;
      this.this$0.mSubTilteText.setText(this.jdField_a_of_type_JavaLangString);
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((bbss)localObject).b()) || (!this.this$0.setSubTitleVisiable)) {
      bool = false;
    }
    Object localObject = ((anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.this$0.sessionInfo.curFriendUin);
    azbj.a().a(this.this$0.app, (Friends)localObject, this.this$0.mSubTilteText, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.10
 * JD-Core Version:    0.7.0.1
 */