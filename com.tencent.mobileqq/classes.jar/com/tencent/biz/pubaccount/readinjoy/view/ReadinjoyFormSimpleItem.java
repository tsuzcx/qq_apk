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
      return paramResources.getColorStateList(2131165343);
    case 0: 
      return paramResources.getColorStateList(2131165343);
    case 2: 
      return paramResources.getColorStateList(2131165687);
    case 1: 
      return paramResources.getColorStateList(2131165379);
    }
    return paramResources.getColorStateList(2131165687);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130846388);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130846388);
      }
      return paramResources.getDrawable(2130846382);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130846391);
      }
      return paramResources.getDrawable(2130846387);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130846390);
      }
      return paramResources.getDrawable(2130846385);
    }
    if (b) {
      return paramResources.getDrawable(2130846389);
    }
    return paramResources.getDrawable(2130846383);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130847252));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */