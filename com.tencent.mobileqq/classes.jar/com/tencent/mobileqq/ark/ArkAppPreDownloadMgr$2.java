package com.tencent.mobileqq.ark;

import altc;
import alti;
import altm;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$2
  implements Runnable
{
  public ArkAppPreDownloadMgr$2(alti paramalti) {}
  
  public void run()
  {
    if ((alti.a(this.this$0).size() == 0) || (alti.a(this.this$0))) {}
    for (;;)
    {
      return;
      alti.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = alti.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        altm localaltm = (altm)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localaltm.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaltm.jdField_a_of_type_JavaLangString, "", null, false))))
        {
          if (altc.c(localaltm.jdField_a_of_type_JavaLangString))
          {
            localaltm.jdField_a_of_type_Int = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + localaltm.jdField_a_of_type_JavaLangString);
          }
          if (localaltm.jdField_a_of_type_Int == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + localaltm.jdField_a_of_type_JavaLangString);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaltm.jdField_a_of_type_JavaLangString, "", "0.0.0.1", false);
            alti.a(this.this$0, localaltm.jdField_a_of_type_JavaLangString, str, alti.a(this.this$0), 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */