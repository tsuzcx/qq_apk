package com.tencent.biz.subscribe.utils;

import bbdj;
import com.tencent.util.Pair;
import wsz;
import wtd;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(wsz paramwsz, String paramString1, String paramString2, wtd paramwtd) {}
  
  public void run()
  {
    Pair localPair = wsz.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bbdj.e((String)localPair.first);
      bbdj.e((String)localPair.second);
      if (this.jdField_a_of_type_Wtd != null) {
        this.jdField_a_of_type_Wtd.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Wtd == null) {
      return;
    }
    this.jdField_a_of_type_Wtd.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */