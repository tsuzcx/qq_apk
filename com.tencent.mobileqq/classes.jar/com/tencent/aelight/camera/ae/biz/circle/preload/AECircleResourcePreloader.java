package com.tencent.aelight.camera.ae.biz.circle.preload;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.aelight.camera.log.AEQLog;

public class AECircleResourcePreloader
{
  private static final Object b = new Object();
  private static AECircleResourcePreloader c;
  public volatile boolean a = false;
  private boolean d;
  
  public static AECircleResourcePreloader a()
  {
    if (c == null) {
      synchronized (b)
      {
        if (c == null) {
          c = new AECircleResourcePreloader();
        }
      }
    }
    return c;
  }
  
  public void a(Context paramContext)
  {
    AEQLog.a("[Performance2]AECircleResourcePreloader", "loadAEPhotoListContentView... ");
    long l = System.currentTimeMillis();
    if (!this.a)
    {
      if (b()) {
        return;
      }
      AEQLog.a("[Performance2]AECircleResourcePreloader", "loadAEPhotoListContentView... create");
      try
      {
        LayoutInflater.from(paramContext).inflate(2064056361, null);
        LayoutInflater.from(paramContext).inflate(2064056490, null);
        LayoutInflater.from(paramContext).inflate(2064056394, null);
        LayoutInflater.from(paramContext).inflate(2064056377, null);
        this.d = true;
      }
      catch (Throwable paramContext)
      {
        AEQLog.a("[Performance2]AECircleResourcePreloader", "exception:", paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("loadAEPhotoListContentView... cost:");
      paramContext.append(System.currentTimeMillis() - l);
      AEQLog.a("[Performance2]AECircleResourcePreloader", paramContext.toString());
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.preload.AECircleResourcePreloader
 * JD-Core Version:    0.7.0.1
 */