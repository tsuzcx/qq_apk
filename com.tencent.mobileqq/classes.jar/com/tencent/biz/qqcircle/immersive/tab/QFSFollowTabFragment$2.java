package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.qphone.base.util.QLog;

class QFSFollowTabFragment$2
  implements Runnable
{
  QFSFollowTabFragment$2(QFSFollowTabFragment paramQFSFollowTabFragment) {}
  
  public void run()
  {
    if ((this.this$0.u != null) && (this.this$0.u.a() == 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleEeveeRedPoint_");
      localStringBuilder.append(this.this$0.b());
      QLog.d(localStringBuilder.toString(), 1, "[clearLocalFollowRedPoint");
      QCircleHostRedPointHelper.setSmallRedPointReaded("circle_entrance");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSFollowTabFragment.2
 * JD-Core Version:    0.7.0.1
 */