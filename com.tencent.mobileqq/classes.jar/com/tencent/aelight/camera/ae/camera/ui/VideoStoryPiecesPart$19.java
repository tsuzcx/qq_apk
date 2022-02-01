package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import java.util.ArrayList;

class VideoStoryPiecesPart$19
  implements Runnable
{
  VideoStoryPiecesPart$19(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    if ((VideoStoryPiecesPart.ac(this.this$0) != null) && (VideoStoryPiecesPart.ac(this.this$0).getVisibility() == 0)) {
      return;
    }
    Object localObject2 = (RelativeLayout)VideoStoryPiecesPart.ae(this.this$0).findViewById(2063991385);
    if (localObject2 != null)
    {
      Object localObject1 = VideoStoryPiecesPart.af(this.this$0).getLayoutParams();
      if ((localObject1 instanceof RelativeLayout.LayoutParams))
      {
        ArrayList localArrayList = new ArrayList();
        ((RelativeLayout)localObject2).findViewsWithText(localArrayList, VideoStoryPiecesPart.ag(this.this$0).getText(AECaptureMode.GIF.textId), 1);
        if (localArrayList.size() == 1)
        {
          localObject2 = new Rect();
          ((View)localArrayList.get(0)).getGlobalVisibleRect((Rect)localObject2);
          int i = VideoStoryPiecesPart.af(this.this$0).getMeasuredWidth();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((((Rect)localObject2).left + ((Rect)localObject2).right) / 2 - i / 2);
          VideoStoryPiecesPart.af(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          VideoStoryPiecesPart.af(this.this$0).setVisibility(0);
          localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -15.0F);
          ((TranslateAnimation)localObject1).setDuration(300L);
          ((TranslateAnimation)localObject1).setRepeatCount(-1);
          ((TranslateAnimation)localObject1).setRepeatMode(2);
          VideoStoryPiecesPart.af(this.this$0).startAnimation((Animation)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.19
 * JD-Core Version:    0.7.0.1
 */