package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQFavParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramJumpParserResult = Uri.parse(paramString).getLastPathSegment();
    paramQQAppInterface = new QQFavAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "com.qqfav";
    paramQQAppInterface.c = paramJumpParserResult;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQFavParser
 * JD-Core Version:    0.7.0.1
 */