package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

class QzoneSlideShowPreparingFragment$2
  implements Runnable
{
  QzoneSlideShowPreparingFragment$2(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void run()
  {
    if ((QzoneSlideShowPreparingFragment.a(this.this$0) != null) && (QzoneSlideShowPreparingFragment.a(this.this$0) != null) && (QzoneSlideShowPreparingFragment.a(this.this$0) != null))
    {
      int i = QzoneSlideShowPreparingFragment.a(this.this$0).getProgress();
      if (i < 95)
      {
        i += 1;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("%");
        localObject = ((StringBuilder)localObject).toString();
        QzoneSlideShowPreparingFragment.a(this.this$0).setProgress(i);
        QzoneSlideShowPreparingFragment.a(this.this$0).setText((CharSequence)localObject);
        QzoneSlideShowPreparingFragment.a(this.this$0).sendEmptyMessage(10);
        return;
      }
      QzoneSlideShowPreparingFragment.a(this.this$0).removeCallbacks(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment.2
 * JD-Core Version:    0.7.0.1
 */