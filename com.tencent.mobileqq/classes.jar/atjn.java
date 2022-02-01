import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;

class atjn
  implements View.OnClickListener
{
  atjn(atjm paramatjm, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (atjm.a(this.jdField_a_of_type_Atjm).c(this.jdField_a_of_type_Int)) {
      atjm.a(this.jdField_a_of_type_Atjm).b(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      atjm.a(this.jdField_a_of_type_Atjm).a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjn
 * JD-Core Version:    0.7.0.1
 */