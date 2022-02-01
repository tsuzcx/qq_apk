package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class VideoStoryPiecesPart$2
  implements View.OnClickListener
{
  VideoStoryPiecesPart$2(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().U();
    if ("h5".equals(VideoStoryPiecesPart.a(this.a)))
    {
      if (!NetworkUtil.isNetworkAvailable(null))
      {
        QQToast.a(VideoStoryPiecesPart.a(this.a), 1, VideoStoryPiecesPart.b(this.a).getString(2131697612), 1).a();
        return;
      }
      paramView = new Intent(VideoStoryPiecesPart.c(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", VideoStoryPiecesPart.b(this.a));
      paramView.putExtra("loc_play_show_material_id", VideoStoryPiecesPart.b(this.a));
      if (VideoStoryPiecesPart.d(this.a).getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        paramView.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", VideoStoryPiecesPart.e(this.a).getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      } else {
        paramView.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", VideoStoryPiecesPart.f(this.a).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      paramView.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.L.a());
      paramView.putExtra("VIDEO_STORY_ACTIVITY_ID", VideoStoryPiecesPart.g(this.a).getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID"));
      VideoStoryPiecesPart.h(this.a).startActivityForResult(paramView, 1025);
      return;
    }
    VideoStoryPiecesPart.a(this.a).b(VideoStoryPiecesPart.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.2
 * JD-Core Version:    0.7.0.1
 */