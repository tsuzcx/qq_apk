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
      return paramResources.getColorStateList(2131165381);
    }
    return paramResources.getColorStateList(2131165687);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130846371);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130846371);
      }
      return paramResources.getDrawable(2130846365);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130846374);
      }
      return paramResources.getDrawable(2130846370);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130846373);
      }
      return paramResources.getDrawable(2130846368);
    }
    if (b) {
      return paramResources.getDrawable(2130846372);
    }
    return paramResources.getDrawable(2130846366);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130847235));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */