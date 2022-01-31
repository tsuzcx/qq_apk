package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import atqg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicPreDownloader;

public class TroopChatPie$8
  implements Runnable
{
  public TroopChatPie$8(aejb paramaejb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.8
 * JD-Core Version:    0.7.0.1
 */