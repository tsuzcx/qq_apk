package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$18
  implements Runnable
{
  BaseChatPie$18(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ChatActivityFacade.c(this.this$0.d, this.this$0.ah, false);
    try
    {
      this.this$0.e.getResources().getDrawable(2130848999);
      this.this$0.e.getResources().getDrawable(2130849000);
      this.this$0.e.getResources().getDrawable(2130838002);
      SystemAndEmojiEmoticonInfo.preload(this.this$0.d);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      str = this.this$0.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("emo qvip_emoji_aio_face oom, e= ");
      localStringBuilder.append(localOutOfMemoryError);
      QLog.e(str, 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = this.this$0.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("emo qvip_emoji_aio_face_new_default_fail, e=");
        localStringBuilder.append(localException.getMessage());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.18
 * JD-Core Version:    0.7.0.1
 */