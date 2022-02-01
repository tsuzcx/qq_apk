package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FrameLoader$GetFrameReport
{
  public int a = 0;
  public long b = 0L;
  public int c = -1;
  private Map<Integer, Long> d = new ConcurrentHashMap();
  
  public void a(int paramInt, long paramLong)
  {
    this.d.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    if (this.b < paramLong)
    {
      this.b = paramLong;
      this.c = paramInt;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.d.entrySet().iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((Long)((Map.Entry)localIterator.next()).getValue()).longValue()) {}
    if (this.d.size() == 0) {
      return "there_is_no_frame";
    }
    this.a = ((int)l / this.d.size());
    localStringBuilder.append("avg:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|max:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|maxId:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameLoader.GetFrameReport
 * JD-Core Version:    0.7.0.1
 */