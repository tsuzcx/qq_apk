package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyFastWebBottomSocialViewNew$4
  implements Runnable
{
  ReadInJoyFastWebBottomSocialViewNew$4(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew) {}
  
  public void run()
  {
    ReadInJoyFastWebBottomSocialViewNew.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 2, "reset mIsWaitingForFavoriteResult = false, not to block request too long.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew.4
 * JD-Core Version:    0.7.0.1
 */