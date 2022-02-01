package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.res.Resources.NotFoundException;
import androidx.core.content.ContextCompat;

class j$a$2
  implements Runnable
{
  j$a$2(j.a parama, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.b.b(ContextCompat.getDrawable(this.b.a.b(), this.a));
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label25:
      break label25;
    }
    this.b.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.2
 * JD-Core Version:    0.7.0.1
 */