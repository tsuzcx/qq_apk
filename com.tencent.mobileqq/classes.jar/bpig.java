import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bpig
  implements View.OnClickListener
{
  bpig(bpif parambpif, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int >= 1)
    {
      String str = (String)bpif.a(this.jdField_a_of_type_Bpif).get(this.jdField_a_of_type_Int - 1);
      if (bpif.a(this.jdField_a_of_type_Bpif) != null) {
        bpif.a(this.jdField_a_of_type_Bpif).a(str);
      }
      bpif.a(this.jdField_a_of_type_Bpif, str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpif.notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bpif.a(this.jdField_a_of_type_Bpif) != null) {
        bpif.a(this.jdField_a_of_type_Bpif).a();
      }
      bpif.a(this.jdField_a_of_type_Bpif, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpig
 * JD-Core Version:    0.7.0.1
 */