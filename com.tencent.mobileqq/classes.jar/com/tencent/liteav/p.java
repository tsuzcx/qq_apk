package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;

public class p
{
  public static n a(Context paramContext, int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 4) && (paramInt != 4) && (paramInt != 6) && (paramInt != 3)) {
      return new f(paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("create player error not support type : ");
    paramContext.append(paramInt);
    TXCLog.e("TXSDKUtil", paramContext.toString());
    return null;
  }
  
  public static String a()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.p
 * JD-Core Version:    0.7.0.1
 */