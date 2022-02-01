package com.tencent.mobileqq.app.parser.jumpcontroller;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpActionLegacyParser;
import com.tencent.mobileqq.app.parser.JumpParserUtil;
import com.tencent.mobileqq.utils.JumpAction;

public class JumpParserInject
  implements IJumpParserInterface
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString)
  {
    JumpAction localJumpAction = JumpParserUtil.a(paramBaseQQAppInterface, paramContext, paramString);
    if (localJumpAction != null) {
      return localJumpAction;
    }
    return JumpActionLegacyParser.a(paramBaseQQAppInterface, paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.JumpParserInject
 * JD-Core Version:    0.7.0.1
 */