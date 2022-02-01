import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbqx
  implements View.OnClickListener
{
  bbqx(bbqr parambbqr, bbnu parambbnu, bbwe parambbwe) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbnu.a(this.jdField_a_of_type_Bbwe.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqx
 * JD-Core Version:    0.7.0.1
 */