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
    boolean bool1 = false;
    paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
    if (paramQQAppInterface != null) {
      bool1 = paramQQAppInterface.a();
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!bool2) && (paramBoolean))
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715775));
        paramContext.startActivity(localIntent);
      }
      SLog.b("UrlJumpUtils", "jump %s, actionResult = %b, handled = %b", paramQQAppInterface, Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UrlJumpUtils
 * JD-Core Version:    0.7.0.1
 */