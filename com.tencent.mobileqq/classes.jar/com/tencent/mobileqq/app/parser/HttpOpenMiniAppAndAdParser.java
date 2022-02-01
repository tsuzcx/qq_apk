package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class HttpOpenMiniAppAndAdParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new HttpOpenMiniAppAndAdAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "miniapp";
    paramQQAppInterface.c = "open";
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HttpOpenMiniAppAndAdParser
 * JD-Core Version:    0.7.0.1
 */