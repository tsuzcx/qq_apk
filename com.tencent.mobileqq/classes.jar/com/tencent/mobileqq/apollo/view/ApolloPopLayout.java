package com.tencent.mobileqq.apollo.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.qphone.base.util.QLog;

public class ApolloPopLayout
  extends FrameLayout
{
  public ApolloPopLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ApolloPopLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsStateActivity", 2, "back down");
      }
      if (((super.getContext() instanceof ApolloGuestsStateActivity)) && (!((ApolloGuestsStateActivity)super.getContext()).isFinishing())) {
        ((Activity)super.getContext()).onBackPressed();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPopLayout
 * JD-Core Version:    0.7.0.1
 */