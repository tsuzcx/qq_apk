package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import bkwm;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ListView;
import pay;
import psf;
import psk;
import rtp;
import sdg;

public class VideoHandler$6
  implements Runnable
{
  public VideoHandler$6(psf parampsf, sdg paramsdg) {}
  
  public void run()
  {
    if (!psf.a(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.a == null) || (this.this$0.a.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((psf.a(this.this$0) == null) || (!psf.a(this.this$0).a()));
      int i = this.a.a;
      int j = psf.a(this.this$0).getHeaderViewsCount();
      psf.a(this.this$0).post(new VideoHandler.6.1(this, i + j));
    } while (!bkwm.a(pay.a()));
    QQToast.a(psf.a(this.this$0).getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.6
 * JD-Core Version:    0.7.0.1
 */