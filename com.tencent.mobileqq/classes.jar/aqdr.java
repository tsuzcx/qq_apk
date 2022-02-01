import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqdr
  implements View.OnClickListener
{
  aqdq jdField_a_of_type_Aqdq;
  aqdu jdField_a_of_type_Aqdu;
  
  aqdr(aqdq paramaqdq, aqdu paramaqdu)
  {
    this.jdField_a_of_type_Aqdq = paramaqdq;
    this.jdField_a_of_type_Aqdu = paramaqdu;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Aqdu.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)aqdq.a(this.jdField_a_of_type_Aqdq).get(i);
    aqcf.b(localColorNote.mServiceType, localColorNote.mSubType);
    aqdq.a(this.jdField_a_of_type_Aqdq).remove(i);
    this.jdField_a_of_type_Aqdq.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (aqda.b(localColorNote))
      {
        if ((aqcz.a().a()) && (aqci.b())) {
          aqdq.a(this.jdField_a_of_type_Aqdq).a(paramView);
        }
        bcst.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", aqca.b(aqda.a(localColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aqdq.getItemCount() == 0) && (aqdq.a(this.jdField_a_of_type_Aqdq) != null)) {
        aqdq.a(this.jdField_a_of_type_Aqdq).b();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      bcst.b(null, "dc00898", "", "", "0X800A747", "0X800A747", aqca.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdr
 * JD-Core Version:    0.7.0.1
 */