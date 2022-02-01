import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqds
  implements View.OnClickListener
{
  aqdq jdField_a_of_type_Aqdq;
  aqdu jdField_a_of_type_Aqdu;
  
  aqds(aqdq paramaqdq, aqdu paramaqdu)
  {
    this.jdField_a_of_type_Aqdq = paramaqdq;
    this.jdField_a_of_type_Aqdu = paramaqdu;
  }
  
  public void onClick(View paramView)
  {
    aqcb.a(paramView.getContext(), (ColorNote)aqdq.a(this.jdField_a_of_type_Aqdq).get(this.jdField_a_of_type_Aqdu.getAdapterPosition()));
    if (aqdq.a(this.jdField_a_of_type_Aqdq) != null) {
      aqdq.a(this.jdField_a_of_type_Aqdq).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqds
 * JD-Core Version:    0.7.0.1
 */