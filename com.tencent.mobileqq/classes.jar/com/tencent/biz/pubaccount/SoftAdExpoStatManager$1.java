package com.tencent.biz.pubaccount;

import android.content.Context;
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
    Object localObject1 = this.a.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
      localStringBuilder.append("&&");
      localStringBuilder.append(((Map.Entry)localObject2).getValue());
      localStringBuilder.append(",,");
    }
    localObject1 = SoftAdExpoStatManager.a(this.this$0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(SoftAdExpoStatManager.a(this.this$0));
    ((StringBuilder)localObject2).append("expo_stat_key_timewindow");
    SharePreferenceUtils.a((Context)localObject1, ((StringBuilder)localObject2).toString(), localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.1
 * JD-Core Version:    0.7.0.1
 */