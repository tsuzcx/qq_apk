package com.tencent.mobileqq.ark;

import anka;
import anke;
import bavo;
import bavr;
import bavs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(anka paramanka, anke paramanke) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)anka.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (bavr localbavr = (bavr)localQQAppInterface.getManager(193);; localbavr = null)
    {
      if (localbavr != null)
      {
        anka.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new bavs(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localbavr.a(10080, "prd", this.a.a, anka.b(this.this$0), this.a.a, "", 1, 0, false, (bavo)localObject);
        return;
      }
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler fail for predownloadCtrl null,app=", this.a.a });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */