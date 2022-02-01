package com.tencent.biz.TroopRedpoint;

import bhcu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import ntq;

public class TroopRedTouchManager$4
  implements Runnable
{
  public TroopRedTouchManager$4(ntq paramntq, String paramString) {}
  
  public void run()
  {
    String str = new File(this.this$0.a.getApplication().getFilesDir(), "TroopRedTouchManager2_All" + this.this$0.a.getCurrentAccountUin()).getAbsolutePath();
    synchronized (this.this$0)
    {
      try
      {
        FileUtils.pushData2File(str, bhcu.encode(this.a.getBytes(), 0), false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.this$0.c + "Q.qqstory.redPoint", 2, "saveLocalFileList Exception,e =" + localException.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.4
 * JD-Core Version:    0.7.0.1
 */