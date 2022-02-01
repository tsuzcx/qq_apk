import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class babp
  implements View.OnClickListener
{
  babp(babn parambabn, View paramView) {}
  
  public void onClick(View paramView)
  {
    azru.a().b(babn.i(this.jdField_a_of_type_Babn));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babp
 * JD-Core Version:    0.7.0.1
 */