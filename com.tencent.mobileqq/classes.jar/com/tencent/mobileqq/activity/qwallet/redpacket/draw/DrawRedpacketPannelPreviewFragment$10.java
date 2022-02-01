package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class DrawRedpacketPannelPreviewFragment$10
  implements OnCompositionLoadedListener
{
  DrawRedpacketPannelPreviewFragment$10(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    if (DrawRedpacketPannelPreviewFragment.e(this.a) != null)
    {
      DrawRedpacketPannelPreviewFragment.e(this.a).setImageDrawable(localLottieDrawable);
      QWalletSetting.a(this.a.getActivity().app.getCurrentAccountUin(), "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.10
 * JD-Core Version:    0.7.0.1
 */