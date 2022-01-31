package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import utb;
import wsv;
import xni;
import xnj;
import xno;
import xnp;

public class PollContainerLayout
  extends FrameLayout
{
  public StoryVideoItem a;
  public utb a;
  private final xnj jdField_a_of_type_Xnj = xni.a(getContext(), 1, 1, null);
  boolean jdField_a_of_type_Boolean = false;
  
  public PollContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PollContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Xnj.a(false);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_Xnj.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Utb == null) {
      return;
    }
    this.jdField_a_of_type_Xnj.a(this.jdField_a_of_type_Utb, paramInt1, paramInt2);
    this.jdField_a_of_type_Xnj.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    if (paramStoryVideoItem != null)
    {
      a(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mPollResult, paramStoryVideoItem.mPollNumbers);
      return;
    }
    a(null, -1, null);
  }
  
  public void a(utb paramutb, int paramInt, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Utb = paramutb;
    if (paramutb == null)
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    paramutb = paramutb.a;
    this.jdField_a_of_type_Xnj.a().a(paramutb[0]);
    int i = 1;
    while (i < paramutb.length)
    {
      this.jdField_a_of_type_Xnj.a(i - 1).a(paramutb[i]);
      this.jdField_a_of_type_Xnj.a(i - 1).b(false);
      i += 1;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramInt >= 0))
    {
      this.jdField_a_of_type_Xnj.a(paramInt).b(true);
      if (paramArrayOfInt != null)
      {
        this.jdField_a_of_type_Xnj.a(paramArrayOfInt);
        this.jdField_a_of_type_Xnj.a(true);
      }
    }
    for (;;)
    {
      a(getWidth(), getHeight());
      return;
      this.jdField_a_of_type_Xnj.a(false);
      continue;
      this.jdField_a_of_type_Xnj.a(false);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = paramBoolean;
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    wsv.a("PollContainerLayout", "onLayout wh(%d, %d)", Integer.valueOf(paramInt3 - paramInt1), Integer.valueOf(paramInt4 - paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.PollContainerLayout
 * JD-Core Version:    0.7.0.1
 */