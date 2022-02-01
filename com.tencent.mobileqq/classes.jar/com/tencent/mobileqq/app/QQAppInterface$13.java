package com.tencent.mobileqq.app;

import android.net.Uri;
import android.text.TextUtils;
import bhkm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;

class QQAppInterface$13
  implements Runnable
{
  QQAppInterface$13(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    boolean bool1 = this.this$0.d();
    boolean bool2 = this.this$0.h();
    if ((!this.this$0.n()) && (bool2) && (!bool1) && (!this.this$0.q()) && (!this.this$0.r()) && (this.this$0.s()) && (this.this$0.i()))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder((String)localObject);
        ((StringBuilder)localObject).append(File.separatorChar).append("voice").append(File.separatorChar).append("tab").append(this.a).append(".mp3");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("playThemeVoice", 2, "Uri:" + ((StringBuilder)localObject).toString());
        }
        if (localFile.exists()) {
          bhkm.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.13
 * JD-Core Version:    0.7.0.1
 */