package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalVideoOperationCenterBottomItemView
  extends AbsWSVideoItemView
{
  private int jdField_a_of_type_Int;
  private AbsWsUIGroup<WSVerticalItemData> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private WSVerticalItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
  private AbsWsUIGroup<WSVerticalItemData> b;
  
  public WSVerticalVideoOperationCenterBottomItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381553);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemTopController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381544);
    this.b = new WSVerticalItemCenterBottomController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new WSVerticalVideoOperationCenterBottomItemView.1(this));
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.d();
    }
    if (this.b != null) {
      this.b.d();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.b(paramInt);
    }
    if (this.b != null) {
      this.b.b(paramInt);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData = paramWSVerticalItemData;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(paramWSVerticalItemData);
    }
    if (this.b != null) {
      this.b.a(paramWSVerticalItemData);
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void c()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localWSShareParam.jdField_a_of_type_Int = 3;
    localWSShareParam.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localWSShareParam.jdField_a_of_type_JavaLangString = WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localWSShareParam.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localWSShareParam.c = "more_operations";
    localWSShareParam.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    WeishiShareUtil.b(this.jdField_a_of_type_AndroidContentContext, localWSShareParam);
    WSVerticalBeaconReport.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "aio_home_page"))) {
      e();
    }
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationCenterBottomItemView
 * JD-Core Version:    0.7.0.1
 */