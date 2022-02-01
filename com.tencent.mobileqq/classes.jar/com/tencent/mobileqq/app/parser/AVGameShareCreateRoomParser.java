package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.avgame.util.SchemeUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class AVGameShareCreateRoomParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    if ((paramContext instanceof Activity)) {
      paramBaseQQAppInterface = new AVGameShareCreateRoomAction(paramBaseQQAppInterface, (Activity)paramContext);
    } else {
      paramBaseQQAppInterface = new AVGameShareCreateRoomAction(paramBaseQQAppInterface, paramContext);
    }
    return SchemeUtil.a(paramBaseQQAppInterface, paramString, "avgame", "create_room");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareCreateRoomParser
 * JD-Core Version:    0.7.0.1
 */