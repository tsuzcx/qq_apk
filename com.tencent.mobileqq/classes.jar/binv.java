import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.DraggableGridView;

public class binv
  implements Animation.AnimationListener
{
  public binv(DraggableGridView paramDraggableGridView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_Int, this.b);
    DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).notifyDataSetChanged();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binv
 * JD-Core Version:    0.7.0.1
 */