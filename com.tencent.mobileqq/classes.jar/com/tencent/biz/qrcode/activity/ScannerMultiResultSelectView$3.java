package com.tencent.biz.qrcode.activity;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qbar.QBarResult;
import com.tencent.qphone.base.util.QLog;

class ScannerMultiResultSelectView$3
  implements Runnable
{
  ScannerMultiResultSelectView$3(ScannerMultiResultSelectView paramScannerMultiResultSelectView) {}
  
  public void run()
  {
    int j = ScannerMultiResultSelectView.a(this.this$0).getChildCount();
    if ((!ScannerMultiResultSelectView.a(this.this$0)) || (ScannerMultiResultSelectView.b(this.this$0) <= 0) || (ScannerMultiResultSelectView.c(this.this$0) <= 0) || (j <= 0)) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      View localView = ScannerMultiResultSelectView.a(this.this$0).getChildAt(i);
      if ((localView == null) || (localView.getTag() == null)) {}
      label236:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = localView.getTag();
        RectF localRectF = null;
        if ((localObject instanceof QBarResult)) {
          localRectF = ((QBarResult)localObject).a;
        }
        for (;;)
        {
          if (localRectF == null) {
            break label236;
          }
          localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
          Rect localRect = ScannerMultiResultSelectView.a(this.this$0, localRectF);
          ((FrameLayout.LayoutParams)localObject).topMargin = (localRect.centerY() - ViewUtils.a(27.0F));
          ((FrameLayout.LayoutParams)localObject).leftMargin = (localRect.centerX() - ViewUtils.a(27.0F));
          if (QLog.isColorLevel()) {
            QLog.i("ScannerMultiResultSelectView", 2, "mUpdatePointPositionRunnable location：" + localRectF + " locInView:" + localRect);
          }
          localView.setVisibility(0);
          break;
          if ((localObject instanceof QMiniResult)) {
            localRectF = ((QMiniResult)localObject).a;
          }
        }
      }
    }
    ScannerMultiResultSelectView.a(this.this$0).requestLayout();
    ScannerMultiResultSelectView.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView.3
 * JD-Core Version:    0.7.0.1
 */