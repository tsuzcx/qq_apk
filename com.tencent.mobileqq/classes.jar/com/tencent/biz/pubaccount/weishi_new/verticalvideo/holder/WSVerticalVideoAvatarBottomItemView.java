package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalVideoAvatarBottomItemView
  extends WSVerticalVideoOperationRightItemView
{
  private AbsWsUIGroup<WSVerticalItemData> a;
  
  public WSVerticalVideoAvatarBottomItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void f()
  {
    if ((a() != null) && (a().poster != null) && (!WSFeedUtils.a(a().poster.followStatus))) {
      ((WSVerticalItemBottomAvatarController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).a(a().poster);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((stSimpleMetaFeed)localObject).poster;
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    ((WSVerticalItemBottomAvatarController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).b((stSimpleMetaPerson)localObject);
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemBottomAvatarController)))
    {
      f();
      return;
    }
    super.c(paramInt);
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381542);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemBottomAvatarController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
    a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoAvatarBottomItemView
 * JD-Core Version:    0.7.0.1
 */