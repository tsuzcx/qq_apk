package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class b
  extends LinearLayout
{
  private LinearLayout a;
  private Context b;
  private TextView c;
  private ImageView d;
  private ViewGroup e;
  private ViewGroup f;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131629644, this);
    this.b = paramContext;
    this.a = ((LinearLayout)findViewById(2131431280));
    this.a.setOrientation(paramBoolean ^ true);
    this.c = ((TextView)findViewById(2131431733));
    this.d = ((ImageView)findViewById(2131435219));
    this.e = ((ViewGroup)findViewById(2131445137));
    this.f = ((ViewGroup)findViewById(2131434412));
  }
  
  public void addView(View paramView)
  {
    this.a.addView(paramView);
  }
  
  public void setHasBorder(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setBackground(this.b.getDrawable(2130852650));
      return;
    }
    this.e.setBackground(null);
  }
  
  public void setStep(c paramc)
  {
    if (paramc == null)
    {
      this.c.setText(null);
      this.d.setImageDrawable(null);
      this.f.setVisibility(8);
      return;
    }
    this.c.setText(paramc.a());
    this.d.setImageResource(a.a(paramc.b()));
    this.f.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */