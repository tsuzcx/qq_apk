package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

public class NewGdtAdWSVerticalVideoItemView
  extends GdtAdWSVerticalVideoItemView
{
  private AbsWsUIGroup<WSVerticalItemData> a;
  
  public NewGdtAdWSVerticalVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381542);
    localViewStub.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new GdtAdWSVerticalItemBottomUserController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
    a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.d();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.NewGdtAdWSVerticalVideoItemView
 * JD-Core Version:    0.7.0.1
 */