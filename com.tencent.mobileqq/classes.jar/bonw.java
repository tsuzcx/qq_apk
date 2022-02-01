import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bonw
  implements View.OnClickListener
{
  bonw(bonv parambonv, bony parambony) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bony.getLayoutPosition();
    bonv.a(this.jdField_a_of_type_Bonv).a(this.jdField_a_of_type_Bony.itemView, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonw
 * JD-Core Version:    0.7.0.1
 */