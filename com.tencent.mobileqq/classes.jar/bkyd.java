import android.view.View;
import android.view.View.OnClickListener;
import java.util.Set;

class bkyd
  implements View.OnClickListener
{
  bkyd(bkyc parambkyc, bkxt parambkxt, int paramInt, bkyi parambkyi) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bkxt.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bkxt.a()) {
        break label73;
      }
      bool = true;
      if (!bool) {
        break label78;
      }
      bkyc.a(this.jdField_a_of_type_Bkyc).add(Integer.valueOf(this.jdField_a_of_type_Int));
      bkyc.a(this.jdField_a_of_type_Bkyc, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkxt.a(bool);
      this.jdField_a_of_type_Bkyi.a(bool);
      return;
      label73:
      bool = false;
      break;
      label78:
      bkyc.a(this.jdField_a_of_type_Bkyc).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (bkyc.a(this.jdField_a_of_type_Bkyc).size() < 1) {
        bkyc.a(this.jdField_a_of_type_Bkyc, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyd
 * JD-Core Version:    0.7.0.1
 */