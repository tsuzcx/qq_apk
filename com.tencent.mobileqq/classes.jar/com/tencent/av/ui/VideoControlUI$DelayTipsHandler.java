package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.tips.TipsUtil;

public class VideoControlUI$DelayTipsHandler
  extends Handler
{
  public VideoControlUI$DelayTipsHandler(VideoControlUI paramVideoControlUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 256: 
      TipsUtil.a(this.a.a, 1037, str);
      return;
    }
    TipsUtil.a(this.a.a, 1036, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.DelayTipsHandler
 * JD-Core Version:    0.7.0.1
 */