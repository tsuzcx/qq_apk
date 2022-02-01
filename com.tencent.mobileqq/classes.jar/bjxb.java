import android.view.View;
import android.view.View.OnLongClickListener;

class bjxb
  implements View.OnLongClickListener
{
  bjxb(bjwz parambjwz, bjwy parambjwy) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bjwy.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bjwz.a.a(this.jdField_a_of_type_Bjwy.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxb
 * JD-Core Version:    0.7.0.1
 */