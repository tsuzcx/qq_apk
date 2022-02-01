import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avhd
  implements View.OnClickListener
{
  avhd(avhc paramavhc, String paramString) {}
  
  public void onClick(View paramView)
  {
    avhc.a(this.jdField_a_of_type_Avhc).a(this.jdField_a_of_type_JavaLangString);
    bcef.b(null, "CliOper", "", "", "0X800A770", "0X800A770", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhd
 * JD-Core Version:    0.7.0.1
 */