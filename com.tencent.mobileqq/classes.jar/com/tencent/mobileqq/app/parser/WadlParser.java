package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class WadlParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramBaseQQAppInterface = new WadlAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
      paramBaseQQAppInterface.c = paramString;
      paramBaseQQAppInterface.d = "gamecenter";
      paramBaseQQAppInterface.e = "install";
      return paramBaseQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WadlParser
 * JD-Core Version:    0.7.0.1
 */