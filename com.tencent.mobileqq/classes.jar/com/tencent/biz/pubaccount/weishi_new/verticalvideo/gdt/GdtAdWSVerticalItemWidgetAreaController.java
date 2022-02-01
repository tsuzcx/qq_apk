package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

public class GdtAdWSVerticalItemWidgetAreaController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private GdtAdWSVerticalItemWidgetButtonController jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  
  public GdtAdWSVerticalItemWidgetAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
  }
  
  private stSimpleMetaFeed a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      return localWSVerticalItemData.a();
    }
    return null;
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((a() != null) && (a().new_icon != null) && (a().new_icon.tag_type == 0))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController = new GdtAdWSVerticalItemWidgetButtonController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController.a(paramWSVerticalItemData);
    }
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSVerticalItemWidgetButtonController.c();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131381217));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemWidgetAreaController
 * JD-Core Version:    0.7.0.1
 */