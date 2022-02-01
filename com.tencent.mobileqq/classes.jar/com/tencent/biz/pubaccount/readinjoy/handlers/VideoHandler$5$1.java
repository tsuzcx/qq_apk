package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder.VideoUIHandler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$5$1
  implements Runnable
{
  VideoHandler$5$1(VideoHandler.5 param5, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "scroll " + this.jdField_a_of_type_Int + " to top");
    }
    View localView = VideoHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$5.this$0).getChildAt(this.jdField_a_of_type_Int - VideoHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$5.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      VideoHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$5.this$0).removeMessages(1001);
      VideoHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$5.this$0).smoothScrollBy(localView.getBottom() - AIOUtils.a(175.0F, VideoHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$5.this$0).getResources()), 800);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$5.this$0.a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.5.1
 * JD-Core Version:    0.7.0.1
 */