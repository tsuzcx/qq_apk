package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import mqq.util.WeakReference;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class WSVerticalVideoOperationRightItemView$WSPAGViewListener
  implements PAGView.PAGViewListener
{
  private final WeakReference<WSVerticalVideoOperationRightItemView> a;
  
  public WSVerticalVideoOperationRightItemView$WSPAGViewListener(WSVerticalVideoOperationRightItemView paramWSVerticalVideoOperationRightItemView)
  {
    this.a = new WeakReference(paramWSVerticalVideoOperationRightItemView);
  }
  
  public void onAnimationCancel(PAGView paramPAGView) {}
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    int i = WSCommentAtHelper.a.d();
    if (i < 0) {
      return;
    }
    paramPAGView = (WSVerticalVideoOperationRightItemView)this.a.get();
    if (paramPAGView != null) {
      WSVerticalVideoOperationRightItemView.d(paramPAGView).postDelayed(new WSVerticalVideoOperationRightItemView.WSPAGViewListener.1(this), i * 1000);
    }
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView.WSPAGViewListener
 * JD-Core Version:    0.7.0.1
 */