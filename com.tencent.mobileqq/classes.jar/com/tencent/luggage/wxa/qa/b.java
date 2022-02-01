package com.tencent.luggage.wxa.qa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.qx.a;

public class b
  extends RelativeLayout
{
  public b(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    Object localObject1 = getContext();
    Object localObject2 = new LinearLayout.LayoutParams(0, 0);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    setId(2131428594);
    localObject2 = new LinearLayout((Context)localObject1);
    ((LinearLayout)localObject2).setId(2131428596);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setGravity(1);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView((Context)localObject1);
    ((ImageView)localObject3).setId(2131428595);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(a.b((Context)localObject1, 2131296340), a.b((Context)localObject1, 2131296340)));
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView((Context)localObject1);
    ((TextView)localObject3).setId(2131428599);
    ((TextView)localObject3).setTextSize(1, a.b((Context)localObject1, 2131296410));
    ((TextView)localObject3).setPadding(a.b((Context)localObject1, 2131296317), 0, a.b((Context)localObject1, 2131296317), 0);
    ((TextView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((LinearLayout)localObject2).addView((View)localObject3);
    addView((View)localObject2);
    localObject2 = new TextView((Context)localObject1);
    ((TextView)localObject2).setId(2131428593);
    ((TextView)localObject2).setTextSize(1, a.b((Context)localObject1, 2131296408));
    ((TextView)localObject2).setBackground(a.a((Context)localObject1, 2130838690));
    ((TextView)localObject2).setTextAppearance((Context)localObject1, 2131952701);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131428596);
    ((RelativeLayout.LayoutParams)localObject3).addRule(17, 2131428596);
    ((RelativeLayout.LayoutParams)localObject3).setMarginStart(a.b((Context)localObject1, 2131296781));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView((View)localObject2);
    localObject2 = new ImageView((Context)localObject1);
    ((ImageView)localObject2).setId(2131428598);
    ((ImageView)localObject2).setBackground(a.a((Context)localObject1, 2130853407));
    localObject3 = new RelativeLayout.LayoutParams(a.b((Context)localObject1, 2131296329), a.b((Context)localObject1, 2131296329));
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131428596);
    ((RelativeLayout.LayoutParams)localObject3).addRule(17, 2131428596);
    ((RelativeLayout.LayoutParams)localObject3).setMarginStart(a.b((Context)localObject1, 2131296782));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = a.e((Context)localObject1, 1);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView((View)localObject2);
    localObject2 = new View((Context)localObject1);
    ((View)localObject2).setId(2131428597);
    localObject1 = new RelativeLayout.LayoutParams(-1, a.b((Context)localObject1, 2131296317));
    ((RelativeLayout.LayoutParams)localObject1).addRule(18, 2131428596);
    ((RelativeLayout.LayoutParams)localObject1).addRule(19, 2131428596);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView((View)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.b
 * JD-Core Version:    0.7.0.1
 */