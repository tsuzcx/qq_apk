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
      return paramResources.getColorStateList(2131099738);
    case 0: 
      return paramResources.getColorStateList(2131099738);
    case 2: 
      return paramResources.getColorStateList(2131100028);
    case 1: 
      return paramResources.getColorStateList(2131099773);
    }
    return paramResources.getColorStateList(2131100028);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130845290);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130845290);
      }
      return paramResources.getDrawable(2130845283);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130845293);
      }
      return paramResources.getDrawable(2130845289);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130845292);
      }
      return paramResources.getDrawable(2130845287);
    }
    if (b) {
      return paramResources.getDrawable(2130845291);
    }
    return paramResources.getDrawable(2130845285);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130846146));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */