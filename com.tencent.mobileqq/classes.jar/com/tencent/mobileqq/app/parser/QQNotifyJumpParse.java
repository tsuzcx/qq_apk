package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class QQNotifyJumpParse
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new QQNotifyJumpAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "qqnotify";
    paramBaseQQAppInterface.c = paramJumpParserResult.c();
    paramBaseQQAppInterface.a(paramJumpParserResult.a());
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQNotifyJumpParse
 * JD-Core Version:    0.7.0.1
 */