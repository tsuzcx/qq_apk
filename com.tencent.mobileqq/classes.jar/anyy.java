import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.List;

class anyy
  implements View.OnClickListener
{
  anyx jdField_a_of_type_Anyx;
  anzb jdField_a_of_type_Anzb;
  
  anyy(anyx paramanyx, anzb paramanzb)
  {
    this.jdField_a_of_type_Anyx = paramanyx;
    this.jdField_a_of_type_Anzb = paramanzb;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Anzb.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)anyx.a(this.jdField_a_of_type_Anyx).get(i);
    anxr.b(localColorNote.mServiceType, localColorNote.mSubType);
    anyx.a(this.jdField_a_of_type_Anyx).remove(i);
    this.jdField_a_of_type_Anyx.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (anyi.b(localColorNote))
      {
        if ((anyh.a().a()) && (anxu.b())) {
          anyx.a(this.jdField_a_of_type_Anyx).a(paramView);
        }
        azmj.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", anxm.b(anyi.a(localColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Anyx.getItemCount() == 0) && (anyx.a(this.jdField_a_of_type_Anyx) != null)) {
        anyx.a(this.jdField_a_of_type_Anyx).a();
      }
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      azmj.b(null, "dc00898", "", "", "0X800A747", "0X800A747", anxm.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyy
 * JD-Core Version:    0.7.0.1
 */