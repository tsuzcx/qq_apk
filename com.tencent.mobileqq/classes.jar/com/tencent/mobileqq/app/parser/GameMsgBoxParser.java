package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class GameMsgBoxParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    if (QLog.isColorLevel())
    {
      paramJumpParserResult = new StringBuilder();
      paramJumpParserResult.append("parse：");
      paramJumpParserResult.append(paramString);
      QLog.d("GameMsgBoxParser", 2, paramJumpParserResult.toString());
    }
    return new GameMsgBoxParser.GameMsgBoxJumpAction(paramBaseQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.GameMsgBoxParser
 * JD-Core Version:    0.7.0.1
 */