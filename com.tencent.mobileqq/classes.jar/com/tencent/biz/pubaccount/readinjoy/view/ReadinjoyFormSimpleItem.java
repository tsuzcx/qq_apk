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
      return paramResources.getColorStateList(2131165275);
    case 0: 
      return paramResources.getColorStateList(2131165275);
    case 2: 
      return paramResources.getColorStateList(2131165613);
    case 1: 
      return paramResources.getColorStateList(2131165310);
    }
    return paramResources.getColorStateList(2131165613);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130845474);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130845474);
      }
      return paramResources.getDrawable(2130845468);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130845477);
      }
      return paramResources.getDrawable(2130845473);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130845476);
      }
      return paramResources.getDrawable(2130845471);
    }
    if (b) {
      return paramResources.getDrawable(2130845475);
    }
    return paramResources.getDrawable(2130845469);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130846327));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */