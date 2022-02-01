package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

final class ForwardUtils$5
  implements Runnable
{
  ForwardUtils$5(String paramString1, int paramInt1, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, int paramInt2) {}
  
  public void run()
  {
    String str = FileManagerUtil.a(this.a);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("---forwardToNewDataLine--- forwardID:");
    ((StringBuilder)localObject1).append(this.b);
    QLog.i("Dataline_FileAssistant", 1, ((StringBuilder)localObject1).toString());
    if (FileUtils.fileExistsAndNotEmpty(this.a))
    {
      Object localObject2 = FileUtil.a(str);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ".jpg";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FMSettings.a().getDefaultRecvPath());
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      FileUtils.copyFile(this.a, (String)localObject1);
      QLog.i("Dataline_FileAssistant", 1, "---forwardToNewDataLine--- sendLocalFile");
      this.c.getFileManagerEngine().a((String)localObject1, this.d, this.e, this.f, true, 0L, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.5
 * JD-Core Version:    0.7.0.1
 */