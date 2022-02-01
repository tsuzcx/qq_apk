package com.tencent.biz.qqcircle.publish.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import java.util.ArrayList;

class QCirclePublishPicPreviewPart$TakePhotoHostEnvironmentLifeCycle
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QCirclePublishPicPreviewPart$TakePhotoHostEnvironmentLifeCycle(QCirclePublishPicPreviewPart paramQCirclePublishPicPreviewPart) {}
  
  private void a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    int i;
    if (QCirclePublishPicPreviewPart.e(this.a) != null) {
      i = QCirclePublishPicPreviewPart.e(this.a).a().size();
    } else {
      i = 0;
    }
    localBundle.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", i);
    localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", false);
    localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
    localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", false);
    localBundle.putBoolean("key_qcircle_publish_from_preview", true);
    localBundle.putBoolean("key_qcircle_is_from_pic_preview_part", true);
    new Intent().putExtras(localBundle);
    QCircleHostLauncher.launchAEMutiCameraFromCircle(paramContext, localBundle);
  }
  
  public void onEnvironmentCreated(Context paramContext)
  {
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewPart.TakePhotoHostEnvironmentLifeCycle
 * JD-Core Version:    0.7.0.1
 */