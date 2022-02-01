import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class bngu
  implements View.OnClickListener
{
  bngu(bngt parambngt, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bngt.a(this.jdField_a_of_type_Bngt, (bngw)this.jdField_a_of_type_Bngt.a.get(this.jdField_a_of_type_Int));
    String str = "";
    if (bngt.a(this.jdField_a_of_type_Bngt) != null) {
      str = bngt.a(this.jdField_a_of_type_Bngt).a;
    }
    if (bngt.a(this.jdField_a_of_type_Bngt) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bngt.a(this.jdField_a_of_type_Bngt).a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngu
 * JD-Core Version:    0.7.0.1
 */