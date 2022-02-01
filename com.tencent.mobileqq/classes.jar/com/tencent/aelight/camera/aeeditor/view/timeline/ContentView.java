package com.tencent.aelight.camera.aeeditor.view.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ContentView
  extends FrameLayout
{
  public ContentView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a()
  {
    setBackgroundColor(getResources().getColor(2063925256));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.ContentView
 * JD-Core Version:    0.7.0.1
 */