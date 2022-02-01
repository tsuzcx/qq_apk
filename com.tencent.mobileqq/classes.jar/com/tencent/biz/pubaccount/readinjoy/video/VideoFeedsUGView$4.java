package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.downloadnew.DownloadInfo;
import omr;

class VideoFeedsUGView$4
  implements Runnable
{
  VideoFeedsUGView$4(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Omr != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Omr.f)) && (this.this$0.jdField_a_of_type_Omr.f.equals(this.a.d)))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.this$0.b.setVisibility(8);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_a_of_type_Omr.m);
      this.this$0.jdField_a_of_type_Int = this.a.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.4
 * JD-Core Version:    0.7.0.1
 */