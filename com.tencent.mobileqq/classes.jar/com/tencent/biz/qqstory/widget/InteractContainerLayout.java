package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import uxj;
import wxe;
import xvz;
import xwj;

public class InteractContainerLayout
  extends FrameLayout
{
  public uxj a;
  private final xvz a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Xvz = new xwj(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Xvz.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Uxj == null) {
      return;
    }
    this.jdField_a_of_type_Xvz.a(this.jdField_a_of_type_Uxj.b, this.jdField_a_of_type_Uxj.c, paramInt1, paramInt2, this.jdField_a_of_type_Uxj.d, this.jdField_a_of_type_Uxj.e, this.jdField_a_of_type_Uxj.f, this.jdField_a_of_type_Uxj.g, this.jdField_a_of_type_Uxj.h);
    this.jdField_a_of_type_Xvz.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    wxe.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void a(uxj paramuxj, int paramInt)
  {
    wxe.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramuxj, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Uxj = paramuxj;
    if ((paramuxj == null) || (paramuxj.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    xwj localxwj = (xwj)this.jdField_a_of_type_Xvz;
    localxwj.a(paramuxj.a);
    localxwj.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localxwj.a(f);
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