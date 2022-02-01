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
    if (paramIntent != null)
    {
      if (this.a.am == null) {
        return;
      }
      long l = SeqUtil.a(paramIntent);
      paramContext = paramIntent.getStringExtra("camera_id");
      int i = paramIntent.getIntExtra("availability", 1);
      paramIntent = this.a.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraAvailabilityReceiver, cameraId[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], availability[");
      localStringBuilder.append(i);
      localStringBuilder.append("], mCameraAvailable[");
      localStringBuilder.append(this.a.am.k().co);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(paramIntent, 1, localStringBuilder.toString());
      this.a.al.a(paramContext, i);
      if (i == 0)
      {
        VideoControlUI.a(this.a, l, i);
        return;
      }
      int j = -1;
      paramContext = this.a.al.i();
      i = j;
      if (paramContext != null)
      {
        i = j;
        if (paramContext.size() > 0)
        {
          paramContext = paramContext.entrySet().iterator();
          do
          {
            i = j;
            if (!paramContext.hasNext()) {
              break;
            }
          } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
          i = 0;
        }
      }
      VideoControlUI.a(this.a, l, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.CameraAvailabilityReceiver
 * JD-Core Version:    0.7.0.1
 */