package com.tencent.biz.qqstory.utils;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import java.util.List;

public abstract interface PollWidgetUtils$IPollWidget
{
  public abstract int a();
  
  public abstract Bitmap a();
  
  public abstract View a();
  
  public abstract PollWidgetUtils.OptionElement a(int paramInt);
  
  public abstract PollWidgetUtils.QuestionElement a();
  
  public abstract void a();
  
  public abstract void a(StoryVideoItem.PollLayout paramPollLayout, float paramFloat1, float paramFloat2);
  
  public abstract void a(PollWidgetUtils.OnPollDetailClickListener paramOnPollDetailClickListener);
  
  public abstract void a(PollWidgetUtils.OnWidgetElementClickListener paramOnWidgetElementClickListener);
  
  public abstract void a(List paramList, int paramInt);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(int[] paramArrayOfInt);
  
  public abstract PollWidgetUtils.WidgetElement[] a();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget
 * JD-Core Version:    0.7.0.1
 */