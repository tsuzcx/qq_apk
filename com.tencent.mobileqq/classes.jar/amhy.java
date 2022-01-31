import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

class amhy
  implements View.OnClickListener
{
  amhw jdField_a_of_type_Amhw;
  amia jdField_a_of_type_Amia;
  
  amhy(amhw paramamhw, amia paramamia)
  {
    this.jdField_a_of_type_Amhw = paramamhw;
    this.jdField_a_of_type_Amia = paramamia;
  }
  
  public void onClick(View paramView)
  {
    amgn.a(paramView.getContext(), (ColorNote)amhw.a(this.jdField_a_of_type_Amhw).get(this.jdField_a_of_type_Amia.getAdapterPosition()));
    if (amhw.a(this.jdField_a_of_type_Amhw) != null) {
      amhw.a(this.jdField_a_of_type_Amhw).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhy
 * JD-Core Version:    0.7.0.1
 */