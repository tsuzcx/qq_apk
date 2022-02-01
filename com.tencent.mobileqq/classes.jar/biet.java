import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class biet
  extends bies
{
  public biet(SurfaceHolder paramSurfaceHolder)
  {
    super(paramSurfaceHolder);
  }
  
  Canvas a(SurfaceHolder paramSurfaceHolder)
  {
    return paramSurfaceHolder.lockCanvas();
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biet
 * JD-Core Version:    0.7.0.1
 */