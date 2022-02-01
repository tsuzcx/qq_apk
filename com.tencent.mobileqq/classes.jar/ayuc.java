import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayuc
  implements View.OnClickListener
{
  ayuc(ayua paramayua, aytv paramaytv) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ayua.dismiss();
    if (this.jdField_a_of_type_Aytv.a != null) {
      this.jdField_a_of_type_Aytv.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuc
 * JD-Core Version:    0.7.0.1
 */