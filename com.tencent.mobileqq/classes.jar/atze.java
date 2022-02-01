import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atze
  implements View.OnClickListener
{
  atze(atzb paramatzb) {}
  
  public void onClick(View paramView)
  {
    auea.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Atxa.d());
    this.a.b = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atze
 * JD-Core Version:    0.7.0.1
 */