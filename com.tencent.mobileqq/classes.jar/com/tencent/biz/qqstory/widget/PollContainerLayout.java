package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OptionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement;

public class PollContainerLayout
  extends FrameLayout
{
  public StoryVideoItem.PollLayout a;
  boolean b = false;
  public StoryVideoItem c;
  private final PollWidgetUtils.IPollWidget d = PollWidgetUtils.a(getContext(), 1, 1, null);
  
  public PollContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PollContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d.a(false);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.d.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    StoryVideoItem.PollLayout localPollLayout = this.a;
    if (localPollLayout == null) {
      return;
    }
    this.d.a(localPollLayout, paramInt1, paramInt2);
    this.d.c();
  }
  
  public void a(StoryVideoItem.PollLayout paramPollLayout, int paramInt, int[] paramArrayOfInt)
  {
    this.a = paramPollLayout;
    if (paramPollLayout == null)
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    paramPollLayout = paramPollLayout.j;
    this.d.b().a(paramPollLayout[0]);
    int i = 1;
    while (i < paramPollLayout.length)
    {
      PollWidgetUtils.IPollWidget localIPollWidget = this.d;
      int j = i - 1;
      localIPollWidget.a(j).a(paramPollLayout[i]);
      this.d.a(j).a(false);
      i += 1;
    }
    if ((this.b) && (paramInt >= 0))
    {
      this.d.a(paramInt).a(true);
      if (paramArrayOfInt != null)
      {
        this.d.a(paramArrayOfInt);
        this.d.a(true);
      }
      else
      {
        this.d.a(false);
      }
    }
    else
    {
      this.d.a(false);
    }
    a(getWidth(), getHeight());
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.c = paramStoryVideoItem;
    if (paramStoryVideoItem != null)
    {
      a(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mPollResult, paramStoryVideoItem.mPollNumbers);
      return;
    }
    a(null, -1, null);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.b;
    this.b = paramBoolean;
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    a(paramInt1, paramInt2);
    SLog.a("PollContainerLayout", "onLayout wh(%d, %d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.PollContainerLayout
 * JD-Core Version:    0.7.0.1
 */