package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager.OnDataCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.widget.pull2refresh.BaseViewHolder;

class AbsWSVerticalPagePresenter$1
  implements WSWidgetDataManager.OnDataCallback
{
  AbsWSVerticalPagePresenter$1(AbsWSVerticalPagePresenter paramAbsWSVerticalPagePresenter, BaseViewHolder paramBaseViewHolder) {}
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    if (!(this.jdField_a_of_type_ComTencentWidgetPull2refreshBaseViewHolder instanceof WSVerticalVideoHolder)) {}
    IWSItemView localIWSItemView;
    do
    {
      return;
      localIWSItemView = ((WSVerticalVideoHolder)this.jdField_a_of_type_ComTencentWidgetPull2refreshBaseViewHolder).a;
    } while (!(localIWSItemView instanceof AbsWSVideoItemView));
    ((AbsWSVideoItemView)localIWSItemView).b(paramWSVerticalItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter.1
 * JD-Core Version:    0.7.0.1
 */