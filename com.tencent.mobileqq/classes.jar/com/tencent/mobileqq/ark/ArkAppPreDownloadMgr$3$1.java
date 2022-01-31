package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import anok;
import anon;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.qphone.base.util.QLog;

public class ArkAppPreDownloadMgr$3$1
  implements Runnable
{
  ArkAppPreDownloadMgr$3$1(ArkAppPreDownloadMgr.3 param3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.a.a))
    {
      if (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.a.a.a, "", null, false))) {
        break label106;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp begin app = ", this.a.a.a });
      }
      ArkAppMgr.getInstance().getAppPathByName(this.a.a.a, "", "0.0.0.1", null, new anok(this));
    }
    label106:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app", this.a.a.a, "allready downloaded" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */