package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class FrameworkHandler$8
  implements View.OnKeyListener
{
  FrameworkHandler$8(FrameworkHandler paramFrameworkHandler) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && ((paramInt == 25) || (paramInt == 24)))
    {
      paramView = new Intent();
      paramView.setAction("com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.ACTION_DOWN_AUDIO_BUTTON");
      if (this.a.a() != null) {
        this.a.a().sendBroadcast(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.8
 * JD-Core Version:    0.7.0.1
 */