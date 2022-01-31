package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import nsx;

class VideoFeedsUGView$9
  implements Runnable
{
  VideoFeedsUGView$9(VideoFeedsUGView paramVideoFeedsUGView, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Nsx == null) || (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Nsx.j)) || (!this.this$0.jdField_a_of_type_Nsx.j.equals(this.a))) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.this$0.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.9
 * JD-Core Version:    0.7.0.1
 */