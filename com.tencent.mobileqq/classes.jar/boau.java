import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class boau
  implements View.OnClickListener
{
  boau(boat paramboat, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int >= 1)
    {
      String str = (String)boat.a(this.jdField_a_of_type_Boat).get(this.jdField_a_of_type_Int - 1);
      if (boat.a(this.jdField_a_of_type_Boat) != null) {
        boat.a(this.jdField_a_of_type_Boat).a(str);
      }
      boat.a(this.jdField_a_of_type_Boat, str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boat.notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (boat.a(this.jdField_a_of_type_Boat) != null) {
        boat.a(this.jdField_a_of_type_Boat).a();
      }
      boat.a(this.jdField_a_of_type_Boat, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boau
 * JD-Core Version:    0.7.0.1
 */