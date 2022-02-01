import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aybi
  implements View.OnClickListener
{
  aybi(aybg paramaybg, aybb paramaybb) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aybg.dismiss();
    if (this.jdField_a_of_type_Aybb.a != null) {
      this.jdField_a_of_type_Aybb.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybi
 * JD-Core Version:    0.7.0.1
 */