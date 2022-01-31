import android.os.Build.VERSION;
import android.view.Surface;

public abstract interface bgrq
{
  public static final boolean a;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 23)) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setOnBufferingUpdateListener(bgrr parambgrr);
  
  public abstract void setOnCompletionListener(bgrs parambgrs);
  
  public abstract void setOnErrorListener(bgrt parambgrt);
  
  public abstract void setOnPreparedListener(bgrw parambgrw);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrq
 * JD-Core Version:    0.7.0.1
 */