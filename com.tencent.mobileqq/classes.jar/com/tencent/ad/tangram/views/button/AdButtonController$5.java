package com.tencent.ad.tangram.views.button;

import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

class AdButtonController$5
  implements IAdButtonView.a
{
  AdButtonController$5(AdButtonController paramAdButtonController, boolean paramBoolean) {}
  
  public void onViewCreated(WeakReference<IAdButtonView> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new AdButtonController.5.1(this, paramWeakReference), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.5
 * JD-Core Version:    0.7.0.1
 */