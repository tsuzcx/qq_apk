package com.tencent.camerasdk.avreport;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reporter
{
  private static final String TAG = Reporter.class.getSimpleName() + "-" + Integer.toHexString(Reporter.class.hashCode());
  private Boolean auto;
  private File dir;
  private Handler ioHandler = null;
  private HandlerThread ioThread = null;
  private Runnable uploadRunable = new Reporter.1(this);
  
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
    LogUtils.d(TAG, "report : " + paramString);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://h.trace.qq.com/kv").openConnection();
      localHttpURLConnection.setConnectTimeout(1000);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setDoInput(false);
      localHttpURLConnection.setDoOutput(true);
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      localBufferedWriter.write(paramString);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      LogUtils.d(TAG, "report: reponse code = " + localHttpURLConnection.getResponseCode());
      LogUtils.d(TAG, "report: reponse msg = " + localHttpURLConnection.getResponseMessage());
      localHttpURLConnection.disconnect();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void schedule()
  {
    if ((this.auto.booleanValue()) && (this.ioHandler != null)) {
      this.ioHandler.postDelayed(this.uploadRunable, 30000L);
    }
  }
  
  public void flush()
  {
    if (this.ioHandler != null)
    {
      this.ioHandler.removeCallbacks(this.uploadRunable);
      this.ioHandler.post(this.uploadRunable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.Reporter
 * JD-Core Version:    0.7.0.1
 */