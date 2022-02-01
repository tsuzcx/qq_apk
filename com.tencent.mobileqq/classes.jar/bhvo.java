import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class bhvo
  extends bhvn
{
  public bhvo(SurfaceHolder paramSurfaceHolder)
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
 * Qualified Name:     bhvo
 * JD-Core Version:    0.7.0.1
 */