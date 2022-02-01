package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.ma.e.d;
import com.tencent.luggage.wxa.qt.c;
import com.tencent.luggage.wxa.qz.o;

class VideoPlayerSeekBar$1
  implements View.OnTouchListener
{
  VideoPlayerSeekBar$1(VideoPlayerSeekBar paramVideoPlayerSeekBar) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      o.d("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
      paramView = this.a;
      paramView.k = false;
      paramView.l = paramMotionEvent.getX();
      if (this.a.a != null)
      {
        this.a.a.a();
        return true;
      }
    }
    else
    {
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)this.a.e.getLayoutParams();
        i = VideoPlayerSeekBar.a(this.a, paramView.leftMargin + (int)(f - this.a.l), VideoPlayerSeekBar.a(this.a));
        paramView.leftMargin = i;
        this.a.e.setLayoutParams(paramView);
        int j = VideoPlayerSeekBar.a(this.a).a;
        if (this.a.i > 0)
        {
          paramView = (FrameLayout.LayoutParams)this.a.c.getLayoutParams();
          paramView.width = i;
          this.a.c.setLayoutParams(paramView);
        }
        paramView = this.a.g;
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append(this.a.c(j / 60));
        paramMotionEvent.append(":");
        paramMotionEvent.append(this.a.c(j % 60));
        paramView.setText(paramMotionEvent.toString());
        this.a.k = true;
        return true;
      }
      int i = this.a.j;
      if (this.a.k)
      {
        paramView = this.a;
        i = VideoPlayerSeekBar.a(paramView).a;
        paramView.j = i;
      }
      if (this.a.a != null)
      {
        paramView = new StringBuilder();
        paramView.append("current time : ");
        paramView.append(i);
        o.d("MicroMsg.Video.VideoPlayerSeekBar", paramView.toString());
        this.a.a.a(i);
      }
      this.a.k = false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar.1
 * JD-Core Version:    0.7.0.1
 */