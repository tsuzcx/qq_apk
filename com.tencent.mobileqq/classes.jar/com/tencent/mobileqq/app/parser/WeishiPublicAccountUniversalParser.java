package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class WeishiPublicAccountUniversalParser
  extends JumpParserBase
{
  private Object a;
  
  public WeishiPublicAccountUniversalParser() {}
  
  public WeishiPublicAccountUniversalParser(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new WeishiPublicAccountUniversalAction((QQAppInterface)paramBaseQQAppInterface, paramContext, this.a);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "wsgzh";
    paramBaseQQAppInterface.c = "wesee";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramBaseQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramContext[i].split("=");
      if (paramString.length == 2) {
        try
        {
          paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
          paramBaseQQAppInterface.a(paramString[0], paramString[1]);
        }
        catch (Exception paramJumpParserResult)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("failed to decode param value,tmps[1] is:");
            localStringBuilder.append(paramString[0]);
            localStringBuilder.append(",tmps[1] is:");
            localStringBuilder.append(paramString[1]);
            QLog.d("WeishiPublicAccountUniversalParser", 2, localStringBuilder.toString(), paramJumpParserResult);
          }
        }
      }
      i += 1;
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountUniversalParser
 * JD-Core Version:    0.7.0.1
 */