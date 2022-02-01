package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HttpOpenMiniAppAndAdAction
  extends JumpActionBase
{
  public HttpOpenMiniAppAndAdAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("HttpOpenMiniAppAndAdAction", 1, "doAction error: " + localException.getMessage());
      a("HttpOpenMiniAppAndAdAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HttpOpenMiniAppAndAdAction
 * JD-Core Version:    0.7.0.1
 */