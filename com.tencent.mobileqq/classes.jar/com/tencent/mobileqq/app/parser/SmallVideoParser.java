package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class SmallVideoParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new SmallVideoAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "now";
    paramQQAppInterface.c = "playmedia";
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.SmallVideoParser
 * JD-Core Version:    0.7.0.1
 */