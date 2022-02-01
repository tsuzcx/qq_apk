package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LyricViewSingleLine
  extends LyricView
{
  public LyricViewSingleLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2064056449, this);
    this.b = ((LyricViewScroll)paramContext.findViewById(2063991625));
    this.a = ((LyricViewInternalSingleLine)paramContext.findViewById(2063991624));
    this.a.a(this.c);
    this.b.setScrollEnable(false);
  }
  
  public LyricViewInternalBase getInternal()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewSingleLine
 * JD-Core Version:    0.7.0.1
 */