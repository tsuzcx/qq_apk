package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.avgame.util.SchemeUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class AVGameShareEntryLobbyParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    return SchemeUtil.a(new AVGameShareEntryLobbyAction((QQAppInterface)paramBaseQQAppInterface, paramContext), paramString, "avgame", "lobby");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareEntryLobbyParser
 * JD-Core Version:    0.7.0.1
 */