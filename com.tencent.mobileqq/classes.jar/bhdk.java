import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.widget.ListView;

public class bhdk
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private boolean jdField_a_of_type_Boolean;
  private Point b;
  
  public bhdk(DraggableGridView paramDraggableGridView, Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramPoint1);
    this.b = new Point(paramPoint2);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 0;
    DraggableGridView.b(paramDraggableGridView, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = this.jdField_a_of_type_Int - 1;
    this.jdField_a_of_type_Int = i;
    if (i <= 0)
    {
      i = 0;
      while (i < DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).getChildCount())
      {
        paramAnimation = DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).getChildAt(i);
        if ((paramAnimation instanceof MeasureGridView))
        {
          paramAnimation = (GridView)paramAnimation;
          int j = 0;
          if (j < paramAnimation.getChildCount())
          {
            paramAnimation.getChildAt(j).clearAnimation();
            if ((((Integer)paramAnimation.getTag()).intValue() == DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).y) && (j == DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).x) && (!this.jdField_a_of_type_Boolean)) {
              paramAnimation.getChildAt(j).setVisibility(4);
            }
            for (;;)
            {
              j += 1;
              break;
              paramAnimation.getChildAt(j).setVisibility(0);
            }
          }
        }
        i += 1;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label216;
      }
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_AndroidGraphicsPoint.y, this.jdField_a_of_type_AndroidGraphicsPoint.x);
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).set(-1, -1);
    }
    for (;;)
    {
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).notifyDataSetChanged();
      DraggableGridView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, false);
      return;
      label216:
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_AndroidGraphicsPoint.y, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.b.y, this.b.x);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdk
 * JD-Core Version:    0.7.0.1
 */