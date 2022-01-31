import android.view.View;
import android.view.animation.Animation;
import com.tencent.qqmini.sdk.core.widget.media.danmu.BarrageView;
import java.util.Set;

public class beon
  extends beoo
{
  public beon(BarrageView paramBarrageView, View paramView)
  {
    super(paramBarrageView, paramView, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    BarrageView.a(this.a).remove(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beon
 * JD-Core Version:    0.7.0.1
 */