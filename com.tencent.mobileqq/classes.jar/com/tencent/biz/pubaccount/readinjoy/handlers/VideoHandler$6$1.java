package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import qdc;
import sxm;
import szd;

class VideoHandler$6$1
  implements Runnable
{
  VideoHandler$6$1(VideoHandler.6 param6, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "scroll " + this.jdField_a_of_type_Int + " to top");
    }
    View localView = qdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$6.this$0).getChildAt(this.jdField_a_of_type_Int - qdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$6.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      qdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$6.this$0).removeMessages(1001);
      qdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$6.this$0).smoothScrollBy(localView.getBottom() - AIOUtils.dp2px(175.0F, qdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$6.this$0).getResources()), 800);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$6.this$0.a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.6.1
 * JD-Core Version:    0.7.0.1
 */