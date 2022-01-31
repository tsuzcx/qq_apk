package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import qtv;
import qva;
import qyv;
import qyw;

public class VideoUIManager$4
  implements Runnable
{
  public VideoUIManager$4(qva paramqva, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    qva.a(this.this$0).setVisibility(8);
    qva.f(this.this$0);
    qva.a(this.this$0).setVisibility(8);
    qva.a(this.this$0).setVisibility(8);
    qva.b(this.this$0).setVisibility(8);
    if (this.jdField_a_of_type_Int == 1) {
      qva.g(this.this$0);
    }
    qva.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_Int == 1) {
      qyw.a(qva.a(this.this$0).a(), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.4
 * JD-Core Version:    0.7.0.1
 */