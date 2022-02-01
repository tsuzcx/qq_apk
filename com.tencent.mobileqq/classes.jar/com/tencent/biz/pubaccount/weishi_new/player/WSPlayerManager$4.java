package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import vfs;
import vgb;
import vgc;

class WSPlayerManager$4
  implements Runnable
{
  WSPlayerManager$4(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.b(this.this$0).jdField_a_of_type_Vhc != null))
    {
      if (WSPlayerManager.b(this.this$0).jdField_a_of_type_Vfs != null) {
        WSPlayerManager.b(this.this$0).jdField_a_of_type_Vfs.d(WSPlayerManager.b(this.this$0));
      }
      if (WSPlayerManager.a(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((vgc)localIterator.next()).b(WSPlayerManager.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.4
 * JD-Core Version:    0.7.0.1
 */