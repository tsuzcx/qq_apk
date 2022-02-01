package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private WSPlayerParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  private WSPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
  private boolean jdField_a_of_type_Boolean;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, WSPlayerParam paramWSPlayerParam, WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = paramWSPlayerWrapper;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper == null) || (WSPlayerManager.f(this.this$0)));
      if (!this.jdField_a_of_type_Boolean) {
        WSPlayerManager.a(this.this$0, true);
      }
      l = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b));
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b))) {}
    for (boolean bool = true;; bool = false)
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.a("", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b, 101, l, 0L, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.c, true, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Boolean)) {
        break;
      }
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
      WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */