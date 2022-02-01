package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalVideoItemView
  extends AbsWSVideoItemView
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private AbsWsUIGroup<WSVerticalItemData> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private WSVerticalItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
  private AbsWsUIGroup<WSVerticalItemData> b;
  
  public WSVerticalVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a() instanceof stSimpleMetaFeed)) && ((this.b instanceof WSVerticalItemBottomOperationController))) {
      ((WSVerticalItemBottomOperationController)this.b).a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381553);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemTopController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
    a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381541);
    WSVerticalItemBottomContentController localWSVerticalItemBottomContentController = new WSVerticalItemBottomContentController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemBottomContentController.a(localViewStub);
    a(localWSVerticalItemBottomContentController);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381543);
    this.b = new WSVerticalItemBottomOperationController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381556);
    WSVerticalItemWidgetAreaController localWSVerticalItemWidgetAreaController = new WSVerticalItemWidgetAreaController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemWidgetAreaController.a(localViewStub);
    a(localWSVerticalItemWidgetAreaController);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new WSVerticalVideoItemView.1(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new WSVerticalVideoItemView.2(this));
  }
  
  private void j()
  {
    if ((a() instanceof WSVerticalItemVideoAreaController)) {
      ((WSVerticalItemVideoAreaController)a()).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData = paramWSVerticalItemData;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a();
      WSLikeAnimationManger.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData = paramWSVerticalItemData;
    c(paramWSVerticalItemData);
  }
  
  public void c()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localWSShareParam.jdField_a_of_type_Int = 2;
    localWSShareParam.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localWSShareParam.jdField_a_of_type_JavaLangString = WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localWSShareParam.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localWSShareParam.c = "more_operations";
    localWSShareParam.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    WeishiShareUtil.a(this.jdField_a_of_type_AndroidContentContext, localWSShareParam);
    WSVerticalBeaconReport.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(this.b instanceof WSVerticalItemBottomOperationController));
        ((WSVerticalItemBottomOperationController)this.b).f();
        return;
      } while (!(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemTopController));
      ((WSVerticalItemTopController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).b();
      return;
    } while (!(this.b instanceof WSVerticalItemBottomOperationController));
    ((WSVerticalItemBottomOperationController)this.b).g();
  }
  
  public void d()
  {
    super.d();
    e();
    f();
    g();
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoItemView
 * JD-Core Version:    0.7.0.1
 */