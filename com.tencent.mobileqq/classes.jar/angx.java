import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class angx
{
  public static anhb a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new anhd((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new anhe((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     angx
 * JD-Core Version:    0.7.0.1
 */