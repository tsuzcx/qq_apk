package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.Iterator;
import java.util.Vector;
import olx;

public class SoftAdExpoStatManager$2
  implements Runnable
{
  public SoftAdExpoStatManager$2(olx paramolx, Vector paramVector, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",,");
    }
    SharePreferenceUtils.set(olx.a(this.this$0), olx.a(this.this$0) + "expo_stat_key_" + this.jdField_a_of_type_JavaLangString, localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.2
 * JD-Core Version:    0.7.0.1
 */