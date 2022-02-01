package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.activity.qwallet.widget.ksong.KSHelper.KLAdapter;
import com.tencent.mobileqq.widget.AnimationView;

class RedPacketKSongFragment$10$1$1
  extends KSHelper.KLAdapter
{
  RedPacketKSongFragment$10$1$1(RedPacketKSongFragment.10.1 param1) {}
  
  public void complete() {}
  
  public void ready(boolean paramBoolean)
  {
    if (!this.a.a.a.c())
    {
      if (paramBoolean) {
        this.a.a.a.a.post(new RedPacketKSongFragment.10.1.1.1(this));
      }
    }
    else {
      return;
    }
    this.a.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10.1.1
 * JD-Core Version:    0.7.0.1
 */