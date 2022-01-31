package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import qls;
import qmm;
import qmr;

public class VideoFeedsAdapter$ShortVideoItemDelegate$8
  implements Runnable
{
  public VideoFeedsAdapter$ShortVideoItemDelegate$8(qmm paramqmm) {}
  
  public void run()
  {
    qmm.a(this.a).m.setVisibility(8);
    qmm.a(this.a).k.setVisibility(0);
    qmm.a(this.a).k.setImageResource(2130842516);
    RelativeLayout localRelativeLayout = (RelativeLayout)qls.a(this.a.a).getWindow().getDecorView().findViewById(2131363287);
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.8
 * JD-Core Version:    0.7.0.1
 */