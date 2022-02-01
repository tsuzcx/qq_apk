package com.tencent.biz.qqcircle.immersive.personal.widget;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;

class QFSPersonalInfoWidget$3
  implements Observer<QFSUserFollowData>
{
  QFSPersonalInfoWidget$3(QFSPersonalInfoWidget paramQFSPersonalInfoWidget) {}
  
  public void a(QFSUserFollowData paramQFSUserFollowData)
  {
    QFSPersonalInfoWidget.a(this.a, paramQFSUserFollowData.c());
    QFSPersonalInfoWidget.a(this.a, paramQFSUserFollowData.d());
    QFSPersonalInfoWidget.a(this.a, paramQFSUserFollowData);
    QFSPersonalInfoWidget.a(this.a);
    QFSPersonalInfoWidget.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */