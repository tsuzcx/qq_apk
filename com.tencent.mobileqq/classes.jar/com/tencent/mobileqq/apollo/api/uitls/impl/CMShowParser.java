package com.tencent.mobileqq.apollo.api.uitls.impl;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpActionBase;
import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.app.parser.JumpParserResult;

public class CMShowParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new CMShowAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "shop";
    paramQQAppInterface.c = "apollo_store";
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.CMShowParser
 * JD-Core Version:    0.7.0.1
 */