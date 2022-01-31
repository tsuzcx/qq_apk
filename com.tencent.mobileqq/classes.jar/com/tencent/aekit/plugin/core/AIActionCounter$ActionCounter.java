package com.tencent.aekit.plugin.core;

class AIActionCounter$ActionCounter
{
  public int count;
  public boolean locked = false;
  public long updateTime;
  
  public AIActionCounter$ActionCounter(int paramInt, long paramLong)
  {
    this.count = paramInt;
    this.updateTime = paramLong;
  }
  
  public void clear()
  {
    this.count = 0;
    this.updateTime = 0L;
    this.locked = false;
  }
  
  public void lockCounter()
  {
    this.locked = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIActionCounter.ActionCounter
 * JD-Core Version:    0.7.0.1
 */