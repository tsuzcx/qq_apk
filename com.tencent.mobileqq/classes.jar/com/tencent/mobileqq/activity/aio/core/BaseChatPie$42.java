package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$42
  implements Runnable
{
  BaseChatPie$42(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ChatActivityFacade.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    try
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847478);
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847479);
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838129);
      SystemAndEmojiEmoticonInfo.preload(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.this$0.b, 2, "emo qvip_emoji_aio_face_new_default_fail, e=" + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(this.this$0.b, 1, "emo qvip_emoji_aio_face oom, e= " + localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.42
 * JD-Core Version:    0.7.0.1
 */