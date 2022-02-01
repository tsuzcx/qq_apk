package com.tencent.biz.qqcircle.manager;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFolderTabInfoManager$3
  implements Runnable
{
  QCircleFolderTabInfoManager$3(QCircleFolderTabInfoManager paramQCircleFolderTabInfoManager, int paramInt, List paramList) {}
  
  public void run()
  {
    QCircleFolderTabInfoManager.a(this.this$0).put("new", Integer.valueOf(this.a));
    QCircleFolderTabInfoManager.b(this.this$0).put("new", this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(",jumpTabType:");
    localStringBuilder.append(this.a);
    QLog.d("QCircleFolderTabInfoManager", 1, new Object[] { "initNewTabInfo done,size:", localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager.3
 * JD-Core Version:    0.7.0.1
 */