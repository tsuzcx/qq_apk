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
      return paramResources.getColorStateList(2131165357);
    case 0: 
      return paramResources.getColorStateList(2131165357);
    case 2: 
      return paramResources.getColorStateList(2131165704);
    case 1: 
      return paramResources.getColorStateList(2131165393);
    }
    return paramResources.getColorStateList(2131165704);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130846392);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130846392);
      }
      return paramResources.getDrawable(2130846386);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130846395);
      }
      return paramResources.getDrawable(2130846391);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130846394);
      }
      return paramResources.getDrawable(2130846389);
    }
    if (b) {
      return paramResources.getDrawable(2130846393);
    }
    return paramResources.getDrawable(2130846387);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130847258));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */