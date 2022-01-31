package com.tencent.gdtad.views.videoimax;

import aanp;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public class GdtVideoImaxFragment$MyResultReceiver
  extends ResultReceiver
{
  private WeakReference<GdtVideoImaxFragment> a;
  
  public GdtVideoImaxFragment$MyResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a(GdtVideoImaxFragment paramGdtVideoImaxFragment)
  {
    this.a = new WeakReference(paramGdtVideoImaxFragment);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    aanp.a("GdtVideoImaxFragment", "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    paramBundle = (GdtVideoImaxFragment)this.a.get();
    if ((paramBundle != null) && (paramInt == 1)) {
      GdtVideoImaxFragment.c(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */