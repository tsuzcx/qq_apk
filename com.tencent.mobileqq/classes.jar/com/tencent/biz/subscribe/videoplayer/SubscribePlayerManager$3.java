package com.tencent.biz.subscribe.videoplayer;

import android.widget.TextView;
import com.tencent.biz.subscribe.framework.BaseVideoViewListenerSets;
import com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.AutoVideoMsgViewHolder;
import java.util.Map;

class SubscribePlayerManager$3
  extends BaseVideoViewListenerSets
{
  SubscribePlayerManager$3(SubscribePlayerManager paramSubscribePlayerManager, AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)SubscribePlayerManager.b(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager).get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder.b));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder.a.setText((CharSequence)SubscribePlayerManager.c(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager).get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder.b)));
      return;
    }
    SubscribePlayerManager.b(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager).put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder.b), Integer.valueOf(paramInt2));
    SubscribePlayerManager.c(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager).put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder.b), paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.3
 * JD-Core Version:    0.7.0.1
 */