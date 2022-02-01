import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class bhvp
  extends bhvn
{
  public bhvp(SurfaceHolder paramSurfaceHolder)
  {
    super(paramSurfaceHolder);
  }
  
  Canvas a(SurfaceHolder paramSurfaceHolder)
  {
    return paramSurfaceHolder.lockHardwareCanvas();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvp
 * JD-Core Version:    0.7.0.1
 */