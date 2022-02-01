package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.qx.a;

@SuppressLint({"AppCompatCustomView"})
class b$a
  extends TextView
{
  public b$a(b paramb, Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = a.e(getContext(), 5);
    localLayoutParams.setMargins(0, i, 0, i);
    setLayoutParams(localLayoutParams);
    setTextSize(1, 12.0F);
    setTextColor(getContext().getResources().getColor(2131165951));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a
 * JD-Core Version:    0.7.0.1
 */