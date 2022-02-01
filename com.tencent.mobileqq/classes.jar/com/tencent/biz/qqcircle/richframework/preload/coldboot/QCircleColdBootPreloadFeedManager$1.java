package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;

class QCircleColdBootPreloadFeedManager$1
  implements Runnable
{
  QCircleColdBootPreloadFeedManager$1(QCircleColdBootPreloadFeedManager paramQCircleColdBootPreloadFeedManager) {}
  
  public void run()
  {
    try
    {
      if (QCircleFolderCacheHelper.a().f())
      {
        QLog.d("QCircleColdBootPreloadFeedManager", 1, "doPrepareInner");
        try
        {
          QCircleColdBootPreloadFeedManager.doPreload(QCircleHostUtil.convertSourceFromType(6));
        }
        finally {}
      }
      else
      {
        QLog.d("QCircleColdBootPreloadFeedManager", 1, "doPrepareInner in 3 min Cache logic,direct return");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager.1
 * JD-Core Version:    0.7.0.1
 */