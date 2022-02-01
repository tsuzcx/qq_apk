import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blmq
  implements View.OnClickListener
{
  blmq(blmi paramblmi, bllo parambllo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Blmi.a(this.jdField_a_of_type_Bllo.itemView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmq
 * JD-Core Version:    0.7.0.1
 */