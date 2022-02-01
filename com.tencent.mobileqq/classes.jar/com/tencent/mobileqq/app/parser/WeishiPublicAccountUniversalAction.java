package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WeishiPublicAccountUniversalAction
  extends JumpAction
{
  private Object H;
  
  public WeishiPublicAccountUniversalAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public WeishiPublicAccountUniversalAction(QQAppInterface paramQQAppInterface, Context paramContext, Object paramObject)
  {
    this(paramQQAppInterface, paramContext);
    this.H = paramObject;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = ((IWSManager)QRoute.api(IWSManager.class)).doJumpAction((String)this.f.get("action"), this.b, this.f, this.H);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("WeishiPublicAccountUniversalAction", 1, localStringBuilder.toString());
      h_("WeishiPublicAccountUniversalAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountUniversalAction
 * JD-Core Version:    0.7.0.1
 */