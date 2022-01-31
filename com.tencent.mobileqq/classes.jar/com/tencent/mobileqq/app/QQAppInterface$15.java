package com.tencent.mobileqq.app;

import android.net.Uri;
import android.text.TextUtils;
import bbbr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;

class QQAppInterface$15
  implements Runnable
{
  QQAppInterface$15(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    boolean bool1 = this.this$0.c();
    boolean bool2 = this.this$0.g();
    if ((!this.this$0.h()) && (bool2) && (!bool1) && (!this.this$0.k()) && (!this.this$0.l()) && (this.this$0.m()) && (QQAppInterface.b(this.this$0)))
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
          bbbr.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.15
 * JD-Core Version:    0.7.0.1
 */