package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SoftAdExpoStatManager$1
  implements Runnable
{
  SoftAdExpoStatManager$1(SoftAdExpoStatManager paramSoftAdExpoStatManager, Map paramMap) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey()).append("&&").append(localEntry.getValue()).append(",,");
    }
    SharePreferenceUtils.a(SoftAdExpoStatManager.a(this.this$0), SoftAdExpoStatManager.a(this.this$0) + "expo_stat_key_timewindow", localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.1
 * JD-Core Version:    0.7.0.1
 */