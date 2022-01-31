import android.os.Build.VERSION;
import android.view.Surface;

public abstract interface bgnj
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
  
  public abstract void setOnBufferingUpdateListener(bgnk parambgnk);
  
  public abstract void setOnCompletionListener(bgnl parambgnl);
  
  public abstract void setOnErrorListener(bgnm parambgnm);
  
  public abstract void setOnPreparedListener(bgnp parambgnp);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnj
 * JD-Core Version:    0.7.0.1
 */