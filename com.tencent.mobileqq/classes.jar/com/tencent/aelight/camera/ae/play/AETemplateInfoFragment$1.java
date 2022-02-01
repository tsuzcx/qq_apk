package com.tencent.aelight.camera.ae.play;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;

class AETemplateInfoFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AETemplateInfoFragment$1(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AETemplateInfoFragment.access$000(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      AETemplateInfoFragment.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    if (AETemplateInfoFragment.access$100(this.this$0) == null) {
      return;
    }
    if (AETemplateInfoFragment.access$100(this.this$0).getVideoHeight() != 0)
    {
      if (AETemplateInfoFragment.access$100(this.this$0).getVideoWidth() == 0) {
        return;
      }
      float f1 = AETemplateInfoFragment.access$100(this.this$0).getVideoWidth() / AETemplateInfoFragment.access$100(this.this$0).getVideoHeight();
      int i = AETemplateInfoFragment.access$000(this.this$0).getWidth();
      int j = AETemplateInfoFragment.access$000(this.this$0).getHeight();
      float f2 = i / j;
      Object localObject;
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" video aspectRation(w/h)=");
        ((StringBuilder)localObject).append(f1);
        QLog.d("AETemplateInfoFragment", 2, new Object[] { "adjust player size---origin w:h=", Integer.valueOf(i), ":", Integer.valueOf(j), " availableRatio(w/h)=", Float.valueOf(f2), ((StringBuilder)localObject).toString() });
      }
      double d1;
      double d2;
      if (f1 < f2)
      {
        d1 = AETemplateInfoFragment.access$000(this.this$0).getHeight();
        d2 = f1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        i = (int)(d1 * d2);
        localObject = AETemplateInfoFragment.access$000(this.this$0).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = i;
        AETemplateInfoFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      if (f1 > f2)
      {
        d1 = AETemplateInfoFragment.access$000(this.this$0).getWidth();
        d2 = f1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        i = (int)(d1 / d2);
        localObject = (ViewGroup.MarginLayoutParams)AETemplateInfoFragment.access$000(this.this$0).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).height = i;
        AETemplateInfoFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.1
 * JD-Core Version:    0.7.0.1
 */