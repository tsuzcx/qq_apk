package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import java.util.Iterator;
import java.util.Set;

public class QCircleParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new QCircleAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramContext = paramString.split("\\?");
    if (paramContext.length < 1) {
      return paramBaseQQAppInterface;
    }
    paramContext = paramContext[0].substring(9).split("/");
    if (paramContext.length != 2) {
      return paramBaseQQAppInterface;
    }
    paramBaseQQAppInterface.c = paramString;
    paramBaseQQAppInterface.d = paramContext[0];
    paramBaseQQAppInterface.e = paramContext[1];
    paramContext = Uri.parse(paramString);
    paramJumpParserResult = paramContext.getQueryParameterNames().iterator();
    while (paramJumpParserResult.hasNext())
    {
      String str1 = (String)paramJumpParserResult.next();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = paramContext.getQueryParameter(str1);
        if (!TextUtils.isEmpty(str2)) {
          paramBaseQQAppInterface.a(str1.toLowerCase(), str2);
        }
      }
    }
    paramBaseQQAppInterface.a("key_scheme", paramString);
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QCircleParser
 * JD-Core Version:    0.7.0.1
 */