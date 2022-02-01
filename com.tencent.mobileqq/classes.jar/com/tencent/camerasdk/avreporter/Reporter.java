package com.tencent.camerasdk.avreporter;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reporter
{
  private static final String TAG;
  private Boolean auto;
  private File dir;
  private Handler ioHandler = null;
  private HandlerThread ioThread = null;
  private Runnable uploadRunable = new Reporter.1(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Reporter.class.getSimpleName());
    localStringBuilder.append("-");
    localStringBuilder.append(Integer.toHexString(Reporter.class.hashCode()));
    TAG = localStringBuilder.toString();
  }
  
  public Reporter(File paramFile, Boolean paramBoolean)
  {
    this.dir = paramFile;
    this.auto = paramBoolean;
    this.ioThread = new HandlerThread(TAG);
    this.ioThread.setDaemon(true);
    this.ioThread.start();
    while (!this.ioThread.isAlive()) {}
    this.ioHandler = new Handler(this.ioThread.getLooper());
    schedule();
  }
  
  private void report(String paramString)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("report : ");
    ((StringBuilder)localObject2).append(paramString);
    LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = (HttpURLConnection)new URL("https://h.trace.qq.com/kv").openConnection();
      ((HttpURLConnection)localObject1).setConnectTimeout(1000);
      ((HttpURLConnection)localObject1).setRequestMethod("POST");
      ((HttpURLConnection)localObject1).setDoInput(false);
      ((HttpURLConnection)localObject1).setDoOutput(true);
      localObject2 = new BufferedWriter(new OutputStreamWriter(((HttpURLConnection)localObject1).getOutputStream(), "UTF-8"));
      ((BufferedWriter)localObject2).write(paramString);
      ((BufferedWriter)localObject2).flush();
      ((BufferedWriter)localObject2).close();
      paramString = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("report: reponse code = ");
      ((StringBuilder)localObject2).append(((HttpURLConnection)localObject1).getResponseCode());
      LogUtils.d(paramString, ((StringBuilder)localObject2).toString());
      paramString = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("report: reponse msg = ");
      ((StringBuilder)localObject2).append(((HttpURLConnection)localObject1).getResponseMessage());
      LogUtils.d(paramString, ((StringBuilder)localObject2).toString());
      ((HttpURLConnection)localObject1).disconnect();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void schedule()
  {
    if (this.auto.booleanValue())
    {
      Handler localHandler = this.ioHandler;
      if (localHandler != null) {
        localHandler.postDelayed(this.uploadRunable, 30000L);
      }
    }
  }
  
  public void flush()
  {
    Handler localHandler = this.ioHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.uploadRunable);
      this.ioHandler.post(this.uploadRunable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.Reporter
 * JD-Core Version:    0.7.0.1
 */