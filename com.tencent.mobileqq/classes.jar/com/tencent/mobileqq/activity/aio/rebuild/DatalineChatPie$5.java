package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

class DatalineChatPie$5
  implements View.OnTouchListener
{
  DatalineChatPie$5(DatalineChatPie paramDatalineChatPie, AsyncImageView paramAsyncImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.b.f != null)
    {
      if (this.b.f.isFinishing()) {
        return false;
      }
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 0))
      {
        int i;
        if (paramMotionEvent.getAction() == 1) {
          i = 255;
        } else {
          i = 127;
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.a.setImageAlpha(i);
          return false;
        }
        this.a.setAlpha(i);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.5
 * JD-Core Version:    0.7.0.1
 */