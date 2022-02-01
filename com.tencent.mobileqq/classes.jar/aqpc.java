import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class aqpc
{
  public static aqpg a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new aqpi((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new aqpj((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpc
 * JD-Core Version:    0.7.0.1
 */