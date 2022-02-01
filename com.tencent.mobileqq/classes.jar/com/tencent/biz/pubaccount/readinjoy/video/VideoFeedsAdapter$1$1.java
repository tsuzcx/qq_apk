package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import rwy;
import rwz;

public class VideoFeedsAdapter$1$1
  implements Runnable
{
  public VideoFeedsAdapter$1$1(rwz paramrwz, ViewTreeObserver.OnDrawListener paramOnDrawListener) {}
  
  public void run()
  {
    rwy.a(this.jdField_a_of_type_Rwz.a).getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnDrawListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */