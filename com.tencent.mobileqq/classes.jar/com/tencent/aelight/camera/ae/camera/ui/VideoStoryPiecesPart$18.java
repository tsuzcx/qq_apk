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

class VideoStoryPiecesPart$18
  implements Runnable
{
  VideoStoryPiecesPart$18(VideoStoryPiecesPart paramVideoStoryPiecesPart, String paramString1, String paramString2) {}
  
  public void run()
  {
    VideoStoryPiecesPart.F(this.this$0);
    VideoStoryPiecesPart.aa(this.this$0);
    Object localObject2 = (RelativeLayout)VideoStoryPiecesPart.ab(this.this$0).findViewById(2063991385);
    if (localObject2 != null)
    {
      Object localObject1 = VideoStoryPiecesPart.ac(this.this$0).getLayoutParams();
      if ((localObject1 instanceof RelativeLayout.LayoutParams))
      {
        int i;
        if (AECaptureMode.NORMAL.name.equals(this.a)) {
          i = AECaptureMode.NORMAL.textId;
        } else if (AECaptureMode.PLAY.name.equals(this.a)) {
          i = AECaptureMode.PLAY.textId;
        } else if (AECaptureMode.GIF.name.equals(this.a)) {
          i = AECaptureMode.GIF.textId;
        } else {
          i = -1;
        }
        if (i == -1) {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        ((RelativeLayout)localObject2).findViewsWithText(localArrayList, VideoStoryPiecesPart.ad(this.this$0).getText(i), 1);
        if (localArrayList.size() == 1)
        {
          localObject2 = new Rect();
          ((View)localArrayList.get(0)).getGlobalVisibleRect((Rect)localObject2);
          i = VideoStoryPiecesPart.ac(this.this$0).getMeasuredWidth();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((((Rect)localObject2).left + ((Rect)localObject2).right) / 2 - i / 2);
          VideoStoryPiecesPart.ac(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          VideoStoryPiecesPart.ac(this.this$0).setText(this.b);
          VideoStoryPiecesPart.ac(this.this$0).setVisibility(0);
          localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -15.0F);
          ((TranslateAnimation)localObject1).setDuration(300L);
          ((TranslateAnimation)localObject1).setRepeatCount(-1);
          ((TranslateAnimation)localObject1).setRepeatMode(2);
          VideoStoryPiecesPart.ac(this.this$0).startAnimation((Animation)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.18
 * JD-Core Version:    0.7.0.1
 */