package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.os.Build.VERSION;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab;
import java.util.List;

class QFSPersonalBottomWidget$5
  extends ViewPager2.OnPageChangeCallback
{
  QFSPersonalBottomWidget$5(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    QFSPersonalBottomWidget.b(this.a, paramInt);
    QFSPersonalBottomWidget localQFSPersonalBottomWidget = this.a;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    QFSPersonalBottomWidget.c(localQFSPersonalBottomWidget, bool);
    if ((Build.VERSION.SDK_INT < 23) && (QFSPersonalBottomWidget.f(this.a) != null))
    {
      if (QFSPersonalBottomWidget.f(this.a).size() < 3) {
        return;
      }
      localQFSPersonalBottomWidget = this.a;
      QFSPersonalBottomWidget.d(localQFSPersonalBottomWidget, ((QFSPersonalTab)QFSPersonalBottomWidget.f(localQFSPersonalBottomWidget).get(2)).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.5
 * JD-Core Version:    0.7.0.1
 */