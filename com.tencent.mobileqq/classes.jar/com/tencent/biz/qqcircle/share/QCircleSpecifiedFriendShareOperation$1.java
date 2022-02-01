package com.tencent.biz.qqcircle.share;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qphone.base.util.QLog;

class QCircleSpecifiedFriendShareOperation$1
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QCircleSpecifiedFriendShareOperation$1(QCircleSpecifiedFriendShareOperation paramQCircleSpecifiedFriendShareOperation, Intent paramIntent) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    if (QCircleSpecifiedFriendShareOperation.a(this.b) == null)
    {
      QLog.w("QCircleSpecifiedFriendShare", 1, "[openHostEnvironment] host forward api should be not null.");
      return;
    }
    QCircleSpecifiedFriendShareOperation.a(this.b).startForwardActivityForResult(paramContext, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleSpecifiedFriendShareOperation.1
 * JD-Core Version:    0.7.0.1
 */