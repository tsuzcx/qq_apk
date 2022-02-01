package com.tencent.mobileqq.activity.aio.doodle;

import java.util.List;
import java.util.Map;

abstract interface LoadDataJob$LoadDataJobListener
{
  public abstract void a(String paramString, int paramInt, DoodleParam paramDoodleParam, List<PathDrawer> paramList, Map<Integer, Integer> paramMap);
  
  public abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.LoadDataJobListener
 * JD-Core Version:    0.7.0.1
 */