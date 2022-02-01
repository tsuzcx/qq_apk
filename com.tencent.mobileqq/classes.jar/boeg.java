import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import androidx.annotation.RequiresApi;

final class boeg
  extends Property<View, Rect>
{
  boeg(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  @RequiresApi(api=18)
  public Rect a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.getClipBounds();
    }
    return new Rect();
  }
  
  @RequiresApi(api=18)
  public void a(View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.setClipBounds(paramRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boeg
 * JD-Core Version:    0.7.0.1
 */