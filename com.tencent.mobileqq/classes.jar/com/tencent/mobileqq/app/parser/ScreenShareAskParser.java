package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;

public class ScreenShareAskParser
  extends JumpParserBase
{
  private JumpAction a(JumpAction paramJumpAction, String paramString)
  {
    paramJumpAction.c = paramString;
    paramJumpAction.d = "avsharescreen";
    paramJumpAction.e = "request";
    paramString = paramString.split("\\?");
    if (paramString.length != 2) {
      return paramJumpAction;
    }
    paramString = paramString[1].split("&");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      if (localObject.split("=").length == 2)
      {
        int j = localObject.indexOf("=");
        paramJumpAction.a(localObject.substring(0, j), localObject.substring(j + 1));
      }
      i += 1;
    }
    return paramJumpAction;
  }
  
  public JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    return a(new ScreenShareAskAction((QQAppInterface)paramBaseQQAppInterface, paramContext), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskParser
 * JD-Core Version:    0.7.0.1
 */