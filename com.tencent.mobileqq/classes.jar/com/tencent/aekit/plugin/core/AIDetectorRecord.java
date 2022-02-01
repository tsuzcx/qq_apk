package com.tencent.aekit.plugin.core;

public class AIDetectorRecord
{
  public int count;
  public long lastDetectTime;
  
  public AIDetectorRecord()
  {
    reset();
  }
  
  public void reset()
  {
    this.count = 0;
    this.lastDetectTime = -1L;
  }
  
  public void update()
  {
    this.count += 1;
    this.lastDetectTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIDetectorRecord
 * JD-Core Version:    0.7.0.1
 */