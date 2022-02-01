package com.tencent.mobileqq.activity.qwallet;

import ajvx;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(ajvx paramajvx, boolean paramBoolean, AEResInfo paramAEResInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo != null))
    {
      String str = AEResUtil.getUnzippedPackageDir(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Ajvx.a.c = str;
        this.jdField_a_of_type_Ajvx.a.a();
        return;
      }
    }
    this.jdField_a_of_type_Ajvx.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */