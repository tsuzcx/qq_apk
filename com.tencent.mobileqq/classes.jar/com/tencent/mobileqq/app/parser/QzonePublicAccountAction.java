package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;

public class QzonePublicAccountAction
  extends JumpAction
{
  public QzonePublicAccountAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    if (this.a == null) {
      return false;
    }
    ((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).openContentBox(this.a);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QzonePublicAccountAction", 1, localStringBuilder.toString());
      b_("QzonePublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzonePublicAccountAction
 * JD-Core Version:    0.7.0.1
 */