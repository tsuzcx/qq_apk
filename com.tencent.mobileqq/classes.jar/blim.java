import android.view.View;
import android.view.View.OnLongClickListener;

class blim
  implements View.OnLongClickListener
{
  blim(blik paramblik, blij paramblij) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Blij.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Blik.a.a(this.jdField_a_of_type_Blij.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blim
 * JD-Core Version:    0.7.0.1
 */