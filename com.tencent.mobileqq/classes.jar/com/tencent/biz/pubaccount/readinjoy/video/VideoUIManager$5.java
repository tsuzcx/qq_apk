package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.MsgLayoutHelper;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;

class VideoUIManager$5
  implements Runnable
{
  VideoUIManager$5(VideoUIManager paramVideoUIManager, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    VideoUIManager.a(this.this$0).setVisibility(8);
    VideoUIManager.f(this.this$0);
    VideoUIManager.a(this.this$0).setVisibility(8);
    VideoUIManager.a(this.this$0).setVisibility(8);
    VideoUIManager.b(this.this$0).setVisibility(8);
    if (this.jdField_a_of_type_Int == 1) {
      VideoUIManager.g(this.this$0);
    }
    VideoUIManager.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_Int == 1) {
      PlayFeedbackHelper.a(VideoUIManager.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.5
 * JD-Core Version:    0.7.0.1
 */