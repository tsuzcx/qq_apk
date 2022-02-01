package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class WadlParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramQQAppInterface = new WadlAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.a = paramString;
      paramQQAppInterface.b = "gamecenter";
      paramQQAppInterface.c = "install";
      return paramQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WadlParser
 * JD-Core Version:    0.7.0.1
 */