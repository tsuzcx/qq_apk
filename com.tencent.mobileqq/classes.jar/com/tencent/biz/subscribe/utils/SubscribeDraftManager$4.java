package com.tencent.biz.subscribe.utils;

import aanf;
import aanj;
import bhmi;
import com.tencent.util.Pair;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(aanf paramaanf, String paramString1, String paramString2, aanj paramaanj) {}
  
  public void run()
  {
    Pair localPair = aanf.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bhmi.d((String)localPair.first);
      bhmi.d((String)localPair.second);
      if (this.jdField_a_of_type_Aanj != null) {
        this.jdField_a_of_type_Aanj.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Aanj == null) {
      return;
    }
    this.jdField_a_of_type_Aanj.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */