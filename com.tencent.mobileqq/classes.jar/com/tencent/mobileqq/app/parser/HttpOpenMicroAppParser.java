package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class HttpOpenMicroAppParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new HttpOpenMicroAppAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "microapp";
    paramBaseQQAppInterface.c = "open";
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[miniapp-scheme], open microapp scheme=");
      paramContext.append(paramString);
      QLog.d("HttpOpenMicroAppParser", 2, paramContext.toString());
    }
    paramContext = paramString.split("\\?");
    if (paramContext.length >= 2)
    {
      if (paramContext[0].length() == 0) {
        return paramBaseQQAppInterface;
      }
      paramContext = paramString.substring(paramContext[0].length() + 1).split("&");
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          paramString = paramContext[i].split("=");
          if ((paramString != null) && (paramString.length == 2))
          {
            paramBaseQQAppInterface.a(paramString[0], paramString[1]);
            if (QLog.isColorLevel())
            {
              paramJumpParserResult = new StringBuilder();
              paramJumpParserResult.append("[miniapp-scheme], open microapp key=");
              paramJumpParserResult.append(paramString[0]);
              paramJumpParserResult.append(", value=");
              paramJumpParserResult.append(paramString[1]);
              QLog.d("HttpOpenMicroAppParser", 2, paramJumpParserResult.toString());
            }
          }
          i += 1;
        }
      }
      paramContext = paramBaseQQAppInterface.b("fakeUrl");
      if ((TextUtils.isEmpty(paramBaseQQAppInterface.b("scene"))) && (!TextUtils.isEmpty(paramContext))) {
        paramBaseQQAppInterface.a("scene", String.valueOf(2003));
      }
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HttpOpenMicroAppParser
 * JD-Core Version:    0.7.0.1
 */