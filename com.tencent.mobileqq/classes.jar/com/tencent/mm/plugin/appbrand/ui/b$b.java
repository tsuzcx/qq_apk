package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
class b$b
  extends TextView
{
  private String b;
  private String c;
  
  public b$b(b paramb, Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setTextSize(1, 12.0F);
    setTextColor(getContext().getResources().getColor(2131165217));
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
    b();
  }
  
  private void b()
  {
    setText(String.format("%s: %s", new Object[] { this.b, this.c }));
  }
  
  private void b(String paramString)
  {
    this.c = paramString;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.b
 * JD-Core Version:    0.7.0.1
 */