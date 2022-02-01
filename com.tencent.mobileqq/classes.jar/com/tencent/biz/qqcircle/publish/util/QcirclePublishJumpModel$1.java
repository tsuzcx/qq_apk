package com.tencent.biz.qqcircle.publish.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;

class QcirclePublishJumpModel$1
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QcirclePublishJumpModel$1(QcirclePublishJumpModel paramQcirclePublishJumpModel) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (QcirclePublishJumpModel.a(this.a) == 0L) {
      QcirclePublishJumpModel.a(this.a, QCirclePublishViewModel.u);
    }
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", QcirclePublishJumpModel.a(this.a) * 1000L);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1610612736L);
    if (QcirclePublishJumpModel.b(this.a) != null) {
      localIntent.putExtra("key_is_take_photo", QcirclePublishJumpModel.b(this.a).getBooleanExtra("key_is_take_photo", false));
    }
    QCircleHostLauncher.launchQQPhotoSelect(paramContext, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.QcirclePublishJumpModel.1
 * JD-Core Version:    0.7.0.1
 */