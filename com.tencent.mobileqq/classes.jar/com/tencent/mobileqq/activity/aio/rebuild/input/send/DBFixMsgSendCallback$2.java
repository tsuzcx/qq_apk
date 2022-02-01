package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.List;
import mqq.os.MqqHandler;

class DBFixMsgSendCallback$2
  implements Runnable
{
  DBFixMsgSendCallback$2(DBFixMsgSendCallback paramDBFixMsgSendCallback, String paramString, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/tencent/com.tencent.mobileqq/data/");
    ((StringBuilder)localObject).append(this.a);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((localFile.getParentFile() != null) && (!localFile.getParentFile().exists())) {
      localFile.getParentFile().mkdirs();
    }
    boolean bool = FileUtils.zipFiles(this.b, (String)localObject);
    ThreadManager.getUIHandler().post(new DBFixMsgSendCallback.2.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DBFixMsgSendCallback.2
 * JD-Core Version:    0.7.0.1
 */