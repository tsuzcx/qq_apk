package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class UrlJumpUtils
{
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
    boolean bool1 = false;
    boolean bool2;
    if (paramQQAppInterface != null)
    {
      bool2 = paramQQAppInterface.a();
      bool1 = true;
    }
    else
    {
      bool2 = false;
    }
    if ((!bool1) && (paramBoolean))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715699));
      paramContext.startActivity(localIntent);
    }
    SLog.b("UrlJumpUtils", "jump %s, actionResult = %b, handled = %b", paramQQAppInterface, Boolean.valueOf(bool2), Boolean.valueOf(bool1));
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UrlJumpUtils
 * JD-Core Version:    0.7.0.1
 */