import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blmo
  implements View.OnClickListener
{
  blmo(blmi paramblmi, int paramInt, bllo parambllo) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Blmi.b()) {
      blmi.a(this.jdField_a_of_type_Blmi, this.jdField_a_of_type_Int, this.jdField_a_of_type_Bllo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmo
 * JD-Core Version:    0.7.0.1
 */