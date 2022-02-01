package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class ScreenShareAskParser
  extends JumpParserBase
{
  private JumpActionBase a(JumpActionBase paramJumpActionBase, String paramString)
  {
    paramJumpActionBase.a = paramString;
    paramJumpActionBase.b = "avsharescreen";
    paramJumpActionBase.c = "request";
    paramString = paramString.split("\\?");
    if (paramString.length != 2) {}
    for (;;)
    {
      return paramJumpActionBase;
      paramString = paramString[1].split("&");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        if (localObject.split("=").length == 2)
        {
          int j = localObject.indexOf("=");
          paramJumpActionBase.a(localObject.substring(0, j), localObject.substring(j + 1));
        }
        i += 1;
      }
    }
  }
  
  public JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, JumpParserResult paramJumpParserResult)
  {
    return a(new ScreenShareAskAction(paramQQAppInterface, paramContext), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskParser
 * JD-Core Version:    0.7.0.1
 */