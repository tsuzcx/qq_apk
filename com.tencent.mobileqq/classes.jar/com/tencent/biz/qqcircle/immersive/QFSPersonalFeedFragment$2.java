package com.tencent.biz.qqcircle.immersive;

import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter.OnItemClickListener;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;

class QFSPersonalFeedFragment$2
  implements QFSPersonalFeedAdapter.OnItemClickListener
{
  QFSPersonalFeedFragment$2(QFSPersonalFeedFragment paramQFSPersonalFeedFragment) {}
  
  public void a(int paramInt, QFSPersonalFeedInfo paramQFSPersonalFeedInfo)
  {
    if (paramQFSPersonalFeedInfo.h() == 100103)
    {
      QFSPersonalFeedFragment.a(this.a, paramInt, paramQFSPersonalFeedInfo);
      return;
    }
    QFSPersonalFeedFragment.b(this.a, paramInt, paramQFSPersonalFeedInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment.2
 * JD-Core Version:    0.7.0.1
 */