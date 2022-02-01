package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class VideoStoryPiecesPart$2
  implements View.OnClickListener
{
  VideoStoryPiecesPart$2(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().V();
    if ("h5".equals(VideoStoryPiecesPart.d(this.a)))
    {
      if (!NetworkUtil.isNetworkAvailable(null))
      {
        QQToast.makeText(VideoStoryPiecesPart.e(this.a), 1, VideoStoryPiecesPart.f(this.a).getString(2131895385), 1).show();
        return;
      }
      paramView = new Intent(VideoStoryPiecesPart.g(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", VideoStoryPiecesPart.h(this.a));
      paramView.putExtra("loc_play_show_material_id", VideoStoryPiecesPart.h(this.a));
      if (VideoStoryPiecesPart.i(this.a).getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        paramView.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", VideoStoryPiecesPart.j(this.a).getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      } else {
        paramView.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", VideoStoryPiecesPart.k(this.a).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      paramView.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.N.a());
      paramView.putExtra("VIDEO_STORY_ACTIVITY_ID", VideoStoryPiecesPart.l(this.a).getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID"));
      VideoStoryPiecesPart.m(this.a).startActivityForResult(paramView, 1025);
      return;
    }
    if ("widget".equals(VideoStoryPiecesPart.d(this.a)))
    {
      VideoStoryPiecesPart.n(this.a).b(VideoStoryPiecesPart.h(this.a));
      return;
    }
    if ("play".equals(VideoStoryPiecesPart.d(this.a)))
    {
      VideoStoryPiecesPart.o(this.a).b(393219, new Object[0]);
      ThreadManager.getUIHandler().postDelayed(new VideoStoryPiecesPart.2.1(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.2
 * JD-Core Version:    0.7.0.1
 */