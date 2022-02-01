package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

final class ForwardUtils$4
  implements FMDialogUtil.FMDialogInterface
{
  ForwardUtils$4(ArrayList paramArrayList, Activity paramActivity, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, String paramString2) {}
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      String str1;
      if (localUri != null) {
        str1 = new UriParserPathHelper(this.b, false, null).a(localUri);
      } else {
        str1 = "";
      }
      if (TextUtils.isEmpty(str1))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("localPath = null. model:");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(Build.MODEL);
        String str2 = ((StringBuilder)localObject).toString();
        localObject = str2;
        if (localUri != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(" uri:");
          ((StringBuilder)localObject).append(localUri.toString());
          localObject = ((StringBuilder)localObject).toString();
        }
        QLog.e("ForwardUtils<FileAssistant>", 1, (String)localObject);
      }
      if (this.c == 1) {
        this.d.getFileManagerEngine().a(str1, this.e, 0L, this.f);
      } else {
        this.d.getFileManagerEngine().a(str1, this.g, this.e, this.c, true, 0L, this.f);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.4
 * JD-Core Version:    0.7.0.1
 */