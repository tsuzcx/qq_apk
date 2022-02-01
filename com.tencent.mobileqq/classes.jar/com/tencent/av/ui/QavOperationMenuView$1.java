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
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        if (this.a.h != null) {
          this.a.h.a(paramString, paramInt2, true);
        }
        DataReport.c(2131441199);
        return;
      }
      if (this.a.h != null) {
        this.a.h.a(paramString, paramInt2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView.1
 * JD-Core Version:    0.7.0.1
 */