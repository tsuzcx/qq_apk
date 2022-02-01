import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnmj
  implements View.OnClickListener
{
  bnmj(bnmi parambnmi, bnml parambnml) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bnml.getLayoutPosition();
    bnmi.a(this.jdField_a_of_type_Bnmi).a(this.jdField_a_of_type_Bnml.itemView, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmj
 * JD-Core Version:    0.7.0.1
 */