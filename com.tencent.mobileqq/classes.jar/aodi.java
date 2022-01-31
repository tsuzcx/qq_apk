import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

class aodi
  implements View.OnClickListener
{
  aodg jdField_a_of_type_Aodg;
  aodk jdField_a_of_type_Aodk;
  
  aodi(aodg paramaodg, aodk paramaodk)
  {
    this.jdField_a_of_type_Aodg = paramaodg;
    this.jdField_a_of_type_Aodk = paramaodk;
  }
  
  public void onClick(View paramView)
  {
    aobw.a(paramView.getContext(), (ColorNote)aodg.a(this.jdField_a_of_type_Aodg).get(this.jdField_a_of_type_Aodk.getAdapterPosition()));
    if (aodg.a(this.jdField_a_of_type_Aodg) != null) {
      aodg.a(this.jdField_a_of_type_Aodg).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodi
 * JD-Core Version:    0.7.0.1
 */