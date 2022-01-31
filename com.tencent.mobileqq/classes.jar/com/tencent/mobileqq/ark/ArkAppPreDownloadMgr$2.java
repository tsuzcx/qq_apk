package com.tencent.mobileqq.ark;

import altb;
import alth;
import altl;
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
  public ArkAppPreDownloadMgr$2(alth paramalth) {}
  
  public void run()
  {
    if ((alth.a(this.this$0).size() == 0) || (alth.a(this.this$0))) {}
    for (;;)
    {
      return;
      alth.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = alth.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        altl localaltl = (altl)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localaltl.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaltl.jdField_a_of_type_JavaLangString, "", null, false))))
        {
          if (altb.c(localaltl.jdField_a_of_type_JavaLangString))
          {
            localaltl.jdField_a_of_type_Int = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + localaltl.jdField_a_of_type_JavaLangString);
          }
          if (localaltl.jdField_a_of_type_Int == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + localaltl.jdField_a_of_type_JavaLangString);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaltl.jdField_a_of_type_JavaLangString, "", "0.0.0.1", false);
            alth.a(this.this$0, localaltl.jdField_a_of_type_JavaLangString, str, alth.a(this.this$0), 1);
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