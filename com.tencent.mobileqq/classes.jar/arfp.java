import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class arfp
{
  public static arft a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new arfv((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new arfw((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfp
 * JD-Core Version:    0.7.0.1
 */