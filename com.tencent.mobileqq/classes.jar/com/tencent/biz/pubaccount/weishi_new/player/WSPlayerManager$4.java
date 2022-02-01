package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ukp;
import ukz;
import ula;

class WSPlayerManager$4
  implements Runnable
{
  WSPlayerManager$4(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.b(this.this$0).jdField_a_of_type_AndroidViewView != null))
    {
      if (WSPlayerManager.b(this.this$0).jdField_a_of_type_Ukp != null) {
        WSPlayerManager.b(this.this$0).jdField_a_of_type_Ukp.d(WSPlayerManager.b(this.this$0));
      }
      if (WSPlayerManager.a(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((ula)localIterator.next()).b(WSPlayerManager.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.4
 * JD-Core Version:    0.7.0.1
 */