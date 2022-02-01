package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class ContactAddParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new ContactAddAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "contact";
    paramQQAppInterface.c = "add";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if ((paramString != null) && (paramString.length == 2)) {
          paramQQAppInterface.a(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ContactAddParser
 * JD-Core Version:    0.7.0.1
 */