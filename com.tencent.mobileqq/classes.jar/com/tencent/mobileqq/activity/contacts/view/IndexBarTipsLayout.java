package com.tencent.mobileqq.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import azvv;

public class IndexBarTipsLayout
  extends RelativeLayout
{
  private IndexBarTipView a;
  
  public IndexBarTipsLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndexBarTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndexBarTipsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new IndexBarTipView(paramContext, paramAttributeSet);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.a, paramContext);
  }
  
  public void setText(String paramString, float paramFloat)
  {
    this.a.setText(paramString);
    paramString = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    paramString.topMargin = ((int)(paramFloat - getWidth() / 2.0D + azvv.a(getContext(), 20.0F)));
    this.a.setLayoutParams(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.IndexBarTipsLayout
 * JD-Core Version:    0.7.0.1
 */