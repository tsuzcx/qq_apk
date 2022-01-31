import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class bdtd
  extends bdtc
{
  public bdtd(SurfaceHolder paramSurfaceHolder)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtd
 * JD-Core Version:    0.7.0.1
 */