package com.tencent.mobileqq.activity.qwallet;

import akyg;
import android.text.TextUtils;
import borf;
import bork;
import com.tencent.qphone.base.util.QLog;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(akyg paramakyg, boolean paramBoolean, borf paramborf) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Borf != null))
    {
      String str = bork.a(this.jdField_a_of_type_Borf);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Akyg.a.c = str;
        this.jdField_a_of_type_Akyg.a.a();
        return;
      }
    }
    this.jdField_a_of_type_Akyg.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */