package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import wlb;
import ykq;
import zhj;
import zht;

public class InteractContainerLayout
  extends FrameLayout
{
  public wlb a;
  private final zhj a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Zhj = new zht(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Zhj.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Wlb == null) {
      return;
    }
    this.jdField_a_of_type_Zhj.a(this.jdField_a_of_type_Wlb.b, this.jdField_a_of_type_Wlb.c, paramInt1, paramInt2, this.jdField_a_of_type_Wlb.d, this.jdField_a_of_type_Wlb.e, this.jdField_a_of_type_Wlb.f, this.jdField_a_of_type_Wlb.g, this.jdField_a_of_type_Wlb.h);
    this.jdField_a_of_type_Zhj.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    ykq.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(wlb paramwlb, int paramInt)
  {
    ykq.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramwlb, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Wlb = paramwlb;
    if ((paramwlb == null) || (paramwlb.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    zht localzht = (zht)this.jdField_a_of_type_Zhj;
    localzht.a(paramwlb.a);
    localzht.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localzht.a(f);
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