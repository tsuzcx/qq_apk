import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class apcs
{
  public static apcw a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new apcy((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new apcz((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcs
 * JD-Core Version:    0.7.0.1
 */