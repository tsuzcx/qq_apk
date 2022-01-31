package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import qmi;
import qqo;
import qtk;
import qyy;
import qyz;

public class VideoFeedsVideoUIDelegate$2
  implements Runnable
{
  public VideoFeedsVideoUIDelegate$2(qtk paramqtk, String paramString, qqo paramqqo) {}
  
  public void run()
  {
    QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoError playButton setVisibility GONE");
    qtk.a(this.this$0, false);
    this.this$0.a.g.clearAnimation();
    this.this$0.a.g.setVisibility(8);
    this.this$0.a.c.setVisibility(0);
    this.this$0.a.a.a(1, this.jdField_a_of_type_JavaLangString, "点击重试");
    qyz.a(this.jdField_a_of_type_Qqo.a.g, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.2
 * JD-Core Version:    0.7.0.1
 */