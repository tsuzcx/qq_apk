import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class bnmv
  implements View.OnClickListener
{
  bnmv(bnmu parambnmu, bnml parambnml, int paramInt, bnna parambnna) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bnml.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bnml.a()) {
        break label80;
      }
      bool = true;
      if (!bool) {
        break label85;
      }
      bnmu.a(this.jdField_a_of_type_Bnmu).add(Integer.valueOf(this.jdField_a_of_type_Int));
      bnmu.a(this.jdField_a_of_type_Bnmu, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnml.a(bool);
      this.jdField_a_of_type_Bnna.a(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      bool = false;
      break;
      label85:
      bnmu.a(this.jdField_a_of_type_Bnmu).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (bnmu.a(this.jdField_a_of_type_Bnmu).size() < 1) {
        bnmu.a(this.jdField_a_of_type_Bnmu, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmv
 * JD-Core Version:    0.7.0.1
 */