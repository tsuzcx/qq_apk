package com.tencent.luggage.wxa.rh;

import android.content.Context;
import android.content.MutableContextWrapper;

class b$a
  extends MutableContextWrapper
{
  private boolean a = true;
  private b.a.a b;
  
  public b$a(MutableContextWrapper paramMutableContextWrapper)
  {
    super(paramMutableContextWrapper);
  }
  
  public static Context a(Context paramContext)
  {
    if ((paramContext instanceof MutableContextWrapper)) {
      return new a((MutableContextWrapper)paramContext);
    }
    return paramContext;
  }
  
  public void a(b.a.a parama)
  {
    this.b = parama;
  }
  
  public void setBaseContext(Context paramContext)
  {
    if (this.a)
    {
      if (paramContext == getBaseContext()) {
        return;
      }
      ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
      b.a.a locala = this.b;
      if (locala != null) {
        locala.a(paramContext);
      }
    }
    else
    {
      super.setBaseContext(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.b.a
 * JD-Core Version:    0.7.0.1
 */