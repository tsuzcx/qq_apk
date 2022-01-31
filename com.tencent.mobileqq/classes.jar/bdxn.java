import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class bdxn
  extends bdxl
{
  public bdxn(SurfaceHolder paramSurfaceHolder)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxn
 * JD-Core Version:    0.7.0.1
 */