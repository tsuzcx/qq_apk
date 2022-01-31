package com.tencent.mobileqq.ark;

import alti;
import altm;
import ayxn;
import ayxq;
import ayxr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(alti paramalti, altm paramaltm) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)alti.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (ayxq localayxq = (ayxq)localQQAppInterface.getManager(193);; localayxq = null)
    {
      if (localayxq != null)
      {
        alti.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new ayxr(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localayxq.a(10080, "prd", this.a.a, alti.b(this.this$0), this.a.a, "", 1, 0, false, (ayxn)localObject);
        return;
      }
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler fail for predownloadCtrl null,app=", this.a.a });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */