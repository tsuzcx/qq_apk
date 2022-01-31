package com.tencent.mobileqq.ark;

import anoj;
import anon;
import bazx;
import bbaa;
import bbab;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(anoj paramanoj, anon paramanon) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)anoj.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (bbaa localbbaa = (bbaa)localQQAppInterface.getManager(193);; localbbaa = null)
    {
      if (localbbaa != null)
      {
        anoj.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new bbab(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localbbaa.a(10080, "prd", this.a.a, anoj.b(this.this$0), this.a.a, "", 1, 0, false, (bazx)localObject);
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