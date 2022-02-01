package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class PoiMapActivity$TabView
  extends RelativeLayout
{
  public TextView a;
  public View b;
  public View c;
  public int d;
  public String e;
  
  public PoiMapActivity$TabView(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.d = paramInt;
    this.e = paramString;
    this.a = new TextView(paramContext);
    this.a.setTextSize(16.0F);
    this.a.setText(paramString);
    this.a.setTextColor(paramPoiMapActivity.e);
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(13, -1);
    addView(this.a, paramString);
    this.b = new View(paramContext);
    this.b.setBackgroundColor(paramPoiMapActivity.k);
    paramString = new RelativeLayout.LayoutParams(-2, (int)(paramPoiMapActivity.l * 3.0F));
    paramString.addRule(12, -1);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131298232);
    paramString.rightMargin = paramInt;
    paramString.leftMargin = paramInt;
    this.b.setVisibility(4);
    addView(this.b, paramString);
    this.c = new View(paramContext);
    this.c.setBackgroundDrawable(null);
    this.c.setBackgroundResource(paramPoiMapActivity.j);
    paramContext = new RelativeLayout.LayoutParams((int)(paramPoiMapActivity.l * 2.0F), (int)(paramPoiMapActivity.l * 20.0F));
    paramContext.addRule(15, -1);
    paramContext.addRule(11, -1);
    addView(this.c, paramContext);
    setOnClickListener(paramPoiMapActivity.aj);
  }
  
  public void a()
  {
    this.c.setVisibility(4);
  }
  
  public void setSelect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.f.getString(2131892670));
      setContentDescription(localStringBuilder.toString());
      this.a.setTextColor(this.f.f);
      this.b.setVisibility(0);
      return;
    }
    setContentDescription(this.e);
    this.a.setTextColor(this.f.e);
    this.b.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.TabView
 * JD-Core Version:    0.7.0.1
 */