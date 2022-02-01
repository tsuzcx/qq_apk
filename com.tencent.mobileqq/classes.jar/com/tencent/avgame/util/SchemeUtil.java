package com.tencent.avgame.util;

import com.tencent.mobileqq.utils.JumpAction;

public class SchemeUtil
{
  public static JumpAction a(JumpAction paramJumpAction, String paramString1, String paramString2, String paramString3)
  {
    paramJumpAction.c = paramString1;
    paramJumpAction.d = paramString2;
    paramJumpAction.e = paramString3;
    paramString1 = paramString1.split("\\?");
    if (paramString1.length != 2) {
      return paramJumpAction;
    }
    paramString1 = paramString1[1].split("&");
    int i = 0;
    while (i < paramString1.length)
    {
      paramString2 = paramString1[i];
      if (paramString2.split("=").length == 2)
      {
        int j = paramString2.indexOf("=");
        paramJumpAction.a(paramString2.substring(0, j), paramString2.substring(j + 1));
      }
      i += 1;
    }
    return paramJumpAction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.SchemeUtil
 * JD-Core Version:    0.7.0.1
 */