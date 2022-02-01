package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class HttpOpenMicroAppAction
  extends JumpAction
{
  public HttpOpenMicroAppAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid")))
      {
        bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl");
        if (!bool)
        {
          j = 1;
          break label42;
        }
      }
      int j = 0;
      label42:
      int k = 2016;
      int i = k;
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap != null)
        {
          i = k;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appscene")) {
            i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appscene"));
          }
        }
      }
      catch (Exception localException1)
      {
        QLog.e("HttpOpenMicroAppAction", 1, QLog.getStackTraceString(localException1));
        i = 2016;
      }
      if (j != 0) {
        return MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      }
      boolean bool = ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, i, null, null);
      return bool;
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException2.getMessage());
      QLog.e("HttpOpenMicroAppAction", 1, localStringBuilder.toString());
      b_("HttpOpenMicroAppAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HttpOpenMicroAppAction
 * JD-Core Version:    0.7.0.1
 */