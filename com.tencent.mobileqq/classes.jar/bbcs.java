import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbcs
  implements View.OnClickListener
{
  bbcs(bbcm parambbcm, bazp parambazp, bbhz parambbhz) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bazp.a(this.jdField_a_of_type_Bbhz.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcs
 * JD-Core Version:    0.7.0.1
 */