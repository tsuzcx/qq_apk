import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

class anyz
  implements View.OnClickListener
{
  anyx jdField_a_of_type_Anyx;
  anzb jdField_a_of_type_Anzb;
  
  anyz(anyx paramanyx, anzb paramanzb)
  {
    this.jdField_a_of_type_Anyx = paramanyx;
    this.jdField_a_of_type_Anzb = paramanzb;
  }
  
  public void onClick(View paramView)
  {
    anxn.a(paramView.getContext(), (ColorNote)anyx.a(this.jdField_a_of_type_Anyx).get(this.jdField_a_of_type_Anzb.getAdapterPosition()));
    if (anyx.a(this.jdField_a_of_type_Anyx) != null) {
      anyx.a(this.jdField_a_of_type_Anyx).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyz
 * JD-Core Version:    0.7.0.1
 */