package com.tencent.biz.subscribe.utils;

import bdhb;
import com.tencent.util.Pair;
import ymb;
import ymf;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(ymb paramymb, String paramString1, String paramString2, ymf paramymf) {}
  
  public void run()
  {
    Pair localPair = ymb.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bdhb.d((String)localPair.first);
      bdhb.d((String)localPair.second);
      if (this.jdField_a_of_type_Ymf != null) {
        this.jdField_a_of_type_Ymf.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Ymf == null) {
      return;
    }
    this.jdField_a_of_type_Ymf.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */