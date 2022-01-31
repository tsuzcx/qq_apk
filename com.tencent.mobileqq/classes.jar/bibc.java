import android.graphics.drawable.Drawable;

public abstract class bibc
{
  public volatile int mCount;
  
  public abstract void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable);
  
  public abstract void onFailed(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibc
 * JD-Core Version:    0.7.0.1
 */