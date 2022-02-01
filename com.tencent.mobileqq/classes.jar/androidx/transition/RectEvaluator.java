package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class RectEvaluator
  implements TypeEvaluator<Rect>
{
  private Rect mRect;
  
  RectEvaluator() {}
  
  RectEvaluator(Rect paramRect)
  {
    this.mRect = paramRect;
  }
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    int i = paramRect1.left + (int)((paramRect2.left - paramRect1.left) * paramFloat);
    int j = paramRect1.top + (int)((paramRect2.top - paramRect1.top) * paramFloat);
    int k = paramRect1.right + (int)((paramRect2.right - paramRect1.right) * paramFloat);
    int m = paramRect1.bottom + (int)((paramRect2.bottom - paramRect1.bottom) * paramFloat);
    paramRect1 = this.mRect;
    if (paramRect1 == null) {
      return new Rect(i, j, k, m);
    }
    paramRect1.set(i, j, k, m);
    return this.mRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.RectEvaluator
 * JD-Core Version:    0.7.0.1
 */