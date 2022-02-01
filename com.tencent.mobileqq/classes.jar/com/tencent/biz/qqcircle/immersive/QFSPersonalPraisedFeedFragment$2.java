package com.tencent.biz.qqcircle.immersive;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import java.util.Iterator;
import java.util.List;

class QFSPersonalPraisedFeedFragment$2
  implements Observer<List<QFSPersonalTab>>
{
  QFSPersonalPraisedFeedFragment$2(QFSPersonalPraisedFeedFragment paramQFSPersonalPraisedFeedFragment) {}
  
  public void a(List<QFSPersonalTab> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QFSPersonalTab localQFSPersonalTab = (QFSPersonalTab)paramList.next();
      if ((this.a.f != null) && (!this.a.f.p()) && (!this.a.f.q()) && (localQFSPersonalTab.c())) {
        this.a.c.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalPraisedFeedFragment.2
 * JD-Core Version:    0.7.0.1
 */