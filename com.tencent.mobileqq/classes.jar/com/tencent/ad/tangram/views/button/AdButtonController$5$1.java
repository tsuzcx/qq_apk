package com.tencent.ad.tangram.views.button;

import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.List;

class AdButtonController$5$1
  implements Runnable
{
  AdButtonController$5$1(AdButtonController.5 param5, WeakReference paramWeakReference) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.val$view;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      AdButtonController.access$700(this.this$1.this$0).add(this.val$view);
      if (((IAdButtonView)this.val$view.get()).getButtonView() != null) {
        ((IAdButtonView)this.val$view.get()).getButtonView().setOnClickListener(AdButtonController.access$1000(this.this$1.this$0, this.this$1.val$inPlacement));
      }
      AdButtonController.access$1100(this.this$1.this$0);
      return;
    }
    AdLog.e("AdButtonController", "onViewCreated error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.5.1
 * JD-Core Version:    0.7.0.1
 */