package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;

class j$a$4
  implements Runnable
{
  j$a$4(j.a parama, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.b.b(this.b.a.b().getResources().getString(this.a));
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label28:
      break label28;
    }
    this.b.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.4
 * JD-Core Version:    0.7.0.1
 */