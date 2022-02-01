package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class AVGameShareJoinRoomParser
  extends JumpParserBase
{
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    paramQQAppInterface = new AVGameShareJoinRoomAction(paramQQAppInterface, paramContext);
    paramQQAppInterface.a = paramString;
    paramQQAppInterface.b = "avgame";
    paramQQAppInterface.c = "join_room";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int i = 0;
    while (i < paramContext.length)
    {
      paramString = paramContext[i];
      if (paramString.split("=").length == 2)
      {
        int j = paramString.indexOf("=");
        paramQQAppInterface.a(paramString.substring(0, j), paramString.substring(j + 1));
      }
      i += 1;
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareJoinRoomParser
 * JD-Core Version:    0.7.0.1
 */