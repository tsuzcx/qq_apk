package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class QQSettingJumpParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new QQSettingJumpAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.c = paramString;
    if (paramJumpParserResult != null)
    {
      paramBaseQQAppInterface.d = paramJumpParserResult.b();
      paramBaseQQAppInterface.e = paramJumpParserResult.c();
      paramBaseQQAppInterface.a(paramJumpParserResult.d());
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQSettingJumpParser
 * JD-Core Version:    0.7.0.1
 */