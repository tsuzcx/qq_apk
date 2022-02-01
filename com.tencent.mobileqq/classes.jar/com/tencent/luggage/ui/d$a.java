package com.tencent.luggage.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

final class d$a
  extends ContextThemeWrapper
{
  private volatile LayoutInflater a;
  
  public d$a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString)) {
      try
      {
        if (this.a == null) {
          this.a = ((LayoutInflater)super.getSystemService(paramString));
        }
        paramString = this.a;
        return paramString;
      }
      finally {}
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.d.a
 * JD-Core Version:    0.7.0.1
 */