package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;

public class ArkInfoMsg
  extends TroopAtMsg
{
  public ArkInfoMsg(Context paramContext, String paramString)
  {
    a(paramString);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = '[' + paramString + ']')
    {
      this.a = paramString;
      this.b = this.a;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.ArkInfoMsg
 * JD-Core Version:    0.7.0.1
 */