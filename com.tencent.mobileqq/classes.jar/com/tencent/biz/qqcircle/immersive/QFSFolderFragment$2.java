package com.tencent.biz.qqcircle.immersive;

import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QFSFolderFragment$2
  implements Runnable
{
  QFSFolderFragment$2(QFSFolderFragment paramQFSFolderFragment) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QCircleEeveeRedPoint_");
    ((StringBuilder)localObject).append(this.this$0.b());
    QLog.d(((StringBuilder)localObject).toString(), 1, "[clearLocalOuterEntranceRedPoint");
    localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(1));
    ((List)localObject).add(Integer.valueOf(3));
    ((List)localObject).add(Integer.valueOf(6));
    QCircleHostRedPointHelper.setOuterEntranceRedPointReaded("circle_entrance", (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSFolderFragment.2
 * JD-Core Version:    0.7.0.1
 */