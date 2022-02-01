package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import wqv;
import yqp;
import zpk;
import zpu;

public class InteractContainerLayout
  extends FrameLayout
{
  public wqv a;
  private final zpk a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Zpk = new zpu(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Zpk.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Wqv == null) {
      return;
    }
    this.jdField_a_of_type_Zpk.a(this.jdField_a_of_type_Wqv.b, this.jdField_a_of_type_Wqv.c, paramInt1, paramInt2, this.jdField_a_of_type_Wqv.d, this.jdField_a_of_type_Wqv.e, this.jdField_a_of_type_Wqv.f, this.jdField_a_of_type_Wqv.g, this.jdField_a_of_type_Wqv.h);
    this.jdField_a_of_type_Zpk.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    yqp.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(wqv paramwqv, int paramInt)
  {
    yqp.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramwqv, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Wqv = paramwqv;
    if ((paramwqv == null) || (paramwqv.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    zpu localzpu = (zpu)this.jdField_a_of_type_Zpk;
    localzpu.a(paramwqv.a);
    localzpu.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localzpu.a(f);
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