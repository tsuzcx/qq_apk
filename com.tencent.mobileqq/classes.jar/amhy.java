import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.List;

class amhy
  implements View.OnClickListener
{
  amhx jdField_a_of_type_Amhx;
  amib jdField_a_of_type_Amib;
  
  amhy(amhx paramamhx, amib paramamib)
  {
    this.jdField_a_of_type_Amhx = paramamhx;
    this.jdField_a_of_type_Amib = paramamib;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Amib.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)amhx.a(this.jdField_a_of_type_Amhx).get(i);
    amgs.b(localColorNote.mServiceType, localColorNote.mSubType);
    amhx.a(this.jdField_a_of_type_Amhx).remove(i);
    this.jdField_a_of_type_Amhx.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (amhi.b(localColorNote))
      {
        if ((amhh.a().a()) && (amgu.b())) {
          amhx.a(this.jdField_a_of_type_Amhx).a(paramView);
        }
        axqw.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", 0, 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Amhx.getItemCount() == 0) && (amhx.a(this.jdField_a_of_type_Amhx) != null)) {
        amhx.a(this.jdField_a_of_type_Amhx).a();
      }
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      axqw.b(null, "dc00898", "", "", "0X800A747", "0X800A747", amgn.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhy
 * JD-Core Version:    0.7.0.1
 */