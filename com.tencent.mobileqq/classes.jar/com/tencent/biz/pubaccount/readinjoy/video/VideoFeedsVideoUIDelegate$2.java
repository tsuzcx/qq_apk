package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import rvn;
import ryo;
import scs;
import shp;
import shq;

public class VideoFeedsVideoUIDelegate$2
  implements Runnable
{
  public VideoFeedsVideoUIDelegate$2(scs paramscs, String paramString, ryo paramryo) {}
  
  public void run()
  {
    QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoError playButton setVisibility GONE");
    scs.a(this.this$0, false);
    this.this$0.a.i.clearAnimation();
    this.this$0.a.i.setVisibility(8);
    this.this$0.a.c.setVisibility(0);
    this.this$0.a.a.a(1, this.jdField_a_of_type_JavaLangString, "点击重试");
    shq.a(this.jdField_a_of_type_Ryo.a.g, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.2
 * JD-Core Version:    0.7.0.1
 */