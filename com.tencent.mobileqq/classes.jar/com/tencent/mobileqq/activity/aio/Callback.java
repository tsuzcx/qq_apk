package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.mobileqq.transfile.FileMsg;

public abstract interface Callback
{
  public abstract void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.Callback
 * JD-Core Version:    0.7.0.1
 */