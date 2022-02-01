package com.tencent.mobileqq.app.soso;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;

public abstract class SosoInterface$OnLocationListener
{
  protected boolean askGPS;
  protected String callerRoute;
  protected long geoCacheInterval;
  protected long globalCacheInterval;
  protected boolean goonListener;
  private boolean isRemoved;
  protected int level;
  protected long levelCacheInterval;
  protected long maxCacheInterval;
  protected int maxFailCount = 3;
  protected boolean reqLocation;
  private boolean requesting;
  protected long sTime;
  protected String tag;
  protected boolean uiThread;
  
  public SosoInterface$OnLocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      this.tag = paramString;
      this.level = paramInt;
      this.askGPS = paramBoolean2;
      this.reqLocation = paramBoolean1;
      this.goonListener = paramBoolean4;
      this.uiThread = paramBoolean3;
      this.maxCacheInterval = paramLong;
      this.sTime = SystemClock.elapsedRealtime();
      return;
    }
    throw new AndroidRuntimeException("invalid level=" + paramInt);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2) {}
  
  public abstract void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener
 * JD-Core Version:    0.7.0.1
 */