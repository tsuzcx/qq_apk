package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import vwg;
import xvv;
import ysq;
import yta;

public class InteractContainerLayout
  extends FrameLayout
{
  public vwg a;
  private final ysq a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Ysq = new yta(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Ysq.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Vwg == null) {
      return;
    }
    this.jdField_a_of_type_Ysq.a(this.jdField_a_of_type_Vwg.b, this.jdField_a_of_type_Vwg.c, paramInt1, paramInt2, this.jdField_a_of_type_Vwg.d, this.jdField_a_of_type_Vwg.e, this.jdField_a_of_type_Vwg.f, this.jdField_a_of_type_Vwg.g, this.jdField_a_of_type_Vwg.h);
    this.jdField_a_of_type_Ysq.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    xvv.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(vwg paramvwg, int paramInt)
  {
    xvv.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramvwg, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Vwg = paramvwg;
    if ((paramvwg == null) || (paramvwg.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    yta localyta = (yta)this.jdField_a_of_type_Ysq;
    localyta.a(paramvwg.a);
    localyta.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localyta.a(f);
      a(getWidth(), getHeight());
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.InteractContainerLayout
 * JD-Core Version:    0.7.0.1
 */