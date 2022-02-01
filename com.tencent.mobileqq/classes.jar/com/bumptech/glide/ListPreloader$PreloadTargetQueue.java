package com.bumptech.glide;

import java.util.Queue;

final class ListPreloader$PreloadTargetQueue
{
  private final Queue<ListPreloader.PreloadTarget> a;
  
  public ListPreloader.PreloadTarget a(int paramInt1, int paramInt2)
  {
    ListPreloader.PreloadTarget localPreloadTarget = (ListPreloader.PreloadTarget)this.a.poll();
    this.a.offer(localPreloadTarget);
    localPreloadTarget.b = paramInt1;
    localPreloadTarget.a = paramInt2;
    return localPreloadTarget;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.ListPreloader.PreloadTargetQueue
 * JD-Core Version:    0.7.0.1
 */