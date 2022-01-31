import android.view.View;
import android.view.View.OnClickListener;

class bktb
  implements View.OnClickListener
{
  bktb(bkta parambkta, bktd parambktd) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bktd.getLayoutPosition();
    bkta.a(this.jdField_a_of_type_Bkta).a(this.jdField_a_of_type_Bktd.itemView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktb
 * JD-Core Version:    0.7.0.1
 */