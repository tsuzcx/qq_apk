package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.x;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements t
{
  a$1(a parama, List paramList) {}
  
  public final void a(int paramInt) {}
  
  public final void a(int paramInt, aq paramaq, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
      paramLong1 = System.currentTimeMillis();
      paramaq = this.a.iterator();
      while (paramaq.hasNext())
      {
        paramString = (UserInfoBean)paramaq.next();
        paramString.f = paramLong1;
        a.a(this.b, paramString, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a.1
 * JD-Core Version:    0.7.0.1
 */