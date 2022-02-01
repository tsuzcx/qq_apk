import android.animation.TypeEvaluator;
import android.graphics.Rect;

class bmoh
  implements TypeEvaluator<Rect>
{
  private Rect a;
  
  bmoh() {}
  
  bmoh(Rect paramRect)
  {
    this.a = paramRect;
  }
  
  public Rect a(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    int i = paramRect1.left;
    i = (int)((paramRect2.left - paramRect1.left) * paramFloat) + i;
    int j = paramRect1.top;
    j = (int)((paramRect2.top - paramRect1.top) * paramFloat) + j;
    int k = paramRect1.right;
    k = (int)((paramRect2.right - paramRect1.right) * paramFloat) + k;
    int m = paramRect1.bottom;
    m = (int)((paramRect2.bottom - paramRect1.bottom) * paramFloat) + m;
    if (this.a == null) {
      return new Rect(i, j, k, m);
    }
    this.a.set(i, j, k, m);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoh
 * JD-Core Version:    0.7.0.1
 */