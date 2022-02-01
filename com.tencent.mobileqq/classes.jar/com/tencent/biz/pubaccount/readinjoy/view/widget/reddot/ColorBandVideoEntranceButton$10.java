package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class ColorBandVideoEntranceButton$10
  extends ReadInJoyObserver
{
  ColorBandVideoEntranceButton$10(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    this.a.setDataSource(paramIEntranceButtonDataSource);
    this.a.a(ColorBandVideoEntranceButton.a(this.a));
    QLog.d("ColorBandVideoEntranceButton", 1, "onHandle0x6cfResp reddot,data=" + paramIEntranceButtonDataSource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton.10
 * JD-Core Version:    0.7.0.1
 */