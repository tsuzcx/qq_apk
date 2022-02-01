package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QwalletToLaunchWXMiniAppAction
  extends JumpActionBase
{
  public QwalletToLaunchWXMiniAppAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    WXMiniProgramHelper.a().a(this.a);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      if ((this.a.containsKey("user_name")) && (!StringUtil.a((String)this.a.get("user_name"))))
      {
        boolean bool = C();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletToLaunchWXMiniAppAction", 1, "doAction error: " + localException.getMessage());
      a("QwalletToLaunchWXMiniAppAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletToLaunchWXMiniAppAction
 * JD-Core Version:    0.7.0.1
 */