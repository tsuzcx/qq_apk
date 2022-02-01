package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSFollowFeedUIDelegate
  implements IWSPlayerUIDelegate
{
  private WSFollowFeedHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.c();
    }
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    if ((paramWSPlayableHolder instanceof WSFollowFeedHolder)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder = ((WSFollowFeedHolder)paramWSPlayableHolder);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, long paramLong1, long paramLong2)
  {
    if (paramLong1 > 2000L) {
      a();
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(8, 400);
    }
    WSLog.e("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d + "\nisPreOutputFirstFrame:" + paramBoolean1 + ", isFirstFrameDrawSuccess:" + paramBoolean2 + "\nmFollowPlayableHolder:" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder);
  }
  
  public boolean a(WSPlayerParam paramWSPlayerParam)
  {
    return false;
  }
  
  public void b(WSPlayerParam paramWSPlayerParam) {}
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null) && (paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
    {
      boolean bool = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.b(bool);
      paramWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
      if (!bool) {
        break label57;
      }
    }
    label57:
    for (int i = 8;; i = 0)
    {
      paramWSPlayerParam.a(i, 0);
      a();
      return;
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.b(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(8, 400);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.c(true);
      WSLog.a("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d);
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.d(true);
    }
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.b(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.d(false);
    }
  }
  
  public void g(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.c(false);
    }
    a();
  }
  
  public void h(WSPlayerParam paramWSPlayerParam) {}
  
  public void i(WSPlayerParam paramWSPlayerParam) {}
  
  public void j(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowFeedUIDelegate
 * JD-Core Version:    0.7.0.1
 */