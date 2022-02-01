package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class TroopOneWayParser
  extends JumpParserBase
{
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramBaseQQAppInterface = new TroopOneWayAction((QQAppInterface)paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.a = paramString;
    paramBaseQQAppInterface.b = "commonBuddyGroup";
    paramBaseQQAppInterface.c = "open";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramBaseQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramContext[i].split("=");
      if (paramString.length == 2) {
        paramBaseQQAppInterface.a(paramString[0], paramString[1]);
      }
      i += 1;
    }
    return paramBaseQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopOneWayParser
 * JD-Core Version:    0.7.0.1
 */