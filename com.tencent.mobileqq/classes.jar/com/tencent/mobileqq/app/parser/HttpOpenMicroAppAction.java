package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class HttpOpenMicroAppAction
  extends JumpActionBase
{
  public HttpOpenMicroAppAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid"))) {
          break label179;
        }
        boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl");
        if (bool) {
          break label179;
        }
        j = 1;
        try
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appscene")))
          {
            i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appscene"));
            if (j != 0) {
              return MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            }
          }
        }
        catch (Exception localException1)
        {
          QLog.e("HttpOpenMicroAppAction", 1, QLog.getStackTraceString(localException1));
          i = 2016;
          continue;
          bool = ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, i, null, null);
          return bool;
        }
        int i = 2016;
      }
      catch (Exception localException2)
      {
        QLog.e("HttpOpenMicroAppAction", 1, "doAction error: " + localException2.getMessage());
        a("HttpOpenMicroAppAction");
        return false;
      }
      continue;
      label179:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HttpOpenMicroAppAction
 * JD-Core Version:    0.7.0.1
 */