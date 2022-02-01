package com.tencent.biz.pubaccount;

import bhjc;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import oct;

public class SoftAdExpoStatManager$1
  implements Runnable
{
  public SoftAdExpoStatManager$1(oct paramoct, Map paramMap) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey()).append("&&").append(localEntry.getValue()).append(",,");
    }
    bhjc.a(oct.a(this.this$0), oct.a(this.this$0) + "expo_stat_key_timewindow", localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.1
 * JD-Core Version:    0.7.0.1
 */