package com.tencent.mobileqq.activity.aio.core;

import admh;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$56
  implements Runnable
{
  BaseChatPie$56(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    admh.c(this.this$0.app, this.this$0.sessionInfo, false);
    try
    {
      this.this$0.mContext.getResources().getDrawable(2130847121);
      this.this$0.mContext.getResources().getDrawable(2130847122);
      this.this$0.mContext.getResources().getDrawable(2130838057);
      SystemAndEmojiEmoticonInfo.preload(this.this$0.app);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.this$0.tag, 2, "emo qvip_emoji_aio_face_new_default_fail, e=" + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(this.this$0.tag, 1, "emo qvip_emoji_aio_face oom, e= " + localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.56
 * JD-Core Version:    0.7.0.1
 */