import android.os.IInterface;

public abstract interface behq
  extends IInterface
{
  public abstract void beginSwitch();
  
  public abstract void doSwitch(String paramString1, String paramString2);
  
  public abstract void onProgress(long paramLong1, long paramLong2);
  
  public abstract void postSwitch(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behq
 * JD-Core Version:    0.7.0.1
 */