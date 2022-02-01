package com.tencent.aelight.camera.ae.play;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;

class AEVideoShelfEditFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEVideoShelfEditFragment$1(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AEVideoShelfEditFragment.access$000(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      AEVideoShelfEditFragment.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    double d2 = 0.0D;
    double d1 = d2;
    if (AEVideoShelfEditFragment.access$100(this.this$0) != null)
    {
      d1 = d2;
      if (AEVideoShelfEditFragment.access$100(this.this$0).getVideoHeight() != 0)
      {
        d1 = AEVideoShelfEditFragment.access$100(this.this$0).getVideoWidth();
        d2 = AEVideoShelfEditFragment.access$100(this.this$0).getVideoHeight();
        Double.isNaN(d1);
        Double.isNaN(d2);
        d2 = d1 / d2;
        d1 = d2;
        if (d2 >= 1.0D)
        {
          i = 1;
          d1 = d2;
          break label125;
        }
      }
    }
    int i = 0;
    label125:
    Object localObject;
    if (i != 0)
    {
      if (d1 < 3.0D)
      {
        d2 = AEVideoShelfEditFragment.access$000(this.this$0).getWidth();
        Double.isNaN(d2);
        i = (int)(d2 / d1);
        localObject = (ViewGroup.MarginLayoutParams)AEVideoShelfEditFragment.access$000(this.this$0).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).height = i;
        AEVideoShelfEditFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        AEVideoShelfEditFragment localAEVideoShelfEditFragment = this.this$0;
        AEVideoShelfEditFragment.access$202(localAEVideoShelfEditFragment, AEVideoShelfEditFragment.access$000(localAEVideoShelfEditFragment).getWidth());
        AEVideoShelfEditFragment.access$302(this.this$0, ((ViewGroup.MarginLayoutParams)localObject).height);
      }
    }
    else if (d1 > 0.3333333333333333D)
    {
      d2 = AEVideoShelfEditFragment.access$000(this.this$0).getHeight();
      Double.isNaN(d2);
      i = (int)(d2 * d1);
      localObject = AEVideoShelfEditFragment.access$000(this.this$0).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i;
      AEVideoShelfEditFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      AEVideoShelfEditFragment.access$202(this.this$0, ((ViewGroup.LayoutParams)localObject).width);
      localObject = this.this$0;
      AEVideoShelfEditFragment.access$302((AEVideoShelfEditFragment)localObject, AEVideoShelfEditFragment.access$000((AEVideoShelfEditFragment)localObject).getHeight());
    }
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "centerView onGlobalLayout: ratio=", Double.valueOf(d1), ", wxh=", Integer.valueOf(AEVideoShelfEditFragment.access$200(this.this$0)), "x", Integer.valueOf(AEVideoShelfEditFragment.access$300(this.this$0)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.1
 * JD-Core Version:    0.7.0.1
 */