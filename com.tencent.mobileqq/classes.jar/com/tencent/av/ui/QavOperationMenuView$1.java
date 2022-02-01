package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.BeautySeekView.ActionListener;
import com.tencent.av.utils.DataReport;

class QavOperationMenuView$1
  implements BeautySeekView.ActionListener
{
  QavOperationMenuView$1(QavOperationMenuView paramQavOperationMenuView) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        return;
      } while (this.a.a == null);
      this.a.a.a(paramString, paramInt2, false);
      return;
    }
    if (this.a.a != null) {
      this.a.a.a(paramString, paramInt2, true);
    }
    DataReport.c(2131373954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView.1
 * JD-Core Version:    0.7.0.1
 */