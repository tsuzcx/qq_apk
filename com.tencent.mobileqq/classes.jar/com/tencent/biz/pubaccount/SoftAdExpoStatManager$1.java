package com.tencent.biz.pubaccount;

import bgjb;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import obj;

public class SoftAdExpoStatManager$1
  implements Runnable
{
  public SoftAdExpoStatManager$1(obj paramobj) {}
  
  public void run()
  {
    if (obj.a(this.this$0).size() == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = obj.a(this.this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey()).append("&&").append(localEntry.getValue()).append(",,");
    }
    bgjb.a(obj.a(this.this$0), obj.a(this.this$0) + "expo_stat_key_timewindow", localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.1
 * JD-Core Version:    0.7.0.1
 */