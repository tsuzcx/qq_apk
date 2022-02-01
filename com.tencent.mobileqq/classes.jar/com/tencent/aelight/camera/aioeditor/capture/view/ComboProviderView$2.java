package com.tencent.aelight.camera.aioeditor.capture.view;

import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;

class ComboProviderView$2
  implements Runnable
{
  ComboProviderView$2(ComboProviderView paramComboProviderView, int paramInt) {}
  
  public void run()
  {
    Object localObject = (GridView)this.this$0.b.c.get(this.this$0.h());
    if (localObject != null)
    {
      ((GridView)localObject).setSelection(this.a);
      ((GridView)localObject).smoothScrollToPosition(this.a / ((GridView)localObject).getNumColumns());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("positon= ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("ComboProviderView", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ComboProviderView", 2, "gridView is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView.2
 * JD-Core Version:    0.7.0.1
 */