package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

final class b
  extends LinearLayout
{
  private TextView a;
  private TextView b;
  private Context c;
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    this.c = paramContext.getApplicationContext();
    setOrientation(1);
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      this.a = new TextView(paramContext);
      this.a.setText(paramString1);
      this.a.setTextColor(-16777216);
      addView(this.a);
    }
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      this.b = new TextView(paramContext);
      this.b.setTextColor(-16777216);
      this.b.setText(paramString2);
      addView(this.b);
    }
    try
    {
      setBackgroundDrawable(d.a(paramContext, "infowindow_bg.9.png"));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if (this.a == null)
      {
        this.a = new TextView(this.c);
        this.a.setText(paramString1);
        this.a.setTextColor(-16777216);
        addView(this.a);
      }
      this.a.setText(paramString1);
    }
    do
    {
      while ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if (this.b == null)
        {
          this.b = new TextView(this.c);
          this.b.setTextColor(-16777216);
          this.b.setText(paramString2);
          addView(this.b);
        }
        this.b.setText(paramString2);
        return;
        if (this.a != null)
        {
          removeView(this.a);
          this.a = null;
        }
      }
    } while (this.b == null);
    removeView(this.b);
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.a.b
 * JD-Core Version:    0.7.0.1
 */