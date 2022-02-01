package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import aqbz;
import aqcf;
import aqcj;
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
  public ArkAppPreDownloadMgr$2(aqcf paramaqcf) {}
  
  public void run()
  {
    if ((aqcf.a(this.this$0).size() == 0) || (aqcf.a(this.this$0))) {}
    for (;;)
    {
      return;
      aqcf.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = aqcf.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        aqcj localaqcj = (aqcj)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localaqcj.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaqcj.jdField_a_of_type_JavaLangString, "", null, false))))
        {
          if (aqbz.c(localaqcj.jdField_a_of_type_JavaLangString))
          {
            localaqcj.jdField_a_of_type_Int = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + localaqcj.jdField_a_of_type_JavaLangString);
          }
          if (localaqcj.jdField_a_of_type_Int == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + localaqcj.jdField_a_of_type_JavaLangString);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaqcj.jdField_a_of_type_JavaLangString, "", "0.0.0.1", false);
            aqcf.a(this.this$0, localaqcj.jdField_a_of_type_JavaLangString, str, aqcf.a(this.this$0), 1);
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