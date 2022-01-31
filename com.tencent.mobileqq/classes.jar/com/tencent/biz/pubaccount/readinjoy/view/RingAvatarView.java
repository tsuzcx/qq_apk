package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RingAvatarView
  extends RelativeLayout
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
  
  public void a()
  {
    setBackgroundDrawable(getContext().getResources().getDrawable(2130848473));
  }
  
  public void b()
  {
    setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView
 * JD-Core Version:    0.7.0.1
 */