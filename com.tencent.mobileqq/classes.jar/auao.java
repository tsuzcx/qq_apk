import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auao
  implements View.OnClickListener
{
  auao(auam paramauam, bcfr parambcfr) {}
  
  public void onClick(View paramView)
  {
    aual localaual = (aual)this.jdField_a_of_type_Bcfr;
    localaual.a(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131366617);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localaual.b());
    }
    if (auam.a(this.jdField_a_of_type_Auam) != null) {
      auam.a(this.jdField_a_of_type_Auam).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auao
 * JD-Core Version:    0.7.0.1
 */