import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bngf
  implements View.OnClickListener
{
  bngf(bngd parambngd, int paramInt, bnfk parambnfk) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Bngd.b()) {
      bngd.a(this.jdField_a_of_type_Bngd, this.jdField_a_of_type_Int, this.jdField_a_of_type_Bnfk);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngf
 * JD-Core Version:    0.7.0.1
 */