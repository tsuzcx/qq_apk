package com.huawei.hms.support.log.a;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.log.b;

public class a
  implements b
{
  private b a;
  
  public void a(Context paramContext, String paramString)
  {
    if (this.a != null) {
      this.a.a(paramContext, paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Log.println(paramInt, "HMSSDK_" + paramString2, paramString3);
    if (this.a != null) {
      this.a.a(paramString1, paramInt, paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.log.a.a
 * JD-Core Version:    0.7.0.1
 */