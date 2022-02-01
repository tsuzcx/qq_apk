package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;

class QFSPersonalBottomWidget$2
  implements Observer<Boolean>
{
  QFSPersonalBottomWidget$2(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void a(Boolean paramBoolean)
  {
    if ((paramBoolean.booleanValue()) && (QFSPersonalBottomWidget.d(this.a) != null) && (QFSPersonalBottomWidget.e(this.a) != null))
    {
      QFSPersonalBottomWidget.b(this.a, false);
      QFSPersonalBottomWidget.d(this.a).setVisibility(8);
      QFSPersonalBottomWidget.e(this.a).setCurrentItem(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.2
 * JD-Core Version:    0.7.0.1
 */