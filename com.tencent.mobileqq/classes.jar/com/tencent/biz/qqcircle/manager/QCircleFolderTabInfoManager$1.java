package com.tencent.biz.qqcircle.manager;

import com.tencent.QCircleCollection;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class QCircleFolderTabInfoManager$1
  implements OnTaskListener<Object>
{
  QCircleFolderTabInfoManager$1(QCircleFolderTabInfoManager paramQCircleFolderTabInfoManager) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchNewDataFromPreload requestTabData onReceive: dispatch Success:");
      localStringBuilder.append(paramVarArgs[0]);
      localStringBuilder.append(" | retCode:");
      localStringBuilder.append(paramVarArgs[1]);
      localStringBuilder.append(" | retMessage:");
      localStringBuilder.append(paramVarArgs[2]);
      QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
      this.a.a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetBusiInfoRsp)paramVarArgs[3]);
      QCircleCollection.a("qcircle_preload", "initTabsFromNetwork");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager.1
 * JD-Core Version:    0.7.0.1
 */