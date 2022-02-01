package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import rwc;
import rwu;
import sar;
import sas;

public class VideoUIManager$5
  implements Runnable
{
  public VideoUIManager$5(rwu paramrwu, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    rwu.a(this.this$0).setVisibility(8);
    rwu.f(this.this$0);
    rwu.a(this.this$0).setVisibility(8);
    rwu.a(this.this$0).setVisibility(8);
    rwu.b(this.this$0).setVisibility(8);
    if (this.jdField_a_of_type_Int == 1) {
      rwu.g(this.this$0);
    }
    rwu.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_Int == 1) {
      sas.a(rwu.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.5
 * JD-Core Version:    0.7.0.1
 */