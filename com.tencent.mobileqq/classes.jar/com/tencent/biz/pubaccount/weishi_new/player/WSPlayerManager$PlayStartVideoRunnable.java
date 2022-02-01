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
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
    {
      if (WSPlayerManager.f(this.this$0)) {
        return;
      }
      boolean bool2 = this.jdField_a_of_type_Boolean;
      boolean bool1 = true;
      if (!bool2) {
        WSPlayerManager.a(this.this$0, true);
      }
      long l = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b)) {
        return;
      }
      if ((WSPlayerManager.a(this.this$0) == null) || (!WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b))) {
        bool1 = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", videoUrl:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b);
      WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e(bool1);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.a("", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b, 101, l, 0L, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.c, true, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Boolean))
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
        WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */