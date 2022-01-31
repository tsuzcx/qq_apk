import android.view.View;
import android.view.View.OnClickListener;
import java.util.Set;

class bist
  implements View.OnClickListener
{
  bist(biss parambiss, bisj parambisj, int paramInt, bisy parambisy) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bisj.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bisj.a()) {
        break label73;
      }
      bool = true;
      if (!bool) {
        break label78;
      }
      biss.a(this.jdField_a_of_type_Biss).add(Integer.valueOf(this.jdField_a_of_type_Int));
      biss.a(this.jdField_a_of_type_Biss, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bisj.a(bool);
      this.jdField_a_of_type_Bisy.a(bool);
      return;
      label73:
      bool = false;
      break;
      label78:
      biss.a(this.jdField_a_of_type_Biss).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (biss.a(this.jdField_a_of_type_Biss).size() < 1) {
        biss.a(this.jdField_a_of_type_Biss, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bist
 * JD-Core Version:    0.7.0.1
 */