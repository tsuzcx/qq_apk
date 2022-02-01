package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class LightAppOpenParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new LightAppOpenAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "lightapp";
    paramQQAppInterface.c = "open";
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramJumpParserResult = (String)paramString.next();
      if (!TextUtils.isEmpty(paramJumpParserResult))
      {
        String str = paramContext.getQueryParameter(paramJumpParserResult);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.a(paramJumpParserResult, str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.LightAppOpenParser
 * JD-Core Version:    0.7.0.1
 */