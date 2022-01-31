package com.tencent.biz.subscribe.utils;

import bdcs;
import com.tencent.util.Pair;
import yho;
import yhs;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(yho paramyho, String paramString1, String paramString2, yhs paramyhs) {}
  
  public void run()
  {
    Pair localPair = yho.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bdcs.d((String)localPair.first);
      bdcs.d((String)localPair.second);
      if (this.jdField_a_of_type_Yhs != null) {
        this.jdField_a_of_type_Yhs.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Yhs == null) {
      return;
    }
    this.jdField_a_of_type_Yhs.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */