package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCollectionController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView;

public class WSVerticalPlayerUIDelegate
  implements IWSPlayerUIDelegate
{
  private WSVerticalItemBottomCollectionController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomCollectionController;
  private WSVerticalItemVideoAreaController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController;
  private WSVerticalItemVideoProgressController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    }
    return null;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.h();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.a(paramString);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.a()))
    {
      if (paramLong2 != 0L) {
        break label65;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.a(0.0F);
    }
    for (;;)
    {
      if ((paramLong1 > 2000L) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomCollectionController != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomCollectionController.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomCollectionController.f();
      }
      return;
      label65:
      float f = (float)paramLong1 / (float)paramLong2;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.a(f);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.f();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.a(0.0F);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.a(8, 400);
    }
  }
  
  public void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder == null) {}
    do
    {
      do
      {
        return;
        if ((paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView))
        {
          Object localObject = (AbsWSVideoItemView)paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
          AbsWsUIGroup localAbsWsUIGroup = ((AbsWSVideoItemView)localObject).a();
          if ((localAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController = ((WSVerticalItemVideoAreaController)localAbsWsUIGroup);
          }
          localObject = ((AbsWSVideoItemView)localObject).b();
          if ((localObject instanceof WSVerticalItemVideoProgressController)) {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController = ((WSVerticalItemVideoProgressController)localObject);
          }
        }
      } while (!(paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof WSVerticalVideoOperationRightItemView));
      paramWSVerticalVideoHolder = ((WSVerticalVideoOperationRightItemView)paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).c();
    } while (!(paramWSVerticalVideoHolder instanceof WSVerticalItemBottomCollectionController));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomCollectionController = ((WSVerticalItemBottomCollectionController)paramWSVerticalVideoHolder);
  }
  
  public boolean a(WSPlayerParam paramWSPlayerParam)
  {
    return false;
  }
  
  public void b(WSPlayerParam paramWSPlayerParam) {}
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.a(8, 200);
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.a(8, 400);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.c(8);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.h();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.i();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.g();
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.c(0);
    }
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.c(8);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.i();
    }
  }
  
  public void g(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.h();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.a(0, 100);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.c(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.g();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.a(0.0F);
    }
  }
  
  public void h(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.g();
      paramWSPlayerParam = a();
      if ((paramWSPlayerParam != null) && (paramWSPlayerParam.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.c(8);
      }
    }
  }
  
  public void i(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController.g();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.h();
      paramWSPlayerParam = a();
      if ((paramWSPlayerParam != null) && (paramWSPlayerParam.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.c(0);
      }
    }
  }
  
  public void j(WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoAreaController.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPlayerUIDelegate
 * JD-Core Version:    0.7.0.1
 */