package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendOpenPageAction;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class ExtendOpenPageParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    if (QLog.isColorLevel())
    {
      paramJumpParserResult = new StringBuilder();
      paramJumpParserResult.append("parse：");
      paramJumpParserResult.append(paramString);
      QLog.d("ExtendOpenPageParser", 2, paramJumpParserResult.toString());
    }
    paramBaseQQAppInterface = new ExtendOpenPageAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.c = paramString;
    paramBaseQQAppInterface.d = "expand";
    paramBaseQQAppInterface.e = "openpage";
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
 * Qualified Name:     com.tencent.mobileqq.app.parser.ExtendOpenPageParser
 * JD-Core Version:    0.7.0.1
 */