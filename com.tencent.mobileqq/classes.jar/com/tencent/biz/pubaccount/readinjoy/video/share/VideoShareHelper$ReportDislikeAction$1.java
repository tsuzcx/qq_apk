package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;
import com.tencent.widget.ActionSheet.WatchDismissActions;

class VideoShareHelper$ReportDislikeAction$1
  implements ActionSheet.WatchDismissActions
{
  VideoShareHelper$ReportDislikeAction$1(VideoShareHelper.ReportDislikeAction paramReportDislikeAction) {}
  
  public void onDismissOperations()
  {
    if (VideoShareHelper.c(this.a.a))
    {
      VideoShareHelper.c(this.a.a, false);
      VideoShareHelper.a(this.a.a).a(VideoShareHelper.a(this.a.a), VideoShareHelper.b(this.a.a), true, false);
      return;
    }
    VideoShareHelper.a(this.a.a).a(VideoShareHelper.a(this.a.a), VideoShareHelper.b(this.a.a), true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.ReportDislikeAction.1
 * JD-Core Version:    0.7.0.1
 */