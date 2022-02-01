package com.tencent.biz.pubaccount.weishi_new.main;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSMainProfilePresenter
  extends WSMainVerticalPresenter
{
  public WSMainProfilePresenter(WSMainContract.View paramView)
  {
    super(paramView);
  }
  
  protected void setCanScrollHorizontally(WSMainContract.View paramView, WSVerticalItemData paramWSVerticalItemData)
  {
    paramView.h(TextUtils.equals(this.mPersonId, paramWSVerticalItemData.b().poster.id) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainProfilePresenter
 * JD-Core Version:    0.7.0.1
 */