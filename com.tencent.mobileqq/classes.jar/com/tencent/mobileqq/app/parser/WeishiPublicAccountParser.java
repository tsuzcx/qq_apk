package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class WeishiPublicAccountParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new WeishiPublicAccountAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.c = paramString;
    paramBaseQQAppInterface.d = "wsgzh";
    paramBaseQQAppInterface.e = "waterfall";
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountParser
 * JD-Core Version:    0.7.0.1
 */