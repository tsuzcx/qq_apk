package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ArkAppPreDownloadMgr$2
  implements Runnable
{
  ArkAppPreDownloadMgr$2(ArkAppPreDownloadMgr paramArkAppPreDownloadMgr) {}
  
  public void run()
  {
    if ((ArkAppPreDownloadMgr.a(this.this$0).size() == 0) || (ArkAppPreDownloadMgr.a(this.this$0))) {}
    for (;;)
    {
      return;
      ArkAppPreDownloadMgr.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = ArkAppPreDownloadMgr.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArkAppPreDownloadMgr.PreloadItem localPreloadItem = (ArkAppPreDownloadMgr.PreloadItem)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localPreloadItem.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localPreloadItem.jdField_a_of_type_JavaLangString, "", null, false))))
        {
          if (ArkAppCrashProtect.c(localPreloadItem.jdField_a_of_type_JavaLangString))
          {
            localPreloadItem.jdField_a_of_type_Int = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + localPreloadItem.jdField_a_of_type_JavaLangString);
          }
          if (localPreloadItem.jdField_a_of_type_Int == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + localPreloadItem.jdField_a_of_type_JavaLangString);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(localPreloadItem.jdField_a_of_type_JavaLangString, "", "0.0.0.1", false);
            ArkAppPreDownloadMgr.a(this.this$0, localPreloadItem.jdField_a_of_type_JavaLangString, str, ArkAppPreDownloadMgr.a(this.this$0), 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */