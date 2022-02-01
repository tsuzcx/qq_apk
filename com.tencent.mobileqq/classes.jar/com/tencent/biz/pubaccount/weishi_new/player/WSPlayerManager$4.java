package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$4
  implements Runnable
{
  WSPlayerManager$4(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.b(this.this$0).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null))
    {
      if (WSPlayerManager.b(this.this$0).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        WSPlayerManager.b(this.this$0).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.d(WSPlayerManager.b(this.this$0));
      }
      if (WSPlayerManager.a(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((WSPlayerStatusListener)localIterator.next()).b(WSPlayerManager.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.4
 * JD-Core Version:    0.7.0.1
 */