package com.tencent.mobileqq.ark.api.silk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import mqq.app.AppRuntime;

class SilkAudioPlayer$2
  implements Runnable
{
  SilkAudioPlayer$2(SilkAudioPlayer paramSilkAudioPlayer, String paramString) {}
  
  public void run()
  {
    SilkAudioPlayer.a(this.this$0).c();
    String str = TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(this.a), 23, null);
    File localFile = new File(str);
    int i = HttpDownloadUtil.downloadData(BaseApplicationImpl.sApplication.getRuntime(), this.a, localFile);
    if (SilkAudioPlayer.a(this.this$0)) {
      return;
    }
    if (i == 0)
    {
      SilkAudioPlayer.a(this.this$0).a(localFile);
      SilkAudioPlayer.a(this.this$0, str);
      return;
    }
    SilkAudioPlayer.a(this.this$0).c(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */