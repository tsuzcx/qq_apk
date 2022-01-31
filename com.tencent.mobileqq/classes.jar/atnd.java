import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.nearby.now.view.widget.MetaballView;

public class atnd
  extends Animation
{
  private atnd(MetaballView paramMetaballView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    MetaballView.a(this.a, paramFloat);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnd
 * JD-Core Version:    0.7.0.1
 */