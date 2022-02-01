package com.a;

import java.util.Locale;

public final class d
  extends a
  implements k
{
  private m a;
  private i b;
  
  public d(m paramm)
  {
    this(paramm, null, null);
  }
  
  private d(m paramm, g paramg, Locale paramLocale)
  {
    if (paramm == null) {
      throw new IllegalArgumentException("Status line may not be null.");
    }
    this.a = paramm;
    Locale.getDefault();
  }
  
  public final void a(i parami)
  {
    this.b = parami;
  }
  
  public final m b()
  {
    return this.a;
  }
  
  public final i c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.a.d
 * JD-Core Version:    0.7.0.1
 */