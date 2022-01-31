import android.view.View;
import android.view.View.OnClickListener;
import java.util.Set;

class bitk
  implements View.OnClickListener
{
  bitk(bitj parambitj, bita parambita, int paramInt, bitp parambitp) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bita.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bita.a()) {
        break label73;
      }
      bool = true;
      if (!bool) {
        break label78;
      }
      bitj.a(this.jdField_a_of_type_Bitj).add(Integer.valueOf(this.jdField_a_of_type_Int));
      bitj.a(this.jdField_a_of_type_Bitj, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bita.a(bool);
      this.jdField_a_of_type_Bitp.a(bool);
      return;
      label73:
      bool = false;
      break;
      label78:
      bitj.a(this.jdField_a_of_type_Bitj).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (bitj.a(this.jdField_a_of_type_Bitj).size() < 1) {
        bitj.a(this.jdField_a_of_type_Bitj, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitk
 * JD-Core Version:    0.7.0.1
 */