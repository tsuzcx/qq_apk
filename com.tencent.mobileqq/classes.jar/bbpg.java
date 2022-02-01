import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbpg
  implements View.OnClickListener
{
  bbpg(bbpf parambbpf, bbmy parambbmy) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbmy.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpg
 * JD-Core Version:    0.7.0.1
 */