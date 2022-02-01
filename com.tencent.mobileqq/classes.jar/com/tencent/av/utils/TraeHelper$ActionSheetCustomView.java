package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class TraeHelper$ActionSheetCustomView
  extends RelativeLayout
{
  private ImageView a;
  private ImageView b;
  private TextView c;
  
  public TraeHelper$ActionSheetCustomView(Context paramContext, int paramInt, CharSequence paramCharSequence)
  {
    super(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(paramContext.getResources().getDimensionPixelSize(2131298648), 0, 0, 0);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(9, -1);
    this.b = new ImageView(paramContext);
    this.b.setImageResource(paramInt);
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, paramContext.getResources().getDimensionPixelSize(2131298648), 0);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(11, -1);
    this.a = new ImageView(paramContext);
    this.a.setImageResource(2130843290);
    this.a.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(14, -1);
    this.c = new TextView(paramContext);
    this.c.setText(paramCharSequence);
    this.c.setLayoutParams(localLayoutParams);
    this.c.setGravity(17);
    this.c.setTextColor(-16777216);
    this.c.setTextSize(0, paramContext.getResources().getDimension(2131299862));
    addView(this.b);
    addView(this.c);
    addView(this.a);
    setBackgroundResource(2130837678);
    setId(2131436870);
    setMinimumHeight(paramContext.getResources().getDimensionPixelSize(2131297055));
  }
  
  public void a(int paramInt)
  {
    this.b.setImageResource(paramInt);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.a;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localImageView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.ActionSheetCustomView
 * JD-Core Version:    0.7.0.1
 */