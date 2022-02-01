package com.tencent.mobileqq.activity.recent.config.menu;

import com.tencent.mobileqq.activity.recent.config.IRecentProcessor;

public abstract class AbsMenuFlag
  implements IRecentProcessor
{
  public int compareTo(IRecentProcessor paramIRecentProcessor)
  {
    return 0;
  }
  
  public int priority()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.menu.AbsMenuFlag
 * JD-Core Version:    0.7.0.1
 */