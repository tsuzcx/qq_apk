import android.view.View;
import android.view.View.OnClickListener;
import java.util.Set;

class blck
  implements View.OnClickListener
{
  blck(blcj paramblcj, blca paramblca, int paramInt, blcp paramblcp) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Blca.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Blca.a()) {
        break label73;
      }
      bool = true;
      if (!bool) {
        break label78;
      }
      blcj.a(this.jdField_a_of_type_Blcj).add(Integer.valueOf(this.jdField_a_of_type_Int));
      blcj.a(this.jdField_a_of_type_Blcj, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blca.a(bool);
      this.jdField_a_of_type_Blcp.a(bool);
      return;
      label73:
      bool = false;
      break;
      label78:
      blcj.a(this.jdField_a_of_type_Blcj).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (blcj.a(this.jdField_a_of_type_Blcj).size() < 1) {
        blcj.a(this.jdField_a_of_type_Blcj, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blck
 * JD-Core Version:    0.7.0.1
 */