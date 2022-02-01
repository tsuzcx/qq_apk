package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QIMProviderContainerView$7
  implements Runnable
{
  QIMProviderContainerView$7(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void run()
  {
    int j = this.this$0.b.getChildCount();
    if (QIMProviderContainerView.g(this.this$0))
    {
      Drawable[] arrayOfDrawable = new Drawable[j];
      int i = 0;
      while (i < j)
      {
        if (QIMProviderContainerView.f(this.this$0).c(i))
        {
          int k = ((Integer)((ImageView)this.this$0.b.getChildAt(i)).getTag()).intValue();
          arrayOfDrawable[i] = this.this$0.getResources().getDrawable(QIMProviderContainerView.f(this.this$0).b(k));
        }
        i += 1;
      }
      ThreadManager.getUIHandler().post(new QIMProviderContainerView.7.1(this, j, arrayOfDrawable));
      QIMProviderContainerView.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.7
 * JD-Core Version:    0.7.0.1
 */