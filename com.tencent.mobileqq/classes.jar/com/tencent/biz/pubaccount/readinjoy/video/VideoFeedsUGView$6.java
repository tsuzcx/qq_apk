package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

class VideoFeedsUGView$6
  implements Runnable
{
  VideoFeedsUGView$6(VideoFeedsUGView paramVideoFeedsUGView, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f)) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f.equals(localDownloadInfo.d)))
      {
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.this$0.b.setVisibility(8);
        if ((localDownloadInfo.f >= 0) && (localDownloadInfo.f <= 100))
        {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.k + localDownloadInfo.f + "%");
          this.this$0.jdField_a_of_type_Int = localDownloadInfo.f;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.6
 * JD-Core Version:    0.7.0.1
 */