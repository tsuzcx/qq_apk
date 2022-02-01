package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class QQFavParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramJumpParserResult = Uri.parse(paramString).getLastPathSegment();
    paramBaseQQAppInterface = new QQFavAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "com.qqfav";
    paramBaseQQAppInterface.c = paramJumpParserResult;
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQFavParser
 * JD-Core Version:    0.7.0.1
 */