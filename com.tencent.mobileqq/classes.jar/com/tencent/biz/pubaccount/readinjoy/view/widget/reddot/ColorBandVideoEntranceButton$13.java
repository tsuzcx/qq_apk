package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
import com.tencent.qphone.base.util.QLog;

class ColorBandVideoEntranceButton$13
  implements Runnable
{
  ColorBandVideoEntranceButton$13(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void run()
  {
    try
    {
      if (ColorBandVideoEntranceButton.a(this.this$0, ColorBandVideoEntranceButton.a(this.this$0)))
      {
        RecommendFeedsDiandianEntranceManager.EntranceIconInfo localEntranceIconInfo = (RecommendFeedsDiandianEntranceManager.EntranceIconInfo)ColorBandVideoEntranceButton.a(this.this$0);
        ColorBandVideoEntranceButton.a(this.this$0, localEntranceIconInfo);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorBandVideoEntranceButton", 1, "setNicknamePopupAttributes error : e = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton.13
 * JD-Core Version:    0.7.0.1
 */