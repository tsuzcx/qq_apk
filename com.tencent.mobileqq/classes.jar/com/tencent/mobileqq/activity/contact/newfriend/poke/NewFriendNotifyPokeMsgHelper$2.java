package com.tencent.mobileqq.activity.contact.newfriend.poke;

import android.widget.ImageView;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.LottieDrawable;

final class NewFriendNotifyPokeMsgHelper$2
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  NewFriendNotifyPokeMsgHelper$2(ImageView paramImageView1, Object paramObject, QQAppInterface paramQQAppInterface, ImageView paramImageView2) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      paramLottieDrawable.addAnimatorListener(new NewFriendNotifyPokeMsgHelper.2.1(this));
      if (!paramLottieDrawable.isAnimating())
      {
        this.b.setImageDrawable(paramLottieDrawable);
        paramLottieDrawable.playAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */