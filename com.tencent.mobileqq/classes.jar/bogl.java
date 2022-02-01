import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bogl
  implements View.OnClickListener
{
  bogl(bogk parambogk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int >= 1)
    {
      String str = (String)bogk.a(this.jdField_a_of_type_Bogk).get(this.jdField_a_of_type_Int - 1);
      if (bogk.a(this.jdField_a_of_type_Bogk) != null) {
        bogk.a(this.jdField_a_of_type_Bogk).a(str);
      }
      bogk.a(this.jdField_a_of_type_Bogk, str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bogk.notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bogk.a(this.jdField_a_of_type_Bogk) != null) {
        bogk.a(this.jdField_a_of_type_Bogk).a();
      }
      bogk.a(this.jdField_a_of_type_Bogk, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogl
 * JD-Core Version:    0.7.0.1
 */