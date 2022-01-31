import android.animation.ValueAnimator;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class bmxn
  extends bmtb
{
  public bmxn(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    wxe.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxn
 * JD-Core Version:    0.7.0.1
 */