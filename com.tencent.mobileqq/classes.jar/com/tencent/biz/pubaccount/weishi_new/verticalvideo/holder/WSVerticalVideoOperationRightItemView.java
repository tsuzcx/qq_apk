package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalVideoOperationRightItemView
  extends AbsWSVideoItemView
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private AbsWsUIGroup<WSVerticalItemData> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private WSVerticalItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
  private AbsWsUIGroup<WSVerticalItemData> b;
  private AbsWsUIGroup<WSVerticalItemData> c;
  
  public WSVerticalVideoOperationRightItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a() instanceof stSimpleMetaFeed)) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemBottomOperationController))) {
      ((WSVerticalItemBottomOperationController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).a(paramMotionEvent);
    }
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
    WSVerticalItemBottomCommentController localWSVerticalItemBottomCommentController = new WSVerticalItemBottomCommentController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemBottomCommentController.a(localViewStub);
    a(localWSVerticalItemBottomCommentController);
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
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381552);
    WSVerticalItemTagController localWSVerticalItemTagController = new WSVerticalItemTagController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemTagController.a(localViewStub);
    a(localWSVerticalItemTagController);
  }
  
  private void j()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381550);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemRightOperationController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
    a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
  }
  
  private void k()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381539);
    this.b = new WSVerticalItemAvatarAreaController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "vertical_layer_collection")) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "vertical_layer_collection_of_card")))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381540);
      this.c = new WSVerticalItemBottomCollectionController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
      this.c.a(localViewStub);
      a(this.c);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new WSVerticalVideoOperationRightItemView.1(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new WSVerticalVideoOperationRightItemView.2(this));
  }
  
  private void n()
  {
    if ((a() != null) && (a().poster != null) && (!WSFeedUtils.a(a().poster.followStatus))) {
      ((WSVerticalItemAvatarAreaController)this.b).b();
    }
  }
  
  private void o()
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
  
  public boolean a()
  {
    return true;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.d(paramInt + 1);
    }
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData = paramWSVerticalItemData;
    c(paramWSVerticalItemData);
  }
  
  public AbsWsUIGroup<WSVerticalItemData> c()
  {
    return this.c;
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
    if ((paramInt == 0) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemBottomOperationController))) {
      ((WSVerticalItemBottomOperationController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).f();
    }
    do
    {
      return;
      if ((paramInt == 1) && ((this.b instanceof WSVerticalItemAvatarAreaController)))
      {
        n();
        return;
      }
    } while ((paramInt != 2) || (!(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemBottomOperationController)));
    ((WSVerticalItemBottomOperationController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).g();
  }
  
  public void d()
  {
    super.d();
    f();
    g();
    j();
    h();
    i();
    k();
    e();
    l();
    m();
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381542);
    WSVerticalItemBottomFlexibleController localWSVerticalItemBottomFlexibleController = new WSVerticalItemBottomFlexibleController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemBottomFlexibleController.a(localViewStub);
    a(localWSVerticalItemBottomFlexibleController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView
 * JD-Core Version:    0.7.0.1
 */