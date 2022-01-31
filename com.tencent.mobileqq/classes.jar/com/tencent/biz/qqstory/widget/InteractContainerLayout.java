package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import tei;
import ved;
import wcy;
import wdi;

public class InteractContainerLayout
  extends FrameLayout
{
  public tei a;
  private final wcy a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Wcy = new wdi(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Wcy.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Tei == null) {
      return;
    }
    this.jdField_a_of_type_Wcy.a(this.jdField_a_of_type_Tei.b, this.jdField_a_of_type_Tei.c, paramInt1, paramInt2, this.jdField_a_of_type_Tei.d, this.jdField_a_of_type_Tei.e, this.jdField_a_of_type_Tei.f, this.jdField_a_of_type_Tei.g, this.jdField_a_of_type_Tei.h);
    this.jdField_a_of_type_Wcy.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    ved.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(tei paramtei, int paramInt)
  {
    ved.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramtei, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Tei = paramtei;
    if ((paramtei == null) || (paramtei.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    wdi localwdi = (wdi)this.jdField_a_of_type_Wcy;
    localwdi.a(paramtei.a);
    localwdi.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localwdi.a(f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.InteractContainerLayout
 * JD-Core Version:    0.7.0.1
 */