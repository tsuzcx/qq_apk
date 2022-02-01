package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;

final class DynamicConcatenatingMediaSource$MessageData<T>
{
  @Nullable
  public final DynamicConcatenatingMediaSource.EventDispatcher actionOnCompletion;
  public final T customData;
  public final int index;
  
  public DynamicConcatenatingMediaSource$MessageData(int paramInt, T paramT, @Nullable Runnable paramRunnable)
  {
    this.index = paramInt;
    if (paramRunnable != null) {
      paramRunnable = new DynamicConcatenatingMediaSource.EventDispatcher(paramRunnable);
    } else {
      paramRunnable = null;
    }
    this.actionOnCompletion = paramRunnable;
    this.customData = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.MessageData
 * JD-Core Version:    0.7.0.1
 */