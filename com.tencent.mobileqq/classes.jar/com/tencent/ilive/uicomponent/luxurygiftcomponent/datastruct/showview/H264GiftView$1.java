package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.widget.PopupWindow;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilivesdk.playview.view.VideoPLayListener;

class H264GiftView$1
  implements VideoPLayListener
{
  H264GiftView$1(H264GiftView paramH264GiftView) {}
  
  public void onEnd()
  {
    if (H264GiftView.access$100(this.this$0) == null) {}
    do
    {
      return;
      H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "PlayView    end", new Object[0]);
      this.this$0.mLottieView.setAnimState(false);
      this.this$0.mLottieView.cancelAnimation();
      this.this$0.mLottieView.setVisibility(8);
      this.this$0.mLottieView.onH264End();
      H264GiftView.access$302(this.this$0, false);
      H264GiftView.access$400(this.this$0).dismiss();
      if (H264GiftView.access$000(this.this$0) != null) {
        H264GiftView.access$000(this.this$0).onEnd();
      }
    } while (H264GiftView.access$500(this.this$0) == null);
    H264GiftView.access$500(this.this$0).animationEnd();
  }
  
  public void onError(int paramInt)
  {
    if (H264GiftView.access$100(this.this$0) == null) {}
    do
    {
      do
      {
        return;
        H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "PlayView error code=" + paramInt, new Object[0]);
      } while ((H264GiftView.access$700(this.this$0) != null) && ((paramInt == -10) || (paramInt == -11) || (paramInt == -12)));
      H264GiftView.access$302(this.this$0, false);
      if (H264GiftView.access$000(this.this$0) != null) {
        H264GiftView.access$000(this.this$0).onError(paramInt);
      }
    } while (H264GiftView.access$500(this.this$0) == null);
    H264GiftView.access$500(this.this$0).animationEnd();
  }
  
  public void onPlayAtTime(long paramLong)
  {
    if ((H264GiftView.access$000(this.this$0) != null) && (H264GiftView.access$600(this.this$0))) {
      H264GiftView.access$000(this.this$0).onPlayAtTime(paramLong);
    }
    this.this$0.mLottieView.onPlayAtTime(paramLong, H264GiftView.access$600(this.this$0));
  }
  
  public void onStart()
  {
    if (H264GiftView.access$100(this.this$0) == null) {
      return;
    }
    H264GiftView.access$200(this.this$0);
    H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "PlayView onStart  t=" + System.currentTimeMillis(), new Object[0]);
    H264GiftView.access$302(this.this$0, true);
    if (H264GiftView.access$000(this.this$0) != null) {
      H264GiftView.access$000(this.this$0).onStart();
    }
    H264GiftView.access$100(this.this$0).getLogger().e("H264GiftShowView|GiftAnimation", "before change visible = " + this.this$0.mLottieView.getVisibility(), new Object[0]);
    this.this$0.postDelayed(this.this$0.runnable, 100L);
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    if (H264GiftView.access$000(this.this$0) != null) {
      H264GiftView.access$000(this.this$0).onVideoSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView.1
 * JD-Core Version:    0.7.0.1
 */