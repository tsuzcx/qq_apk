package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;

class QFSMainMultiTabFragmentPart$10
  implements Runnable
{
  QFSMainMultiTabFragmentPart$10(QFSMainMultiTabFragmentPart paramQFSMainMultiTabFragmentPart) {}
  
  public void run()
  {
    if (QFSMainMultiTabFragmentPart.i(this.this$0) == null) {
      return;
    }
    QFSMainMultiTabFragmentPart.i(this.this$0).setAlpha(1.0F);
    QFSMainMultiTabFragmentPart.a(this.this$0, new ValueAnimator());
    float f = QFSMainMultiTabFragmentPart.j(this.this$0).getTranslationY();
    QFSMainMultiTabFragmentPart.k(this.this$0).setFloatValues(new float[] { f, 0.0F });
    QFSMainMultiTabFragmentPart.k(this.this$0).setDuration(300L);
    QFSMainMultiTabFragmentPart.k(this.this$0).addUpdateListener(new QFSMainMultiTabFragmentPart.10.1(this, f));
    QFSMainMultiTabFragmentPart.k(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.10
 * JD-Core Version:    0.7.0.1
 */