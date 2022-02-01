package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.annotation.RequiresApi;
import mqq.util.WeakReference;

class AETipsViewController$TipsHandler
  extends Handler
{
  private final WeakReference<AETipsViewController> a;
  
  public AETipsViewController$TipsHandler(AETipsViewController paramAETipsViewController)
  {
    this.a = new WeakReference(paramAETipsViewController);
  }
  
  @RequiresApi(api=17)
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.get() != null) && (AETipsViewController.a((AETipsViewController)this.a.get()).getContext() == null) && ((AETipsViewController.a((AETipsViewController)this.a.get()).getContext() instanceof Activity)) && (!((Activity)AETipsViewController.a((AETipsViewController)this.a.get()).getContext()).isFinishing()) && (!((Activity)AETipsViewController.a((AETipsViewController)this.a.get()).getContext()).isDestroyed()))
    {
      int i = paramMessage.what;
      if ((i != 1004) && (i != 1009))
      {
        if (i != 1018) {
          return;
        }
        ((AETipsViewController)this.a.get()).b();
        return;
      }
      AETipsViewController.b((AETipsViewController)this.a.get());
      return;
    }
    removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController.TipsHandler
 * JD-Core Version:    0.7.0.1
 */