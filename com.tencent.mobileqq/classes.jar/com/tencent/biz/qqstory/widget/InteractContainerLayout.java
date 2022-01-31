package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import tel;
import veg;
import wdb;
import wdl;

public class InteractContainerLayout
  extends FrameLayout
{
  public tel a;
  private final wdb a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Wdb = new wdl(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Wdb.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Tel == null) {
      return;
    }
    this.jdField_a_of_type_Wdb.a(this.jdField_a_of_type_Tel.b, this.jdField_a_of_type_Tel.c, paramInt1, paramInt2, this.jdField_a_of_type_Tel.d, this.jdField_a_of_type_Tel.e, this.jdField_a_of_type_Tel.f, this.jdField_a_of_type_Tel.g, this.jdField_a_of_type_Tel.h);
    this.jdField_a_of_type_Wdb.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    veg.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(tel paramtel, int paramInt)
  {
    veg.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramtel, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Tel = paramtel;
    if ((paramtel == null) || (paramtel.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    wdl localwdl = (wdl)this.jdField_a_of_type_Wdb;
    localwdl.a(paramtel.a);
    localwdl.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localwdl.a(f);
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