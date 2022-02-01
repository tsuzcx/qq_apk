package com.tencent.component.network.utils.thread;

public class PriorityThreadPool$Priority
{
  public static final Priority HIGH = new Priority(1, false);
  public static final Priority LOW = new Priority(-1, true);
  public static final Priority NORMAL = new Priority(0, true);
  public final boolean fifo;
  public final int priority;
  
  public PriorityThreadPool$Priority(int paramInt, boolean paramBoolean)
  {
    this.priority = paramInt;
    this.fifo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool.Priority
 * JD-Core Version:    0.7.0.1
 */