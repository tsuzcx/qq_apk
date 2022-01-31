package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import uta;
import wsv;
import xrq;
import xsa;

public class InteractContainerLayout
  extends FrameLayout
{
  public uta a;
  private final xrq a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Xrq = new xsa(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Xrq.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Uta == null) {
      return;
    }
    this.jdField_a_of_type_Xrq.a(this.jdField_a_of_type_Uta.b, this.jdField_a_of_type_Uta.c, paramInt1, paramInt2, this.jdField_a_of_type_Uta.d, this.jdField_a_of_type_Uta.e, this.jdField_a_of_type_Uta.f, this.jdField_a_of_type_Uta.g, this.jdField_a_of_type_Uta.h);
    this.jdField_a_of_type_Xrq.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    wsv.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(uta paramuta, int paramInt)
  {
    wsv.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramuta, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Uta = paramuta;
    if ((paramuta == null) || (paramuta.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    xsa localxsa = (xsa)this.jdField_a_of_type_Xrq;
    localxsa.a(paramuta.a);
    localxsa.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localxsa.a(f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.InteractContainerLayout
 * JD-Core Version:    0.7.0.1
 */