package com.tencent.aelight.camera.ae.camera.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;

class VideoStoryPiecesPart$17
  implements Runnable
{
  VideoStoryPiecesPart$17(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    View localView = VideoStoryPiecesPart.Y(this.this$0).findViewById(2063990903);
    if (localView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = VideoStoryPiecesPart.Z(this.this$0).getLayoutParams();
      if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
      {
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        int i = VideoStoryPiecesPart.Z(this.this$0).getMeasuredWidth();
        ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = ((localRect.left + localRect.right) / 2 - i / 2);
        VideoStoryPiecesPart.Z(this.this$0).setLayoutParams(localLayoutParams);
        VideoStoryPiecesPart.Z(this.this$0).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.17
 * JD-Core Version:    0.7.0.1
 */