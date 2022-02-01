package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.widget.PopupWindow;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface;
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
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mLottieView.getParent()=" + this.this$0.mLottieView.getParent(), new Object[0]);
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mLottieView.isShown()=" + this.this$0.mLottieView.isShown(), new Object[0]);
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mPopupWindow.isShowing()=" + H264GiftView.access$400(this.this$0).isShowing(), new Object[0]);
      H264GiftView.access$400(this.this$0).showAtLocation(this.this$0, 17, 0, 0);
      if (!this.this$0.mLottieView.isShown())
      {
        H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "!mLottieView.isShown()", new Object[0]);
        this.this$0.mLottieView.setVisibility(0);
        H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "mLottieView.isShown() = " + this.this$0.mLottieView.isShown(), new Object[0]);
      }
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mPopupWindow.isShowing()=" + H264GiftView.access$400(this.this$0).isShowing(), new Object[0]);
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mLottieView.getVisibility()=" + this.this$0.mLottieView.getVisibility(), new Object[0]);
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mLottieView.isShown()=" + this.this$0.mLottieView.isShown(), new Object[0]);
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", " mLottieView.getParent()=" + this.this$0.mLottieView.getParent(), new Object[0]);
      return;
    }
    H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "H264GiftView.this.getWindowToken() == null", new Object[0]);
    this.this$0.postDelayed(this, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView.2
 * JD-Core Version:    0.7.0.1
 */