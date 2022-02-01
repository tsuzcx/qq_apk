package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
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
  private AbsWsUIGroup<WSVerticalItemData> d;
  private AbsWsUIGroup<WSVerticalItemData> e;
  private AbsWsUIGroup<WSVerticalItemData> f;
  private AbsWsUIGroup<WSVerticalItemData> g;
  
  public WSVerticalVideoOperationRightItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
      if ((localObject instanceof WSVerticalItemBottomOperationController)) {
        ((WSVerticalItemBottomOperationController)localObject).a(paramMotionEvent);
      }
    }
  }
  
  private void f()
  {
    if (!((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).c()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380789);
    WSVerticalItemTopTextController localWSVerticalItemTopTextController = new WSVerticalItemTopTextController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemTopTextController.a(localViewStub);
    a(localWSVerticalItemTopTextController);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380776);
    this.d = new WSVerticalItemBottomContentController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.d.a(localViewStub);
    a(this.d);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380778);
    this.f = new WSVerticalItemBottomCommentController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.f.a(localViewStub);
    a(this.f);
  }
  
  private void i()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380792);
    this.g = new WSVerticalItemWidgetAreaController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.g.a(localViewStub);
    a(this.g);
  }
  
  private void j()
  {
    Object localObject = this.f.a();
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362260);
    localObject = new WSVerticalItemWidgetAdvBigCardController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder, (View)localObject);
    ((WSVerticalItemWidgetAdvBigCardController)localObject).a(localViewStub);
    ((WSVerticalItemWidgetAdvBigCardController)localObject).a(new WSVerticalVideoOperationRightItemView.1(this));
    a((AbsWsUIGroup)localObject);
  }
  
  private void k()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380788);
    WSVerticalItemTagController localWSVerticalItemTagController = new WSVerticalItemTagController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    localWSVerticalItemTagController.a(localViewStub);
    a(localWSVerticalItemTagController);
  }
  
  private void l()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380786);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemRightOperationController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
    a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
  }
  
  private void m()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380774);
    this.b = new WSVerticalItemAvatarAreaController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void n()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380775);
    this.c = WSVerticalPageBottomBarFactory.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.c.a(localViewStub);
    a(this.c);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new WSVerticalVideoOperationRightItemView.2(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new WSVerticalVideoOperationRightItemView.3(this));
  }
  
  private void p()
  {
    if ((a() != null) && (a().poster != null) && (!WSFeedUtils.a(a().poster.followStatus))) {
      ((WSVerticalItemAvatarAreaController)this.b).b();
    }
  }
  
  private void q()
  {
    if ((a() instanceof WSVerticalItemVideoAreaController)) {
      ((WSVerticalItemVideoAreaController)a()).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    WSVerticalItemData localWSVerticalItemData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
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
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalItemRightOperationController)) {
      ((WSVerticalItemRightOperationController)localAbsWsUIGroup).b(paramBoolean);
    }
    localAbsWsUIGroup = this.b;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i);
    }
    localAbsWsUIGroup = this.d;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i);
    }
    localAbsWsUIGroup = this.e;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    super.b();
    g();
    h();
    l();
    i();
    k();
    m();
    e();
    n();
    f();
    j();
    o();
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData = paramWSVerticalItemData;
    c(paramWSVerticalItemData);
  }
  
  public void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    AbsWsUIGroup localAbsWsUIGroup = this.d;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i);
    }
    localAbsWsUIGroup = this.e;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i);
    }
    localAbsWsUIGroup = this.g;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i);
    }
  }
  
  public AbsWsUIGroup<WSVerticalItemData> c()
  {
    return this.c;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a();
      WSLikeAnimationManger.a().a(((stSimpleMetaFeed)localObject).id);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalItemRightOperationController)) {
      ((WSVerticalItemRightOperationController)localAbsWsUIGroup).a(paramBoolean);
    }
  }
  
  public void d()
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
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void d(int paramInt)
  {
    AbsWsUIGroup localAbsWsUIGroup;
    if (paramInt == 0)
    {
      localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
      if ((localAbsWsUIGroup instanceof WSVerticalItemBottomOperationController))
      {
        ((WSVerticalItemBottomOperationController)localAbsWsUIGroup).g();
        return;
      }
    }
    if ((paramInt == 1) && ((this.b instanceof WSVerticalItemAvatarAreaController)))
    {
      p();
      return;
    }
    if (paramInt == 2)
    {
      localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
      if ((localAbsWsUIGroup instanceof WSVerticalItemBottomOperationController))
      {
        ((WSVerticalItemBottomOperationController)localAbsWsUIGroup).h();
        return;
      }
    }
    if (paramInt == 3) {
      ((WSVerticalItemBottomOperationController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).f();
    }
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380777);
    this.e = new WSVerticalItemBottomFlexibleController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.e.a(localViewStub);
    a(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView
 * JD-Core Version:    0.7.0.1
 */