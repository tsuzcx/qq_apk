package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$2
  extends MqqHandler
{
  ShortVideoPlayActivity$2(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "...mobile/none => wifi...");
            }
            if ((this.a.mMediaPlayer != null) && (this.a.mMediaPlayer.get() != null)) {
              ((TVK_IMediaPlayer)this.a.mMediaPlayer.get()).setDownloadNetworkChange(1);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "...wifi/none => mobile...");
            }
            if ((this.a.mMediaPlayer != null) && (this.a.mMediaPlayer.get() != null)) {
              ((TVK_IMediaPlayer)this.a.mMediaPlayer.get()).setDownloadNetworkChange(2);
            }
            if ((this.a.mPlayCallerType != 1) && (this.a.mPlayCallerType != 2))
            {
              if ((this.a.mPlayCallerType == 0) || (this.a.mPlayCallerType == 5)) {
                ShortVideoPlayActivity.access$100(this.a);
              }
            }
            else if (this.a.isPlaying())
            {
              this.a.pause();
              this.a.showNetAlertDlg();
            }
          }
        }
        else
        {
          paramMessage = DialogUtil.a(this.a.mContext, 232, this.a.mContext.getResources().getString(2131916643), this.a.mContext.getResources().getString(2131916642), 2131916626, 2131915687, new ShortVideoPlayActivity.2.1(this), new ShortVideoPlayActivity.2.2(this));
          ShortVideoPlayActivity.access$000(this.a, paramMessage);
        }
      }
      else
      {
        String str = this.a.getString(2131916612);
        paramMessage = (String)paramMessage.obj;
        Context localContext = this.a.mContext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramMessage);
        QQToast.makeText(localContext, 2, localStringBuilder.toString(), 0).show();
        ImageUtil.b(this.a, paramMessage);
      }
    }
    else {
      QQToast.makeText(this.a, 2131916611, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.2
 * JD-Core Version:    0.7.0.1
 */