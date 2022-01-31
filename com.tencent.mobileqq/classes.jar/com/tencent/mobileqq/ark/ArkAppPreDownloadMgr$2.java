package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import anod;
import anoj;
import anon;
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
  public ArkAppPreDownloadMgr$2(anoj paramanoj) {}
  
  public void run()
  {
    if ((anoj.a(this.this$0).size() == 0) || (anoj.a(this.this$0))) {}
    for (;;)
    {
      return;
      anoj.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = anoj.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        anon localanon = (anon)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localanon.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localanon.jdField_a_of_type_JavaLangString, "", null, false))))
        {
          if (anod.c(localanon.jdField_a_of_type_JavaLangString))
          {
            localanon.jdField_a_of_type_Int = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + localanon.jdField_a_of_type_JavaLangString);
          }
          if (localanon.jdField_a_of_type_Int == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + localanon.jdField_a_of_type_JavaLangString);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(localanon.jdField_a_of_type_JavaLangString, "", "0.0.0.1", false);
            anoj.a(this.this$0, localanon.jdField_a_of_type_JavaLangString, str, anoj.a(this.this$0), 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */