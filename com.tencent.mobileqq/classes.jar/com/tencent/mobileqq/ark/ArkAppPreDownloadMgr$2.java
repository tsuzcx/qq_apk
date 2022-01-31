package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import anju;
import anka;
import anke;
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
  public ArkAppPreDownloadMgr$2(anka paramanka) {}
  
  public void run()
  {
    if ((anka.a(this.this$0).size() == 0) || (anka.a(this.this$0))) {}
    for (;;)
    {
      return;
      anka.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = anka.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        anke localanke = (anke)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localanke.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localanke.jdField_a_of_type_JavaLangString, "", null, false))))
        {
          if (anju.c(localanke.jdField_a_of_type_JavaLangString))
          {
            localanke.jdField_a_of_type_Int = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + localanke.jdField_a_of_type_JavaLangString);
          }
          if (localanke.jdField_a_of_type_Int == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + localanke.jdField_a_of_type_JavaLangString);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(localanke.jdField_a_of_type_JavaLangString, "", "0.0.0.1", false);
            anka.a(this.this$0, localanke.jdField_a_of_type_JavaLangString, str, anka.a(this.this$0), 1);
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