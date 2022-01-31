package com.tencent.biz.subscribe.utils;

import bace;
import com.tencent.util.Pair;
import wei;
import wem;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(wei paramwei, String paramString1, String paramString2, wem paramwem) {}
  
  public void run()
  {
    Pair localPair = wei.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bace.d((String)localPair.first);
      bace.d((String)localPair.second);
      if (this.jdField_a_of_type_Wem != null) {
        this.jdField_a_of_type_Wem.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Wem == null) {
      return;
    }
    this.jdField_a_of_type_Wem.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */