package com.tencent.biz.qqcircle.fragments.main;

import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import java.util.ArrayList;
import java.util.List;

class QCircleFolderFollowTabFragment$2
  implements Runnable
{
  QCircleFolderFollowTabFragment$2(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void run()
  {
    QCircleHostRedPointHelper.setSmallRedPointReaded("circle_entrance");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(6));
    QCircleHostRedPointHelper.setOuterEntranceRedPointReaded("circle_entrance", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment.2
 * JD-Core Version:    0.7.0.1
 */