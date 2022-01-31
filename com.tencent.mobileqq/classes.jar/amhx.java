import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.List;

class amhx
  implements View.OnClickListener
{
  amhw jdField_a_of_type_Amhw;
  amia jdField_a_of_type_Amia;
  
  amhx(amhw paramamhw, amia paramamia)
  {
    this.jdField_a_of_type_Amhw = paramamhw;
    this.jdField_a_of_type_Amia = paramamia;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Amia.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)amhw.a(this.jdField_a_of_type_Amhw).get(i);
    amgr.b(localColorNote.mServiceType, localColorNote.mSubType);
    amhw.a(this.jdField_a_of_type_Amhw).remove(i);
    this.jdField_a_of_type_Amhw.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (amhh.b(localColorNote))
      {
        if ((amhg.a().a()) && (amgt.b())) {
          amhw.a(this.jdField_a_of_type_Amhw).a(paramView);
        }
        axqy.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", 0, 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Amhw.getItemCount() == 0) && (amhw.a(this.jdField_a_of_type_Amhw) != null)) {
        amhw.a(this.jdField_a_of_type_Amhw).a();
      }
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      axqy.b(null, "dc00898", "", "", "0X800A747", "0X800A747", amgm.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhx
 * JD-Core Version:    0.7.0.1
 */