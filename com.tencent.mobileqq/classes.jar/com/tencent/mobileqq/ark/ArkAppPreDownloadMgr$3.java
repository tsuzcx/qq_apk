package com.tencent.mobileqq.ark;

import aleu;
import aley;
import axxg;
import axxj;
import axxk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(aleu paramaleu, aley paramaley) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)aleu.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (axxj localaxxj = (axxj)localQQAppInterface.getManager(193);; localaxxj = null)
    {
      if (localaxxj != null)
      {
        aleu.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new axxk(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localaxxj.a(10080, "prd", this.a.a, aleu.b(this.this$0), this.a.a, "", 1, 0, false, (axxg)localObject);
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