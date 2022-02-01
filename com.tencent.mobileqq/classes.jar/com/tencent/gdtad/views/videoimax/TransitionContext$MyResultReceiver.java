package com.tencent.gdtad.views.videoimax;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.gdtad.log.GdtLog;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveResult() called with: resultCode = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], resultData = [");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("TransitionContext", ((StringBuilder)localObject).toString());
    localObject = (TransitionContext)this.a.get();
    if (localObject != null)
    {
      if (paramInt == 2)
      {
        TransitionContext.a((TransitionContext)localObject, TransitionContext.a((TransitionContext)localObject));
        return;
      }
      if (paramInt == 0)
      {
        TransitionContext.a((TransitionContext)localObject, true);
        paramBundle.setClassLoader(GdtVideoImaxFragment.MyResultReceiver.class.getClassLoader());
        TransitionContext.a((TransitionContext)localObject, (ResultReceiver)paramBundle.getParcelable("callback"));
        if (TransitionContext.b((TransitionContext)localObject)) {
          TransitionContext.c((TransitionContext)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.TransitionContext.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */