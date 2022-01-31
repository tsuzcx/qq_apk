package com.tencent.mobileqq.activity.qwallet;

import aivr;
import android.text.TextUtils;
import blao;
import blap;
import com.tencent.qphone.base.util.QLog;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(aivr paramaivr, boolean paramBoolean, blao paramblao) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Blao != null))
    {
      String str = blap.a(this.jdField_a_of_type_Blao);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Aivr.a.c = str;
        this.jdField_a_of_type_Aivr.a.a();
        return;
      }
    }
    this.jdField_a_of_type_Aivr.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */