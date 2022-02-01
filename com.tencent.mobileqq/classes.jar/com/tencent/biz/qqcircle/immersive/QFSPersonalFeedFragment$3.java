package com.tencent.biz.qqcircle.immersive;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

class QFSPersonalFeedFragment$3
  implements Observer<QFSPersonalInfo>
{
  QFSPersonalFeedFragment$3(QFSPersonalFeedFragment paramQFSPersonalFeedFragment) {}
  
  public void a(QFSPersonalInfo paramQFSPersonalInfo)
  {
    if ((paramQFSPersonalInfo != null) && (this.a.c != null) && (!paramQFSPersonalInfo.v))
    {
      if (!paramQFSPersonalInfo.w) {
        return;
      }
      switch (this.a.g)
      {
      default: 
        paramQFSPersonalInfo = "";
        break;
      case 20103: 
        paramQFSPersonalInfo = QCircleConfigHelper.aZ();
        break;
      case 20102: 
        paramQFSPersonalInfo = QCircleConfigHelper.aT();
        break;
      case 20101: 
        paramQFSPersonalInfo = QCircleConfigHelper.aP();
      }
      this.a.c.a(paramQFSPersonalInfo, QCircleConfigHelper.aM());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment.3
 * JD-Core Version:    0.7.0.1
 */