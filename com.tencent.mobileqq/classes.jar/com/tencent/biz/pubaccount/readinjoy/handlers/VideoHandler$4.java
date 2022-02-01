package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$4
  implements Runnable
{
  VideoHandler$4(VideoHandler paramVideoHandler, VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam2) {}
  
  public void run()
  {
    int i = VideoHandler.a(this.this$0).getHeaderViewsCount() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a + 1;
    if (QLog.isColorLevel()) {
      QLog.i("VideoHandler", 2, "setSelectionFromTop selectIndex:" + i);
    }
    VideoHandler.a(this.this$0).setSelectionFromTop(i, AIOUtils.a(175.0F, VideoHandler.a(this.this$0).getResources()));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == 7)
    {
      this.this$0.a(this.b);
      return;
    }
    this.this$0.a = null;
    this.this$0.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.4
 * JD-Core Version:    0.7.0.1
 */