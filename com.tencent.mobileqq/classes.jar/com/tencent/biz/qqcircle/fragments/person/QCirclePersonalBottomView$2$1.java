package com.tencent.biz.qqcircle.fragments.person;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCirclePersonalBottomView$2$1
  implements Runnable
{
  QCirclePersonalBottomView$2$1(QCirclePersonalBottomView.2 param2) {}
  
  public void run()
  {
    Object localObject = QCircleSkinHelper.getInstance();
    int i;
    if (this.a.a) {
      i = 2130845361;
    } else {
      i = 2130845365;
    }
    localObject = ((QCircleSkinHelper)localObject).getDrawable(i);
    QCirclePersonalBottomView.b(this.a.b).setImageDrawable((Drawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.2.1
 * JD-Core Version:    0.7.0.1
 */