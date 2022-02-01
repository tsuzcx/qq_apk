package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import spk;
import sqd;
import suf;
import sug;

public class VideoUIManager$5
  implements Runnable
{
  public VideoUIManager$5(sqd paramsqd, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    sqd.a(this.this$0).setVisibility(8);
    sqd.f(this.this$0);
    sqd.a(this.this$0).setVisibility(8);
    sqd.a(this.this$0).setVisibility(8);
    sqd.b(this.this$0).setVisibility(8);
    if (this.jdField_a_of_type_Int == 1) {
      sqd.g(this.this$0);
    }
    sqd.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_Int == 1) {
      sug.a(sqd.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.5
 * JD-Core Version:    0.7.0.1
 */