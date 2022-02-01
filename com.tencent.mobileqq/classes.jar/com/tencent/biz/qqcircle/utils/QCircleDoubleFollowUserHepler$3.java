package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.beans.Friend;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import vtj;

public class QCircleDoubleFollowUserHepler$3
  implements Runnable
{
  public QCircleDoubleFollowUserHepler$3(vtj paramvtj, String paramString) {}
  
  public void run()
  {
    int i = vtj.a(this.this$0).delete(Friend.class.getSimpleName(), "mUin=? ", new String[] { this.a });
    if (QLog.isColorLevel()) {
      QLog.i("QCircleDoubleFollowUserHepler", 2, "updateFollowUser remove count:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleDoubleFollowUserHepler.3
 * JD-Core Version:    0.7.0.1
 */