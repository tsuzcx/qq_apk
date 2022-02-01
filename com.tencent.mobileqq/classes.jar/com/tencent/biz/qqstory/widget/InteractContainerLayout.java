package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import wuq;
import yuk;
import ztf;
import ztp;

public class InteractContainerLayout
  extends FrameLayout
{
  public wuq a;
  private final ztf a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Ztf = new ztp(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Ztf.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Wuq == null) {
      return;
    }
    this.jdField_a_of_type_Ztf.a(this.jdField_a_of_type_Wuq.b, this.jdField_a_of_type_Wuq.c, paramInt1, paramInt2, this.jdField_a_of_type_Wuq.d, this.jdField_a_of_type_Wuq.e, this.jdField_a_of_type_Wuq.f, this.jdField_a_of_type_Wuq.g, this.jdField_a_of_type_Wuq.h);
    this.jdField_a_of_type_Ztf.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    yuk.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(wuq paramwuq, int paramInt)
  {
    yuk.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramwuq, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Wuq = paramwuq;
    if ((paramwuq == null) || (paramwuq.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    ztp localztp = (ztp)this.jdField_a_of_type_Ztf;
    localztp.a(paramwuq.a);
    localztp.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localztp.a(f);
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