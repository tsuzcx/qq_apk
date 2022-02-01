package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;

class QFSPersonalBottomWidget$3
  implements Observer<QFSPersonalInfo>
{
  QFSPersonalBottomWidget$3(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void a(QFSPersonalInfo paramQFSPersonalInfo)
  {
    if ((paramQFSPersonalInfo != null) && (QFSPersonalBottomWidget.d(this.a) != null) && (!paramQFSPersonalInfo.v))
    {
      if (!paramQFSPersonalInfo.w) {
        return;
      }
      QFSPersonalBottomWidget.d(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.3
 * JD-Core Version:    0.7.0.1
 */