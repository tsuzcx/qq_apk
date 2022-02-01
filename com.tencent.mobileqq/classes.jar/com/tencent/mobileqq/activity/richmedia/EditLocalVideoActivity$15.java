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
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("VideoView onError, what:");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(", extra:");
    paramMediaPlayer.append(paramInt2);
    QLog.e("EditLocalVideoActivity", 2, paramMediaPlayer.toString());
    for (;;)
    {
      int i;
      try
      {
        Toast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131901751), 1).show();
        paramMediaPlayer = a();
        StringBuilder localStringBuilder1;
        if (paramMediaPlayer == null)
        {
          paramMediaPlayer = this.a;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("what: ");
          localStringBuilder1.append(paramInt1);
          localStringBuilder1.append(",   extra: ");
          localStringBuilder1.append(paramInt2);
          localStringBuilder1.append(",   ");
          localStringBuilder1.append(Build.MODEL);
          EditLocalVideoActivity.a(paramMediaPlayer, "play_local_video", "play_local_video_success", "4", localStringBuilder1.toString());
        }
        else
        {
          int k = paramMediaPlayer.length;
          i = 0;
          int j = 1;
          if (i < k)
          {
            localStringBuilder1 = paramMediaPlayer[i];
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramInt1);
            localStringBuilder2.append("-");
            localStringBuilder2.append(paramInt2);
            if (!TextUtils.equals(localStringBuilder1, localStringBuilder2.toString())) {
              break label328;
            }
            j = 0;
            break label328;
          }
          if (j != 0)
          {
            paramMediaPlayer = this.a;
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("what: ");
            localStringBuilder1.append(paramInt1);
            localStringBuilder1.append(",   extra: ");
            localStringBuilder1.append(paramInt2);
            localStringBuilder1.append(",   ");
            localStringBuilder1.append(Build.MODEL);
            EditLocalVideoActivity.a(paramMediaPlayer, "play_local_video", "play_local_video_success", "4", localStringBuilder1.toString());
          }
        }
        this.a.setResult(0);
      }
      catch (Exception paramMediaPlayer)
      {
        QLog.e("EditLocalVideoActivity", 2, "VideoView onError", paramMediaPlayer);
      }
      return true;
      label328:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.15
 * JD-Core Version:    0.7.0.1
 */