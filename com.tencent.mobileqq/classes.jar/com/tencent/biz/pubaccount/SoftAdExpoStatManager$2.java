package com.tencent.biz.pubaccount;

import android.content.Context;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.Iterator;
import java.util.Vector;

class SoftAdExpoStatManager$2
  implements Runnable
{
  SoftAdExpoStatManager$2(SoftAdExpoStatManager paramSoftAdExpoStatManager, Vector paramVector, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder1.append(((Long)((Iterator)localObject).next()).longValue());
      localStringBuilder1.append(",,");
    }
    localObject = SoftAdExpoStatManager.a(this.this$0);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(SoftAdExpoStatManager.b(this.this$0));
    localStringBuilder2.append("expo_stat_key_");
    localStringBuilder2.append(this.b);
    SharePreferenceUtils.a((Context)localObject, localStringBuilder2.toString(), localStringBuilder1.delete(localStringBuilder1.length() - 2, localStringBuilder1.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.2
 * JD-Core Version:    0.7.0.1
 */