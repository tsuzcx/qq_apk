import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bmlc
  implements View.OnClickListener
{
  bmlc(bmlb parambmlb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int >= 1)
    {
      String str = (String)bmlb.a(this.jdField_a_of_type_Bmlb).get(this.jdField_a_of_type_Int - 1);
      if (bmlb.a(this.jdField_a_of_type_Bmlb) != null) {
        bmlb.a(this.jdField_a_of_type_Bmlb).a(str);
      }
      bmlb.a(this.jdField_a_of_type_Bmlb, str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmlb.notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bmlb.a(this.jdField_a_of_type_Bmlb) != null) {
        bmlb.a(this.jdField_a_of_type_Bmlb).a();
      }
      bmlb.a(this.jdField_a_of_type_Bmlb, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlc
 * JD-Core Version:    0.7.0.1
 */