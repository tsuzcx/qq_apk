import android.animation.ValueAnimator;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class bmtb
  extends bmop
{
  public bmtb(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    wsv.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtb
 * JD-Core Version:    0.7.0.1
 */