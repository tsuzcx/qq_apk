package com.tencent.liteav.basic.license;

import android.content.Context;

public class g
  implements e
{
  private Context a;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    if (this.a != null) {
      LicenceCheck.a().a(null, this.a);
    }
    return LicenceCheck.a().b() >= 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.license.g
 * JD-Core Version:    0.7.0.1
 */