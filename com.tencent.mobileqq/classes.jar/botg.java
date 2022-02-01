import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class botg
  implements View.OnClickListener
{
  botg(botf parambotf, bosw parambosw, int paramInt, botl parambotl) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bosw.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bosw.a()) {
        break label80;
      }
      bool = true;
      if (!bool) {
        break label85;
      }
      botf.a(this.jdField_a_of_type_Botf).add(Integer.valueOf(this.jdField_a_of_type_Int));
      botf.a(this.jdField_a_of_type_Botf, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bosw.a(bool);
      this.jdField_a_of_type_Botl.a(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      bool = false;
      break;
      label85:
      botf.a(this.jdField_a_of_type_Botf).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (botf.a(this.jdField_a_of_type_Botf).size() < 1) {
        botf.a(this.jdField_a_of_type_Botf, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botg
 * JD-Core Version:    0.7.0.1
 */