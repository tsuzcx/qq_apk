package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class WSVerticalItemBottomCommentController$6
  implements PAGView.PAGViewListener
{
  WSVerticalItemBottomCommentController$6(WSVerticalItemBottomCommentController paramWSVerticalItemBottomCommentController, PAGView.PAGViewListener paramPAGViewListener) {}
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    PAGView.PAGViewListener localPAGViewListener = this.a;
    if (localPAGViewListener != null) {
      localPAGViewListener.onAnimationCancel(paramPAGView);
    }
    paramPAGView.removeListener(this);
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    PAGView.PAGViewListener localPAGViewListener = this.a;
    if (localPAGViewListener != null) {
      localPAGViewListener.onAnimationEnd(paramPAGView);
    }
    paramPAGView.removeListener(this);
  }
  
  public void onAnimationRepeat(PAGView paramPAGView)
  {
    PAGView.PAGViewListener localPAGViewListener = this.a;
    if (localPAGViewListener != null) {
      localPAGViewListener.onAnimationRepeat(paramPAGView);
    }
  }
  
  public void onAnimationStart(PAGView paramPAGView)
  {
    PAGView.PAGViewListener localPAGViewListener = this.a;
    if (localPAGViewListener != null) {
      localPAGViewListener.onAnimationStart(paramPAGView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCommentController.6
 * JD-Core Version:    0.7.0.1
 */