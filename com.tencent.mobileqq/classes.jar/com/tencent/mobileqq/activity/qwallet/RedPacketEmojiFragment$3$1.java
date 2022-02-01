package com.tencent.mobileqq.activity.qwallet;

import akmv;
import android.text.TextUtils;
import bnpt;
import bnpy;
import com.tencent.qphone.base.util.QLog;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(akmv paramakmv, boolean paramBoolean, bnpt parambnpt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bnpt != null))
    {
      String str = bnpy.a(this.jdField_a_of_type_Bnpt);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Akmv.a.c = str;
        this.jdField_a_of_type_Akmv.a.a();
        return;
      }
    }
    this.jdField_a_of_type_Akmv.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */