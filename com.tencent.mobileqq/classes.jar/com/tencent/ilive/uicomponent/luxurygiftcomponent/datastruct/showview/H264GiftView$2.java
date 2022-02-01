package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.widget.PopupWindow;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.lottie.LottieViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

class H264GiftView$2
  implements Runnable
{
  H264GiftView$2(H264GiftView paramH264GiftView) {}
  
  public void run()
  {
    if (this.this$0.getWindowToken() != null)
    {
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "showAtLocation ", new Object[0]);
      LogInterface localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mLottieView.getParent()=");
      localStringBuilder.append(this.this$0.mLottieView.getParent());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mLottieView.isShown()=");
      localStringBuilder.append(this.this$0.mLottieView.isShown());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mPopupWindow.isShowing()=");
      localStringBuilder.append(H264GiftView.access$400(this.this$0).isShowing());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      H264GiftView.access$400(this.this$0).showAtLocation(this.this$0, 17, 0, 0);
      if (!this.this$0.mLottieView.isShown())
      {
        H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "!mLottieView.isShown()", new Object[0]);
        this.this$0.mLottieView.setVisibility(0);
        localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mLottieView.isShown() = ");
        localStringBuilder.append(this.this$0.mLottieView.isShown());
        localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      }
      localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mPopupWindow.isShowing()=");
      localStringBuilder.append(H264GiftView.access$400(this.this$0).isShowing());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mLottieView.getVisibility()=");
      localStringBuilder.append(this.this$0.mLottieView.getVisibility());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mLottieView.isShown()=");
      localStringBuilder.append(this.this$0.mLottieView.isShown());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      localLogInterface = H264GiftView.access$100(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mLottieView.getParent()=");
      localStringBuilder.append(this.this$0.mLottieView.getParent());
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      return;
    }
    H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "H264GiftView.this.getWindowToken() == null", new Object[0]);
    this.this$0.postDelayed(this, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView.2
 * JD-Core Version:    0.7.0.1
 */