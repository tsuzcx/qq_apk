package com.google.android.exoplayer2.util;

import java.io.IOException;

public class PriorityTaskManager$PriorityTooLowException
  extends IOException
{
  public PriorityTaskManager$PriorityTooLowException(int paramInt1, int paramInt2)
  {
    super("Priority too low [priority=" + paramInt1 + ", highest=" + paramInt2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException
 * JD-Core Version:    0.7.0.1
 */