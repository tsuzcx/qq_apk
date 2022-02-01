package com.tencent.biz.qqcircle.immersive;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart;
import java.util.ArrayList;
import java.util.List;

class QFSPersonalProductFeedFragment$3
  implements Observer<List<QFSPersonalFeedInfo>>
{
  QFSPersonalProductFeedFragment$3(QFSPersonalProductFeedFragment paramQFSPersonalProductFeedFragment) {}
  
  public void a(List<QFSPersonalFeedInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      QFSPersonalProductFeedFragment localQFSPersonalProductFeedFragment = this.a;
      localQFSPersonalProductFeedFragment.i = true;
      localQFSPersonalProductFeedFragment.e.a((ArrayList)paramList);
      this.a.c.f();
      return;
    }
    paramList = this.a;
    paramList.i = false;
    paramList.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalProductFeedFragment.3
 * JD-Core Version:    0.7.0.1
 */