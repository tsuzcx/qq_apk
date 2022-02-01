package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RingAvatarView
  extends FrameLayout
{
  public RingAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RingAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RingAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void showNormal()
  {
    setBackgroundDrawable(null);
  }
  
  public void showStarRing()
  {
    setBackgroundDrawable(getContext().getResources().getDrawable(2130849389));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView
 * JD-Core Version:    0.7.0.1
 */