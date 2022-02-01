import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class apme
  implements View.OnClickListener
{
  apmc jdField_a_of_type_Apmc;
  apmg jdField_a_of_type_Apmg;
  
  apme(apmc paramapmc, apmg paramapmg)
  {
    this.jdField_a_of_type_Apmc = paramapmc;
    this.jdField_a_of_type_Apmg = paramapmg;
  }
  
  public void onClick(View paramView)
  {
    apkn.a(paramView.getContext(), (ColorNote)apmc.a(this.jdField_a_of_type_Apmc).get(this.jdField_a_of_type_Apmg.getAdapterPosition()));
    if (apmc.a(this.jdField_a_of_type_Apmc) != null) {
      apmc.a(this.jdField_a_of_type_Apmc).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apme
 * JD-Core Version:    0.7.0.1
 */