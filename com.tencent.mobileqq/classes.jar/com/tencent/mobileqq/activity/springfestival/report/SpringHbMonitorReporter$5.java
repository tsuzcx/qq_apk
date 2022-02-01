package com.tencent.mobileqq.activity.springfestival.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import java.util.HashMap;
import java.util.Map;

final class SpringHbMonitorReporter$5
  implements Runnable
{
  SpringHbMonitorReporter$5(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if (SpringHbMonitorReporter.a(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getEncodeUrl(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", localObject);
        String str = this.b;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localHashMap.put("ext2", localObject);
        str = this.c;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localHashMap.put("ext3", localObject);
        SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_Int, localHashMap, ReportConstant.Res.a(4));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.5
 * JD-Core Version:    0.7.0.1
 */