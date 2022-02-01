package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class BottomVideoInfoWidget$5
  implements DialogInterface.OnClickListener
{
  BottomVideoInfoWidget$5(BottomVideoInfoWidget paramBottomVideoInfoWidget) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BottomVideoInfoWidget.a(this.a);
    StoryReportor.a("play_video", "clk_window", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.5
 * JD-Core Version:    0.7.0.1
 */