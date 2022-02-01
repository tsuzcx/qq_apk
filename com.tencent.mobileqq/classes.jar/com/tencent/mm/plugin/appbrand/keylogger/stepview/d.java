package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class d
  extends LinearLayout
{
  private TextView a;
  private ImageView b;
  
  public d(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131629643, this);
    this.a = ((TextView)findViewById(2131431733));
    this.b = ((ImageView)findViewById(2131435219));
  }
  
  public void setStep(c paramc)
  {
    if (paramc == null)
    {
      this.a.setText(null);
      this.b.setImageDrawable(null);
      return;
    }
    this.a.setText(paramc.a());
    this.b.setImageResource(a.a(paramc.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */