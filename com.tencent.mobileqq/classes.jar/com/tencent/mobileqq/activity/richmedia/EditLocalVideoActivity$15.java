package com.tencent.mobileqq.activity.richmedia;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class EditLocalVideoActivity$15
  implements MediaPlayer.OnErrorListener
{
  EditLocalVideoActivity$15(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  private String[] a()
  {
    String str = QzoneConfig.getInstance().getConfig("VideoEdit", "VideoLoadErrorReturnCode");
    if (str == null) {
      return null;
    }
    return str.split(",");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("EditLocalVideoActivity", 2, "VideoView onError, what:" + paramInt1 + ", extra:" + paramInt2);
    for (;;)
    {
      try
      {
        Toast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131703677), 1).show();
        paramMediaPlayer = a();
        if (paramMediaPlayer == null)
        {
          EditLocalVideoActivity.a(this.a, "play_local_video", "play_local_video_success", "4", "what: " + paramInt1 + ",   extra: " + paramInt2 + ",   " + Build.MODEL);
          this.a.setResult(0);
          return true;
        }
        int k = paramMediaPlayer.length;
        int i = 0;
        int j = 1;
        if (i < k)
        {
          if (TextUtils.equals(paramMediaPlayer[i], paramInt1 + "-" + paramInt2)) {
            j = 0;
          }
        }
        else
        {
          if (j == 0) {
            continue;
          }
          EditLocalVideoActivity.a(this.a, "play_local_video", "play_local_video_success", "4", "what: " + paramInt1 + ",   extra: " + paramInt2 + ",   " + Build.MODEL);
          continue;
        }
        i += 1;
      }
      catch (Exception paramMediaPlayer)
      {
        QLog.e("EditLocalVideoActivity", 2, "VideoView onError", paramMediaPlayer);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.15
 * JD-Core Version:    0.7.0.1
 */