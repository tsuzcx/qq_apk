import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.widget.ListView;

public class bhdg
  implements Animation.AnimationListener
{
  private bhdg(DraggableGridView paramDraggableGridView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < DraggableGridView.a(this.a).getChildCount())
    {
      paramAnimation = DraggableGridView.a(this.a).getChildAt(i);
      if ((paramAnimation instanceof GridView))
      {
        paramAnimation = (GridView)paramAnimation;
        int j = 0;
        while (j < paramAnimation.getChildCount())
        {
          paramAnimation.getChildAt(j).clearAnimation();
          paramAnimation.getChildAt(j).setPressed(false);
          paramAnimation.getChildAt(j).setVisibility(0);
          j += 1;
        }
      }
      i += 1;
    }
    this.a.a();
    DraggableGridView.b(this.a, false);
    DraggableGridView.c(this.a, false);
    DraggableGridView.a(this.a).notifyDataSetChanged();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdg
 * JD-Core Version:    0.7.0.1
 */