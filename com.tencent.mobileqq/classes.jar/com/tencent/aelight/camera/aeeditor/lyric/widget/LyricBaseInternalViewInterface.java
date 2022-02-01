package com.tencent.aelight.camera.aeeditor.lyric.widget;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;

public abstract interface LyricBaseInternalViewInterface
{
  public abstract int a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract int b(int paramInt);
  
  public abstract int getEndScrollY();
  
  public abstract Lyric getMeasuredLyric();
  
  public abstract int getTopScroll();
  
  public abstract void setEffectEnable(boolean paramBoolean);
  
  public abstract void setLyric(Lyric paramLyric1, Lyric paramLyric2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricBaseInternalViewInterface
 * JD-Core Version:    0.7.0.1
 */