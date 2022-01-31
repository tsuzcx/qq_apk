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
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131492971);
    case 0: 
      return paramResources.getColorStateList(2131492971);
    case 2: 
      return paramResources.getColorStateList(2131493800);
    case 1: 
      return paramResources.getColorStateList(2131493489);
    }
    return paramResources.getColorStateList(2131493800);
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130843386);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130843386);
      }
      return paramResources.getDrawable(2130843379);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130843389);
      }
      return paramResources.getDrawable(2130843385);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130843388);
      }
      return paramResources.getDrawable(2130843383);
    }
    if (b) {
      return paramResources.getDrawable(2130843387);
    }
    return paramResources.getDrawable(2130843381);
  }
  
  protected void a()
  {
    setArrowIcon(getResources().getDrawable(2130844055));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */