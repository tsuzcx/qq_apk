import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqpi
  implements View.OnClickListener
{
  aqpg jdField_a_of_type_Aqpg;
  aqpk jdField_a_of_type_Aqpk;
  
  aqpi(aqpg paramaqpg, aqpk paramaqpk)
  {
    this.jdField_a_of_type_Aqpg = paramaqpg;
    this.jdField_a_of_type_Aqpk = paramaqpk;
  }
  
  public void onClick(View paramView)
  {
    aqnr.a(paramView.getContext(), (ColorNote)aqpg.a(this.jdField_a_of_type_Aqpg).get(this.jdField_a_of_type_Aqpk.getAdapterPosition()));
    if (aqpg.a(this.jdField_a_of_type_Aqpg) != null) {
      aqpg.a(this.jdField_a_of_type_Aqpg).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpi
 * JD-Core Version:    0.7.0.1
 */