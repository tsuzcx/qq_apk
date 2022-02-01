package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class SubScribeAction
  extends JumpAction
{
  public SubScribeAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      SubscribeLaucher.a(this.b, this.e, this.f);
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("SubScribeAction", 1, localStringBuilder.toString());
      h_("SubScribeAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.SubScribeAction
 * JD-Core Version:    0.7.0.1
 */