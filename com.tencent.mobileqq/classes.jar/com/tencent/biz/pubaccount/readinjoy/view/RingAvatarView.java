package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;

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
    setBackgroundDrawable(getContext().getResources().getDrawable(2130845420));
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = AIOUtils.a(43.0F, getContext().getResources());
    localLayoutParams.height = AIOUtils.a(43.0F, getContext().getResources());
    setLayoutParams(localLayoutParams);
  }
  
  public void b()
  {
    setBackgroundDrawable(null);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = AIOUtils.a(43.0F, getContext().getResources());
    localLayoutParams.height = AIOUtils.a(43.0F, getContext().getResources());
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView
 * JD-Core Version:    0.7.0.1
 */