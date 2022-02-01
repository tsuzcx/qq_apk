package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class OpenSdkJumpParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new OpenSdkJumpAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    if (paramJumpParserResult != null)
    {
      paramBaseQQAppInterface.b = paramJumpParserResult.b();
      paramBaseQQAppInterface.c = paramJumpParserResult.c();
      paramBaseQQAppInterface.a(paramJumpParserResult.a());
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OpenSdkJumpParser
 * JD-Core Version:    0.7.0.1
 */