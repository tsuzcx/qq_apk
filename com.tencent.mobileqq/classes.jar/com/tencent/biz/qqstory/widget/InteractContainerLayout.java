package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import srp;
import urk;
import vqf;
import vqp;

public class InteractContainerLayout
  extends FrameLayout
{
  public srp a;
  private final vqf a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Vqf = new vqp(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Vqf.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Srp == null) {
      return;
    }
    this.jdField_a_of_type_Vqf.a(this.jdField_a_of_type_Srp.b, this.jdField_a_of_type_Srp.c, paramInt1, paramInt2, this.jdField_a_of_type_Srp.d, this.jdField_a_of_type_Srp.e, this.jdField_a_of_type_Srp.f, this.jdField_a_of_type_Srp.g, this.jdField_a_of_type_Srp.h);
    this.jdField_a_of_type_Vqf.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    urk.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(srp paramsrp, int paramInt)
  {
    urk.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramsrp, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Srp = paramsrp;
    if ((paramsrp == null) || (paramsrp.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    vqp localvqp = (vqp)this.jdField_a_of_type_Vqf;
    localvqp.a(paramsrp.a);
    localvqp.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localvqp.a(f);
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