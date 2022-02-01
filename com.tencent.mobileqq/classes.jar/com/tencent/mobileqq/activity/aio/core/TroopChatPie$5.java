package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;

class TroopChatPie$5
  implements Runnable
{
  TroopChatPie$5(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */