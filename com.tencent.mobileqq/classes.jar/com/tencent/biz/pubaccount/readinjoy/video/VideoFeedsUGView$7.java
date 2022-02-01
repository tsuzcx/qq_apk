package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.downloadnew.DownloadInfo;
import ocb;

class VideoFeedsUGView$7
  implements Runnable
{
  VideoFeedsUGView$7(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Ocb != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Ocb.f)) && (this.this$0.jdField_a_of_type_Ocb.f.equals(this.a.d)))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.this$0.b.setVisibility(8);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_a_of_type_Ocb.l);
      this.this$0.jdField_a_of_type_Int = this.a.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.7
 * JD-Core Version:    0.7.0.1
 */