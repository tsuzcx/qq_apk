package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import java.util.Iterator;
import java.util.Set;

public class LightAppOpenParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new LightAppOpenAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "lightapp";
    paramBaseQQAppInterface.c = "open";
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramJumpParserResult = (String)paramString.next();
      if (!TextUtils.isEmpty(paramJumpParserResult))
      {
        String str = paramContext.getQueryParameter(paramJumpParserResult);
        if (!TextUtils.isEmpty(str)) {
          paramBaseQQAppInterface.a(paramJumpParserResult, str);
        }
      }
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.LightAppOpenParser
 * JD-Core Version:    0.7.0.1
 */