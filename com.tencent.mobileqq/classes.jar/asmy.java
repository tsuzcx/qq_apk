import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asmy
  implements View.OnClickListener
{
  asmy(asmw paramasmw, bayt parambayt) {}
  
  public void onClick(View paramView)
  {
    asmv localasmv = (asmv)this.jdField_a_of_type_Bayt;
    localasmv.a(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131366644);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localasmv.b());
    }
    if (asmw.a(this.jdField_a_of_type_Asmw) != null) {
      asmw.a(this.jdField_a_of_type_Asmw).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmy
 * JD-Core Version:    0.7.0.1
 */