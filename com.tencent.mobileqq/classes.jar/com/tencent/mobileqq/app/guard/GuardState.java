package com.tencent.mobileqq.app.guard;

import com.tencent.qphone.base.util.QLog;

public class GuardState
{
  private static final String[] a = { "MSG", "RESUME", "TICK", "FG", "BG", "ENTER", "MAIN" };
  protected static final String[] c = { "EMPTY", "BG_FETCH", "FG_MAIN", "FG_OTHER", "BG_GUARD", "BG_UNGUARD", "LITE_GUARD", "LITE_UNGUARD", "DEAD" };
  protected int d = 0;
  protected GuardManager e;
  protected long f;
  protected long g;
  
  protected void a()
  {
    this.f += 1L;
    this.g += 1L;
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c[this.d]);
      localStringBuilder.append(" onEvent ");
      localStringBuilder.append(a[paramInt]);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.g);
      QLog.d("GuardManager", 2, localStringBuilder.toString());
    }
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.e.nextState(2, null);
      return;
    case 5: 
      b((String)paramObject);
      return;
    case 4: 
      d((String)paramObject);
      return;
    case 3: 
      a((String)paramObject);
      return;
    case 2: 
      a();
      return;
    case 1: 
      c((String)paramObject);
      return;
    }
    b();
  }
  
  protected void a(String paramString) {}
  
  protected void b() {}
  
  protected void b(String paramString)
  {
    this.g = 0L;
    this.f = 0L;
  }
  
  protected void c(String paramString) {}
  
  protected void d(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardState
 * JD-Core Version:    0.7.0.1
 */