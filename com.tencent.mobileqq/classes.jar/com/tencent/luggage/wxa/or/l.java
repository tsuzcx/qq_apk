package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.tencent.luggage.util.k;

class l
  implements j
{
  private final Activity a;
  
  l(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    return k.a.b(this.a);
  }
  
  public int b()
  {
    return k.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.l
 * JD-Core Version:    0.7.0.1
 */