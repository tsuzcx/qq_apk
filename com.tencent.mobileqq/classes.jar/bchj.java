import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;

class bchj
  implements View.OnTouchListener
{
  bchj(bchh parambchh, View paramView1, View paramView2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {}
    for (int i = 1; (paramMotionEvent.getAction() == 4) && (AtPanelTouchController.a(this.b, paramMotionEvent)) && ((i == 0) || ((i != 0) && (!AtPanelTouchController.a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent)))); i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchj
 * JD-Core Version:    0.7.0.1
 */