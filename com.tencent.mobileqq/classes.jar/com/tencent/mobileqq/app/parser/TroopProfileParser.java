package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopProfileParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new TroopProfileAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "groupopenapp";
    paramQQAppInterface.c = "openapp";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {}
    for (;;)
    {
      return paramQQAppInterface;
      paramContext = paramContext[1].split("&");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramContext[i].split("=");
        if (paramString.length == 2) {
          paramQQAppInterface.a(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopProfileParser
 * JD-Core Version:    0.7.0.1
 */