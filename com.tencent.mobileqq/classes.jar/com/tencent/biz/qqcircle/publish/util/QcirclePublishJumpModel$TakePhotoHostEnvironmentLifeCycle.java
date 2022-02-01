package com.tencent.biz.qqcircle.publish.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qphone.base.util.QLog;

class QcirclePublishJumpModel$TakePhotoHostEnvironmentLifeCycle
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QcirclePublishJumpModel$TakePhotoHostEnvironmentLifeCycle(QcirclePublishJumpModel paramQcirclePublishJumpModel) {}
  
  private void a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    if ((QcirclePublishJumpModel.b(this.a) != null) && (QcirclePublishJumpModel.b(this.a).getExtras() != null))
    {
      localBundle.putAll(QcirclePublishJumpModel.b(this.a).getExtras());
      localBundle.remove("key_bundle_common_init_bean");
      if (QcirclePublishJumpModel.c(this.a))
      {
        localBundle.remove("PhotoConst.PHOTO_PATHS");
        localBundle.remove("ALBUM_ID");
      }
      localBundle.remove("PhotoConst.PHOTO_PATHS");
    }
    localBundle.putInt("key_qcircle_entrance_type", QcirclePublishJumpModel.d(this.a));
    QLog.d("[QcirclePublish]QcirclePublishJumpUtil", 1, new Object[] { "takePhoto... mQcircleScheme:", QcirclePublishJumpModel.e(this.a) });
    if (!TextUtils.isEmpty(QcirclePublishJumpModel.e(this.a)))
    {
      localBundle.putString("key_scheme", QcirclePublishJumpModel.e(this.a));
      localBundle.putString("qq_camera_from_qcircle_scheme", QcirclePublishJumpModel.e(this.a));
    }
    if (!TextUtils.isEmpty(QcirclePublishJumpModel.f(this.a))) {
      localBundle.putString("key_polymerization_scheme", QcirclePublishJumpModel.f(this.a));
    }
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    int i = QcirclePublishJumpModel.g(this.a).size();
    localBundle.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", i);
    boolean bool;
    if ((i != 0) && (!QcirclePublishJumpModel.c(this.a))) {
      bool = false;
    } else {
      bool = true;
    }
    localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", bool);
    localBundle.putBoolean("key_qcircle_publish_back_edit", QcirclePublishJumpModel.c(this.a));
    if (QcirclePublishJumpModel.c(this.a)) {
      localBundle.putString(QCircleHostConstants._AEEditorConstants.KEY_AE_PHOTO_PICKER_TAB(), this.a.a);
    }
    localBundle.putStringArrayList("key_qcircle_publish_out_imagepath", QcirclePublishJumpModel.g(this.a));
    if (QCircleHostQzoneHelper.getInt4Uin("_qq_circle_publish", 0, QcirclePublishJumpModel.h(this.a)) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("key_qcircle_pulish_has_draft", bool);
    if (i > 0)
    {
      localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
      localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", false);
    }
    else
    {
      localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
      localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[takePhoto...] + END, time cost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    QLog.d("[Performance2][QcirclePublish]QcirclePublishJumpUtil", 1, ((StringBuilder)localObject).toString());
    localBundle.putString("qcircle_client_traceid", QcirclePublishJumpModel.i(this.a));
    localBundle.putBoolean("key_is_capsule_button", QcirclePublishJumpModel.j(this.a));
    long l = System.currentTimeMillis();
    if (QcirclePublishJumpModel.d(this.a) == 1)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      QCircleHostLauncher.jumpForAECircle(paramContext, (Intent)localObject);
    }
    else if (QcirclePublishJumpModel.d(this.a) == 2)
    {
      QCircleHostLauncher.launchAECameraFromCircle(paramContext, localBundle);
    }
    else if ((QcirclePublishJumpModel.d(this.a) == 3) || (QcirclePublishJumpModel.d(this.a) == 0))
    {
      QCircleHostLauncher.launchAEMutiCameraFromCircle(paramContext, localBundle);
    }
    paramContext = new StringBuilder();
    paramContext.append("takePhoto... cost:");
    paramContext.append(System.currentTimeMillis() - l);
    QLog.d("[QcirclePublish]QcirclePublishJumpUtil", 1, paramContext.toString());
  }
  
  public void onEnvironmentCreated(Context paramContext)
  {
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.QcirclePublishJumpModel.TakePhotoHostEnvironmentLifeCycle
 * JD-Core Version:    0.7.0.1
 */