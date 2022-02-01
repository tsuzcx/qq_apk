package com.tencent.biz.qqcircle.viewmodels;

import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;

class QCirclePublishButtonViewModel$3
  extends CountDownTimer
{
  QCirclePublishButtonViewModel$3(QCirclePublishButtonViewModel paramQCirclePublishButtonViewModel, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    QCirclePublishButtonViewModel.a(this.a, true);
    QCirclePublishButtonViewModel.b(this.a).postValue(QCirclePublishButtonViewModel.a(this.a));
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.3
 * JD-Core Version:    0.7.0.1
 */