import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awtx
  implements View.OnClickListener
{
  awtx(awtw paramawtw, String paramString) {}
  
  public void onClick(View paramView)
  {
    awtw.a(this.jdField_a_of_type_Awtw).a(this.jdField_a_of_type_JavaLangString);
    bdll.b(null, "CliOper", "", "", "0X800A770", "0X800A770", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtx
 * JD-Core Version:    0.7.0.1
 */