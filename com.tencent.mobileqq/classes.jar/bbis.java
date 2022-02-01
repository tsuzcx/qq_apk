import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;

public class bbis
  extends Animation
{
  public bbis(CircleBarView paramCircleBarView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    CircleBarView.a(this.a, CircleBarView.a(this.a) * paramFloat * CircleBarView.b(this.a) / CircleBarView.c(this.a));
    CircleBarView.b(this.a, 30.0F);
    if (CircleBarView.a(this.a) != null)
    {
      if (CircleBarView.a(this.a) != null) {
        CircleBarView.a(this.a).setText(CircleBarView.a(this.a).a(paramFloat, CircleBarView.b(this.a), CircleBarView.c(this.a)));
      }
      CircleBarView.a(this.a).a(CircleBarView.a(this.a), paramFloat, CircleBarView.b(this.a), CircleBarView.c(this.a));
    }
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbis
 * JD-Core Version:    0.7.0.1
 */