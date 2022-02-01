package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class VideoControlUI$CameraAvailabilityReceiver
  extends BroadcastReceiver
{
  VideoControlUI$CameraAvailabilityReceiver(VideoControlUI paramVideoControlUI) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    long l = SeqUtil.a(paramIntent);
    paramContext = paramIntent.getStringExtra("camera_id");
    int i = paramIntent.getIntExtra("availability", 1);
    QLog.w(this.a.d, 1, "CameraAvailabilityReceiver, cameraId[" + paramContext + "], availability[" + i + "], mCameraAvailable[" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa + "], seq[" + l + "]");
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramContext, i);
    if (i == 0)
    {
      VideoControlUI.a(this.a, l, i);
      return;
    }
    paramContext = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.entrySet().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
    }
    for (i = 0;; i = -1)
    {
      VideoControlUI.a(this.a, l, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.CameraAvailabilityReceiver
 * JD-Core Version:    0.7.0.1
 */