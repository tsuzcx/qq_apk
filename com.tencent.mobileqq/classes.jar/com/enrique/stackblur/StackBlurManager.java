package com.enrique.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.SystemClock;
import android.support.v8.renderscript.RSRuntimeException;
import android.util.Log;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackBlurManager
{
  static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(EXECUTOR_THREADS);
  static int EXECUTOR_THREADS = Runtime.getRuntime().availableProcessors();
  private static final String TAG = "StackBlurManager";
  private static volatile boolean hasRS = true;
  private final BlurProcess _blurProcess;
  private final Bitmap _image;
  private Bitmap _result;
  private boolean mDbg = true;
  
  public StackBlurManager(Bitmap paramBitmap)
  {
    this._image = paramBitmap;
    this._blurProcess = new JavaBlurProcess();
  }
  
  public int getExecutorThreads()
  {
    return EXECUTOR_THREADS;
  }
  
  public Bitmap getImage()
  {
    return this._image;
  }
  
  public Bitmap process(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    this._result = this._blurProcess.blur(this._image, paramInt);
    if (this.mDbg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("process: ");
      localStringBuilder.append(this._blurProcess);
      localStringBuilder.append("=");
      localStringBuilder.append(SystemClock.uptimeMillis() - l);
      localStringBuilder.append(" ms");
      Log.i("StackBlurManager", localStringBuilder.toString());
    }
    return this._result;
  }
  
  public Bitmap processNatively(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    NativeBlurProcess localNativeBlurProcess = new NativeBlurProcess();
    this._result = localNativeBlurProcess.blur(this._image, paramInt);
    if (this.mDbg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processNatively: ");
      localStringBuilder.append(localNativeBlurProcess);
      localStringBuilder.append("=");
      localStringBuilder.append(SystemClock.uptimeMillis() - l);
      localStringBuilder.append(" ms");
      Log.i("StackBlurManager", localStringBuilder.toString());
    }
    return this._result;
  }
  
  public Bitmap processRenderScript(Context paramContext, float paramFloat, int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    if (hasRS) {}
    try
    {
      paramContext = new RSBlurProcess(paramContext, paramInt);
    }
    catch (RSRuntimeException paramContext)
    {
      label24:
      StringBuilder localStringBuilder;
      break label24;
    }
    paramContext = new NativeBlurProcess();
    hasRS = false;
    break label47;
    paramContext = new NativeBlurProcess();
    label47:
    this._result = paramContext.blur(this._image, paramFloat);
    if (this.mDbg)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("processRenderScript: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("=");
      localStringBuilder.append(SystemClock.uptimeMillis() - l);
      localStringBuilder.append(" ms");
      Log.i("StackBlurManager", localStringBuilder.toString());
    }
    return this._result;
  }
  
  public Bitmap processSdkRenderScript(Context paramContext, float paramFloat)
  {
    long l = SystemClock.uptimeMillis();
    paramContext = new SdkRSBlurProcess(paramContext);
    this._result = paramContext.blur(this._image, paramFloat);
    if (this.mDbg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processSdkRenderScript: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("=");
      localStringBuilder.append(SystemClock.uptimeMillis() - l);
      localStringBuilder.append(" ms");
      Log.i("StackBlurManager", localStringBuilder.toString());
    }
    return this._result;
  }
  
  public Bitmap returnBlurredImage()
  {
    return this._result;
  }
  
  public void saveIntoFile(String paramString)
  {
    try
    {
      paramString = new FileOutputStream(paramString);
      this._result.compress(Bitmap.CompressFormat.PNG, 90, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDbg(boolean paramBoolean)
  {
    this.mDbg = paramBoolean;
  }
  
  public void setExecutorThreads(int paramInt)
  {
    EXECUTOR_THREADS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.enrique.stackblur.StackBlurManager
 * JD-Core Version:    0.7.0.1
 */