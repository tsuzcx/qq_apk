package com.tencent.biz.pubaccount;

import bgjb;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import obj;

public class SoftAdExpoStatManager$2
  implements Runnable
{
  public SoftAdExpoStatManager$2(obj paramobj, String paramString) {}
  
  public void run()
  {
    Object localObject = (List)obj.b(this.this$0).get(this.a);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(((Long)((Iterator)localObject).next()).longValue()).append(",,");
    }
    bgjb.a(obj.a(this.this$0), obj.a(this.this$0) + "expo_stat_key_" + this.a, localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.2
 * JD-Core Version:    0.7.0.1
 */