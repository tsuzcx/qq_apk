package com.tencent.gdtad.views.videoimax;

import acqy;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

final class TransitionContext$MyResultReceiver
  extends ResultReceiver
{
  private WeakReference<TransitionContext> a;
  
  public TransitionContext$MyResultReceiver(Handler paramHandler, TransitionContext paramTransitionContext)
  {
    super(paramHandler);
    this.a = new WeakReference(paramTransitionContext);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    acqy.a("TransitionContext", "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    TransitionContext localTransitionContext = (TransitionContext)this.a.get();
    if (localTransitionContext != null)
    {
      if (paramInt != 2) {
        break label73;
      }
      TransitionContext.a(localTransitionContext, TransitionContext.a(localTransitionContext));
    }
    label73:
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      TransitionContext.a(localTransitionContext, true);
      paramBundle.setClassLoader(GdtVideoImaxFragment.MyResultReceiver.class.getClassLoader());
      TransitionContext.a(localTransitionContext, (ResultReceiver)paramBundle.getParcelable("callback"));
    } while (!TransitionContext.a(localTransitionContext));
    TransitionContext.a(localTransitionContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.TransitionContext.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */