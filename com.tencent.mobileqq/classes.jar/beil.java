import android.animation.TypeEvaluator;
import android.graphics.Rect;
import com.tencent.widget.DynamicGridView;

public class beil
  implements TypeEvaluator<Rect>
{
  public beil(DynamicGridView paramDynamicGridView) {}
  
  public int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
  
  public Rect a(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    return new Rect(a(paramRect1.left, paramRect2.left, paramFloat), a(paramRect1.top, paramRect2.top, paramFloat), a(paramRect1.right, paramRect2.right, paramFloat), a(paramRect1.bottom, paramRect2.bottom, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beil
 * JD-Core Version:    0.7.0.1
 */