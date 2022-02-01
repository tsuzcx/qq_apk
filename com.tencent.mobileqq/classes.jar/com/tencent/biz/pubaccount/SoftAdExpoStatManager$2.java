package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.Iterator;
import java.util.Vector;

class SoftAdExpoStatManager$2
  implements Runnable
{
  SoftAdExpoStatManager$2(SoftAdExpoStatManager paramSoftAdExpoStatManager, Vector paramVector, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",,");
    }
    SharePreferenceUtils.a(SoftAdExpoStatManager.a(this.this$0), SoftAdExpoStatManager.a(this.this$0) + "expo_stat_key_" + this.jdField_a_of_type_JavaLangString, localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.2
 * JD-Core Version:    0.7.0.1
 */