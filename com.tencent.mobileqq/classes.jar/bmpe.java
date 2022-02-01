import android.graphics.drawable.Drawable;

public abstract class bmpe
{
  public volatile int mCount;
  
  public abstract void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable);
  
  public abstract void onFailed(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpe
 * JD-Core Version:    0.7.0.1
 */