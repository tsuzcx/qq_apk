package com.tencent.mobileqq.ark;

import alth;
import altl;
import ayxp;
import ayxs;
import ayxt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(alth paramalth, altl paramaltl) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)alth.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (ayxs localayxs = (ayxs)localQQAppInterface.getManager(193);; localayxs = null)
    {
      if (localayxs != null)
      {
        alth.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new ayxt(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localayxs.a(10080, "prd", this.a.a, alth.b(this.this$0), this.a.a, "", 1, 0, false, (ayxp)localObject);
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