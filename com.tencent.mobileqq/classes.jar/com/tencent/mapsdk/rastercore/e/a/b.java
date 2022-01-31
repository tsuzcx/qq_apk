package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

final class b
  extends LinearLayout
{
  public TextView a;
  public TextView b;
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    setOrientation(1);
    this.a = new TextView(paramContext);
    this.a.setText(paramString1);
    this.a.setTextColor(-16777216);
    addView(this.a);
    this.b = new TextView(paramContext);
    this.b.setTextColor(-16777216);
    this.b.setText(paramString2);
    addView(this.b);
    try
    {
      setBackgroundDrawable(d.a(paramContext, "infowindow_bg.9.png"));
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.a.b
 * JD-Core Version:    0.7.0.1
 */