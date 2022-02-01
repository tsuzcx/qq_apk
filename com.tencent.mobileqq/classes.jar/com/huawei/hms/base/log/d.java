package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

public class d
  implements b
{
  public b a;
  
  public void a(Context paramContext, String paramString)
  {
    b localb = this.a;
    if (localb != null) {
      localb.a(paramContext, paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HMSSDK_");
    ((StringBuilder)localObject).append(paramString2);
    Log.println(paramInt, ((StringBuilder)localObject).toString(), paramString3);
    localObject = this.a;
    if (localObject != null) {
      ((b)localObject).a(paramString1, paramInt, paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.base.log.d
 * JD-Core Version:    0.7.0.1
 */