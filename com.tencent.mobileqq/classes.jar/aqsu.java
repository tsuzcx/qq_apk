import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqsu
  implements View.OnClickListener
{
  aqst jdField_a_of_type_Aqst;
  aqsx jdField_a_of_type_Aqsx;
  
  aqsu(aqst paramaqst, aqsx paramaqsx)
  {
    this.jdField_a_of_type_Aqst = paramaqst;
    this.jdField_a_of_type_Aqsx = paramaqsx;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Aqsx.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)aqst.a(this.jdField_a_of_type_Aqst).get(i);
    aqri.b(localColorNote.mServiceType, localColorNote.mSubType);
    aqst.a(this.jdField_a_of_type_Aqst).remove(i);
    this.jdField_a_of_type_Aqst.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (aqsd.b(localColorNote))
      {
        if ((aqsc.a().a()) && (aqrl.b())) {
          aqst.a(this.jdField_a_of_type_Aqst).a(paramView);
        }
        bdll.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", aqrd.b(aqsd.a(localColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aqst.getItemCount() == 0) && (aqst.a(this.jdField_a_of_type_Aqst) != null)) {
        aqst.a(this.jdField_a_of_type_Aqst).b();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      bdll.b(null, "dc00898", "", "", "0X800A747", "0X800A747", aqrd.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsu
 * JD-Core Version:    0.7.0.1
 */