import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;

public class bajn
  implements TypeEvaluator<PointF>
{
  public bajn(VasProfileTagView paramVasProfileTagView) {}
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    return new PointF(f1 + (paramPointF2.x - f1) * paramFloat, f2 + (paramPointF2.y - f2) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajn
 * JD-Core Version:    0.7.0.1
 */