import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

class amhz
  implements View.OnClickListener
{
  amhx jdField_a_of_type_Amhx;
  amib jdField_a_of_type_Amib;
  
  amhz(amhx paramamhx, amib paramamib)
  {
    this.jdField_a_of_type_Amhx = paramamhx;
    this.jdField_a_of_type_Amib = paramamib;
  }
  
  public void onClick(View paramView)
  {
    amgo.a(paramView.getContext(), (ColorNote)amhx.a(this.jdField_a_of_type_Amhx).get(this.jdField_a_of_type_Amib.getAdapterPosition()));
    if (amhx.a(this.jdField_a_of_type_Amhx) != null) {
      amhx.a(this.jdField_a_of_type_Amhx).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhz
 * JD-Core Version:    0.7.0.1
 */