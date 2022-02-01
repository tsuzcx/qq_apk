package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class VoiceChangeChooseDialog$3
  implements VoiceChangeAdapter.ICallback
{
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemSelected| voiceType=");
    localStringBuilder.append(paramInt);
    AVLog.printAllUserLog("VoiceChangeChooseDialog", localStringBuilder.toString());
    if (this.a.a == null)
    {
      AVLog.printErrorLog("VoiceChangeChooseDialog", "onItemSelected mVideoController is null!!");
      return;
    }
    if (paramInt == 0)
    {
      this.a.f.setText(2131893740);
      this.a.k.removeCallbacks(this.a.l);
      VoiceChangeChooseDialog.a(this.a, 0);
    }
    else
    {
      this.a.f.setText(2131893739);
      if (this.a.a.k() != null)
      {
        if ((!this.a.a.k().bW) && (VoiceChangeChooseDialog.a(this.a) == 0) && (!this.a.g))
        {
          this.a.k.postDelayed(this.a.l, 5000L);
          VoiceChangeChooseDialog.a(this.a, 1);
        }
      }
      else {
        AVLog.printErrorLog("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
      }
    }
    if (this.a.a.k() != null)
    {
      this.a.a.k().cr = paramInt;
      this.a.a.k().cs = 0;
      this.a.a.am();
      VoiceChangeDataReport.a(this.a.a.k(), paramInt);
      return;
    }
    AVLog.printErrorLog("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.3
 * JD-Core Version:    0.7.0.1
 */