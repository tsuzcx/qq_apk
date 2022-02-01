package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;

final class a$a
  implements Runnable
{
  private boolean a;
  private UserInfoBean b;
  
  public a$a(a parama, UserInfoBean paramUserInfoBean, boolean paramBoolean)
  {
    this.b = paramUserInfoBean;
    this.a = paramBoolean;
  }
  
  public final void run()
  {
    try
    {
      Object localObject1;
      Object localObject2;
      if (this.b != null)
      {
        localObject1 = this.b;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.bugly.crashreport.common.info.a.b();
          if (localObject2 != null) {
            ((UserInfoBean)localObject1).j = ((com.tencent.bugly.crashreport.common.info.a)localObject2).d();
          }
        }
        x.c("[UserInfo] Record user info.", new Object[0]);
        a.a(this.c, this.b, false);
      }
      if (this.a)
      {
        localObject1 = this.c;
        localObject2 = w.a();
        if (localObject2 != null) {
          ((w)localObject2).a(new a.2((a)localObject1));
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a.a
 * JD-Core Version:    0.7.0.1
 */