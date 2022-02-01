package com.tencent.aelight.camera.ae.play;

import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;

class AEVideoShelfEditFragment$7
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEVideoShelfEditFragment$7(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, EditTextViewer paramEditTextViewer, NodeItem paramNodeItem) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.val$textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      this.val$textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$textView.getLayoutParams();
    int i = (int)(this.val$nodeItem.maskRect.left * AEVideoShelfEditFragment.access$200(this.this$0));
    int j = (int)(this.val$nodeItem.maskRect.top * AEVideoShelfEditFragment.access$300(this.this$0));
    int k = (int)((1.0F - this.val$nodeItem.maskRect.right) * AEVideoShelfEditFragment.access$200(this.this$0));
    int m = (int)((1.0F - this.val$nodeItem.maskRect.bottom) * AEVideoShelfEditFragment.access$300(this.this$0));
    localMarginLayoutParams.leftMargin = i;
    localMarginLayoutParams.topMargin = j;
    localMarginLayoutParams.rightMargin = k;
    localMarginLayoutParams.bottomMargin = m;
    localMarginLayoutParams.width = (AEVideoShelfEditFragment.access$200(this.this$0) - k - i);
    localMarginLayoutParams.height = (AEVideoShelfEditFragment.access$300(this.this$0) - m - j);
    this.val$textView.setLayoutParams(localMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.7
 * JD-Core Version:    0.7.0.1
 */