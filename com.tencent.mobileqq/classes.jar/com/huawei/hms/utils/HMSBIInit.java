package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.stats.bs;
import com.huawei.hms.stats.bt.a;

public class HMSBIInit
{
  public static <T> T checkNonNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramString));
    }
    return paramT;
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    checkNonNull(paramContext, "context must not be null.");
    new bt.a(paramContext).d(paramBoolean1).b(paramBoolean2).c(paramBoolean3).a(0, paramString).a();
  }
  
  public boolean isInit()
  {
    return bs.b();
  }
  
  public void refresh(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    checkNonNull(paramContext, "context must not be null.");
    new bt.a(paramContext).d(paramBoolean1).b(paramBoolean2).c(paramBoolean3).a(0, paramString).a(paramBoolean4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInit
 * JD-Core Version:    0.7.0.1
 */