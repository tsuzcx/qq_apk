package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class RedPacketEmojiFragment$3$1
  implements Runnable
{
  RedPacketEmojiFragment$3$1(RedPacketEmojiFragment.3 param3, int paramInt, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "face config doLoading result:" + this.jdField_a_of_type_Int + ",pathres=" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketEmojiFragment$3.a.b = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketEmojiFragment$3.a.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketEmojiFragment$3.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */