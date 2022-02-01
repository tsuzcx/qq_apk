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
      return paramResources.getColorStateList(2131165351);
    case 0: 
      return paramResources.getColorStateList(2131165351);
    case 2: 
      return paramResources.getColorStateList(2131165695);
    case 1: 
      return paramResources.getColorStateList(2131165387);
    }
    return paramResources.getColorStateList(2131165695);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130846296);
    case 0: 
      if (b) {
        return paramResources.getDrawable(2130846296);
      }
      return paramResources.getDrawable(2130846290);
    case 1: 
      if (b) {
        return paramResources.getDrawable(2130846299);
      }
      return paramResources.getDrawable(2130846295);
    case 2: 
      if (b) {
        return paramResources.getDrawable(2130846298);
      }
      return paramResources.getDrawable(2130846293);
    }
    if (b) {
      return paramResources.getDrawable(2130846297);
    }
    return paramResources.getDrawable(2130846291);
  }
  
  public void a()
  {
    setArrowIcon(getResources().getDrawable(2130847160));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */