package com.tencent.mobileqq.activity.qwallet;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;

class RedPacketEmojiFragment$2
  extends URLDrawableHelper.Adapter
{
  RedPacketEmojiFragment$2(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.a.b();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.2
 * JD-Core Version:    0.7.0.1
 */