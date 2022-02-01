package com.tencent.biz.qqcircle.fragments.main;

import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import vtf;

class QCircleFolderRcmdTabFragment$2
  implements Runnable
{
  QCircleFolderRcmdTabFragment$2(QCircleFolderRcmdTabFragment paramQCircleFolderRcmdTabFragment) {}
  
  public void run()
  {
    vtf localvtf = (vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(3));
    localvtf.a("circle_entrance", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment.2
 * JD-Core Version:    0.7.0.1
 */