package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

public class k
  extends ContextThemeWrapper
{
  protected static final k.a a = new k.1();
  private Resources b;
  private LayoutInflater c;
  private final k.a d;
  
  public k(Context paramContext, k.a parama)
  {
    super.attachBaseContext(paramContext);
    paramContext = parama;
    if (parama == null) {
      paramContext = a;
    }
    this.d = paramContext;
  }
  
  public Resources a(Resources paramResources)
  {
    return new a(paramResources, paramResources.getDisplayMetrics(), paramResources.getConfiguration(), this.d);
  }
  
  public Resources getResources()
  {
    if (getAssets() != null)
    {
      if (this.b == null) {
        this.b = a(super.getResources());
      }
      return this.b;
    }
    return super.getResources();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      paramString = this.c;
      if (paramString != null) {
        return paramString;
      }
      paramString = (LayoutInflater)super.getSystemService("layout_inflater");
      this.c = paramString;
      return paramString;
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */