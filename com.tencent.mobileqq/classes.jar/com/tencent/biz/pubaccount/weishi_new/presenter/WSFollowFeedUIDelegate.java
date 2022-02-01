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
    WSFollowFeedHolder localWSFollowFeedHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if ((localWSFollowFeedHolder != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      localWSFollowFeedHolder.c();
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
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if ((localObject != null) && (paramBoolean1) && (paramBoolean2)) {
      ((WSFollowFeedHolder)localObject).a(8, 400);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:");
    ((StringBuilder)localObject).append(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d);
    ((StringBuilder)localObject).append("\nisPreOutputFirstFrame:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(", isFirstFrameDrawSuccess:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("\nmFollowPlayableHolder:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder);
    WSLog.e("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
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
      int i;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
      paramWSPlayerParam.a(i, 0);
    }
    a();
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if (localObject != null)
    {
      ((WSFollowFeedHolder)localObject).b(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(8, 400);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.c(true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFollowFeedUIDelegate.java][onVideoStart] title:");
      ((StringBuilder)localObject).append(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d);
      WSLog.a("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.d(true);
    }
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.b(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.d(false);
    }
  }
  
  public void g(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.c(false);
    }
    a();
  }
  
  public void h(WSPlayerParam paramWSPlayerParam) {}
  
  public void i(WSPlayerParam paramWSPlayerParam) {}
  
  public void j(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowFeedUIDelegate
 * JD-Core Version:    0.7.0.1
 */