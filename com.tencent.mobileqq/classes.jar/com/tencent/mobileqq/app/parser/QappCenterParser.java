package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;

public class QappCenterParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new QappCenterJumpAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "qapp";
    paramQQAppInterface.c = Uri.parse(paramString).getHost();
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QappCenterParser
 * JD-Core Version:    0.7.0.1
 */