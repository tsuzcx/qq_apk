package com.tencent.mobileqq.activity.qwallet.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class ToPayManagerImpl$5
  extends ResultReceiver
{
  ToPayManagerImpl$5(Handler paramHandler, WeakReference paramWeakReference, ResultReceiver paramResultReceiver, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 99999) {}
    BaseActivity localBaseActivity;
    do
    {
      return;
      localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseActivity == null) || (localBaseActivity.isFinishing()));
    localBaseActivity.runOnUiThread(new ToPayManagerImpl.5.1(this, paramInt, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */