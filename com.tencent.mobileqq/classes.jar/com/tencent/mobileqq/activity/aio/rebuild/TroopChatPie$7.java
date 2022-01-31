package com.tencent.mobileqq.activity.aio.rebuild;

import awfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicPreDownloader;

class TroopChatPie$7
  implements Runnable
{
  TroopChatPie$7(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.7
 * JD-Core Version:    0.7.0.1
 */