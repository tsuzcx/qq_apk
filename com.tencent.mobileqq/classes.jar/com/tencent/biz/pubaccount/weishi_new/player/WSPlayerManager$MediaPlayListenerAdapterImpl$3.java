package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ujv;
import ujz;
import ukb;
import ukc;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$3
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$3(ujz paramujz, int paramInt1, int paramInt2, ukb paramukb) {}
  
  public void run()
  {
    String str = WSPlayerManager.a(this.jdField_a_of_type_Ujz.a, this.jdField_a_of_type_Int, this.b);
    if ((this.jdField_a_of_type_Ukb != null) && (this.jdField_a_of_type_Ukb.a != null)) {
      this.jdField_a_of_type_Ukb.a.a(this.jdField_a_of_type_Ukb, this.jdField_a_of_type_Int, this.b, str);
    }
    if (WSPlayerManager.a(this.jdField_a_of_type_Ujz.a) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.jdField_a_of_type_Ujz.a).iterator();
      while (localIterator.hasNext()) {
        ((ukc)localIterator.next()).a(this.jdField_a_of_type_Ukb, this.jdField_a_of_type_Int, this.b, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3
 * JD-Core Version:    0.7.0.1
 */