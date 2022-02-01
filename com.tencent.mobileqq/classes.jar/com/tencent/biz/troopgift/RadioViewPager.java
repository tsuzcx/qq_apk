package com.tencent.biz.troopgift;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RadioViewPager
  extends RelativeLayout
{
  protected GridListViewPager a;
  protected RadioButtonIndicator b;
  protected View c;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  
  public RadioViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadioViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131626704, this, false);
    this.a = ((GridListViewPager)paramContext.findViewById(2131439794));
    this.b = ((RadioButtonIndicator)paramContext.findViewById(2131435686));
    this.b.setOrientation(0);
    this.a.setOnPagerSizeChangeListener(this.b);
    this.a.setOnPageChangeListener(this.b);
    this.c = paramContext.findViewById(2131434252);
    this.d = ((TextView)paramContext.findViewById(2131434250));
    this.f = ((TextView)paramContext.findViewById(2131434251));
    this.e = ((TextView)paramContext.findViewById(2131434249));
    this.f.getPaint().setFlags(8);
    this.f.getPaint().setAntiAlias(true);
    addView(paramContext);
  }
  
  public absMultiViewPager getViewPager()
  {
    return this.a;
  }
  
  public void setEmptyInfo(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.d.setText(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.f.setText(paramString2);
    }
  }
  
  public void setGiftPanel(TroopGiftPanel paramTroopGiftPanel)
  {
    this.a.e = paramTroopGiftPanel;
  }
  
  public void setIsListEmpty(boolean paramBoolean)
  {
    View localView = this.c;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void setIsShowJumpInfo(boolean paramBoolean, String paramString, Context paramContext)
  {
    TextView localTextView = this.f;
    int j = 0;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    localTextView = this.e;
    if (paramBoolean) {
      i = j;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.f.setOnClickListener(new RadioViewPager.1(this, paramContext, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.RadioViewPager
 * JD-Core Version:    0.7.0.1
 */