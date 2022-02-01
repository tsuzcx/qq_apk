package com.tencent.mobileqq.activity.recent.msgbox.search;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpActionBase;
import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.app.parser.JumpParserResult;

public class TempMsgBoxOpenParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    return new TempMsgBoxJumpAction(paramQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.search.TempMsgBoxOpenParser
 * JD-Core Version:    0.7.0.1
 */