package com.tencent.aelight.camera.ae.camera.ui;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.view.AECompoundButton;

class VideoStoryPiecesPart$4
  implements Runnable
{
  VideoStoryPiecesPart$4(VideoStoryPiecesPart paramVideoStoryPiecesPart, String paramString) {}
  
  public void run()
  {
    if ((AECameraEntryManager.f(VideoStoryPiecesPart.a(this.this$0))) && (!TextUtils.isEmpty(this.a)) && (VideoStoryPiecesPart.a(this.this$0)) && (VideoStoryPiecesPart.b(this.this$0)))
    {
      VideoStoryPiecesPart.a(this.this$0);
      return;
    }
    VideoStoryPiecesPart.a(this.this$0).a().setImageResource(2064056405);
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)VideoStoryPiecesPart.a(this.this$0).a().getDrawable();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.4
 * JD-Core Version:    0.7.0.1
 */