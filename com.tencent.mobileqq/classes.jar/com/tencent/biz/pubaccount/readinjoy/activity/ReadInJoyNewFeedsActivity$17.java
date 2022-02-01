package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyNewFeedsActivity$17
  extends ReadInJoyObserver
{
  ReadInJoyNewFeedsActivity$17(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onComponentLastReadShow");
    }
    this.a.runOnUiThread(new ReadInJoyNewFeedsActivity.17.1(this));
  }
  
  public void b(int paramInt)
  {
    this.a.f(paramInt);
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.17
 * JD-Core Version:    0.7.0.1
 */