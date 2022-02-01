package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemWidgetAreaController
  extends AbsWsVerticalUIGroup
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private WSVerticalItemWidgetController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController;
  private final WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  
  public WSVerticalItemWidgetAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController = new WSVerticalItemWidgetController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController.a(paramWSVerticalItemData);
  }
  
  public void a() {}
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    b(paramWSVerticalItemData);
  }
  
  public int b()
  {
    return 2131560164;
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController.d();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetController.c(paramInt);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131381217));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAreaController
 * JD-Core Version:    0.7.0.1
 */