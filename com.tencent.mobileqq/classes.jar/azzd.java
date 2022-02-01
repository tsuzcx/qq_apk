import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azzd
  implements View.OnClickListener
{
  azzd(azzb paramazzb, TextView paramTextView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    bhoy.a(paramView.getContext(), bhou.b(this.jdField_a_of_type_Int), bhou.c(this.jdField_a_of_type_Int), 3, false, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzd
 * JD-Core Version:    0.7.0.1
 */