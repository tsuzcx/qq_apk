package com.tencent.biz.subscribe.utils;

import aaje;
import aaji;
import bgmg;
import com.tencent.util.Pair;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(aaje paramaaje, String paramString1, String paramString2, aaji paramaaji) {}
  
  public void run()
  {
    Pair localPair = aaje.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bgmg.d((String)localPair.first);
      bgmg.d((String)localPair.second);
      if (this.jdField_a_of_type_Aaji != null) {
        this.jdField_a_of_type_Aaji.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Aaji == null) {
      return;
    }
    this.jdField_a_of_type_Aaji.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */