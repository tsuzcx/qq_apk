package com.tencent.mobileqq.activity.qwallet;

import airc;
import android.text.TextUtils;
import bkwh;
import bkwi;
import com.tencent.qphone.base.util.QLog;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(airc paramairc, boolean paramBoolean, bkwh parambkwh) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bkwh != null))
    {
      String str = bkwi.a(this.jdField_a_of_type_Bkwh);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Airc.a.c = str;
        this.jdField_a_of_type_Airc.a.a();
        return;
      }
    }
    this.jdField_a_of_type_Airc.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */