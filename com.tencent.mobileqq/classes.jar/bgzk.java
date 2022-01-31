import android.view.View;
import android.view.View.OnClickListener;

class bgzk
  implements View.OnClickListener
{
  bgzk(bgzj parambgzj, bgzm parambgzm) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bgzm.getLayoutPosition();
    bgzj.a(this.jdField_a_of_type_Bgzj).a(this.jdField_a_of_type_Bgzm.itemView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgzk
 * JD-Core Version:    0.7.0.1
 */