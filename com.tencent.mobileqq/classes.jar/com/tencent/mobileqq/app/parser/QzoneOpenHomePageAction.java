package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QzoneOpenHomePageAction
  extends JumpAction
{
  public QzoneOpenHomePageAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    String str2 = (String)this.f.get("uin");
    String str1 = str2;
    try
    {
      if (TextUtils.isEmpty(str2)) {
        str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      }
      QZoneHelper.forwardToUserHome((Activity)this.b, QZoneHelper.UserInfo.getInstance(), str1, 0, 0, 0);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneOpenHomePageAction", 1, localException, new Object[0]);
    }
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
      QLog.e("QzoneOpenHomePageAction", 1, localStringBuilder.toString());
      h_("QzoneOpenHomePageAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneOpenHomePageAction
 * JD-Core Version:    0.7.0.1
 */