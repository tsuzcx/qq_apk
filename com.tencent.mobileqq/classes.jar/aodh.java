import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.List;

class aodh
  implements View.OnClickListener
{
  aodg jdField_a_of_type_Aodg;
  aodk jdField_a_of_type_Aodk;
  
  aodh(aodg paramaodg, aodk paramaodk)
  {
    this.jdField_a_of_type_Aodg = paramaodg;
    this.jdField_a_of_type_Aodk = paramaodk;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Aodk.getAdapterPosition();
    ColorNote localColorNote = (ColorNote)aodg.a(this.jdField_a_of_type_Aodg).get(i);
    aoca.b(localColorNote.mServiceType, localColorNote.mSubType);
    aodg.a(this.jdField_a_of_type_Aodg).remove(i);
    this.jdField_a_of_type_Aodg.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      if (aocr.b(localColorNote))
      {
        if ((aocq.a().a()) && (aocd.b())) {
          aodg.a(this.jdField_a_of_type_Aodg).a(paramView);
        }
        azqs.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", aobv.b(aocr.a(localColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aodg.getItemCount() == 0) && (aodg.a(this.jdField_a_of_type_Aodg) != null)) {
        aodg.a(this.jdField_a_of_type_Aodg).a();
      }
      return;
      QQPlayerService.c(paramView.getContext());
      break;
      azqs.b(null, "dc00898", "", "", "0X800A747", "0X800A747", aobv.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodh
 * JD-Core Version:    0.7.0.1
 */