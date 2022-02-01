package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.downloadnew.DownloadInfo;
import odl;

class VideoFeedsUGView$5
  implements Runnable
{
  VideoFeedsUGView$5(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Odl != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Odl.f)) && (this.this$0.jdField_a_of_type_Odl.f.equals(this.a.d)))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.this$0.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.5
 * JD-Core Version:    0.7.0.1
 */