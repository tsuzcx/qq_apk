package com.tencent.aelight.camera.aioeditor.capture.view;

import com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderPagerAdapter;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;

class MusicProviderView$5
  implements Runnable
{
  MusicProviderView$5(MusicProviderView paramMusicProviderView, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.b.getCurrentItem();
    Object localObject = this.this$0.c.b(i);
    if (localObject != null)
    {
      ((GridView)localObject).setSelection(this.a);
      localObject = this.this$0;
      ((MusicProviderView)localObject).j = i;
      ((MusicProviderView)localObject).k = this.a;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("selectCategoryAndItem setSelection= ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" position=");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("MusicProviderView", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gridView is null item= ");
      ((StringBuilder)localObject).append(i);
      QLog.e("MusicProviderView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView.5
 * JD-Core Version:    0.7.0.1
 */