package com.tencent.biz.TroopRedpoint;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class TroopRedTouchManager$4
  implements Runnable
{
  TroopRedTouchManager$4(TroopRedTouchManager paramTroopRedTouchManager, String paramString) {}
  
  public void run()
  {
    ??? = this.this$0.a.getApplication().getFilesDir();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TroopRedTouchManager2_All");
    ((StringBuilder)localObject2).append(this.this$0.a.getCurrentAccountUin());
    localObject2 = new File((File)???, ((StringBuilder)localObject2).toString()).getAbsolutePath();
    try
    {
      synchronized (this.this$0)
      {
        FileUtils.pushData2File((String)localObject2, Base64Util.encode(this.a.getBytes(), 0), false);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.this$0.c);
        ((StringBuilder)localObject4).append("Q.qqstory.redPoint");
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveLocalFileList Exception,e =");
        localStringBuilder.append(localException.getMessage());
        QLog.e((String)localObject4, 2, localStringBuilder.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.4
 * JD-Core Version:    0.7.0.1
 */