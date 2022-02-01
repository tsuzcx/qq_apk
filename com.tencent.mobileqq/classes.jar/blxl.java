import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class blxl
  implements View.OnClickListener
{
  blxl(blxk paramblxk, blxb paramblxb, int paramInt, blxq paramblxq) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Blxb.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Blxb.a()) {
        break label80;
      }
      bool = true;
      if (!bool) {
        break label85;
      }
      blxk.a(this.jdField_a_of_type_Blxk).add(Integer.valueOf(this.jdField_a_of_type_Int));
      blxk.a(this.jdField_a_of_type_Blxk, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blxb.a(bool);
      this.jdField_a_of_type_Blxq.a(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      bool = false;
      break;
      label85:
      blxk.a(this.jdField_a_of_type_Blxk).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (blxk.a(this.jdField_a_of_type_Blxk).size() < 1) {
        blxk.a(this.jdField_a_of_type_Blxk, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxl
 * JD-Core Version:    0.7.0.1
 */