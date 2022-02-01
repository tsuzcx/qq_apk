package com.tencent.biz.pubaccount;

import bhjc;
import java.util.Iterator;
import java.util.Vector;
import oct;

public class SoftAdExpoStatManager$2
  implements Runnable
{
  public SoftAdExpoStatManager$2(oct paramoct, Vector paramVector, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",,");
    }
    bhjc.a(oct.a(this.this$0), oct.a(this.this$0) + "expo_stat_key_" + this.jdField_a_of_type_JavaLangString, localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length()).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager.2
 * JD-Core Version:    0.7.0.1
 */