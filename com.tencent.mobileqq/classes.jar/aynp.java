import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aynp
  implements View.OnClickListener
{
  aynp(aynn paramaynn, ayni paramayni) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aynn.dismiss();
    if (this.jdField_a_of_type_Ayni.a != null) {
      this.jdField_a_of_type_Ayni.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynp
 * JD-Core Version:    0.7.0.1
 */