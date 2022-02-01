package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopManagerParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new TroopManagerAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "manage_troop";
    paramQQAppInterface.c = "main_page";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int i = 0;
    while (i < paramContext.length)
    {
      paramString = paramContext[i].split("=");
      if (paramString.length == 2) {
        paramQQAppInterface.a(paramString[0], paramString[1]);
      }
      i += 1;
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopManagerParser
 * JD-Core Version:    0.7.0.1
 */