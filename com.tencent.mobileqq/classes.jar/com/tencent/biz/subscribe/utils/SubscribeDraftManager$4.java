package com.tencent.biz.subscribe.utils;

import bbdx;
import com.tencent.util.Pair;
import wsw;
import wta;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(wsw paramwsw, String paramString1, String paramString2, wta paramwta) {}
  
  public void run()
  {
    Pair localPair = wsw.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      bbdx.e((String)localPair.first);
      bbdx.e((String)localPair.second);
      if (this.jdField_a_of_type_Wta != null) {
        this.jdField_a_of_type_Wta.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Wta == null) {
      return;
    }
    this.jdField_a_of_type_Wta.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */