import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atrz
  implements View.OnClickListener
{
  atrz(atrw paramatrw) {}
  
  public void onClick(View paramView)
  {
    atrw.a(this.a, true);
    this.a.jdField_a_of_type_Atsz.f(true);
    this.a.jdField_a_of_type_Atsz.d(false);
    atrw.a(this.a);
    this.a.jdField_a_of_type_Atoo.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrz
 * JD-Core Version:    0.7.0.1
 */