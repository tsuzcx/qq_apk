package androidx.transition;

import android.graphics.PointF;
import android.util.Property;

final class ChangeTransform$2
  extends Property<ChangeTransform.PathAnimatorMatrix, PointF>
{
  ChangeTransform$2(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(ChangeTransform.PathAnimatorMatrix paramPathAnimatorMatrix)
  {
    return null;
  }
  
  public void set(ChangeTransform.PathAnimatorMatrix paramPathAnimatorMatrix, PointF paramPointF)
  {
    paramPathAnimatorMatrix.setTranslation(paramPointF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeTransform.2
 * JD-Core Version:    0.7.0.1
 */