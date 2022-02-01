import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azzj
  implements View.OnClickListener
{
  azzj(azzh paramazzh, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Azzh.a != null) {
      this.jdField_a_of_type_Azzh.a.b(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzj
 * JD-Core Version:    0.7.0.1
 */