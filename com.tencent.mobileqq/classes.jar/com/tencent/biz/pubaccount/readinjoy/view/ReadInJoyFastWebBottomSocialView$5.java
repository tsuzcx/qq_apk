package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyFastWebBottomSocialView$5
  implements Runnable
{
  ReadInJoyFastWebBottomSocialView$5(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void run()
  {
    ReadInJoyFastWebBottomSocialView.b(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "reset mIsWaitingForFavoriteResult = false, not to block request too long.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView.5
 * JD-Core Version:    0.7.0.1
 */