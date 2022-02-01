package com.tencent.mobileqq.activity.richmedia;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;

class EditLocalVideoActivity$18
  implements Runnable
{
  EditLocalVideoActivity$18(EditLocalVideoActivity paramEditLocalVideoActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.this$0.getResources().getDisplayMetrics().widthPixels / 6;
    float f = this.a * 1.0F / this.b;
    int j;
    int n;
    int k;
    int m;
    if (f <= 1.0F)
    {
      j = (int)(i / f);
      n = (j - i) / 2;
      k = i;
      m = 0;
    }
    else
    {
      k = (int)(f * i);
      m = (k - i) / 2;
      j = i;
      n = 0;
    }
    if (TextUtils.isEmpty(EditLocalVideoActivity.C(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "initFramesBar, mTrimVideoPath is null");
      }
      EditLocalVideoActivity.y(this.this$0).sendEmptyMessage(1001);
      return;
    }
    Object localObject1;
    if (!EditLocalVideoActivity.d())
    {
      i = ThumbnailUtils.a(EditLocalVideoActivity.C(this.this$0), k, j, m, n, i, i);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init, status1=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", dstWidth=");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", dstHeight=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (i != 0)
      {
        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(EditLocalVideoActivity.D(this.this$0)), "qzone_video_trim", "2", null);
        EditLocalVideoActivity.y(this.this$0).sendEmptyMessage(1001);
        return;
      }
    }
    EditLocalVideoActivity.c(this.this$0).a(EditLocalVideoActivity.p(this.this$0), EditLocalVideoActivity.C(this.this$0));
    if (EditLocalVideoActivity.u(this.this$0) == 0)
    {
      localObject1 = this.this$0;
      EditLocalVideoActivity.c((EditLocalVideoActivity)localObject1, (int)EditLocalVideoActivity.c((EditLocalVideoActivity)localObject1).getSelectBeginTime());
    }
    if (EditLocalVideoActivity.v(this.this$0) == 0)
    {
      localObject1 = this.this$0;
      EditLocalVideoActivity.d((EditLocalVideoActivity)localObject1, (int)EditLocalVideoActivity.c((EditLocalVideoActivity)localObject1).getSelectEndTime());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mStartTime=");
      ((StringBuilder)localObject1).append(EditLocalVideoActivity.u(this.this$0));
      ((StringBuilder)localObject1).append(", mEndTime=");
      ((StringBuilder)localObject1).append(EditLocalVideoActivity.v(this.this$0));
      QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject1).toString());
    }
    EditLocalVideoActivity.q(this.this$0).setPlayDuration(EditLocalVideoActivity.u(this.this$0), EditLocalVideoActivity.v(this.this$0) - EditLocalVideoActivity.u(this.this$0));
    EditLocalVideoActivity.y(this.this$0).sendEmptyMessage(1100);
    if (!EditLocalVideoActivity.d())
    {
      if (TextUtils.isEmpty(EditLocalVideoActivity.C(this.this$0))) {
        i = -999;
      } else {
        i = ThumbnailUtils.a(EditLocalVideoActivity.C(this.this$0), this.a, this.b);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init, status0=");
        ((StringBuilder)localObject1).append(i);
        QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (i != 0)
      {
        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(EditLocalVideoActivity.D(this.this$0)), "qzone_video_trim", "3", null);
        EditLocalVideoActivity.y(this.this$0).sendEmptyMessage(1000);
        return;
      }
    }
    try
    {
      Object localObject2;
      if (EditLocalVideoActivity.d())
      {
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(EditLocalVideoActivity.C(this.this$0));
        localObject1 = ((MediaMetadataRetriever)localObject2).getFrameAtTime(EditLocalVideoActivity.u(this.this$0) * 1000, 3);
        ((MediaMetadataRetriever)localObject2).release();
      }
      else
      {
        localObject1 = ThumbnailUtils.a(0L, 1000L);
      }
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(GloableValue.b);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((StringBuilder)localObject2).append(".jpg");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (PhotoUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2, Bitmap.CompressFormat.JPEG, 90, true)) {
          EditLocalVideoActivity.y(this.this$0).obtainMessage(1102, localObject2).sendToTarget();
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.18
 * JD-Core Version:    0.7.0.1
 */