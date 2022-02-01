import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class astc
  implements View.OnClickListener
{
  astc(astb paramastb, asmu paramasmu) {}
  
  public void onClick(View paramView)
  {
    astb.a(this.jdField_a_of_type_Astb, this.jdField_a_of_type_Asmu);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astc
 * JD-Core Version:    0.7.0.1
 */