import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atre
  implements View.OnClickListener
{
  atre(atrc paramatrc, bcfj parambcfj) {}
  
  public void onClick(View paramView)
  {
    atrb localatrb = (atrb)this.jdField_a_of_type_Bcfj;
    localatrb.a(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131366755);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localatrb.b());
    }
    if (atrc.a(this.jdField_a_of_type_Atrc) != null) {
      atrc.a(this.jdField_a_of_type_Atrc).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atre
 * JD-Core Version:    0.7.0.1
 */