package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;

class VideoFeedsPlayActivity$5
  extends ColorNoteCurd.OnColorNoteCurdListener
{
  VideoFeedsPlayActivity$5(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    int j = 1;
    super.onAddColorNote(paramBundle, paramBoolean);
    int i;
    if (paramBundle.getInt("color_note_curd_from_type") == 1)
    {
      i = 1;
      if (VideoFeedsPlayActivity.a(this.a) == 0)
      {
        paramBundle = this.a;
        if (i == 0) {
          break label151;
        }
      }
    }
    for (;;)
    {
      VideoFeedsPlayActivity.a(paramBundle, j);
      paramBundle = VideoFeedsPlayActivity.a(this.a);
      if (paramBundle != null) {
        paramBundle.q = VideoFeedsPlayActivity.a(this.a);
      }
      if (VideoFeedsPlayActivity.a(this.a) == 3) {
        VideoFeedsPlayActivity.a(this.a, ColorNoteUtils.a(VideoFeedsPlayActivity.a(this.a)));
      }
      VideoFeedsPlayActivity.a(this.a).mReserve = VideoFeedsHelper.a(paramBundle);
      VideoFeedsPlayActivity.a(this.a).a(VideoFeedsPlayActivity.a(this.a));
      ReportUtil.a(paramBundle);
      if (i == 0) {
        this.a.e();
      }
      return;
      i = 0;
      break;
      label151:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */