package com.tencent.av.ui;

import com.tencent.mobileqq.profile.view.HScrollView.ScrollViewListener;

class QavOperationMenuView$2
  implements HScrollView.ScrollViewListener
{
  QavOperationMenuView$2(QavOperationMenuView paramQavOperationMenuView) {}
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if ((paramInt == 1) && (l - QavOperationMenuView.a(this.a) > 1000L)) {
      QavOperationMenuView.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView.2
 * JD-Core Version:    0.7.0.1
 */