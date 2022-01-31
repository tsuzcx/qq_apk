package com.tencent.mobileqq.activity.qwallet.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class RollTextView$RollViewHandler
  extends Handler
{
  WeakReference mRootView;
  
  RollTextView$RollViewHandler(RollTextView paramRollTextView)
  {
    this.mRootView = new WeakReference(paramRollTextView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RollTextView localRollTextView = (RollTextView)this.mRootView.get();
    if (localRollTextView == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = paramMessage.getData();
      } while (localBundle == null);
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      localRollTextView.setText(localBundle.getString("content"));
    } while (RollTextView.access$000(localRollTextView) == null);
    RollTextView.access$000(localRollTextView).onRollTextChanged(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.RollTextView.RollViewHandler
 * JD-Core Version:    0.7.0.1
 */