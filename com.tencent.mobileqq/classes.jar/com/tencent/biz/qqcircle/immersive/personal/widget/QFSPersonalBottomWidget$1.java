package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.widget.RadioButton;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab;
import java.util.Iterator;
import java.util.List;

class QFSPersonalBottomWidget$1
  implements Observer<List<QFSPersonalTab>>
{
  QFSPersonalBottomWidget$1(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void a(List<QFSPersonalTab> paramList)
  {
    QFSPersonalBottomWidget.a(this.a, paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QFSPersonalTab localQFSPersonalTab = (QFSPersonalTab)paramList.next();
      switch (localQFSPersonalTab.b())
      {
      default: 
        break;
      case 20103: 
        QFSPersonalBottomWidget.c(this.a).setText(localQFSPersonalTab.d());
        break;
      case 20102: 
        QFSPersonalBottomWidget.b(this.a).setText(localQFSPersonalTab.d());
        QFSPersonalBottomWidget.a(this.a, localQFSPersonalTab.c());
        break;
      case 20101: 
        QFSPersonalBottomWidget.a(this.a).setText(localQFSPersonalTab.d());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.1
 * JD-Core Version:    0.7.0.1
 */