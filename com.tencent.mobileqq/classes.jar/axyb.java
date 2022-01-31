import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;

class axyb
  implements acui
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  boolean jdField_a_of_type_Boolean;
  TextView b;
  
  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = this.a.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (ColorFilter localColorFilter = null;; localColorFilter = BaseBubbleBuilder.a)
    {
      localDrawable.setColorFilter(localColorFilter);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 1: 
    case 3: 
      do
      {
        return;
        paramView = this.a.getBackground();
      } while (paramView == null);
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
      return;
    }
    a(false);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyb
 * JD-Core Version:    0.7.0.1
 */