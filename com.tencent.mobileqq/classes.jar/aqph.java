import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqph
  implements View.OnClickListener
{
  aqpg jdField_a_of_type_Aqpg;
  aqpk jdField_a_of_type_Aqpk;
  
  aqph(aqpg paramaqpg, aqpk paramaqpk)
  {
    this.jdField_a_of_type_Aqpg = paramaqpg;
    this.jdField_a_of_type_Aqpk = paramaqpk;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Aqpk.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)aqpg.a(this.jdField_a_of_type_Aqpg).get(i);
    aqnv.b(localColorNote.mServiceType, localColorNote.mSubType);
    aqpg.a(this.jdField_a_of_type_Aqpg).remove(i);
    this.jdField_a_of_type_Aqpg.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (aqoq.b(localColorNote))
      {
        if ((aqop.a().a()) && (aqny.b())) {
          aqpg.a(this.jdField_a_of_type_Aqpg).a(paramView);
        }
        bdla.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", aqnq.b(aqoq.a(localColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aqpg.getItemCount() == 0) && (aqpg.a(this.jdField_a_of_type_Aqpg) != null)) {
        aqpg.a(this.jdField_a_of_type_Aqpg).b();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      bdla.b(null, "dc00898", "", "", "0X800A747", "0X800A747", aqnq.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqph
 * JD-Core Version:    0.7.0.1
 */