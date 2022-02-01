package com.tencent.biz.qqcircle.flutter;

import android.view.View;
import com.tencent.biz.qqcircle.flutter.animation.PushCountImageRenderer.LoadCountBitmapsListener;
import com.tencent.qphone.base.util.QLog;

class QQCircleMethodMine$1$1
  implements PushCountImageRenderer.LoadCountBitmapsListener
{
  QQCircleMethodMine$1$1(QQCircleMethodMine.1 param1) {}
  
  public void a() {}
  
  public void b()
  {
    this.a.a.post(new QQCircleMethodMine.1.1.1(this));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQCircleMethodMine", 1, "[loadCountBitmapsAsync] loadFail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.1.1
 * JD-Core Version:    0.7.0.1
 */