package com.tencent.mobileqq.activity.qwallet;

import aivs;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

public class RedPacketEmojiFragment$4$1
  implements Runnable
{
  public RedPacketEmojiFragment$4$1(aivs paramaivs, int paramInt, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "face config doLoading result:" + this.jdField_a_of_type_Int + ",pathres=" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Aivs.a.b = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath;
      this.jdField_a_of_type_Aivs.a.a();
      return;
    }
    this.jdField_a_of_type_Aivs.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.4.1
 * JD-Core Version:    0.7.0.1
 */