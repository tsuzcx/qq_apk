package com.tencent.mobileqq.ark;

import aqcf;
import aqcj;
import bezs;
import bezv;
import bezw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(aqcf paramaqcf, aqcj paramaqcj) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)aqcf.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (bezv localbezv = (bezv)localQQAppInterface.getManager(193);; localbezv = null)
    {
      if (localbezv != null)
      {
        aqcf.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new bezw(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localbezv.a(10080, "prd", this.a.a, aqcf.b(this.this$0), this.a.a, "", 1, 0, false, (bezs)localObject);
        return;
      }
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler fail for predownloadCtrl null,app=", this.a.a });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */