package com.tencent.imsdk.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class IMContext
{
  private static final String TAG = "IMContext";
  private Context mContext;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  public static IMContext getInstance()
  {
    return IMContext.Holder.instance;
  }
  
  public Context getApplicationContext()
  {
    return this.mContext;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void runOnMainThread(Runnable paramRunnable)
  {
    this.mMainHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.IMContext
 * JD-Core Version:    0.7.0.1
 */