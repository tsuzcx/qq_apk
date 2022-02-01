package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class QQNotifySettingParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new QQNotifySettingAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.c = paramString;
    paramBaseQQAppInterface.d = "qqnotify";
    paramBaseQQAppInterface.e = paramJumpParserResult.c();
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramBaseQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if ((paramString != null) && (paramString.length == 2)) {
          paramBaseQQAppInterface.a(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQNotifySettingParser
 * JD-Core Version:    0.7.0.1
 */