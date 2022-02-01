import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blta
  implements View.OnClickListener
{
  blta(blsz paramblsz, blsy paramblsy) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Blsy.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Blsz.a.a(this.jdField_a_of_type_Blsy.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blta
 * JD-Core Version:    0.7.0.1
 */