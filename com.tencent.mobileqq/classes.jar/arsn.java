import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class arsn
{
  public static arsr a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new arst((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new arsu((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsn
 * JD-Core Version:    0.7.0.1
 */