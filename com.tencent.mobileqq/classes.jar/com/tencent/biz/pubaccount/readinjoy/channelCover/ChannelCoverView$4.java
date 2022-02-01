package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ChannelCoverView$4
  implements View.OnTouchListener
{
  ChannelCoverView$4(ChannelCoverView paramChannelCoverView, Context paramContext) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent() == null)) {
        break label67;
      }
    }
    label67:
    for (int i = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("channel_from", -1);; i = 0)
    {
      ChannelCoverView.a("0X8007BE7", null, null, null, null, i);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.4
 * JD-Core Version:    0.7.0.1
 */