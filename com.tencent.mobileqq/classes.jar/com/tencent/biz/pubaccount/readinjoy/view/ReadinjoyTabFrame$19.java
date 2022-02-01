package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$19
  extends ReadInJoyObserver
{
  ReadinjoyTabFrame$19(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "onLocationChanged changeType = " + paramInt);
    }
    ReadinjoyTabFrame.a(this.a, paramInt, paramPositionData);
  }
  
  public void m()
  {
    super.m();
    if (ReadinjoyTabFrame.a(this.a) != null) {
      ReadinjoyTabFrame.a(this.a).post(new ReadinjoyTabFrame.19.1(this));
    }
  }
  
  public void n()
  {
    QLog.d("ReadInJoyTabFrame", 2, "onHideChannel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.19
 * JD-Core Version:    0.7.0.1
 */