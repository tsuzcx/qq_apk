import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atiu
  implements View.OnClickListener
{
  atiu(atis paramatis, bbmy parambbmy) {}
  
  public void onClick(View paramView)
  {
    atir localatir = (atir)this.jdField_a_of_type_Bbmy;
    localatir.a(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131366568);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localatir.b());
    }
    if (atis.a(this.jdField_a_of_type_Atis) != null) {
      atis.a(this.jdField_a_of_type_Atis).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atiu
 * JD-Core Version:    0.7.0.1
 */