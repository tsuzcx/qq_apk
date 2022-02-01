package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerErrorCode;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  WSPlayerManager$MediaPlayListenerAdapterImpl$4(WSPlayerManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl, int paramInt1, int paramInt2, int paramInt3, WSPlayerParam paramWSPlayerParam) {}
  
  public void run()
  {
    String str = WSPlayerErrorCode.a(this.jdField_a_of_type_Int, this.b, this.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][onError] 播放状态回调 errorContent:");
    ((StringBuilder)localObject).append(str);
    WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    if ((localObject != null) && (((WSPlayerParam)localObject).a != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, this.jdField_a_of_type_Int, this.b, str);
    }
    if (WSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl.a) != null)
    {
      localObject = WSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WSPlayerStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, this.jdField_a_of_type_Int, this.b, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */