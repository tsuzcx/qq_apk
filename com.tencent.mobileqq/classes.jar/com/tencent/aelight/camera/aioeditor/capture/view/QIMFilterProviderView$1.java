package com.tencent.aelight.camera.aioeditor.capture.view;

import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;

class QIMFilterProviderView$1
  implements Runnable
{
  QIMFilterProviderView$1(QIMFilterProviderView paramQIMFilterProviderView, int paramInt) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.this$0.b.c.get(this.this$0.h());
    if (localGridView != null)
    {
      localGridView.setSelection(this.a);
      localGridView.smoothScrollToPosition(this.a / localGridView.getNumColumns());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "gridView is null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView.1
 * JD-Core Version:    0.7.0.1
 */