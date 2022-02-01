package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.widget.LinearLayout;

class QFSPersonalBottomWidget$8
  implements QFSPersonalBottomWidget.OnJustSeeListener
{
  QFSPersonalBottomWidget$8(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void a()
  {
    if (QFSPersonalBottomWidget.d(this.a) == null) {
      return;
    }
    QFSPersonalBottomWidget.b(this.a, false);
    QFSPersonalBottomWidget.d(this.a).setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QFSPersonalBottomWidget.d(this.a) != null)
    {
      if (QFSPersonalBottomWidget.h(this.a)) {
        return;
      }
      if (paramBoolean)
      {
        QFSPersonalBottomWidget.d(this.a).setVisibility(0);
        return;
      }
      QFSPersonalBottomWidget.d(this.a).setVisibility(8);
      QFSPersonalBottomWidget.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.8
 * JD-Core Version:    0.7.0.1
 */