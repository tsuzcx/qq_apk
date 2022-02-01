package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ukp;
import ukx;
import ukz;
import ula;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$3
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$3(ukx paramukx, int paramInt1, int paramInt2, ukz paramukz) {}
  
  public void run()
  {
    String str = WSPlayerManager.a(this.jdField_a_of_type_Ukx.a, this.jdField_a_of_type_Int, this.b);
    if ((this.jdField_a_of_type_Ukz != null) && (this.jdField_a_of_type_Ukz.a != null)) {
      this.jdField_a_of_type_Ukz.a.a(this.jdField_a_of_type_Ukz, this.jdField_a_of_type_Int, this.b, str);
    }
    if (WSPlayerManager.a(this.jdField_a_of_type_Ukx.a) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.jdField_a_of_type_Ukx.a).iterator();
      while (localIterator.hasNext()) {
        ((ula)localIterator.next()).a(this.jdField_a_of_type_Ukz, this.jdField_a_of_type_Int, this.b, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3
 * JD-Core Version:    0.7.0.1
 */