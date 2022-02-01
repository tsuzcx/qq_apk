import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class apmd
  implements View.OnClickListener
{
  apmc jdField_a_of_type_Apmc;
  apmg jdField_a_of_type_Apmg;
  
  apmd(apmc paramapmc, apmg paramapmg)
  {
    this.jdField_a_of_type_Apmc = paramapmc;
    this.jdField_a_of_type_Apmg = paramapmg;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Apmg.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)apmc.a(this.jdField_a_of_type_Apmc).get(i);
    apkr.b(localColorNote.mServiceType, localColorNote.mSubType);
    apmc.a(this.jdField_a_of_type_Apmc).remove(i);
    this.jdField_a_of_type_Apmc.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (aplm.b(localColorNote))
      {
        if ((apll.a().a()) && (apku.b())) {
          apmc.a(this.jdField_a_of_type_Apmc).a(paramView);
        }
        bcef.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", apkm.b(aplm.a(localColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Apmc.getItemCount() == 0) && (apmc.a(this.jdField_a_of_type_Apmc) != null)) {
        apmc.a(this.jdField_a_of_type_Apmc).b();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      bcef.b(null, "dc00898", "", "", "0X800A747", "0X800A747", apkm.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmd
 * JD-Core Version:    0.7.0.1
 */