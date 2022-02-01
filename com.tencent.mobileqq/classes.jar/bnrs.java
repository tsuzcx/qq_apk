import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class bnrs
  implements View.OnClickListener
{
  bnrs(bnrr parambnrr, bnri parambnri, int paramInt, bnrx parambnrx) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bnri.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bnri.a()) {
        break label80;
      }
      bool = true;
      if (!bool) {
        break label85;
      }
      bnrr.a(this.jdField_a_of_type_Bnrr).add(Integer.valueOf(this.jdField_a_of_type_Int));
      bnrr.a(this.jdField_a_of_type_Bnrr, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnri.a(bool);
      this.jdField_a_of_type_Bnrx.a(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      bool = false;
      break;
      label85:
      bnrr.a(this.jdField_a_of_type_Bnrr).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (bnrr.a(this.jdField_a_of_type_Bnrr).size() < 1) {
        bnrr.a(this.jdField_a_of_type_Bnrr, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrs
 * JD-Core Version:    0.7.0.1
 */