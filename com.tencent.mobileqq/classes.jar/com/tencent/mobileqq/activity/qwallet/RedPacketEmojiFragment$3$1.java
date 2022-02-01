package com.tencent.mobileqq.activity.qwallet;

import akrq;
import android.text.TextUtils;
import bnkt;
import bnky;
import com.tencent.qphone.base.util.QLog;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(akrq paramakrq, boolean paramBoolean, bnkt parambnkt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bnkt != null))
    {
      String str = bnky.a(this.jdField_a_of_type_Bnkt);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Akrq.a.c = str;
        this.jdField_a_of_type_Akrq.a.a();
        return;
      }
    }
    this.jdField_a_of_type_Akrq.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */