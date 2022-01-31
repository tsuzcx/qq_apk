package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class ReadinjoyFormSimpleItem
  extends FormSimpleItem
{
  public ReadinjoyFormSimpleItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131165307);
    case 0: 
      return paramResources.getColorStateList(2131165307);
    case 2: 
      return paramResources.getColorStateList(2131165649);
    case 1: 
      return paramResources.getColorStateList(2131165345);
    }
    return paramResources.getColorStateList(2131165649);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130845932);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130845932);
      }
      return paramResources.getDrawable(2130845926);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130845935);
      }
      return paramResources.getDrawable(2130845931);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130845934);
      }
      return paramResources.getDrawable(2130845929);
    }
    if (b) {
      return paramResources.getDrawable(2130845933);
    }
    return paramResources.getDrawable(2130845927);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130846785));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */