package com.tencent.mobileqq.activity.shortvideo;

import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$20
  extends MqqHandler
{
  ShortVideoPreviewActivity$20(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = ShortVideoUtils.stringForTime(paramMessage.arg1);
    this.a.progressTimeMp.setText(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.20
 * JD-Core Version:    0.7.0.1
 */