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
      return paramResources.getDrawable(2130845859);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130845859);
      }
      return paramResources.getDrawable(2130845853);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130845862);
      }
      return paramResources.getDrawable(2130845858);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130845861);
      }
      return paramResources.getDrawable(2130845856);
    }
    if (b) {
      return paramResources.getDrawable(2130845860);
    }
    return paramResources.getDrawable(2130845854);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130846712));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */