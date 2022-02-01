package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilivesdk.playview.view.PlayView;

class H264GiftView$5$1
  implements Runnable
{
  H264GiftView$5$1(H264GiftView.5 param5) {}
  
  public void run()
  {
    H264GiftView.access$800(this.this$1.this$0).playFile(this.this$1.val$giftInfo.mediaFilePath);
    if (H264GiftView.access$500(this.this$1.this$0) != null) {
      H264GiftView.access$500(this.this$1.this$0).animViewReady();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView.5.1
 * JD-Core Version:    0.7.0.1
 */