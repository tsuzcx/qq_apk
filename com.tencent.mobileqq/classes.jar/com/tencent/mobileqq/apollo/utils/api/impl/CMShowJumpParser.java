package com.tencent.mobileqq.apollo.utils.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.utils.JumpAction;

public class CMShowJumpParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new CMShowJumpAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "shop";
    paramBaseQQAppInterface.c = "apollo_store";
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.CMShowJumpParser
 * JD-Core Version:    0.7.0.1
 */