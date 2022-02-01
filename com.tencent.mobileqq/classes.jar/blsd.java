import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blsd
  implements View.OnClickListener
{
  blsd(blsc paramblsc, blsf paramblsf) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Blsf.getLayoutPosition();
    blsc.a(this.jdField_a_of_type_Blsc).a(this.jdField_a_of_type_Blsf.itemView, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsd
 * JD-Core Version:    0.7.0.1
 */