import android.os.SystemClock;
import android.util.AndroidRuntimeException;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public abstract class aopa
{
  public boolean askGPS;
  protected String callerRoute;
  protected long geoCacheInterval;
  protected long globalCacheInterval;
  public boolean goonListener;
  private boolean isRemoved;
  public int level;
  protected long levelCacheInterval;
  public long maxCacheInterval;
  protected int maxFailCount = 3;
  public boolean reqLocation;
  private boolean requesting;
  public long sTime;
  public String tag;
  public boolean uiThread;
  
  public aopa(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopa
 * JD-Core Version:    0.7.0.1
 */