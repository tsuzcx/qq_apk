import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class anhc
{
  public static anhg a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new anhi((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new anhj((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhc
 * JD-Core Version:    0.7.0.1
 */